package com.example.javawebproject.controller.admin;

import com.example.javawebproject.dao.AdminDao;
import com.example.javawebproject.dao.AdminDaoImpl;
import com.example.javawebproject.model.admin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SelectAdminServlet", value = "/SelectAdminServlet")
public class SelectAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao dao = new AdminDaoImpl();
        System.out.println(dao);
        ArrayList<admin> adminlist=new ArrayList<admin>();
        String message = "";
        try{
            adminlist = dao.findByNum(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>查找记录错误！</li>" + e;
        }
        HttpSession session=request.getSession();
        session.setAttribute("adminlist", adminlist);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/displayAll.jsp");
        rd.forward(request,response);
    }
}
