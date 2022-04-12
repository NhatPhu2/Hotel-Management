/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeDAO {
    public List<Object[]> doanhThu(Date min,Date max){
        String sql = "{call doanhthu(?,?)}";
        String cols[] ={"sokh","thanhtien"}; 
        return getListOfArray(sql, cols,min,max);
    }
    public List<Object[]> tkkhachhang(Date min,Date max){
        String sql = "{call tkkhachhang(?,?)}";
        String cols[]={"tenkhach","sodt","cmnd","solan","songay"};
        return getListOfArray(sql, cols,min,max);
    }
    private List<Object[]> getListOfArray(String sql,String[] cols,Object...args){
        try{
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = JdbcHelper.query(sql, args);
            while(rs.next()){
                Object vals[] = new Object[cols.length];
                for(int i =0; i <cols.length;i++){
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
                
            }
            rs.getStatement().getConnection().close();
            return list;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
