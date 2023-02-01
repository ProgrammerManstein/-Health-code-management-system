package com.example.javawebproject.dao;

import com.example.javawebproject.model.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDaoImpl implements com.example.javawebproject.dao.AdminDao {
    // 插入一条客户记录
    public boolean addAdmin(admin admin)
            throws DaoException {
        String sql = "INSERT INTO admin VALUES(?,?,?)";

        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1,admin.getNum());
            pstmt.setString(2,admin.getPassword());
            pstmt.setString(3,admin.getPower());

            pstmt.executeUpdate();
            conn.close();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    // 按id查询客户记录
    public ArrayList<admin> findByNum(String num) throws DaoException{
        ArrayList<admin> stuList = new ArrayList<admin>();
        String sql = "SELECT *" +
                " FROM admin WHERE num = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,num);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                admin  admin = new admin();
                admin.setNum(rst.getString("num"));
                admin.setPassword(rst.getString("password"));
                admin.setPower(rst.getString("power"));

                stuList.add(admin);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public admin findByNum_(String num) throws DaoException{

        String sql = "SELECT *" +
                " FROM admin WHERE num = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,num);
            ResultSet rst = pstmt.executeQuery();
            admin  admin = new admin();
            while(rst.next()){

                admin.setNum(rst.getString("num"));
                admin.setPassword(rst.getString("password"));
                admin.setPower(rst.getString("power"));
            }
            conn.close();
            return admin;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 查询所有客户信息
    public ArrayList<admin> findAllAdmin()throws DaoException{
        ArrayList<admin> stuList = new ArrayList<admin>();
        String sql = "SELECT * FROM admin";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                admin  admin = new admin();
                admin.setNum(rst.getString("num"));
                admin.setPassword(rst.getString("password"));
                admin.setPower(rst.getString("power"));
                stuList.add(admin);
            }conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteAdmin(String num) throws DaoException{
        String sql="delete from admin where num=?";
        try{
            Connection conn=getConnection();
            PreparedStatement psmt=conn.prepareStatement(sql);
            psmt.setString(1,num);
            psmt.executeUpdate();conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updateAdmin(admin admin) throws DaoException{
        String sql="update admin set num=?,password=?,power=?,where num=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,admin.getNum());
            pstmt.setString(2,admin.getPassword());
            pstmt.setString(3,admin.getPower());
            pstmt.setString(4,admin.getNum());
            pstmt.executeUpdate();conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
