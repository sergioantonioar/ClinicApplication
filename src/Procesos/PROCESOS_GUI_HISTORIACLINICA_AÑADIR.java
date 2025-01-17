package Procesos;

import Modelo.HistoriaClinica;
import Modelo.Paciente;
import Vista.GUIF_HISTORIACLINICA_AÑADIR;
import java.util.Date;



public class PROCESOS_GUI_HISTORIACLINICA_AÑADIR {
    
    private GUIF_HISTORIACLINICA_AÑADIR vista;

    public PROCESOS_GUI_HISTORIACLINICA_AÑADIR(GUIF_HISTORIACLINICA_AÑADIR vista) {
        this.vista = vista;
    }
    
    public HistoriaClinica CrearHistoriaClinica(Paciente paciente) {  
        if (vista.txa_alergias.getText().trim().isEmpty() ||
            vista.txa_atencedentesFamiliares.getText().trim().isEmpty() ||
            vista.txa_atencedentesPersonales.getText().trim().isEmpty() ||
            vista.txt_codigoHistoria.getText().trim().isEmpty() ||
            vista.txa_examenesRealizados.getText().trim().isEmpty() ||
            vista.txa_habitos.getText().trim().isEmpty() ||
            vista.txt_codigoHistoria.getText().trim().isEmpty() ||
            vista.txa_medicamento.getText().trim().isEmpty() ||
            vista.txa_HistorialQuirurjico.getText().trim().isEmpty() ||
            vista.txa_tratamientosPrevios.getText().trim().isEmpty() ||
            vista.txa_vacunas.getText().trim().isEmpty()) {
            Mensajes.LeerMensaje("Todos los campos deben estar llenos.");  
            LimpiarHistoriaClinica();
        }else{
            HistoriaClinica clinica = new HistoriaClinica();
            clinica.setAlergias(vista.txa_alergias.getText());
            clinica.setAtencedenteFamiliares(vista.txa_atencedentesFamiliares.getText());
            clinica.setAtencedentePersonales(vista.txa_atencedentesPersonales.getText());
            clinica.setCodigo(vista.txt_codigoHistoria.getText());
            clinica.setExamanesRealizados(vista.txa_examenesRealizados.getText());
            clinica.setFecha(new Date());
            clinica.setHabitos(vista.txa_habitos.getText());
            clinica.setHistorialQuirurjica(vista.txa_HistorialQuirurjico.getText());
            clinica.setMedicamentosActuales(vista.txa_medicamento.getText());
            clinica.setPaciente(paciente);
            clinica.setTratamientosPrevios(vista.txa_tratamientosPrevios.getText());
            clinica.setVacunas(vista.txa_vacunas.getText());
            return clinica;
        }
        return null;
    }
    
    public void LimpiarHistoriaClinica(){
        vista.txa_alergias.setText("");
        vista.txa_atencedentesFamiliares.setText("");
        vista.txa_atencedentesPersonales.setText("");
        vista.txt_codigoHistoria.setText("");
        vista.txa_examenesRealizados.setText("");
        vista.txa_habitos.setText("");
        vista.txa_HistorialQuirurjico.setText("");
        vista.txa_tratamientosPrevios.setText("");
        vista.txa_vacunas.setText("");
        vista.txa_medicamento.setText("");
    }
    
    public void MostarPaciente(Paciente p){
        vista.lbl_dniCliente.setText("DNI: "+p.getDni());
        vista.lbl_generoCliente.setText("GENERO: "+p.getGenero());
        vista.lbl_nombreCliente.setText("NOMBRE: "+p.getNombres());
    } 
}
