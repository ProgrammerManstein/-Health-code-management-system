package com.example.javawebproject.dao;

import com.example.javawebproject.model.studentBaseDate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements StudentDao {
    // 插入一条客户记录
    public boolean addStudent(studentBaseDate student)
            throws DaoException {
        String sql = "INSERT INTO studentBaseDate VALUES(?,?,?,?,?,?,?)";

        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getId());
            pstmt.setString(3,student.getNum());
            pstmt.setString(4,student.getSchool());
            pstmt.setString(5,student.getMajor());
            pstmt.setString(6,student.get_Class());
            pstmt.setString(7,student.getPhone());
            pstmt.executeUpdate();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }
    // 按id查询客户记录
    public ArrayList<studentBaseDate> findByNum(String num) throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT *" +
                " FROM studentBaseDate WHERE num like ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+num+"%");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 查询所有客户信息
    public ArrayList<studentBaseDate> findAllStudent()throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT * FROM studentBaseDate";
        try(
                Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rst = pstmt.executeQuery()){
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    // 按name查询客户记录
    public ArrayList<studentBaseDate> findByName(String name) throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT *" +
                " FROM studentBaseDate WHERE name like ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+name+"%");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("Class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //按school查询客户方法
    public ArrayList<studentBaseDate> findBySchool(String school) throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT *" +
                " FROM studentBaseDate WHERE school = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,school);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("Class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //按major查询客户方法
    public ArrayList<studentBaseDate> findByMajor(String major) throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT *" +
                " FROM studentBaseDate WHERE major = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,major);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("Class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    //按major查询客户方法
    public ArrayList<studentBaseDate> findByClass(String Class) throws DaoException{
        ArrayList<studentBaseDate> stuList = new ArrayList<studentBaseDate>();
        String sql = "SELECT *" +
                " FROM studentBaseDate WHERE Class = ?";
        try
        {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Class);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                studentBaseDate  student = new studentBaseDate();
                student.setName(rst.getString("name"));
                student.setId(rst.getString("id"));
                student.setNum(rst.getString("num"));
                student.setSchool(rst.getString("school"));
                student.setMajor(rst.getString("major"));
                student.set_Class(rst.getString("Class"));
                student.setPhone(rst.getString("phone"));
                stuList.add(student);
            }
            conn.close();
            return stuList;
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public void deleteStudent(String num) throws DaoException{
        String sql="delete from studentBaseDate where num=?";
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
    public void updateStudent(studentBaseDate student) throws DaoException{
        String sql="update studentBaseDate set name=?,num=?,school=?,major=?,Class=?,phone=? where num=?";
        try {
            Connection conn = getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql);
            pstmt.setString(1,student.getName());
            pstmt.setString(2,student.getNum());
            pstmt.setString(3,student.getSchool());
            pstmt.setString(4,student.getMajor());
            pstmt.setString(5,student.get_Class());
            pstmt.setString(6,student.getPhone());
            pstmt.setString(7,student.getNum());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public String loginStudent(String name,String num,String id) throws DaoException{
        String sql="select name,id,num from studentbasedate where name=? and num=? and id like ?";
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
