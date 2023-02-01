package com.example.javawebproject.controller;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.studentBaseDate;
import com.example.javawebproject.model.teacherBaseDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectStudentAndTeacherServlet", value = "/SelectStudentAndTeacherServlet")
public class SelectStudentAndTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("student",null);
        session.setAttribute("teacher",null);
        session.setAttribute("studentList",null);
        session.setAttribute("teacherList",null);
        String num = request.getParameter("numOname");
        String school=request.getParameter("school");
        String role=request.getParameter("role");
        session.setAttribute("nu",num);

        StudentDao studentDao=new StudentDaoImpl();
        studentBaseDate student=new studentBaseDate();
        TeacherDao teacherDao=new TeacherDaoImpl();
        teacherBaseDate teacher=new teacherBaseDate();
        ArrayList<studentBaseDate> studentBaseDateArrayList=new ArrayList<studentBaseDate>();
        ArrayList<teacherBaseDate> teacherBaseDateArrayList=new ArrayList<teacherBaseDate>();
        try {

            if(role.equals("全部")){
                session.setAttribute("student","student");
                session.setAttribute("teacher","teacher");

                teacherBaseDateArrayList=teacherDao.findByNum(num);//验证输入的是否为num
                if(teacherBaseDateArrayList.size()==0){//不是num
                    teacherBaseDateArrayList=teacherDao.findByName(num);//验证输入的是否为name
                    if(teacherBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                        teacherBaseDateArrayList=teacherDao.findBySchool(school);
                        if(teacherBaseDateArrayList.size()==0){//通过学院查找
                            //输出全部
                            teacherBaseDateArrayList=teacherDao.findAllTeacher();
                            session.setAttribute("teacherList",teacherBaseDateArrayList);

                        }

                    }
                }

                studentBaseDateArrayList=studentDao.findByNum(num);//验证输入的是否为num
                if(studentBaseDateArrayList.size()==0){//不是num
                    studentBaseDateArrayList=studentDao.findByName(num);//验证输入的是否为name
                    if(studentBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                        studentBaseDateArrayList=studentDao.findBySchool(school);
                        if(studentBaseDateArrayList.size()==0){//通过学院查找
                            studentBaseDateArrayList=studentDao.findAllStudent();
                        }
                    }
                }
                if(!school.equals("全部")) {
                    for (int i = 0; i < teacherBaseDateArrayList.size(); i++) {
                        if (!teacherBaseDateArrayList.get(i).getSchool().equals(school)) {
                            teacherBaseDateArrayList.remove(i);
                            i--;
                        }
                    }
                    for (int i = 0; i < studentBaseDateArrayList.size(); i++) {
                        if (!studentBaseDateArrayList.get(i).getSchool().equals(school)) {
                            studentBaseDateArrayList.remove(i);
                            i--;
                        }
                    }
                }
                session.setAttribute("teacherList",teacherBaseDateArrayList);
                session.setAttribute("studentList",studentBaseDateArrayList);
                response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacher.jsp");
                return;

            }
            else if(role.equals("老师")){
                session.setAttribute("teacher","teacher");
                teacherBaseDateArrayList=teacherDao.findByNum(num);//验证输入的是否为num
                if(teacherBaseDateArrayList.size()==0){//不是num
                    teacherBaseDateArrayList=teacherDao.findByName(num);//验证输入的是否为name
                    if(teacherBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                        teacherBaseDateArrayList=teacherDao.findBySchool(school);
                        if(teacherBaseDateArrayList.size()==0){//通过学院查找
                            //输出全部
                            teacherBaseDateArrayList=teacherDao.findAllTeacher();
                        }

                    }
                }
                if(!school.equals("全部")) {
                    for (int i = 0; i < teacherBaseDateArrayList.size(); i++) {
                        if (!teacherBaseDateArrayList.get(i).getSchool().equals(school)) {
                            teacherBaseDateArrayList.remove(i);
                            i--;
                        }
                    }
                }
                session.setAttribute("teacherList",teacherBaseDateArrayList);
                response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacher.jsp");
                return;
            }
            else{
                session.setAttribute("student","student");
                studentBaseDateArrayList=studentDao.findByNum(num);//验证输入的是否为num
                if(studentBaseDateArrayList.size()==0){//不是num
                    studentBaseDateArrayList=studentDao.findByName(num);//验证输入的是否为name
                    if(studentBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                        studentBaseDateArrayList=studentDao.findBySchool(school);
                        if(studentBaseDateArrayList.size()==0){//通过学院查找
                            studentBaseDateArrayList=studentDao.findAllStudent();

                        }

                    }
                }
            }

            if(!school.equals("全部")) {
                for (int i = 0; i < studentBaseDateArrayList.size(); i++) {
                    if (!studentBaseDateArrayList.get(i).getSchool().equals(school)) {
                        studentBaseDateArrayList.remove(i);
                        i--;
                    }
                }
            }
            session.setAttribute("studentList",studentBaseDateArrayList);
            response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacher.jsp");
            return;


        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
