package Procesos;

import Estructura.Paciente.ListaCircularPaciente;
import Estructura.Paciente.Nodo;
import Modelo.Paciente;
import Vista.GUIF_AGREGAR_PACIENTES;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class PROCESOS_GUI_PACIENTE {
    private GUIF_AGREGAR_PACIENTES Vista;

    public PROCESOS_GUI_PACIENTE(GUIF_AGREGAR_PACIENTES Vista) {
        this.Vista = Vista;
    }
    
    public void Presentacion(){
        Vista.setTitle("Gestion Pacientes");
        Vista.setVisible(true);
    }
    
    public Paciente CrearPaciente(){
        Paciente paciente = new Paciente();
        paciente.setDni(Vista.TXT_DNI.getText());
        paciente.setNombres(Vista.TXT_NOMBRE.getText());
        paciente.setGenero(Vista.CBX_GENERO.getSelectedItem().toString());
        paciente.setTelf(Vista.TXT_TELEFONO.getText());
        paciente.setDireccion(Vista.TXT_DIRECCION.getText());
        //verificacion de fecha Nac.
        if(Vista.JCD_FECHA_NACIMIENTO.getDate() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            paciente.setFechaNac(sdf.format(Vista.JCD_FECHA_NACIMIENTO.getDate()));
        }else{
            paciente.setFechaNac("");
        }
        
        paciente.setEdad(calcularEdad(Vista.JCD_FECHA_NACIMIENTO.getDate()));
        return paciente;
    }
    
    public void Limpiar() {
        Vista.TXT_DNI.setText("");
        Vista.TXT_NOMBRE.setText("");
        Vista.TXT_TELEFONO.setText("");
        Vista.TXT_DIRECCION.setText("");
        Vista.CBX_GENERO.setSelectedIndex(0); 
        Vista.JCD_FECHA_NACIMIENTO.setDate(null); 
    }
    
    public void CargarPaciente(Paciente paciente) {
        Vista.TXT_DNI.setText(paciente.getDni());
        Vista.TXT_NOMBRE.setText(paciente.getNombres());
        Vista.TXT_TELEFONO.setText(paciente.getTelf());
        Vista.TXT_DIRECCION.setText(paciente.getDireccion());
        Vista.CBX_GENERO.setSelectedItem(paciente.getGenero());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = sdf.parse(paciente.getFechaNac());
            Vista.JCD_FECHA_NACIMIENTO.setDate(fecha);
        } catch (Exception e) {
        }
    }
    
    public String getOrdenar(){
        return Vista.CBX_SELC_ORDEN.getSelectedItem().toString();
    }
    
    public int calcularEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null){
            return 0;
        }
        Calendar nacimiento = Calendar.getInstance();
        nacimiento.setTime(fechaNacimiento);
        Calendar actual = Calendar.getInstance();
        int edad = actual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);
        if (actual.before(nacimiento)){
            edad--;
        }
        return edad;
    }
    
    public void MostrarTabla(ListaCircularPaciente lista) {
        String[] titulos = {"ID", "DNI", "NOMBRE", "TELEFONO", "EDAD", "DIRECCION", "GENERO", "FECHA NAC."};
        DefaultTableModel dm = new DefaultTableModel(null, titulos);
        Vista.TBL_TABLA.setModel(dm);
        int num = 0;
        
        if (lista.getEnlazeCircular().lc != null) {
            Nodo aux = lista.getEnlazeCircular().lc.enlace; 
            do {
                num++;
                dm.addRow(aux.pac.Registro(num)); 
                aux = aux.enlace; 
            } while (aux != lista.getEnlazeCircular().lc.enlace); 
        }
    }
}
