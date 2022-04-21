/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author ASUS
 */
public class DichVu {

    private int maDV;
    private String tenDV;
    private float gia;
    private int maLoai;
    private String hinh;

    public DichVu(int maDV, String tenDV, float gia, int maLoai, String hinh) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.gia = gia;
        this.maLoai = maLoai;
        this.hinh = hinh;
    }

    public DichVu() {
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    

}
