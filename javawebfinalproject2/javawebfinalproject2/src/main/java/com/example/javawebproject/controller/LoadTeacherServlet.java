package com.example.javawebproject.controller;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.studentBaseDate;
import com.example.javawebproject.model.teacherBaseDate;
import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoadTeacherServlet", value = "/LoadTeacherServlet")
public class LoadTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        teacherBaseDate[] datas = gson.fromJson(request.getReader(),teacherBaseDate[].class);
        TeacherDao dao = new TeacherDaoImpl();
        PersonDao dao1=new PersonDaoImpl();
        for (teacherBaseDate data:datas) {
            try {
                dao.addTeacher(data);
                dao1.addPerson(data.getName(),data.getNum(),data.getId());
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
