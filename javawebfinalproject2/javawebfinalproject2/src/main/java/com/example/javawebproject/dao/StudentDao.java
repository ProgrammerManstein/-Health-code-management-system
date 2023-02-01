package com.example.javawebproject.dao;

import com.example.javawebproject.model.studentBaseDate;

import java.util.ArrayList;

public interface StudentDao extends Dao{
    //添加客户方法
    public boolean addStudent (studentBaseDate student) throws DaoException;
    // 按id查询客户方法
    public ArrayList<studentBaseDate> findByNum (String num) throws DaoException;
    //按name查询客户方法
    public ArrayList<studentBaseDate> findByName (String name) throws DaoException;
    //按school查询客户方法
    public ArrayList<studentBaseDate> findBySchool (String school) throws DaoException;
    //major
    public ArrayList<studentBaseDate> findByMajor (String major) throws DaoException;
    //Class
    public ArrayList<studentBaseDate> findByClass (String Class) throws DaoException;
    // 查询所有客户方法
    public ArrayList<studentBaseDate> findAllStudent ()throws DaoException;
    public void deleteStudent(String num) throws DaoException;
    public void updateStudent(studentBaseDate student) throws DaoException;

    public String loginStudent(String name,String num,String id) throws DaoException;
}
