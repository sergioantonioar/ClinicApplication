package Estructura.Especialidad;

import Modelo.Especialidad;
import Ordenamiento.OrdenarEspecialidad;
import Persistencia.Persistencia_Especialidad;
import Procesos.Mensajes;
import java.io.Serializable;

public class ArrayEspecialidad implements Serializable {

    private Especialidad[] listEspec;
    private Persistencia_Especialidad persistencia;
    public static int cant;

    public ArrayEspecialidad() {
        persistencia = new Persistencia_Especialidad();
        listEspec = persistencia.RecupereAtenciones(10);
        ActualizarContador();
    }

    public void GuardarCambios() {
        persistencia.GuardarAtenciones(listEspec);;
    }

    public void AñadirEspecialidad(Especialidad e) {
        listEspec[cant] = e;
        cant++;
        GuardarCambios();
    }

    public void ActualizarEspecialidad(int i, Especialidad espActualizada) {
        listEspec[i] = espActualizada;
        GuardarCambios();
    }

    public Especialidad ObtenerEspecialidad(int i) {
        return listEspec[i];
    }

    public void EliminarEspecialidad(int index) {
        for (int i = index; i < cant - 1; i++) {
            listEspec[i] = listEspec[i + 1];
            break;
        }

        listEspec[cant - 1] = null;
        cant--;
        Mensajes.LeerMensaje("Eliminarcion Exitosa");
        GuardarCambios();
    }

    public int BuscarIndexEspecialidad(String id) {
        for (int i = 0; i < listEspec.length; i++) {
            if (listEspec[i].getCodigo().contains(id)) {
                return i;
            }
        }
        Mensajes.LeerMensaje("No se encontro el Index de especialidad");
        return -1;
    }

    public Especialidad BuscarNombreEspecialidad(String nombre) {
        for (int i = 0; i < listEspec.length; i++) {
            if (listEspec[i].getNombre().equalsIgnoreCase(nombre)) {
                return listEspec[i];
            }
        }
        Mensajes.LeerMensaje("No se encontró la especialidad con ese nombre.");
        return null;
    }

    public void ActualizarContador() {
        cant = 0;
        for (Especialidad especialidad : listEspec) {
            if (especialidad != null) {
                cant++;
            }
        }
    }

    public int getContador() {
        return cant;
    }

    public Especialidad[] getListEspec() {
        return listEspec;
    }
    // Método para ordenar las especialidades por nombre utilizando la clase OrdenarEspecialidades

    public void OrdenarPorNombre() {
        // Pasar el arreglo de especialidades (listEspec) a la clase de ordenamiento
        OrdenarEspecialidad.OrdenarPorNombre(listEspec);
    }
}
