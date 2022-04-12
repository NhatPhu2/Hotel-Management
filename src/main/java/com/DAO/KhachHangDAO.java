/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.KhachHang;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class KhachHangDAO extends QLKSDAO<KhachHang, String> {

    @Override
    public void insert(KhachHang kh) {
        String sql = "INSERT INTO khachHang (cmnd, tenKH, ngaySinh, diaChi, gioiTinh, SDT) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.update(sql,
                kh.getCmnd(),
                kh.getTenKH(),
                kh.getNgaySinh(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getSoDT()
              
        );
    }

    @Override
    public void update(KhachHang kh) {
        String sql = "UPDATE khachHang SET tenKH=?, ngaySinh=?, diaChi=?, gioiTinh=?, SDT=? WHERE cmnd=?";
        JdbcHelper.update(sql,
                kh.getTenKH(),
                kh.getNgaySinh(),
                kh.getDiaChi(),
                kh.getGioiTinh(),
                kh.getSoDT(),
                kh.getCmnd()
        );
    }

    @Override
    public void delete(String cmnd) {
        String sql = "DELETE FROM khachHang WHERE cmnd=?";
        JdbcHelper.update(sql, cmnd);
    }

    @Override
    public KhachHang selectById(String MaKH) {
        String sql = "SELECT * FROM khachHang WHERE cmnd=?";
        List<KhachHang> list = this.selectBySql(sql, MaKH);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    public List<KhachHang> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM KHACHHANG WHERE cmnd LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }

    @Override
    public List<KhachHang> selectAll() {
        String sql = "SELECT * FROM khachHang";
        return this.selectBySql(sql);
    }

    @Override
    public List<KhachHang> selectBySql(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
       try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    KhachHang model = readFormResultSet(rs);
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

    public KhachHang readFormResultSet(ResultSet rs) throws Exception {

        KhachHang kh = new KhachHang();
        kh.setCmnd(rs.getString("cmnd"));
        kh.setTenKH(rs.getString("tenKH"));
        kh.setNgaySinh(rs.getDate("ngaySinh"));
        kh.setDiaChi(rs.getString("diaChi"));
        kh.setGioiTinh(rs.getBoolean("gioiTinh"));
        kh.setSoDT(rs.getString("SDT"));
        return kh;

    }

}
