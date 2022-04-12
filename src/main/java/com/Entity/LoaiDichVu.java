/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Entity;

/**
 *
 * @author Admin
 */
public class LoaiDichVu  {
    private int maLoai;
    private String tenLoai;
    private String ghiChu;
    
    
    public LoaiDichVu(){
        
    }
    
    public String toString(){
        return this.tenLoai;
    }
    
    public LoaiDichVu(int maLoai, String tenLoai, String ghiChu) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
        this.ghiChu = ghiChu;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
