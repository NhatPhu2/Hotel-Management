/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Phong;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class PhongDAO extends QLKSDAO<Phong,String> {

    @Override
    public void insert(Phong entity) {
      String sql = "insert into phong(sophong,maloaiphong,tinhtrang) values(?,?,?)";
        JdbcHelper.update(sql,entity.getSoPhong(),entity.getMaLP(),entity.getTinhTrang());
    }

    @Override
    public void update(Phong entity) {
        String sql = "update phong set maloaiphong = ?,tinhtrang = ? where sophong = ?";
        JdbcHelper.update(sql,entity.getMaLP(),entity.getTinhTrang(),entity.getSoPhong());
    }

    @Override
    public void delete(String key) {
         String sql = "delete from phong where sophong = ?";
        JdbcHelper.update(sql,key);
    }

    @Override
    public Phong selectById(String id) {
      String sql = "select * from phong where sophong = ?";
      List<Phong> list = selectBySql(sql,id);
      return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Phong> selectAll() {
       String sql = "select * from phong";
       return selectBySql(sql);
    }

    @Override
    protected List<Phong> selectBySql(String sql, Object... args) {
        List<Phong> list = new ArrayList<>();
       try{
           ResultSet rs = null;
           try{
               rs = JdbcHelper.query(sql, args);
               while(rs.next()){
                   Phong model = readFormResultSet(rs);
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
    
    public Phong readFormResultSet(ResultSet rs) throws Exception {
        Phong model = new Phong();
        model.setSoPhong(rs.getString("sophong"));
        model.setMaLP(rs.getString("maloaiphong"));
        model.setTinhTrang(rs.getString("tinhtrang"));
        return model;
    }
    
    public List<Phong> selectByIdLoaiPhong(String maLoai){
        String sql = "select * from phong where maloaiphong = ?";
        return selectBySql(sql,maLoai);
    }
    
    public List<Phong> selectByKeyword(String keyword) {
        String sql="SELECT * FROM phong WHERE soPhong LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
    
    public void updateTrangThaiPhong(Phong entity){
        String sql = "update phong set tinhtrang = ? where sophong = ?";
        JdbcHelper.update(sql,entity.getTinhTrang(),entity.getSoPhong());
    }
    
}
