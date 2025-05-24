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

    
    public CoordenadaFicha(PanelCasilla[][] casillas, Ficha ficha) {
        this.casillas = casillas;
        this.ficha = ficha;
        localizarPosicion();
    }
    
    public void localizarPosicion(){
       
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
               if(casillas[i][j].equals(ficha)){
                    this.fila = i;
                    this.columna = j;
               }
                
            }
            
        }
  
        
    }

    
}
