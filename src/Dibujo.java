import javax.swing.*;
import java.awt.*;

public class Dibujo extends JPanel {
    int contador = 0;
    int ancho=30;
    boolean[][] matriz;

    public boolean[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(boolean[][] matriz) {
        this.matriz = matriz;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (matriz != null) {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    if (matriz[i][j]) {
                        g.fillRect(i * ancho + 10, j * ancho + 10, ancho, ancho);
                    } else {
                        g.drawRect(i * ancho + 10, j * ancho + 10, ancho, ancho);
                    }
                }
            }
        }



/*
       g.setColor(new Color(10+contador,10+contador,10+contador));
       g.drawLine(0,0,ancho,alto);
       g.setColor(Color.red);
       g.drawLine(0,alto,ancho,0);
       g.drawString("Hola Mundo, van:"+contador,100,100);
       g.drawOval((int)(ancho/2),(int)(alto/2),200+contador,200);
       contador++;
       if(contador>100) contador=0;


 */

    }



        void pausa(int ciclos,int mili){
            long inicio=System.currentTimeMillis();
            while(System.currentTimeMillis()<inicio+(ciclos*mili)){
            }
        }




}
