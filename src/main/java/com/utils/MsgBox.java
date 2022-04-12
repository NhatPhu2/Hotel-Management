/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MsgBox {
    public static void alert(Component parent,String message){
        JOptionPane.showMessageDialog(parent, message,"Hệ thống quán lý khách sản",JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(Component parent,String message){
        int result = JOptionPane.showConfirmDialog(parent, message,"Hệ thóng quản lý khách sản",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    public static String promt(Component parent,String message){
        return JOptionPane.showInputDialog(parent,message,"Hệ thóng quản lý khách sản",JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void warring(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message, "Hệ thống quản lý đào tạo", JOptionPane.WARNING_MESSAGE);
    }
}
