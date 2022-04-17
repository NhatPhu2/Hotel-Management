/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.DatTruoc;

import com.utils.JdbcHelper;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DatTruocDAO extends QLKSDAO<DatTruoc, Integer> {

    @Override
    public void insert(DatTruoc model) {
        String sql = 
                 "INSERT INTO dattruoc (cmnd, ngaytra, ngayNhanPhong, tienDatCoc, maNV, sophong, tinhTrang) VALUES (?, ?, ?, ?, ?, ?, ?)"
                ;
        JdbcHelper.update(sql,
                model.getCmnd(),
                model.getNgayTra(),
                model.getNgayNhanPhong(),
                model.getTienDatCoc(),
                model.getMaNV(),
                model.getSoPhong(),
                model.getTinhTrang()
        );
    }

    @Override
    public void update(DatTruoc model) {
        String sql = "UPDATE datTruoc SET cmnd = ?, ngaytra =?, ngayNhanPhong = ?, tienDatCoc = ?, maNV=?, soPhong=?, tinhtrang=? WHERE maDT=?";
        JdbcHelper.update(sql,
                model.getCmnd(),
                model.getNgayTra(),
                model.getNgayNhanPhong(),
                model.getTienDatCoc(),
                model.getMaNV(),
                model.getSoPhong(),
                model.getTinhTrang(),
                model.getMaDT()
        );
    }
    
    
    
    public DatTruoc selectMaDT(String soPhong){
        String sql = "select * from datTruoc join khachHang on khachHang.cmnd = datTruoc.cmnd \n" +
"			join phong on phong.soPhong = datTruoc.soPhong\n" +
"			where datTruoc.soPhong = ? and datTruoc.tinhtrang = N'Đã nhận phòng'";
        List<DatTruoc> list = selectBySql(sql,soPhong);
        return list.size() > 0 ? list.get(0) : null;
    }
    

    @Override
    public void delete(Integer maDT) {
        String sql = "DELETE FROM dattruoc WHERE MaNV=?";
        JdbcHelper.update(sql, maDT);
    }

    @Override
    public DatTruoc selectById(Integer maDT) {
        String sql = "SELECT * FROM datTruoc WHERE maDT=?";
        List<DatTruoc> list = selectBySql(sql, maDT);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DatTruoc> selectAll() {
        String sql = "SELECT * FROM datTruoc";
        return selectBySql(sql);
    }

    @Override
    protected List<DatTruoc> selectBySql(String sql, Object... args) {
        List<DatTruoc> list = new ArrayList<>();
         try{
           ResultSet rs = null;
           try{
               rs = JdbcHelper.query(sql, args);
               while(rs.next()){
                   DatTruoc model = readFormResultSet(rs);
                   list.add(model);
               }
           }finally{
               rs.getStatement().getConnection().close();
           }
       }catch(Exception e){
           e.printStackTrace();
       }
        return list;
    }

    public DatTruoc readFormResultSet(ResultSet rs) throws Exception {
        DatTruoc model = new DatTruoc();
        model.setMaDT(rs.getInt("maDT"));
        model.setCmnd(rs.getString("cmnd"));
        model.setNgayTra(rs.getDate("ngaytra"));
        model.setTienDatCoc(rs.getFloat("tiendatcoc"));
        model.setMaNV(rs.getString("manv"));
        model.setSoPhong(rs.getString("soPhong"));
        model.setTinhTrang(rs.getString("tinhtrang"));
        model.setNgayNhanPhong(rs.getDate("ngaynhanphong"));
        return model;
    }
    
    public void updateStatus(DatTruoc model){
        String sql = "UPDATE datTruoc SET tinhtrang=? WHERE maDT=?";
        JdbcHelper.update(sql,
                model.getTinhTrang(),
                model.getMaDT()
        );
    }

}
