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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import com.Entity.KhachHang;
import com.Entity.LoaiPhong;
import com.Entity.Phong;
import com.Entity.ThuePhong;
import java.sql.Date;
import com.Entity.DatTruoc;
import com.utils.MsgBox;
import com.utils.XDate;
import com.Entity.HoaDon;
import com.utils.Auth;

/**
 *
 * @author Admin
 */
public class ThuePhongUI extends javax.swing.JFrame {

    PhongDAO spDao = new PhongDAO();
    LoaiPhongDAO lDao = new LoaiPhongDAO();
    KhachHangDAO khDao = new KhachHangDAO();
    ThuePhongDAO tpDao = new ThuePhongDAO();
    DatTruocDAO dtDao = new DatTruocDAO();
    HoaDonDAO hdDao = new HoaDonDAO();
    long millis = System.currentTimeMillis();
    Date date = new Date(millis);

    public ThuePhongUI() {
        initComponents();
        this.setVisible(true);
        setLocationRelativeTo(null);
        chk_DatTruoc1.setSelected(false);
        txt_DatCoc.setVisible(false);
        DC_NgayNhan.setVisible(false);
        lblNgayNhan1.setVisible(false);
        lblCoc1.setVisible(false);
        fillComboBoxLoaiPhong();
       

    }

    public void fillComboBoxPhong() {
        LoaiPhong loai = (LoaiPhong) cbo_LoaiPhong.getSelectedItem();
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_SoPhong.getModel();
        model.removeAllElements();
        List<Phong> list = spDao.selectByIdLoaiPhong(loai.getMaLP());//lấy số phòng theo mã loại
        list.forEach((element) -> {
            model.addElement(element);
        });
        model.toString();
    }

