<%--
  Created by IntelliJ IDEA.
  User: Mans'tei'n
  Date: 2021/6/20
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

    <title>师生登录</title>
    <!--
    SOFTY PINKO
    https://templatemo.com/tm-535-softy-pinko
    -->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="assets/css/templatemo-softy-pinko.css">

    <script>
        function valid() {
            if(document.getElementById('id').value.length==8){
                return true;
            }
            else{
                alert("请输入身份证后八位")
                return false;
            }
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
                        <li><a href="#features">实时疫情</a></li>
                        <li><a href="#work-process">相关说明</a></li>
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
        <h1 class="h1 text-white">Login In</h1>
        <p class="text-white">
            请输入您的用户名和密码
        </p>
    </div>
</div>
<!-- End Login Page -->

<!-- Start Contact -->
<div class="text-center text-danger"><%if(request.getAttribute("message")!=null) {%><%=request.getAttribute("message")%><%}%></div>
<div class="container py-5" id="contact-us">
    <div class="row py-5">
        <form class="col-md-9 m-auto" method="post" onsubmit="return valid()" action="LoginPersonServlet" role="form">
            <div class="mb-3">
                <label for="name">姓&nbsp;&nbsp;&nbsp;&nbsp;名</label>
                <input type="text" class="form-control mt-1" id="name" name="name" placeholder="Name">
            </div>
            <div class="mb-3">
                <label for="num">学/工号</label>
                <input type="text" class="form-control mt-1" id="num" name="num" placeholder="Num">
            </div>
            <div class="mb-3">
                <label for="id">身份证（后8位）</label>
                <input type="text" class="form-control mt-1" id="id" name="id" placeholder="Id">
            </div>

            <div class="mb-3">
                <label>教&nbsp;&nbsp;&nbsp;&nbsp;师&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="radio" name="type" value="teacher" required>
                <label>&nbsp;&nbsp;&nbsp;&nbsp;学&nbsp;&nbsp;&nbsp;&nbsp;生&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="radio" name="type" value="student" required>
                <div class="col text-right mt-2">
                    <button type="submit" class="btn btn-success btn-lg px-3">登录</button>
                </div>
            </div>
        </form>
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
