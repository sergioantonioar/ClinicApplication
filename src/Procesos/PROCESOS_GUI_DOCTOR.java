package Procesos;

import Estructura.Doctor.ListaNodoEnlazados;
import Estructura.Doctor.Nodo;
import Modelo.Doctor;
import Vista.GUIF_AGREGAR_DOCTOR;
import javax.swing.table.DefaultTableModel;

public class PROCESOS_GUI_DOCTOR {
    private GUIF_AGREGAR_DOCTOR vista;

    public PROCESOS_GUI_DOCTOR(GUIF_AGREGAR_DOCTOR vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Gestion de Doctor");
        vista.setVisible(true);
    }
    
    public Doctor CrearDoctor(){
        Doctor d = new Doctor();
        d.setCodigo(vista.TXT_CODIGO.getText());
        d.setDni(vista.TXT_DNI.getText());
        d.setNombres(vista.TXT_NOMBRE.getText());
        d.setTelefono(vista.TXT_TELEFONO.getText());
        d.setDireccion(vista.TXT_DIRECCION.getText());
        return d;
    }
    
    public void Limpiar() {
        vista.TXT_CODIGO.setText("");
        vista.TXT_DNI.setText("");
        vista.TXT_NOMBRE.setText("");
        vista.TXT_TELEFONO.setText("");
        vista.TXT_DIRECCION.setText("");
    }
    
    public void CargarDoctor(Doctor doctor) {
        vista.TXT_CODIGO.setText(doctor.getCodigo());
        vista.TXT_DNI.setText(doctor.getDni());
        vista.TXT_NOMBRE.setText(doctor.getNombres());
        vista.TXT_TELEFONO.setText(doctor.getTelefono());
        vista.TXT_DIRECCION.setText(doctor.getDireccion());
    }
    
    public String getOrdenar(){
        return vista.CBX_SELC_ORDEN.getSelectedItem().toString();
    }
    
    public boolean VerificarCampos() {
        if (vista.TXT_CODIGO.getText().isEmpty() || vista.TXT_DNI.getText().isEmpty() || 
                vista.TXT_NOMBRE.getText().isEmpty() || vista.TXT_TELEFONO.getText().isEmpty() || 
                vista.TXT_DIRECCION.getText().isEmpty()) {
            return false; 
        }
        return true; 
    }
    
    public void MostrarTabla(ListaNodoEnlazados lista){
        String[] titulos = {"ID", "DNI","CODIGO", "NOMBRE", "TELEFONO", "DIRECCION"};
        DefaultTableModel dm = new DefaultTableModel(null, titulos);
        vista.TBL_TABLA.setModel(dm);
        int cont=1;
        for (Nodo d = lista.getEnlaze().getIni(); d!=null; d=d.getSig()) {
            dm.addRow(d.getdoctor().Registro(cont++));
        }
    }
}
