package Controlador;

import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Modelo.HistoriaClinica;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_HISTORIACLINICA_VISTA;
import Vista.GUIF_HISTORIACLINICA_VER;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CONTROLADOR_HISTORIACLINICA_VER implements ActionListener{
    private GUIF_HISTORIACLINICA_VER vista;
    private PROCESOS_GUI_HISTORIACLINICA_VISTA procesos;
    private ListaPilaHistoriaClinica pila;

    public CONTROLADOR_HISTORIACLINICA_VER() {
        this.vista = new GUIF_HISTORIACLINICA_VER();
        procesos=new PROCESOS_GUI_HISTORIACLINICA_VISTA(vista);
        pila=new ListaPilaHistoriaClinica();
        procesos.mostrarLista(pila);
        vista.btn_buscar.addActionListener(this);
        vista.btn_eliminar.addActionListener(this);
    }  

    public GUIF_HISTORIACLINICA_VER getVista() {
        return vista;
    }  

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btn_buscar)
            Buscar();
        if(e.getSource()==vista.btn_eliminar)
            Eliminar();
    }
    
    public void Buscar(){   
        HistoriaClinica aux=pila.BuscarPilaHistoriaClinica(Mensajes.Escribir("Ingrese el codigo del Historial"));       
        if(aux != null)
            Mensajes.LeerMensaje(aux.toString());
        else
            return;  
    }
    
    public void Eliminar(){
        pila.Despilar();
        procesos.mostrarLista(pila);
    }
}
