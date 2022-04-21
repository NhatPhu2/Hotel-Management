
package com.UI;


import javax.swing.ImageIcon;

/**
 *
 * @author PC
 */
public class Form_Cart extends javax.swing.JPanel {

  
    public Form_Cart() {
        initComponents();

    }
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cart2 = new com.UI.Cart();
        cart3 = new com.UI.Cart();
        cart1 = new com.UI.Cart();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(910, 283));

        cart2.setColor1(new java.awt.Color(186, 123, 247));
        cart2.setColor2(new java.awt.Color(167, 94, 236));
        add(cart2);

        cart3.setColor1(new java.awt.Color(241, 208, 62));
        cart3.setColor2(new java.awt.Color(211, 184, 64));
        add(cart3);

        cart1.setBackground(new java.awt.Color(0, 0, 0));
        cart1.setColor1(new java.awt.Color(142, 142, 250));
        cart1.setColor2(new java.awt.Color(123, 123, 245));
        add(cart1);
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.UI.Cart cart1;
    public com.UI.Cart cart2;
    public com.UI.Cart cart3;
    // End of variables declaration//GEN-END:variables
}
