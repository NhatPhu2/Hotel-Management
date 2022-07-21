/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.DatTruocDAO;
import com.DAO.HoaDonDAO;
import com.DAO.LoaiPhongDAO;
import com.DAO.PhongDAO;
import com.Entity.DatTruoc;
import com.Entity.HoaDon;
import com.Entity.LoaiPhong;
import com.Entity.Phong;
import com.Entity.ThuePhong;
import com.utils.Auth;
import com.utils.ButtonCustom;
import com.utils.MsgBox;
import com.utils.XDate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class MainForm extends javax.swing.JFrame {

    PhongDAO pDao = new PhongDAO();
    LoaiPhongDAO lDao = new LoaiPhongDAO();
    DatTruocDAO dtDao = new DatTruocDAO();
    List<Phong> listPhong = pDao.selectAll();
    List<DatTruoc> listPhongDatTruoc = dtDao.selectAll();
    HoaDonDAO hdDao = new HoaDonDAO();
    int size = listPhong.size();
    List<JLabel> soPhong = new ArrayList<>();
    List<JLabel> loai = new ArrayList<>();
    List<ButtonCustom> button = new ArrayList<>();
    List<JLabel> image = new ArrayList<>();
    long millis = System.currentTimeMillis();
    Date date = new Date(millis);

    public MainForm() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        execute();
        fillPhong();
        soPhongTrong();
        fillDatTruoc();
        fillStatus();
        action();
        datTruocQuaHan();
        themHĐatTruocQuaHan();

        getContentPane().setBackground(Color.white);
        PanelExit.setBackground(new Color(51, 0, 51));
        lblNameNV.setText(Auth.user.getHoTen());

    }

    public void soPhongTrong() {
        pnlCart.removeAll();
        pnlCart.repaint();
        listPhong = pDao.selectAll();
        int soPhongTrong = 0;
        int phongDaThue = 0;
        int donDep = 0;
        for (int i = 0; i < listPhong.size(); i++) {
            Phong p = listPhong.get(i);
            if (p.getTinhTrang().equalsIgnoreCase("Trống")) {
                soPhongTrong += 1;
            } else if (p.getTinhTrang().equalsIgnoreCase("Đã có người")) {
                phongDaThue += 1;
            } else if (p.getTinhTrang().equalsIgnoreCase("Đang dọn dẹp")) {
                donDep += 1;
            }
        }
        Form_Cart c = new Form_Cart();
        c.cart1.data(new Model_Cart(donDep + "", "Đang dọn dẹp"));
        c.cart2.data(new Model_Cart(soPhongTrong + "", "Phòng Trống"));
        c.cart3.data(new Model_Cart(phongDaThue + "", "Đã Thuê"));
        pnlCart.add(c);
        this.setVisible(true);
    }

    //thông báo
    //thanh toán các phòng đặt trước đã hủy bỏ
    public void themHĐatTruocQuaHan() {
        HoaDon hd = new HoaDon();
        for (int i = 0; i < listPhongDatTruoc.size(); i++) {
            DatTruoc dt = listPhongDatTruoc.get(i);
            if (dt.getTinhTrang().equalsIgnoreCase("Quá hạn")) {

                hd.setCmnd(dt.getCmnd());
                hd.setMaKM(null);
                hd.setMaNV(Auth.user.getMaNV());
                hd.setNgayXuat(date);
                hd.setThanhTien(dt.getTienDatCoc());
                hd.setSoPhong(dt.getSoPhong());
                hd.setSoNgay(0);
                hd.setSodv(0);
                hd.setNgayLap(dt.getNgayNhanPhong());
                hd.setMaThue(null);
                hd.setTinhTrang("Đã thanh toán");
                hdDao.insert(hd);

                DatTruoc d = new DatTruoc();
                d.setMaDT(dt.getMaDT());
                d.setTinhTrang("Đã hủy");
                dtDao.updateStatus(d);

            }
        }

    }

    //cập nhật các phòng đặt trước quá hạn
    public void datTruocQuaHan() {

        for (int i = 0; i < listPhongDatTruoc.size(); i++) {
            DatTruoc d = listPhongDatTruoc.get(i);
            java.sql.Date sqlDate = new java.sql.Date(d.getNgayNhanPhong().getTime());
            if (XDate.toString(sqlDate, "yyyy-MM-dd").compareTo(XDate.toString(date, "yyyy-MM-dd")) == -1
                    && d.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                DatTruoc dt = new DatTruoc();
                dt.setMaDT(d.getMaDT());
                dt.setTinhTrang("Quá hạn");
                dtDao.updateStatus(dt);

                Phong pp = new Phong();
                pp.setSoPhong(d.getSoPhong());
                pp.setTinhTrang("Trống");
                pDao.updateTrangThaiPhong(pp);

            }
        }

    }

    //sự kiện button
    public void action() {

        for (int i = 0; i < button.size(); i++) {
            int index = i;

            button.get(i).addActionListener((ActionEvent e) -> {
                String data = e.getActionCommand();
                int indexx = -1;
                if (data.equalsIgnoreCase("thuê phòng")) {
                    ThuePhongUI t = new ThuePhongUI();
                    t.setVisible(true);
                    LoaiPhong loaiList = lDao.selectById(listPhong.get(index).getMaLP());
                    Phong p = pDao.selectById(soPhong.get(index).getText());
                    t.cbo_LoaiPhong.getModel().setSelectedItem(loaiList);
                    t.cbo_SoPhong.getModel().setSelectedItem(p);
                    t.cbo_LoaiPhong.setEnabled(false);
                    t.cbo_SoPhong.setEnabled(false);
                    t.btn_ThemPhong.addActionListener((ActionEvent e1) -> {
                        if (t.checkForm() == false) {

                        } else {
                            t.dispose();
                            t.add();
                            MsgBox.alert(this, "Thuê phòng thành công");
                            fillDatTruoc();
                            refresh();
                            soPhongTrong();

                        }
                    });

                } else if (data.equalsIgnoreCase("trả phòng")) {
                    TraPhongUI t = new TraPhongUI();
                    t.setVisible(true);
                    for (int j = 0; j < t.listThuePhong.size(); j++) {
                        ThuePhong tt = t.listThuePhong.get(j);
                        if (tt.getSoPhong().equalsIgnoreCase(soPhong.get(index).getText())) {
                            t.tbl_CheckOut.setRowSelectionInterval(j, j);
                            t.setFormHoaDon();
                            break;
                        }
                    }
                    t.btn_TraPhong.addActionListener((ActionEvent e1) -> {
                        if (t.index == -1) {
                            MsgBox.alert(this, "Bạn chưa chọn phòng để thanh toán");
                            return;
                        }
                        t.dispose();
                        t.traPhong();
                        refresh();
                        soPhongTrong();

                    });

                } else if (data.equalsIgnoreCase("Đã có người đặt trước")) {
                    DatTruocUI dt = new DatTruocUI();
                    dt.setVisible(true);
                    List<DatTruoc> listPhongDT = dtDao.selectAll();

                    for (int j = 0; j < listPhongDT.size(); j++) {

                        DatTruoc d = listPhongDT.get(j);
                        //set chọn phòng đã đặt trước
                        if (d.getSoPhong().equalsIgnoreCase(soPhong.get(index).getText()) && d.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                            dt.tbl_DatTruoc.setRowSelectionInterval(j, j);
                            break;
                        }
                    }
                    //pop-up menu
                    dt.tbl_DatTruoc.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent e) {
                            if (e.getButton() == MouseEvent.BUTTON3) {
                                if (e.isPopupTrigger() && dt.tbl_DatTruoc.getSelectedRowCount() != 0) {
                                    dt.jPopupMenu1.show(e.getComponent(), e.getX(), e.getY());
                                }
                            }
                        }
                    });

                    dt.trangThai.addActionListener((ActionEvent e1) -> {
                        dt.datTruoc();
                        listPhong = pDao.selectAll();
                        fillStatus();
                        soPhongTrong();
                        dt.dispose();
                    });

                } else {
                    if (MsgBox.confirm(null, "Đã dọn dẹp xong ?")) {
                        Phong p = new Phong();
                        p.setSoPhong(soPhong.get(index).getText());
                        p.setTinhTrang("Trống");
                        pDao.updateTrangThaiPhong(p);
                        soPhongTrong();
                        refresh();

                    }

                }
            });

        }

    }

    public void fillPhong() {

        for (int i = 0; i < listPhong.size(); i++) {

            Phong p = listPhong.get(i);

            //text so phong
            soPhong.add(new JLabel());
            soPhong.get(i).setForeground(Color.BLUE);
            soPhong.get(i).setFont(new Font("Verdana", Font.BOLD, 13));

            soPhong.get(i).setText(p.getSoPhong());
            soPhong.get(i).setHorizontalAlignment(JLabel.CENTER);
            soPhong.get(i).setVerticalTextPosition(JLabel.CENTER);
            //end

            //loaiphong
            loai.add(new JLabel());
            loai.get(i).setForeground(Color.white);
            loai.get(i).setFont(new Font("Verdana", Font.BOLD, 13));
            loai.get(i).setText(lDao.selectById(p.getMaLP()).getTenLP());
            loai.get(i).setHorizontalAlignment(JLabel.CENTER);
            loai.get(i).setVerticalTextPosition(JLabel.CENTER);

            //button
            button.add(new ButtonCustom());
            button.get(i).setFont(new Font("Verdana", Font.BOLD, 13));
            button.get(i).setBorder(null);
            button.get(i).setBackground(Color.white);
            button.get(i).setForeground(Color.BLACK);
            button.get(i).setFocusable(false);
            button.get(i).setHorizontalAlignment(JLabel.CENTER);
            button.get(i).setVerticalTextPosition(JLabel.CENTER);
            button.get(i).setCursor(new Cursor(Cursor.HAND_CURSOR));

            //hình
            image.add(new JLabel());
            image.get(i).setLayout(new BorderLayout());
            image.get(i).setHorizontalAlignment(JLabel.CENTER);
            image.get(i).setVerticalTextPosition(JLabel.CENTER);
            image.get(i).setPreferredSize(new Dimension(150, 162));

            image.get(i).add(soPhong.get(i), BorderLayout.NORTH);
            image.get(i).add(loai.get(i), BorderLayout.CENTER);
            image.get(i).add(button.get(i), BorderLayout.SOUTH);
            pnlPhong.add(image.get(i));
        }

    }

    public void fillDatTruoc() {
        List<DatTruoc> listPhongDT = dtDao.selectAll();
        for (int i = 0; i < listPhong.size(); i++) {
            for (int j = 0; j < listPhongDT.size(); j++) {
                DatTruoc dt = listPhongDT.get(j);
                java.sql.Date sqlDate = new java.sql.Date(dt.getNgayNhanPhong().getTime());
                if (XDate.toString(sqlDate, "yyyy-MM-dd").equals(XDate.toString(date, "yyyy-MM-dd"))
                        && dt.getSoPhong().equalsIgnoreCase(soPhong.get(i).getText()) && dt.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                    Phong pp = new Phong();
                    pp.setSoPhong(soPhong.get(i).getText());
                    pp.setTinhTrang("Đã đặt trước");
                    pDao.updateTrangThaiPhong(pp);
                    break;
                }
            }

        }
    }

    public void fillStatus() {
        for (int i = 0; i < listPhong.size(); i++) {
            Phong p = listPhong.get(i);
            if (p.getTinhTrang().equalsIgnoreCase("trống")) {

                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/door1.png")));
                button.get(i).setText("Thuê phòng");
            } else if (p.getTinhTrang().equalsIgnoreCase("đã có người")) {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/door.png")));
                button.get(i).setText("Trả phòng");
            } else if (p.getTinhTrang().equalsIgnoreCase("đã đặt trước")) {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/reserved.png")));
                button.get(i).setText("Đã có người đặt trước");
            } else {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/broom.png")));
                button.get(i).setText("Đang dọn dẹp");
            }
        }
    }

    public void addMenu(MenuItem... menu) {
        for (MenuItem m : menu) {
            pnlMenu.add(m);
            ArrayList<MenuItem> subMenu = m.getList();
            for (MenuItem mm : subMenu) {
                addMenu(mm);
            }
        }
    }

    public void dangXuat() {
        this.setVisible(false);
        Auth.clear();
        new Login().setVisible(true);

    }

    public void refresh() {
        listPhong.clear();
        image.clear();
        loai.clear();
        soPhong.clear();
        button.clear();
        pnlPhong.removeAll();
        pnlPhong.repaint();
        listPhong = pDao.selectAll();
        fillPhong();
        fillDatTruoc();
        fillStatus();
        action();

    }

    public void kiemTraDatTruoc() {

    }

    public void execute() {

        MenuItem trangChu = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/hotel.png")), "Trang chủ", (ActionEvent e) -> {
            refresh();
        });

        MenuItem qlP = new MenuItem(null, "    Quản lý phòng", (ActionEvent e) -> {
            QuanLyPhong ql = new QuanLyPhong();
            ql.setVisible(true);
            ql.btn_Add1.addActionListener((ActionEvent e1) -> {
                ql.insertRoom();
                refresh();
            });
            ql.btn_Delete1.addActionListener((ActionEvent e1) -> {
                ql.deleteRoom();
                refresh();
            });
            ql.btn_Update1.addActionListener((ActionEvent e1) -> {
                ql.updateRoom();
                refresh();
            });
        });

        MenuItem dichVu = new MenuItem(null, "   Dịch vụ", (ActionEvent e) -> {
            new DichVuUI().setVisible(true);
        });
        MenuItem loaiDichVu = new MenuItem(null, "   Loại dịch vụ", (ActionEvent e) -> {
            new LoaiDichVuUI().setVisible(true);
        });
        MenuItem qlDichVu = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/customer-service.png")),
                "Dich vụ", null, dichVu, loaiDichVu);

        MenuItem doanhthu = new MenuItem(null, "   Doanh thu", (ActionEvent e) -> {
            ThongKe tk = new ThongKe();
            tk.tabs.setSelectedIndex(1);
        });
        MenuItem kh = new MenuItem(null, "   Khách hàng", (ActionEvent e) -> {
            ThongKe tk = new ThongKe();
            tk.tabs.setSelectedIndex(0);
        });
        MenuItem thongKe = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/analytics.png")), "Thống kê", null,
                doanhthu, kh);

        MenuItem khuyenMai = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/tag.png")),
                "Khuyến mãi", (ActionEvent e) -> {
                    new KhuyenMaiUI().setVisible(true);
                });

        MenuItem dangX = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/log-out.png")), "Đăng xuất", (ActionEvent e) -> {
            dangXuat();
        });

        MenuItem dattruoc = new MenuItem(null, "    Đặt trước", (ActionEvent e) -> {
            new DatTruocUI();
        });
        MenuItem thue = new MenuItem(null, "    Thuê phòng", (ActionEvent e) -> {
            ThuePhongUI t = new ThuePhongUI();
            t.btn_ThemPhong.addActionListener((ActionEvent e1) -> {
                if (t.checkForm() == false) {

                } else {
                    t.add();
                    MsgBox.alert(this, "Thuê phòng thành công");
                    fillDatTruoc();
                    refresh();
                    t.dispose();
                }
            });
        });

        MenuItem kiemTraDatTruoc = new MenuItem(null, "    Check đặt trước", (ActionEvent e) -> {
            KiemTraDatTruoc k = new KiemTraDatTruoc();
            k.setLocationRelativeTo(null);
            k.setVisible(true);
            k.btnOk.addActionListener((ActionEvent e1) -> {
                boolean check = true;
                Phong p = (Phong) k.cbo_Phong.getModel().getSelectedItem();
                listPhongDatTruoc = dtDao.selectAll();
                for (int i = 0; i < listPhongDatTruoc.size(); i++) {
                    DatTruoc dt = listPhongDatTruoc.get(i);
                    if (dt.getSoPhong().equals(p.getSoPhong()) && XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd")
                            .compareTo(XDate.toString(dt.getNgayTra(), "yyyy-MM-dd")) <= -1
                            && dt.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                        MsgBox.alert(null, "Từ ngày " + XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd") + " đến " + dt.getNgayTra() + " Phòng này đã có người đặt trước rồi");
                        check = false;
                        break;
                    } else if (dt.getSoPhong().equals(p.getSoPhong()) && XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd")
                            .compareTo(XDate.toString(dt.getNgayTra(), "yyyy-MM-dd")) == 0
                            && dt.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                        MsgBox.alert(null, "Từ ngày " + XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd") + " đến " + dt.getNgayTra() + " Phòng này đã có người đặt trước rồi");
                       check = false;
                        break;
                    } else if (dt.getSoPhong().equals(p.getSoPhong()) && XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd")
                            .compareTo(XDate.toString(dt.getNgayNhanPhong(), "yyyy-MM-dd")) == 0
                            && dt.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                        MsgBox.alert(null, "Từ ngày " + XDate.toString(k.dcsNgayNhan.getDate(), "yyyy-MM-dd") + " đến " + dt.getNgayTra() + " Phòng này đã có người đặt trước rồi");
                       check = false;
                        break;
                    }
                    
                }
                  if(check == true){
                      MsgBox.alert(this,"Phong này còn trống!");
                  }
            });
          
                
            

        });

        MenuItem qlPhong = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/double-bed.png")), "Quản lý phòng", null, qlP, dattruoc, thue, kiemTraDatTruoc);

        MenuItem qlNhanVien = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/crew.png")), "Quản lý nhân viên", (ActionEvent e) -> {
            new QuanLyNhanVien().setVisible(true);
        });

        MenuItem qlKhachHang = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/customer-feedback.png")), "Quản lý khách hàng", (ActionEvent e) -> {
            new QuanLyKhachHang().setVisible(true);
        });

        MenuItem hoaDon = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/bill.png")), "Hóa đơn", (ActionEvent e) -> {
            new HoaDonUI().setVisible(true);
        });

        addMenu(trangChu, qlNhanVien, qlPhong, qlKhachHang, qlDichVu, thongKe, khuyenMai, hoaDon, dangX);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpoMenu = new javax.swing.JPopupMenu();
        themPhong = new javax.swing.JMenuItem();
        pnlMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblNameNV = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPhong = new javax.swing.JPanel();
        pnlCart = new javax.swing.JPanel();
        PanelExit = new javax.swing.JPanel();
        lblThuLai = new javax.swing.JLabel();
        lblKetThuc = new javax.swing.JLabel();

        themPhong.setText("Thêm phòng");
        jpoMenu.add(themPhong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(0, 158, 250));
        pnlMenu.setLayout(new javax.swing.BoxLayout(pnlMenu, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNameNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNameNV.setForeground(new java.awt.Color(255, 51, 0));
        lblNameNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameNV.setText("Tên nhân viên");
        jPanel2.add(lblNameNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 140, -1));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlPhong.setBackground(new java.awt.Color(255, 255, 255));
        pnlPhong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnlPhongKeyReleased(evt);
            }
        });
        pnlPhong.setLayout(new java.awt.GridLayout(0, 4, 15, 15));
        jScrollPane1.setViewportView(pnlPhong);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 710, 550));

        pnlCart.setBackground(new java.awt.Color(255, 255, 255));
        pnlCart.setToolTipText("");
        pnlCart.setName(""); // NOI18N
        pnlCart.setPreferredSize(new java.awt.Dimension(910, 283));
        jPanel2.add(pnlCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 520, 100));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 23, 710, -1));

        PanelExit.setBackground(new java.awt.Color(51, 51, 51));
        PanelExit.setLayout(null);

        lblThuLai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThuLai.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/minus.png"))
        );
        lblThuLai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblThuLai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThuLaiMouseClicked(evt);
            }
        });
        PanelExit.add(lblThuLai);
        lblThuLai.setBounds(850, 0, 30, 20);

        lblKetThuc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblKetThuc.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/close_1.png"))
        );
        lblKetThuc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblKetThuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblKetThucMouseClicked(evt);
            }
        });
        PanelExit.add(lblKetThuc);
        lblKetThuc.setBounds(880, 0, 30, 20);

        getContentPane().add(PanelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked

        System.exit(0);
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked

        this.setState(MainForm.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked

    private void pnlPhongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlPhongKeyReleased

    }//GEN-LAST:event_pnlPhongKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If 
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelExit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu jpoMenu;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblNameNV;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JPanel pnlCart;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPhong;
    private javax.swing.JMenuItem themPhong;
    // End of variables declaration//GEN-END:variables
}
