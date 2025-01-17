
package Procesos;

import Vista.GUIF_IMPRIMIR_HC;


public class PROCESOS_GUI_IMPRIMIR_HC {
    private GUIF_IMPRIMIR_HC vista;

    public PROCESOS_GUI_IMPRIMIR_HC(GUIF_IMPRIMIR_HC vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Imprimir Historia Clinica");
        vista.setVisible(true);
    }
    
    public void CargarHistoriaClinica(String t){
        vista.TXTA_DETALLEHISTORIA.setText(t);
    }
    
    public String getNombrePaciente(){
        return vista.TXT_NOMBREPACIENTE.getText();
    }
    
    public String getDniPaciente(){
        return vista.TXT_DNIPACIENTE.getText();
    }
}
