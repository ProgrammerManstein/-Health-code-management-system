package com.example.javawebproject.dao;

import com.example.javawebproject.model.teacherBaseDate;

import java.util.ArrayList;

public interface TeacherDao extends Dao{
    //添加客户方法
    public boolean addTeacher (teacherBaseDate teacher) throws DaoException;
    // 按id查询客户方法
    public ArrayList<teacherBaseDate> findByNum (String num) throws DaoException;
    public ArrayList<teacherBaseDate> findByName (String name) throws DaoException;
    //按school查询客户方法
    public ArrayList<teacherBaseDate> findBySchool (String school) throws DaoException;
    //按role查询客户方法
    public ArrayList<teacherBaseDate> findByRole (String role) throws DaoException;

    // 查询所有客户方法

    public ArrayList<teacherBaseDate> findAllTeacher ()throws DaoException;
    public void deleteTeacher(String num) throws DaoException;
    public void updateTeacher(teacherBaseDate teacher) throws DaoException;
    public void updateTeacher_NOROLEandID(teacherBaseDate teacher) throws DaoException;
    public String loginTeacher(String name,String num,String id) throws DaoException;
}
