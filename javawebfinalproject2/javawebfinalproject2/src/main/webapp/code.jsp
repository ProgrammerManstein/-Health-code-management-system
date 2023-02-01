<%--
  Created by IntelliJ IDEA.
  User: Mans'tei'n
  Date: 2021/5/19
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="code.css">
<jsp:useBean id="person" class="com.example.javawebproject.model.Person" scope="session"></jsp:useBean>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

    <title>您的健康码</title>
    <!--
    SOFTY PINKO
    https://templatemo.com/tm-535-softy-pinko
    -->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="assets/css/templatemo-softy-pinko.css">

    <script>
        window.onload=function () {
            let oDt = new Date();
            let iMonth=parseInt(oDt.getMonth())+1;
            document.getElementById("date").innerHTML="<span>"+iMonth+"月"+oDt.getDate()+"日"+"</span>";
            setInterval(()=>{showtime()},1000);
        }
        function showtime(){
            let oDt=new Date();
            let sTime="";
            if(oDt.getHours()<10){
                sTime+="0"+oDt.getHours()+"：";
            }
            else{
                sTime+=oDt.getHours()+"：";
            }
            if(oDt.getMinutes()<10){
                sTime+="0"+oDt.getMinutes()+"：";
            }
            else{
                sTime+=oDt.getMinutes()+"：";
            }
            if(oDt.getSeconds()<10){
                sTime+="0"+oDt.getSeconds();
            }
            else{
                sTime+=oDt.getSeconds();
            }
            document.getElementById("time").innerHTML="<span>"+sTime+"</span>";
        }
    </script>
</head>

<body>

<!-- ***** Preloader Start ***** -->
<div id="preloader">
    <div class="jumper">
        <div></div>
        <div></div>
        <div></div>
    </div>
</div>
<!-- ***** Preloader End ***** -->


<!-- ***** Header Area Start ***** -->
<header class="header-area header-sticky">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <nav class="main-nav">
                    <!-- ***** Logo Start ***** -->
                    <a href="#" class="logo row">
                        <i class="fa fa-heartbeat mr-3 fa-3x text-black-50" aria-hidden="true"></i>
                        <h2 class="text-black-50">健康码管理系统</h2>
                    </a>
                    <!-- ***** Logo End ***** -->
                    <!-- ***** Menu Start ***** -->
                    <ul class="nav">
                        <li><a href="index.jsp">主页</a></li>
                        <li><a href="#contact-us" class="active">我的健康码</a></li>
                        <li><a href="personal.jsp">打卡记录</a></li>
                    </ul>
                    <a class='menu-trigger'>
                        <span>Menu</span>
                    </a>
                    <!-- ***** Menu End ***** -->
                </nav>
            </div>
        </div>
    </div>
</header>
<!-- ***** Header Area End ***** -->

<!-- Start Login Page -->
<div class="container-fluid login-area bg-success py-5">
    <div class="col-md-6 m-auto text-center">
        <h1 class="h1 text-white">Health Code</h1>
        <p class="text-white">
            您的健康码
        </p>
    </div>
</div>
<!-- End Login Page -->

<!-- Start Contact -->
<div class="container py-5 text-center col-4" id="contact-us">
        <div id="date">
        </div>
        <div id="time">
        </div>
        <div id="info">
            <jsp:getProperty name="person" property="name"/>
            <jsp:getProperty name="person" property="num"/>
        </div>
        <div id="code">
                <%if(person.getCode().equals("gold")){%>
            <img src="qrServlet" class="border-warning border" alt="">
                <%} else {%>
            <img src="qrServlet" alt="">
                <%}%>
        </div>
        <div id="annotation">
            <%if(person.getCode().equals("green")){%>绿<%}%>
            <%if(person.getCode().equals("yellow")){%>黄<%}%>
            <%if(person.getCode().equals("red")){%>红<%}%>
            <%if(person.getCode().equals("gold")){%>金<%}%>
            码：凭此码可在浙江省范围内通行，请主动出示，配合检查；并做好自身防护工作，码色将根据您的申报由当地政府按照相关政策动态更新，出行前请仔细检查您的健康码
        </div>
</div>
<!-- End Contact -->

<!-- ***** Footer Start ***** -->
<footer class="bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p class="copyright">Copyright &copy; 2021 Zhejiang University Of Technology - Design: lv rui,wang tao</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="assets/js/jquery-2.1.0.min.js"></script>

<!-- Bootstrap -->
<script src="assets/js/popper.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- Plugins -->
<script src="assets/js/scrollreveal.min.js"></script>
<script src="assets/js/waypoints.min.js"></script>
<script src="assets/js/jquery.counterup.min.js"></script>
<script src="assets/js/imgfix.min.js"></script>

<!-- Global Init -->
<script src="assets/js/custom.js"></script>

</body>
</html>
