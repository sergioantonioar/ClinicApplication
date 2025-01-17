
package Controlador;

import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Modelo.HistoriaClinica;
import Modelo.Paciente;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_HISTORIACLINICA_AÑADIR;
import Vista.GUIF_HISTORIACLINICA_AÑADIR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CONTROLADOR_HISTORIACLINICA_AÑADIR implements ActionListener{
    
    private GUIF_HISTORIACLINICA_AÑADIR vista;
    private PROCESOS_GUI_HISTORIACLINICA_AÑADIR procesos;
    private ListaPilaHistoriaClinica lista;
    private Paciente Paciente;
    private CONTROLADOR_HISTORIACLINICA HistoriaClinica;
    
    public CONTROLADOR_HISTORIACLINICA_AÑADIR(Paciente Paciente,CONTROLADOR_HISTORIACLINICA HistoriaClinica) {
        this.Paciente = Paciente;
        this.HistoriaClinica=HistoriaClinica;
        vista=new GUIF_HISTORIACLINICA_AÑADIR();
        procesos=new PROCESOS_GUI_HISTORIACLINICA_AÑADIR(vista);
        lista=new ListaPilaHistoriaClinica();
        vista.btn_guadar.addActionListener(this);
    }
     
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btn_guadar)
            crearHistoria();    
    }
    
    private void crearHistoria() { 
        HistoriaClinica aux = procesos.CrearHistoriaClinica(Paciente); 
        if (aux == null) {
            Mensajes.LeerMensaje("No se pudo crear la historia clínica.");
            return;
        }
        
        lista.AgregarPila(aux);
        procesos.LimpiarHistoriaClinica();
        System.out.println(Paciente.toString());
        Mensajes.LeerMensaje("Se añadió la historia exitosamente.");
        HistoriaClinica.VolverPanelOriginal();
    }

    public void MostrarPac(Paciente paciente){
        procesos.MostarPaciente(paciente);
    }
    
    public GUIF_HISTORIACLINICA_AÑADIR getVista() {
        return vista;
    }
    
}
