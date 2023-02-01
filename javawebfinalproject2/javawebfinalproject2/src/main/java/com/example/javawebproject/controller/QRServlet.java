package com.example.javawebproject.controller;

import com.example.javawebproject.model.Person;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "QRServlet", value = "/qrServlet")
public class QRServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person  person = (Person) request.getSession().getAttribute("person");
        String c = person.getName() +"\r\n"+person.getId()+"\r\n"+person.getCode();
        BitMatrix bitMatrix = null;
        ServletOutputStream out = response.getOutputStream();
        try {
            Map<EncodeHintType, String> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            bitMatrix = new MultiFormatWriter().encode(c, BarcodeFormat.QR_CODE,256,256,hints);
            HttpSession session=request.getSession();
            String color= (String) session.getAttribute("color");
            MatrixToImageConfig config;
            if(color.equals("green")) {
                config = new MatrixToImageConfig(0xff3CB371, 0xffffffff);
            }
            else if(color.equals("yellow")) {
                config = new MatrixToImageConfig(0xffFFA500, 0xffffffff);
            }
            else if(color.equals("gold")){
                config = new MatrixToImageConfig(0xff0000FF, 0xffffffff);
            }
            else{
                config = new MatrixToImageConfig(0xffCD5C5C, 0xffffffff);
            }
            MatrixToImageWriter.writeToStream(bitMatrix,"png",out,config);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
