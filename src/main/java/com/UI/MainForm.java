/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.DatTruocDAO;
import com.DAO.LoaiPhongDAO;
import com.DAO.PhongDAO;
import com.Entity.DatTruoc;
import com.Entity.LoaiPhong;
import com.Entity.Phong;
import com.Entity.ThuePhong;
import com.utils.Auth;
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
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */
public class MainForm extends javax.swing.JFrame {

    PhongDAO pDao = new PhongDAO();
    LoaiPhongDAO lDao = new LoaiPhongDAO();
    DatTruocDAO dtDao = new DatTruocDAO();
    List<Phong> list = pDao.selectAll();
    List<DatTruoc> listDatTruoc = dtDao.selectAll();
    int size = list.size();
    List<JLabel> soPhong = new ArrayList<>();
    List<JLabel> loai = new ArrayList<>();
    List<JButton> tonghop = new ArrayList<>();
    List<JLabel> image = new ArrayList<>();
    long millis = System.currentTimeMillis();
    Date date = new Date(millis);

    public MainForm() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        execute();
        fillPhong();
        fillDatTruoc();
        fillStatus();
        action();
        getContentPane().setBackground(Color.white);
        PanelExit.setBackground(new Color(51, 0, 51));
        lblNameNV.setText(Auth.user.getHoTen());

    }

    public void action() {

        for (int i = 0; i < tonghop.size(); i++) {
            int index = i;
            tonghop.get(i).addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    String data = e.getActionCommand();
                    int indexx = -1;
                    if (data.equalsIgnoreCase("thuê phòng")) {
                        List<LoaiPhong> loaiList = lDao.selectByKeyWord(soPhong.get(index).getText());
                        Phong p = pDao.selectById(soPhong.get(index).getText());
                        ThuePhongUI t = new ThuePhongUI();
                        t.cbo_LoaiPhong.getModel().setSelectedItem(loaiList.get(0));
                        t.cbo_SoPhong.getModel().setSelectedItem(p);
                        t.btn_ThemPhong.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (t.checkForm() == false) {

                                } else {
                                    t.add();
                                    refresh();
                                    MsgBox.alert(t, "Thêm thành công");
                                    t.dispose();
                                }

                            }

                        });
                        t.setVisible(true);

                    } else if (data.equalsIgnoreCase("trả phòng")) {
                        TraPhongUI t = new TraPhongUI();

                        for (int i = 0; i < t.listThuePhong.size(); i++) {
                            ThuePhong tt = t.listThuePhong.get(i);
                            if (tt.getSoPhong().equalsIgnoreCase(soPhong.get(index).getText())) {
                                t.tbl_CheckOut.setRowSelectionInterval(i, i);
                                break;
                            }
                        }

                        t.btn_TraPhong.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (t.index == -1) {
                                    MsgBox.alert(t, "Bạn chưa chọn phòng để thanh toán");
                                    return;
                                }
                                t.traPhong();
                                refresh();
                                t.dispose();
                            }

                        });
                        t.setVisible(true);
                    } else if (data.equalsIgnoreCase("Đã có người đặt trước")) {
                        DatTruocUI dt = new DatTruocUI();

                        List<DatTruoc> listDT = dtDao.selectAll();

                        for (int j = 0; j < listDT.size(); j++) {

                            DatTruoc d = listDT.get(j);
                            if (d.getSoPhong().equalsIgnoreCase(soPhong.get(index).getText()) && d.getTinhTrang().equalsIgnoreCase("Chờ nhận phòng")) {
                                dt.tbl_DatTruoc.setRowSelectionInterval(j, j);
                                break;
                            }
                        }
                       

                        dt.setVisible(true);
                    } else {
                        if (MsgBox.confirm(null, "Đã dọn dẹp xong ?")) {
                            Phong p = new Phong();
                            p.setSoPhong(soPhong.get(index).getText());
                            p.setTinhTrang("Trống");
                            pDao.updateTrangThaiPhong(p);
                            refresh();
                        }

                    }
                }
            });

        }

    }

    public void fillPhong() {

        for (int i = 0; i < list.size(); i++) {

            Phong p = list.get(i);

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

            //tonghop
            tonghop.add(new JButton());
            tonghop.get(i).setFont(new Font("Verdana", Font.BOLD, 13));
            tonghop.get(i).setBorder(null);
            tonghop.get(i).setBackground(Color.white);
            tonghop.get(i).setFocusable(false);
            tonghop.get(i).setHorizontalAlignment(JLabel.CENTER);
            tonghop.get(i).setVerticalTextPosition(JLabel.CENTER);
            tonghop.get(i).setCursor(new Cursor(HAND_CURSOR));

            //hình
            image.add(new JLabel());
            image.get(i).setLayout(new BorderLayout());
            image.get(i).setHorizontalAlignment(JLabel.CENTER);
            image.get(i).setVerticalTextPosition(JLabel.CENTER);
            image.get(i).setPreferredSize(new Dimension(120, 162));

            image.get(i).add(soPhong.get(i), BorderLayout.NORTH);
            image.get(i).add(loai.get(i), BorderLayout.CENTER);
            image.get(i).add(tonghop.get(i), BorderLayout.SOUTH);
            pnlPhong.add(image.get(i));
        }

    }

    public void fillDatTruoc() {
        List<DatTruoc> listDT = dtDao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listDT.size(); j++) {
                DatTruoc dt = listDT.get(j);
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
        for (int i = 0; i < list.size(); i++) {
            Phong p = list.get(i);
            if (p.getTinhTrang().equalsIgnoreCase("trống")) {

                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/door1.png")));
                tonghop.get(i).setText("Thuê phòng");
            } else if (p.getTinhTrang().equalsIgnoreCase("đã có người")) {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/door.png")));
                tonghop.get(i).setText("Trả phòng");
            } else if (p.getTinhTrang().equalsIgnoreCase("đã đặt trước")) {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/reserved.png")));
                tonghop.get(i).setText("Đã có người đặt trước");
            } else {
                image.get(i).setIcon(new ImageIcon(getClass().getClassLoader().getResource("Images/broom.png")));
                tonghop.get(i).setText("Đang dọn dẹp");
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
        list.clear();
        image.clear();
        loai.clear();
        soPhong.clear();
        tonghop.clear();
        pnlPhong.removeAll();
        pnlPhong.repaint();
        list = pDao.selectAll();
        fillPhong();
        fillDatTruoc();
        fillStatus();
        action();

    }

    public void execute() {

        MenuItem trangChu = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/hotel.png")), "Trang chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        MenuItem thongT = new MenuItem(null, "    Thông tin phòng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ThongKe().setVisible(true);
            }
        });
        MenuItem qlP = new MenuItem(null, "    Quản lý phòng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuanLyPhong ql = new QuanLyPhong();
                ql.setVisible(true);
                ql.btn_Add1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ql.insertRoom();
                        refresh();
                    }

                });
                ql.btn_Delete1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ql.deleteRoom();
                        refresh();
                    }

                });
                ql.btn_Update1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ql.updateRoom();
                        refresh();
                    }

                });
            }

        });

        MenuItem dichVu = new MenuItem(null, "   Dịch vụ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DichVuUI().setVisible(true);
            }
        });
        MenuItem loaiDichVu = new MenuItem(null, "   Loại dịch vụ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoaiDichVuUI().setVisible(true);
            }
        });
        MenuItem qlDichVu = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/customer-service.png")),
                "Dich vụ", null, dichVu, loaiDichVu);

        MenuItem doanhthu = new MenuItem(null, "   Doanh thu", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThongKe tk = new ThongKe();
                tk.tabs.setSelectedIndex(1);
            }
        });
        MenuItem kh = new MenuItem(null, "   Khách hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThongKe tk = new ThongKe();
                tk.tabs.setSelectedIndex(0);
            }
        });
        MenuItem thongKe = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/analytics.png")), "Thống kê", null,
                doanhthu, kh);

        MenuItem khuyenMai = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/tag.png")),
                "Khuyến mãi", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new KhuyenMaiUI().setVisible(true);
            }
        });

        MenuItem dangX = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/log-out.png")), "Đăng xuất", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dangXuat();
            }
        });

        MenuItem dattruoc = new MenuItem(null, "    Đặt trước",
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DatTruocUI().setVisible(true);
            }

        });
        MenuItem qlPhong = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/double-bed.png")), "Quản lý phòng", null, qlP, thongT, dattruoc);

        MenuItem qlNhanVien = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/crew.png")), "Quản lý nhân viên", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuanLyNhanVien().setVisible(true);
            }
        });

        MenuItem qlKhachHang = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/customer-feedback.png")), "Quản lý khách hàng",
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuanLyKhachHang().setVisible(true);
            }

        });

        MenuItem hoaDon = new MenuItem(new ImageIcon(getClass().getClassLoader().getResource("Images/bill.png")), "Hóa đơn",
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HoaDonUI().setVisible(true);
            }
        }
        );

        addMenu(trangChu, qlNhanVien, qlPhong, qlKhachHang, qlDichVu, thongKe, khuyenMai, hoaDon, dangX);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpoMenu = new javax.swing.JPopupMenu();
        themPhong = new javax.swing.JMenuItem();
        pnlMenu = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblNameNV = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPhong = new javax.swing.JPanel();
        PanelExit = new javax.swing.JPanel();
        lblThuLai = new javax.swing.JLabel();
        lblKetThuc = new javax.swing.JLabel();

        themPhong.setText("Thêm phòng");
        jpoMenu.add(themPhong);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(0, 158, 250));
        pnlMenu.setLayout(new javax.swing.BoxLayout(pnlMenu, javax.swing.BoxLayout.Y_AXIS));
        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 230, 650));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("UTM Isadora", 0, 36)); // NOI18N
        jLabel1.setText("Chào mừng đến với khách sạn BamBoo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lblNameNV.setText("Tên nhân viên");
        jPanel2.add(lblNameNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 100, -1));

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
        pnlPhong.setLayout(new java.awt.GridLayout(0, 5, 15, 15));
        jScrollPane1.setViewportView(pnlPhong);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 710, 570));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 23, 710, -1));

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
        // TODO add your handling code here:
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu jpoMenu;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblNameNV;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPhong;
    private javax.swing.JMenuItem themPhong;
    // End of variables declaration//GEN-END:variables
}
