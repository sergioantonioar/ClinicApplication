/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author robert
 */
public class GUI_MENU extends javax.swing.JFrame {

    /**
     * Creates new form GUI_MENU
     */
    public GUI_MENU() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Recursos/logoclinica200.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JDP_ESCRITORIO = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        NavPaciente = new javax.swing.JMenu();
        PACIENTE_GESTION = new javax.swing.JMenuItem();
        NavDoc = new javax.swing.JMenu();
        DOCTOR_GESTION = new javax.swing.JMenuItem();
        NavEspecialidad = new javax.swing.JMenu();
        ESPECIALIDAD_GESTION = new javax.swing.JMenuItem();
        NavAtencion = new javax.swing.JMenu();
        ATENCION_GESTION = new javax.swing.JMenuItem();
        NavHistoriaClinica = new javax.swing.JMenu();
        HISTORIACLINICA_GESTION = new javax.swing.JMenuItem();
        BTN_IMPRIMIR_HC = new javax.swing.JMenuItem();
        NavReportes = new javax.swing.JMenu();
        BUSQ_DOCTOR = new javax.swing.JMenuItem();
        BUSQ_ESPECIALIDAD = new javax.swing.JMenuItem();
        CERRAR_SESION = new javax.swing.JMenu();
        EXIT = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout JDP_ESCRITORIOLayout = new javax.swing.GroupLayout(JDP_ESCRITORIO);
        JDP_ESCRITORIO.setLayout(JDP_ESCRITORIOLayout);
        JDP_ESCRITORIOLayout.setHorizontalGroup(
            JDP_ESCRITORIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        JDP_ESCRITORIOLayout.setVerticalGroup(
            JDP_ESCRITORIOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 527, Short.MAX_VALUE)
        );

        jMenuBar1.setMaximumSize(new java.awt.Dimension(1050, 32769));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(1050, 52));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1050, 52));

        NavPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/paciente.png"))); // NOI18N
        NavPaciente.setText("PACIENTE");
        NavPaciente.setPreferredSize(new java.awt.Dimension(150, 50));

        PACIENTE_GESTION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        PACIENTE_GESTION.setText("GESTIONAR");
        PACIENTE_GESTION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PACIENTE_GESTIONActionPerformed(evt);
            }
        });
        NavPaciente.add(PACIENTE_GESTION);

        jMenuBar1.add(NavPaciente);

        NavDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/doctor.png"))); // NOI18N
        NavDoc.setText("DOCTORES");
        NavDoc.setPreferredSize(new java.awt.Dimension(150, 50));

        DOCTOR_GESTION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        DOCTOR_GESTION.setText("GESTIONAR");
        NavDoc.add(DOCTOR_GESTION);

        jMenuBar1.add(NavDoc);

        NavEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/especialidades.png"))); // NOI18N
        NavEspecialidad.setText("ESPECIALIDADES");
        NavEspecialidad.setPreferredSize(new java.awt.Dimension(150, 50));

        ESPECIALIDAD_GESTION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        ESPECIALIDAD_GESTION.setText("GESTIONAR");
        NavEspecialidad.add(ESPECIALIDAD_GESTION);

        jMenuBar1.add(NavEspecialidad);

        NavAtencion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/atencion-medica.png"))); // NOI18N
        NavAtencion.setText("ATENCIONES");
        NavAtencion.setPreferredSize(new java.awt.Dimension(150, 50));

        ATENCION_GESTION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        ATENCION_GESTION.setText("GESTIONAR");
        NavAtencion.add(ATENCION_GESTION);

        jMenuBar1.add(NavAtencion);

        NavHistoriaClinica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/historia-clinica.png"))); // NOI18N
        NavHistoriaClinica.setText("HISTORIAS CLINICAS");
        NavHistoriaClinica.setPreferredSize(new java.awt.Dimension(150, 50));

        HISTORIACLINICA_GESTION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        HISTORIACLINICA_GESTION.setText("GESTIONAR");
        NavHistoriaClinica.add(HISTORIACLINICA_GESTION);

        BTN_IMPRIMIR_HC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        BTN_IMPRIMIR_HC.setText("IMPRIMIR");
        NavHistoriaClinica.add(BTN_IMPRIMIR_HC);

        jMenuBar1.add(NavHistoriaClinica);

        NavReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/reportes.png"))); // NOI18N
        NavReportes.setText("BUSQUEDAS");
        NavReportes.setPreferredSize(new java.awt.Dimension(150, 50));

        BUSQ_DOCTOR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        BUSQ_DOCTOR.setText("POR DOCTOR");
        NavReportes.add(BUSQ_DOCTOR);

        BUSQ_ESPECIALIDAD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/buscar.png"))); // NOI18N
        BUSQ_ESPECIALIDAD.setText("POR ESPECIALIDAD");
        NavReportes.add(BUSQ_ESPECIALIDAD);

        jMenuBar1.add(NavReportes);

        CERRAR_SESION.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/salida.png"))); // NOI18N
        CERRAR_SESION.setText("CERRAR SESION");
        CERRAR_SESION.setPreferredSize(new java.awt.Dimension(150, 50));

        EXIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/gestion-pacientes.png"))); // NOI18N
        EXIT.setText("EXIT");
        CERRAR_SESION.add(EXIT);

        jMenuBar1.add(CERRAR_SESION);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP_ESCRITORIO)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JDP_ESCRITORIO)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PACIENTE_GESTIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PACIENTE_GESTIONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PACIENTE_GESTIONActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_MENU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem ATENCION_GESTION;
    public javax.swing.JMenuItem BTN_IMPRIMIR_HC;
    public javax.swing.JMenuItem BUSQ_DOCTOR;
    public javax.swing.JMenuItem BUSQ_ESPECIALIDAD;
    public javax.swing.JMenu CERRAR_SESION;
    public javax.swing.JMenuItem DOCTOR_GESTION;
    public javax.swing.JMenuItem ESPECIALIDAD_GESTION;
    public javax.swing.JMenuItem EXIT;
    public javax.swing.JMenuItem HISTORIACLINICA_GESTION;
    public javax.swing.JDesktopPane JDP_ESCRITORIO;
    public javax.swing.JMenu NavAtencion;
    public javax.swing.JMenu NavDoc;
    public javax.swing.JMenu NavEspecialidad;
    public javax.swing.JMenu NavHistoriaClinica;
    public javax.swing.JMenu NavPaciente;
    public javax.swing.JMenu NavReportes;
    public javax.swing.JMenuItem PACIENTE_GESTION;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
