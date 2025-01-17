package Controlador;

import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Estructura.Paciente.ListaCircularPaciente;
import Modelo.HistoriaClinica;
import Modelo.Paciente;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_HISTORIACLINICA_ACTUALIZAR;
import Vista.GUIF_HISTORIACLINICA_AÑADIR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CONTROLADOR_HISTORIACLINICA_ACTUALIZAR implements ActionListener{
    
    private GUIF_HISTORIACLINICA_AÑADIR VistaActualizar; //Es la vista de añadir solo q la estoy reutilizando
    private PROCESOS_GUI_HISTORIACLINICA_ACTUALIZAR procesos;
    private ListaPilaHistoriaClinica pila;
    private CONTROLADOR_HISTORIACLINICA controlador_historiaclinica;
    
    private HistoriaClinica aux;

    public CONTROLADOR_HISTORIACLINICA_ACTUALIZAR(CONTROLADOR_HISTORIACLINICA controlador_historiaclinica, HistoriaClinica aux) {
        this.controlador_historiaclinica = controlador_historiaclinica;
        VistaActualizar=new GUIF_HISTORIACLINICA_AÑADIR();
        procesos=new PROCESOS_GUI_HISTORIACLINICA_ACTUALIZAR(VistaActualizar);
        pila=new ListaPilaHistoriaClinica();
        this.aux=aux;
        procesos.CargarHistoriaClinica(pila.BuscarPilaHistoriaClinica(aux.getCodigo()));
        
        VistaActualizar.btn_guadar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==VistaActualizar.btn_guadar)
            Modificar();
    }
    
    public void Modificar() {
        if (aux != null) {
            
            HistoriaClinica historiaClinicaActualizar = procesos.CrearHistoriaClinica(aux.getPaciente());
            
            pila.ActualizarPila(aux.getCodigo(), historiaClinicaActualizar);
            
            controlador_historiaclinica.VolverPanelOriginal();
        } else {
            Mensajes.LeerMensaje("Hubo un error: No se seleccionó correctamente la lista.");
        }
    }

    public GUIF_HISTORIACLINICA_AÑADIR getVistaActualizar() {
        return VistaActualizar;
    }
    
    
}
