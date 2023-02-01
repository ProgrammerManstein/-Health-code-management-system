package com.example.javawebproject.controller;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.History;
import com.example.javawebproject.model.Person;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "LoginPersonServlet", value = "/LoginPersonServlet")
public class LoginPersonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String message = "";
        String name=request.getParameter("name");
        String id=request.getParameter("id");
        String num=request.getParameter("num");
        String type=request.getParameter("type");
        if(type.equals("teacher")){
            TeacherDao teacher=new TeacherDaoImpl();
            try {
                id=teacher.loginTeacher(name,num,id);
                if(id==null){
                    message+="请输入正确的姓名、学号/工号和身份证后八位";
                    request.setAttribute("message",message);
                    RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                    rd.forward(request,response);
                    return;
                }
                else{
                    History formerperson=new History();
                    HistoryDao dao=new HistoryDaoImpl();
                    if (dao.clockToday(num)) {
                        formerperson=dao.findHistory(num).get(0);
                        Person person = new Person();
                        person.setCode(formerperson.getCode());
                        person.setName(name);
                        person.setNum(num);
                        person.setId(id);
                        person.setType(type);
                        HttpSession session = request.getSession();
                        session.setAttribute("person", person);
                        session.setAttribute("color", person.getCode());
                        RequestDispatcher rd = request.getRequestDispatcher("/code.jsp");
                        rd.forward(request, response);
                        return;
                    }
                    Person person=new Person();
                    person.setName(name);
                    person.setNum(num);
                    person.setId(id);
                    person.setType(type);
                    HttpSession session=request.getSession();
                    session.setAttribute("person",person);
                    RequestDispatcher rd=request.getRequestDispatcher("/apply.jsp");
                    rd.forward(request,response);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
        if(type.equals("student")){
            StudentDao teacher=new StudentDaoImpl();
            try {
                id=teacher.loginStudent(name,num,id);

                if(id==null){
                    message+="请输入正确的姓名、学号/工号和身份证后八位";
                    request.setAttribute("message",message);
                    RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                    rd.forward(request,response);
                    return;
                }
                else{
                    History formerperson=new History();
                    HistoryDao dao=new HistoryDaoImpl();
                    if (dao.clockToday(num)) {
                        formerperson=dao.findHistory(num).get(0);
                        Person person = new Person();
                        person.setCode(formerperson.getCode());
                        person.setName(name);
                        person.setNum(num);
                        person.setId(id);
                        person.setType(type);
                        HttpSession session = request.getSession();
                        session.setAttribute("person", person);
                        session.setAttribute("color", person.getCode());
                        RequestDispatcher rd = request.getRequestDispatcher("/code.jsp");
                        rd.forward(request, response);
                        return;
                    }
                    Person person=new Person();
                    person.setName(name);
                    person.setNum(num);
                    person.setId(id);
                    person.setType(type);
                    HttpSession session=request.getSession();
                    session.setAttribute("person",person);
                    RequestDispatcher rd=request.getRequestDispatcher("/apply.jsp");
                    rd.forward(request,response);
                }
            } catch (DaoException e) {
                e.printStackTrace();
            }
        }
    }
}
