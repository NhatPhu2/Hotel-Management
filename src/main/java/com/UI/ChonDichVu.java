/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.DichVuDAO;
import com.DAO.LoaiDichVuDAO;
import com.Entity.DichVu;
import com.Entity.LoaiDichVu;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class ChonDichVu extends javax.swing.JFrame {

    /**
     * Creates new form BillUI
     */
    public ChonDichVu() {
        initComponents();
        fillComboboxDichVu();
        fill();
       
    }

    LoaiDichVuDAO loaiDichVuDao = new LoaiDichVuDAO();
    DichVuDAO dichVuDao = new DichVuDAO();
    List<JPanel> listPnlMon = new ArrayList<>();
    List<DichVu> listDichVu = dichVuDao.selectAll();
    List<JLabel> listLblGia = new ArrayList<>();
    List<JLabel> listLblTen = new ArrayList<>();
    List<LoaiDichVu> listLoaiDichVu = loaiDichVuDao.selectAll();
    NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbo_LoaiDichVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Các loại dịch vụ:");

        cbo_LoaiDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbo_LoaiDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbo_LoaiDichVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_LoaiDichVuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Tìm kiếm:");

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setLayout(new java.awt.GridLayout(0, 3, 10, 10));
        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_LoaiDichVu, 0, 306, Short.MAX_VALUE)
                            .addComponent(txtTimKiem))
                        .addGap(537, 537, 537))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbo_LoaiDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased

    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void cbo_LoaiDichVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_LoaiDichVuActionPerformed
       
        
    }//GEN-LAST:event_cbo_LoaiDichVuActionPerformed
    
    public void clearList(){
         listLblTen.clear();
        listLblGia.clear();
        listPnlMon.clear();
        jPanel2.removeAll();
        jPanel2.repaint();
        
    }
    
    public void fillTypeOfService() {
        
        LoaiDichVu dv = (LoaiDichVu) cbo_LoaiDichVu.getSelectedItem();
        listDichVu = dichVuDao.selectTypeOfService(dv.getMaLoai());
        fill();
    }

   

    public void fill() {

        for (int i = 0; i < listDichVu.size(); i++) {

            //panel để hiện thị
            listPnlMon.add(new JPanel());
            listPnlMon.get(i).setBorder(BorderFactory.createEtchedBorder());
            listPnlMon.get(i).setLayout(new GridLayout(0, 1, 0, 0));
            listPnlMon.get(i).setBackground(Color.white);
            listPnlMon.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR) {
            });

            //giá món
            listLblGia.add(new JLabel());
            listLblGia.get(i).setText(nf.format(listDichVu.get(i).getGia()) + "" + "(VNĐ)");
            listLblGia.get(i).setHorizontalAlignment(JLabel.CENTER);
            listLblGia.get(i).setVerticalTextPosition(JLabel.CENTER);
            listLblGia.get(i).setFont(new Font("Verdana", Font.PLAIN, 13));

            //tên món
            listLblTen.add(new JLabel());
            listLblTen.get(i).setText(listDichVu.get(i).getTenDV());
            listLblTen.get(i).setHorizontalAlignment(JLabel.CENTER);
            listLblTen.get(i).setVerticalTextPosition(JLabel.CENTER);
            listLblTen.get(i).setFont(new Font("Verdana", Font.PLAIN, 13));

            listPnlMon.get(i).add(listLblTen.get(i));
            listPnlMon.get(i).add(listLblGia.get(i));
            jPanel2.add(listPnlMon.get(i));

        }
        this.setVisible(true);
    }

    public void fillAll() {
        
        listDichVu = dichVuDao.selectAll();
        fill();
    }

    public void fillComboboxDichVu() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_LoaiDichVu.getModel();
        listLoaiDichVu = loaiDichVuDao.selectAll();
        for (int i = 0; i < listLoaiDichVu.size(); i++) {
            model.addElement(listLoaiDichVu.get(i));
        }
        model.toString();
    }

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
            java.util.logging.Logger.getLogger(ChonDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChonDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChonDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChonDichVu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChonDichVu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbo_LoaiDichVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
