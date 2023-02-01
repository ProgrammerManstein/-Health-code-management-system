package com.example.javawebproject.controller.teacher;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.Person;
import com.example.javawebproject.model.teacherBaseDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectTeacherHealthServlet", value = "/SelectTeacherHealthServlet")
public class SelectTeacherHealthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        session.setAttribute("YoN",null);
        session.setAttribute("code",null);
        request.getSession().setAttribute("teacherList",null);
        String num = request.getParameter("numOname");
        String school=request.getParameter("school");

        request.getSession().setAttribute("nu",num);
        PersonDao personDao=new PersonDaoImpl();
        HistoryDao historyDao=new HistoryDaoImpl();
        TeacherDao teacherDao=new TeacherDaoImpl();
        teacherBaseDate teacher=new teacherBaseDate();
        ArrayList<teacherBaseDate> teacherBaseDateArrayList=new ArrayList<teacherBaseDate>();
        try {
            teacherBaseDateArrayList=teacherDao.findByNum(num);//验证输入的是否为num
            if(teacherBaseDateArrayList.size()==0){//不是num
                teacherBaseDateArrayList=teacherDao.findByName(num);//验证输入的是否为name
                if(teacherBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                    teacherBaseDateArrayList=teacherDao.findBySchool(school);
                    if(teacherBaseDateArrayList.size()==0){//通过学院查找
                        teacherBaseDateArrayList=teacherDao.findAllTeacher();
                        session.setAttribute("teacherList",teacherBaseDateArrayList);
                        response.sendRedirect(request.getContextPath()+"/SelectTeacherAndStudentHealth.jsp");
                        return;
                    }

                }
            }
            if(!school.equals("全部")){
                for(int i=0;i<teacherBaseDateArrayList.size();i++){
                    if(!teacherBaseDateArrayList.get(i).getSchool().equals(school)){
                        teacherBaseDateArrayList.remove(i);
                        i--;
                    }
                }
            }
            ArrayList<String> YoN=new ArrayList<>();
            ArrayList<String> code=new ArrayList<>();
            for(int i=0;i<teacherBaseDateArrayList.size();i++){
                String nu=teacherBaseDateArrayList.get(i).getNum();
                Person person=personDao.selectPerson(nu);
                if(historyDao.clockToday(nu)){
                    YoN.add("已打卡");
                    code.add(person.getCode());
                }
                else{
                    YoN.add("未打卡");
                    code.add("无");
                }
            }
            session.setAttribute("YoN",YoN);
            session.setAttribute("code",code);
            session.setAttribute("teacherList",teacherBaseDateArrayList);
            response.sendRedirect(request.getContextPath()+"//SelectTeacherAndStudentHealth.jsp");


        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
