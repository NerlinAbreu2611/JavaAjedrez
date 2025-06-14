/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Igu;
import Conexion.ControladorTablero;
import Igu.Ganador;
import Modelo.FichaModelo;
import Modelo.Partida;
import ajedrez.*;

import javax.sound.sampled.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author elmen
 */



public class Tablero extends javax.swing.JFrame implements  MouseListener {

    /**
     * Creates new form Tablero
     */
    
    private JPanel jugadorNegro;
    private JPanel jugadorBlanco;
    private Font fuente = new Font("Monospaced", Font.BOLD, 13);
    
    private ArrayList<PanelCasilla> movimientos = new ArrayList<>();
    private ArrayList<Color> coloresAntiguos = new ArrayList<>();

    private JLabel quedanNegras;
    private JLabel quedanBlancas;


    private Color marron = new Color(139,69,19);
    private Color  blanco = Color.WHITE;
    public Tablero() {
        initComponents();

        
        this.setSize(new Dimension(900,580));
        
        panelBase.setBackground(marron);
        this.setTitle("Tablero de ajedrez");
        this.setResizable(false);
        crearTablero();
        this.setLocationRelativeTo(null);


    }

    private JFrame menu;

    private void accionarCierreDeVentana(JFrame menu){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {


                int opcion = JOptionPane.showConfirmDialog(
                        null,
                        "¿Deseas guardar partida?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION
                );



                if(opcion == JOptionPane.YES_NO_OPTION) {

                    if(partida != null){
                        if(ControladorTablero.existeLaPartida(partida)){
                            Timestamp fecha = partida.getFecha();
                            if(ControladorTablero.borrarPartida(partida)){
                                ControladorTablero con = new ControladorTablero();
                                con.guardar(fichasBlancas, fichasNegras, matrizCasillas,turnoBlanco,fecha);
                            }
                        }
                    }else{
                        ControladorTablero con = new ControladorTablero();
                        Timestamp ahora = new Timestamp(System.currentTimeMillis());
                        con.guardar(fichasBlancas, fichasNegras, matrizCasillas,turnoBlanco,ahora);
                    }
                }
                    setVisible(false);
                    dispose();
                    menu.setVisible(true);

            }
        });
    }

    private Partida partida;
    public Tablero(JFrame menu){
        this();
        this.agregarFichas();
        this.menu = menu;
        this.setVisible(true);
        accionarCierreDeVentana(menu);
        this.agregarEventosCasillas();
    }

    public Tablero(JFrame menu, List<FichaModelo> fichasModelo, Partida turno){
        this();
        this.agregarFichasConModelo(fichasModelo);
        this.menu = menu;
        turnoBlanco = turno.isTurnoBlanco();
        partida = turno;
        this.setVisible(true);
        accionarCierreDeVentana(menu);
        this.agregarEventosCasillas();
    }
    
    public void agregarFichasConModelo(List<FichaModelo> fichasModelo){
        
        fichasModelo.forEach(f->{
            
            if(f.getNombre().equalsIgnoreCase("peon")){

                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Peon fi = new Peon(f.getEquipo(),peonBlancoImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);
                    if(f.getX() < 6){
                        fi.setInicio(true);
                    }
                }else {
                    Peon fi = new Peon(f.getEquipo(),peonNegroImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);
                    if(f.getX() > 1){
                        fi.setInicio(true);
                    }

                }

            } else if (f.getNombre().equalsIgnoreCase("caballo")) {

                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Ficha fi = new Caballo(f.getEquipo(),caballoBlancoImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);

                }else {
                    Ficha fi = new Caballo(f.getEquipo(),caballoNegroImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);

                }
                
            } else if (f.getNombre().equalsIgnoreCase("rey")) {

                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Ficha fi = new Rey(f.getEquipo(),reyBlancoImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);

                }else {
                    Ficha fi = new Rey(f.getEquipo(),reyNegroImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);
                }

            } else if (f.getNombre().equalsIgnoreCase("arfil")) {

                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Ficha fi = new Arfil(f.getEquipo(),arfilBlancoImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);

                }else {
                    Ficha fi = new Arfil(f.getEquipo(),arfilNegroImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);

                }
                
            } else if (f.getNombre().equalsIgnoreCase("dama")) {

                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Ficha fi = new Dama(f.getEquipo(),damaBlancaImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);

                }else {
                    Ficha fi = new Dama(f.getEquipo(),damaNegraImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);

                }
                
            } else if (f.getNombre().equalsIgnoreCase("torre")) {
                if(f.getEquipo().equalsIgnoreCase("blanco")){
                    Ficha fi = new Torre(f.getEquipo(),torreBlancaImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasBlancas.add(fi);

                }else {
                    Ficha fi = new Torre(f.getEquipo(),torreNegraImagen);
                    matrizCasillas[f.getX()][f.getY()].setFicha(fi);
                    fichasNegras.add(fi);

                }
            }

        });

        String quedan = "CHESS REMAINING" + " " +fichasNegras.size();
        this.quedanNegras.setText(quedan);
        quedan = "CHESS REMAINING" + " "+fichasBlancas.size();
        this.quedanBlancas.setText(quedan);
    }
    
    private  PanelCasilla [][] matrizCasillas = new PanelCasilla[8][8];
    private ArrayList<Ficha> fichasNegras = new ArrayList<>();
    private ArrayList<Ficha> fichasBlancas = new ArrayList<>();
    public void crearTablero(){
        panelBase.setLayout(null);
        
        panelTablero.setBounds(10, 10, panelBase.getWidth() - 20, panelBase.getHeight() - 20);
        panelTablero.setBackground(Color.black);
       // Border borde = BorderFactory.createLineBorder(Color.BLACK, 3); // Color y grosor
       // panelTablero.setBorder(borde);
        panelTablero.setLayout(new GridLayout(8,8));
        

      
        jugadorNegro = new JPanel();
        
        jugadorNegro.setBounds((int) (panelTablero.getSize().getWidth()+ 15), + 15, 150, 200);
             
        jugadorNegro.setBackground(blanco);
        jugadorNegro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        panelBase.add(jugadorNegro);
        
         jugadorBlanco = new JPanel();
        
        jugadorBlanco.setBounds((int) (panelTablero.getSize().getWidth()+ 15), 230, 150, 200);
             
        jugadorBlanco.setBackground(blanco);

        panelBase.add(jugadorBlanco);
        
        jugadorNegro.setLayout(null);
        JLabel label1 = new JLabel("  JUGADOR NEGRO ");
        label1.setFont(fuente);
        label1.setBounds(0, 0, 150, 30);
        label1.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        JLabel imagen1 = new JLabel();
        imagen1.setBounds(0,30,150,140);
        ImageIcon imagenFicha1 = new ImageIcon(caballoNegroImagen);
        Icon icono1 = new ImageIcon(imagenFicha1.getImage().getScaledInstance(imagen1.getWidth() - 5 , imagen1.getHeight() - 5, 1));
        imagen1.setIcon(icono1);
       // imagen1.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        
        quedanNegras = new JLabel();
        quedanNegras.setFont(fuente);
        quedanNegras.setBounds(0,170,150,30);
        quedanNegras.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        
        jugadorNegro.add(label1);
        jugadorNegro.add(imagen1);
        jugadorNegro.add(quedanNegras);
        
        jugadorBlanco.setLayout(null);
        JLabel label2 = new JLabel("  JUGADOR BLANCO ");
        label2.setFont(fuente);
        label2.setBounds(0, 0, 150, 30);
        label2.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        JLabel imagen2 = new JLabel();
        imagen2.setBounds(0,30,150,140);
        ImageIcon imagenFicha2 = new ImageIcon(caballoBlancoImagen);
        Icon icono2 = new ImageIcon(imagenFicha2.getImage().getScaledInstance(imagen2.getWidth() - 5 , imagen2.getHeight() - 5, 1));
        imagen2.setIcon(icono2);
      
        this.setIconImage(imagenFicha1.getImage());
        quedanBlancas= new JLabel("");
        quedanBlancas.setFont(fuente);
        quedanBlancas.setBounds(0,170,150,30);
        quedanBlancas.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        
        jugadorBlanco.add(label2);
        jugadorBlanco.add(imagen2);
        jugadorBlanco.add(quedanBlancas);

        jugadorBlanco.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        
        
        for(int i = 0;i<8;i++){
            for(int j=0;j<8;j++){
                PanelCasilla casilla = new PanelCasilla(panelTablero);
                casilla.setBorder(BorderFactory.createLineBorder(Color.black,1));
                if((i+j) % 2 == 0){
                    casilla.setBackground(marron);
                }else{
                    casilla.setBackground(blanco);
                }
                matrizCasillas[i][j] = casilla;
                panelTablero.add(casilla);
            }
        }
    }


   private String damaNegraImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\reina (1).png";
    private String damaBlancaImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\reina.png";
   private String peonNegroImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\peon (1).png";
   private String peonBlancoImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\peon.png";

   private String arfilNegroImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\arfil(1).png";
   private String arfilBlancoImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\arfil.png";

   private String torreNegraImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\torre (1).png";

   private String caballoBlancoImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\caballero.png";

   private String caballoNegroImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\caballero (1).png";

   private String torreBlancaImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\torre.png";

   private String reyBlancoImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\rey.png";
   private String reyNegroImagen = "C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\imagenes\\rey (1).png";
   private String equipoBlanco = "blanco";
   private String equipoNegro = "negro";

   public void mapearFichas(){
       System.out.println("Fichas negras:");
       fichasNegras.forEach(f ->{

           CoordenadaFicha coordenadaFicha = CoordenadaFicha.localizarPosicion(matrizCasillas, f);
           System.out.println(f.getTipo() + " encontrada en la posicion " + coordenadaFicha.getFila() + "," + coordenadaFicha.getColumna());


       });

       System.out.println("Fichas blancas");

       fichasBlancas.forEach(f ->{

           CoordenadaFicha coordenadaFicha = CoordenadaFicha.localizarPosicion(matrizCasillas, f);
           System.out.println(f.getTipo() + " encontrada en la posicion " + coordenadaFicha.getFila() + "," + coordenadaFicha.getColumna());


       });

   }
    private void agregarFichas(){
        //Agregar peones
        for (int i = 0; i < matrizCasillas.length; i++) {
            for (int j = 0; j < matrizCasillas.length; j++) {
                if(i == 1){
                    matrizCasillas[i][j].setFicha(new Peon(equipoNegro,peonNegroImagen));
                    fichasNegras.add(matrizCasillas[i][j].getFicha());

                } else if (i == 6) {
                    matrizCasillas[i][j].setFicha(new Peon(equipoBlanco,peonBlancoImagen));
                    fichasBlancas.add(matrizCasillas[i][j].getFicha());
                }
            }
        }

        //Agregar torres negras
        matrizCasillas[0][0].setFicha(new Torre(equipoNegro,torreNegraImagen));
        fichasNegras.add(matrizCasillas[0][0].getFicha());
        matrizCasillas[0][7].setFicha(new Torre(equipoNegro,torreNegraImagen));
        fichasNegras.add(matrizCasillas[0][7].getFicha());

        //Agregar torres blancas
        matrizCasillas[7][7].setFicha(new Torre(equipoBlanco,torreBlancaImagen));
        fichasBlancas.add(matrizCasillas[7][7].getFicha());
        matrizCasillas[7][0].setFicha(new Torre(equipoBlanco,torreBlancaImagen));
        fichasBlancas.add(matrizCasillas[7][0].getFicha());

        //Agregar caballos negros
        matrizCasillas[0][1].setFicha(new Caballo(equipoNegro,caballoNegroImagen));
        fichasNegras.add(matrizCasillas[0][1].getFicha());
        matrizCasillas[0][6].setFicha(new Caballo(equipoNegro,caballoNegroImagen));
        fichasNegras.add(matrizCasillas[0][6].getFicha());

        //Agregar caballos blancos
        matrizCasillas[7][1].setFicha(new Caballo(equipoBlanco,caballoBlancoImagen));
        fichasBlancas.add(matrizCasillas[7][1].getFicha());
        matrizCasillas[7][6].setFicha(new Caballo(equipoBlanco,caballoBlancoImagen));
        fichasBlancas.add(matrizCasillas[7][6].getFicha());

        //Agregar arfiles negros
        matrizCasillas[0][2].setFicha(new Arfil(equipoNegro,arfilNegroImagen));
        fichasNegras.add(matrizCasillas[0][2].getFicha());
        matrizCasillas[0][5].setFicha(new Arfil(equipoNegro,arfilNegroImagen));
        fichasNegras.add(matrizCasillas[0][5].getFicha());

        //agregar arfiles blancos
        matrizCasillas[7][2].setFicha(new Arfil(equipoBlanco,arfilBlancoImagen));
        fichasBlancas.add(matrizCasillas[7][2].getFicha());
        matrizCasillas[7][5].setFicha(new Arfil(equipoBlanco,arfilBlancoImagen));
        fichasBlancas.add(matrizCasillas[7][5].getFicha());

        //agregar rey negro
        matrizCasillas[0][3].setFicha(new Rey(equipoNegro,reyNegroImagen));
        fichasNegras.add(matrizCasillas[0][3].getFicha());

        //agregar rey blanco
        matrizCasillas[7][3].setFicha(new Rey(equipoBlanco,reyBlancoImagen));
        fichasBlancas.add(matrizCasillas[7][3].getFicha());

        //agregar reyna negra
        matrizCasillas[0][4].setFicha(new Dama(equipoNegro,damaNegraImagen));
        fichasNegras.add(matrizCasillas[0][4].getFicha());

        //agregar reyna blanca
        matrizCasillas[7][4].setFicha(new Dama(equipoBlanco,damaBlancaImagen));
        fichasBlancas.add(matrizCasillas[7][4].getFicha());
        
        String quedan = "CHESS REMAINING" + " " +fichasNegras.size();
        this.quedanNegras.setText(quedan);
        quedan = "CHESS REMAINING" + " "+fichasBlancas.size();
        this.quedanBlancas.setText(quedan);

    }
    
    private boolean turnoBlanco = true;

    
    
    public void agregarEventosCasillas(){
        for (int i = 0; i < matrizCasillas.length; i++) {
            for (int j = 0; j < matrizCasillas.length; j++) {  
                matrizCasillas[i][j].addMouseListener(this);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBase = new javax.swing.JPanel();
        panelTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBase.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelTableroLayout = new javax.swing.GroupLayout(panelTablero);
        panelTablero.setLayout(panelTableroLayout);
        panelTableroLayout.setHorizontalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );
        panelTableroLayout.setVerticalGroup(
            panelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBaseLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelTablero;
    // End of variables declaration//GEN-END:variables
    
    private Color verde = Color.GREEN;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        PanelCasilla panel = (PanelCasilla) e.getSource();
      //  System.out.println(panel.getFicha().getTipo());
      
      if(panel.getFicha() != null || panel.getBackground().equals(verde) || panel.getBackground().equals(Color.red)){


          reproducirSonido("C:\\Users\\elmen\\Desktop\\Ajedrez\\JavaAjedrez\\src\\sonido\\351518__mh2o__chess_move_on_alabaster.wav");
                moverFichas(panel);

      }else{

         if(!movimientos.isEmpty()){
             limpiarMovimientos();
         }
      }

        
        
    }
    


    public void moverFichas(PanelCasilla panel){
        if(panel.getFicha() != null){
           
            

            if(movimientos.isEmpty()){


                if(turnoBlanco && panel.getFicha().getEquipo().equalsIgnoreCase(equipoBlanco)){

                    panel.getFicha().mover(matrizCasillas,this.movimientos, this.coloresAntiguos);

                }else if(!turnoBlanco && panel.getFicha().getEquipo().equalsIgnoreCase(equipoNegro)){

                    panel.getFicha().mover(matrizCasillas,this.movimientos, this.coloresAntiguos);

                }

                
            }else if(panel.getBackground().equals(Color.red)){
                if(movimientos.get(0).getFicha() != null && movimientos.get(0).getFicha().getTipo().equalsIgnoreCase("peon")){
                    Peon peon = (Peon) movimientos.get(0).getFicha();
                    peon.setInicio(true);
                }
                eliminarFicha(panel);
            }else{
                limpiarMovimientos();
            }

            
            
            
        }else{
            if(panel.getBackground().equals(verde)){
                if(movimientos.get(0).getFicha() != null && movimientos.get(0).getFicha().getTipo().equalsIgnoreCase("peon")){
                    Peon peon = (Peon) movimientos.get(0).getFicha();
                    peon.setInicio(true);
                }

                trasladarFicha(panel);
            }
          
        }
    }

    public static void reproducirSonido(String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream original = AudioSystem.getAudioInputStream(archivo);

            // Convertir a formato compatible
            AudioFormat formatoCompatible = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    44100,
                    16,
                    original.getFormat().getChannels(),
                    original.getFormat().getChannels() * 2,
                    44100,
                    false
            );

            AudioInputStream audioCompatible = AudioSystem.getAudioInputStream(formatoCompatible, original);

            Clip clip = AudioSystem.getClip();
            clip.open(audioCompatible);
            clip.start();

            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void removerFicha(ArrayList<Ficha> fichas, Ficha f){
        int indice = 0;

        for(Ficha i: fichas){

            if(i.equals(f)){

                break;
            }
            indice++;
        }

        if(f.getEquipo().equalsIgnoreCase("blanco") && f.getTipo().equalsIgnoreCase("rey")){
            Ganador g = new Ganador("/imagenes/caballero (1).png","NEGRO",menu,partida,this);
        }else if(f.getTipo().equalsIgnoreCase("rey")){
            Ganador g = new Ganador("/imagenes/caballero.png","BLANCO",menu,partida,this);
        }

        fichas.remove(indice);
        
        String quedan = "CHESS REMAINING" + " " +fichasNegras.size();
        this.quedanNegras.setText(quedan);
        quedan = "CHESS REMAINING" + " "+fichasBlancas.size();
        this.quedanBlancas.setText(quedan);

        

    }

    private void finalizarPartida(){
        if(ControladorTablero.existeLaPartida(partida)){
            if(ControladorTablero.borrarPartida(partida)){
            }
        }

        setVisible(false);
        menu.setVisible(true);
        dispose();
    }

    public void eliminarFicha(PanelCasilla panel){
        //Cambiar turno

        if(turnoBlanco){
            turnoBlanco = false;
            removerFicha(fichasNegras,panel.getFicha());
        }else{

            turnoBlanco = true;
            removerFicha(fichasBlancas,panel.getFicha());
        }
        //Eliminar la ficha en el panel


        panel.eliminarFicha();
        //Poner la ficha que elimino a la otra en el panel de color rojo
        panel.setFicha(movimientos.get(0).getFicha());
        //Eliminar la ficha de la posicion de movimientos
        movimientos.get(0).eliminarFicha();
        //LLamar al metodo de limipieza
        limpiarMovimientos();
    }

    
    public void trasladarFicha(PanelCasilla panel){
        //Cambiar turno
        turnoBlanco = !turnoBlanco;
        Iterator<PanelCasilla> i = movimientos.iterator();
        PanelCasilla anterior = i.next();
        panel.setFicha(anterior.getFicha());
        anterior.eliminarFicha();
        
        int c = 0;

        for (PanelCasilla j : movimientos) {
            if (j.getBackground().equals(verde) || j.getBackground().equals(Color.red)) {
                j.setBackground(coloresAntiguos.get(c));
                c++;
            }

        }
        
        

        movimientos.clear();
        coloresAntiguos.clear();

        
    }

    
    public void limpiarMovimientos(){
         int c = 0;


                  
                    for(PanelCasilla j: movimientos){
                       if(j.getBackground().equals(verde) || j.getBackground().equals(Color.red)){
                        j.setBackground(coloresAntiguos.get(c));                        
                         c++;
                       }
                      
                     }
                  
                    movimientos.clear();
                    coloresAntiguos.clear();
            

    }
    
    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
      
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }


}
