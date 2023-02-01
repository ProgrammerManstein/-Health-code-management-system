package com.example.javawebproject.controller;

import com.example.javawebproject.dao.DaoException;
import com.example.javawebproject.dao.StudentDao;
import com.example.javawebproject.dao.StudentDaoImpl;
import com.example.javawebproject.model.studentBaseDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateStudentBaseServlet", value = "/UpdateStudentBaseServlet")
public class UpdateStudentBaseServlet extends HttpServlet {
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
        ArrayList<String>mJ=new ArrayList<String>();
        mJ.add(request.getParameter("mJ1"));
        mJ.add(request.getParameter("mJ2"));
        mJ.add(request.getParameter("mJ3"));
        mJ.add(request.getParameter("mJ4"));
        mJ.add(request.getParameter("mJ5"));
        ArrayList<String>cL=new ArrayList<String>();
        cL.add(request.getParameter("cL1"));
        cL.add(request.getParameter("cL2"));
        cL.add(request.getParameter("cL3"));
        cL.add(request.getParameter("cL4"));
        cL.add(request.getParameter("cL5"));
        ArrayList<String>pH=new ArrayList<String>();
        pH.add(request.getParameter("pH1"));
        pH.add(request.getParameter("pH2"));
        pH.add(request.getParameter("pH3"));
        pH.add(request.getParameter("pH4"));
        pH.add(request.getParameter("pH5"));

        StudentDao studentDao = new StudentDaoImpl();
        ArrayList<studentBaseDate> studentBaseDateArrayList=new ArrayList<studentBaseDate>();

        for(int i=0;i<nA.size();i++){
            if(nA.get(i)!=null){
                studentBaseDate student=new studentBaseDate();
                student.setName(new String(nA.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8")
                student.setNum(new String(nU.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));
                student.setSchool(new String(cS.get(i)));
                student.setMajor(new String(mJ.get(i)));
                student.set_Class(new String(cL.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));
                student.setPhone(new String(pH.get(i)));
//                        .getBytes("iso-8859-1"),"UTF-8"));

                studentBaseDateArrayList.add(student);
                try {
                    studentDao.updateStudent(student);
                } catch (DaoException e) {
                    e.printStackTrace();
                }

            }

        }
        HttpSession session=request.getSession();
        session.setAttribute("studentList",studentBaseDateArrayList);
        response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacher.jsp？successStudent=successStudent");


    }
}
