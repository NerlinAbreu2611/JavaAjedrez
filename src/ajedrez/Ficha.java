/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez;

import javax.swing.ImageIcon;

/**
 *
 * @author elmen
 */
public abstract class Ficha {
    
    
    private String equipo;
    private String tipo;
    private CoordenadaFicha posicion;
    private ImageIcon imagenFicha;

    public ImageIcon getImagenFicha() {
        return imagenFicha;
    }

    public void setImagenFicha(ImageIcon imagenFicha) {
        this.imagenFicha = imagenFicha;
    }
    
    
   
    public Ficha(String equipo, String tipo,PanelCasilla[][] m, ImageIcon imagenFicha ){
        this.equipo = equipo;
        this.tipo = tipo;
        this.imagenFicha = imagenFicha;
        this.posicion = new CoordenadaFicha(m,this);
    }
    
    

    public CoordenadaFicha getPosicion() {
        return posicion;
    }
    
    public abstract void mover(PanelCasilla[][]m);
    public abstract void matar(PanelCasilla[][]m);

    public String getEquipo() {
        return equipo;
    }

    public String getTipo() {
        return tipo;
    }
    
    
}
