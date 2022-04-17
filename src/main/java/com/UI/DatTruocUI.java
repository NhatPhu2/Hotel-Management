/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.DatTruocDAO;
import com.DAO.HoaDonDAO;
import com.DAO.KhachHangDAO;
import com.DAO.LoaiPhongDAO;
import com.DAO.PhongDAO;
import com.DAO.ThuePhongDAO;
import com.Entity.DatTruoc;
import com.Entity.HoaDon;

import com.Entity.Phong;
import com.Entity.ThuePhong;
import com.utils.Auth;

import com.utils.XDate;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DatTruocUI extends javax.swing.JFrame {

    public DatTruocDAO dao = new DatTruocDAO();
    public KhachHangDAO khdao = new KhachHangDAO();
    public LoaiPhongDAO lpdao = new LoaiPhongDAO();
    public PhongDAO pdao = new PhongDAO();
    public ThuePhongDAO tpDao = new ThuePhongDAO();
    public HoaDonDAO hdDao = new HoaDonDAO();
    long millis = System.currentTimeMillis();
    Date date = new Date(millis);
    int index = -1;

    /**
     * Creates new form DatTruoc
     */
    public DatTruocUI() {
        initComponents();
        this.setVisible(true);
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        trangThai = new javax.swing.JMenuItem();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_DatTruoc = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btn_CapNhat = new com.k33ptoo.components.KButton();
        lblKetThuc1 = new javax.swing.JLabel();
        lblThuLai1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        trangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        trangThai.setText("Đã nhận phòng");
        trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangThaiActionPerformed(evt);
            }
        });
        jPopupMenu1.add(trangThai);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đặt Trước");
        setUndecorated(true);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        tbl_DatTruoc.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_DatTruoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đặt trước", "Mã nhân viên", "Cmnd", "Tên KH", "Số Phòng", "Loại Phòng", "Ngày Trả", "Tiền Cọc", "Ngày Nhận", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_DatTruoc.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_DatTruoc.setRowHeight(20);
        tbl_DatTruoc.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_DatTruoc.setShowHorizontalLines(false);
        tbl_DatTruoc.setShowVerticalLines(false);
        tbl_DatTruoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_DatTruocMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_DatTruocMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_DatTruoc);

        btn_CapNhat.setText("Cập nhật");
        btn_CapNhat.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_CapNhat.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_CapNhat.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btn_CapNhat.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatActionPerformed(evt);
            }
        });

        lblKetThuc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetThuc1.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/close_1.png"))
        );
        lblKetThuc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKetThuc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetThuc1MouseClicked(evt);
            }
        });

        lblThuLai1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThuLai1.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/minus.png"))
        );
        lblThuLai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThuLai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThuLai1MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Đặt Trước");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 443, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(352, 352, 352)
                .addComponent(lblThuLai1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKetThuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(410, 410, 410))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKetThuc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThuLai1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btn_CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void lblKetThuc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThuc1MouseClicked
        
        this.dispose();
    }//GEN-LAST:event_lblKetThuc1MouseClicked

    private void lblThuLai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLai1MouseClicked
        // TODO add your handling code here:
        this.setState(DatTruocUI.ICONIFIED);
    }//GEN-LAST:event_lblThuLai1MouseClicked

    private void btn_CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btn_CapNhatActionPerformed

    private void tbl_DatTruocMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatTruocMouseReleased
        
    }//GEN-LAST:event_tbl_DatTruocMouseReleased

    private void tbl_DatTruocMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DatTruocMousePressed
        index = tbl_DatTruoc.getSelectedRow();
    }//GEN-LAST:event_tbl_DatTruocMousePressed

    private void trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangThaiActionPerformed
       
       
    }//GEN-LAST:event_trangThaiActionPerformed
    public ThuePhong getValueThuePhong() {
        ThuePhong t = new ThuePhong();
        String soPhong = tbl_DatTruoc.getValueAt(index, 4).toString();
        String ngayTra = tbl_DatTruoc.getValueAt(index, 6).toString();
        String cmnd = tbl_DatTruoc.getValueAt(index, 2).toString();
        String ngayThue = tbl_DatTruoc.getValueAt(index, 8).toString();
        List<ThuePhong> list = tpDao.selectAll();
        int maThue;
        if (list.size() == 0) {
            maThue = list.size() + 1;
        } else {
            maThue = list.get(list.size() - 1).getMaThue() + 1;
        }
        t.setMaThue(maThue);
        t.setNgayTra(XDate.toDate(ngayTra, "yyyy-MM-dd"));
        t.setSoPhong(soPhong);
        t.setCmnd(cmnd);
        t.setNgayThue(XDate.toDate(ngayThue, "yyyy-MM-dd"));
        return t;
    }

    public DatTruoc getValueDatTruoc() {
        DatTruoc d = new DatTruoc();
        int maDT = Integer.parseInt(tbl_DatTruoc.getValueAt(index, 0).toString());
        d.setMaDT(maDT);
        d.setTinhTrang("Đã nhận phòng");
        return d;
    }

    public Phong getValuePhong() {
        Phong p = new Phong();
        String soPhong = tbl_DatTruoc.getValueAt(index, 4).toString();
        p.setTinhTrang("Đã có người");
        p.setSoPhong(soPhong);
        return p;
    }

    public HoaDon getValueHoaDon() {
        HoaDon hd = new HoaDon();
        String cmnd = tbl_DatTruoc.getValueAt(index, 2).toString();
        List<ThuePhong> list = tpDao.selectAll();
        int maThue = list.get(list.size() - 1).getMaThue();
        hd.setCmnd(cmnd);
        hd.setMaKM(null);
        hd.setMaNV(Auth.user.getMaNV());
        hd.setMaThue(maThue);
        hd.setNgayLap(date);
        hd.setNgayXuat(null);
        hd.setThanhTien(0);
        hd.setSoNgay(0);
        hd.setTinhTrang("Chưa thanh toán");
        return hd;

    }
    
    public void datTruoc(){
         String trangThai = tbl_DatTruoc.getValueAt(index, 9).toString();
        if (trangThai.equalsIgnoreCase("đã nhận phòng")) {
            return;
        }
        dao.updateStatus(getValueDatTruoc());
        tpDao.insert(getValueThuePhong());
        hdDao.insert(getValueHoaDon());
        pdao.updateTrangThaiPhong(getValuePhong());
        fillToTable();
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
            java.util.logging.Logger.getLogger(DatTruocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatTruocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatTruocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatTruocUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatTruocUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_CapNhat;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblKetThuc1;
    private javax.swing.JLabel lblThuLai1;
    public javax.swing.JTable tbl_DatTruoc;
    public javax.swing.JMenuItem trangThai;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        fillToTable();
    }

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_DatTruoc.getModel();
        model.setRowCount(0);
        try {
            List<DatTruoc> list = dao.selectAll();
            for (DatTruoc dt : list) {
                String tenkh = khdao.selectById(dt.getCmnd()).getTenKH();
                String maloai_phong = pdao.selectById(dt.getSoPhong()).getMaLP();
                String loaip = lpdao.selectById(maloai_phong).getTenLP();
                Object[] row = {dt.getMaDT(), dt.getMaNV(), dt.getCmnd(), tenkh, dt.getSoPhong(), loaip,
                    dt.getNgayTra(), dt.getTienDatCoc(), dt.getNgayNhanPhong(), dt.getTinhTrang()};
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi try vấn!");
        }
    }

    void update() {
        try {
            if (checkValidate()) {
                int index = tbl_DatTruoc.getSelectedRow();
                int madt = (int) tbl_DatTruoc.getValueAt(index, 0);
                String ngayNhan = tbl_DatTruoc.getValueAt(index, 8).toString();
                String sop = (String) tbl_DatTruoc.getValueAt(index, 4);
                DatTruoc dt = dao.selectById(madt);
                dt.setNgayNhanPhong(XDate.toDate(ngayNhan, "yyyy-MM-dd"));
                dt.setSoPhong(sop);
                dao.update(dt);
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
                fillToTable();
            }

            fillToTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng!");

        }
    }

    public boolean checkValidate() {
        boolean check = false;
        int index = tbl_DatTruoc.getSelectedRow();
        int madt = (int) tbl_DatTruoc.getValueAt(index, 0);
        DatTruoc dt = dao.selectById(madt);
        String ngayNhan = tbl_DatTruoc.getValueAt(index, 8).toString();
        String sop = (String) tbl_DatTruoc.getValueAt(index, 4);
        List<Phong> list = pdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            Phong p = list.get(i);
            if (sop.equals(p.getSoPhong())) {
                check = true;
                break;
            } else {
                check = false;
            }
        }
        if (check == false) {
            JOptionPane.showMessageDialog(this, "Không tồn tại phòng này!");
        }
        if (checkDate(ngayNhan) == false) {
            JOptionPane.showMessageDialog(this, " không đúng định dạng yyyy-MM-dd");
            fillToTable();
            return false;
        }

        return true;
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
            if (!id.matches(rgx)) {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
