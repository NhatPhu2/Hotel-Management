/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.NhanVien;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NhanVienDAO extends QLKSDAO<NhanVien, String> {

    @Override
    public void insert(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (maNV, tenNV, SDT, diaChi, email, chucVu, namSinh, matKhau, gioiTinh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.update(sql,
                nv.getMaNV(),
                nv.getHoTen(),
                nv.getSoDT(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getChuVu(),
                nv.getNamSinh(),
                nv.getMaKhau(),
                nv.getGioiTinh()
        );
    }

    @Override
    public void update(NhanVien nv) {
        String sql = "UPDATE nhanVien SET tenNV=?, SDT=?, diaChi=?, email=?, chucVu=?, namSinh=?, matKhau=?, gioiTinh=? WHERE maNV=?";
        JdbcHelper.update(sql,
                nv.getHoTen(),
                nv.getSoDT(),
                nv.getDiaChi(),
                nv.getEmail(),
                nv.getChuVu(),
                nv.getNamSinh(),
                nv.getMaKhau(),
                nv.getGioiTinh(),
                nv.getMaNV()
        );
    }

    @Override
    public void delete(String MaNV) {
        String sql = "DELETE FROM nhanVien WHERE MaNV=?";
        JdbcHelper.update(sql, MaNV);
    }

    @Override
    public NhanVien selectById(String maNV) {
        String sql = "SELECT * FROM nhanVien WHERE MaNV=?";
        List<NhanVien> list = this.selectBySql(sql, maNV);
        return list.size() > 0 ? list.get(0) : null;
    }
    
    

    @Override
    public List<NhanVien> selectAll() {
        String sql = "SELECT * FROM nhanVien";
        return this.selectBySql(sql);
    }

    @Override
    protected List<NhanVien> selectBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    NhanVien model = readFormResultSet(rs);
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

    public NhanVien readFormResultSet(ResultSet rs) throws Exception {
        NhanVien nv = new NhanVien();
        nv.setMaNV(rs.getString("maNV"));
        nv.setHoTen(rs.getString("tenNV"));
        nv.setSoDT(rs.getString("SDT"));
        nv.setDiaChi(rs.getString("diaChi"));
        nv.setEmail(rs.getString("email"));
        nv.setChuVu(rs.getBoolean("chucVu"));
        nv.setNamSinh(rs.getDate("namSinh"));
        nv.setMaKhau(rs.getString("matKhau"));
        nv.setGioiTinh(rs.getBoolean("gioiTinh"));

        return nv;
    }
}
