package Igu;

import Conexion.ControladorTablero;
import Modelo.FichaModelo;
import Modelo.Partida;
import ajedrez.Tablero;

import java.util.HashMap;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Partidas extends JFrame {
    private Color marron = new Color(139,69,19);
    private Font fuente = new Font("Monospaced", Font.BOLD, 14);
    private JFrame menu;

    private JPanel panelPrincipal;
    public Partidas(JFrame menu){
        setSize(500,250);
        setLocationRelativeTo(null);
        this.menu = menu;
        setTitle("Elegir Partidas");
        menu.setVisible(false);
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);
        panelPrincipal.setBackground(marron);
        add(panelPrincipal);
        Image icono = new ImageIcon(getClass().getResource("/imagenes/caballero (1).png")).getImage();
        setIconImage(icono);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        cerrarVentana();
        inicializarComponentes();
        accionarBotones();

    }

    private JComboBox<String> comboBox;
    private JButton botonIniciar;

    private void accionarBotones(){

        botonIniciar.addActionListener(b ->{

            List<FichaModelo> fichas = ControladorTablero.getFichas(mapa.get(comboBox.getSelectedIndex() + 1));

            new Tablero(menu,fichas,mapa.get(comboBox.getSelectedIndex() + 1)).setVisible(true);
            this.setVisible(false);
            this.dispose();

        });

        botonEliminar.addActionListener(b ->{

            int indice = comboBox.getSelectedIndex();
            Partida p = mapa.get(indice + 1);
            if(ControladorTablero.existeLaPartida(p)){
                if(ControladorTablero.borrarPartida(p)){
                    mapa.remove(comboBox.getSelectedIndex() + 1);
                    ((DefaultComboBoxModel<String>) comboBox.getModel()).removeElementAt(indice);
                    if (comboBox.getItemCount() == 0) {
                        botonIniciar.setEnabled(false);
                        botonEliminar.setEnabled(false);
                    }

                }

            }

        });

    }
    private HashMap<Integer,Partida> mapa;


    private JButton botonEliminar;

    private void inicializarComponentes(){
        List<Partida> lista = ControladorTablero.getPartidas();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        mapa = new HashMap<>();

        int i = 1;
        for(var p: lista){
            mapa.put(i,p);
            modelo.addElement("Partida:" + i + ":Fecha:"+p.getFecha());
            i++;
        }


        comboBox = new JComboBox<>(modelo);
        comboBox.setBounds(55,50,370,30);
        comboBox.setFont(fuente);
        comboBox.setBackground(Color.white);
        comboBox.setForeground(Color.black);
        panelPrincipal.add(comboBox);

        JLabel titulo = new JLabel("PARTIDAS");
        titulo.setForeground(Color.black);
        titulo.setFont(fuente);
        titulo.setBounds(200,10,100,40);
        panelPrincipal.add(titulo);

        botonIniciar = new JButton("INICIAR PARTIDA");
        botonIniciar.setForeground(Color.black);
        botonIniciar.setBackground(Color.white);
        botonIniciar.setFont(fuente);
        botonIniciar.setBounds(55,90,370,50);
        panelPrincipal.add(botonIniciar);

        botonEliminar = new JButton("ELIMINAR PARTIDA");
        botonEliminar.setForeground(Color.black);
        botonEliminar.setBackground(Color.white);
        botonEliminar.setFont(fuente);
        botonEliminar.setBounds(55,150,370,50);

        panelPrincipal.add(botonEliminar);

        if(comboBox.getItemCount() == 0){
            botonIniciar.setEnabled(false);
            botonEliminar.setEnabled(false);
        }

    }
    private void cerrarVentana(){

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                dispose();
                menu.setVisible(true);

            }
        });

    }

}
