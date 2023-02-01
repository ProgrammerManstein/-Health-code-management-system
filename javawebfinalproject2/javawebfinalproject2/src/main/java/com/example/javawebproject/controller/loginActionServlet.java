package com.example.javawebproject.controller;

import com.example.javawebproject.dao.AdminDao;
import com.example.javawebproject.dao.AdminDaoImpl;
import com.example.javawebproject.dao.TeacherDao;
import com.example.javawebproject.dao.TeacherDaoImpl;
import com.example.javawebproject.model.admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "loginActionServlet", value = "/loginActionServlet")
public class loginActionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        response.setContentType("text/html;charset=utf-8");
        AdminDao dao = new AdminDaoImpl();
        response.setCharacterEncoding("utf-8");
        response.setHeader("content-type", "text/html;charset=utf-8");
        ArrayList<admin> adminlist=new ArrayList<admin>();
        String message = "";
        String password=null;
        try{

            String num1=(String)request.getParameter("num1");
            String num2=(String)request.getParameter("num2");
            String num3=(String)request.getParameter("num3");
            if(num1!=null){
                adminlist = dao.findByNum(request.getParameter("num1"));
                //用户名正确
                if(adminlist.size()!=0){
                    password=adminlist.get(0).getPassword();

                    if(!password.equals(request.getParameter("password"))||!adminlist.get(0).getPower().equals("1")){
                        response.sendRedirect(request.getContextPath()+"/login1.jsp?error=error");
                    }
                    else{
                        response.sendRedirect(request.getContextPath()+"/admin1.jsp");//、、、、、、、
                    }
                }
                //用户名错误
                else{
                    response.sendRedirect(request.getContextPath()+"/login1.jsp?error=error");
                }
            }
            if(num2!=null){
                adminlist = dao.findByNum(request.getParameter("num2"));
                //用户名正确
                if(adminlist.size()!=0){
                    password=adminlist.get(0).getPassword();
                    System.out.println("numDB:"+adminlist.get(0).getNum());
                    System.out.println("passwordDB:"+adminlist.get(0).getPassword());
                    System.out.println("powerDB:"+adminlist.get(0).getPower());
                    if(!password.equals(request.getParameter("password"))||!adminlist.get(0).getPower().equals("2")){
                        response.sendRedirect(request.getContextPath()+"/login2.jsp?error=error");
                    }
                    else{
                        response.sendRedirect(request.getContextPath()+"/admin2.jsp");//、、、、、、、
                    }
                }
                //用户名错误
                else{
                    response.sendRedirect(request.getContextPath()+"/login2.jsp?error=error");
                }
            }
            if(num3!=null){

                adminlist = dao.findByNum(request.getParameter("num3"));
                //用户名正确
                if(adminlist.size()!=0){
                    password=adminlist.get(0).getPassword();

                    if(!password.equals(request.getParameter("password"))||!adminlist.get(0).getPower().equals("3")){
                        response.sendRedirect(request.getContextPath()+"/login3.jsp?error=error");
                    }
                    else{
                        TeacherDao teacherDao=new TeacherDaoImpl();
                        request.getSession().setAttribute("AdminSchool",teacherDao.findByNum(adminlist.get(0).getNum()).get(0).getSchool());
                        response.sendRedirect(request.getContextPath()+"/admin3.jsp?power=3");//、、、、、、、
                    }
                }
                //用户名错误
                else{
                    response.sendRedirect(request.getContextPath()+"/login3.jsp?error=error");
                }
            }


        }catch(Exception e){
            System.out.println(e);
            message = "<li>查找记录错误！</li>" + e;
        }


    }
}
