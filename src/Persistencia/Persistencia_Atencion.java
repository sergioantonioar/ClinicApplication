package Persistencia;

import Modelo.Atencion;
import Modelo.Especialidad;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Persistencia_Atencion {
    private String Archivo="Atenciones";
    public void GuardarAtenciones(ArrayList<Atencion>Lista){
        try{
            FileOutputStream fos = new FileOutputStream(Archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
            System.out.println("Se guardo el arraylist con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al guardar Atenciones: "+e);
        }
    }
    public ArrayList<Atencion> RecupereAtenciones(){
        ArrayList<Atencion>Lista = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(Archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista=(ArrayList<Atencion>)ois.readObject();
            ois.close();
            System.out.println("Se recupero la lista con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al recuperar Atenciones: "+e);
        }
        return Lista;
    }
}
