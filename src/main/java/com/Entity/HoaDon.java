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
public class HoaDon {
    private Integer maHD;
    private String cmnd;
    private String maKM;
    private String maNV;
    private Integer maThue;
    private Date ngayLap;
    private Date ngayXuat;
    private int sodv;
    private String soPhong;
    private double thanhTien;
    private int soNgay;
    private String tinhTrang;

    public HoaDon() {
    }

    public HoaDon(Integer maHD, String cmnd, String maKM, String maNV, Integer maThue, Date ngayLap, Date ngayXuat, int sodv, String soPhong, double thanhTien, int soNgay, String tinhTrang) {
        this.maHD = maHD;
        this.cmnd = cmnd;
        this.maKM = maKM;
        this.maNV = maNV;
        this.maThue = maThue;
        this.ngayLap = ngayLap;
        this.ngayXuat = ngayXuat;
        this.sodv = sodv;
        this.soPhong = soPhong;
        this.thanhTien = thanhTien;
        this.soNgay = soNgay;
        this.tinhTrang = tinhTrang;
    }

    public Integer getMaThue() {
        return maThue;
    }

    public void setMaThue(Integer maThue) {
        this.maThue = maThue;
    }

   

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    

    public Integer getMaHD() {
        return maHD;
    }

    public void setMaHD(Integer maHD) {
        this.maHD = maHD;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    

    public Date getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(Date ngayLap) {
        this.ngayLap = ngayLap;
    }

    public Date getNgayXuat() {
        return ngayXuat;
    }

    public void setNgayXuat(Date ngayXuat) {
        this.ngayXuat = ngayXuat;
    }

    public int getSodv() {
        return sodv;
    }

    public void setSodv(int sodv) {
        this.sodv = sodv;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
    
    

    
    
    
}
