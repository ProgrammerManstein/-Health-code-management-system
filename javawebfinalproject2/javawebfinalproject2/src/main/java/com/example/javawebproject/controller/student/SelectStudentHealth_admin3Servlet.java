package com.example.javawebproject.controller.student;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.Person;
import com.example.javawebproject.model.studentBaseDate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectStudentHealth_admin3Servlet", value = "/SelectStudentHealth_admin3Servlet")
public class SelectStudentHealth_admin3Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        session.setAttribute("YoN",null);
        session.setAttribute("code",null);
        request.getSession().setAttribute("studentList",null);
        String num = request.getParameter("numOname");
        String school=(String) session.getAttribute("AdminSchool");
        String major=request.getParameter("major");
        String Class=request.getParameter("Class");

        request.getSession().setAttribute("nu",num);
        PersonDao personDao=new PersonDaoImpl();
        HistoryDao historyDao=new HistoryDaoImpl();
        StudentDao studentDao=new StudentDaoImpl();
        studentBaseDate student=new studentBaseDate();
        ArrayList<studentBaseDate> studentBaseDateArrayList=new ArrayList<studentBaseDate>();
        try {
            studentBaseDateArrayList=studentDao.findByNum(num);//验证输入的是否为num
            if(studentBaseDateArrayList.size()==0){//不是num
                studentBaseDateArrayList=studentDao.findByName(num);//验证输入的是否为name
                if(studentBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                    studentBaseDateArrayList=studentDao.findBySchool(school);
                    if(studentBaseDateArrayList.size()==0){//通过学院查找
                        studentBaseDateArrayList=studentDao.findByMajor(major);
                        if(studentBaseDateArrayList.size()==0){//通过学院查找
                            studentBaseDateArrayList=studentDao.findByClass(Class);
                            if(studentBaseDateArrayList.size()==0){//通过学院查找
                                studentBaseDateArrayList=studentDao.findAllStudent();
                                session.setAttribute("studentList",studentBaseDateArrayList);
                                response.sendRedirect(request.getContextPath()+"/SelectStudentAndTeacherHealth_admin3.jsp");
                                return;
                            }

                        }

                    }

                }
            }
            if(major!=null)
            if(!major.equals("全部")){
                for(int i=0;i<studentBaseDateArrayList.size();i++){
                    if(!studentBaseDateArrayList.get(i).getMajor().equals(major)){
                        studentBaseDateArrayList.remove(i);
                        i--;
                    }
                }
            }
            if(Class!=null)
            if(!Class.equals("全部")){
                for(int i=0;i<studentBaseDateArrayList.size();i++){
                    if(!studentBaseDateArrayList.get(i).get_Class().equals(Class)){
                        studentBaseDateArrayList.remove(i);
                        i--;
                    }
                }
            }


            ArrayList<String> YoN=new ArrayList<>();
            ArrayList<String> code=new ArrayList<>();
            for(int i=0;i<studentBaseDateArrayList.size();i++){
                String nu=studentBaseDateArrayList.get(i).getNum();
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
            session.setAttribute("studentList",studentBaseDateArrayList);
            response.sendRedirect(request.getContextPath()+"//SelectStudentAndTeacherHealth_admin3.jsp");


        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
}
