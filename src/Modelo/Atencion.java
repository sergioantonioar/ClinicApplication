package Modelo;

import java.io.Serializable;
import java.util.Date;

public class Atencion implements Serializable{
    
    private String codigo;
    private Paciente paciente;
    private Doctor doctor;
    private String motivo;
    private String observacion;
    private String diagnostico;
    private String tratamiento;
    private Especialidad especialidad_atencion;
    private Date fecha;
    
    public Atencion() {
        
    }
    
    public Object[] Registro(int num){
        Object [] fila={num,codigo,doctor.getNombres(),paciente.getNombres(),especialidad_atencion.getNombre(),fecha.toInstant()};
        return fila;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Especialidad getEspecialidad_atencion() {
        return especialidad_atencion;
    }

    public void setEspecialidad_atencion(Especialidad especialidad_atencion) {
        this.especialidad_atencion = especialidad_atencion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("======================= DETALLES DE LA ATENCIÓN ========================\n");
        sb.append("\t\tCódigo: ").append(codigo).append("\n");
        sb.append("\t\tPaciente: ").append(paciente.getNombres()).append("\n");
        sb.append("\t\tDoctor: ").append(doctor.getNombres()).append("\n");
        sb.append("\t\tEspecialidad: ").append(especialidad_atencion.getNombre()).append("\n");
        sb.append("\t\tFecha: ").append(fecha.toString()).append("\n\n");

        sb.append("---- MOTIVO Y DIAGNÓSTICO ----\n");
        sb.append("Motivo: ").append(motivo).append("\n\n");
        sb.append("Diagnóstico: ").append(diagnostico).append("\n\n");

        sb.append("---- TRATAMIENTO Y OBSERVACIONES ----\n");
        sb.append("Tratamiento: ").append(tratamiento).append("\n\n");
        sb.append("Observación: ").append(observacion).append("\n\n");
        
        return sb.toString();
    }     
}
