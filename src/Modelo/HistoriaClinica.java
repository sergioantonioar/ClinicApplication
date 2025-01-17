package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class HistoriaClinica implements Serializable{
    private String codigo;
    private Paciente paciente;
    private Date fecha;
    private String atencedentePersonales;
    private String atencedenteFamiliares;
    private String alergias;
    private String vacunas;
    private String medicamentosActuales;
    private String habitos;
    private String tratamientosPrevios;
    private String examanesRealizados;
    private String historialQuirurjica;

    public HistoriaClinica() {
    }

    public Object[] Registro(int num){
        Object[] fila={num,codigo,paciente.getNombres(),fecha};
        return fila;
    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAtencedentePersonales() {
        return atencedentePersonales;
    }

    public void setAtencedentePersonales(String atencedentePersonales) {
        this.atencedentePersonales = atencedentePersonales;
    }

    public String getAtencedenteFamiliares() {
        return atencedenteFamiliares;
    }

    public void setAtencedenteFamiliares(String atencedenteFamiliares) {
        this.atencedenteFamiliares = atencedenteFamiliares;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getVacunas() {
        return vacunas;
    }

    public void setVacunas(String vacunas) {
        this.vacunas = vacunas;
    }

    public String getMedicamentosActuales() {
        return medicamentosActuales;
    }

    public void setMedicamentosActuales(String medicamentosActuales) {
        this.medicamentosActuales = medicamentosActuales;
    }

    public String getHabitos() {
        return habitos;
    }

    public void setHabitos(String habitos) {
        this.habitos = habitos;
    }

    public String getTratamientosPrevios() {
        return tratamientosPrevios;
    }

    public void setTratamientosPrevios(String tratamientosPrevios) {
        this.tratamientosPrevios = tratamientosPrevios;
    }

    public String getExamanesRealizados() {
        return examanesRealizados;
    }

    public void setExamanesRealizados(String examanesRealizados) {
        this.examanesRealizados = examanesRealizados;
    }

    public String getHistorialQuirurjica() {
        return historialQuirurjica;
    }

    public void setHistorialQuirurjica(String historialQuirurjica) {
        this.historialQuirurjica = historialQuirurjica;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder();
        sb.append("======================= HISTORIA CLÍNICA ========================\n");
        sb.append("\t\tCódigo: ").append(codigo).append("\n");
        sb.append("\t\tPaciente: ").append(paciente.getNombres()).append("\n");
        sb.append("\t\tFecha de emisión: ").append(sdf.format(fecha)).append("\n\n");

        sb.append("---- ANTECEDENTES ----\n");
        sb.append("Personales: ").append(atencedentePersonales).append("\n\n");
        sb.append("Familiares: ").append(atencedenteFamiliares).append("\n\n");

        sb.append("---- DETALLES MÉDICOS ----\n");
        sb.append("Alergias: ").append(alergias).append("\n\n");
        sb.append("Vacunas: ").append(vacunas).append("\n\n");
        sb.append("Medicamentos Actuales: ").append(medicamentosActuales).append("\n\n");

        sb.append("---- HÁBITOS Y TRATAMIENTOS ----\n");
        sb.append("Hábitos: ").append(habitos).append("\n\n");
        sb.append("Tratamientos Previos: ").append(tratamientosPrevios).append("\n\n");

        sb.append("---- HISTORIAL Y EXÁMENES ----\n");
        sb.append("Exámenes Realizados: ").append(examanesRealizados).append("\n\n");
        sb.append("Historial Quirúrgico: ").append(historialQuirurjica).append("\n");

        return sb.toString();
    }    
}
