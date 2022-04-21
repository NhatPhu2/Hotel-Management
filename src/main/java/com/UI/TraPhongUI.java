
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.ChiTietHoaDonDAO;
import com.DAO.DatTruocDAO;
import com.DAO.HoaDonDAO;
import com.DAO.KhachHangDAO;
import com.DAO.KhuyenMaiDAO;
import com.DAO.LoaiPhongDAO;
import com.DAO.PhongDAO;
import com.DAO.ThuePhongDAO;
import com.Entity.ChiTietHoaDon;
import com.Entity.DatTruoc;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import com.Entity.ThuePhong;
import com.utils.MsgBox;
import com.utils.XDate;
import java.awt.event.MouseEvent;
import java.util.Date;
import com.Entity.HoaDon;
import com.Entity.KhuyenMai;
import com.Entity.Phong;
import com.utils.Auth;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Formatter;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class TraPhongUI extends javax.swing.JFrame {

    /**
     * Creates new form CheckOut
     */
    public TraPhongUI() {
        initComponents();
        this.setVisible(true);
        init();
        fillTable();
        txtTienThua.setEditable(false);
    }
    List<ThuePhong> listThuePhong;
    ThuePhongDAO thuePhongDao = new ThuePhongDAO();
    KhachHangDAO khDao = new KhachHangDAO();
    LoaiPhongDAO lDao = new LoaiPhongDAO();
    PhongDAO pDao = new PhongDAO();
    HoaDonDAO hdDao = new HoaDonDAO();
    KhuyenMaiDAO kmDao = new KhuyenMaiDAO();
    ChiTietHoaDonDAO ctDao = new ChiTietHoaDonDAO();
    DatTruocDAO dtDao = new DatTruocDAO();
    DefaultTableModel model;
    long millis = System.currentTimeMillis();
    Date date = new java.sql.Date(millis);
    int index = -1;
    
     
    
    public void fillTable() {
        model = (DefaultTableModel) tbl_CheckOut.getModel();
        model.setRowCount(0);
        listThuePhong = thuePhongDao.selectAll();
        for (int i = 0; i < listThuePhong.size(); i++) {
            ThuePhong tp = listThuePhong.get(i);
            String name = khDao.selectById(tp.getCmnd()).getTenKH();
            String maloai = pDao.selectById(tp.getSoPhong()).getMaLP();
            String loaiPhong = lDao.selectById(maloai).getTenLP();
            BigDecimal bg = new BigDecimal(thuePhongDao.tienCoc(tp.getSoPhong()));
            Formatter ftm = new Formatter();
            ftm.format("%." + bg.scale() + "f", bg);
            Object[] obj = {tp.getMaThue(), tp.getCmnd(), name, tp.getSoPhong(), loaiPhong, tp.getNgayThue(), tp.getNgayTra(), thuePhongDao.soDV(tp.getMaThue()), ftm};
            model.addRow(obj);
        }
    }

    public HoaDon getValueHoaDon() {
        HoaDon hd = new HoaDon();
        int maHD = hdDao.selectByMaThue(maThue).getMaHD();
        int soDV = Integer.parseInt(tbl_CheckOut.getValueAt(index, 7).toString());
        hd.setCmnd(cmnd);
        hd.setMaKM(maKM);
        hd.setMaNV(Auth.user.getMaNV());
        hd.setNgayXuat(date);
        hd.setThanhTien(thanhTien);
        hd.setSoPhong(soPhong);
        hd.setMaHD(maHD);
        hd.setSoNgay(hdDao.soNgay(maThue));
        hd.setSodv(soDV);
        hd.setTinhTrang("Đã thanh toán");
        return hd;

    }

    public Phong getValuePhong() {
        Phong p = new Phong();
        p.setTinhTrang("Đang dọn dẹp");
        p.setSoPhong(soPhong);
        return p;
    }
    
    public DatTruoc updateStatus(){
        DatTruoc dt = new DatTruoc();
        DatTruoc d = dtDao.selectMaDT(soPhong);
        dt.setMaDT(d.getMaDT());
        dt.setTinhTrang("Đã thanh toán");
        return dt;
    }

    public void traPhong() {
        hdDao.update(getValueHoaDon());
        pDao.updateTrangThaiPhong(getValuePhong());
        if(tienCoc > 0){
        dtDao.updateStatus(updateStatus());
        }
        thuePhongDao.delete(maThue);
         MsgBox.alert(this,"Thanh toán thành công");
        fillTable();
    }

    public ThuePhong giaHan() {
        ThuePhong t = new ThuePhong();
        String s = JOptionPane.showInputDialog(null, "Số ngày muốn gia hạn");

        if (s == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số ngày muốn gia hạn");
            return null;
        }
        int soNgay = 0;
        try {
            soNgay = Integer.parseInt(s);
            if (soNgay <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            MsgBox.alert(null, "Số ngày chỉ nhập số nguyên(lớn hơn 0)");
            return null;
        }

        Date d = XDate.toDate(tbl_CheckOut.getValueAt(index, 6).toString(), "yyyy-MM-dd");
        t.setMaThue(maThue);
        t.setNgayTra(XDate.addDays(d, soNgay));
        t.setNgayThue(listThuePhong.get(index).getNgayThue());
        t.setCmnd(listThuePhong.get(index).getCmnd());
        t.setSoPhong(listThuePhong.get(index).getSoPhong());
        return t;
    }

    public void themDichVu() {
        ChonDichVu dv1 = new ChonDichVu();
        dv1.setVisible(true);
        dv1.cbo_LoaiDichVu.addActionListener((ActionEvent e) -> {
            dv1.clearList();
            if (dv1.cbo_LoaiDichVu.getSelectedIndex() == 0) {
                dv1.fillAll();
            } else {
                dv1.fillTypeOfService();
            }
            for (int i = 0; i < dv1.listPnlMon.size(); i++) {
                int index1 = i;
                dv1.listPnlMon.get(i).addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        SoLuong sl = new SoLuong();
                        sl.setLocationRelativeTo(dv1);
                        sl.setVisible(true);
                        sl.lblRoomNumber.setText("Phòng số " + soPhong);
                        sl.lblServiceName.setText("" + dv1.listDichVu.get(index1).getTenDV());
                        sl.btnAdd.addActionListener((ActionEvent e1) -> {
                            int maHD = hdDao.selectByMaThue(maThue).getMaHD();
                            ChiTietHoaDon ct = new ChiTietHoaDon();
                            ct.setMaHD(maHD);
                            ct.setMaDV(dv1.listDichVu.get(index1).getMaDV());
                            ct.setNgaySuDung(date);
                            int count = sl.count;
                            for (int i1 = 0; i1 < count; i1++) {
                                ctDao.insert(ct);
                            }
                            fillTable();
                             MsgBox.alert(dv1,"Thêm dịch vụ thành công");
                            sl.dispose();
                        });
                    }
                });
            }
        });
    }
    
    float tongTienDV;
    public void fillService() {
        float tongTien = 0;
        
        DefaultTableModel model = (DefaultTableModel) tbl_Service.getModel();
        model.setRowCount(0);
        List<Object[]> list = thuePhongDao.tenDichVu(maThue);
        int sTT = 1;

        for (Object[] row : list) {
            int soLuong = Integer.parseInt(row[2].toString());
            float donGia = Float.parseFloat(row[1].toString());
            float thanhTien = soLuong * donGia;
            tongTien += thanhTien;
            model.addRow(new Object[]{sTT++, row[0], soLuong, nf.format(donGia), row[3],nf.format(thanhTien)});
        }
        tongTienDV = tongTien;
        lblTienDV.setText("Tổng tiền dịch vụ: " + nf.format(tongTienDV));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnitThemDv = new javax.swing.JMenuItem();
        giaHan = new javax.swing.JMenuItem();
        DoiPhong = new javax.swing.JMenuItem();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        txtKeyWord = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_CheckOut = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btn_TraPhong = new com.k33ptoo.components.KButton();
        lblKetThuc1 = new javax.swing.JLabel();
        lblThuLai1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblPhong = new javax.swing.JLabel();
        lblTienDV = new javax.swing.JLabel();
        lblSoNgay = new javax.swing.JLabel();
        lblTienPhong = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        lblMaGiamGia = new javax.swing.JLabel();
        txtMaGiamGia = new javax.swing.JTextField();
        lblTienCoc = new javax.swing.JLabel();
        lblNgayDen = new javax.swing.JLabel();
        lblNgayDi = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        lblTongTien = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblNguoiThu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Service = new javax.swing.JTable();
        lblTienKhach = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        txtTienKhach = new javax.swing.JTextField();

        mnitThemDv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnitThemDv.setText("Thêm dịch vụ");
        mnitThemDv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnitThemDvMousePressed(evt);
            }
        });
        jPopupMenu1.add(mnitThemDv);

        giaHan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        giaHan.setText("Gia hạn");
        giaHan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                giaHanMousePressed(evt);
            }
        });
        jPopupMenu1.add(giaHan);

        DoiPhong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        DoiPhong.setText("Đổi phòng");
        jPopupMenu1.add(DoiPhong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtKeyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyReleased(evt);
            }
        });
        kGradientPanel1.add(txtKeyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 124, 219, 20));

        tbl_CheckOut.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_CheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null,null},
                {null, null, null, null, null, null, null, null,null},
                {null, null, null, null, null, null, null, null,null},
                {null, null, null, null, null, null, null, null,null}
            },
            new String [] {
                "Mã Thuê", "CMND", "Tên khách hàng", "Số Phòng", "Loại Phòng", "Ngày Thuê", "Ngày Trả", "Dịch Vụ","Tiền cọc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_CheckOut.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_CheckOut.setRowHeight(20);
        tbl_CheckOut.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_CheckOut.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_CheckOut.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_CheckOut.setShowHorizontalLines(false);
        tbl_CheckOut.setShowVerticalLines(false);
        tbl_CheckOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbl_CheckOutMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tbl_CheckOutMouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_CheckOut);

        kGradientPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 209, 881, 275));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Trả Phòng");
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 39, -1, -1));
        kGradientPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 162, 881, 10));

        btn_TraPhong.setText("Trả phòng");
        btn_TraPhong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_TraPhong.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_TraPhong.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btn_TraPhong.setkStartColor(new java.awt.Color(0, 153, 255));
        kGradientPanel1.add(btn_TraPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        lblKetThuc1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetThuc1.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/close_1.png"))
        );
        lblKetThuc1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKetThuc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetThuc1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblKetThuc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(876, 0, 29, 21));

        lblThuLai1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThuLai1.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/minus.png"))
        );
        lblThuLai1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThuLai1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThuLai1MouseClicked(evt);
            }
        });
        kGradientPanel1.add(lblThuLai1, new org.netbeans.lib.awtextra.AbsoluteConstraints(836, 0, 28, 21));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CMND:");
        kGradientPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 123, -1, -1));

        getContentPane().add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Khách sạn BamBoo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 13, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Hóa Đơn");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 70, -1, -1));

        lblPhong.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPhong.setText("Phòng số P101 (Đơn)");
        jPanel1.add(lblPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        lblTienDV.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTienDV.setText("Tổng tiền dịch vụ:");
        jPanel1.add(lblTienDV, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 310, -1, -1));

        lblSoNgay.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblSoNgay.setText("Số ngày ở:");
        jPanel1.add(lblSoNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 339, 120, -1));

        lblTienPhong.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTienPhong.setText("Tiền phòng:");
        jPanel1.add(lblTienPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 368, 150, -1));

        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblGiamGia.setText("Giảm giá:");
        jPanel1.add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 397, 160, -1));

        lblMaGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblMaGiamGia.setText("Mã giảm giá(nếu có):");
        jPanel1.add(lblMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 429, -1, -1));

        txtMaGiamGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaGiamGiaKeyReleased(evt);
            }
        });
        jPanel1.add(txtMaGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 426, 107, -1));

        lblTienCoc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTienCoc.setText("Tiền cọc:");
        jPanel1.add(lblTienCoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 310, 130, -1));

        lblNgayDen.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNgayDen.setText("Ngày đến:");
        jPanel1.add(lblNgayDen, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 339, 140, -1));

        lblNgayDi.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNgayDi.setText("Ngày đi:");
        jPanel1.add(lblNgayDi, new org.netbeans.lib.awtextra.AbsoluteConstraints(277, 368, 130, -1));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 410, 10));

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTongTien.setText("Tổng tiền:");
        jPanel1.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 470, 160, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Người Thu Tiền");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 90, -1));

        lblNguoiThu.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblNguoiThu.setText("Nguyễn Kim Ngân");
        jPanel1.add(lblNguoiThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 140, -1));

        jScrollPane1.setBorder(null);

        tbl_Service.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        tbl_Service.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Tên", "SL", "Đ.giá", "Ngày sử dụng", "T.tiền"
            }
        ));
        tbl_Service.setGridColor(new java.awt.Color(255, 255, 255));
        tbl_Service.setRowHeight(20);
        tbl_Service.setSelectionBackground(new java.awt.Color(0, 158, 250));
        tbl_Service.setShowHorizontalLines(false);
        tbl_Service.setShowVerticalLines(false);
        tbl_Service.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ServiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Service);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 420, 140));

        lblTienKhach.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTienKhach.setText("Tiền khách đưa:");
        jPanel1.add(lblTienKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        lblTienThua.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblTienThua.setText("Tiền thừa:");
        jPanel1.add(lblTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        txtTienThua.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jPanel1.add(txtTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 130, -1));

        txtTienKhach.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtTienKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtTienKhachMouseReleased(evt);
            }
        });
        jPanel1.add(txtTienKhach, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 440, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKetThuc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThuc1MouseClicked

        this.dispose();
    }//GEN-LAST:event_lblKetThuc1MouseClicked

    private void lblThuLai1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLai1MouseClicked
        // TODO add your handling code here:
        this.setState(TraPhongUI.ICONIFIED);
    }//GEN-LAST:event_lblThuLai1MouseClicked

    private void tbl_CheckOutMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CheckOutMouseReleased

        if (evt.getButton() == MouseEvent.BUTTON3) {
            if (evt.isPopupTrigger() && tbl_CheckOut.getSelectedRowCount() != 0) {
                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
            }
        }
    }//GEN-LAST:event_tbl_CheckOutMouseReleased

    private void mnitThemDvMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnitThemDvMousePressed

        themDichVu();

    }//GEN-LAST:event_mnitThemDvMousePressed

    private void giaHanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_giaHanMousePressed
        ThuePhong p = giaHan();
        if (p == null) {
            return;
        }
        thuePhongDao.update(p);
        fillTable();
        MsgBox.alert(null, "Gia hạn thành công");
    }//GEN-LAST:event_giaHanMousePressed
    float tienGiam = 0;
    String soPhong;
    String maloai;
    String loaiPhong;
    int maThue;
    int soNgay;
    float tienPhong;
    NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
    float tienCoc;
    String ngayDen;
    float thanhTien;
    String maKM;
    String cmnd;
    float tienKhach;
    float tienThua;
    
    public void setFormHoaDon(){
        index = tbl_CheckOut.getSelectedRow();
        soPhong = tbl_CheckOut.getValueAt(index, 3).toString();
        maloai = pDao.selectById(soPhong).getMaLP();
        loaiPhong = lDao.selectById(maloai).getTenLP();
        maThue = (int) tbl_CheckOut.getValueAt(index, 0);
        soNgay = (int) hdDao.soNgay(maThue);
        tienPhong = thuePhongDao.getThanhTien(maThue);
        cmnd = tbl_CheckOut.getValueAt(index, 1).toString();
        fillService();
        NumberFormat nf = NumberFormat.getInstance(new Locale("vi", "VN"));
        tienCoc = Float.parseFloat(tbl_CheckOut.getValueAt(index, 8).toString());
        ngayDen = tbl_CheckOut.getValueAt(index, 5).toString();
        thanhTien = tienPhong - tienCoc + tongTienDV;

        if (tienGiam != 0) {
            thanhTien -= (thanhTien * tienGiam);
        }

        lblPhong.setText("Phòng số " + soPhong + "(" + loaiPhong + ")");
        lblSoNgay.setText("Số ngày ở: " + soNgay);
        lblTienPhong.setText("Tiền phòng: " + nf.format(tienPhong));
        lblTienCoc.setText("Tiền cọc: " + tienCoc);
        lblNgayDen.setText("Ngày Đến: " + ngayDen);
        lblNgayDi.setText("Ngày Đi: " + XDate.toString(date, "yyyy-MM-dd"));
        lblTongTien.setText("Tổng tiền: " + nf.format(thanhTien));
        lblNguoiThu.setText(Auth.user.getHoTen());
    }
    
    private void tbl_CheckOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CheckOutMousePressed
        setFormHoaDon();

    }//GEN-LAST:event_tbl_CheckOutMousePressed

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        model = (DefaultTableModel) tbl_CheckOut.getModel();
        model.setRowCount(0);
        listThuePhong.clear();
        listThuePhong = thuePhongDao.selectByKeyWord(txtKeyWord.getText());
        for (int i = 0; i < listThuePhong.size(); i++) {
            ThuePhong tp = listThuePhong.get(i);
            String name = khDao.selectById(tp.getCmnd()).getTenKH();
            String maloai = pDao.selectById(tp.getSoPhong()).getMaLP();
            String loaiPhong = lDao.selectById(maloai).getTenLP();
            BigDecimal bg = new BigDecimal(thuePhongDao.tienCoc(tp.getSoPhong()));
            Formatter ftm = new Formatter();
            ftm.format("%." + bg.scale() + "f", bg);
            Object[] obj = {tp.getMaThue(), tp.getCmnd(), name, tp.getSoPhong(), loaiPhong, tp.getNgayThue(), tp.getNgayTra(), thuePhongDao.soDV(tp.getMaThue()),ftm};
            model.addRow(obj);
        }
        
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void tbl_ServiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ServiceMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbl_ServiceMouseClicked

    private void txtMaGiamGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaGiamGiaKeyReleased

        KhuyenMai km = kmDao.selectById(txtMaGiamGia.getText());
        if (km == null) {
            maKM = null;
            tienGiam = 0;
            lblGiamGia.setText("Giảm giá: " + 0 + "%");
        } else {
            maKM = km.getMaKM();
            tienGiam = km.getPhanTramGiam() / 100;
            lblGiamGia.setText("Giảm giá: " + km.getPhanTramGiam() + "%");
        }
        thanhTien = tienPhong - tienCoc + tongTienDV;
        if (tienGiam != 0) {
            thanhTien -= (thanhTien * tienGiam);
        }
        lblTongTien.setText("Tổng tiền: " + nf.format(thanhTien));
    }//GEN-LAST:event_txtMaGiamGiaKeyReleased

    private void txtTienKhachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachMouseReleased

        if (!txtTienKhach.getText().trim().isEmpty()) {
            try {
                tienKhach = Float.parseFloat(txtTienKhach.getText());
                tienThua = tienKhach - thanhTien;
                txtTienThua.setText("" + nf.format(tienThua));
            } catch (NumberFormatException e) {
                MsgBox.alert(this, "Chỉ được nhập số!!");
            }

        } else {
            txtTienThua.setText("");
        }

    }//GEN-LAST:event_txtTienKhachMouseReleased

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
            java.util.logging.Logger.getLogger(TraPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraPhongUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new TraPhongUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DoiPhong;
    public com.k33ptoo.components.KButton btn_TraPhong;
    private javax.swing.JMenuItem giaHan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblKetThuc1;
    private javax.swing.JLabel lblMaGiamGia;
    private javax.swing.JLabel lblNgayDen;
    private javax.swing.JLabel lblNgayDi;
    private javax.swing.JLabel lblNguoiThu;
    private javax.swing.JLabel lblPhong;
    private javax.swing.JLabel lblSoNgay;
    private javax.swing.JLabel lblThuLai1;
    private javax.swing.JLabel lblTienCoc;
    private javax.swing.JLabel lblTienDV;
    private javax.swing.JLabel lblTienKhach;
    private javax.swing.JLabel lblTienPhong;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JMenuItem mnitThemDv;
    public javax.swing.JTable tbl_CheckOut;
    private javax.swing.JTable tbl_Service;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtMaGiamGia;
    private javax.swing.JTextField txtTienKhach;
    private javax.swing.JTextField txtTienThua;
    // End of variables declaration//GEN-END:variables

    private void init() {
        this.setLocationRelativeTo(null);

    }

}
