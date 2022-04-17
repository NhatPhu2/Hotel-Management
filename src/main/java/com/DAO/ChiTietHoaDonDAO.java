/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.ChiTietHoaDon;
import com.Entity.ChiTietHoaDon;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonDAO extends QLKSDAO<ChiTietHoaDon, Integer> {

    @Override
    public void insert(ChiTietHoaDon entity) {
        String sql = "insert into chitiethd(madv,mahd,ngaysudung) values(?,?,?)";
        JdbcHelper.update(sql, entity.getMaDV(), entity.getMaHD(),entity.getNgaySuDung());
    }

    @Override
    public void update(ChiTietHoaDon entity) {
        String sql = "update chitiethd set mahd = ?,set madv =? where machitiet =?";
        JdbcHelper.update(sql, entity.getMaHD(), entity.getMaDV(),entity.getMaCT());
    }

    @Override
    public void delete(Integer maChiTiet) {
        String sql = "delete from chitiethd where machitiet =?";
        JdbcHelper.update(sql, maChiTiet);
    }

    @Override
    public ChiTietHoaDon selectById(Integer maChiTiet) {
        String sql = "select * from chitiethd where machitiet = ?";
        List<ChiTietHoaDon> list = selectBySql(sql, maChiTiet);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ChiTietHoaDon> selectAll() {
        String sql = "select * from chitiethd";
        return selectBySql(sql);
    }

    @Override
    protected List<ChiTietHoaDon> selectBySql(String sql, Object... args) {
       List<ChiTietHoaDon> list = new ArrayList<>();
       try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    ChiTietHoaDon model = readFormResultSet(rs);
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
     public ChiTietHoaDon readFormResultSet(ResultSet rs) throws Exception {
        ChiTietHoaDon hd = new ChiTietHoaDon();
       hd.setMaCT(rs.getInt("machitiet"));
       hd.setMaDV(rs.getInt("madv"));
       hd.setMaHD(rs.getInt("mahd"));
       hd.setNgaySuDung(rs.getDate("ngaysudung"));
        return hd;
    }
     
     public List<ChiTietHoaDon> selectByHoaDon(Integer mahd){
         String sql = "select * from chitiethd where mahd = ?";
         return selectBySql(sql,mahd);
     }

}
