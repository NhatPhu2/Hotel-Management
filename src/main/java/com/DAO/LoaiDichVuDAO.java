/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.LoaiDichVu;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LoaiDichVuDAO extends QLKSDAO<LoaiDichVu,Integer>{

    @Override
    public void insert(LoaiDichVu entity) {
       String sql = "INSERT INTO loaidichvu ( tenloai , ghichu) VALUES ( ?, ?)";
        JdbcHelper.update(sql,
                entity.getTenLoai(),
                entity.getGhiChu()
        );
    }

    @Override
    public void update(LoaiDichVu entity) {
       String sql = "update loaidichvu set tenloai = ? , ghichu = ? where maloai = ?";
        JdbcHelper.update(sql,
               entity.getTenLoai(),
                entity.getGhiChu(),
                entity.getMaLoai()
        );
    }

    @Override
    public void delete(Integer key) {
         String sql = "delete from loaidichvu where maloai = ?";
        JdbcHelper.update(sql,key);
    }

    @Override
    public LoaiDichVu selectById(Integer key) {
      String sql = "SELECT * FROM loaidichVu WHERE maloai=?";
        List<LoaiDichVu> list = this.selectBySql(sql,key);
        return list.size() > 0 ? list.get(0) : null;
    }
    
   

    @Override
    public List<LoaiDichVu> selectAll() {
       String sql = "select * from loaidichvu";
       return selectBySql(sql);
    }

    @Override
    protected List<LoaiDichVu> selectBySql(String sql, Object... args) {
      List<LoaiDichVu> list = new ArrayList<>();
        try{
           ResultSet rs = null;
           try{
               rs = JdbcHelper.query(sql, args);
               while(rs.next()){
                   LoaiDichVu model = readFormResultSet(rs);
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
    
   

    public LoaiDichVu readFormResultSet(ResultSet rs) throws Exception {
        LoaiDichVu dv = new LoaiDichVu();
        dv.setMaLoai(rs.getInt("maloai"));
        dv.setTenLoai(rs.getString("tenloai"));
        dv.setGhiChu(rs.getString("ghichu"));
        return dv;
    }
   
    
}
