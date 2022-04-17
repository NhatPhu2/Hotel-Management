/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DAO;

import com.Entity.ThuePhong;
import com.utils.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ThuePhongDAO extends QLKSDAO<ThuePhong, Integer> {

    @Override
    public void insert(ThuePhong tp) {
        String sql = "set identity_insert thuephong on"
                + " INSERT INTO thuephong (mathue,soPhong, cmnd, ngayThue, ngayTra) VALUES (?, ? ,?, ?, ?)"
                + " set identity_insert thuephong off";
        JdbcHelper.update(sql,
                tp.getMaThue(),
                tp.getSoPhong(),
                tp.getCmnd(),
                tp.getNgayThue(),
                tp.getNgayTra()
        );
    }

    @Override
    public void update(ThuePhong tp) {
        String sql = "UPDATE thuephong SET soPhong=?, cmnd=?, ngayThue=?, ngayTra=? WHERE mathue=?";
        JdbcHelper.update(sql,
                tp.getSoPhong(),
                tp.getCmnd(),
                tp.getNgayThue(),
                tp.getNgayTra(),
                tp.getMaThue()
        );
    }

    @Override
    public void delete(Integer MaThue) {
        String sql = "DELETE FROM thuephong WHERE mathue=?";
        JdbcHelper.update(sql, MaThue);
    }

    @Override
    public ThuePhong selectById(Integer MaThue) {
        String sql = "SELECT * FROM thuephong WHERE mathue=?";
        List<ThuePhong> list = this.selectBySql(sql, MaThue);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<ThuePhong> selectAll() {
        String sql = "select * from thuephong";
        return selectBySql(sql);
    }

    @Override
    public List<ThuePhong> selectBySql(String sql, Object... args) {
        List<ThuePhong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.query(sql, args);
                while (rs.next()) {
                    ThuePhong model = readFormResultSet(rs);
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

    public ThuePhong readFormResultSet(ResultSet rs) throws Exception {
        ThuePhong tp = new ThuePhong();
        tp.setMaThue(rs.getInt("mathue"));
        tp.setSoPhong(rs.getString("soPhong"));
        tp.setCmnd(rs.getString("cmnd"));
        tp.setNgayThue(rs.getDate("ngayThue"));
        tp.setNgayTra(rs.getDate("ngayTra"));
        return tp;
    }

    public float getGiaDv(int maThue) {
        float i = 0;
        try {
            String sql = "{ ? = call giadv(?)}";
             i = JdbcHelper.callFunction(sql, maThue).getFloat(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public float getThanhTien(int maThue){
        float i = 0;
        try {
            String sql = "{ ? = call thanhtien(?)}";
             i = JdbcHelper.callFunction(sql, maThue).getFloat(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
    public int soDV(int maThue){
        int i =0;
         try {
            String sql = "{ ? = call sodv(?)}";
             i = JdbcHelper.callFunction(sql, maThue).getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
    
     public List<ThuePhong> selectByKeyWord(String keyword) {
        String sql = "SELECT * FROM thuephong WHERE cmnd LIKE ?";
        return this.selectBySql(sql, "%"+keyword+"%");
    }
     
     public int tienCoc(String soPhong){
        int i =0;
         try {
            String sql = "{ ? = call tienCoc(?)}";
             i = JdbcHelper.callFunction(sql,soPhong).getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
     
     
     public List<Object[]> tenDichVu(int maThue){
         String sql = "{call tendichvu(?)}";
        String cols[] ={"tendv","gia","soluong","ngaysudung"} ;
         return getListOfArray(sql,cols,maThue);
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
