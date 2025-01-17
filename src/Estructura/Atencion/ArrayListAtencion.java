package Estructura.Atencion;

import Modelo.Atencion;
import Persistencia.Persistencia_Atencion;
import Procesos.Mensajes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Collectors;

public class ArrayListAtencion implements Serializable {

    private ArrayList<Atencion> Lista;

    private Persistencia_Atencion persistencia;

    public ArrayListAtencion() {
        persistencia = new Persistencia_Atencion();
        Lista = persistencia.RecupereAtenciones();
    }

    private void GuardarCambios() {
        persistencia.GuardarAtenciones(Lista);
    }

    public void AñadirAtencion(Atencion a) {
        Lista.add(a);
        GuardarCambios();
    }

    public void ElimnicarAtencion(Atencion a) {
        Lista.remove(a);
        GuardarCambios();
    }

    public Atencion ObtenerAtencion(int i) {
        return Lista.get(i);
    }

    public void ActualizarAtencion(int i, Atencion atencion) {
        Lista.set(i, atencion);
        GuardarCambios();
    }

    public int BuscarIndexAtencion(String codigo) {
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getCodigo().contains(codigo)) {
                return i;
            }
        }
        Mensajes.LeerMensaje("No se encontro el index de esa atencion");
        return -1;
    }
    
    

    public ArrayList<Atencion> Lista_Doctor(String codigo, String dni) {
        ArrayList<Atencion> atencionesDoctor = new ArrayList<>();
        for (Atencion atencion : Lista) {
            if (atencion.getDoctor().getCodigo().equalsIgnoreCase(codigo) && atencion.getDoctor().getDni().equalsIgnoreCase(dni)) {
                atencionesDoctor.add(atencion);
            }
        }
        return atencionesDoctor;
    }

    public String CrearCodigoAtencion() {
        int c1 = 5;
        int c2 = Lista.size() + 1;

        String codigo;
        do {
            codigo = "At" + c1 + "GT" + String.format("%03d", c2);
            c2++;
        } while (CodigoExiste(codigo));

        return codigo;
    }

    private boolean CodigoExiste(String codigo) {
        for (Atencion atencion : Lista) {
            if (atencion.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Atencion> FiltrarPorEspecialidadYFechas(String especialidad, Date inicio, Date fin) {
        return (ArrayList<Atencion>) Lista.stream()
                .filter(a -> a.getEspecialidad_atencion().getNombre().equalsIgnoreCase(especialidad)
                && (inicio == null || !a.getFecha().before(inicio))
                && (fin == null || !a.getFecha().after(fin)))
                .collect(Collectors.toList());
    }
    
    public ArrayList<Atencion> FiltrarPorDoctorYFecha(String codDoctor, Date fecha) {
        if (Lista == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Lista.stream()
                .filter(a -> a.getDoctor().getCodigo().equalsIgnoreCase(codDoctor)
                && truncarFecha(a.getFecha()).equals(truncarFecha(fecha)))
                .collect(Collectors.toList()));
    }

    private Date truncarFecha(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public ArrayList<Atencion> getLista() {
        return Lista;
    }
}
