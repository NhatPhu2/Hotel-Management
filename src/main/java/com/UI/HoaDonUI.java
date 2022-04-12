/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.HoaDonDAO;
import com.DAO.KhachHangDAO;
import com.Entity.HoaDon;
import java.awt.Desktop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC
 */
public class HoaDonUI extends javax.swing.JFrame {

    int index = -1;
    HoaDonDAO dao = new HoaDonDAO();
    KhachHangDAO khdao = new KhachHangDAO();

    /**
     * Creates new form HoaDon
     */
    public HoaDonUI() {
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDon = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        btn_XuatHD = new com.k33ptoo.components.KButton();
        lblThuLai = new javax.swing.JLabel();
        lblKetThuc = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        tbl_HoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Mã KM", "Mã NV", "Tên khách hàng", "Số Phòng", "Số dv sử dụng", "Ngày Lập HD", "Ngày xuất HD", "Số ngày ở", "Thành Tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_HoaDon.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_HoaDon.setRowHeight(20);
        tbl_HoaDon.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_HoaDon.setShowHorizontalLines(false);
        tbl_HoaDon.setShowVerticalLines(false);
        jScrollPane2.setViewportView(tbl_HoaDon);

        btn_XuatHD.setText("Xuất hóa đơn");
        btn_XuatHD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_XuatHD.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_XuatHD.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_XuatHD.setkSelectedColor(new java.awt.Color(153, 0, 153));
        btn_XuatHD.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_XuatHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XuatHDActionPerformed(evt);
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

        lblKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetThuc.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/close_1.png"))
        );
        lblKetThuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKetThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetThucMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã HD:");

        txtMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaHDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHDKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Hóa Đơn");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(464, 464, 464)
                        .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator2)
                            .addComponent(jScrollPane2))
                        .addContainerGap())))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(488, 488, 488)
                .addComponent(btn_XuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 1141, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_XuatHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                    .addContainerGap(107, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(495, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(HoaDonUI.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void txtMaHDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHDKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaHDKeyPressed

    private void txtMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHDKeyReleased
        // TODO add your handling code here:
        fillToTable();
    }//GEN-LAST:event_txtMaHDKeyReleased

    private void btn_XuatHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XuatHDActionPerformed
        // TODO add your handling code here:
        printExcel();
    }//GEN-LAST:event_btn_XuatHDActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_XuatHD;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JTable tbl_HoaDon;
    private javax.swing.JTextField txtMaHD;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);
        fillToTable();
    }

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_HoaDon.getModel();
        model.setRowCount(0);
        try {
            String ma = txtMaHD.getText();
            Integer key = -1;
            if (ma.isEmpty()) {
                List<HoaDon> list = dao.selectAll();
                for (HoaDon hd : list) {
                    String name = khdao.selectById(hd.getCmnd()).getTenKH();
                    BigDecimal bg = new BigDecimal(hd.getThanhTien());
                    Formatter fmt = new Formatter();
                    fmt.format("%." + bg.scale() + "f", bg);
                    Object[] row = {hd.getMaHD(), hd.getCmnd(), hd.getMaKM(), hd.getMaNV(),
                        name, hd.getSoPhong(), hd.getSodv(), hd.getNgayLap(), hd.getNgayXuat(),hd.getSoNgay(),fmt};
                    model.addRow(row);
                }
            } else {
                key = Integer.parseInt(ma);
                model.setRowCount(0);

                List<HoaDon> list = dao.findKey(key);
                for (HoaDon hd : list) {
                    String name = khdao.selectById(hd.getCmnd()).getTenKH();
                    BigDecimal bg = new BigDecimal(hd.getThanhTien());
                    Formatter fmt = new Formatter();
                    fmt.format("%." + bg.scale() + "f", bg);
                    Object[] row = {hd.getMaHD(), hd.getCmnd(), hd.getMaKM(), hd.getMaNV(),
                        name, hd.getSoPhong(), hd.getSodv(), hd.getNgayLap(), hd.getNgayXuat(), fmt};
                    model.addRow(row);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mã HD phải là số!");
        }

    }

    public void PressPrintandSave(Integer ma) {
        int line = tbl_HoaDon.getRowCount();
        index = tbl_HoaDon.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn đối tượng!");
        } else {
            Integer mahd = (Integer) tbl_HoaDon.getValueAt(index, 0);
            String makh = (String) tbl_HoaDon.getValueAt(index, 1);
            String makm = (String) tbl_HoaDon.getValueAt(index, 2);
            String manv = (String) tbl_HoaDon.getValueAt(index, 3);
            String tenkh = (String) tbl_HoaDon.getValueAt(index, 4);
            String sp = (String) tbl_HoaDon.getValueAt(index, 5);
            int sdv = (int) tbl_HoaDon.getValueAt(index, 6);
            Date ngayLap = (Date) tbl_HoaDon.getValueAt(index, 7);
            Date ngayXuat = (Date) tbl_HoaDon.getValueAt(index, 8);
            Formatter thanhTien = (Formatter) tbl_HoaDon.getValueAt(index, 9);
            try {
                Writer bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(".//History//" + mahd + ".txt"), "UTF8"));
                bw.write("\t\t\tTHE BAMBOO HOTEL\r\n\r\n");
                bw.write("\t\t590 CMT8, P.11, Q.3, TPHCM\r\n");
                bw.write("\t\t\tSĐT: 01212692802\r\n\r\n");
                bw.write("\t\t\tHÓA ĐƠN BÁN HÀNG\r\n\r\n");
                bw.write("Mã hóa đơn: " + mahd + "\r\n");
                bw.write("Ngày xuất: " + ngayXuat + "\r\n");
                bw.write("NHÂN VIÊN: " + manv + "\r\n");
                bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\r\n");
                bw.write("Mã HD\tMã KH\t\tMã KM\t\tMã NV\t\tTên KH\t\tSố phòng\tSố DV\tNgày Lập HD\tNgày Xuất HD\tThành Tiền\r\n");
                bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\r\n");
                bw.write(mahd + "\t" + makh + "   " + makm + "\t\t" + manv + "\t    " + tenkh + "\t" + sp + "\t" + sdv + "\t" + ngayLap + "\t" + ngayXuat + "\t" + thanhTien + "\r\n\r\n");
                bw.write("-----------------------------------------------------------------------------------------------------------------------------------------------\r\n");
                bw.write("Mật khẩu Wifi: 88888888\r\n");
                bw.write("----------------------------------------------------------CÁM ƠN QUÝ KHÁCH!---------------------------------------------------------------------");
                bw.close();
            } catch (Exception e) {
            }

            Runtime run = Runtime.getRuntime();
            try {
                run.exec("notepad History//" + mahd + ".txt");
            } catch (IOException e) {
            }
        }

    }
    
    public void printExcel() {
        try {
            XSSFWorkbook wordbook = new XSSFWorkbook();
            XSSFSheet sheet = wordbook.createSheet("Hóa Đơn");
            String[] columnH = {"Mã HD", "Mã KH", "Mã KM", "Mã NV", " Tên KH ",
                "Số Phòng", "Số DV sử dụng", "Ngày Lập HD", "Ngày Xuất HD", "Số ngày","Thành Tiền"};
            XSSFFont headF = wordbook.createFont();
            Row row;
            org.apache.poi.ss.usermodel.Cell cell;
            headF.setBold(true);
            headF.setColor(IndexedColors.BLUE.index);
            CellStyle headS = wordbook.createCellStyle();
            headS.setFont(headF);
            headS.setAlignment(HorizontalAlignment.CENTER);
            headS.setBorderBottom(BorderStyle.MEDIUM);
            headS.setBorderLeft(BorderStyle.MEDIUM);
            headS.setBorderRight(BorderStyle.MEDIUM);
            headS.setBorderTop(BorderStyle.MEDIUM);
            headS.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headS.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

            Row row2 = sheet.createRow(1);
            Cell cell2 = row2.createCell(5);
            cell2.setCellValue("KHÁCH SẠN BAMBOO XIN CHÀO!");
            CellStyle head2 = wordbook.createCellStyle();
            head2.setFont(headF);
            head2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            head2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            head2.setAlignment(HorizontalAlignment.CENTER);
            cell2.setCellStyle(head2);
            sheet.addMergedRegion(new CellRangeAddress(1, 1, 5, 7));

            Row rows = sheet.createRow(2);
            Cell cells = rows.createCell(5);
            cells.setCellValue("HÓA ĐƠN KHÁCH HÀNG");
            CellStyle head = wordbook.createCellStyle();
            head.setFont(headF);
            head.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            head.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            head.setAlignment(HorizontalAlignment.CENTER);
            cells.setCellStyle(head);
            sheet.addMergedRegion(new CellRangeAddress(2, 2, 5, 7));

            CellStyle cellS = wordbook.createCellStyle();
            cellS.setBorderBottom(BorderStyle.MEDIUM);
            cellS.setBorderLeft(BorderStyle.MEDIUM);
            cellS.setBorderRight(BorderStyle.MEDIUM);
            cellS.setBorderTop(BorderStyle.MEDIUM);
            Row headR = sheet.createRow(3);
            for (int j = 0; j < columnH.length; j++) {
                cell = headR.createCell(j + 1);
                cell.setCellValue(columnH[j]);
                cell.setCellStyle(headS);
            }

            index = tbl_HoaDon.getSelectedRow();
            row = sheet.createRow(4);
            Row row_2 = sheet.createRow(5);
            Integer mahd = (Integer) tbl_HoaDon.getValueAt(index, 0);
            String makh = (String) tbl_HoaDon.getValueAt(index, 1);
            String makm = (String) tbl_HoaDon.getValueAt(index, 2);
            String manv = (String) tbl_HoaDon.getValueAt(index, 3);
            String tenkh = (String) tbl_HoaDon.getValueAt(index, 4);
            String sp = (String) tbl_HoaDon.getValueAt(index, 5);
            int sdv = (int) tbl_HoaDon.getValueAt(index, 6);
            Date ngayLap = (Date) tbl_HoaDon.getValueAt(index, 7);
            Date ngayXuat = (Date) tbl_HoaDon.getValueAt(index, 8);
            int songay = (int) tbl_HoaDon.getValueAt(index, 9);
            Formatter thanhTien = (Formatter) tbl_HoaDon.getValueAt(index, 10);

            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(mahd);
            cell.setCellStyle(cellS);

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(makh);
            cell.setCellStyle(cellS);

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(makm);
            cell.setCellStyle(cellS);

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(manv);
            cell.setCellStyle(cellS);

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(tenkh);
            cell.setCellStyle(cellS);

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(sp);
            cell.setCellStyle(cellS);

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(sdv);
            cell.setCellStyle(cellS);

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(ngayLap);
            cell.setCellStyle(cellS);

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(ngayXuat);
            cell.setCellStyle(cellS);
            
            cell = row.createCell(10, CellType.NUMERIC);
            cell.setCellValue(songay);
            cell.setCellStyle(cellS);

            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue(thanhTien.toString());
            cell.setCellStyle(cellS);

            Row row3 = sheet.createRow(6);
            Cell cell3 = row3.createCell(2);
            cell3.setCellValue("Pass wifi : bamboohotel");

            Row row4 = sheet.createRow(7);
            Cell cell4 = row4.createCell(5);
            cell4.setCellValue("Cám ơn quý khách - Hẹn gặp lại");
            CellStyle head4 = wordbook.createCellStyle();
            head4.setFont(headF);
            head4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            head4.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            head4.setAlignment(HorizontalAlignment.CENTER);
            cell4.setCellStyle(head4);
            sheet.addMergedRegion(new CellRangeAddress(7, 7, 5, 7));

            // resize the colunm
            for (int i = 0; i <= columnH.length; i++) {
                sheet.autoSizeColumn(i);
            }

            File f = new File("D://hoadon.xlsx");
            try {
                FileOutputStream op = new FileOutputStream(f);
                wordbook.write(op);
                op.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Desktop.getDesktop().open(new File("D://hoadon.xlsx"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi in file");
            e.printStackTrace();
            return;
        }
    }
}
