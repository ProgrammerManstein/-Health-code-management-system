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

@WebServlet(name = "UpdateTeacherServlet", value = "/UpdateTeacherServlet")
public class UpdateTeacherServlet extends HttpServlet {
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
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码
            teacher.setName(new String(request.getParameter("name")
                    .getBytes("iso-8859-1"),"UTF-8"));
            teacher.setId(new String(request.getParameter("id")
                    .getBytes("iso-8859-1"),"UTF-8"));
            teacher.setNum(new String(request.getParameter("num")
                    .getBytes("iso-8859-1"),"UTF-8"));
            teacher.setSchool(new String(request.getParameter("school")
                    .getBytes("iso-8859-1"),"UTF-8"));
            teacher.setRole(new String(request.getParameter("role")
                    .getBytes("iso-8859-1"),"UTF-8"));
            teacher.setPhone(new String(request.getParameter("phone")
                    .getBytes("iso-8859-1"),"UTF-8"));
            dao.updateTeacher(teacher);
        }catch(Exception e){
            System.out.println(e);
            message = "<li>更新记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectTeacher.jsp");
        rd.forward(request,response);
    }
}
