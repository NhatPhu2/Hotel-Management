/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.LoaiPhongDAO;
import com.DAO.PhongDAO;
import com.Entity.LoaiPhong;
import com.Entity.Phong;
import com.utils.MsgBox;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ASUS
 */
public class QuanLyPhong extends javax.swing.JFrame {

    PhongDAO dao1 = new PhongDAO();
    int row1 = -1;
    LoaiPhongDAO dao = new LoaiPhongDAO();
    int row = -1;

    public QuanLyPhong() {
        initComponents();
        this.setVisible(true);
        init();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel5 = new com.k33ptoo.components.KGradientPanel();
        tabs = new javax.swing.JTabbedPane();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_idKindOfRoom = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KindOfRoom = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_RoomName = new javax.swing.JTextField();
        txt_Price = new javax.swing.JTextField();
        kGradientPanel4 = new com.k33ptoo.components.KGradientPanel();
        btn_Add2 = new com.k33ptoo.components.KButton();
        btn_Delete2 = new com.k33ptoo.components.KButton();
        btn_Update2 = new com.k33ptoo.components.KButton();
        kGradientPanel2 = new com.k33ptoo.components.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_SearchIdRoom = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Room1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_idRoom = new javax.swing.JTextField();
        cbo_KindOfRoom = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        kGradientPanel3 = new com.k33ptoo.components.KGradientPanel();
        btn_Add1 = new com.k33ptoo.components.KButton();
        btn_Delete1 = new com.k33ptoo.components.KButton();
        btn_Update1 = new com.k33ptoo.components.KButton();
        lblKetThuc = new javax.swing.JLabel();
        lblThuLai = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        tabs.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 255));
        kGradientPanel1.setkGradientFocus(1000);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã loại:");

        txt_idKindOfRoom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tbl_KindOfRoom.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_KindOfRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại", "Tên loại", "Giá"
            }
        ));
        tbl_KindOfRoom.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_KindOfRoom.setRowHeight(20);
        tbl_KindOfRoom.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_KindOfRoom.setShowHorizontalLines(false);
        tbl_KindOfRoom.setShowVerticalLines(false);
        tbl_KindOfRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KindOfRoomMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KindOfRoom);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên loại:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Giá:");

        txt_RoomName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txt_Price.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        kGradientPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Add2.setBackground(new java.awt.Color(255, 255, 255));
        btn_Add2.setText("Thêm");
        btn_Add2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Add2.setkBackGroundColor(new java.awt.Color(204, 0, 204));
        btn_Add2.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Add2.setkHoverForeGround(new java.awt.Color(255, 0, 153));
        btn_Add2.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Add2.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Add2.setkSelectedColor(new java.awt.Color(153, 0, 153));
        btn_Add2.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_Add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Add2ActionPerformed(evt);
            }
        });

        btn_Delete2.setBackground(new java.awt.Color(102, 204, 255));
        btn_Delete2.setForeground(new java.awt.Color(0, 51, 255));
        btn_Delete2.setText("Xóa");
        btn_Delete2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Delete2.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Delete2.setkHoverForeGround(new java.awt.Color(255, 0, 153));
        btn_Delete2.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Delete2.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Delete2.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_Delete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Delete2ActionPerformed(evt);
            }
        });

        btn_Update2.setBackground(new java.awt.Color(102, 204, 255));
        btn_Update2.setForeground(new java.awt.Color(0, 51, 255));
        btn_Update2.setText("Cập nhật");
        btn_Update2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Update2.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Update2.setkHoverForeGround(new java.awt.Color(255, 0, 153));
        btn_Update2.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Update2.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Update2.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_Update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Update2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel4Layout = new javax.swing.GroupLayout(kGradientPanel4);
        kGradientPanel4.setLayout(kGradientPanel4Layout);
        kGradientPanel4Layout.setHorizontalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Add2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Update2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        kGradientPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Delete2, btn_Update2});

        kGradientPanel4Layout.setVerticalGroup(
            kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Update2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Delete2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Add2, btn_Delete2, btn_Update2});

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_RoomName)
                            .addComponent(txt_Price)
                            .addComponent(txt_idKindOfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_idKindOfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_RoomName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(kGradientPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        tabs.addTab("Loại phòng", kGradientPanel1);

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 102, 255));
        kGradientPanel2.setkGradientFocus(1000);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tìm kiếm:");

        txt_SearchIdRoom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_SearchIdRoom.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_SearchIdRoomCaretUpdate(evt);
            }
        });

        tbl_Room1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_Room1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Số phòng", "Loại phòng", "Tình trạng"
            }
        ));
        tbl_Room1.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Room1.setRowHeight(30);
        tbl_Room1.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_Room1.setShowHorizontalLines(false);
        tbl_Room1.setShowVerticalLines(false);
        tbl_Room1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Room1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Room1);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số phòng:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Loại phòng:");

        txt_idRoom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbo_KindOfRoom.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbo_KindOfRoom.setForeground(new java.awt.Color(255, 0, 102));
        cbo_KindOfRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_KindOfRoomActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        kGradientPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_Add1.setBackground(new java.awt.Color(255, 255, 255));
        btn_Add1.setText("Thêm");
        btn_Add1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Add1.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Add1.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Add1.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Add1.setkSelectedColor(new java.awt.Color(153, 0, 153));
        btn_Add1.setkStartColor(new java.awt.Color(0, 153, 255));

        btn_Delete1.setBackground(new java.awt.Color(102, 204, 255));
        btn_Delete1.setForeground(new java.awt.Color(0, 51, 255));
        btn_Delete1.setText("Xóa");
        btn_Delete1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Delete1.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Delete1.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Delete1.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Delete1.setkStartColor(new java.awt.Color(0, 153, 255));

        btn_Update1.setBackground(new java.awt.Color(102, 204, 255));
        btn_Update1.setForeground(new java.awt.Color(0, 51, 255));
        btn_Update1.setText("Cập nhật");
        btn_Update1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Update1.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_Update1.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Update1.setkIndicatorColor(new java.awt.Color(0, 204, 204));
        btn_Update1.setkStartColor(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout kGradientPanel3Layout = new javax.swing.GroupLayout(kGradientPanel3);
        kGradientPanel3.setLayout(kGradientPanel3Layout);
        kGradientPanel3Layout.setHorizontalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Add1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btn_Update1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        kGradientPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Add1, btn_Delete1, btn_Update1});

        kGradientPanel3Layout.setVerticalGroup(
            kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Add1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Delete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Update1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Add1, btn_Delete1, btn_Update1});

        javax.swing.GroupLayout kGradientPanel2Layout = new javax.swing.GroupLayout(kGradientPanel2);
        kGradientPanel2.setLayout(kGradientPanel2Layout);
        kGradientPanel2Layout.setHorizontalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbo_KindOfRoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_idRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(46, 46, 46)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                                .addGap(329, 329, 329)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_SearchIdRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        kGradientPanel2Layout.setVerticalGroup(
            kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_SearchIdRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(17, 17, 17)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_idRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(kGradientPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbo_KindOfRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(kGradientPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        kGradientPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, jLabel6});

        tabs.addTab("Phòng", kGradientPanel2);

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

        javax.swing.GroupLayout kGradientPanel5Layout = new javax.swing.GroupLayout(kGradientPanel5);
        kGradientPanel5.setLayout(kGradientPanel5Layout);
        kGradientPanel5Layout.setHorizontalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabs)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        kGradientPanel5Layout.setVerticalGroup(
            kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel5Layout.createSequentialGroup()
                .addGroup(kGradientPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(QuanLyPhong.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void tbl_KindOfRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KindOfRoomMouseClicked
        // TODO add your handling code here:
        this.row = tbl_KindOfRoom.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tbl_KindOfRoomMouseClicked

    private void tbl_Room1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Room1MouseClicked
        // TODO add your handling code here:

        this.row1 = tbl_Room1.getSelectedRow();
        this.editRoom();

    }//GEN-LAST:event_tbl_Room1MouseClicked

    private void txt_SearchIdRoomCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_SearchIdRoomCaretUpdate
        // TODO add your handling code here:
        this.find();
    }//GEN-LAST:event_txt_SearchIdRoomCaretUpdate

    private void btn_Add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Add2ActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btn_Add2ActionPerformed

    private void btn_Delete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Delete2ActionPerformed
        // TODO add your handling code here:
        this.delete();
    }//GEN-LAST:event_btn_Delete2ActionPerformed

    private void btn_Update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Update2ActionPerformed
       
        this.update();
    }//GEN-LAST:event_btn_Update2ActionPerformed

    private void cbo_KindOfRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_KindOfRoomActionPerformed
