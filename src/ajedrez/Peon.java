/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author elmen
 */
public class Peon extends Ficha{

    private boolean inicio = false;
    
    public Peon(String equipo, String tipo, ImageIcon imagenFicha) {
        super(equipo, tipo,  imagenFicha);
       
        
    }
    

    
    public Peon( String equipo, String ruta){
        
          super(equipo, "peon",  new ImageIcon(ruta));
    }
    
    
    private Color verde = Color.GREEN;

    public void setInicio(boolean inicio) {
        this.inicio = inicio;
    }
    
    @Override
    public void mover(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {
        CoordenadaFicha coordenada = CoordenadaFicha.localizarPosicion(m,this);
        movimientos.add(m[coordenada.getFila()][coordenada.getColumna()]);
        if(this.getEquipo().equals("negro")){
            moverNegra(m, movimientos, coloresAntiguos);
            matar(m, movimientos, coloresAntiguos);
        }else{
            moverBlanca(m, movimientos, coloresAntiguos);
            matar(m, movimientos, coloresAntiguos);
        }
       
    }

    @Override
    public void matar(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {

        //Verificar si mi ficha es negra o blanca
        if(this.getEquipo().equals("negro")){
            matarBlanca(m, movimientos, coloresAntiguos);

        }else{
            matarNegra(m, movimientos, coloresAntiguos);
        }

    }

    public void moverBlanca(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos){
        CoordenadaFicha coordenada = CoordenadaFicha.localizarPosicion(m, this);

        if(inicio == false && m[coordenada.getFila() + 1][coordenada.getColumna()].getFicha() == null && m[coordenada.getFila() + 2][coordenada.getColumna()].getFicha() == null){



            coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna()].getBackground());
            coloresAntiguos.add(m[coordenada.getFila() + 2][coordenada.getColumna()].getBackground());

            m[coordenada.getFila() + 1][coordenada.getColumna()].setBackground(verde);
            m[coordenada.getFila() + 2][coordenada.getColumna()].setBackground(verde);


            movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna()]);
            movimientos.add(m[coordenada.getFila() + 2][coordenada.getColumna()]);
        }else{
            if(coordenada.getFila() + 1 <= m.length - 1 && m[coordenada.getFila() + 1][coordenada.getColumna()].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() + 1][coordenada.getColumna()].getBackground());
                m[coordenada.getFila() + 1][coordenada.getColumna()].setBackground(verde);


                movimientos.add(m[coordenada.getFila() + 1][coordenada.getColumna()]);
            }
        }
    }

    public void moverNegra(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos){
        CoordenadaFicha coordenada = CoordenadaFicha.localizarPosicion(m, this);

        if(inicio == false && m[coordenada.getFila() - 1][coordenada.getColumna()].getFicha() == null && m[coordenada.getFila() - 2][coordenada.getColumna()].getFicha() == null){



            coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna()].getBackground());
            coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna()].getBackground());

            m[coordenada.getFila() - 1][coordenada.getColumna()].setBackground(verde);
            m[coordenada.getFila() - 2][coordenada.getColumna()].setBackground(verde);


            movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna()]);
            movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna()]);
        }else{
            if(coordenada.getFila() - 1 >= 0 && m[coordenada.getFila() - 1][coordenada.getColumna()].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna()].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna()].setBackground(verde);


                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna()]);
            }
        }
    }


    private void matarBlanca(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos){
        CoordenadaFicha coor = CoordenadaFicha.localizarPosicion(m,this);

        //Verificar limite por izquierda

        if(coor.getFila() - 1 >= 0 && coor.getColumna() - 1 >= 0){
            //Verificar si existe una ficha en la posicion dada
            if(m[coor.getFila() - 1][coor.getColumna() - 1].getFicha() != null){
                //Guardar el nombre de equipo
                String equipo = m[coor.getFila() - 1][coor.getColumna() - 1].getFicha().getEquipo();
                //Verificar si es de mi equipo o de un equipo enemigo
                if(!this.getEquipo().equalsIgnoreCase(equipo)){

                    //si no es de mi equipo marcar la casilla en rojo
                    //Obtener color de la casilla
                    coloresAntiguos.add(m[coor.getFila() - 1][coor.getColumna() - 1].getBackground());
                    //Cambiar color de la casilla al rojo
                    m[coor.getFila() - 1][coor.getColumna() - 1].setBackground(Color.red);
                    //Agregar a la lista de movimientos

                    movimientos.add(m[coor.getFila() - 1][coor.getColumna() - 1]);
                }


            }
        }

        //Verificar limite por derecha
        if(coor.getFila() - 1 >= 0 && coor.getColumna() + 1 <= m.length - 1){
            //Verificar si existe una ficha en la posicion dada
            if(m[coor.getFila() - 1][coor.getColumna() + 1].getFicha() != null){
                //Guardar el nombre de equipo
                String equipo = m[coor.getFila() - 1][coor.getColumna() + 1].getFicha().getEquipo();
                //Verificar si es de mi equipo o de un equipo enemigo
                if(!this.getEquipo().equalsIgnoreCase(equipo)){

                    //si no es de mi equipo marcar la casilla en rojo
                    //Obtener color de la casilla
                    coloresAntiguos.add(m[coor.getFila() - 1][coor.getColumna() + 1].getBackground());
                    //Cambiar color de la casilla al rojo
                    m[coor.getFila() - 1][coor.getColumna() + 1].setBackground(Color.red);
                    //Agregar a la lista de movimientos
                    movimientos.add(m[coor.getFila() - 1][coor.getColumna() + 1]);
                }


            }
        }

    }

    private void matarNegra(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos){
        CoordenadaFicha coor = CoordenadaFicha.localizarPosicion(m,this);

      //Verificar limite por izquierda
       if(coor.getFila() + 1 <= m.length - 1 && coor.getColumna() - 1 >= 0){

           //Verificar si hay una ficha en esa posicion
           if(m[coor.getFila() + 1][coor.getColumna() - 1].getFicha() != null  ){

               String equipo = m[coor.getFila() + 1][coor.getColumna() - 1].getFicha().getEquipo();
               //Verificar si el equipo es distinto del mio

               if(!equipo.equalsIgnoreCase("blanco")){
                   //Si se cumple la condicion se debe marcar la casilla de color rojo


                   //luego guardo el color de la ficha a matar
                   coloresAntiguos.add(m[coor.getFila() + 1][coor.getColumna() - 1].getBackground());
                   //Ahora le cambio el color al color rojo para indicar que la ficha puede ser comida
                   m[coor.getFila() + 1][coor.getColumna() - 1].setBackground(Color.red);
                   //Por ultimo agrego mi ficha a la coleccion de movimientos
                   movimientos.add(m[coor.getFila() + 1][coor.getColumna() - 1]);
               }
           }
       }

        //Verificar limite por derecha
        if(coor.getFila() + 1 <= m.length - 1 && coor.getColumna() + 1 <= m.length - 1){

            //Verificar si hay una ficha en esa posicion
            if(m[coor.getFila() + 1][coor.getColumna() + 1].getFicha() != null  ){

                String equipo = m[coor.getFila() + 1][coor.getColumna() + 1].getFicha().getEquipo();
                //Verificar si el equipo es distinto del mio

                if(!equipo.equalsIgnoreCase("blanco")){
                    //Si se cumple la condicion se debe marcar la casilla de color rojo

                    //luego guardo el color de la ficha a matar
                    coloresAntiguos.add(m[coor.getFila() + 1][coor.getColumna() + 1].getBackground());
                    //Ahora le cambio el color al color rojo para indicar que la ficha puede ser comida
                    m[coor.getFila() + 1][coor.getColumna() + 1].setBackground(Color.red);
                    //Por ultimo agrego mi ficha a la coleccion de movimientos
                    movimientos.add(m[coor.getFila() + 1][coor.getColumna() + 1]);
                }
            }
        }

    }


   
}
