/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UI;

import com.DAO.DichVuDAO;
import com.DAO.LoaiDichVuDAO;
import com.Entity.DichVu;
import com.Entity.LoaiDichVu;
import com.utils.MsgBox;
import com.utils.XImage;
import java.awt.Image;
import java.io.File;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DichVuUI extends javax.swing.JFrame {

    String anh = "";

    public DichVuUI() {
        initComponents();
        this.setVisible(true);
        init();
    }
    JFileChooser chooser = new JFileChooser();
    int index = -1;
     File file;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        txtgia1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DichVu = new javax.swing.JTable();
        kButton1 = new com.k33ptoo.components.KButton();
        kButton2 = new com.k33ptoo.components.KButton();
        kButton3 = new com.k33ptoo.components.KButton();
        kButton4 = new com.k33ptoo.components.KButton();
        lblKetThuc = new javax.swing.JLabel();
        lblThuLai = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbo_LoaiDV = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtTenDichVu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        lblHinh = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DỊch Vụ");
        setUndecorated(true);

        txtgia1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtgia1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtgia1FocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tên DV:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        tbl_DichVu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tbl_DichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã DV", "Tên loại DV", "Tên DV", "Đơn giá", "Hình"
            }
        ));
        tbl_DichVu.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_DichVu.setRowHeight(20);
        tbl_DichVu.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_DichVu.setShowHorizontalLines(false);
        tbl_DichVu.setShowVerticalLines(false);
        tbl_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DichVuMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DichVu);

        kButton1.setText("Thêm");
        kButton1.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        kButton1.setkSelectedColor(new java.awt.Color(153, 0, 153));
        kButton1.setkStartColor(new java.awt.Color(0, 153, 255));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        kButton2.setText("Xóa");
        kButton2.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        kButton2.setkSelectedColor(new java.awt.Color(153, 0, 153));
        kButton2.setkStartColor(new java.awt.Color(0, 153, 255));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        kButton3.setText("Sửa");
        kButton3.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        kButton3.setkSelectedColor(new java.awt.Color(153, 0, 153));
        kButton3.setkStartColor(new java.awt.Color(0, 153, 255));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });

        kButton4.setText("Mới");
        kButton4.setkEndColor(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        kButton4.setkSelectedColor(new java.awt.Color(153, 0, 153));
        kButton4.setkStartColor(new java.awt.Color(0, 153, 255));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        lblKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetThuc.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/close_1.png"))
        );
        lblKetThuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKetThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetThucMouseClicked(evt);
            }
        });

        lblThuLai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThuLai.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/minus.png"))
        );
        lblThuLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThuLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThuLaiMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dịch vụ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tên loại DV:");

        txtTenDichVu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtTenDichVu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenDichVuFocusLost(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Đơn giá:");

        lblHinh.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblHinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblHinhMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Chọn hình:");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_LoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblHinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtgia1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbo_LoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtgia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(lblHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)))
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(DichVuUI.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        if (checkForm() == false) {
            return;
        }
       insert();
       XImage.save(file);
       MsgBox.alert(this,"Thêm thành công");

    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        if (index == -1) {
           MsgBox.alert(this,"Vui lòng chọn dịch vụ muốn xóa");

            return;
        }
        delete();
        MsgBox.alert(this,"Xóa thành công");

    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed
        if (index == -1) {
           MsgBox.alert(this,"Vui lòng chọn dịch vụ muốn cập nhật");
            return;
        }
        update();
        XImage.save(file);
        MsgBox.alert(this,"Cập nhật thành công");


    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
        // TODO add your handling code here:
        clearFrom();
    }//GEN-LAST:event_kButton4ActionPerformed

    private void txtgia1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtgia1FocusLost

    }//GEN-LAST:event_txtgia1FocusLost

    private void txtTenDichVuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenDichVuFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDichVuFocusLost

    private void tbl_DichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DichVuMousePressed
        index = tbl_DichVu.getSelectedRow();
        setForm();
    }//GEN-LAST:event_tbl_DichVuMousePressed

    private void lblHinhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMousePressed
       chooseImage();
    }//GEN-LAST:event_lblHinhMousePressed
    
    public void chooseImage(){
        
           if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
            file = chooser.getSelectedFile();
            lblHinh.setIcon(Resize(file.getAbsolutePath()));
            anh = chooser.getSelectedFile().getName();
           }
        
    }
    
    public ImageIcon Resize(String ImagePath) {
        ImageIcon myimage = new ImageIcon(ImagePath);
        Image img = myimage.getImage();
        Image newImg = img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DichVuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DichVuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DichVuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DichVuUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DichVuUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_LoaiDV;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private com.k33ptoo.components.KButton kButton1;
    private com.k33ptoo.components.KButton kButton2;
    private com.k33ptoo.components.KButton kButton3;
    private com.k33ptoo.components.KButton kButton4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JTable tbl_DichVu;
    private javax.swing.JTextField txtTenDichVu;
    private javax.swing.JTextField txtgia1;
    // End of variables declaration//GEN-END:variables
    DichVuDAO dichVuDao = new DichVuDAO();
    LoaiDichVuDAO loaiDichVuDao = new LoaiDichVuDAO();
    NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
    int row = -1;
    List<DichVu> list = dichVuDao.selectAll();

    private void init() {
        this.setLocationRelativeTo(null);
        filltable();
        fillComboboxDichVu();
    }

    public void fillComboboxDichVu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_LoaiDV.getModel();
        model.removeAllElements();
        List<LoaiDichVu> list = loaiDichVuDao.selectAll();
        for (LoaiDichVu dv : list) {
            model.addElement(dv);
        }
        model.toString();
    }

    public void filltable() {
        DefaultTableModel model = (DefaultTableModel) tbl_DichVu.getModel();
        model.setRowCount(0);
        try {
            list = dichVuDao.selectAll();
            for (DichVu dv : list) {
                String tenDichVu = loaiDichVuDao.selectById(dv.getMaLoai()).getTenLoai();
                Object[] row = {dv.getMaDV(), tenDichVu, dv.getTenDV(), nf.format(dv.getGia()), dv.getHinh()};
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkForm() {
        if (txtTenDichVu.getText().trim().isEmpty()) {
            MsgBox.alert(this,"Không để trống tên dịch vụ");
            return false;
        }
        try {
            float gia = Float.parseFloat(txtgia1.getText());
            if (gia <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            MsgBox.alert(this,"Giá không hợp lệ");
            return false;
        }

        return true;
    }

    public DichVu getForm() {
        DichVu dv = new DichVu();
        LoaiDichVu dv2 = (LoaiDichVu) cbo_LoaiDV.getSelectedItem();
        dv.setTenDV(txtTenDichVu.getText());
        dv.setGia(Float.parseFloat(txtgia1.getText()));
        dv.setMaLoai(dv2.getMaLoai());
        dv.setHinh(anh);
        return dv;
    }

    public void loadImage(String image) {
        ImageIcon myimage = new ImageIcon("src/main/java/image/"+image);
        Image img = myimage.getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), Image.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
    }

    public void setForm() {
        String tenDichVu = tbl_DichVu.getValueAt(index, 2).toString();
        float donGia = list.get(index).getGia();
        txtTenDichVu.setText(tenDichVu);
        txtgia1.setText(donGia + "");
        LoaiDichVu dv = loaiDichVuDao.selectById(list.get(index).getMaLoai());
        cbo_LoaiDV.getModel().setSelectedItem(dv);
        loadImage(tbl_DichVu.getValueAt(index, 4).toString());
    }

    void clearFrom() {
        txtTenDichVu.setText("");
        txtgia1.setText("");
    }

    void insert() {

        DichVu dv = getForm();
        dichVuDao.insert(dv);
        this.filltable();
        this.clearFrom();

    }

    public DichVu getFormUpdate() {
        DichVu dv = new DichVu();
        LoaiDichVu dv2 = (LoaiDichVu) cbo_LoaiDV.getSelectedItem();
        dv.setTenDV(txtTenDichVu.getText());
        dv.setGia(Float.parseFloat(txtgia1.getText()));
        dv.setMaLoai(dv2.getMaLoai());
        dv.setMaDV(list.get(index).getMaDV());
        dv.setHinh(anh);
        return dv;
    }

    public void update() {
        if (checkForm() == false) {
            return;
        }
        DichVu dv = getFormUpdate();
        dichVuDao.update(dv);
        this.filltable();
    }

    public void delete() {
        int maDV = Integer.parseInt(tbl_DichVu.getValueAt(index, 0).toString());
        dichVuDao.delete(maDV);
        filltable();
    }

   

}