//        fillComboBox();
    }//GEN-LAST:event_cbo_KindOfRoomActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.k33ptoo.components.KButton btn_Add1;
    private com.k33ptoo.components.KButton btn_Add2;
    public com.k33ptoo.components.KButton btn_Delete1;
    private com.k33ptoo.components.KButton btn_Delete2;
    public com.k33ptoo.components.KButton btn_Update1;
    private com.k33ptoo.components.KButton btn_Update2;
    private javax.swing.JComboBox<String> cbo_KindOfRoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel2;
    private com.k33ptoo.components.KGradientPanel kGradientPanel3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel4;
    private com.k33ptoo.components.KGradientPanel kGradientPanel5;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbl_KindOfRoom;
    private javax.swing.JTable tbl_Room1;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_RoomName;
    private javax.swing.JTextField txt_SearchIdRoom;
    private javax.swing.JTextField txt_idKindOfRoom;
    private javax.swing.JTextField txt_idRoom;
    // End of variables declaration//GEN-END:variables

    void init() {
        setLocationRelativeTo(null);
        setTable();
        fillToTableRoom();
        fillToTable();
        updateStatus();
        updateStatusRoom();
        fillComboBoxLoaiPhong();

    }

    public void fillComboBoxLoaiPhong() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_KindOfRoom.getModel();
        model.removeAllElements();
        List<LoaiPhong> list = dao.selectAll();
        for (LoaiPhong kh : list) {
            model.addElement(kh.getMaLP());
        }
    }

    /* ClearForm Loại phòng*/
    public void clearForm() {
        LoaiPhong lp = new LoaiPhong();
        settext();
        this.row = -1;
        this.updateStatus();
    }

    void setTable() {
        TableCellRenderer rendererFromHeader = tbl_KindOfRoom.getTableHeader().getDefaultRenderer();/* Căn giữa title ở header of table_KindOfRoom */
        JLabel headerLabel = (JLabel) rendererFromHeader;
        headerLabel.setHorizontalAlignment(JLabel.CENTER);

        TableCellRenderer rendererFromHeaderRoom = tbl_Room1.getTableHeader().getDefaultRenderer();/* Căn giữa title ở header of table_Room */
        JLabel headerLabelRoom = (JLabel) rendererFromHeaderRoom;
        headerLabelRoom.setHorizontalAlignment(JLabel.CENTER);

        JTableHeader hd = tbl_KindOfRoom.getTableHeader();/* set màu chữ và màu background cho header */
        hd.setBackground(new Color(0, 102, 255));
        hd.setForeground(Color.BLACK);
        JTableHeader hd2 = tbl_Room1.getTableHeader();
        hd2.setBackground(new Color(0, 102, 255));
        hd2.setForeground(Color.BLACK);
        tbl_KindOfRoom.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));
        tbl_Room1.getTableHeader().setFont(new Font("Tahoma", Font.PLAIN, 16));

        DefaultTableCellRenderer centerTable = new DefaultTableCellRenderer();/* căn giữa text in column */
        centerTable.setHorizontalAlignment(JLabel.CENTER);

        tbl_KindOfRoom.getColumnModel().getColumn(0).setCellRenderer(centerTable);
        tbl_KindOfRoom.getColumnModel().getColumn(1).setCellRenderer(centerTable);
        tbl_KindOfRoom.getColumnModel().getColumn(2).setCellRenderer(centerTable);

        tbl_Room1.getColumnModel().getColumn(0).setCellRenderer(centerTable);
        tbl_Room1.getColumnModel().getColumn(1).setCellRenderer(centerTable);
        tbl_Room1.getColumnModel().getColumn(2).setCellRenderer(centerTable);
    }


    /* Đẩy dữ liệu từ database vào table_Room */
    void fillToTableRoom() {
        DefaultTableModel model = (DefaultTableModel) tbl_Room1.getModel();
        model.setRowCount(0);
        try {
            String keyword = txt_SearchIdRoom.getText();
            List<Phong> list = dao1.selectByKeyword(keyword);
            for (Phong p : list) {
                model.addRow(new Object[]{
                    p.getSoPhong(),
                    p.getMaLP(),
                    p.getTinhTrang(),});
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu! \n" + e);
        }

    }

    /* Đẩy dữ liệu từ database vào table_KindOfRoom */
    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_KindOfRoom.getModel();
        model.setRowCount(0);
        try {
            List<LoaiPhong> list = dao.selectAll();
            for (LoaiPhong lp : list) {
                model.addRow(new Object[]{
                    lp.getMaLP(),
                    lp.getTenLP(),
                    lp.getGia(),});
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi truy vấn dữ liệu! \n" + e);
        }
    }

    /* setForm cho Loại phòng */
    public void setForm(LoaiPhong lp) {
        txt_idKindOfRoom.setText(lp.getMaLP());
        txt_RoomName.setText(lp.getTenLP());
        txt_Price.setText(String.valueOf(lp.getGia()));
    }

    /* getForm cho Loại phòng */
    public LoaiPhong getForm() {
        LoaiPhong lp = new LoaiPhong();
        lp.setMaLP(txt_idKindOfRoom.getText());
        lp.setTenLP(txt_RoomName.getText());
        lp.setGia(Float.parseFloat(txt_Price.getText()));

        return lp;
    }

    /* set text cho Loại phòng & Phòng */
    public void settext() {
        txt_idKindOfRoom.setText("");
        txt_RoomName.setText("");
        txt_Price.setText("");

        txt_idRoom.setText("");
        cbo_KindOfRoom.setSelectedIndex(0);
    }

    /* Thêm Loại phòng */
   public void insert() {
        LoaiPhong lp = getForm();

        try {
            dao.insert(lp);
            this.fillToTable();
            MsgBox.alert(this, "Thêm thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại!");
        }

    }

    /* Xóa Loại phòng */
    public void delete() {
        String maLP = txt_idKindOfRoom.getText();
        try {
            dao.delete(maLP);
            this.fillToTable();
            this.clearForm();
            MsgBox.alert(this, "Xóa thành công!");
            settext();
        } catch (Exception e) {
            MsgBox.alert(this, "Xóa thất bại!");
        }

    }

    /* Cập nhật Loại phòng */
    public void update() {

        LoaiPhong lp = getForm();

        if (txt_idKindOfRoom.getText().equals("")) {
            MsgBox.alert(this, "Mã loại phòng không được để trống!");
            txt_idKindOfRoom.requestFocus();
            txt_idKindOfRoom.setBackground(Color.yellow);
            return;
        } else {
            txt_idKindOfRoom.setBackground(Color.white);
        }
//        if (txt_RoomName.getText().equals("")) {
//            MsgBox.alert(this, "Tên loại phòng không được để trống!");;
//            txt_RoomName.requestFocus();
//            txt_RoomName.setBackground(Color.yellow);
//            return;
//        } else {
//            txt_RoomName.setBackground(Color.white);
//        }
//        if (txt_Price.getText().equals("")) {
//            MsgBox.alert(this, "Giá không được để trống!");
//            txt_Price.requestFocus();
//            txt_Price.setBackground(Color.yellow);
//            return;
//        } else {
//            txt_Price.setBackground(Color.white);
//        }

        try {
            dao.update(lp);
            this.fillToTable();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }

    }

    /* edit Loại phòng */
    private void edit() {
        String maLP = (String) tbl_KindOfRoom.getValueAt(this.row, 0);
        LoaiPhong lp = dao.selectById(maLP);
        this.setForm(lp);
        this.updateStatus();
        tabs.setSelectedIndex(0);
    }

    /* edit phòng */
    private void editRoom() {
        String soP = (String) tbl_Room1.getValueAt(this.row1, 0);
        Phong p = dao1.selectById(soP);
        this.setFormRoom(p);
        this.updateStatusRoom();
        tabs.setSelectedIndex(1);
    }

    /* Trạng thái Phòng */
    public void updateStatusRoom() {
        boolean editRoom = (this.row1 >= 0);
        boolean firstRoom = (this.row1 == 0);
        boolean lastRoom = (this.row1 == tbl_Room1.getRowCount() - 1);

      
        btn_Update1.setEnabled(editRoom);
        btn_Delete1.setEnabled(editRoom);

    }

    /* Trạng thái Loại Phòng */
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        boolean first = (this.row == 0);
        boolean last = (this.row == tbl_KindOfRoom.getRowCount() - 1);

 
        btn_Update2.setEnabled(edit);
        btn_Delete2.setEnabled(edit);
    }

    public void first() {
        this.row = 0;
        this.edit();
    }

    public void prev() {
        if (this.row > 0) {
            this.row--;
            this.edit();
        }
    }

    public void next() {
        if (this.row < tbl_KindOfRoom.getRowCount() - 1) {
            this.row++;
            this.edit();
        }
    }

    public void last() {
        this.row = tbl_KindOfRoom.getRowCount() - 1;
        this.edit();
    }

    public void setFormRoom(Phong p) {
        txt_idRoom.setText(p.getSoPhong());
        if (p.getMaLP().equals("PD1")) {
            cbo_KindOfRoom.setSelectedIndex(0);
        } else if (p.getMaLP().equals("PD2")) {
            cbo_KindOfRoom.setSelectedIndex(1);
        } else {
            cbo_KindOfRoom.setSelectedIndex(2);
        }

    }

    public Phong getFormRoom() {
        Phong p = new Phong();
        p.setSoPhong(txt_idRoom.getText());
        p.setMaLP(cbo_KindOfRoom.getSelectedItem().toString());
        p.setTinhTrang("Trống");
        return p;
    }

    /* Thêm Loại phòng */
    public void insertRoom() {
        if(txt_idRoom.getText().trim().isEmpty()){
            MsgBox.alert(this,"Vui lòng nhập số phòng");
            return;
        }else if(txt_idRoom.getText().trim().length() >=5){
             MsgBox.alert(this,"Số phòng không quá 4 ký tự");
            return;
        }
        Phong p = getFormRoom();

        try {
            dao1.insert(p);
            this.fillToTableRoom();
            MsgBox.alert(this, "Thêm thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm thất bại!");
            
        }

    }

    /* Xóa phòng */
    public void deleteRoom() {
        if (MsgBox.confirm(this, "Bạn muốn xóa Phòng ?")) {
            try {
                String soP = txt_idRoom.getText();
                dao1.delete(soP);
                this.fillToTableRoom();
                this.clear();
                MsgBox.alert(this, "Xóa thành công!");
                settext();
            } catch (Exception e) {
                MsgBox.alert(this, "Xóa thất bại!");
            }
        }

    }

    /* Cập nhật Loại phòng */
    public void updateRoom() {

        Phong p = getFormRoom();

        try {
            dao1.update(p);
            this.fillToTableRoom();
            MsgBox.alert(this, "Cập nhật thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Cập nhật thất bại!");
        }

    }

    public void clear() {
        Phong p = new Phong();
        settext();
        this.row1 = -1;
        updateStatusRoom();
    }

    private void find() {
        this.fillToTableRoom();
        this.clear();
        this.row1 = -1;
        this.updateStatusRoom();
    }

    public void firstRoom() {
        this.row1 = 0;
        this.editRoom();
    }

    public void prevRoom() {
        if (this.row1 > 0) {
            this.row1--;
            this.editRoom();
        }
    }

    public void nextRoom() {
        if (this.row1 < tbl_Room1.getRowCount() - 1) {
            this.row1++;
            this.editRoom();
        }
    }

    public void lastRoom() {
        this.row1 = tbl_Room1.getRowCount() - 1;
        this.editRoom();
    }

//    private void fillComboBox() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_KindOfRoom.getModel();
//        model.removeAllElements();
//        Phong p = (Phong) cbo_KindOfRoom.getSelectedItem();
//        if (p != null) {
//            List<Phong> list = (List<Phong>) dao1.selectById(p.getSoPhong());
//            for (Phong kh : list) {
//                model.addElement(kh);
//            }
//            this.fillToTableRoom();
//        }
//    }
}
