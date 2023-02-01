package com.example.javawebproject.dao;

import com.example.javawebproject.model.admin;

import java.util.ArrayList;

public interface AdminDao extends Dao{
    //添加客户方法
    public boolean addAdmin (admin admin) throws DaoException;
    // 按id查询客户方法
    public ArrayList<admin> findByNum (String num) throws DaoException;
    public admin findByNum_ (String num) throws DaoException;

    // 查询所有客户方法
    public ArrayList<admin> findAllAdmin ()throws DaoException;
    public void deleteAdmin(String num) throws DaoException;
    public void updateAdmin(admin admin) throws DaoException;
}
