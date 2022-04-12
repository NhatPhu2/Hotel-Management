/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.KhuyenMai;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhuyenMaiDAO extends QLKSDAO<KhuyenMai, String> {

    @Override
    public void insert(KhuyenMai km) {
        String sql = "INSERT INTO khuyenMai (maKM, tenKM, noiDung, ngayBatDau, ngayKetThuc,phanTramGiam) VALUES (?, ? ,?, ?, ?,?)";
        JdbcHelper.update(sql,
                km.getMaKM(),
                km.getTenKM(),
                km.getNoiDung(),
                km.getNgayBD(),
                km.getNgayKT(),
                km.getPhanTramGiam()
        );
    }

    @Override
    public void update(KhuyenMai km) {
        String sql = "UPDATE khuyenMai SET tenKM=?, noiDung=?, ngayBatDau=?, ngayKetThuc=?,phanTramGiam=? WHERE maKM=?";
        JdbcHelper.update(sql,
                km.getTenKM(),
                km.getNoiDung(),
                km.getNgayBD(),
                km.getNgayKT(),
                km.getPhanTramGiam(),
                km.getMaKM()
        );
    }

    @Override
    public void delete(String MaKM) {
        String sql = "DELETE FROM khuyenMai WHERE maKM=?";
        JdbcHelper.update(sql, MaKM);
    }

    @Override
    public KhuyenMai selectById(String MaKM) {
        String sql = "SELECT * FROM khuyenMai WHERE maKM=?";
        List<KhuyenMai> list = this.selectBySql(sql, MaKM);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<KhuyenMai> selectAll() {
        String sql = "SELECT * FROM khuyenMai";
        return this.selectBySql(sql);
    }

    @Override
    protected List<KhuyenMai> selectBySql(String sql, Object... args) {
        List<KhuyenMai> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    KhuyenMai model = readFormResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhuyenMai readFormResultSet(ResultSet rs) throws Exception {
        KhuyenMai km = new KhuyenMai();
        km.setMaKM(rs.getString("maKM"));
        km.setTenKM(rs.getString("tenKM"));
        km.setNoiDung(rs.getString("noiDung"));
        km.setNgayBD(rs.getDate("ngayBatDau"));
        km.setNgayKT(rs.getDate("ngayKetThuc"));
        km.setPhanTramGiam(rs.getFloat("phanTramGiam"));
        return  km;
    }

  
    
   

}
