/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Types;

/**
 *
 * @author ASUS
 */
public class JdbcHelper {
    private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl="jdbc:sqlserver://localhost:1433;databaseName=qlks";
    private static String username="sa";
    private static String password="123";
    static Connection con = null;
     static {
        try {
            Class.forName(driver);
            con  = DriverManager.getConnection(dburl, username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getStmt(String sql, Object... args) throws Exception {
        con  = DriverManager.getConnection(dburl, username, password);
        PreparedStatement stm;
        if (sql.trim().startsWith("{")) {
            stm = con.prepareCall(sql);
        } else {
            stm = con.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            stm.setObject(i + 1, args[i]);
        }
        return stm;
    }

    public static int update(String sql, Object... args) {
        try{
            PreparedStatement stm = JdbcHelper.getStmt(sql, args);  
            try{
                return stm.executeUpdate();
            }finally{
                stm.getConnection().close();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static ResultSet query(String sql, Object... args) throws Exception {
        PreparedStatement stm = JdbcHelper.getStmt(sql, args);
        return stm.executeQuery();
    }

    public static Object value(String sql, Object... args) {
            try{
                ResultSet rs = JdbcHelper.query(sql, args);
                if(rs.next()){
                    return rs.getObject(0);
                }
                rs.getStatement().getConnection().close();
                return null;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
    }
    
    public static CallableStatement callFunction(String sql, Object...args)throws Exception{
        con  = DriverManager.getConnection(dburl, username, password);
        CallableStatement call  = con.prepareCall(sql);
        call.registerOutParameter(1,Types.FLOAT);
        for(int i = 1; i < args.length + 1 ;i ++ ){
            call.setObject(i+1,args[i-1]);
        }
        call.execute();
        return call;
    }
    
    
      public Float giaDv (int maThue){
        String sql = " {? = call giadv(?)}";
        return (Float)JdbcHelper.value(sql,maThue);
    }
    
}
