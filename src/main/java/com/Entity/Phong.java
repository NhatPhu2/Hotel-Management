/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author ASUS
 */
public class Phong {
    private String soPhong;
    private String maLP;
    private String tinhTrang;

    public Phong() {
    }
    @Override
    public String toString(){
        return this.soPhong;
    }
    public Phong(String soPhong, String maLP, String tinhTrang) {
        this.soPhong = soPhong;
        this.maLP = maLP;
        this.tinhTrang = tinhTrang;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public String getMaLP() {
        return maLP;
    }

    public void setMaLP(String maLP) {
        this.maLP = maLP;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    
    
}
