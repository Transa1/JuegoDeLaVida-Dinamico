import javax.swing.*;
import java.io.*;

public class Vida {
    private boolean[][] matrix;
    private final String ruta="c:/archivos/vespertino/";
    private final String ext=".vida";

    private int ancho=30;

    public int getAncho() {
        return ancho;
    }

    public Vida() {

    }

    int getX(){
        return matrix.length;
    }
    int getY(){
        return matrix[0].length;
    }

    void cambia(int x, int y){
        matrix[x][y]=!matrix[x][y];
    }
    void nuevo(){
        int x=leerEntero("Dame x");
        int y=leerEntero("Dame y");
        matrix=new boolean[x][y];
        llena();

    }
    void nuevoV(){
        int x=leerEntero("Dame x");
        int y=leerEntero("Dame y");
        matrix=new boolean[x][y];
    }

    public boolean[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(boolean[][] matrix) {
        this.matrix = matrix;
    }

    boolean guarda(String n) throws IOException {
        File f=new File(ruta);
        if(!f.exists()) f.mkdirs();
        f=new File(ruta+n+ext);
        BufferedWriter bw=new BufferedWriter(new FileWriter(f));
        bw.write(""+matrix.length);
        bw.newLine();
        bw.write(""+matrix[0].length);
        bw.newLine();
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                bw.write(""+matrix[i][j]);
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        return true;
    }


    boolean recupera(String n) throws IOException {
        //BufferedReader br=new BufferedReader(new FileReader(new File(ruta+n+ext)));
        File f=new File(ruta+n+ext);
        if(!f.exists()) return false;
        BufferedReader br=new BufferedReader(new FileReader(f));
        int x=Integer.parseInt(br.readLine());
        int y=Integer.parseInt(br.readLine());
        boolean[][] tempore=new boolean[x][y];
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                if(br.readLine().compareTo("true")==0) tempore[i][j]=true;
            }
        }
        br.close();
        matrix=tempore;
        return true;
    }


    int leerEntero(String t){
        String texto;
        String m="";
        do {
            boolean ok=true;
            texto = JOptionPane.showInputDialog(t+m);
            for (int i = 0; i < texto.length(); i++) {
                if(!(texto.charAt(i)>='0' && texto.charAt(i)<='9')){
                    ok=false;
                }
            }
            if(ok) break;
            else m="como eres tonto ... leee";
        }
        while(true);
        return Integer.parseInt(texto);
    }

    void llena(){
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(Math.random()>.5)matrix[i][j]=true;
            }
        }
    }
    void mostrar(){
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                System.out.print(matrix[i][j]?"O":"+");
            }
            System.out.println();
        }
    }

    void siggen(){
        boolean [][] matrixTemp=new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                boolean vive=false;
                if(vecinos(i,j)==3 && !matrix[i][j]) vive=true;
                if((vecinos(i,j)==2 || vecinos(i,j)==3) && matrix[i][j]) vive=true;
                matrixTemp[i][j]=vive;
            }
        }
        matrix=matrixTemp;
    }


    boolean esOrillaX(int i){
        if(i<0 || i>=matrix.length) return true;
        return false;
    }
    boolean esOrillaY(int j){
        if(j<0 || j>=matrix[0].length) return true;
        return false;
    }

    int vecinos(int i, int j){
        int contador=0;
        if(!esOrillaX(i-1) && !esOrillaY(j-1) && matrix[i-1][j-1])contador++;
        if(!esOrillaX(i-1) && !esOrillaY(j) && matrix[i-1][j])contador++;
        if(!esOrillaX(i-1) && !esOrillaY(j+1) &&matrix[i-1][j+1])contador++;
        if(!esOrillaX(i) && !esOrillaY(j-1) &&matrix[i][j-1])contador++;
        if(!esOrillaX(i) && !esOrillaY(j+1) &&matrix[i][j+1])contador++;
        if(!esOrillaX(i+1) && !esOrillaY(j-1) &&matrix[i+1][j-1])contador++;
        if(!esOrillaX(i+1) && !esOrillaY(j) &&matrix[i+1][j])contador++;
        if(!esOrillaX(i+1) && !esOrillaY(j+1) &&matrix[i+1][j+1])contador++;
        return contador;
    }

    void mas(){
        ancho++;
    }
    void menos(){
        ancho--;
    }

}
