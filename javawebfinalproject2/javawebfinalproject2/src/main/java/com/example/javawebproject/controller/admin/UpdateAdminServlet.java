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

@WebServlet(name = "UpdateAdminServlet", value = "/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
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
            // 将传递来的字符串重新使用utf-8编码，以免产生乱码

            admin.setNum(new String(request.getParameter("num")
                    .getBytes("iso-8859-1"),"UTF-8"));

            admin.setPassword(new String(request.getParameter("password")
                    .getBytes("iso-8859-1"),"UTF-8"));

            admin.setPower(new String(request.getParameter("power")
                    .getBytes("iso-8859-1"),"UTF-8"));
            boolean success = dao.addAdmin(admin);
        }catch(Exception e){
            System.out.println(e);
            message = "<li>更新记录错误！</li>" + e;
        }
        request.setAttribute("result", message);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/selectAdmin.jsp");
        rd.forward(request,response);
    }
}
