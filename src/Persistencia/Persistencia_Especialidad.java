package Persistencia;

import Modelo.Atencion;
import Modelo.Especialidad;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author robert
 */
public class Persistencia_Especialidad {
    private String Archivo="Especialidad";
    public void GuardarAtenciones(Especialidad[]Lista){
        try{
            FileOutputStream fos = new FileOutputStream(Archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
            System.out.println("Se guardo la lista con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al guardar Especialidad: "+e);
        }
    }
    public Especialidad[] RecupereAtenciones(int num){
        Especialidad[]Lista = new Especialidad[num];
        try{
            FileInputStream fis = new FileInputStream(Archivo);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista=(Especialidad[])ois.readObject();
            ois.close();
            System.out.println("Se recupero la lista con exito");
        }catch(Exception e){
            Mensajes.LeerMensaje("Ocurrio un error al recuperar Especialidad: "+e);
        }
        return Lista;
    }
}
