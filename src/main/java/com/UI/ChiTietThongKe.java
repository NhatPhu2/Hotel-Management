/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.ChiTietHoaDonDAO;
import com.DAO.DichVuDAO;
import com.DAO.HoaDonDAO;
import com.Entity.ChiTietHoaDon;
import com.Entity.DichVu;
import com.Entity.HoaDon;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ChiTietThongKe extends javax.swing.JFrame {

   List<HoaDon> listHaoDon = new ArrayList<>();
   ChiTietHoaDonDAO ctDao = new ChiTietHoaDonDAO();
   DichVuDAO dvDao = new DichVuDAO();
   int index = -1;
    public ChiTietThongKe() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
     public void fillService(Integer maHD) {
        
        
        DefaultTableModel model = (DefaultTableModel) tblDichVu.getModel();
        model.setRowCount(0);
        List<ChiTietHoaDon> list = ctDao.selectByHoaDon(maHD);
       
        for(int i = 0 ; i < list.size() ; i ++){
            ChiTietHoaDon ct = list.get(i);
            DichVu dv = dvDao.selectById(ct.getMaDV());
            Object obj[] = {++i,dv.getTenDV(),ct.getNgaySuDung()};
            model.addRow(obj);
        }
        
    }
   
    
    public void fillTable(String cmnd){
        DefaultTableModel model = (DefaultTableModel)tblThongTinKH.getModel();
        model.setRowCount(0);
        HoaDonDAO hdDao = new HoaDonDAO();
        listHaoDon = hdDao.selectByCmnd(cmnd);
        listHaoDon.forEach((element ->{
            Object[] obj = {element.getNgayLap(),element.getNgayXuat(),element.getSoNgay(),element.getSoPhong(),element.getSodv()};
            model.addRow(obj);
        }));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblThongTinKH = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblThongTinKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblThongTinKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ngày đến", "Ngày đi", "Số ngày ở", "Số phòng", "Số dịch vụ"
            }
        ));
        tblThongTinKH.setGridColor(new java.awt.Color(255, 255, 255));
        tblThongTinKH.setRowHeight(20);
        tblThongTinKH.setShowHorizontalLines(false);
        tblThongTinKH.setShowVerticalLines(false);
        tblThongTinKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThongTinKHMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblThongTinKH);

        tblDichVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Tên dịch vụ", "Ngày sử dụng"
            }
        ));
        tblDichVu.setGridColor(new java.awt.Color(255, 255, 255));
        tblDichVu.setRowHeight(20);
        tblDichVu.setShowHorizontalLines(false);
        tblDichVu.setShowVerticalLines(false);
        jScrollPane1.setViewportView(tblDichVu);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblThongTinKHMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinKHMousePressed
       index = tblThongTinKH.getSelectedRow();
       if(index == -1)
           return;
       Integer maHD = listHaoDon.get(index).getMaHD();
        fillService(maHD);
    }//GEN-LAST:event_tblThongTinKHMousePressed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietThongKe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTable tblThongTinKH;
    // End of variables declaration//GEN-END:variables
}
