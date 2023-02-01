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

import java.io.IOException;

@WebServlet(name = "DeleteStudentServlet", value = "/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao dao = new StudentDaoImpl();
        System.out.println(dao);
        studentBaseDate student = new studentBaseDate();
        String message = "";
        try{

            dao.deleteStudent(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>删除记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectCustomer.jsp");
        rd.forward(request,response);
    }

}
