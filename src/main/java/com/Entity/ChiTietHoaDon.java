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
public class ChiTietHoaDon {
    private int maCT;
    private int maDV;
    private int maHD;
    private Date ngaySuDung;
    
    public ChiTietHoaDon(){
        
    }

    public ChiTietHoaDon(int maCT, int maDV, int maHD, Date ngaySuDung) {
        this.maCT = maCT;
        this.maDV = maDV;
        this.maHD = maHD;
        this.ngaySuDung = ngaySuDung;
    }

    public Date getNgaySuDung() {
        return ngaySuDung;
    }

    public void setNgaySuDung(Date ngaySuDung) {
        this.ngaySuDung = ngaySuDung;
    }
    
   

    public int getMaCT() {
        return maCT;
    }

    public void setMaCT(int maCT) {
        this.maCT = maCT;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }
    
}
