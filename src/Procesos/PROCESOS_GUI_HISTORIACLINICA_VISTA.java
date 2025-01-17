package Procesos;

import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Vista.GUIF_HISTORIACLINICA_VER;
import javax.swing.table.DefaultTableModel;


public class PROCESOS_GUI_HISTORIACLINICA_VISTA {
    
    private GUIF_HISTORIACLINICA_VER vista;

    public PROCESOS_GUI_HISTORIACLINICA_VISTA(GUIF_HISTORIACLINICA_VER vista) {
        this.vista = vista;
    }
    
    public void mostrarLista(ListaPilaHistoriaClinica lista){
        String titulos [] = {"ID","CODIGO","PACIENTE","FECHA"};
        DefaultTableModel dtm = new DefaultTableModel(null,titulos);
        vista.tabla.setModel(dtm);
        for (int i = 0; i < lista.getPila().size(); i++) {
            dtm.addRow(lista.getPila().get(i).Registro(i+1));
        }
    }
}
