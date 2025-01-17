package Controlador;

import Estructura.Atencion.ArrayListAtencion;
import Modelo.Atencion;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_BUSQ_DOCTOR;
import Vista.GUIF_BUSQUEDA_DOCTOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class CONTROLADOR_BUSQ_DOCTOR implements ActionListener {

    private GUIF_BUSQUEDA_DOCTOR vista;
    private PROCESOS_GUI_BUSQ_DOCTOR procesos;
    private List<Atencion> atencionesCargadas;
    

    public CONTROLADOR_BUSQ_DOCTOR() {
        vista = new GUIF_BUSQUEDA_DOCTOR();
        procesos = new PROCESOS_GUI_BUSQ_DOCTOR(vista);
        atencionesCargadas = new ArrayList<>();
      
        procesos.Presentacion();
        
        vista.BTN_BUSCAR.addActionListener(this);
        
        vista.TBL_ATENCIONES.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = vista.TBL_ATENCIONES.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String codigoAtencion = vista.TBL_ATENCIONES.getValueAt(filaSeleccionada, 0).toString();
//                    ArrayListAtencion listaAtenciones = new ArrayListAtencion();
                    
                    Atencion atencionSeleccionada = atencionesCargadas.stream() //cargando atenciones
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

    public GUIF_BUSQUEDA_DOCTOR getVista() {
        return vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String codigoDoctor = vista.TXT_COD_MEDICO.getText().trim();
        Date fechaBusqueda = vista.JDC_FECHA_BUSQ.getDate();
        
        if (codigoDoctor.isEmpty()) {
            Mensajes.LeerMensaje("Por favor, ingrese un código de médico.");
            return;
        }
        if (fechaBusqueda == null) {
            Mensajes.LeerMensaje("Por favor, seleccione una fecha.");
            return;
        }
        
        ArrayListAtencion listaAtenciones = new ArrayListAtencion();
        
//        ArrayList<Atencion> atencionesFiltradas = listaAtenciones.FiltrarPorDoctorYFecha(codigoDoctor, fechaBusqueda);
        atencionesCargadas = listaAtenciones.FiltrarPorDoctorYFecha(codigoDoctor, fechaBusqueda);
        
        if (atencionesCargadas.isEmpty()) {
            Mensajes.LeerMensaje("No se encontraron atenciones para el médico y la fecha seleccionada.");
            return;
        }
        
        procesos.MostrarTabla(listaAtenciones, codigoDoctor, fechaBusqueda);
        
        Mensajes.LeerMensaje("Búsqueda realizada con éxito para el médico con código: \n" + codigoDoctor);
    }

}
