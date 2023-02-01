<%@ page import="javax.swing.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@include file="javax.util.*"%>--%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

    <title>Softy Pinko - Bootstrap 4.0 Theme</title>
    <!--
    SOFTY PINKO
    https://templatemo.com/tm-535-softy-pinko
    -->

    <!-- Additional CSS Files -->
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <link href="css/font-awesome.css" rel="stylesheet" type="text/css">

    <link href="css/templatemo-softy-pinko.css" rel="stylesheet" type="text/css">

</head>

<body>
<%
    HttpSession Session=request.getSession();
    Session.setAttribute("key","value");
%>
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
                        <li><a href="#welcome" class="active">Home</a></li>
                        <li><a href="#features">About</a></li>
                        <li><a href="#work-process">Work Process</a></li>
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

<!-- ***** Welcome Area Start ***** -->
<div class="welcome-area bg-success" id="welcome">

    <!-- ***** Header Text Start ***** -->
    <div class="header-text">
        <div class="container">
            <div class="row">
                <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                    <h1>师生基本信息管理</h1>
<%--                    <form class="form-horizontal" id="tform" action="UpdateAdmin2Servlet" method="post">--%>
<%--                        <div class="form-group row">--%>

<%--                            <input class="form-control" name="numOname" type="text" placeholder="请输入工号或姓名进行查询">--%>
<%--                        </div>--%>
<%--                        <a href="javascript:void(0);" onclick="document.getElementById('tform').submit()" class="main-button-slider">点击查询</a>--%>
<%--                        &lt;%&ndash;                        <a href="#features" class="">Discover More</a>&ndash;%&gt;--%>

<%--                    </form>--%>
                    <form class="form-horizontal" id="tform" action="UpdateAdmin3Servlet" method="post">
                        <div class="form-group row">
                            <input class="form-control col-5" name="num" type="text" placeholder="请输入工号进行查询">
                            <div class="col-2"></div>
                            <input class="form-control col-5" name="name" type="text" placeholder="请输入姓名进行查询">
                        </div>
<%--                        <a href="javascript:void(0);" onclick="document.getElementById('tform').submit()" class="main-button-slider">点击查询</a>--%>
                        <%--                        <a href="#features" class="">Discover More</a>--%>
                        <span style="font-size:16px;">分公司：</span>
                        <select class="selectpicker form-control combox col-12" id="selectBranchOffice" name="school">
                            <option value="全部">全部</option>
                            <option value="计算机学院">计算机学院</option>
                            <option value="信息学院">信息学院</option>
                            <option value="化学工程学院">化学工程学院</option>
                        </select>

                        <span style="font-size:16px;">车队：</span>
                        <select class="selectpicker form-control combox" id="selectFleet"></select>
                    </form>

<%--                    <p style="color: red;float: left; margin-top: -35px">--%>
<%--                        <%--%>
<%--                            String error=request.getParameter("error");--%>
<%--                            if(error!=null)--%>
<%--                                if(error.equals("error")){--%>
<%--                        %>--%>
<%--                        <%="您输入的工号或姓名不存在"%>--%>
<%--                        <%--%>
<%--                                }--%>
<%--                        %>--%>
<%--                    </p>--%>


                </div>
            </div>
        </div>
    </div>
    <!-- ***** Header Text End ***** -->
</div>

<!-- ***** Features Small End ***** -->

<!-- ***** situation ***** -->
<section class="section padding-top-70 padding-bottom-0" id="features">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-md-12 col-sm-12 align-self-center" data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
                <img src="images/china.jpg" class="rounded img-fluid d-block mx-auto" alt="App">
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-top-fix">
                <div class="left-heading">
                    <h2 class="section-title">Let’s discuss about you project</h2>
                </div>
                <div class="left-text">
                    <p>Nullam sit amet purus libero. Etiam ullamcorper nisl ut augue blandit, at finibus leo efficitur. Nam gravida purus non sapien auctor, ut aliquam magna ullamcorper.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="hr"></div>
            </div>
        </div>
    </div>
</section>
<!-- ***** Features Big Item End ***** -->

<!-- ***** Features Big Item Start ***** -->
<section class="section padding-bottom-100">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-bottom-fix">
                <div class="left-heading">
                    <h2 class="section-title">We can help you to grow your business</h2>
                </div>
                <div class="left-text">
                    <p>Aenean pretium, ipsum et porttitor auctor, metus ipsum iaculis nisi, a bibendum lectus libero vitae urna. Sed id leo eu dolor luctus congue sed eget ipsum. Nunc nec luctus libero. Etiam quis dolor elit.</p>
                </div>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-5 col-md-12 col-sm-12 align-self-center mobile-bottom-fix-big" data-scroll-reveal="enter right move 30px over 0.6s after 0.4s">
                <img src="images/world.jpg" class="rounded img-fluid d-block mx-auto" alt="App">
            </div>
        </div>
    </div>
</section>
<!-- ***** Features Big Item End ***** -->

<!-- ***** Home Parallax Start ***** -->
<section class="mini bg-success" id="work-process">
    <div class="mini-content">
        <div class="container">
            <div class="row">
                <div class="offset-lg-3 col-lg-6">
                    <div class="info">
                        <h1>Work Process</h1>
                        <p>Aenean nec tempor metus. Maecenas ligula dolor, commodo in imperdiet interdum, vehicula ut ex. Donec ante diam.</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
</section>
<!-- ***** Home Parallax End ***** -->
<!-- ***** Footer Start ***** -->
<footer class="bg-dark">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <p class="copyright"> &copy; 2020 Softy Pinko Company - Design: TemplateMo</p>
            </div>
        </div>
    </div>
</footer>

<!-- jQuery -->
<script src="js/jquery-2.1.0.min.js"></script>

<!-- Bootstrap -->
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>

<!-- Plugins -->
<script src="js/scrollreveal.min.js"></script>
<script src="js/waypoints.min.js"></script>
<script src="js/jquery.counterup.min.js"></script>
<script src="js/imgfix.min.js"></script>

<!-- Global Init -->
<script src="js/custom.js"></script>

</body>
</html>