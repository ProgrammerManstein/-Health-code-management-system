package com.example.javawebproject.dao;

import com.example.javawebproject.model.History;

import java.util.ArrayList;

public interface HistoryDao extends Dao{
    public boolean addHistory(History history) throws DaoException;
    public ArrayList<History> findHistory(String num) throws DaoException;
    public boolean clockToday(String num)throws DaoException;
}
