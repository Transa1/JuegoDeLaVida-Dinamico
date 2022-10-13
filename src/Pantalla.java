import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Pantalla implements MouseListener {
    private int ciclos;
    private Vida v;
    Dibujo d;
    JFrame hoja;
    boolean diseño=false;

    public void setCiclos(int ciclos) {
        this.ciclos = ciclos;
    }
    public Pantalla(int ciclos, Vida v) {
        this.ciclos = ciclos;
        this.v = v;
        hoja=new JFrame();
        hoja.setSize(10,10);
        hoja.setDefaultCloseOperation(3);
        d=new Dibujo();
        hoja.setResizable(false);
        hoja.add(d);
        d.setMatriz(v.getMatrix());
        d.repaint();
    }
    void muestra(){
        if(!(v.getMatrix()==null)) {
            d.setMatriz(v.getMatrix());
            hoja.setSize(v.getAncho() * v.getX() + 50, v.getAncho() * v.getY() + 80);
            hoja.setLocation(100, 100);
            hoja.setVisible(true);
            d.setAncho(v.getAncho());
            d.repaint();
        }
        else{
            JOptionPane.showMessageDialog(null,"Primero debe crear uno nuevo o Recuperar del archivo");
        }
    }

    void diseña(){
        if(!(v.getMatrix()==null)) {
            d.setMatriz(v.getMatrix());
            hoja.setSize(v.getAncho() * v.getX() + 50, v.getAncho() * v.getY() + 80);
            hoja.setLocation(100, 100);
            hoja.setVisible(true);
            d.addMouseListener(this);
            d.setAncho(v.getAncho());
            diseño=true;
                do {
                    d.repaint();
                }while (diseño);
        }
        else{
            JOptionPane.showMessageDialog(null,"Primero debe crear uno nuevo o Recuperar del archivo");
        }
    }
    void apaga(){
        hoja.setVisible(false);
        hoja.dispose();
    }
    void avanza(int ciclo){
        for (int i = 0; i <ciclo ; i++) {
            v.siggen();
            d.setMatriz(v.getMatrix());
            d.pausa(1,200);
            d.repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton()==3){ // 3=secundario
            diseño=false;
        }
        else{
            int tam=v.getAncho();
            int px=(int)((e.getX()-10)/tam);
            int py=(int)((e.getY()-10)/tam);
            v.cambia(px,py);
            //System.out.println("click"+e.getX()+" "+e.getY()+" "+px+" "+py);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
