package Procesos;

import Modelo.HistoriaClinica;
import Modelo.Paciente;
import Vista.GUIF_HISTORIACLINICA_AÑADIR;
import java.util.Date;


public class PROCESOS_GUI_HISTORIACLINICA_ACTUALIZAR {
    private GUIF_HISTORIACLINICA_AÑADIR vista;

    public PROCESOS_GUI_HISTORIACLINICA_ACTUALIZAR(GUIF_HISTORIACLINICA_AÑADIR vista) {
        this.vista = vista;
    }
    
    public HistoriaClinica CrearHistoriaClinica(Paciente paciente) {  
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
    
    public void CargarHistoriaClinica(HistoriaClinica clinica) {
        if (clinica != null) {       
            vista.txa_alergias.setText(clinica.getAlergias());       
            vista.txa_atencedentesFamiliares.setText(clinica.getAtencedenteFamiliares());      
            vista.txa_atencedentesPersonales.setText(clinica.getAtencedentePersonales());     
            Modificarcodigo(clinica.getCodigo());
            vista.txa_examenesRealizados.setText(clinica.getExamanesRealizados());      
            vista.txa_habitos.setText(clinica.getHabitos());        
            vista.txa_HistorialQuirurjico.setText(clinica.getHistorialQuirurjica());    
            vista.txa_medicamento.setText(clinica.getMedicamentosActuales());      
            vista.txa_tratamientosPrevios.setText(clinica.getTratamientosPrevios());       
            vista.txa_vacunas.setText(clinica.getVacunas());
            MostarPaciente(clinica.getPaciente());
        } else {
            Mensajes.LeerMensaje("La historia clínica no contiene datos.");
        }
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
    
    public void Modificarcodigo(String codigo){
        vista.txt_codigoHistoria.setText(codigo); 
        vista.txt_codigoHistoria.setEditable(false);
    }
}
