
package Persistencia;

import Estructura.Paciente.EnlazeCircular;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Procesos.Mensajes;

public class Persistencia_Paciente {
    public static String ARCHIVO = "DatosListaPacientes.bin";
    
    public void guardarLista(EnlazeCircular Lista){
        try {
            FileOutputStream fos = new FileOutputStream(ARCHIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Lista);
            oos.close();
        } catch (Exception e) {
            Mensajes.LeerMensaje("ERROR no se puede guardar "+e);
        }
    }
    
    public EnlazeCircular recuperarLista(){
        EnlazeCircular Lista = new EnlazeCircular();
        try {
            FileInputStream fis = new FileInputStream(ARCHIVO);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Lista = (EnlazeCircular) ois.readObject();
        } catch (Exception e) {
            Mensajes.LeerMensaje("ERROR no se puede recuperar... "+e);
        }
        return Lista;
    }
}

