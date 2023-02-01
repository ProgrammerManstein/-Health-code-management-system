package com.example.javawebproject.dao;

import com.example.javawebproject.model.teacherBaseDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDaoImpl implements TeacherDao{
    // 插入一条客户记录
    public boolean addTeacher(teacherBaseDate teacher)
            throws DaoException {
        String sql = "INSERT INTO teacherBaseDate VALUES(?,?,?,?,?,?,?)";

        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getId());
            pstmt.setString(3,teacher.getNum());
            pstmt.setString(4,teacher.getSchool());
            pstmt.setString(5,teacher.getRole());
            pstmt.setString(7,teacher.getPhone());
            pstmt.executeUpdate();
            conn.close();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    // 按id查询客户记录
    public ArrayList<teacherBaseDate> findByNum(String num) throws DaoException{
        ArrayList<teacherBaseDate> stuList = new ArrayList<teacherBaseDate>();
        String sql = "SELECT *" +
                " FROM teacherBaseDate WHERE num like ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+num+"%");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                teacherBaseDate  teacher = new teacherBaseDate();
                teacher.setName(rst.getString("name"));
                teacher.setId(rst.getString("id"));
                teacher.setNum(rst.getString("num"));
                teacher.setSchool(rst.getString("school"));
                teacher.setRole(rst.getString("role"));
                teacher.setPhone(rst.getString("phone"));
                stuList.add(teacher);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 按name查询客户记录
    public ArrayList<teacherBaseDate> findByName(String name) throws DaoException{
        ArrayList<teacherBaseDate> stuList = new ArrayList<teacherBaseDate>();
        String sql = "SELECT *" +
                " FROM teacherBaseDate WHERE name like ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                teacherBaseDate  teacher = new teacherBaseDate();
                teacher.setName(rst.getString("name"));
                teacher.setId(rst.getString("id"));
                teacher.setNum(rst.getString("num"));
                teacher.setSchool(rst.getString("school"));
                teacher.setRole(rst.getString("role"));
                teacher.setPhone(rst.getString("phone"));
                stuList.add(teacher);
            }conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //按school查询客户方法
    public ArrayList<teacherBaseDate> findBySchool(String school) throws DaoException{
        ArrayList<teacherBaseDate> stuList = new ArrayList<teacherBaseDate>();
        String sql = "SELECT *" +
                " FROM teacherBaseDate WHERE school = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,school);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                teacherBaseDate  teacher = new teacherBaseDate();
                teacher.setName(rst.getString("name"));
                teacher.setId(rst.getString("id"));
                teacher.setNum(rst.getString("num"));
                teacher.setSchool(rst.getString("school"));
                teacher.setRole(rst.getString("role"));
                teacher.setPhone(rst.getString("phone"));
                stuList.add(teacher);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<teacherBaseDate> findByRole(String role) throws DaoException{
        ArrayList<teacherBaseDate> stuList = new ArrayList<teacherBaseDate>();
        String sql = "SELECT *" +
                " FROM teacherBaseDate WHERE role = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,role);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                teacherBaseDate  teacher = new teacherBaseDate();
                teacher.setName(rst.getString("name"));
                teacher.setId(rst.getString("id"));
                teacher.setNum(rst.getString("num"));
                teacher.setSchool(rst.getString("school"));
                teacher.setRole(rst.getString("role"));
                teacher.setPhone(rst.getString("phone"));
                stuList.add(teacher);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // 查询所有客户信息
    public ArrayList<teacherBaseDate> findAllTeacher()throws DaoException{
        ArrayList<teacherBaseDate> stuList = new ArrayList<teacherBaseDate>();
        String sql = "SELECT * FROM teacherBaseDate";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                teacherBaseDate  teacher = new teacherBaseDate();
                teacher.setName(rst.getString("name"));
                teacher.setId(rst.getString("id"));
                teacher.setNum(rst.getString("num"));
                teacher.setSchool(rst.getString("school"));
                teacher.setRole(rst.getString("role"));
                teacher.setPhone(rst.getString("phone"));
                stuList.add(teacher);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteTeacher(String num) throws DaoException{
        String sql="delete from teacherBaseDate where num=?";
        try{
            Connection conn=getConnection();
            PreparedStatement psmt=conn.prepareStatement(sql);
            psmt.setString(1,num);
            psmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void updateTeacher(teacherBaseDate teacher) throws DaoException{
        String sql="update teacherBaseDate set name=?,id=?,num=? ,school=?,role=?,phone=? where num=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getId());
            pstmt.setString(3,teacher.getNum());
            pstmt.setString(4,teacher.getSchool());
            pstmt.setString(5,teacher.getRole());
            pstmt.setString(6,teacher.getPhone());
            pstmt.setString(7,teacher.getNum());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateTeacher_NOROLEandID(teacherBaseDate teacher) throws DaoException{
        String sql="update teacherBaseDate set name=?,num=? ,school=?,phone=? where num=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,teacher.getName());
            pstmt.setString(2,teacher.getNum());
            pstmt.setString(3,teacher.getSchool());
            pstmt.setString(4,teacher.getPhone());
            pstmt.setString(5,teacher.getNum());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String loginTeacher(String name, String num, String id) throws DaoException {
        String sql="select name,id,num from teacherbasedate where name=? and num=? and id like ?";
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            String wholeid="%"+id;
            pstmt.setString(1,name);
            pstmt.setString(2,num);
            pstmt.setString(3,wholeid);
            ResultSet rst = pstmt.executeQuery();
            if (rst.next()){
                id=rst.getString("id");
            }
            else {
                conn.close();
                return null;
            }
            conn.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return id;
    }
}
