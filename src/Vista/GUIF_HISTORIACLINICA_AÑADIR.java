/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author Roberto
 */
public class GUIF_HISTORIACLINICA_AÑADIR extends javax.swing.JPanel {

    /**
     * Creates new form GUIF_PRUEBA_HISTORIA_AÑADIR
     */
    public GUIF_HISTORIACLINICA_AÑADIR() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_guadar = new javax.swing.JButton();
        lbl_generoCliente = new javax.swing.JLabel();
        lbl_nombreCliente = new javax.swing.JLabel();
        lbl_dniCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_habitos = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txa_atencedentesPersonales = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_alergias = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txa_atencedentesFamiliares = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txa_tratamientosPrevios = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txa_HistorialQuirurjico = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        txa_medicamento = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txa_vacunas = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        txa_examenesRealizados = new javax.swing.JTextArea();
        txt_codigoHistoria = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(900, 550));

        btn_guadar.setText("GUARDAR");

        lbl_generoCliente.setText("GENERO:");

        lbl_nombreCliente.setText("NOMBRE:");

        lbl_dniCliente.setText("DNI:");

        txa_habitos.setColumns(20);
        txa_habitos.setRows(5);
        txa_habitos.setBorder(javax.swing.BorderFactory.createTitledBorder("HABITOS"));
        jScrollPane1.setViewportView(txa_habitos);

        txa_atencedentesPersonales.setColumns(20);
        txa_atencedentesPersonales.setRows(5);
        txa_atencedentesPersonales.setBorder(javax.swing.BorderFactory.createTitledBorder("ANTECEDENTES PERSONALES"));
        jScrollPane2.setViewportView(txa_atencedentesPersonales);

        txa_alergias.setColumns(20);
        txa_alergias.setRows(5);
        txa_alergias.setBorder(javax.swing.BorderFactory.createTitledBorder("ALERGIAS"));
        jScrollPane3.setViewportView(txa_alergias);

        txa_atencedentesFamiliares.setColumns(20);
        txa_atencedentesFamiliares.setRows(5);
        txa_atencedentesFamiliares.setBorder(javax.swing.BorderFactory.createTitledBorder("ANTECEDENTES FAMILIARES"));
        jScrollPane4.setViewportView(txa_atencedentesFamiliares);

        txa_tratamientosPrevios.setColumns(20);
        txa_tratamientosPrevios.setRows(5);
        txa_tratamientosPrevios.setBorder(javax.swing.BorderFactory.createTitledBorder("TRATAMINETOS PREVIOS"));
        jScrollPane5.setViewportView(txa_tratamientosPrevios);

        txa_HistorialQuirurjico.setColumns(20);
        txa_HistorialQuirurjico.setRows(5);
        txa_HistorialQuirurjico.setBorder(javax.swing.BorderFactory.createTitledBorder("HISTORIAL QUIRURJICO"));
        jScrollPane6.setViewportView(txa_HistorialQuirurjico);

        txa_medicamento.setColumns(20);
        txa_medicamento.setRows(5);
        txa_medicamento.setBorder(javax.swing.BorderFactory.createTitledBorder("MEDICAMENTOS ACTUALES"));
        jScrollPane7.setViewportView(txa_medicamento);

        txa_vacunas.setColumns(20);
        txa_vacunas.setRows(5);
        txa_vacunas.setBorder(javax.swing.BorderFactory.createTitledBorder("VACUNAS"));
        jScrollPane8.setViewportView(txa_vacunas);

        txa_examenesRealizados.setColumns(20);
        txa_examenesRealizados.setRows(5);
        txa_examenesRealizados.setBorder(javax.swing.BorderFactory.createTitledBorder("EXAMENES REALIZADOS"));
        jScrollPane9.setViewportView(txa_examenesRealizados);

        txt_codigoHistoria.setBorder(javax.swing.BorderFactory.createTitledBorder("CODIGO"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_generoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addComponent(btn_guadar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_codigoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_nombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_dniCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_generoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_codigoHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_guadar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane8))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_guadar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public javax.swing.JLabel lbl_dniCliente;
    public javax.swing.JLabel lbl_generoCliente;
    public javax.swing.JLabel lbl_nombreCliente;
    public javax.swing.JTextArea txa_HistorialQuirurjico;
    public javax.swing.JTextArea txa_alergias;
    public javax.swing.JTextArea txa_atencedentesFamiliares;
    public javax.swing.JTextArea txa_atencedentesPersonales;
    public javax.swing.JTextArea txa_examenesRealizados;
    public javax.swing.JTextArea txa_habitos;
    public javax.swing.JTextArea txa_medicamento;
    public javax.swing.JTextArea txa_tratamientosPrevios;
    public javax.swing.JTextArea txa_vacunas;
    public javax.swing.JTextField txt_codigoHistoria;
    // End of variables declaration//GEN-END:variables
}
