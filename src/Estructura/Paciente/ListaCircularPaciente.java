package Estructura.Paciente;

import Modelo.Paciente;
import Ordenamiento.OrdenamientoPacientes;
import Persistencia.Persistencia_Paciente;
import Procesos.Mensajes;
import java.io.Serializable;

public class ListaCircularPaciente implements Serializable {

    private EnlazeCircular enlazeCircular;
    private Persistencia_Paciente persistencia;

    public ListaCircularPaciente() {
        persistencia = new Persistencia_Paciente();
        enlazeCircular = persistencia.recuperarLista();
    }

    private void GuardaCambios() {
        persistencia.guardarLista(enlazeCircular);
    }

    public void AgregarPaciente(Paciente paciente) {
        enlazeCircular.InsertarFinal(paciente);
        GuardaCambios();
    }

    public Nodo BuscarNodoPaciente(String dni) {
        if (enlazeCircular.BuscarDni(dni) != null) {
            return enlazeCircular.BuscarDni(dni);
        }
        Mensajes.LeerMensaje("Paciente no encontrado");
        return null;
    }

    public void EliminarNodoPaciente(String dni) {
        enlazeCircular.EliminarNodo(dni);
        GuardaCambios();
    }

    public void ActualizarNodoPaciente(String dni, Paciente pacienteNuevo) {
        enlazeCircular.ActualizarPaciente(dni, pacienteNuevo);
        GuardaCambios();
    }

    public EnlazeCircular getEnlazeCircular() {
        return enlazeCircular;
    }

    public void setEnlazeCircular(EnlazeCircular enlazeCircular) {
        this.enlazeCircular = enlazeCircular;
    }

    // Ordenar por nombre
    public void OrdenarPacientesPorNombre() {
        OrdenamientoPacientes.OrdenarPorNombre(enlazeCircular);
        GuardaCambios();
        Mensajes.LeerMensaje("Pacientes ordenados por nombre.");
    }

    // Ordenar por edad
    public void OrdenarPacientesPorEdad() {
        OrdenamientoPacientes.OrdenarPorEdad(enlazeCircular);
        GuardaCambios();
        Mensajes.LeerMensaje("Pacientes ordenados por edad.");
    }
}
