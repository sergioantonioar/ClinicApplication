package Controlador;

import Estructura.Atencion.ArrayListAtencion;
import Estructura.Especialidad.ArrayEspecialidad;
import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Estructura.Paciente.ListaCircularPaciente;
import Estructura.Paciente.Nodo;
import Modelo.Atencion;
import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.HistoriaClinica;
import Modelo.Paciente;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_ATENCION;
import Vista.GUIF_AGREGAR_ATENCION;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CONTROLADOR_ATENCION implements ActionListener {

    private GUIF_AGREGAR_ATENCION vista;
    private PROCESOS_GUI_ATENCION procesos; 
    
    private ArrayListAtencion listaAtencion;
    private ListaCircularPaciente listaPaciente;
    private ListaPilaHistoriaClinica pilaHistoriaClinica;
    private ArrayEspecialidad listaEspecialidad;
    
    private Paciente pacienteAUX;
    private Doctor doctorAUX;
    private Atencion atencionAUX;
    
    //agregar lista

    public CONTROLADOR_ATENCION(Doctor doctorAUX) {
        
        vista = new GUIF_AGREGAR_ATENCION();
        procesos = new PROCESOS_GUI_ATENCION(vista);
        
        listaAtencion=new ArrayListAtencion();
        listaPaciente=new ListaCircularPaciente();
        pilaHistoriaClinica=new ListaPilaHistoriaClinica();
        listaEspecialidad=new ArrayEspecialidad();
        
        this.doctorAUX=doctorAUX;
        pacienteAUX=new Paciente();

        procesos.Presentacion();
        procesos.CargarEspecialidades(listaEspecialidad);
        procesos.MostrarDoctor(doctorAUX.getNombres());
        
        procesos.MostrarTabla(listaAtencion,doctorAUX.getCodigo(),doctorAUX.getDni());
        
        vista.btn_agregarAtencion.addActionListener(this);
        vista.btn_verHistoriaClinica.addActionListener(this);
        vista.btn_modificarAtencion.addActionListener(this);
        vista.btn_limpiarAtencion.addActionListener(this);
        vista.btn_Eliminar.addActionListener(this);
        vista.btn_cargarAtencion.addActionListener(this);
        vista.btn_buscarPaciente.addActionListener(this); 
    }

    public GUIF_AGREGAR_ATENCION getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btn_agregarAtencion){
            AgregarAtencion();
        }
        if(e.getSource()==vista.btn_buscarPaciente){
            BuscarPaciente();
        }
        if(e.getSource()==vista.btn_cargarAtencion){
            CargarAtencion();
        }
        if(e.getSource()==vista.btn_limpiarAtencion){
            procesos.LimpiarCampos();
        }
        if(e.getSource()==vista.btn_modificarAtencion){
            Actualizar();
        }
        if(e.getSource()==vista.btn_Eliminar){
            Eliminar();
        }
        if(e.getSource()==vista.btn_verHistoriaClinica){
            MostrarHistoriClinica();
        }
    }
    
    public void AgregarAtencion(){
        
        String codigoAtencion=listaAtencion.CrearCodigoAtencion();
        
        Especialidad especialidadAUX=listaEspecialidad.BuscarNombreEspecialidad(procesos.EspecializacionEscogidad());
        
        if(especialidadAUX==null){
            Mensajes.LeerMensaje("Debe Escoger una especialidad");
        }else{
            Atencion atencionAUX=procesos.CrearAtencion(doctorAUX, pacienteAUX, codigoAtencion, especialidadAUX);      
            listaAtencion.AñadirAtencion(atencionAUX);    
            procesos.MostrarTabla(listaAtencion,doctorAUX.getCodigo(),doctorAUX.getDni());
            procesos.LimpiarCampos();
        }
    }
    
    public void BuscarPaciente(){        
        Nodo NodoPaciente= listaPaciente.BuscarNodoPaciente(Mensajes.Escribir("Ingrese el DNI del paciente"));
        if(NodoPaciente!=null){
            pacienteAUX=NodoPaciente.pac;
            procesos.MostrarPaciente(pacienteAUX);
        }else{
            Mensajes.LeerMensaje("CAUSAS PROBLABLES: ELMINADO O NO INGRESADO");
        }
    }
    
    public void CargarAtencion(){
        String codigo=Mensajes.Escribir("Ingrese el codigo de Atencion");
        atencionAUX=listaAtencion.ObtenerAtencion(listaAtencion.BuscarIndexAtencion(codigo));
        pacienteAUX=procesos.CargarAtencionEnCampos(atencionAUX);
    }
    
    public void Actualizar(){
        
        Especialidad especialidadAUX=listaEspecialidad.BuscarNombreEspecialidad(procesos.EspecializacionEscogidad());
        
        atencionAUX=procesos.CrearAtencion(doctorAUX, pacienteAUX, atencionAUX.getCodigo(),especialidadAUX);
        
        listaAtencion.ActualizarAtencion(listaAtencion.BuscarIndexAtencion(atencionAUX.getCodigo()), atencionAUX);
        
        procesos.MostrarTabla(listaAtencion,doctorAUX.getCodigo(),doctorAUX.getDni());
    }
    
    
    
    
    
    
    
    
    
    
    
    public void Eliminar(){
        String codigo=Mensajes.Escribir("Ingrese el codigo de Atencion");
        listaAtencion.ElimnicarAtencion(listaAtencion.ObtenerAtencion(listaAtencion.BuscarIndexAtencion(codigo)));
        procesos.MostrarTabla(listaAtencion,doctorAUX.getCodigo(),doctorAUX.getDni());
    }
    
    public void MostrarHistoriClinica(){
        if (pacienteAUX != null) {
            HistoriaClinica historiaClinicaAUX = pilaHistoriaClinica.BuscarPilaHistoriaClinica_Paciente(pacienteAUX.getDni());
            if (historiaClinicaAUX != null) {
                Mensajes.LeerMensaje(historiaClinicaAUX.toString());
            } else {
             Mensajes.LeerMensaje("No se encontró la historia clínica para este paciente.");
            }
        } else {
            Mensajes.LeerMensaje("No se ha seleccionado un paciente.");
        }
    }
}
