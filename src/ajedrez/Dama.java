package ajedrez;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Dama extends Ficha{

    public Dama(String equipo,String imagenFicha){
        super(equipo,"dama",new ImageIcon(imagenFicha));
    }
    @Override
    public void mover(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {
        CoordenadaFicha c = CoordenadaFicha.localizarPosicion(m,this);
        int contFila = 1;
        int contColumna = 1;
        //Mover hacia arriba
        //Agregar la posicion de la Dama
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

        contFila = 1;
        contColumna = 1;
        //Determinar limite vertical positivo por izquierda
        while(c.getFila() - contFila >= 0 && c.getColumna() - contColumna >= 0 ){
            //Determinar si hay una ficha en la posicion dada
            if(m[c.getFila() - contFila][c.getColumna() - contColumna].getFicha() == null){

                //Agregar la casilla al rango de movimientos
                //Primero guardar el color antiguo
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna() - contColumna].getBackground());
                //Cambiarle el color al verde
                m[c.getFila() - contFila][c.getColumna() - contColumna].setBackground(Color.green);
                //Agregar casilla al rango de movimientos
                movimientos.add(m[c.getFila() - contFila][c.getColumna() - contColumna]);
                contFila++;
                contColumna++;

            }else if(!m[c.getFila() - contFila][c.getColumna() - contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())){
                //Esta parte es para marcar la ficha si es enemiga
                //Si resulta ser diferente entonces mapear el color
                //primero obtener el color antiguo del panel
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna() - contColumna].getBackground());
                //luego cambiarle el color al rojo
                m[c.getFila() - contFila][c.getColumna() - contColumna].setBackground(Color.red);
                //finalmente agregarlo a la coleccion de movimientos
                movimientos.add(m[c.getFila() - contFila][c.getColumna() - contColumna]);

                break;
            }else{
                break;
            }
        }

        //Reinciar contadores
        contFila = 1;
        contColumna = 1;

        //Determinar limite vertical positivo por derecha
        while(c.getFila() - contFila >= 0   && c.getColumna() + contColumna <= m.length - 1){
            //Determinar si hay una ficha en la posicion dada
            if(m[c.getFila() - contFila][c.getColumna() + contColumna].getFicha() == null){

                //Agregar la casilla al rango de movimientos
                //Primero guardar el color antiguo
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna() + contColumna].getBackground());
                //Cambiarle el color al verde
                m[c.getFila() - contFila][c.getColumna() + contColumna].setBackground(Color.green);
                //Agregar casilla al rango de movimientos
                movimientos.add(m[c.getFila() - contFila][c.getColumna() + contColumna]);
                contFila++;
                contColumna++;

            }else if(!m[c.getFila() - contFila][c.getColumna() + contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())){
                //Esta parte es para marcar la ficha si es enemiga
                //Si resulta ser diferente entonces mapear el color
                //primero obtener el color antiguo del panel
                coloresAntiguos.add(m[c.getFila() - contFila][c.getColumna() + contColumna].getBackground());
                //luego cambiarle el color al rojo
                m[c.getFila() - contFila][c.getColumna() + contColumna].setBackground(Color.red);
                //finalmente agregarlo a la coleccion de movimientos
                movimientos.add(m[c.getFila() - contFila][c.getColumna() + contColumna]);

                break;
            }else{
                break;
            }
        }
        //Reinciar contadores
        contFila = 1;
        contColumna = 1;
        //Determinar limite vertical negativo por izquierda

        while(c.getFila() + contFila <= m.length - 1 && c.getColumna() - contColumna >= 0){
            //Determinar si hay una ficha en la posicion dada
            if(m[c.getFila() + contFila][c.getColumna() - contColumna].getFicha() == null){

                //Agregar la casilla al rango de movimientos
                //Primero guardar el color antiguo
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna() - contColumna].getBackground());
                //Cambiarle el color al verde
                m[c.getFila() + contFila][c.getColumna() - contColumna].setBackground(Color.green);
                //Agregar casilla al rango de movimientos
                movimientos.add(m[c.getFila() + contFila][c.getColumna() - contColumna]);
                contFila++;
                contColumna++;

            }else if(!m[c.getFila() + contFila][c.getColumna() - contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())){
                //Esta parte es para marcar la ficha si es enemiga
                //Si resulta ser diferente entonces mapear el color
                //primero obtener el color antiguo del panel
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna() - contColumna].getBackground());
                //luego cambiarle el color al rojo
                m[c.getFila() + contFila][c.getColumna() - contColumna].setBackground(Color.red);
                //finalmente agregarlo a la coleccion de movimientos
                movimientos.add(m[c.getFila() + contFila][c.getColumna() - contColumna]);

                break;
            }else{
                break;
            }
        }

        //Reinciar contadores
        contFila = 1;
        contColumna = 1;
        //Determinar limite vertical negativo por derecha

        while(c.getFila() + contFila <= m.length - 1 && c.getColumna() + contColumna <= m.length - 1){
            //Determinar si hay una ficha en la posicion dada

            if(m[c.getFila() + contFila][c.getColumna() + contColumna].getFicha() == null){

                //Agregar la casilla al rango de movimientos
                //Primero guardar el color antiguo
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna() + contColumna].getBackground());
                //Cambiarle el color al verde
                m[c.getFila() + contFila][c.getColumna() + contColumna].setBackground(Color.green);
                //Agregar casilla al rango de movimientos
                movimientos.add(m[c.getFila() + contFila][c.getColumna() + contColumna]);
                contFila++;
                contColumna++;

            }else if(!m[c.getFila() + contFila][c.getColumna() + contColumna].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())){
                //Esta parte es para marcar la ficha si es enemiga
                //Si resulta ser diferente entonces mapear el color
                //primero obtener el color antiguo del panel
                coloresAntiguos.add(m[c.getFila() + contFila][c.getColumna() + contColumna].getBackground());
                //luego cambiarle el color al rojo
                m[c.getFila() + contFila][c.getColumna() + contColumna].setBackground(Color.red);
                //finalmente agregarlo a la coleccion de movimientos
                movimientos.add(m[c.getFila() + contFila][c.getColumna() + contColumna]);

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
