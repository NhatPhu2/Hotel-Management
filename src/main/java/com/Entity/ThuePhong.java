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
public class ThuePhong {
    private int maThue;
    private String soPhong;
    private String cmnd;
    private Date ngayThue;
    private Date ngayTra;

    public ThuePhong(){
        
    }

    public ThuePhong(int maThue, String soPhong, String cmnd, Date ngayThue, Date ngayTra) {
        this.maThue = maThue;
        this.soPhong = soPhong;
        this.cmnd = cmnd;
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
    }
    
    
    

    public int getMaThue() {
        return maThue;
    }

    public void setMaThue(int maThue) {
        this.maThue = maThue;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgayThue() {
        return ngayThue;
    }

    public void setNgayThue(Date ngayThue) {
        this.ngayThue = ngayThue;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }
    
}
