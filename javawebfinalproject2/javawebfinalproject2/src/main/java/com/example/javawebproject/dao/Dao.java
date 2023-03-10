package com.example.javawebproject.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public interface Dao {

    public static DataSource getDataSource(){
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup("java:comp/env/jdbc/javawebproject");

        }catch(NamingException ne){
            System.out.println(ne);
        }
        return dataSource;
    }

    public default Connection getConnection() throws

            com.example.javawebproject.dao.DaoException {
        DataSource dataSource = getDataSource();
        Connection conn = null;
        try{
            conn =  dataSource.getConnection();
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
        return  conn;
    }
}