import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) throws IOException {
        Vida v=new Vida();
        Pantalla p=new Pantalla(0,v);
        do{
            char letra = verMenu().charAt(0);
            switch (letra) {
                case 'N':
                    v.nuevo();
                    p.muestra();
                    break;
                case '-':
                    // metodo 2
                    v.menos();
                    p.muestra();
                    break;
                case '+':
                    // metodo 2
                    v.mas();
                    p.muestra();
                    break;
                case 'D':
                    v.nuevoV();
                    p.diseña();
                    v.guarda(JOptionPane.showInputDialog("Nombre"));
                    break;
                case 'G':
                    v.guarda(JOptionPane.showInputDialog("Nombre"));
                    break;
                case 'R':
                    v.recupera(JOptionPane.showInputDialog("Nombre"));
                    p.muestra();
                    break;
                case 'M':
                    p.muestra();
                    break;
                case 'S':
                    p.avanza(1);
                    break;
                case 'V':
                    p.avanza(v.leerEntero("Cuantos ciclos"));
                    break;

                    case 'F':
                    p.apaga();
                    break;
            }
            if(letra=='F')
                break;
        }while(true);
    }

    static String verMenu(){
        String texto="Menu\n" +
                "Nuevo ( el usuario define tamaño )\n" +
                "Diseño ( por desarrollar )\n" +
                "Guardar (solicitar nombre del archivo)\n" +
                "Recuperar ( solicitar nombre del archivo) y mostrar\n" +
                "Mostrar ( muestra el diseño actual )\n" +
                "Siguiente ( avanza una generacion )\n" +
                "Ver Siguientes #  ( solicitar cuantas generaciones )\n" +
                "+ mas grande\n" +
                "- mas pequeño\n" +
                "Fin ( salir del programa )\n" +
                "\n" +
                "Teclee la primera letra de su selección";
               do {
                   char letra='0';
                   String opcion = JOptionPane.showInputDialog(texto);
                   if(!(opcion.isEmpty())){
                       letra = opcion.charAt(0);
                   }

                   switch (letra) {
                       case 'N':
                           return "Nuevo";
                       case 'D':
                           return "Diseño";
                       case 'G':
                           return "Guardar";
                       case 'R':
                           return "Recuperar";
                       case 'M':
                           return "Mostrar";
                       case 'S':
                           return "Siguiente";
                       case 'V':
                           return "Ver Siguientes";
                       case '+': return "+";
                       case '-': return "-";
                       case 'F':
                           return "Fin";
                   }
                   JOptionPane.showMessageDialog(null,"No sea usted indulgente, \nlea por favor la instrucción.\nDebe ser la primera letra en Mayúscula");
               }while (true);
    }

}
