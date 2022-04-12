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
public class DatTruoc {
    private int maDT;
    private String cmnd;
    private Date ngayTra;
    private Date ngayNhanPhong;
    private float tienDatCoc;
    private String maNV;
    private String soPhong;
    private String tinhTrang;

    public DatTruoc() {
    }

    public DatTruoc(int maDT, String cmnd, Date ngayTra, Date ngayNhanPhong, float tienDatCoc, String maNV, String soPhong, String tinhTrang) {
        this.maDT = maDT;
        this.cmnd = cmnd;
        this.ngayTra = ngayTra;
        this.ngayNhanPhong = ngayNhanPhong;
        this.tienDatCoc = tienDatCoc;
        this.maNV = maNV;
        this.soPhong = soPhong;
        this.tinhTrang = tinhTrang;
    }

    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Date getNgayNhanPhong() {
        return ngayNhanPhong;
    }

    public void setNgayNhanPhong(Date ngayNhanPhong) {
        this.ngayNhanPhong = ngayNhanPhong;
    }

    public float getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(float tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(String soPhong) {
        this.soPhong = soPhong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

   
    
    
    
    
}
