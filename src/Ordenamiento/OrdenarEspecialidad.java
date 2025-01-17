package Ordenamiento;
import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Especialidad;

import java.util.Arrays;
import java.util.Comparator;

public class OrdenarEspecialidad {
     public static void OrdenarPorNombre(Especialidad[] especialidades) {
        Arrays.sort(especialidades, new Comparator<Especialidad>() {
            @Override
            public int compare(Especialidad e1, Especialidad e2) {
                if (e1 == null || e2 == null) {
                    return 0;
                }
                return e1.getNombre().compareToIgnoreCase(e2.getNombre());
            }
        });
    }
}
