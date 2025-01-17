package Procesos;

import Estructura.Atencion.ArrayListAtencion;
import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Atencion;
import Modelo.Doctor;
import Modelo.Especialidad;
import Modelo.Paciente;
import Vista.GUIF_AGREGAR_ATENCION;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author SERGIO
 */
public class PROCESOS_GUI_ATENCION{
    private GUIF_AGREGAR_ATENCION vista;

    public PROCESOS_GUI_ATENCION(GUIF_AGREGAR_ATENCION vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Gestion de Atención");
        vista.setVisible(true);
    }
    
    public Atencion CrearAtencion(Doctor doctor, Paciente paciente, String codigo, Especialidad especialidad) {
    
        if (codigo == null || codigo.trim().isEmpty() || 
            doctor == null || 
            paciente == null || 
            especialidad == null || 
            vista.TXTA_DIAGNOSTICO.getText().trim().isEmpty() || 
            vista.TXTA_MOTIVO.getText().trim().isEmpty() || 
            vista.TXTA_OBSERVACIONES.getText().trim().isEmpty() || 
            vista.TXTA_TRATAMIENTO.getText().trim().isEmpty()) {
        
            Mensajes.LeerMensaje("Todos los campos son obligatorios. Por favor, complete todos los datos.");
            return null;
        }
    
        Atencion a = new Atencion();
        a.setCodigo(codigo);
        a.setDiagnostico(vista.TXTA_DIAGNOSTICO.getText());
        a.setDoctor(doctor);
        a.setEspecialidad_atencion(especialidad);
        a.setFecha(new Date());
        a.setMotivo(vista.TXTA_MOTIVO.getText());
        a.setObservacion(vista.TXTA_OBSERVACIONES.getText());
        a.setPaciente(paciente);
        a.setTratamiento(vista.TXTA_TRATAMIENTO.getText());
        return a;
    }
    
    public void LimpiarCampos() {
        vista.TXTA_DIAGNOSTICO.setText("");
        vista.TXTA_MOTIVO.setText("");
        vista.TXTA_OBSERVACIONES.setText("");
        vista.TXTA_TRATAMIENTO.setText("");
        vista.CBX_SELECT_ESPEC.setSelectedIndex(0);
    }
    
    public String EspecializacionEscogidad(){
        if(vista.CBX_SELECT_ESPEC.getSelectedItem().toString()=="Seleccionar"){
            Mensajes.LeerMensaje("Debe escoger un especialidad");
        }else{
            return vista.CBX_SELECT_ESPEC.getSelectedItem().toString();
        }
        return "";
    }
    
    public Paciente CargarAtencionEnCampos(Atencion atencion) {
        if (atencion == null) {
            Mensajes.LeerMensaje("La atención proporcionada es nula.");    
        }
        vista.TXTA_DIAGNOSTICO.setText(atencion.getDiagnostico());
        vista.TXTA_MOTIVO.setText(atencion.getMotivo());
        vista.TXTA_OBSERVACIONES.setText(atencion.getObservacion());
        vista.TXTA_TRATAMIENTO.setText(atencion.getTratamiento());
        MostrarPaciente(atencion.getPaciente());
        vista.lbl_doctor.setText(atencion.getDoctor().getNombres()); 
        vista.lbl_codigo.setText(atencion.getCodigo());
        vista.CBX_SELECT_ESPEC.setSelectedIndex(0);
        return atencion.getPaciente();
    }
    
    public void MostrarPaciente(Paciente a){
        vista.txt_nombrePaciente.setText("NOMBRE: "+a.getNombres());
        vista.txt_dniPaciente.setText("DNI: "+a.getDni());
        vista.txt_direccionPaciente.setText("DIRECCION: "+a.getDireccion());
        vista.txt_edadPaciente.setText("EDAD: "+String.valueOf(a.getEdad()));
        vista.txt_fechaNaciminetoPaciente.setText("FECHA DE NACIMINETO: "+a.getFechaNac());
        vista.txt_telefonoPaciente.setText("TELEFONO: "+a.getTelf());
        vista.txt_generoPaciente.setText("GENERO: "+a.getGenero());
    }
    
    public void CargarEspecialidades(ArrayEspecialidad lista){
        for (int i = 0; i < lista.getContador(); i++) {
            vista.CBX_SELECT_ESPEC.addItem(lista.ObtenerEspecialidad(i).getNombre());
        }
    }
    
    public void MostrarDoctor(String doctor){
        vista.lbl_doctor.setText("Doctor: "+doctor);
    }
    
    public void MostrarTabla(ArrayListAtencion lista, String codigo,String dni) {
        String[] titulos = {"NUM", "CODIGO ATENCION", "DOCTOR", "PACIENTE", "ESPECIALIDAD DE ATENCION", "FECHA DE ATENCION"};
        DefaultTableModel dtm = new DefaultTableModel(null, titulos);
        vista.tbl_tablaAtencion.setModel(dtm);
        ArrayList<Atencion>ListaRecuperada=lista.Lista_Doctor(codigo,dni);
        for (int i = 0; i < ListaRecuperada.size(); i++) {
                dtm.addRow(ListaRecuperada.get(i).Registro(i+1));   
        } 
    }
    
}
