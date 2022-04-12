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
public class KhuyenMai {
    private String maKM;
    private String tenKM;
    private String noiDung;
    private Date ngayBD;
    private Date ngayKT;
    private float phanTramGiam;

    public float getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(float phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public KhuyenMai() {
    }

    public KhuyenMai(String maKM, String tenKM, String noiDung, Date ngayBD, Date ngayKT) {
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.noiDung = noiDung;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }
    
    
}
