/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez;

/**
 *
 * @author elmen
 */
public class CoordenadaFicha {

    private PanelCasilla[][] casillas;
    private Ficha ficha;

    private int fila = 0;
    private int columna = 0;

    public int getFila() {
        return fila;
    }

 

    public int getColumna() {
        return columna;
    }

    
   
    
    public static CoordenadaFicha localizarPosicion(PanelCasilla [][] m, Ficha ficha){
       // System.out.println(ficha.getEquipo() + "," + ficha.getPosicion());
       
           CoordenadaFicha coordenada = new CoordenadaFicha();
       
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
               
               if(m[i][j].getFicha() != null && m[i][j].getFicha().equals(ficha)){
                   coordenada.setFila(i);
                   coordenada.setColumna(j);
               }
                
            }
            
        }
  
    
        
        return coordenada;
        
              
        
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    
}
