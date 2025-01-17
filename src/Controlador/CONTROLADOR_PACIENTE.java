package Controlador;

import Estructura.Paciente.EnlazeCircular;
import Estructura.Paciente.ListaCircularPaciente;
import Estructura.Paciente.Nodo;
import Modelo.Doctor;
import Ordenamiento.*;
import Modelo.Paciente;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_PACIENTE;
import Vista.GUIF_AGREGAR_PACIENTES;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CONTROLADOR_PACIENTE implements ActionListener {

    private GUIF_AGREGAR_PACIENTES vista;
    private PROCESOS_GUI_PACIENTE procesos;
    private ListaCircularPaciente lista;

    // private EnlazeCircular listacir;
    private String dniBuscado;

    public CONTROLADOR_PACIENTE() {
        vista = new GUIF_AGREGAR_PACIENTES();
        procesos = new PROCESOS_GUI_PACIENTE(vista);
        lista = new ListaCircularPaciente();
        procesos.Presentacion();
        procesos.MostrarTabla(lista);
        vista.BTN_ACTUALIZAR.addActionListener(this);
        vista.BTN_AÑADIR.addActionListener(this);
        vista.BTN_BUSCAR.addActionListener(this);
        vista.BTN_ELIMINAR.addActionListener(this);
        vista.BTN_ORDENAR.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.BTN_ACTUALIZAR) {
            ModificarPaciente();
        } else if (e.getSource() == vista.BTN_AÑADIR) {
            AgregarPaciente();
        } else if (e.getSource() == vista.BTN_BUSCAR) {
            BuscarPaciente();
        } else if (e.getSource() == vista.BTN_ELIMINAR) {
            EliminarPaciente();
        } else if (e.getSource() == vista.BTN_ORDENAR) {
            if ("Nombre".equals(vista.CBX_SELC_ORDEN.getSelectedItem())) {
                odernarPacientesPorNombre();
            } else if ("Edad".equals(vista.CBX_SELC_ORDEN.getSelectedItem())) {
                odernarPacientesPorEdad();
            }

        }
    }

    public void AgregarPaciente() {
        lista.AgregarPaciente(procesos.CrearPaciente());
        procesos.Limpiar();
        procesos.MostrarTabla(lista);
    }

    public void EliminarPaciente() {
        lista.EliminarNodoPaciente(Mensajes.Escribir("Ingrese el codigo del paciente a eliminar"));
        procesos.MostrarTabla(lista);
    }

    public void BuscarPaciente() {
        // Solicitar DNI
        dniBuscado = Mensajes.Escribir("Ingrese el DNI del paciente que desea buscar");

        // Buscar paciente en la lista
        Nodo nodoPaciente = lista.BuscarNodoPaciente(dniBuscado);

        if (nodoPaciente != null) {
            // Si se encuentra, cargar datos en el formulario
            procesos.CargarPaciente(nodoPaciente.pac);
        } else {
            // Si no se encuentra, mostrar un mensaje de error
            Mensajes.LeerMensaje("Paciente con DNI " + dniBuscado + " no encontrado.");
        }
    }

    public void ModificarPaciente() {
        // Crear un nuevo paciente con los datos actuales del formulario
        Paciente nuevoPaciente = procesos.CrearPaciente();

        lista.ActualizarNodoPaciente(dniBuscado, nuevoPaciente);//actualizar el nodo del paciente en lista circular
        procesos.MostrarTabla(lista); //actualizar tabla
        procesos.Limpiar();
        Mensajes.LeerMensaje("Paciente modificado exitosamente.");
    }

    public void odernarPacientesPorNombre() {
        lista.OrdenarPacientesPorNombre();
        procesos.MostrarTabla(lista);
    }

    public void odernarPacientesPorEdad() {
        lista.OrdenarPacientesPorEdad();
        procesos.MostrarTabla(lista);
    }

    public GUIF_AGREGAR_PACIENTES getVista() {
        return vista;
    }
}
