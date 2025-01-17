package Controlador;

import Modelo.Doctor;
import Servicios.ImgFontGuiMenu;
import Vista.GUI_MENU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class CONTROLADOR_MENU implements ActionListener {

    private GUI_MENU vista;
    private CONTROLADOR_LOGIN login;

    public CONTROLADOR_MENU(CONTROLADOR_LOGIN login) {
        this.login = login;
        vista = new GUI_MENU();
        vista.ATENCION_GESTION.addActionListener(this);
        vista.ATENCION_GESTION.addActionListener(this);
        vista.EXIT.addActionListener(this);
        vista.DOCTOR_GESTION.addActionListener(this);
        vista.ESPECIALIDAD_GESTION.addActionListener(this);
        vista.HISTORIACLINICA_GESTION.addActionListener(this);
        vista.PACIENTE_GESTION.addActionListener(this);
        
        vista.BTN_IMPRIMIR_HC.addActionListener(this);
        
        vista.BUSQ_DOCTOR.addActionListener(this);
        vista.BUSQ_ESPECIALIDAD.addActionListener(this);

        //agregamos imagen como fondo de jdesktoppane
        vista.JDP_ESCRITORIO.setBorder(new ImgFontGuiMenu());
        if (vista instanceof JFrame) {
            ((JFrame) vista).setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }

    private void MostrarFrame(JInternalFrame frame) {
        vista.JDP_ESCRITORIO.removeAll();
        vista.JDP_ESCRITORIO.add(frame);
        vista.JDP_ESCRITORIO.repaint();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.ATENCION_GESTION) {
            
            CONTROLADOR_ATENCION ca = new CONTROLADOR_ATENCION(LoginDoctor());
            MostrarFrame(ca.getVista());
            
        } else if (e.getSource() == vista.EXIT) {
            login.getVista().setVisible(true);
            vista.setVisible(false);
            login.LimpiezaLogin();
            login.CerrarSesion();
        } else if (e.getSource() == vista.DOCTOR_GESTION) {          
            CONTROLADOR_DOCTOR cd = new CONTROLADOR_DOCTOR();
            MostrarFrame(cd.getVista());
        } else if (e.getSource() == vista.ESPECIALIDAD_GESTION) {
            CONTROLADOR_ESPEC ce = new CONTROLADOR_ESPEC();
            MostrarFrame(ce.getVista());
        } else if (e.getSource() == vista.HISTORIACLINICA_GESTION) {
            CONTROLADOR_HISTORIACLINICA ch = new CONTROLADOR_HISTORIACLINICA();
            MostrarFrame(ch.getVista());
        } else if (e.getSource() == vista.PACIENTE_GESTION) {
            CONTROLADOR_PACIENTE cp = new CONTROLADOR_PACIENTE();
            MostrarFrame(cp.getVista());
        } else if (e.getSource() == vista.BUSQ_DOCTOR) {
            CONTROLADOR_BUSQ_DOCTOR cbd = new CONTROLADOR_BUSQ_DOCTOR();
            MostrarFrame(cbd.getVista());
        } else if (e.getSource() == vista.BUSQ_ESPECIALIDAD) {
            CONTROLADOR_BUSQ_ESPEC cbe = new CONTROLADOR_BUSQ_ESPEC();
            MostrarFrame(cbe.getVista());
        } else if (e.getSource() == vista.BTN_IMPRIMIR_HC){
            CONTROLADOR_IMPRIMIR_HC Ich=new CONTROLADOR_IMPRIMIR_HC();
            MostrarFrame(Ich.getVista());
        }
    }

    public GUI_MENU getVistaMenu() {
        return vista;
    }

    public Doctor LoginDoctor() {
        return login.SesionDoctor();
    }   
}
