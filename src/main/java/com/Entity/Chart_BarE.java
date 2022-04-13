/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author PC
 */
public class Chart_BarE {
    private String thoiGian;
    private int soKhach;
    private int sodv;

    public Chart_BarE() {
    }

    public Chart_BarE(String thoiGian, int soKhach, int sodv) {
        this.thoiGian = thoiGian;
        this.soKhach = soKhach;
        this.sodv = sodv;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public int getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(int soKhach) {
        this.soKhach = soKhach;
    }

    public int getSodv() {
        return sodv;
    }

    public void setSodv(int sodv) {
        this.sodv = sodv;
    }
    
    
    
}
