package Persistencia;

import Modelo.HistoriaClinica;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

public class Persistencia_HistoriaClinica {
    private static String Archivo="HistoriasClinicas";
    public void GuardarHistoriaClinica(Stack<HistoriaClinica>Pila){
        try{
            FileOutputStream fos = new FileOutputStream(Archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Pila);
            oos.close();
            System.out.println("Se guardo la pila con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al guardar HistoriasClinicias: "+e);
        }
    }
    public Stack<HistoriaClinica> RecupereHistoriaClinica(){
        Stack<HistoriaClinica>Pila=new Stack<>();
        try{
            FileInputStream fis = new FileInputStream(Archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pila=(Stack<HistoriaClinica>)ois.readObject();
            ois.close();
            System.out.println("Se recupero la pila con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al recuperar HistoriasClinicas: "+e);
        }
        return Pila;
    }
}
