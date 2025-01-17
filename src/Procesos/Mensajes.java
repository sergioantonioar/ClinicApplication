package Procesos;

import javax.swing.JOptionPane;

public class Mensajes {
  
    public static void LeerMensaje(String text){
        JOptionPane.showMessageDialog(null, text);
    }
    
    public static String Escribir(String text){
        return JOptionPane.showInputDialog(text);
    }
}
