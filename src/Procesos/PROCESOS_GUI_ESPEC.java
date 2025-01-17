package Procesos;

import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Especialidad;
import Vista.GUIF_AGREGAR_ESPEC;
import javax.swing.table.DefaultTableModel;


public class PROCESOS_GUI_ESPEC {
    private GUIF_AGREGAR_ESPEC vista;

    public PROCESOS_GUI_ESPEC(GUIF_AGREGAR_ESPEC vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Gestion de Especialidad");
        vista.setVisible(true);
    }
    
    public Especialidad CrearEspecialidad(){
        Especialidad e = new Especialidad();
        e.setCodigo(vista.TXT_CODIGO.getText());
        e.setNombre(vista.TXT_ESPECIALIDAD.getText());
        return e;
    }
    
    public void limpiarEntradasEspecialidad() {
        vista.TXT_CODIGO.setText("");
        vista.TXT_ESPECIALIDAD.setText("");
    }
    
    public void cargarEspecialidad(Especialidad especialidad) {
        vista.TXT_CODIGO.setText(especialidad.getCodigo());
        vista.TXT_ESPECIALIDAD.setText(especialidad.getNombre());
    }
    
    public String getOrdenar(){
        return vista.CBX_SELC_ORDEN.getSelectedItem().toString();
    }
    
    public void MostrarTabla(ArrayEspecialidad lista){
        String titulos[]={"ID","CODIGO","ESPECIALIDAD"};
        DefaultTableModel dtm = new DefaultTableModel(null,titulos);
        vista.TBL_TABLA.setModel(dtm); 
        
        for (int i = 0; i < lista.getContador(); i++) {
            dtm.addRow(lista.getListEspec()[i].Registrar(i+1));
        }
    }
}
