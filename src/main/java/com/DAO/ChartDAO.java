/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.Chart_BarE;
import com.Entity.DichVu;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ChartDAO extends QLKSDAO<Chart_BarE, Integer>{

    @Override
    public void insert(Chart_BarE entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Chart_BarE entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Chart_BarE selectById(Integer year) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Chart_BarE> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected List<Chart_BarE> selectBySql(String sql, Object... args) {
        List<Chart_BarE> list = new ArrayList<>();
        try{
           ResultSet rs = null;
           try{
               rs = JdbcHelper.query(sql, args);
               while(rs.next()){
                   Chart_BarE model = readFormResultSet(rs);
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

    public Chart_BarE readFormResultSet(ResultSet rs) throws Exception {
        Chart_BarE ch= new Chart_BarE();
        ch.setThoiGian(rs.getString("time"));
        ch.setSoKhach(rs.getInt("guest"));
        ch.setSodv(rs.getInt("serviece"));
        return ch;
    }
    
    
    public List<Chart_BarE> selectByYear(Integer year)  {
        String sql = "select month(ngayLapHD) as 'time', count(cmnd) as 'guest', sum(sodv) as 'serviece' from hoaDon\n" +
"			where Year(ngayLapHD) = ?" +
"			group by month(ngayLapHD) ";
        return selectBySql(sql,year);
    }
    
    public List<Chart_BarE> selectYear() {
        String sql = "select Year(ngayLapHD) as 'time', count(cmnd) as 'guest', sum(sodv) as 'serviece' from hoaDon group by Year(ngayLapHD)";
        return selectBySql(sql);
    }
    
}
