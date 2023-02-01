package com.example.javawebproject.controller;

import com.example.javawebproject.dao.DaoException;
import com.example.javawebproject.dao.TeacherDao;
import com.example.javawebproject.dao.TeacherDaoImpl;
import com.example.javawebproject.model.admin;
import com.example.javawebproject.model.teacherBaseDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateTeacherBaseServlet", value = "/UpdateTeacherBaseServlet")
public class UpdateTeacherBaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ArrayList<String> nA=new ArrayList<String>();
        nA.add(request.getParameter("nA1"));
        nA.add(request.getParameter("nA2"));
        nA.add(request.getParameter("nA3"));
        nA.add(request.getParameter("nA4"));
        nA.add(request.getParameter("nA5"));
        ArrayList<String>nU=new ArrayList<String>();
        nU.add(request.getParameter("nU1"));
        nU.add(request.getParameter("nU2"));
        nU.add(request.getParameter("nU3"));
        nU.add(request.getParameter("nU4"));
        nU.add(request.getParameter("nU5"));
        ArrayList<String>cS=new ArrayList<String>();
        cS.add(request.getParameter("cS1"));
        cS.add(request.getParameter("cS2"));
        cS.add(request.getParameter("cS3"));
        cS.add(request.getParameter("cS4"));
        cS.add(request.getParameter("cS5"));

        ArrayList<String>pH=new ArrayList<String>();
        pH.add(request.getParameter("pH1"));
        pH.add(request.getParameter("pH2"));
        pH.add(request.getParameter("pH3"));
        pH.add(request.getParameter("pH4"));
        pH.add(request.getParameter("pH5"));

        TeacherDao teacherDao = new TeacherDaoImpl();

        ArrayList<admin> adminArrayList=new ArrayList<admin>();
        ArrayList<teacherBaseDate> teacherBaseDateArrayList=new ArrayList<teacherBaseDate>();

        for(int i=0;i<nA.size();i++){
            if(nA.get(i)!=null){
                admin  admin=new admin();
                teacherBaseDate teacher=new teacherBaseDate();
                teacher.setName(new String(nA.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8")

                teacher.setNum(new String(nU.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));
                teacher.setSchool(new String(cS.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));

                teacher.setPhone(new String(pH.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));


                teacherBaseDateArrayList.add(teacher);
                try {
                    teacherDao.updateTeacher_NOROLEandID(teacher);
                } catch (DaoException e) {
                    e.printStackTrace();
                }

            }

        }
        HttpSession session=request.getSession();
        session.setAttribute("teacherList",teacherBaseDateArrayList);
        response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacher.jsp？successTeacher=successTeacher");

    }
}
