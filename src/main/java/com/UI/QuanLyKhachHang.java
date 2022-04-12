/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.KhachHangDAO;
import com.Entity.KhachHang;
import com.utils.XDate;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ASUS
 */
public class QuanLyKhachHang extends javax.swing.JFrame {

    boolean check = false;
    KhachHangDAO dao = new KhachHangDAO();
    int index = -1;

    /**
     * Creates new form ManagerCustomer
     */
    public QuanLyKhachHang() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_ManagerCustomer = new javax.swing.JTable();
        btn_Sua = new com.k33ptoo.components.KButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblKetThuc = new javax.swing.JLabel();
        lblThuLai = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản Lý Khách Hàng");
        setUndecorated(true);
        setResizable(false);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 255));
        kGradientPanel1.setkGradientFocus(1000);

        tbl_ManagerCustomer.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_ManagerCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CMND", "Họ tên", "Năm sinh", "Số điện thoại", "Giới tính", "Địa chỉ"
            }
        ));
        tbl_ManagerCustomer.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_ManagerCustomer.setRowHeight(20);
        tbl_ManagerCustomer.setSelectionBackground(new java.awt.Color(0, 158, 250));
        jScrollPane1.setViewportView(tbl_ManagerCustomer);

        btn_Sua.setText("Cập Nhật");
        btn_Sua.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Sua.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Sua.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btn_Sua.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quản lý khách hàng");

        txtCMND.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtCMND.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCMNDKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CMND:");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(323, 323, 323)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(313, 313, 313))))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCMND)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(QuanLyKhachHang.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void txtCMNDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCMNDKeyReleased
        // TODO add your handling code here:
        fillToTable();
    }//GEN-LAST:event_txtCMNDKeyReleased

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_SuaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_Sua;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JTable tbl_ManagerCustomer;
    private javax.swing.JTextField txtCMND;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setLocationRelativeTo(null);
        fillToTable();
    }

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_ManagerCustomer.getModel();
        model.setRowCount(0);
        try {
            String keyword = txtCMND.getText();
            List<KhachHang> list = dao.selectByKeyWord(keyword);
            for (KhachHang kh : list) {
                Object[] row = {kh.getCmnd(), kh.getTenKH(), kh.getNgaySinh(),
                    kh.getSoDT(), kh.getGioiTinh() == true ? "Nam" : "Nữ", kh.getDiaChi()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi try vấn!");
        }
    }

    void update() {
        try {
            if (checkValidate()) {
                int index = tbl_ManagerCustomer.getSelectedRow();
                String cmnd = (String) tbl_ManagerCustomer.getValueAt(index, 0);
                KhachHang kh = dao.selectById(cmnd);
                kh.setTenKH((String) tbl_ManagerCustomer.getValueAt(index, 1));
                String date = tbl_ManagerCustomer.getValueAt(index, 2).toString();
                kh.setNgaySinh(XDate.toDate(date, "yyyy-MM-dd"));
                kh.setSoDT((String) tbl_ManagerCustomer.getValueAt(index, 3));
                if (tbl_ManagerCustomer.getValueAt(index, 4).equals("Nam")) {
                    kh.setGioiTinh(true);
                } else {
                    kh.setGioiTinh(false);
                }
                kh.setDiaChi((String) tbl_ManagerCustomer.getValueAt(index, 5));
                if (check = true) {
                    dao.update(kh);
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                    fillToTable();
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng!");
        }
    }

    void delete() {
        try {
            int index = tbl_ManagerCustomer.getSelectedRow();
            String cmnd = (String) tbl_ManagerCustomer.getValueAt(index, 0);
            dao.delete(cmnd);
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            fillToTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng!");
            System.out.println(e);
        }
    }

    public boolean checkValidate() {
        int index = tbl_ManagerCustomer.getSelectedRow();
        String cmnd = (String) tbl_ManagerCustomer.getValueAt(index, 0);
        KhachHang kh = dao.selectById(cmnd);
        String tenkh = (String) tbl_ManagerCustomer.getValueAt(index, 1);
        String sdt = tbl_ManagerCustomer.getValueAt(index, 3).toString();
        String date = tbl_ManagerCustomer.getValueAt(index, 2).toString();      
        if (checkName(tenkh) == false) {
            JOptionPane.showMessageDialog(this, "Tên phải là chữ cái");
            fillToTable();
            return false;
        } else if (checkSDT(sdt) == false) {
            JOptionPane.showMessageDialog(this, "SDT phải là chữ số");
            System.out.println(sdt);
            fillToTable();
            return false;
        } else if (checkDate(date) == false) {
            JOptionPane.showMessageDialog(this, " không đúng định dạng yyyy-MM-dd");
            fillToTable();
            return false;
        }

        return true;
    }

    public static boolean checkName(String txt) {
        String id = txt;
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkSDT(String txt) {
        String id = txt.trim();
        String rgx = "[0-9]{10}";
        if (id.matches(rgx)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isValidDate(String inDate) {

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static boolean checkDate(String txt) {
        String id = txt.trim();
        if (isValidDate(id)) {          
            String rgx = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";
            if(!id.matches(rgx)){
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
