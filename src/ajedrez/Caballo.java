package ajedrez;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Caballo extends Ficha{

    public Caballo(String equipo, String imagenFicha){
        super(equipo,"caballo",new ImageIcon(imagenFicha));
    }

    @Override
    public void mover(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {
        //Localizar posicion de la ficha
        CoordenadaFicha coordenada = CoordenadaFicha.localizarPosicion(m,this);
        //Agregar a la coleccion de movimientos
        movimientos.add(m[coordenada.getFila()][coordenada.getColumna()]);
        //Movimiento de L  arriba
        if(coordenada.getFila() - 2 >= 0){
            if(coordenada.getColumna() - 1 >= 0 && m[coordenada.getFila() - 2][coordenada.getColumna() - 1].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna() - 1].getBackground());
                m[coordenada.getFila() - 2][coordenada.getColumna() - 1].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna() - 1]);
            } else if (coordenada.getColumna() - 1 >= 0 && !m[coordenada.getFila() - 2][coordenada.getColumna() - 1].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna() - 1].getBackground());
                m[coordenada.getFila() - 2][coordenada.getColumna() - 1].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna() - 1]);
            }

            if(coordenada.getColumna() + 1 <= m.length - 1 && m[coordenada.getFila() - 2][coordenada.getColumna() + 1].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna() + 1].getBackground());
                m[coordenada.getFila() - 2][coordenada.getColumna() + 1].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna() + 1]);
            } else if (coordenada.getColumna() + 1 <= m.length - 1 && !m[coordenada.getFila() - 2][coordenada.getColumna() + 1].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna() + 1].getBackground());
                m[coordenada.getFila() - 2][coordenada.getColumna() + 1].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna() + 1]);
            }

        }

        //Movimiento de L  abajo
        if(coordenada.getFila() + 2 <= m.length - 1){
            if(coordenada.getColumna() - 1 >= 0 && m[coordenada.getFila() + 2][coordenada.getColumna() - 1].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() + 2][coordenada.getColumna() - 1].getBackground());
                m[coordenada.getFila() + 2][coordenada.getColumna() - 1].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() + 2][coordenada.getColumna() - 1]);
            } else if (coordenada.getColumna() - 1 >= 0 && !m[coordenada.getFila() + 2][coordenada.getColumna() - 1].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() + 2][coordenada.getColumna() - 1].getBackground());
                m[coordenada.getFila() + 2][coordenada.getColumna() - 1].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() + 2][coordenada.getColumna() - 1]);
            }

            if(coordenada.getColumna() + 1 <= m.length - 1 && m[coordenada.getFila() + 2][coordenada.getColumna() + 1].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() + 2][coordenada.getColumna() + 1].getBackground());
                m[coordenada.getFila() + 2][coordenada.getColumna() + 1].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() + 2][coordenada.getColumna() + 1]);
            } else if (coordenada.getColumna() + 1 <= m.length - 1 && !m[coordenada.getFila() + 2][coordenada.getColumna() + 1].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() + 2][coordenada.getColumna() + 1].getBackground());
                m[coordenada.getFila() + 2][coordenada.getColumna() + 1].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() + 2][coordenada.getColumna() + 1]);
            }

        }

        //Movimiento de L a la izquierda

        if(coordenada.getColumna() - 2 >= 0){

            if(coordenada.getFila() - 1 >= 0 && m[coordenada.getFila() - 1][coordenada.getColumna() - 2].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna() - 2].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna() - 2].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna() - 2]);
            } else if (coordenada.getFila() - 1 >= 0 && !m[coordenada.getFila() - 1][coordenada.getColumna() - 2].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna() - 2].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna() - 2].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna() - 2]);
            }

            if(coordenada.getFila() + 1 <= m.length - 1 && m[coordenada.getFila() + 1][coordenada.getColumna() - 2].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna() - 2].getBackground());
                m[coordenada.getFila() + 1][coordenada.getColumna() - 2].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna() - 2]);
            } else if (coordenada.getFila() + 1 <= m.length - 1 && !m[coordenada.getFila() + 1][coordenada.getColumna() - 2].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna() - 2].getBackground());
                m[coordenada.getFila() + 1][coordenada.getColumna() - 2].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna() - 2]);
            }

        }

        //movimiento de l a la derecha

        if(coordenada.getColumna() + 2 <= m.length - 1){

            if(coordenada.getFila() - 1 >= 0 && m[coordenada.getFila() - 1][coordenada.getColumna() + 2].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna() + 2].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna() + 2].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna() + 2]);
            } else if (coordenada.getFila() - 1 >= 0 && !m[coordenada.getFila() - 1][coordenada.getColumna() + 2].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna() + 2].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna() + 2].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna() + 2]);
            }

            if(coordenada.getFila() + 1 <= m.length - 1 && m[coordenada.getFila() + 1][coordenada.getColumna() + 2].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna() + 2].getBackground());
                m[coordenada.getFila() + 1][coordenada.getColumna() + 2].setBackground(Color.green);
                movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna() + 2]);
            } else if (coordenada.getFila() + 1 <= m.length - 1 && !m[coordenada.getFila() + 1][coordenada.getColumna() + 2].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna() + 2].getBackground());
                m[coordenada.getFila() + 1][coordenada.getColumna() + 2].setBackground(Color.red);
                movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna() + 2]);
            }

        }


    }

    @Override
    public void matar(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {

    }
}
