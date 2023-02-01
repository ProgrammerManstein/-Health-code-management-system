package com.example.javawebproject.controller.student;

import com.example.javawebproject.dao.StudentDao;
import com.example.javawebproject.dao.StudentDaoImpl;
import com.example.javawebproject.model.studentBaseDate;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectStudentServlet", value = "/SelectStudentServlet")
public class SelectStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao dao = new StudentDaoImpl();
        System.out.println(dao);
        ArrayList<studentBaseDate> studentlist=new ArrayList<studentBaseDate>();
        String message = "";
        try{
            studentlist = dao.findByNum(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>查找记录错误！</li>" + e;
        }
        HttpSession session=request.getSession();
        session.setAttribute("studentlist", studentlist);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAll.jsp");
        rd.forward(request,response);
    }
}
