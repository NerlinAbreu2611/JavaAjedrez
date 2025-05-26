/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ajedrez;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author elmen
 */
public class PanelCasilla extends JPanel{
    private JLabel casilla;
    private Ficha ficha = null;

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
        ImageIcon imagen = ficha.getImagenFicha();
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance((panelPadre.getWidth() / 8) - 10, (panelPadre.getHeight() / 8) - 10, 1));
        this.casilla.setIcon(icono);
    }
    
    public void eliminarFicha(){
        this.ficha = null;
        this.casilla.setIcon(null);
    }
    
    private JPanel panelPadre;
    
    public PanelCasilla(JPanel panelPadre){
        this.panelPadre = panelPadre;
        this.setLayout(null);
        
        this.casilla = new JLabel();
        this.casilla.setBounds(5, 0, panelPadre.getWidth() / 8, panelPadre.getHeight() / 8);
        
        add(casilla);
        
    }

    public JLabel getCasilla() {
        return casilla;
    }

}
