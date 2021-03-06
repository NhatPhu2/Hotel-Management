/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class MenuItem extends javax.swing.JPanel {

    ActionListener act;
    ArrayList<MenuItem> list = new ArrayList<>();

    public ArrayList<MenuItem> getList() {
        return list;
    }

    public MenuItem() {

    }

    public MenuItem(ImageIcon icon, String menuName, ActionListener act, MenuItem... menu) {
        initComponents();
         setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(background);
        setForeground(Color.WHITE);
        this.setVisible(true);
        lblName.setText(menuName);
        lblIcon.setIcon(icon);
        if (act != null) {
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 50));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 50));
        for (MenuItem m : menu) {
            list.add(m);
            m.setVisible(false);
        }
    }

    public void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < list.size(); i++) {
                        Thread.sleep(20);
                        list.get(i).setVisible(true);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                show = false;
            }
        }).start();
    }

    public void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = list.size() - 1; i >= 0; i--) {
                        Thread.sleep(20);
                        list.get(i).setVisible(false);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                show = true;
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        lblName = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(0, 158, 250));
        setForeground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("MenuName");
        lblName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(lblIcon))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    boolean show = true;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (show == true) {
            showMenu();
        } else {
            hideMenu();
        }
        if (act != null) {
            act.actionPerformed(null);
        }
        MenuItem.super.setBackground(getColorPressed());
    }//GEN-LAST:event_formMousePressed
    private Color background = new Color(69, 191, 71);
    private Color colorHover = new Color(1, 0, 0, 15);
    private Color colorPressed = new Color(1, 0, 0, 15);
    private boolean mouseOver = false;

    @Override
    public void setBackground(Color bg) {
        background = bg;
        super.setBackground(bg);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(Color colorPressed) {
        this.colorPressed = colorPressed;
    }

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        mouseOver = true;
        MenuItem.super.setBackground(getColorHover());
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        mouseOver = false;
        MenuItem.super.setBackground(background);
    }//GEN-LAST:event_formMouseExited

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (mouseOver) {
            MenuItem.super.setBackground(getColorHover());
        } else {
            MenuItem.super.setBackground(background);
        }
    }//GEN-LAST:event_formMouseReleased
    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblName;
    // End of variables declaration//GEN-END:variables

}
