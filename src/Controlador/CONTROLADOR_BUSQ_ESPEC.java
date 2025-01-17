package Controlador;

import Estructura.Atencion.ArrayListAtencion;
import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Atencion;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_BUSQ_ESPEC;
import Vista.GUIF_BUSQUEDA_ESPEC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;


public class CONTROLADOR_BUSQ_ESPEC implements ActionListener{
    private GUIF_BUSQUEDA_ESPEC vista;
    private PROCESOS_GUI_BUSQ_ESPEC procesos;   
    private ArrayEspecialidad listaEspecialidad;

    public CONTROLADOR_BUSQ_ESPEC() {
        vista = new GUIF_BUSQUEDA_ESPEC();
        procesos = new PROCESOS_GUI_BUSQ_ESPEC(vista);
        listaEspecialidad = new ArrayEspecialidad();
        
        procesos.CargarEspecialidades(listaEspecialidad);
        procesos.Presentacion();
        
        vista.BTN_BUSCAR.addActionListener(this);
        
        vista.TBL_ATENCIONES.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.TBL_ATENCIONES.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String codigoAtencion = vista.TBL_ATENCIONES.getValueAt(filaSeleccionada, 0).toString();
                    ArrayListAtencion listaAtenciones = new ArrayListAtencion();
                    
                    Atencion atencionSeleccionada = listaAtenciones.getLista().stream()
                        .filter(atencion -> atencion.getCodigo().equals(codigoAtencion))
                        .findFirst()
                        .orElse(null);
                    
                    if (atencionSeleccionada != null) {
                        Mensajes.LeerMensaje(atencionSeleccionada.toString());
                    } else {
                        Mensajes.LeerMensaje("No se encontró la atención seleccionada.");
                    }
                }
            }
        });
    }
    
    public GUIF_BUSQUEDA_ESPEC getVista() {
        return vista;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.BTN_BUSCAR) {
            String especialidadSeleccionada = vista.CBX_SELEC_ESPEC.getSelectedItem() != null
                ? vista.CBX_SELEC_ESPEC.getSelectedItem().toString()
                : null;
            Date fechaInicio = vista.JCD_FECHA_INICIO.getDate();
            Date fechaFin = vista.JCD_FECHA_FIN.getDate();
            
            if (!procesos.ValidarFechas(fechaInicio, fechaFin)) {
                return;
            }
            
            if (especialidadSeleccionada == null || especialidadSeleccionada.isEmpty()) {
                Mensajes.LeerMensaje("Por favor, seleccione una especialidad.");
                return;
            }
            
            ArrayListAtencion listaAtenciones = new ArrayListAtencion();
            procesos.MostrarTabla(listaAtenciones, especialidadSeleccionada, fechaInicio, fechaFin);
            
            Mensajes.LeerMensaje("Búsqueda realizada con éxito para: \n" + especialidadSeleccionada);
        }
    }  
}
