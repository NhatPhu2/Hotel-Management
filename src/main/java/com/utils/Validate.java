/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utils;

import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Truong Bui
 */
public class Validate {
    public static boolean checkNull(JTextField txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    
    public static boolean checkNullTextArea(JTextArea txt) {
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
    
    public static boolean checkMaNV(JTextField txt) {
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{1,15}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải có 1-15 kí tự\nchữ hoa, thường không dấu hoặc số.");
            return false;
        }
    }
    
    public static boolean checkName(JTextField txt) {
        String id = txt.getText();
        String rgx = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]{3,25}$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là tên tiếng việt hoặc không đấu\ntừ 3-25 kí tự");
            return false;
        }
    }
    
    public static boolean checkMaCD(JTextField txt) {
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{5}";
        if (id.matches(rgx)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải có đúng 5 kí tự\nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }
    
     public static boolean checkTenCD(JTextField txt) {
        String id = txt.getText();
        String rgx = ".{3,50}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải từ 3-50 kí tự.");
            return false;
        }
    }
    
    public static boolean checkThoiLuong(JTextField txt) {
        try {
            int hour = Integer.parseInt(txt.getText());
            if (hour >= 0) {
                return true;
            } else {
                txt.grabFocus();
                JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là số nguyên.");
            return false;
        }
    }
    
     public static boolean checkHocPhi(JTextField txt) {
        try {
            float hp = Float.parseFloat(txt.getText());
            if (hp >= 0) {
                return true;
            } else {
                txt.grabFocus();
                JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là lớn hơn bằng 0.");
                return false;
            }
        } catch (NumberFormatException e) {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là số nguyên hoặc số thực.");
            return false;
        }
    }
     
     public static boolean checkMaNH(JTextField txt) {
        String id = txt.getText();
        String rgx = "[a-zA-Z0-9]{7}";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải có đúng 7 kí tự\nchữ thường, chữ hoa hoặc số");
            return false;
        }
    }
     
     public static boolean isValidDate(String inDate) {

        //set the format to use as a constructor argument
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        if (inDate.trim().length() != dateFormat.toPattern().length()) {
            return false;
        }
        try {
            //parse the inDate parameter
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }
     
       public static boolean checkDate(JTextField txt) {
        txt.setBackground(white);
        String id = txt.getText();
        if (isValidDate(id)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " không đúng định dạng dd-MM-yyyy");
            return false;
        }
    }
       
       public static boolean checkSDT(JTextField txt) {
        String id = txt.getText();
        String rgx = "[0-9]{10}";
        if (id.matches(rgx)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " phải là 10 chữ số.");
            return false;
        }
    }
       
       public static boolean checkEmail(JTextField txt) {
        String id = txt.getText();
        String rgx = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (id.matches(rgx)) {
            return true;
        } else {
            txt.grabFocus();
            JOptionPane.showMessageDialog(txt.getRootPane(), txt.getName() + " không đúng định dạng");
            return false;
        }
    }
       
       
}
