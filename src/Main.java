import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame hoja=new JFrame();
        hoja.setSize(1000,800);
        hoja.setDefaultCloseOperation(3);
        Hilorama d=new Hilorama();
        hoja.setResizable(true);
        hoja.add(d);
        hoja.setVisible(true);
        for (int i = 0; i <1 ; i++) {
            d.pausa(1,200);
            d.repaint();
        }








    }
}