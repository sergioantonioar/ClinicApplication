package Ordenamiento;

import Estructura.Paciente.*;
import Modelo.Paciente;

public class OrdenamientoPacientes {

    // Método para ordenar una lista circular de pacientes por nombre
    public static void OrdenarPorNombre(EnlazeCircular enlazeCircular) {
        if (enlazeCircular == null || enlazeCircular.lc == null || enlazeCircular.lc.enlace == enlazeCircular.lc) {
            return; // Lista vacía o con un solo elemento, no es necesario ordenar
        }

        boolean huboIntercambio;
        do {
            Nodo actual = enlazeCircular.lc.enlace; // Comenzamos desde el primer nodo
            Nodo siguiente = actual.enlace;
            huboIntercambio = false;

            do {
                // Comparar los nombres del paciente actual y el siguiente
                if (actual.pac.getNombres().compareTo(siguiente.pac.getNombres()) > 0) {
                    // Intercambiar los datos entre los nodos
                    Paciente temp = actual.pac;
                    actual.pac = siguiente.pac;
                    siguiente.pac = temp;
                    huboIntercambio = true; // Hubo un intercambio, seguimos ordenando
                }

                actual = siguiente; // Avanzamos al siguiente nodo
                siguiente = siguiente.enlace; // Nodo siguiente del siguiente
            } while (siguiente != enlazeCircular.lc.enlace); // Recorremos toda la lista

        } while (huboIntercambio); // Repetimos mientras haya intercambios
    }
    // Ordena una lista circular de pacientes por edad
    public static void OrdenarPorEdad(EnlazeCircular enlazeCircular) {
        if (esListaOrdenable(enlazeCircular)) {
            boolean huboIntercambio;
            do {
                Nodo actual = enlazeCircular.lc.enlace; 
                Nodo siguiente = actual.enlace;
                huboIntercambio = false;

                do {
                    if (actual.pac.getEdad() > siguiente.pac.getEdad()) { // Comparación por edad
                        intercambiarPacientes(actual, siguiente);
                        huboIntercambio = true;
                    }
                    actual = siguiente;
                    siguiente = siguiente.enlace;
                } while (siguiente != enlazeCircular.lc.enlace);

            } while (huboIntercambio);
        }
    }

    // Método auxiliar para verificar si la lista es ordenable
    private static boolean esListaOrdenable(EnlazeCircular enlazeCircular) {
        return enlazeCircular != null && enlazeCircular.lc != null && enlazeCircular.lc.enlace != enlazeCircular.lc;
    }

    // Método auxiliar para intercambiar los datos de dos nodos
    private static void intercambiarPacientes(Nodo nodo1, Nodo nodo2) {
        Paciente temp = nodo1.pac;
        nodo1.pac = nodo2.pac;
        nodo2.pac = temp;
    }
}
