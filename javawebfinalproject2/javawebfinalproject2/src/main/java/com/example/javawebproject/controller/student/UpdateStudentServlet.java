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

@WebServlet(name = "UpdateStudentServlet", value = "/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
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
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码
            student.setName(new String(request.getParameter("name")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.setId(new String(request.getParameter("id")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.setNum(new String(request.getParameter("num")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.setSchool(new String(request.getParameter("school")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.setMajor(new String(request.getParameter("major")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.set_Class(new String(request.getParameter("Class")
                    .getBytes("iso-8859-1"),"UTF-8"));
            student.setPhone(new String(request.getParameter("phone")
                    .getBytes("iso-8859-1"),"UTF-8"));
            boolean success = dao.addStudent(student);
        }catch(Exception e){
            System.out.println(e);
            message = "<li>更新记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectStudent.jsp");
        rd.forward(request,response);
    }
}
