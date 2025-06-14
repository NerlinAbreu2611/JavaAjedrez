package Igu;

import Conexion.ControladorTablero;
import Modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ganador extends JFrame {


    private Color marron = new Color(139,69,19);
    private Font fuente = new Font("Monospaced", Font.BOLD, 14);

    public Ganador(String imagen, String vencedor, JFrame menu, Partida partida, Tablero tablero){
        Image icono = new ImageIcon(getClass().getResource("/imagenes/caballero (1).png")).getImage();
        setIconImage(icono);
        setSize(300,400);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        add(panel);
        panel.setBackground(marron);
        setTitle("Ganador");
        establecerComponentes(panel,imagen,vencedor);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                menu.setVisible(true);
                finalizarPartida();
                dispose();
            }

            private void finalizarPartida(){
                if(partida != null){
                    if(ControladorTablero.existeLaPartida(partida)){
                        if(ControladorTablero.borrarPartida(partida)){
                        }
                    }
                }

                tablero.setVisible(false);
                tablero.dispose();
            }
        });

    }

    private void establecerComponentes(JPanel panel, String imagen, String vencedor){

        JLabel label = new JLabel();
        label.setText("FELICITACIONES!");
        label.setForeground(Color.black);
        label.setFont(fuente);
        label.setBounds(50,10,50,40);
        panel.add(label);

        JPanel contenedor = new JPanel();
        int ancho = 220;
        int alto = 250;
        Image image = new ImageIcon(getClass().getResource(imagen)).getImage();
        Image imagenEscalada = image.getScaledInstance(ancho - 5, alto - 5, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);
        JLabel labelImagen = new JLabel();
        JPanel panel2 = new JPanel();
        labelImagen.setIcon(icono);

        labelImagen.setBounds(10,90,240,280);
        labelImagen.setBackground(Color.WHITE);
        panel2.add(labelImagen);
        panel2.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel.add(panel2);

        JLabel mensaje2 = new JLabel();
        mensaje2.setText("<html>HAS GANADO LA PARTIDA<br>&nbsp;&nbsp;&nbsp;JUGADOR "+vencedor+"</html>");
        mensaje2.setFont(fuente);
        mensaje2.setForeground(Color.black);
        panel.add(mensaje2);

    }

}
