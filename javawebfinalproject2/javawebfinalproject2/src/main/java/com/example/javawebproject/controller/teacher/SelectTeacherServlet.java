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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectTeacherServlet", value = "/SelectTeacherServlet")
public class SelectTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherDao dao = new TeacherDaoImpl();
        System.out.println(dao);
        ArrayList<teacherBaseDate> teacherlist=new ArrayList<teacherBaseDate>();
        String message = "";
        try{
            teacherlist = dao.findByNum(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>查找记录错误！</li>" + e;
        }
        HttpSession session=request.getSession();
        session.setAttribute("teacherlist", teacherlist);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAll.jsp");
        rd.forward(request,response);
    }
}
