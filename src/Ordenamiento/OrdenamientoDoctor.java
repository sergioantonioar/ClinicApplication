package Ordenamiento;

import Estructura.Doctor.EnlazeNodo;
import Estructura.Doctor.Nodo;
import Modelo.Doctor;

public class OrdenamientoDoctor {

   // Método para ordenar por nombre
    public static void OrdenarPorNombre(EnlazeNodo enlaze) {
        if (enlaze.getIni() == null || enlaze.getIni().getSig() == null) {
            return; // La lista está vacía o tiene un solo nodo
        }

        boolean intercambiado;
        Nodo actual;
        Nodo siguiente;

        do {
            intercambiado = false;
            actual = enlaze.getIni();

            while (actual != null && actual.getSig() != null) {
                siguiente = actual.getSig();

                // Comparar los nombres de los doctores
                if (actual.getdoctor().getNombres().compareToIgnoreCase(siguiente.getdoctor().getNombres()) > 0) {
                    // Intercambiar los doctores entre los nodos
                    Doctor temp = actual.getdoctor();
                    actual.setdoctor(siguiente.getdoctor());
                    siguiente.setdoctor(temp);
                    intercambiado = true;
                }
                actual = actual.getSig();
            }
        } while (intercambiado); // Repetir si hubo un intercambio
    }
}
