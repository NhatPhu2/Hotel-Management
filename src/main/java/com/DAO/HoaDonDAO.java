/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.HoaDon;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HoaDonDAO extends QLKSDAO<HoaDon, Integer> {

    @Override
    public void insert(HoaDon hd) {
        String sql = "INSERT INTO hoadon (mathue,sodv,sophong,cmnd, maKM, maNV, thanhTien, ngayLapHD, ngayXuatHD,songayo) "
                + "VALUES (?, ? ,?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.update(sql,
                hd.getMaThue(),
                hd.getSodv(),
                hd.getSoPhong(),
                hd.getCmnd(),
                hd.getMaKM(),
                hd.getMaNV(),
                hd.getThanhTien(),
                hd.getNgayLap(),
                hd.getNgayXuat(),
                hd.getSoNgay()
        );
    }

    @Override
    public void update(HoaDon hd) {
        String sql = "UPDATE hoadon SET sophong = ?,makm = ?, maNV=?, thanhTien=?,ngayXuatHD=? ,songayo = ? ,sodv = ?  WHERE mahd=?";
        JdbcHelper.update(sql,
                hd.getSoPhong(),
                hd.getMaKM(),
                hd.getMaNV(),
                hd.getThanhTien(),
                hd.getNgayXuat(),
                hd.getSoNgay(),
                hd.getSodv(),
                hd.getMaHD()
                
        );
    }

    @Override
    public void delete(Integer MaHD) {
        String sql = "DELETE FROM hoadon WHERE mahd=?";
        JdbcHelper.update(sql, MaHD);
    }

    @Override
    public HoaDon selectById(Integer MaHD) {

        String sql = "SELECT * FROM hoadon WHERE mahd=?";
        List<HoaDon> list = this.selectBySql(sql, MaHD);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<HoaDon> selectAll() {

        String sql = "SELECT * FROM hoadon";

        return this.selectBySql(sql);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    HoaDon model = readFormResultSet(rs);
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

    public HoaDon readFormResultSet(ResultSet rs) throws Exception {
        HoaDon hd = new HoaDon();
        hd.setMaHD(rs.getInt("maHD"));
        hd.setCmnd(rs.getString("cmnd"));
        hd.setMaKM(rs.getString("maKM"));
        hd.setMaNV(rs.getString("maNV"));
        hd.setMaThue(rs.getInt("maThue"));
        hd.setThanhTien(rs.getFloat("thanhtien"));
        hd.setNgayLap(rs.getDate("ngayLapHD"));
        hd.setNgayXuat(rs.getDate("ngayxuatHD"));
        hd.setSodv((rs.getInt("sodv")));
        hd.setSoPhong(rs.getString("sophong"));
        hd.setSoNgay(rs.getInt("songayo"));
        return hd;
    }

    public HoaDon selectByMaThue(Integer maThue) {
        String sql = "SELECT * FROM hoadon WHERE mathue =?";
        List<HoaDon> list = this.selectBySql(sql, maThue);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<HoaDon> findKey(Integer maHD) {
        String sql = "SELECT * FROM hoaDon where maHD like ?";
        return this.selectBySql(sql, "%" + maHD + "%");
    }
    
    public int soNgay(int maThue){
        int i =0;
         try {
            String sql = "{ ? = call numberofdays(?)}";
             i = JdbcHelper.callFunction(sql, maThue).getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
