package com.example.javawebproject.dao;

import com.example.javawebproject.model.History;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class HistoryDaoImpl implements HistoryDao {
    @Override
    public boolean addHistory(History history) throws DaoException {
        String sql="insert into apply_history values(?,?,?)";

        try {
            Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,history.getNum());
            pstmt.setTimestamp(2,history.getDate());
            pstmt.setString(3,history.getCode());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<History> findHistory(String num) throws DaoException {
        String sql="select * from apply_history where num=? order by date desc";
        ArrayList<History> histories=new ArrayList<History>();
        try{
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,num);
            ResultSet rst=pstmt.executeQuery();
            while(rst.next()){
                History history=new History(rst.getString(1),rst.getTimestamp(2),rst.getString(3));
                histories.add(history);
            }
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return histories;
    }

    @Override
    public boolean clockToday(String num) throws DaoException {
        String sql="select date from apply_history where num=? order by date desc";
        try {
            Connection conn=getConnection();
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,num);
            ResultSet rst=pstmt.executeQuery();
            if(rst.next()){
                Date date = new Date(System.currentTimeMillis());
                int day1 = rst.getTimestamp("date").getDay();
                int day2 = date.getDay();
                if(day1==day2)
                {
                    conn.close();
                    return true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
        return false;
    }
}
