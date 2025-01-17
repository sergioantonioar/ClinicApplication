package Procesos;

import Estructura.Atencion.ArrayListAtencion;
import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Atencion;
import Vista.GUIF_BUSQUEDA_ESPEC;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SERGIO
 */
public class PROCESOS_GUI_BUSQ_ESPEC {
    private GUIF_BUSQUEDA_ESPEC vista;

    public PROCESOS_GUI_BUSQ_ESPEC(GUIF_BUSQUEDA_ESPEC vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Busqueda por Especialidad...");
        vista.setVisible(true);
    }
    
    public void LimpiarCampos() {
        vista.CBX_SELEC_ESPEC.setSelectedIndex(0);
        vista.JCD_FECHA_FIN.setDate(null);
        vista.JCD_FECHA_INICIO.setDate(null);
    }
    
    public void CargarEspecialidades(ArrayEspecialidad lista){
        vista.CBX_SELEC_ESPEC.removeAllItems();
        for (int i = 0; i < lista.getContador(); i++) {
            vista.CBX_SELEC_ESPEC.addItem(lista.ObtenerEspecialidad(i).getNombre());
        }
    }
    
    public boolean ValidarFechas(Date inicio, Date fin) {
        if (inicio != null && fin != null) {
            if (inicio.after(fin)) {
                Mensajes.LeerMensaje("La fecha de inicio no puede ser posterior a la fecha fin.");
                return false;
            }
        }
        return true;
    }
    
    public void MostrarTabla(ArrayListAtencion lista, String especialidad, Date inicio, Date fin) {
        String[] titulos = {"Código de Atención", "DNI Paciente", "Nombre Paciente", "Fecha de Atención", "Especialidad", "Doctor"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        vista.TBL_ATENCIONES.setModel(dtm);
        
        
        ArrayList<Atencion> listaFiltrada = lista.FiltrarPorEspecialidadYFechas(especialidad, inicio, fin);

        //formato fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (Atencion atencion : listaFiltrada) {
            dtm.addRow(new Object[]{
                atencion.getCodigo(),
                atencion.getPaciente().getDni(),
                atencion.getPaciente().getNombres(),
                sdf.format(atencion.getFecha()),
                atencion.getEspecialidad_atencion().getNombre(),
                atencion.getDoctor().getNombres()
            });
        }

        if (listaFiltrada.isEmpty()) {
            Mensajes.LeerMensaje("No se encontraron resultados para la búsqueda.");
        }
    }
}
