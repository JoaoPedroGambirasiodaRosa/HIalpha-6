/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hardwareinventory;

import java.awt.Color;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author s.lucas
 */
public class cadHardware extends javax.swing.JInternalFrame {

    /**
     * Creates new form cadHardware
     */
    public cadHardware() {
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
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSK = new javax.swing.JTextField();
        txtHardware = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        boxCategory = new javax.swing.JComboBox<>();
        boxStats = new javax.swing.JComboBox<>();
        boxBrand = new javax.swing.JComboBox<>();
        txtDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCharacteristics = new javax.swing.JTextArea();

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Swis721 Cn BT", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CADASTROS DE HARDWARE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, -1));

        jPanel9.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Swis721 Cn BT", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Todos os Direitos Reservados a J.P.G.R ©");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 195, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 470, 20));

        txtSK.setEditable(false);
        txtSK.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSK.setForeground(new java.awt.Color(153, 153, 153));
        txtSK.setText("Insira a Serial Key do Hardware:");
        txtSK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSKMousePressed(evt);
            }
        });
        txtSK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSKActionPerformed(evt);
            }
        });
        jPanel1.add(txtSK, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 300, -1));

        txtHardware.setEditable(false);
        txtHardware.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHardware.setForeground(new java.awt.Color(153, 153, 153));
        txtHardware.setText("Insira seu Hardware: ");
        txtHardware.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtHardwareMousePressed(evt);
            }
        });
        txtHardware.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHardwareActionPerformed(evt);
            }
        });
        jPanel1.add(txtHardware, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, -1));

        txtModel.setEditable(false);
        txtModel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtModel.setForeground(new java.awt.Color(153, 153, 153));
        txtModel.setText("Insira o modelo:");
        txtModel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtModelMousePressed(evt);
            }
        });
        txtModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelActionPerformed(evt);
            }
        });
        jPanel1.add(txtModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 140, -1));

        boxCategory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CATEGORIA" }));
        jPanel1.add(boxCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 110, -1));

        boxStats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boxStats.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESTADO", "NOVO", "USADO ", "QUEBRADO" }));
        jPanel1.add(boxStats, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 110, -1));

        boxBrand.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boxBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MARCA" }));
        jPanel1.add(boxBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 110, -1));

        txtDate.setEditable(false);
        txtDate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                txtDateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        txtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDateActionPerformed(evt);
            }
        });
        jPanel1.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 140, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eraser.png"))); // NOI18N
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Save.png"))); // NOI18N
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        txtPrice.setEditable(false);
        txtPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrice.setForeground(new java.awt.Color(153, 153, 153));
        txtPrice.setText("Insira o Preço:");
        txtPrice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtPriceMousePressed(evt);
            }
        });
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, -1));

        txtCharacteristics.setEditable(false);
        txtCharacteristics.setColumns(20);
        txtCharacteristics.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCharacteristics.setForeground(new java.awt.Color(153, 153, 153));
        txtCharacteristics.setRows(5);
        txtCharacteristics.setText("Insira as Caracteristicas do Hardware:");
        txtCharacteristics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtCharacteristicsMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtCharacteristics);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 300, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

boolean a = false;
boolean b = false;
boolean c = false;
boolean d = false;
boolean e = false;

    private void txtSKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSKActionPerformed

    private void txtHardwareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHardwareActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHardwareActionPerformed

    private void txtModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelActionPerformed

    private void txtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtHardwareMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHardwareMousePressed
if(a==false){ 
        txtHardware.setText(null);
        txtHardware.setEditable(true);
        txtHardware.setForeground(Color.black);
        a = true;
      }else{if(txtHardware.getText().equals("")&& txtHardware.isFocusOwner()==false){txtHardware.setText("Insira seu Hardware:");
        txtHardware.setEditable(false);
        txtHardware.setForeground(Color.LIGHT_GRAY);
        a = false;}}
    }//GEN-LAST:event_txtHardwareMousePressed

    private void txtModelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtModelMousePressed
if(b==false){ 
        txtModel.setText(null);
        txtModel.setEditable(true);
        txtModel.setForeground(Color.black);
        b = true;
      }else{if(txtModel.getText().equals("")&& txtModel.isFocusOwner()==false){txtModel.setText("Insira o Modelo:");
        txtModel.setEditable(false);
        txtModel.setForeground(Color.LIGHT_GRAY);
        b = false;}}
    }//GEN-LAST:event_txtModelMousePressed

    private void txtPriceMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPriceMousePressed
if(c==false){ 
        txtPrice.setText(null);
        txtPrice.setEditable(true);
        txtPrice.setForeground(Color.black);
        c = true;
      }else{if(txtPrice.getText().equals("")&& txtPrice.isFocusOwner()==false){txtPrice.setText("Insira o Preço:");
        txtPrice.setEditable(false);
        txtPrice.setForeground(Color.LIGHT_GRAY);
        c = false;}}
    }//GEN-LAST:event_txtPriceMousePressed

    private void txtDateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txtDateAncestorAdded
LocalDateTime Datee = LocalDateTime.now();
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
txtDate.setText(formato.format(Datee));
    }//GEN-LAST:event_txtDateAncestorAdded

    private void txtSKMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSKMousePressed
if(d==false){ 
        txtSK.setText(null);
        txtSK.setEditable(true);
        txtSK.setForeground(Color.black);
        d = true;
      }else{if(txtSK.getText().equals("")&& txtSK.isFocusOwner()==false){txtSK.setText("Insira a Serial Key do Hardware:");
        txtSK.setEditable(false);
        txtSK.setForeground(Color.LIGHT_GRAY);
        d = false;}}
    }//GEN-LAST:event_txtSKMousePressed

    private void txtCharacteristicsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCharacteristicsMousePressed
if(e==false){ 
        txtCharacteristics.setText(null);
        txtCharacteristics.setEditable(true);
        txtCharacteristics.setForeground(Color.black);
        e = true;
      }else{if(txtCharacteristics.getText().equals("")&& txtCharacteristics.isFocusOwner()==false){txtCharacteristics.setText("Insira as Caracteristicas do Hardware:");
        txtCharacteristics.setEditable(false);
        txtCharacteristics.setForeground(Color.LIGHT_GRAY);
        e = false;}}
    }//GEN-LAST:event_txtCharacteristicsMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxBrand;
    private javax.swing.JComboBox<String> boxCategory;
    private javax.swing.JComboBox<String> boxStats;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCharacteristics;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtHardware;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSK;
    // End of variables declaration//GEN-END:variables
}