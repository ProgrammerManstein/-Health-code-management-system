package com.example.javawebproject.controller;

import com.example.javawebproject.dao.DaoException;
import com.example.javawebproject.dao.PersonDao;
import com.example.javawebproject.dao.PersonDaoImpl;
import com.example.javawebproject.dao.StudentDaoImpl;
import com.example.javawebproject.model.studentBaseDate;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoadStudentServlet", value = "/LoadStudentServlet")
public class LoadStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        studentBaseDate[] datas = gson.fromJson(request.getReader(), studentBaseDate[].class);
        StudentDaoImpl dao = new StudentDaoImpl();
        PersonDao dao1=new PersonDaoImpl();
        for (studentBaseDate data:datas) {
            try {
                dao.addStudent(data);
                dao1.addPerson(data.getName(),data.getNum(),data.getId());
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
