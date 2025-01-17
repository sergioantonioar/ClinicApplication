package Procesos;

import Estructura.Atencion.ArrayListAtencion;
import Modelo.Atencion;
import Vista.GUIF_BUSQUEDA_DOCTOR;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SERGIO
 */
public class PROCESOS_GUI_BUSQ_DOCTOR {

    private GUIF_BUSQUEDA_DOCTOR vista;

    public PROCESOS_GUI_BUSQ_DOCTOR(GUIF_BUSQUEDA_DOCTOR vista) {
        this.vista = vista;
    }

    public void Presentacion() {
        vista.setTitle("Busqueda por Doctor...");
        vista.setVisible(true);
    }

    public void LimpiarCampos() {
        vista.TXT_COD_MEDICO.setText("");
        vista.JDC_FECHA_BUSQ.setDate(null);
    }

    public boolean ValidarFecha(Date fecha) {
        if (fecha != null) {
            return true;
        }
        return true;
    }

    public void MostrarTabla(ArrayListAtencion lista, String codDoctor, Date fecha) {
        String[] titulos = {"Código de Atención", "DNI Paciente", "Nombre Paciente", "Fecha de Atención", "Especialidad", "Doctor"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        vista.TBL_ATENCIONES.setModel(dtm);

        // Validación
        if (codDoctor == null || codDoctor.isEmpty()) {
            Mensajes.LeerMensaje("El código de doctor no puede estar vacío.");
            return;
        }
        if (fecha == null) {
            Mensajes.LeerMensaje("La fecha no puede ser nula.");
            return;
        }

        ArrayList<Atencion> listaFiltrada = lista.FiltrarPorDoctorYFecha(codDoctor, fecha);

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
