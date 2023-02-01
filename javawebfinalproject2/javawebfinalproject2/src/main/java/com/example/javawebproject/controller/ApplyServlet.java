package com.example.javawebproject.controller;

import com.example.javawebproject.dao.*;
import com.example.javawebproject.model.History;
import com.example.javawebproject.model.Person;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "ApplyServlet", value = "/ApplyServlet")
public class ApplyServlet extends HttpServlet {
    public String judgeColor(Person p){
        if(p.getQ1().equals("yes")||p.getQ2().equals("yes")||(p.getQ5().length==1&&!(p.getQ5()[0].equals("healthy")))){
            return "yellow";
        }
        else if(p.getQ3().equals("yes")||p.getQ4().equals("yes")||(p.getQ5().length>1&&!(p.getQ5()[0].equals("healthy")))){
            return "red";
        }
        else{
            return "green";
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String message = "";
        HttpSession session=request.getSession();
        Person formerperson= (Person) session.getAttribute("person");
        String name= formerperson.getName();
        String id=formerperson.getId();
        String num=formerperson.getNum();
        String phone=request.getParameter("phone");
        String type=formerperson.getType();
        String q1=request.getParameter("q1");
        String q2=request.getParameter("q2");
        String q3=request.getParameter("q3");
        String q4=request.getParameter("q4");
        String[] q5=request.getParameterValues("q5");
        Person person=new Person(name,id,num,phone,type,q1,q2,q3,q4,q5);
        PersonDao dao=new PersonDaoImpl();
        HistoryDao dao1=new HistoryDaoImpl();
        Date d=new Date(System.currentTimeMillis());
        Timestamp date=new Timestamp(d.getTime());

        try {
            person.setDays(dao.selectPerson(num).getDays());
            person.setCode(dao.selectPerson(num).getCode());
            person.setVaccines(dao.selectPerson(num).getVaccines());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        if(judgeColor(person).equals("green")){
            person.setDays((person.getDays())+1);
        }
        else{
            person.setDays(0);
        }
        if(person.getDays()>7){
            person.setDays(person.getDays()-7);
        }
        if(person.getVaccines().equals("yes")){
            String color="gold";
            person.setCode(color);
            synchronized (session){
                session.setAttribute("person",person);
                session.setAttribute("color",color);
            }
            try {
                boolean  success = dao.updatePerson(person);
                History history=new History(num,date,color);
                success=dao1.addHistory(history);
                if(success){
                    message = "<li>成功申请健康码！</li>";
                }else{
                    message = "<li>申请时发生错误！</li>";
                }
            } catch (DaoException e) {
                e.printStackTrace();
                message = "<li>申请时发生错误！</li>";
            }
        }
        else if(judgeColor(person).equals("green")&&person.getCode().equals("green")||(person.getDays()==7&&person.getCode().equals("yellow"))){
            String color="green";
            person.setCode(color);
            synchronized (session){
                session.setAttribute("person",person);
                session.setAttribute("color",color);
            }
            try {
                boolean  success = dao.updatePerson(person);
                History history=new History(num,date,color);
                success=dao1.addHistory(history);
                if(success){
                    message = "<li>成功申请健康码！</li>";
                }else{
                    message = "<li>申请时发生错误！</li>";
                }
            } catch (DaoException e) {
                e.printStackTrace();
                message = "<li>申请时发生错误！</li>";
            }
        }
        else if((judgeColor(person).equals("green")&&person.getCode().equals("yellow"))||(judgeColor(person).equals("yellow")&&(person.getCode().equals("yellow")||person.getCode().equals("green")))||(person.getCode().equals("red")&&person.getDays()==7)){
            String color="yellow";
            person.setCode(color);
            synchronized (session){
                session.setAttribute("person",person);
                session.setAttribute("color",color);
            }
            try {
                boolean  success = dao.updatePerson(person);
                History history=new History(num,date,color);
                success=dao1.addHistory(history);
                if(success){
                    message = "<li>成功申请健康码！</li>";
                }else{
                    message = "<li>申请时发生错误！</li>";
                }
            } catch (DaoException e) {
                e.printStackTrace();
                message = "<li>申请时发生错误！</li>";
            }
        }
        else{
            String color="red";
            person.setCode(color);
            synchronized (session){
                session.setAttribute("person",person);
                session.setAttribute("color",color);
            }
            try {
                boolean  success = dao.updatePerson(person);
                History history=new History(num,date,color);
                success=dao1.addHistory(history);
                if(success){
                    message = "<li>成功申请健康码！</li>";
                }else{
                    message = "<li>申请时发生错误！</li>";
                }
            } catch (DaoException e) {
                e.printStackTrace();
                message = "<li>申请时发生错误！</li>";
            }
        }
        RequestDispatcher rd=request.getRequestDispatcher("/code.jsp");
        rd.forward(request,response);
    }
}