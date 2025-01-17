
package Estructura.Doctor;

import Modelo.Doctor;
import java.io.Serializable;
import Persistencia.Persistencia_Doctor;
import Ordenamiento.OrdenamientoDoctor;
public class ListaNodoEnlazados implements Serializable{
    
    private EnlazeNodo enlaze;
    private Persistencia_Doctor persistencia;
    
    public ListaNodoEnlazados() {
        persistencia=new Persistencia_Doctor();
        enlaze=persistencia.RecuperarEnlazeNodo();
    }
    
    private void GuardarCambios(){persistencia.GuardarEnlazeNodo(enlaze);}

    public void AñadirDoctorInicio(Doctor e){
        Nodo nodo = new Nodo(e);
        enlaze.AgregarNodoInicio(nodo);
        GuardarCambios();
    }
    
    public void AñadirDoctorFinal(Doctor e){
        Nodo nodo = new Nodo(e);
        enlaze.AgregarNodoFinal(nodo);
        GuardarCambios();
    }
    
    public void ElminarDoctor(String codigo){
        Nodo Eliminar=enlaze.BuscarCodigo(codigo);
        enlaze.EliminarDoctor(Eliminar);
        GuardarCambios();
    }
    
    public void Actualizar(String codigo,Doctor Actualizar){
        Nodo BuscarDescontinuado=enlaze.BuscarCodigo(codigo);
        enlaze.ActualizarDoctor(BuscarDescontinuado, Actualizar);
        GuardarCambios();
    }
    
    public Nodo Iniciar_Sesion_Doctor(String codigo,String dni){
        return enlaze.Buscar_Doctor_Sesion(codigo, dni);
    }
    
    public boolean VerificarSesion(String codigo,String dni){
        return enlaze.VerificarSesionDoctor(codigo, dni);
    }
    
    public boolean VerificarDuplicados(Doctor d){
        return enlaze.VerificarDuplicados(d);
    }
    
    public Doctor BuscarDoctor(String codigo){
        return enlaze.BuscarCodigo(codigo).getdoctor();
    }
    
    public Nodo BuscarNodoDoctor(String codigo){
        return enlaze.BuscarCodigo(codigo);
    }

    public EnlazeNodo getEnlaze() {
        return enlaze;
    }

    public void setEnlaze(EnlazeNodo enlaze) {
        this.enlaze = enlaze;
    }

    public Persistencia_Doctor getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(Persistencia_Doctor persistencia) {
        this.persistencia = persistencia;
    } 
    // Método para ordenar por nombre usando la clase OrdenamientoDoctor
    public void OrdenarPorNombre() {
        OrdenamientoDoctor.OrdenarPorNombre(enlaze);
    }
}
