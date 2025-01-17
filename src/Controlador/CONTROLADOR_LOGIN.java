package Controlador;

import Estructura.Doctor.ListaNodoEnlazados;
import Login.Admin;
import Modelo.Doctor;
import Vista.GUI_LOGIN;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class CONTROLADOR_LOGIN implements ActionListener{
    
    private GUI_LOGIN vista;
   
    
    private Doctor doctor= new Doctor();
    
    public CONTROLADOR_LOGIN() {
        vista=new GUI_LOGIN();
        vista.BTN_LOGIN.addActionListener(this);
        vista.setTitle("Ingreso al Sistema");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.BTN_LOGIN){
            if(ConprobacionAdmin() == true){
                
                String usu = vista.TXT_USER.getText();
                CONTROLADOR_MENU fm= new CONTROLADOR_MENU(this);

                fm.getVistaMenu().NavAtencion.setEnabled(false);
                
                fm.getVistaMenu().setVisible(true);
                fm.getVistaMenu().setTitle(usu.toUpperCase()+" : Aplicación del curso de Estructura de datos");
                fm.getVistaMenu().setExtendedState(JFrame.MAXIMIZED_BOTH);
                vista.setVisible(false);
                
            }else if(ComprobacionDoctor()==true){
                
                String usu = doctor.getNombres();
                CONTROLADOR_MENU fm= new CONTROLADOR_MENU(this);
                
                //Bloqueo de Menu a doctor
                fm.getVistaMenu().NavPaciente.setEnabled(false);
                fm.getVistaMenu().NavDoc.setEnabled(false);
                fm.getVistaMenu().NavEspecialidad.setEnabled(false);
                
                fm.getVistaMenu().setVisible(true);
                fm.getVistaMenu().setTitle("Bienvenido: "+usu+" : Aplicación del curso de Estructura de datos");
                fm.getVistaMenu().setExtendedState(JFrame.MAXIMIZED_BOTH);
                vista.setVisible(false);
            }     
        }
    }
    
    public boolean ConprobacionAdmin(){
        Admin a = new Admin();
        
        String user=vista.TXT_USER.getText();
        String contraseña=vista.TXT_CONTRASEÑA.getText();
        
        if (a.getUser().equals(user) && a.getContraseña().equals(contraseña)) {
            System.out.println("Usuario autenticado: " + a.getUser());
            return true;
        } else {
            System.out.println("Error: Usuario o contraseña incorrectos.");
            return false;
        }
    }
    
    public boolean ComprobacionDoctor(){
        
        ListaNodoEnlazados listaDoctor =new ListaNodoEnlazados();
        
        String user=vista.TXT_USER.getText();
        String contraseña=vista.TXT_CONTRASEÑA.getText();
        
        if(listaDoctor.VerificarSesion(contraseña, user)){
            doctor=listaDoctor.getEnlaze().Buscar_Doctor_Sesion(contraseña, user).getdoctor();
            return true;
        }else{
            return false;
        }
    }
    
    public void LimpiezaLogin(){
        vista.TXT_USER.setText("");
        vista.TXT_CONTRASEÑA.setText("");
    }

    public Doctor SesionDoctor() {
        return doctor;
    }
    
    public void CerrarSesion(){
        doctor=null;
    }

    public GUI_LOGIN getVista() {
        return vista;
    }
}
