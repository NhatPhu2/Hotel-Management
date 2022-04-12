/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author ASUS
 */
public class LoaiPhong {
    private String maLP;
    private String tenLP;
    private float gia;

    public LoaiPhong() {
    }
    @Override
    public String toString(){
        return this.tenLP;
    }
    public LoaiPhong(String maLP, String tenLP, float gia) {
        this.maLP = maLP;
        this.tenLP = tenLP;
        this.gia = gia;
    }

    public String getMaLP() {
        return maLP;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public String getTenLP() {
        return tenLP;
    }

    public void setTenLP(String tenLP) {
        this.tenLP = tenLP;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }
    
    
}
