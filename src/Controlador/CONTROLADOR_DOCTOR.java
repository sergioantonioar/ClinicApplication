package Controlador;

import Estructura.Doctor.ListaNodoEnlazados;
import Estructura.Doctor.Nodo;
import Modelo.Doctor;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_DOCTOR;
import Vista.GUIF_AGREGAR_DOCTOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CONTROLADOR_DOCTOR implements ActionListener {

    private GUIF_AGREGAR_DOCTOR vista;
    private PROCESOS_GUI_DOCTOR procesos;
    private ListaNodoEnlazados lista;
    
    private String codigoBuscado;
    private Nodo DoctorAux;
    
    public CONTROLADOR_DOCTOR() {
        vista = new GUIF_AGREGAR_DOCTOR();
        procesos = new PROCESOS_GUI_DOCTOR(vista);
        lista = new ListaNodoEnlazados();
        procesos.Presentacion();
        procesos.MostrarTabla(lista);
        vista.BTN_ACTUALIZAR.addActionListener(this);
        vista.BTN_AÑADIR_INICIO.addActionListener(this);
        vista.BTN_BUSCAR.addActionListener(this);
        vista.BTN_ELIMINAR.addActionListener(this);
        vista.BTN_ORDENAR.addActionListener(this);
        vista.BTN_AÑADIR_FINAL.addActionListener(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.BTN_ACTUALIZAR) {
            ActualizarDoctor();
        } else if (e.getSource() == vista.BTN_AÑADIR_INICIO) {
            AgregarDoctor_Incio();
        } else if (e.getSource() == vista.BTN_BUSCAR) {
            BuscarDoctor();
        } else if (e.getSource() == vista.BTN_ELIMINAR) {
            EliminarDoctor();
        } else if (e.getSource() == vista.BTN_ORDENAR) {

            if ("Nombre".equals(vista.CBX_SELC_ORDEN.getSelectedItem())) {
                OrdenarPorNombres();
            }
        } else if (e.getSource() == vista.BTN_AÑADIR_FINAL) {
            AgregarDoctor_Final();
        }
    }

    public void AgregarDoctor_Incio() {
        if (procesos.VerificarCampos()) {
            Doctor d = procesos.CrearDoctor();
            if (lista.VerificarDuplicados(d) == true) {
                Mensajes.LeerMensaje("El doctor con este codigo o dni ya esta verificados");
            } else {
                lista.AñadirDoctorInicio(d);
                procesos.Limpiar();
                procesos.MostrarTabla(lista);
            }
        } else {
            Mensajes.LeerMensaje("Rellene todos los datos");
        }
    }

    public void AgregarDoctor_Final() {
        if (procesos.VerificarCampos()) {
            Doctor d = procesos.CrearDoctor();
            if (lista.VerificarDuplicados(d)) {
                Mensajes.LeerMensaje("El doctor con este codigo y dni ya esta verificados");
            } else {
                lista.AñadirDoctorFinal(d);
                procesos.Limpiar();
                procesos.MostrarTabla(lista);
            }
        } else {
            Mensajes.LeerMensaje("Rellene todos los datos");
        }
    }

    public void EliminarDoctor() {
        lista.ElminarDoctor(Mensajes.Escribir("Ingrese el codigo del doctor"));
        procesos.Limpiar();
        procesos.MostrarTabla(lista);
    }

    public void BuscarDoctor() {
        // Solicitar el código del doctor
        codigoBuscado = Mensajes.Escribir("Ingrese el código del doctor a buscar:");

        // Buscar el doctor en la lista enlazada utilizando el método ya existente
        DoctorAux = lista.BuscarNodoDoctor(codigoBuscado);

        if (DoctorAux != null) {
            // Obtener el objeto Doctor desde el nodo encontrado
            procesos.CargarDoctor(DoctorAux.getdoctor());

            // Mostrar mensaje de éxito
            Mensajes.LeerMensaje("Doctor con código " + codigoBuscado + " encontrado.");
        } else {
            // Si no se encuentra, mostrar un mensaje de error
            Mensajes.LeerMensaje("Doctor con código " + codigoBuscado + " no encontrado.");
        }
    }

    public void ActualizarDoctor() {

        Doctor DocActutalizar=procesos.CrearDoctor();
        
        if (DoctorAux != null) {
            
            lista.Actualizar(codigoBuscado, DocActutalizar);
            procesos.Limpiar(); 
            procesos.MostrarTabla(lista);
            
            DocActutalizar=null;

            // Mensaje de éxito
            Mensajes.LeerMensaje("Doctor con código " + codigoBuscado + " actualizado.");
            procesos.Limpiar();
        } else {
            // Mensaje de error si no se encuentra el doctor
            Mensajes.LeerMensaje("Doctor no encontrado.");
        }
    }

    public void OrdenarPorNombres() {
        lista.OrdenarPorNombre(); // Ordena los doctores por nombre
        procesos.MostrarTabla(lista);
    }

    public GUIF_AGREGAR_DOCTOR getVista() {
        return vista;
    }
}
