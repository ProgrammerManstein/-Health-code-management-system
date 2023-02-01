package com.example.javawebproject.controller.admin;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.admin;
import com.example.javawebproject.model.teacherBaseDate;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "UpdateAdmin2Servlet", value = "/UpdateAdmin2Servlet")
public class UpdateAdmin2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("numOname");
        AdminDao adminDao=new AdminDaoImpl();
        TeacherDao teacherDao=new TeacherDaoImpl();
        admin admin=new admin();
        teacherBaseDate teacher=new teacherBaseDate();
        ArrayList<admin> adminArrayList=new ArrayList<admin>();
        ArrayList<teacherBaseDate> teacherBaseDateArrayList=new ArrayList<teacherBaseDate>();
        HttpSession session=request.getSession();
        try {
            teacherBaseDateArrayList=teacherDao.findByNum(num);//验证输入的是否为num
            if(teacherBaseDateArrayList.size()==0){//不是num
                teacherBaseDateArrayList=teacherDao.findByName(num);//验证输入的是否为name
                if(teacherBaseDateArrayList.size()==0){//通过name和num查询都找不到结果
                    //输出空结果
                    //提示找不到信息
                    response.sendRedirect(request.getContextPath()+"/updateAdmin2.jsp?error=error");
                    return;
                }
            }
//            System.out.println("teacherSize:"+teacherBaseDateArrayList.size());
            for(int i=0;i<teacherBaseDateArrayList.size();i++){
                if(teacherBaseDateArrayList.get(i).getRole().equals("1")){
                    teacherBaseDateArrayList.remove(i);
                    i--;
                    continue;
                }
                admin=null;
                admin=adminDao.findByNum_(teacherBaseDateArrayList.get(i).getNum());
                adminArrayList.add(admin);
            }

            session.setAttribute("adminList",adminArrayList);
            session.setAttribute("teacherList",teacherBaseDateArrayList);
            response.sendRedirect(request.getContextPath()+"/updateAdmin2.jsp");


        } catch (DaoException e) {
            e.printStackTrace();
        }

    }
}
