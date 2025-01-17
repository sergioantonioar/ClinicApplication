package Vista;

/**
 *
 * @author AguidoRin
 */
public class GUIF_BUSQUEDA_DOCTOR extends javax.swing.JInternalFrame {
    public GUIF_BUSQUEDA_DOCTOR() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BTN_BUSCAR = new javax.swing.JButton();
        TXT_COD_MEDICO = new javax.swing.JTextField();
        JDC_FECHA_BUSQ = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBL_ATENCIONES = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 1, 20)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Buscar Atención");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Sección", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Book Antiqua", 0, 14))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 12, 215, -1));

        BTN_BUSCAR.setBackground(new java.awt.Color(0, 153, 153));
        BTN_BUSCAR.setFont(new java.awt.Font("Dubai Medium", 1, 14)); // NOI18N
        BTN_BUSCAR.setText("BUSCAR");
        jPanel1.add(BTN_BUSCAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 150, 50));

        TXT_COD_MEDICO.setBackground(new java.awt.Color(204, 255, 255));
        TXT_COD_MEDICO.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        TXT_COD_MEDICO.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Código médico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        TXT_COD_MEDICO.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TXT_COD_MEDICO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_COD_MEDICOActionPerformed(evt);
            }
        });
        jPanel1.add(TXT_COD_MEDICO, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 180, 50));

        JDC_FECHA_BUSQ.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel1.add(JDC_FECHA_BUSQ, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 157, 50));

        TBL_ATENCIONES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código atención", "Dni Paciente", "Fecha", "Especialidad", "Doctor", "Descripcion Atencion"
            }
        ));
        jScrollPane4.setViewportView(TBL_ATENCIONES);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 910, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_COD_MEDICOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_COD_MEDICOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_COD_MEDICOActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BTN_BUSCAR;
    public com.toedter.calendar.JDateChooser JDC_FECHA_BUSQ;
    public javax.swing.JTable TBL_ATENCIONES;
    public javax.swing.JTextField TXT_COD_MEDICO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}