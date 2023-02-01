package com.example.javawebproject.dao;

import com.example.javawebproject.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {
    @Override
    public boolean updatePerson(Person person)throws DaoException {
        String sql = "update apply_inf set phone=?,q1=?,q2=?,q3=?,q4=?,q5=?,days=?,code=? where num=?";

        try{
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,person.getPhone());
            pstmt.setString(2,person.getQ1());
            pstmt.setString(3,person.getQ2());
            pstmt.setString(4,person.getQ3());
            pstmt.setString(5,person.getQ4());
            pstmt.setInt(7,person.getDays());
            pstmt.setString(8,person.getCode());
            pstmt.setString(9,person.getNum());
            String[] q5list=person.getQ5();
            String q5=q5list[0];
            for(int i=1;i<q5list.length;i++){
                q5=q5+","+q5list[i];
            }
            pstmt.setString(6,q5);
            pstmt.executeUpdate();
            conn.close();
            return true;
        }catch(SQLException se){
            System.out.println(se);
            return false;
        }
    }

    @Override
    public Person selectPerson(String num) throws DaoException{
        String sql="select code,days,vaccines from apply_inf where num=?";
        Person person=new Person();
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,num);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                person.setCode(rst.getString("code"));
                person.setDays(rst.getInt("days"));
                person.setVaccines(rst.getString("vaccines"));
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }
    @Override
    public int findGreen() throws DaoException {
        String sql="select num from apply_inf where code=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"green");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findYellow() throws DaoException {
        String sql="select num from apply_inf where code=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"yellow");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findRed() throws DaoException {
        String sql="select num from apply_inf where code=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"red");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findGold() throws DaoException {
        String sql="select num from apply_inf where code=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"gold");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findQ1() throws DaoException {
        String sql="select num from apply_inf where q1=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"yes");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findQ2() throws DaoException {
        String sql="select num from apply_inf where q2=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"yes");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findQ3() throws DaoException {
        String sql="select num from apply_inf where q3=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"yes");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int findQ4() throws DaoException {
        String sql="select num from apply_inf where q4=?";
        int i=0;
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"yes");
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                i++;
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean addPerson(String name, String num, String id) throws DaoException {
        String sql="insert into apply_inf (name,num,id) values(?,?,?)";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,num);
            pstmt.setString(3,id);
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }
}
