package ajedrez;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Torre extends Ficha{

    public Torre(String equipo,  String imagenFicha){
        super(equipo,"torre",new ImageIcon(imagenFicha));
    }
    @Override
    public void mover(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {
        CoordenadaFicha c = CoordenadaFicha.localizarPosicion(m,this);
        int contFila = 1;
        int contColumna = 1;
        //Mover hacia arriba
        //Agregar la posicion de la torre
        movimientos.add(m[c.getFila()][c.getColumna()]);

        while (c.getFila() - contFila >= 0){
            //Verificar si la casilla no contiene fichas
            if(m[c.getFila() - contFila][c.getColumna()].getFicha() == null ){
                //Si no tiene ficha mapear la casilla como verde para moverse
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna()].getBackground());
                m[c.getFila() - contFila][c.getColumna()].setBackground(Color.green);
                movimientos.add(m[c.getFila() - contFila][c.getColumna()]);
                contFila ++;

            } else if (!m[c.getFila() - contFila][c.getColumna()].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                //Si es del equipo contrario mapear la casilla como roja
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna()].getBackground());
                m[c.getFila() - contFila][c.getColumna()].setBackground(Color.red);
                movimientos.add(m[c.getFila() - contFila][c.getColumna()]);
                break;
            }else{
                break;
            }
        }
        //reiniciar contador
        contFila = 1;

        //Mover hacia abajo;
        while (c.getFila() + contFila <= m.length - 1){
            //Verificar si la casilla no contiene fichas
            if(m[c.getFila() + contFila][c.getColumna()].getFicha() == null ){
                //Si no tiene ficha mapear la casilla como verde para moverse
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna()].getBackground());
                m[c.getFila() + contFila][c.getColumna()].setBackground(Color.green);
                movimientos.add(m[c.getFila() + contFila][c.getColumna()]);
                contFila ++;

            } else if (!m[c.getFila() + contFila][c.getColumna()].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                //Si es del equipo contrario mapear la casilla como roja
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna()].getBackground());
                m[c.getFila() + contFila][c.getColumna()].setBackground(Color.red);
                movimientos.add(m[c.getFila() + contFila][c.getColumna()]);
                break;
            }else{
                break;
            }
        }

        //mover hacia la izquierda

        while (c.getColumna()- contColumna >= 0){
            //Verificar si la casilla no contiene fichas
            if(m[c.getFila()][c.getColumna() - contColumna].getFicha() == null ){
                //Si no tiene ficha mapear la casilla como verde para moverse
                coloresAntiguos.add(m[c.getFila()][c.getColumna()- contColumna].getBackground());
                m[c.getFila()][c.getColumna() - contColumna].setBackground(Color.green);
                movimientos.add(m[c.getFila()][c.getColumna() - contColumna]);
                contColumna++;

            } else if (!m[c.getFila()][c.getColumna() - contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                //Si es del equipo contrario mapear la casilla como roja
                coloresAntiguos.add(m[c.getFila()][c.getColumna() - contColumna].getBackground());
                m[c.getFila()][c.getColumna() - contColumna].setBackground(Color.red);
                movimientos.add(m[c.getFila()][c.getColumna() - contColumna]);
                break;
            }else{
                break;
            }
        }

        //reiniciar contador
        contColumna = 1;
        while (c.getColumna() + contColumna <= m.length - 1){
            //Verificar si la casilla no contiene fichas
            if(m[c.getFila()][c.getColumna() + contColumna].getFicha() == null ){
                //Si no tiene ficha mapear la casilla como verde para moverse
                coloresAntiguos.add(m[c.getFila()][c.getColumna() + contColumna].getBackground());
                m[c.getFila()][c.getColumna() + contColumna].setBackground(Color.green);
                movimientos.add(m[c.getFila()][c.getColumna() + contColumna]);
                contColumna++;

            } else if (!m[c.getFila()][c.getColumna() + contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                //Si es del equipo contrario mapear la casilla como roja
                coloresAntiguos.add(m[c.getFila()][c.getColumna() + contColumna].getBackground());
                m[c.getFila()][c.getColumna() + contColumna].setBackground(Color.red);
                movimientos.add(m[c.getFila()][c.getColumna() + contColumna]);
                break;
            }else{
                break;
            }
        }


    }

    @Override
    public void matar(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {

    }
}