    public void fillComboBoxLoaiPhong() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbo_LoaiPhong.getModel();
        model.removeAllElements();
        List<LoaiPhong> list = lDao.selectAll();//lấy tất cả loại phòng có trong DB
        list.forEach((element) -> {
            model.addElement(element);
        });
        model.toString();
        
    }

    public KhachHang getValueKhachHang() {
        KhachHang k = new KhachHang();
        k.setTenKH(txtHoTen.getText());
        k.setDiaChi(txtDia.getText());
        if (rdo_Nam.isSelected()) {
            k.setGioiTinh(true);
        } else {
            k.setGioiTinh(false);
        }
        k.setNgaySinh(DC_NgaySinh.getDate());
        k.setSoDT(txt_SoDT.getText());
        k.setCmnd(txt_CMND.getText());
        return k;
    }

    public boolean checkForm() {
        if (txtDia.getText().trim().isEmpty()) {
            MsgBox.alert(null, "Vui lòng nhập địa chỉ");
            return false;
        } else if (txtHoTen.getText().trim().isEmpty()) {
            MsgBox.alert(null, "Vui lòng nhập họ tên");
            return false;
        } else if (txtHoTen.getText().trim().matches("[\\sa-zA-ZaAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\n"
                + "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\n"
                + "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]+") == false) {

            MsgBox.alert(null, "Vui lòng nhập họ tên hợp lệ");
            return false;
        } else if (txt_CMND.getText().trim().matches("[0-9]{9,12}") == false) {
            MsgBox.alert(null, "Chứng minh nhân dân phải từ 9-12 số");
            return false;
        } else if (txt_NgayThue.getText().trim().isEmpty()) {
            MsgBox.alert(null, "Vui lòng nhập số ngày thuê");
            return false;
        } else if (txt_SoDT.getText().trim().isEmpty()) {
            MsgBox.alert(null, "Vui lòng nhập số điện thoại");
            return false;
        } else if (txt_SoDT.getText().matches("[01-9]{9}")) {
            MsgBox.alert(null, "Số điện thoại phải đúng 10 số");
            return false;
        }else if(DC_NgaySinh.getDate() == null){
             MsgBox.alert(null, "Vui lòng điền năm sinh");
            return false;
        }
        try {
            int ngayThue = Integer.parseInt(txt_NgayThue.getText());
            if (ngayThue <= 0) {
                throw new Exception();
            }
        } catch (Exception e) {
            MsgBox.alert(null, "Số ngày thuê chỉ nhập số nguyên");
            return false;
        }
        
        if (chk_DatTruoc1.isSelected()) {
            if (DC_NgayNhan.getDate() == null) {
                MsgBox.alert(null, "Vui lòng điền ngày nhận phòng");
                return false;
            } else if (txt_DatCoc.getText().trim().isEmpty()) {
                MsgBox.alert(null, "Không để trống tiền cọc");
                return false;
            }
            try {
                float coc = Float.parseFloat(txt_DatCoc.getText());
                if (coc <= 0) {
                    throw new Exception();
                }
            } catch (Exception e) {
                MsgBox.alert(null, "Tiền cọc vui lòng nhập số(không nhỏ hơn hoặc bằng 0)");
                return false;
            }
        }

        return true;
    }
    

    public ThuePhong getValueThuePhong() {
        ThuePhong t = new ThuePhong();
        Phong p = (Phong) cbo_SoPhong.getSelectedItem();
        List<ThuePhong> list = tpDao.selectAll();
        int maThue;
        if(list.size() == 0)
            maThue  = list.size() + 1;
        else{
        maThue  = list.get(list.size() -1).getMaThue() + 1;
        }
        t.setMaThue(maThue);
        t.setNgayTra(XDate.addDays(date, Integer.parseInt(txt_NgayThue.getText())));
        t.setSoPhong(p.getSoPhong());
        t.setCmnd(txt_CMND.getText());
        t.setNgayThue(date);
        return t;
    }

    public DatTruoc getValueDatTruoc() {
        DatTruoc d = new DatTruoc();
        Phong p = (Phong) cbo_SoPhong.getSelectedItem();
        d.setNgayTra(XDate.addDays(DC_NgayNhan.getDate(), Integer.parseInt(txt_NgayThue.getText())));
        d.setNgayNhanPhong(DC_NgayNhan.getDate());
        d.setSoPhong(p.getSoPhong());
        d.setTinhTrang("Chờ nhận phòng");
        d.setTienDatCoc(Float.parseFloat(txt_DatCoc.getText()));
        d.setCmnd(txt_CMND.getText());
        d.setMaNV(Auth.user.getMaNV());
        return d;
    }
    
    public HoaDon getValueHoaDon() {
        HoaDon hd = new HoaDon();
        String cmnd = txt_CMND.getText();
        List<ThuePhong> list = tpDao.selectAll();
        int maThue  = list.get(list.size() -1).getMaThue();
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
    
    public Phong getValuePhong(){
        Phong p = new Phong();
        Phong p1 = (Phong) cbo_SoPhong.getSelectedItem();
        p.setTinhTrang("Đã có người");
        p.setSoPhong(p1.getSoPhong());
        return p;
    }

    public void add() {
        boolean check = true;
        Phong p = (Phong) cbo_SoPhong.getSelectedItem();
        if(p.getTinhTrang().equalsIgnoreCase("đã có người")){
            MsgBox.alert(null,"Phòng này đã có người xin vui lòng chọn phòng khác");
            return;
        }
        
        List<KhachHang> list = khDao.selectAll();
        for(int i =0 ;i<list.size() ; i ++){ //kiểm tra khách hàng đã từng đến KS
            KhachHang k = list.get(i);
            if(txt_CMND.getText().trim().equals(k.getCmnd().trim())){
                check = false;
            }
        }
        
         
        
        if(check == true)    
        khDao.insert(getValueKhachHang());
        if (chk_DatTruoc1.isSelected()){
            dtDao.insert(getValueDatTruoc());
        }
         else {
            tpDao.insert(getValueThuePhong());
            hdDao.insert(getValueHoaDon());
            spDao.updateTrangThaiPhong(getValuePhong());
        }
        

    }

    public void clearForm() {
        txtDia.setText("");
        txtHoTen.setText("");
        txt_CMND.setText("");
        txt_DatCoc.setText("");
        txt_SoDT.setText("");
        buttonGroup1.clearSelection();
        DC_NgayNhan.setDate(null);
        DC_NgaySinh.setDate(null);
        txt_NgayThue.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtDia = new javax.swing.JTextField();
        rdo_Nu = new javax.swing.JRadioButton();
        rdo_Nam = new javax.swing.JRadioButton();
        txt_SoDT = new javax.swing.JTextField();
        txt_CMND = new javax.swing.JTextField();
        DC_NgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblNgayNhan1 = new javax.swing.JLabel();
        lblCoc1 = new javax.swing.JLabel();
        cbo_SoPhong = new javax.swing.JComboBox<>();
        cbo_LoaiPhong = new javax.swing.JComboBox<>();
        chk_DatTruoc1 = new javax.swing.JCheckBox();
        DC_NgayNhan = new com.toedter.calendar.JDateChooser();
        txt_DatCoc = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_ThemPhong = new com.k33ptoo.components.KButton();
        btn_New = new com.k33ptoo.components.KButton();
        lblKetThuc = new javax.swing.JLabel();
        lblThuLai = new javax.swing.JLabel();
        txt_NgayThue = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 102, 255));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkTransparentControls(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Họ và tên:");
        jLabel11.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Địa chỉ:");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Giới tính:");
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Số điện thoại:");
        jLabel14.setToolTipText("");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("CMND:");
        jLabel15.setToolTipText("");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Ngày sinh:");
        jLabel16.setToolTipText("");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtDia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        buttonGroup1.add(rdo_Nu);
        rdo_Nu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdo_Nu.setForeground(new java.awt.Color(255, 255, 255));
        rdo_Nu.setText("Nữ");
        rdo_Nu.setOpaque(false);

        buttonGroup1.add(rdo_Nam);
        rdo_Nam.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdo_Nam.setForeground(new java.awt.Color(255, 255, 255));
        rdo_Nam.setSelected(true);
        rdo_Nam.setText("Nam");
        rdo_Nam.setOpaque(false);

        txt_SoDT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txt_CMND.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txt_CMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_CMNDActionPerformed(evt);
            }
        });

        DC_NgaySinh.setDateFormatString("yyyy-MM-dd");
        DC_NgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Số ngày thuê");
        jLabel17.setToolTipText("");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Số phòng:");
        jLabel19.setToolTipText("");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Loại phòng:");
        jLabel20.setToolTipText("");

        lblNgayNhan1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNgayNhan1.setForeground(new java.awt.Color(255, 255, 255));
        lblNgayNhan1.setText("Ngày nhận:");
        lblNgayNhan1.setToolTipText("");

        lblCoc1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblCoc1.setForeground(new java.awt.Color(255, 255, 255));
        lblCoc1.setText("Tiền cọc:");
        lblCoc1.setToolTipText("");

        cbo_SoPhong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbo_LoaiPhong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbo_LoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_LoaiPhongActionPerformed(evt);
            }
        });

        chk_DatTruoc1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chk_DatTruoc1.setForeground(new java.awt.Color(255, 255, 255));
        chk_DatTruoc1.setText("Đặt trước");
        chk_DatTruoc1.setOpaque(false);
        chk_DatTruoc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                chk_DatTruoc1MousePressed(evt);
            }
        });

        DC_NgayNhan.setDateFormatString("yyyy-MM-dd");
        DC_NgayNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DatCoc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btn_ThemPhong.setText("Thêm phòng");
        btn_ThemPhong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_ThemPhong.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_ThemPhong.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btn_ThemPhong.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_ThemPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemPhongActionPerformed(evt);
            }
        });

        btn_New.setText("Làm mới");
        btn_New.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_New.setkEndColor(new java.awt.Color(255, 255, 255));
        btn_New.setkHoverStartColor(new java.awt.Color(0, 204, 204));
        btn_New.setkStartColor(new java.awt.Color(0, 153, 255));
        btn_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewActionPerformed(evt);
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

        txt_NgayThue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Thuê Phòng");
        jLabel18.setToolTipText("");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(191, 191, 191)
                .addComponent(btn_ThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btn_New, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(rdo_Nam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdo_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtDia)
                                    .addComponent(txt_SoDT)
                                    .addComponent(txt_CMND)
                                    .addComponent(DC_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(txtHoTen))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addGap(16, 16, 16))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lblCoc1)
                                                    .addComponent(lblNgayNhan1))
                                                .addGap(18, 18, 18))
                                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel19)
                                                .addGap(27, 27, 27))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_NgayThue)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(chk_DatTruoc1))
                                    .addComponent(txt_DatCoc)
                                    .addComponent(DC_NgayNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(cbo_SoPhong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbo_LoaiPhong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(220, 220, 220)
                        .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {lblCoc1, lblNgayNhan1});

        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_NgayThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(rdo_Nu)
                            .addComponent(rdo_Nam))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_SoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_CMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DC_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cbo_SoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(cbo_LoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chk_DatTruoc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DC_NgayNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayNhan1))
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_DatCoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCoc1))))
                .addGap(92, 92, 92)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_New, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {lblCoc1, lblNgayNhan1});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_CMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_CMNDActionPerformed
       
    }//GEN-LAST:event_txt_CMNDActionPerformed

    private void chk_DatTruoc1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chk_DatTruoc1MousePressed
        if (chk_DatTruoc1.isSelected()) {
            txt_DatCoc.setVisible(false);
            DC_NgayNhan.setVisible(false);
            lblNgayNhan1.setVisible(false);
            lblCoc1.setVisible(false);
        } else {
            txt_DatCoc.setVisible(true);
            DC_NgayNhan.setVisible(true);
            lblNgayNhan1.setVisible(true);
            lblCoc1.setVisible(true);
        }
    }//GEN-LAST:event_chk_DatTruoc1MousePressed

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(ThuePhongUI.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void cbo_LoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_LoaiPhongActionPerformed
        fillComboBoxPhong();
    }//GEN-LAST:event_cbo_LoaiPhongActionPerformed

    private void btn_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewActionPerformed
        clearForm();
    }//GEN-LAST:event_btn_NewActionPerformed

    private void btn_ThemPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemPhongActionPerformed
      
    }//GEN-LAST:event_btn_ThemPhongActionPerformed

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
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThuePhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThuePhongUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DC_NgayNhan;
    private com.toedter.calendar.JDateChooser DC_NgaySinh;
    private com.k33ptoo.components.KButton btn_New;
    public com.k33ptoo.components.KButton btn_ThemPhong;
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> cbo_LoaiPhong;
    public javax.swing.JComboBox<String> cbo_SoPhong;
    public javax.swing.JCheckBox chk_DatTruoc1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblCoc1;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblNgayNhan1;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JRadioButton rdo_Nam;
    private javax.swing.JRadioButton rdo_Nu;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txt_CMND;
    private javax.swing.JTextField txt_DatCoc;
    private javax.swing.JTextField txt_NgayThue;
    private javax.swing.JTextField txt_SoDT;
    // End of variables declaration//GEN-END:variables
}
