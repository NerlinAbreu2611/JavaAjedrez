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
public abstract class Ficha {
    
    
    private String equipo;
    private String tipo;
 
    private ImageIcon imagenFicha;

    public ImageIcon getImagenFicha() {
        return imagenFicha;
    }

    public void setImagenFicha(ImageIcon imagenFicha) {
        this.imagenFicha = imagenFicha;
    }
    
    
   
    public Ficha(String equipo, String tipo, ImageIcon imagenFicha ){
        this.equipo = equipo;
        this.tipo = tipo;
        this.imagenFicha = imagenFicha;
       
    }
    
    


    public abstract void mover(PanelCasilla[][]m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos);
    public abstract void matar(PanelCasilla[][]m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos);

    public String getEquipo() {
        return equipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
