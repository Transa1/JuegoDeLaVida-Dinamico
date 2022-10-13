import javax.swing.*;
import java.awt.*;

public class Hilorama extends JPanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <1000 ; i=i+5) {
            g.setColor(new Color(color(),color(),color()));
            for (int j = 0; j <800 ; j=j+5) {

                g.drawLine(i,(int)(super.getWidth()-j),(int)(super.getHeight()-i),j);

            }
            // 1000,800


        }

    }
    void pausa(int ciclos,int mili){
        long inicio=System.currentTimeMillis();
        while(System.currentTimeMillis()<inicio+(ciclos*mili)){
        }
    }
    int color(){
        return (int)(Math.random()*255);
    }

}
