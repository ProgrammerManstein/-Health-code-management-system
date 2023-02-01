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

import java.io.IOException;

@WebServlet(name = "DeleteAdminServlet", value = "/DeleteAdminServlet")
public class DeleteAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao dao = new AdminDaoImpl();
        System.out.println(dao);
        admin admin = new admin();
        String message = "";
        try{

            dao.deleteAdmin(request.getParameter("num"));
        }catch(Exception e){
            System.out.println(e);
            message = "<li>删除记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectCustomer.jsp");
        rd.forward(request,response);
    }
}
