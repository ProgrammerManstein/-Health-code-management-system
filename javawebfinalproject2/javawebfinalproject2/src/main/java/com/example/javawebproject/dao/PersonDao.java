package com.example.javawebproject.dao;

import com.example.javawebproject.model.Person;

import java.sql.SQLException;

public interface PersonDao extends Dao{
    public boolean updatePerson(Person person) throws DaoException;
    public Person selectPerson(String num) throws DaoException;
    public int findGreen()throws  DaoException;
    public int findYellow()throws  DaoException;
    public int findRed()throws  DaoException;
    public int findGold()throws  DaoException;
    public int findQ1()throws  DaoException;
    public int findQ2()throws  DaoException;
    public int findQ3()throws  DaoException;
    public int findQ4()throws  DaoException;
    public boolean addPerson(String name,String num,String id)throws  DaoException;
}
