<%--
  Created by IntelliJ IDEA.
  User: Mans'tei'n
  Date: 2021/6/25
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@ page import="com.example.javawebproject.dao.HistoryDao" %>
<%@ page import="com.example.javawebproject.dao.HistoryDaoImpl" %>
<%@ page import="com.example.javawebproject.model.History" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" class="com.example.javawebproject.model.Person" scope="session"></jsp:useBean>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

  <title>绿码</title>
  <!--
  SOFTY PINKO
  https://templatemo.com/tm-535-softy-pinko
  -->

  <!-- Additional CSS Files -->
  <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

  <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

  <link rel="stylesheet" href="assets/css/templatemo-softy-pinko.css">

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
            <li><a href="code.jsp">我的健康码</a></li>
            <li><a href="#" class="active">打卡记录</a></li>
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
    <h1 class="h1 text-white">${person.type}</h1>
    <p class="text-white">
      ${person.name}
    </p>
    <p class="text-white">
      ${person.num}
    </p>
  </div>
</div>
<!-- End Login Page -->

<!-- Start Contact -->
<div class="container py-5 text-center col-9" id="contact-us">
  <table border="1" class="table table-striped table-hover">
    <tr><td>学号/工号</td><td>打卡时间</td><td>健康码</td></tr>
  <%HistoryDao dao=new HistoryDaoImpl();
    ArrayList<History> histories=dao.findHistory(person.getNum());
    for(History history:histories){
  %>
    <tr><td><%=history.getNum()%></td><td><%=history.getDate()%></td><td><%=history.getCode()%></td></tr>
    <%}%>
  </table>
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

