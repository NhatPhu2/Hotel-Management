/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.UI;

import com.DAO.NhanVienDAO;
import com.Entity.NhanVien;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.utils.Auth;
import com.utils.MsgBox;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


/**
 *
 * @author ASUS
 */
public class Login extends javax.swing.JFrame implements Runnable, ThreadFactory {

    NhanVienDAO dao = new NhanVienDAO();
    boolean showPass;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setVisible(true);
        init();
        
        txt_UserName.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    try {
                        login();
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        txt_Pass.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    try {
                        login();
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        btn_Login.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {
                    try {
                        login();
                    } catch (Exception ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        lbl_Sceen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_UserName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_Login = new com.k33ptoo.components.KButton();
        lbl_ShowPass = new javax.swing.JLabel();
        txt_Pass = new javax.swing.JPasswordField();
        lbl_LogoHotel = new javax.swing.JLabel();
        lblThuLai = new javax.swing.JLabel();
        lblKetThuc = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ErrorUser = new javax.swing.JLabel();
        ErrorPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkGradientFocus(99);
        kGradientPanel1.setkStartColor(new java.awt.Color(204, 204, 204));

        lbl_Sceen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Sceen.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/Hotel_Sceen.jpg")));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Tài khoản:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Mật khẩu:");

        txt_UserName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btn_Login.setText("Đăng nhập");
        btn_Login.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btn_Login.setkHoverStartColor(new java.awt.Color(153, 255, 153));
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });

        lbl_ShowPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_ShowPass.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/hidden.png")));
        lbl_ShowPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ShowPassMouseClicked(evt);
            }
        });

        txt_Pass.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lbl_LogoHotel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_LogoHotel.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/Logo_HotelSmooth.png")));

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

        jLabel3.setIcon(new ImageIcon( getClass().getClassLoader().getResource("Images/qr-code.png")));
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });
        jLabel3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel3KeyReleased(evt);
            }
        });

        ErrorUser.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ErrorUser.setForeground(new java.awt.Color(255, 0, 0));

        ErrorPass.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ErrorPass.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblThuLai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(lbl_Sceen, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ErrorUser, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ErrorPass, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(lbl_ShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_LogoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                            .addComponent(lblThuLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addComponent(lbl_LogoHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ErrorUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txt_Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_ShowPass, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorPass, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_Login, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addComponent(lbl_Sceen, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 3, Short.MAX_VALUE))
        );

        kGradientPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblKetThucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblKetThucMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblKetThucMouseClicked

    private void lblThuLaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThuLaiMouseClicked
        // TODO add your handling code here:
        this.setState(Login.ICONIFIED);
    }//GEN-LAST:event_lblThuLaiMouseClicked
    private void lbl_ShowPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ShowPassMouseClicked
        // TODO add your handling code here:
        if (showPass) {
            ImageIcon iconPass = new ImageIcon(getClass().getClassLoader().getResource("Images/hidden.png"));
            lbl_ShowPass.setIcon(iconPass);
            showPass = false;

            if (!txt_Pass.getText().equalsIgnoreCase("Mật khẩu")) {
                txt_Pass.setEchoChar('\u25cf');
            }
        } else {
            ImageIcon iconPass = new ImageIcon(getClass().getClassLoader().getResource("Images/show.png"));
            lbl_ShowPass.setIcon(iconPass);
            txt_Pass.setEchoChar((char) 0);
            showPass = true;
        }
    }//GEN-LAST:event_lbl_ShowPassMouseClicked

    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        if (txt_UserName.getText().trim().length() > 0) {
            if (txt_Pass.getPassword().length > 0) {
                login();
            } else {
                txt_Pass.grabFocus();
                MsgBox.alert(this, "Không để trống mật khẩu!");
                ErrorPass.setText("Nhập mật khẩu!");
            }
        } else {
            txt_UserName.grabFocus();
            MsgBox.alert(this, "Không để trống tên đăng nhập!");
            ErrorUser.setText("Nhập tên đăng nhập!");
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    private void jLabel3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel3KeyReleased

    }//GEN-LAST:event_jLabel3KeyReleased

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        loginQR();
    }//GEN-LAST:event_jLabel3MousePressed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorPass;
    private javax.swing.JLabel ErrorUser;
    private com.k33ptoo.components.KButton btn_Login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lblKetThuc;
    private javax.swing.JLabel lblThuLai;
    private javax.swing.JLabel lbl_LogoHotel;
    private javax.swing.JLabel lbl_Sceen;
    private javax.swing.JLabel lbl_ShowPass;
    private javax.swing.JPasswordField txt_Pass;
    private javax.swing.JTextField txt_UserName;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setLocationRelativeTo(null);

    }
    WebCam c;

    public void loginQR() {
        c = new WebCam();
        c.setVisible(true);
        c.setLocationRelativeTo(null);
        initWebCam();

    }

    void login() {
        String manv = txt_UserName.getText();
        String matKhau = txt_Pass.getText();
        NhanVien nv = dao.selectById(manv);

        if (nv == null) {
            ErrorUser.setText("Sai tên đăng nhập!");
        } else if (!matKhau.equals(nv.getMaKhau())) {
            ErrorPass.setText("Sai mật khẩu!");
        } else {
          
            

           
            this.dispose();
            Auth.user = nv;
            MainForm m = new MainForm();
            m.setVisible(true);
            
        }
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            } else {
                break;
            }

            try {
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }

            if (result != null) {
                NhanVien nv = dao.selectById(result.getText());
                if (nv == null) {
                     MsgBox.alert(this,"Mã QR không chính xác");
                } else {
                    c.dispose();
                    try {
                        webcam.close();
                    } catch (Exception e) {
                        //notthing
                    }
                    Auth.user = nv;
                    new MainForm();
                    this.dispose();
                    
                    break;
                }
            }

        } while (true);
    }

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private Executor excutor = Executors.newSingleThreadExecutor(this);

    private void initWebCam() {
        excutor = Executors.newSingleThreadExecutor(this);
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);// 0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        WebCam.pnlCamera.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));
        excutor.execute(this);

    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My thread");
        t.setDaemon(true);
        return t;
    }

}
