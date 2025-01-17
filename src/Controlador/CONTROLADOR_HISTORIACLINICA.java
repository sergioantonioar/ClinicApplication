package Controlador;

import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Estructura.Paciente.ListaCircularPaciente;
import Estructura.Paciente.Nodo;
import Modelo.HistoriaClinica;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_HISTORIACLINICA;
import Vista.GUIF_HISTORIACLINICA;
import Vista.GUIF_HISTORIACLINICA;
import Vista.GUIF_HISTORIACLINICA_AÑADIR;
import Vista.GUIF_HISTORIACLINICA_VER;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class CONTROLADOR_HISTORIACLINICA implements ActionListener {

    private GUIF_HISTORIACLINICA vista;
    private PROCESOS_GUI_HISTORIACLINICA procesos;
    
    private ListaCircularPaciente listaPaciente;
    private JPanel aux ;
    
    public CONTROLADOR_HISTORIACLINICA() {
        vista = new GUIF_HISTORIACLINICA();
        procesos = new PROCESOS_GUI_HISTORIACLINICA(vista);
        listaPaciente=new ListaCircularPaciente();
        vista.Actualizar_HistoriaClinica.addActionListener(this);
        vista.Añadir_HistoriaClinica.addActionListener(this);
        vista.Ver_HistoriaClinica.addActionListener(this);
        
        procesos.Presentacion();
        
        aux=vista.Panel_Contenido;
    }

    public GUIF_HISTORIACLINICA getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.Añadir_HistoriaClinica){
            Ver_Panel_AÑADIR();
        }else if(e.getSource()==vista.Ver_HistoriaClinica){
            Ver_Panel_VER();
        }else if(e.getSource()==vista.Actualizar_HistoriaClinica){
            Ver_Panel_ACTUALIZAR();
        }
    }
    
    
    private void CambiarPanel(JPanel panel){
            panel.setSize(900, 550);
            panel.setLocation(0, 0);
            vista.Panel_Contenido.removeAll();
            vista.Panel_Contenido.add(panel,BorderLayout.CENTER);
            vista.Panel_Contenido.revalidate();
            vista.Panel_Contenido.repaint();
    }
    
    public void VolverPanelOriginal() {
        try {
            CambiarPanel(aux); 
        } catch (Exception e) {
            System.out.println("Error al intentar regresar al panel original: " + e.getMessage());
            System.out.println("Trazando panel...");
            
        }
    }

    
    private void Ver_Panel_AÑADIR(){    
        
        ListaPilaHistoriaClinica historiaClinica = new ListaPilaHistoriaClinica();
        
        String dni = Mensajes.Escribir("Ingrese el Dni del paciente");
        
        Nodo nodo = listaPaciente.BuscarNodoPaciente(dni);
        
        if (historiaClinica.Detector_Duplicados(nodo.pac.getDni())) {
            Mensajes.LeerMensaje("El paciente ya tiene una historia clínica.");
            return;
        }
        
        if(nodo==null){
            Mensajes.LeerMensaje("No se encontro al paciente");
            return;
        }else{
            CONTROLADOR_HISTORIACLINICA_AÑADIR panel_Añadir=new CONTROLADOR_HISTORIACLINICA_AÑADIR(nodo.pac,this);
            CambiarPanel(panel_Añadir.getVista());
            panel_Añadir.MostrarPac(nodo.pac); 
        } 
    }
    
    private void Ver_Panel_VER(){
        CONTROLADOR_HISTORIACLINICA_VER panel_ver =new CONTROLADOR_HISTORIACLINICA_VER();
        CambiarPanel(panel_ver.getVista());
    }
    
    private void Ver_Panel_ACTUALIZAR(){
        
        ListaPilaHistoriaClinica listaHistoriaClinica=new ListaPilaHistoriaClinica();
        String codigo=Mensajes.Escribir("Ingrese el codigo de la historia clinica");
        HistoriaClinica aux=listaHistoriaClinica.BuscarPilaHistoriaClinica(codigo);
        
        if(aux==null){
            Mensajes.LeerMensaje("Debe escribir un codigo");
            return;
        }else{
            CONTROLADOR_HISTORIACLINICA_ACTUALIZAR panel_actualizar = new CONTROLADOR_HISTORIACLINICA_ACTUALIZAR(this, aux);
            CambiarPanel(panel_actualizar.getVistaActualizar());
        }
    }

}
