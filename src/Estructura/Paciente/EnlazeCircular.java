package Estructura.Paciente;

import Modelo.Paciente;
import java.io.Serializable;

public class EnlazeCircular implements Serializable {

    public Nodo lc;

    public EnlazeCircular() {
        lc = null;
    }

    public void ActualizarPaciente(String dnibuscado, Paciente nuevoPaciente) {
        if (lc != null && nuevoPaciente != null && dnibuscado != null) { // Asegurarse de que no son nulos
            Nodo actual = lc.enlace;
            do {
                if (actual.pac.getDni().equals(dnibuscado)) {
                    actual.pac = nuevoPaciente; // Actualizamos el paciente
                    break;
                }
                actual = actual.enlace;
            } while (actual != lc.enlace); // Recorrer hasta encontrar el nodo
        }
    }

    public void InsertarFinal(Paciente pac) {
        Nodo nuevo = new Nodo(pac);
        if (lc == null) {
            lc = nuevo;
            lc.enlace = lc; // El primer nodo apunta a sí mismo
        } else {
            nuevo.enlace = lc.enlace; // El nuevo nodo apunta al primer nodo
            lc.enlace = nuevo; // El último nodo apunta al nuevo nodo
            lc = nuevo; // Actualizamos el último nodo a ser el nuevo nodo
        }
    }

    public Nodo BuscarDni(String dnibuscado) {
        if (lc != null && dnibuscado != null) {
            Nodo actual = lc.enlace;
            do {
                if (actual.pac.getDni().equals(dnibuscado)) {
                    return actual;
                }
                actual = actual.enlace;
            } while (actual != lc.enlace);
        }
        return null; // No se encuentra el paciente con el DNI buscado
    }

    public void EliminarNodo(String dnieliminar) {
        if (lc == null || dnieliminar == null) {
            return;
        }

        Nodo actual = lc.enlace;
        Nodo anterior = lc;

        do {
            if (actual.pac.getDni().equals(dnieliminar)) {
                if (actual == lc && actual.enlace == lc) { // Un solo nodo en la lista
                    lc = null;
                } else {
                    anterior.enlace = actual.enlace; // El nodo anterior apunta al siguiente
                    if (actual == lc) { // Si el nodo a eliminar es el último
                        lc = anterior;
                    }
                }
                break; // Nodo encontrado y eliminado
            }
            anterior = actual;
            actual = actual.enlace;
        } while (actual != lc.enlace); // Recorrer toda la lista
    }

    public void OrdenarPorNombre() {
        if (lc == null || lc.enlace == lc) {
            return; // Lista vacía o con un solo elemento, no es necesario ordenar
        }

        boolean huboIntercambio;
        do {
            Nodo actual = lc.enlace;
            Nodo siguiente = actual.enlace;
            huboIntercambio = false;

            do {
                if (actual.pac.getNombres().compareTo(siguiente.pac.getNombres()) > 0) {
                    // Intercambiamos los pacientes entre los nodos
                    Paciente temp = actual.pac;
                    actual.pac = siguiente.pac;
                    siguiente.pac = temp;
                    huboIntercambio = true; // Hubo un intercambio, seguimos ordenando
                }
                actual = siguiente;
                siguiente = siguiente.enlace;
            } while (siguiente != lc.enlace);

        } while (huboIntercambio); // Repetimos mientras haya intercambios
    }

}
