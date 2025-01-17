/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Estructura.Doctor.EnlazeNodo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;


public class Persistencia_Doctor {
     private static String Archivo="Doctores";
    public void GuardarEnlazeNodo(EnlazeNodo enlaze){
        try{
            FileOutputStream fos = new FileOutputStream(Archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(enlaze);
            oos.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al guardar el enlaze: "+e);
        }
    }
    public EnlazeNodo RecuperarEnlazeNodo(){
        EnlazeNodo enlazeNodo = new EnlazeNodo();
        try{
            FileInputStream fis = new FileInputStream(Archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            enlazeNodo=(EnlazeNodo)ois.readObject();
            ois.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Hubo un error al recuperar el enlaze: "+e);
        }
        return enlazeNodo;
    }
}
