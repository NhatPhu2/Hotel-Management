/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.DichVu;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DichVuDAO extends QLKSDAO<DichVu, Integer> {

    @Override
    public void insert(DichVu dv) {
        String sql = "INSERT INTO dichVu ( tenDV, gia,maloai, hinh) VALUES ( ?, ? , ?, ?)";
        JdbcHelper.update(sql,
               
                dv.getTenDV(),
                dv.getGia(),
                dv.getMaLoai(),
                dv.getHinh()
        );
    }

    @Override
    public void update(DichVu dv) {
        String sql = "UPDATE dichVu SET tenDV=?, gia=? ,maloai = ?, hinh = ? WHERE maDV=?";
        JdbcHelper.update(sql,
                dv.getTenDV(),
                dv.getGia(),
                dv.getMaLoai(),
                dv.getHinh(),
                dv.getMaDV()
        );
    }

    @Override
    public void delete(Integer MaDV) {
        String sql = "DELETE FROM dichVu WHERE maDV=?";
        JdbcHelper.update(sql, MaDV);
    }

    @Override
    public DichVu selectById(Integer MaDV) {
        String sql = "SELECT * FROM dichVu WHERE maDV=?";
        List<DichVu> list = this.selectBySql(sql, MaDV);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<DichVu> selectAll() {
        String sql = "SELECT * FROM dichVu";
        return selectBySql(sql);
    }

    @Override
    protected List<DichVu> selectBySql(String sql, Object... args) {
        List<DichVu> list = new ArrayList<>();
        try{
           ResultSet rs = null;
           try{
               rs = JdbcHelper.query(sql, args);
               while(rs.next()){
                   DichVu model = readFormResultSet(rs);
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

    public DichVu readFormResultSet(ResultSet rs) throws Exception {
        DichVu dv = new DichVu();
        dv.setMaDV(rs.getInt("maDV"));
        dv.setTenDV(rs.getString("tenDV"));
        dv.setGia(rs.getFloat("gia"));
        dv.setMaLoai(rs.getInt("maloai"));
        dv.setHinh(rs.getString("hinh"));
        return dv;
    }
    
    public List<DichVu> selectTypeOfService(Integer codeType) {
        String sql = "SELECT * FROM dichVu where maloai = ?";
        return selectBySql(sql,codeType);
    }

    

}
