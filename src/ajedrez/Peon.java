/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez;

import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author elmen
 */
public class Peon extends Ficha{

    private boolean inicio = false;
    
    public Peon(String equipo, String tipo, PanelCasilla[][] m, ImageIcon imagenFicha) {
        super(equipo, tipo, m, imagenFicha);
    }
    
    public Peon(PanelCasilla[][]m, String equipo, String ruta){
        
          super(equipo, "peon", m, new ImageIcon(ruta));
    }
    
    
    private Color verde = Color.GREEN;
    
    @Override
    public void mover(PanelCasilla[][] m) {
        CoordenadaFicha c = super.getPosicion();
        
        if(inicio == false){
            inicio = true;
            m[c.getFila()- 1][c.getColumna()].setBackground(verde);
            m[c.getFila()- 2][c.getColumna()].setBackground(verde);
            
        }
        
       
    }

    @Override
    public void matar(PanelCasilla[][] m) {
        
    }
    
}
