/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.util.Date;


/**
 *
 * @author ASUS
 */
public class KhachHang {
    private String cmnd;
    private String tenKH;
    private Date ngaySinh;
    private String soDT;
    private boolean gioiTinh;
    private String diaChi;
    
    

    public KhachHang() {
    }

    public KhachHang(String cmnd, String tenKH, Date ngaySinh, String soDT, boolean gioiTinh, String diaChi) {
        this.cmnd = cmnd;
        this.tenKH = tenKH;
        this.ngaySinh = ngaySinh;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
       
    }

   

   

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    
}
