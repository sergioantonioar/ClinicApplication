package Procesos;

import Vista.GUIF_HISTORIACLINICA;
/**
 *
 * @author SERGIO
 */
public class PROCESOS_GUI_HISTORIACLINICA{
    
    private GUIF_HISTORIACLINICA vista;

    public PROCESOS_GUI_HISTORIACLINICA(GUIF_HISTORIACLINICA vista) {
        this.vista = vista;
    }
    
    public void Presentacion(){
        vista.setTitle("Historia Clínica...");
        vista.setVisible(true);
    }
    
}
