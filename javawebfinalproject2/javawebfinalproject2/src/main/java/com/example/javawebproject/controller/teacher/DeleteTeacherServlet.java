package com.example.javawebproject.controller.teacher;

import com.example.javawebproject.dao.TeacherDao;
import com.example.javawebproject.dao.TeacherDaoImpl;
import com.example.javawebproject.model.teacherBaseDate;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteTeacherServlet", value = "/DeleteTeacherServlet")
public class DeleteTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println(dao);
        teacherBaseDate teacher = new teacherBaseDate();
        String message = "";
        try{

            dao.deleteTeacher(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>删除记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectCustomer.jsp");
        rd.forward(request,response);
    }
}
