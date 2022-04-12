/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.LoaiPhong;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class LoaiPhongDAO extends QLKSDAO<LoaiPhong, String> {

    @Override
    public void insert(LoaiPhong lp) {
        String sql = "INSERT INTO loaiPhong (maLoaiPhong, tenLoaiPhong, gia) VALUES (?, ?, ?)";
        JdbcHelper.update(sql,
                lp.getMaLP(),
                lp.getTenLP(),
                lp.getGia()
        );
    }

    @Override
    public void update(LoaiPhong lp) {
        String sql = "UPDATE loaiPhong SET tenLoaiPhong=?, gia=? WHERE maLoaiPhong=?";
        JdbcHelper.update(sql,
                lp.getTenLP(),
                lp.getGia(),
                lp.getMaLP()
        );
    }

    @Override
    public void delete(String MaLP) {
        String sql = "DELETE FROM loaiPhong WHERE maLoaiPhong=?";
        JdbcHelper.update(sql, MaLP);
    }

    @Override
    public LoaiPhong selectById(String MaLP) {
        String sql = "SELECT * FROM loaiPhong WHERE maLoaiPhong=?";
        List<LoaiPhong> list = selectBySql(sql, MaLP);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<LoaiPhong> selectAll() {
        String sql = "SELECT * FROM loaiPhong";
        return this.selectBySql(sql);
    }

    @Override
    protected List<LoaiPhong> selectBySql(String sql, Object... args) {
        List<LoaiPhong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    LoaiPhong model = readFormResultSet(rs);
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

    public LoaiPhong readFormResultSet(ResultSet rs) throws Exception {
        LoaiPhong lp = new LoaiPhong();
        lp.setMaLP(rs.getString("maLoaiPhong"));
        lp.setTenLP(rs.getString("tenLoaiPhong"));
        lp.setGia(rs.getFloat("gia"));;

        return lp;
    }

    public List<LoaiPhong> selectByKeyWord(String soPhong) {
        String sql = "select loaiphong.maLoaiPhong,tenLoaiPhong,gia from phong join loaiPhong on loaiPhong.maLoaiPhong = phong.maLoaiPhong\n"
                + "	where soPhong = ?";
        return this.selectBySql(sql,soPhong);
    }

}
