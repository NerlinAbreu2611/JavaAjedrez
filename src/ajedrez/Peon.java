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
        CoordenadaFicha coordenada = CoordenadaFicha.localizarPosicion(m, this);
        
        if(inicio == false){
           // inicio = true;
            
            
            coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna()].getBackground());           
            coloresAntiguos.add(m[coordenada.getFila() - 2][coordenada.getColumna()].getBackground());
                        
            m[coordenada.getFila() - 1][coordenada.getColumna()].setBackground(verde);
            m[coordenada.getFila() - 2][coordenada.getColumna()].setBackground(verde);
            
            movimientos.add(m[coordenada.getFila()][coordenada.getColumna()]);
            movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna()]);
            movimientos.add(m[coordenada.getFila() - 2][coordenada.getColumna()]);
        }else{
            if(coordenada.getFila() - 1 >= 0 && m[coordenada.getFila() - 1][coordenada.getColumna()].getFicha() == null){
                coloresAntiguos.add(m[coordenada.getFila() - 1][coordenada.getColumna()].getBackground());
                m[coordenada.getFila() - 1][coordenada.getColumna()].setBackground(verde);
                
                movimientos.add(m[coordenada.getFila()][coordenada.getColumna()]);
                movimientos.add(m[coordenada.getFila() - 1][coordenada.getColumna()]);
            }
        }
        
       
    }

    @Override
    public void matar(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {
       
    }


   
}
