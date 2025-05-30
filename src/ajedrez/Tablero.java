/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ajedrez;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;

/**
 *
 * @author elmen
 */



public class Tablero extends javax.swing.JFrame implements  MouseListener  {

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
    private boolean isTurnoBlanco = true;
    private Color marron = new Color(139,69,19);
    private Color  blanco = Color.WHITE;
    public Tablero() {
        initComponents();
        System.out.println(this.getSize().height + " " + this.getSize().width);
        
        this.setSize(new Dimension(900,580));
        
        panelBase.setBackground(marron);
        this.setTitle("Tablero de ajedrez");
        crearTablero();
        this.setLocationRelativeTo(null);
        this.agregarEventosCasillas();
        this.agregarFichas();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        System.out.println(panelTablero.getSize().getWidth() + " " + panelTablero.getSize().getHeight());
      
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
        fichasBlancas.add(matrizCasillas[0][4].getFicha());
        
        String quedan = "CHESS REMAINING" + " " +fichasNegras.size();
        this.quedanNegras.setText(quedan);
        quedan = "CHESS REMAINING" + " "+fichasBlancas.size();
        this.quedanBlancas.setText(quedan);

    }
    
    private boolean turnoBlanco = true;
    private boolean turnoNegro = false;
    
    
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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

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


                if(isTurnoBlanco && panel.getFicha().getEquipo().equalsIgnoreCase(equipoBlanco)){

                    panel.getFicha().mover(matrizCasillas,this.movimientos, this.coloresAntiguos);

                }else if(!isTurnoBlanco && panel.getFicha().getEquipo().equalsIgnoreCase(equipoNegro)){

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

    private void removerFicha(ArrayList<Ficha> fichas, Ficha f){
        int indice = 0;

        for(Ficha i: fichas){

            if(i.equals(f)){

                break;
            }
            indice++;
        }

        if(f.getEquipo().equalsIgnoreCase("blanco") && f.getTipo().equalsIgnoreCase("rey")){
            JOptionPane.showMessageDialog(this,"EL JUGADOR NEGRO HA GANADO");
        }else if(f.getTipo().equalsIgnoreCase("rey")){
            JOptionPane.showMessageDialog(this,"El JUGADOR BLANCO HA GANADO");
        }

        fichas.remove(indice);
        
        String quedan = "CHESS REMAINING" + " " +fichasNegras.size();
        this.quedanNegras.setText(quedan);
        quedan = "CHESS REMAINING" + " "+fichasBlancas.size();
        this.quedanBlancas.setText(quedan);
        

    }

    public void eliminarFicha(PanelCasilla panel){
        //Cambiar turno
        if(isTurnoBlanco){
            isTurnoBlanco = false;
            removerFicha(fichasNegras,panel.getFicha());
        }else{

            isTurnoBlanco = true;
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
        if(isTurnoBlanco){
            isTurnoBlanco = false;

        }else{

            isTurnoBlanco = true;
        }
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
