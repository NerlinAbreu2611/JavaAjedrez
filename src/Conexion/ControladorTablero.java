package Conexion;

import Modelo.FichaModelo;
import Modelo.Partida;
import ajedrez.CoordenadaFicha;
import ajedrez.Ficha;
import ajedrez.PanelCasilla;
import ajedrez.Peon;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ControladorTablero {

    private HashMap<String,Integer> ficha;

    public ControladorTablero(){
        ficha = new HashMap<>();
        ficha.put("peon;negro", 1);
        ficha.put("rey;negro", 2);
        ficha.put("dama;negro", 3);
        ficha.put("caballo;negro", 4);
        ficha.put("torre;negro", 5);
        ficha.put("arfil;negro", 6);
        ficha.put("peon;blanco", 7);
        ficha.put("rey;blanco", 8);
        ficha.put("dama;blanco", 9);
        ficha.put("caballo;blanco", 10);
        ficha.put("torre;blanco", 11);
        ficha.put("arfil;blanco", 12);
    }

    /*public void recuperarFichas(ArrayList<Ficha> ){


    }*/

    public static boolean existeLaPartida(Partida partida){
        String sql = "select * from partida  where id_partida = ?";

        try(Connection conn = Conexion.getConnetion()){

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,partida.getId());
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }

        }catch (SQLException e){
            System.out.println("Ocurrio un error de tipo: " + e.getMessage());
        }

        return false;
    }

    public static List<FichaModelo> getFichas(Partida partida){

        List<FichaModelo> fichas = new ArrayList<>();
        String sql = "SELECT\n" +
                "    tablero.id_partida,\n" +
                "    ficha.nombre,\n" +
                "    ficha.equipo,\n" +
                "    tablero.coordenada_ficha_x as x,\n" +
                "    tablero.coordenada_ficha_y as y\n" +
                "FROM tablero\n" +
                "INNER JOIN ficha ON tablero.id_ficha = ficha.id\n" +
                "WHERE tablero.id_partida = ?";

        try(Connection conn = Conexion.getConnetion()){
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,partida.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                FichaModelo modelo = new FichaModelo(rs.getString("nombre"),
                        rs.getString("equipo"),
                        rs.getInt("x"),
                        rs.getInt("y")
                        );
               fichas.add(modelo);
            }

        }catch (SQLException e){
            System.out.println("Ocurrio un error de tipo " + e.getMessage());
        }

        return fichas;
    }

    public static boolean borrarPartida(Partida p){

        String sql = "delete from partida where id_partida = ?";

        try(Connection conn = Conexion.getConnetion()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,p.getId());

            int filasAfectas = ps.executeUpdate();

            if(filasAfectas > 0){
                return true;
            }


        }catch (SQLException e){
            System.out.println("Ocurrio un error de tipo: " + e.getMessage());
        }

        return false;
    }

    public static List<Partida> getPartidas(){
        String sql = "SELECT * FROM partida ORDER BY fecha_partida ASC";
        List<Partida> partidas = new ArrayList<>();
        try(Connection c = Conexion.getConnetion()){
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                partidas.add(new Partida(rs.getInt("id_partida"),rs.getTimestamp("fecha_partida"),rs.getBoolean("turno_blanco")));
            }

        }catch (SQLException e){

            System.out.println("Ocurrio un error de tipo: " + e.getMessage());
        }




     return partidas;
    }

    public void guardar(ArrayList<Ficha> fichasBlancas, ArrayList<Ficha> fichasNegras, PanelCasilla[][] casillas, boolean turnoBlanco,Timestamp fecha){
        Connection conn = Conexion.getConnetion();
        String sqlPartida = "insert into partida(fecha_partida,turno_blanco) values (?,?)";
        String sqlTablero = "insert into tablero(id_partida, id_ficha,coordenada_ficha_x, coordenada_ficha_y) values (?,?,?,?)";

        try {
            conn.setAutoCommit(false);

            // Insertar partida y obtener ID generado
            PreparedStatement psPartida = conn.prepareStatement(sqlPartida, Statement.RETURN_GENERATED_KEYS);
            psPartida.setTimestamp(1,fecha);
            psPartida.setBoolean(2,turnoBlanco);
            psPartida.executeUpdate();
            ResultSet rs = psPartida.getGeneratedKeys();
            int idPartida = 0;
            if (rs.next()) {
                idPartida = rs.getInt(1);
            }
            rs.close();
            psPartida.close();

            PreparedStatement psTablero = conn.prepareStatement(sqlTablero);

            // Insertar fichas negras
            for (Ficha f : fichasNegras) {
                String key = f.getTipo() + ";" + f.getEquipo();
                CoordenadaFicha coord = CoordenadaFicha.localizarPosicion(casillas, f);
                int fichaId = this.ficha.get(key);
                psTablero.setInt(1, idPartida);
                psTablero.setInt(2, fichaId);
                psTablero.setInt(3, coord.getFila());
                psTablero.setInt(4, coord.getColumna());
                psTablero.executeUpdate();
            }

            // Insertar fichas blancas
            for (Ficha f : fichasBlancas) {
                String key = f.getTipo() + ";" + f.getEquipo();
                CoordenadaFicha coord = CoordenadaFicha.localizarPosicion(casillas, f);
                int fichaId = this.ficha.get(key);
                psTablero.setInt(1, idPartida);
                psTablero.setInt(2, fichaId);
                psTablero.setInt(3, coord.getFila());
                psTablero.setInt(4, coord.getColumna());
                psTablero.executeUpdate();
            }

            psTablero.close();
            conn.commit();

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Transacción revertida.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void comprobarPartida(int id){

        Connection conn = Conexion.getConnetion();
        String sql = "select from tablero where id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,1);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
