/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturaunt.gui;

/**
 *
 * @author Admin
 */
public class Sides extends javax.swing.JPanel {

    /**
     * Creates new form Sides
     */
    public Sides() {
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

        Sides = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BeansB = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        SChipB = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        LChipB = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        CornB = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        CurryCB = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        CurlyFB = new javax.swing.JTextPane();
        SmallCCombo = new javax.swing.JComboBox<>();
        LargeCCombo = new javax.swing.JComboBox<>();
        CornCombo = new javax.swing.JComboBox<>();
        BeansCombo = new javax.swing.JComboBox<>();
        CurryCCombo = new javax.swing.JComboBox<>();
        CurlyCCombo = new javax.swing.JComboBox<>();
        BackToMenu = new javax.swing.JButton();

        Sides.setFont(new java.awt.Font("The Next Font", 0, 48)); // NOI18N
        Sides.setText("Sides");

        BeansB.setEditable(false);
        BeansB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BeansB.setText("beans\n\n60");
        BeansB.setToolTipText("hello");
        jScrollPane1.setViewportView(BeansB);

        SChipB.setEditable(false);
        SChipB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        SChipB.setText("small chip");
        SChipB.setToolTipText("hello");
        jScrollPane2.setViewportView(SChipB);

        LChipB.setEditable(false);
        LChipB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        LChipB.setText("large\nchip\n1.20");
        LChipB.setToolTipText("hello");
        jScrollPane3.setViewportView(LChipB);

        CornB.setEditable(false);
        CornB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CornB.setText("corn\n\n1");
        CornB.setToolTipText("hello");
        jScrollPane4.setViewportView(CornB);

        CurryCB.setEditable(false);
        CurryCB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CurryCB.setText("curly\nfries\n3");
        CurryCB.setToolTipText("hello");
        jScrollPane5.setViewportView(CurryCB);

        CurlyFB.setEditable(false);
        CurlyFB.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        CurlyFB.setText("curly\nfries\n2.00");
        CurlyFB.setToolTipText("hello");
        jScrollPane8.setViewportView(CurlyFB);

        SmallCCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        SmallCCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SmallCComboActionPerformed(evt);
            }
        });

        LargeCCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        LargeCCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LargeCComboActionPerformed(evt);
            }
        });

        CornCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        CornCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CornComboActionPerformed(evt);
            }
        });

        BeansCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        BeansCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeansComboActionPerformed(evt);
            }
        });

        CurryCCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        CurryCCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurryCComboActionPerformed(evt);
            }
        });

        CurlyCCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        CurlyCCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurlyCComboActionPerformed(evt);
            }
        });

        BackToMenu.setText("BACK");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(Sides)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CurlyCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SmallCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CornCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LargeCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BeansCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CurryCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Sides)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(SmallCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(LargeCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(CurlyCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(BeansCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(CurryCCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CornCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(BackToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SmallCComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SmallCComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SmallCComboActionPerformed

    private void LargeCComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LargeCComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LargeCComboActionPerformed

    private void CornComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CornComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CornComboActionPerformed

    private void BeansComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeansComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeansComboActionPerformed

    private void CurryCComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurryCComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurryCComboActionPerformed

    private void CurlyCComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurlyCComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurlyCComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMenu;
    private javax.swing.JTextPane BeansB;
    private javax.swing.JComboBox<String> BeansCombo;
    private javax.swing.JTextPane CornB;
    private javax.swing.JComboBox<String> CornCombo;
    private javax.swing.JComboBox<String> CurlyCCombo;
    private javax.swing.JTextPane CurlyFB;
    private javax.swing.JTextPane CurryCB;
    private javax.swing.JComboBox<String> CurryCCombo;
    private javax.swing.JTextPane LChipB;
    private javax.swing.JComboBox<String> LargeCCombo;
    private javax.swing.JTextPane SChipB;
    private javax.swing.JLabel Sides;
    private javax.swing.JComboBox<String> SmallCCombo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    // End of variables declaration//GEN-END:variables
}
