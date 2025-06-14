package Igu;

import ajedrez.Tablero;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Menu extends JFrame {
    public Menu(){
        setTitle("Inicio");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(600,400));
        setLocationRelativeTo(null);
        Image icono = new ImageIcon(getClass().getResource("/imagenes/caballero (1).png")).getImage();
        setIconImage(icono);
        setResizable(false);

        agregarPanel();


    }
    private Color marron = new Color(139,69,19);

    private void agregarPanel(){
        JPanel panelComponentes = new JPanel();
        panelComponentes.setLayout(null);
        this.add(panelComponentes);
        panelComponentes.setBackground(marron);
        panelComponentes.add(panelTarjeta());
        panelComponentes.add(panelOpciones());
        panelComponentes.add(derechosReservados());

    }
    private Font fuente = new Font("Monospaced", Font.BOLD, 14);

    private JLabel derechosReservados(){
        JLabel label = new JLabel();

        label.setText("© 2025 Nerlin Alexander Abreu Henriquez. Todos los derechos reservados");
        label.setFont(fuente);
        label.setForeground(Color.black);
        label.setBounds(220,315,350,40);

        return label;
    }
    private JPanel panelTarjeta(){
        JPanel panel = new JPanel();

        panel.setBackground(Color.white);
        panel.setBounds(5,5,200,340);
        panel.setLayout(null);

        JLabel etiqueta = new JLabel("       CHESS GAME ");
        etiqueta.setFont(fuente);
        etiqueta.setBounds(0,0,200,40);
        panel.setBorder(BorderFactory.createLineBorder(Color.black,2));
        etiqueta.setBorder(BorderFactory.createLineBorder(Color.black,2));
        panel.add(etiqueta);

        int ancho = 220;
        int alto = 250;

        Image image = new ImageIcon(getClass().getResource("/imagenes/caballero (1).png")).getImage();
        Image imagenEscalada = image.getScaledInstance(ancho - 5, alto - 5, Image.SCALE_SMOOTH);
        ImageIcon icono = new ImageIcon(imagenEscalada);

        JLabel imagen = new JLabel();
        imagen.setBounds(0, 50, ancho, alto);
        imagen.setIcon(icono);
        panel.add(imagen);

        return panel;
    }


    private void accionarBotones(){

        nuevaPartida.addActionListener(s ->{
            this.setVisible(false);
            Tablero tablero = new Tablero(this);
        });

        partida.addActionListener(s ->{
            Partidas partidas = new Partidas(this);
        });

        salir.addActionListener(s ->{
            System.exit(0);
        });



    }

    private JButton nuevaPartida;
    private JButton partida;
    private JButton salir;

    private JPanel panelOpciones(){

        JPanel panelOpciones = new JPanel();
        panelOpciones.setBounds(250,5,300,260);
        panelOpciones.setLayout(null);
        panelOpciones.setBackground(marron);
        //panelOpciones.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        nuevaPartida = new JButton("NUEVA PARTIDA");
        nuevaPartida.setFont(fuente);
        nuevaPartida.setBackground(Color.white);
        nuevaPartida.setForeground(Color.black);
        nuevaPartida.setBounds(15, 30, 270, 50);
        panelOpciones.add(nuevaPartida);

        partida = new JButton("PARTIDA");
        partida.setFont(fuente);
        partida.setBackground(Color.white);
        partida.setForeground(Color.black);
        partida.setBounds(15,110,270,50);
        panelOpciones.add(partida);

        salir = new JButton("SALIR");
        salir.setFont(fuente);
        salir.setBackground(Color.white);
        salir.setForeground(Color.black);
        salir.setBounds(15,190,270,50);
        panelOpciones.add(salir);

        // Crear un borde con línea y título
        TitledBorder borde = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black, 2), // Línea negra
                "MENU",                      // Título
                TitledBorder.CENTER, TitledBorder.TOP,            // Alineación del título
                new Font("Monospaced", Font.BOLD, 18),          // Fuente del título
                Color.black);                                     // Color del título

        panelOpciones.setBorder(borde);

        accionarBotones();

        return panelOpciones;
    }

    public static void main(String[] args) {
        Menu m = new Menu();

        m.setVisible(true);
    }
}
