package ajedrez;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Rey extends Ficha{

    public Rey(String equipo,String imagenFicha){
        super(equipo,"rey",new ImageIcon(imagenFicha));
    }
    @Override
    public void mover(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {



        CoordenadaFicha coordenadaFicha = CoordenadaFicha.localizarPosicion(m,this);
        movimientos.add(m[coordenadaFicha.getFila()][coordenadaFicha.getColumna()]);

        for (int i = coordenadaFicha.getFila() - 1; i <= coordenadaFicha.getFila() + 1 ; i++) {
            for (int j = coordenadaFicha.getColumna() - 1; j <= coordenadaFicha.getColumna() + 1 ; j++) {
                if(i >= 0 && j >= 0 && i <= m.length - 1 && j <= m.length - 1){
                    if(m[i][j].getFicha() == null){
                        coloresAntiguos.add(m[i][j].getBackground());
                        m[i][j].setBackground(Color.green);
                        movimientos.add(m[i][j]);
                    } else if (!m[i][j].getFicha().getEquipo().equalsIgnoreCase(this.getEquipo())) {
                        coloresAntiguos.add(m[i][j].getBackground());
                        m[i][j].setBackground(Color.red);
                        movimientos.add(m[i][j]);
                    }
                }
            }
        }

        int cont = 0;






    }

    @Override
    public void matar(PanelCasilla[][] m, ArrayList<PanelCasilla> movimientos, ArrayList<Color> coloresAntiguos) {

    }
}
