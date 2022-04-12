/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String maNV;
    private String hoTen;
    private Date namSinh;
    private String diaChi;
    private String soDT;
    private boolean gioiTinh;
    private String email;
    private String maKhau;
    private boolean chuVu;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, Date namSinh, String diaChi, String soDT, boolean gioiTinh, String email, String maKhau, boolean chuVu) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.maKhau = maKhau;
        this.chuVu = chuVu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaKhau() {
        return maKhau;
    }

    public void setMaKhau(String maKhau) {
        this.maKhau = maKhau;
    }

    public boolean getChuVu() {
        return chuVu;
    }

    public void setChuVu(boolean chuVu) {
        this.chuVu = chuVu;
    }
    
    
}
