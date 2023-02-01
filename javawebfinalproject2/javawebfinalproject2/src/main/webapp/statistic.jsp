<%@ page import="com.example.javawebproject.model.History" %>
<%@ page import="com.example.javawebproject.dao.HistoryDao" %>
<%@ page import="com.example.javawebproject.dao.HistoryDaoImpl" %>
<%@ page import="com.example.javawebproject.dao.PersonDao" %>
<%@ page import="com.example.javawebproject.dao.PersonDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: Mans'tei'n
  Date: 2021/6/26
  Time: 15:59
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

    <title>首页</title>
    <!--
    SOFTY PINKO
    https://templatemo.com/tm-535-softy-pinko
    -->

    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.css">

    <link rel="stylesheet" href="assets/css/templatemo-softy-pinko.css">

    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
</head>

<body>

<%
    PersonDao dao=new PersonDaoImpl();
    int green=dao.findGreen();
    int yellow=dao.findYellow();
    int red=dao.findRed();
    int gold=dao.findGold();
    int q1=dao.findQ1();
    int q2=dao.findQ2();
    int q3=dao.findQ3();
    int q4=dao.findQ4();
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
                        <li><a href="#welcome" class="active">主页</a></li>
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

<div class="container-fluid login-area bg-success py-5">
    <div class="col-md-6 m-auto text-center">
        <h1 class="h1 text-white">Statistic</h1>
        <p class="text-white">
            健康码统计图
        </p>
    </div>
</div>

<!-- ***** situation ***** -->
<section class="section padding-top-70 padding-bottom-0" id="features">
    <div class="container">
        <div class="row">
            <div class="col-lg-5 col-md-12 col-sm-12 align-self-center" data-scroll-reveal="enter left move 30px over 0.6s after 0.4s">
                <div id="bar" style="width: 600px;height:400px;"></div>
                <script type="text/javascript">
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('bar'));

                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '近14天问题人员人数'
                        },
                        tooltip: {},
                        legend: {
                            data:["去过重点疫区","去过国外","接触过新冠病人","确认为新冠"]
                        },
                        xAxis: {
                            data: ["去过重点疫区","去过国外","接触过新冠病人","确认为新冠"]
                        },
                        yAxis: {},
                        series: [{
                            name: '人数',
                            type: 'bar',
                            data: [{value:<%=q1%>,itemStyle:{color:"#008000"}},{value:<%=q2%>,itemStyle:{color:"#FFFF00"}},{value:<%=q3%>,itemStyle:{color:"#FF0000"}},{value:<%=q4%>,itemStyle:{color:"#FFD700"}}]
                        }]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                </script>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-6 col-md-12 col-sm-12 align-self-center mobile-top-fix">
                <div class="left-heading">
                    <h2 class="section-title">柱状统计图</h2>
                </div>
                <div class="left-text">
                    <p>去过重点疫区<%=q1%></p>
                    <p>去过国外<%=q2%></p>
                    <p>接触过新冠病人<%=q3%></p>
                    <p>确认为新冠<%=q4%></p>
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
                    <h2 class="section-title">饼图</h2>
                </div>
                <div class="left-text">
                    <p>绿码<%=green%></p>
                    <p>黄码<%=yellow%></p>
                    <p>红码<%=red%></p>
                    <p>金码<%=gold%></p>
                </div>
            </div>
            <div class="col-lg-1"></div>
            <div class="col-lg-5 col-md-12 col-sm-12 align-self-center mobile-bottom-fix-big" data-scroll-reveal="enter right move 30px over 0.6s after 0.4s">
                <div id="pie" style="width: 600px;height:400px;"></div>
                <script type="text/javascript">
                    // 基于准备好的dom，初始化echarts实例
                    var myChart = echarts.init(document.getElementById('pie'));

                    // 指定图表的配置项和数据
                    var option = {
                        title: {
                            text: '健康码类型统计'
                        },
                        series: [{
                            name: '人数',
                            type: 'pie',
                            roseType: 'angle',
                            data: [{name:"绿码",value:<%=green%>,itemStyle:{color:"#008000"}},{name:"黄码",value:<%=yellow%>,itemStyle:{color:"#FFFF00"}},{name:"红码",value:<%=red%>,itemStyle:{color:"#FF0000"}},{name:"金码",value:<%=gold%>,itemStyle:{color:"#FFD700"}}]
                        }]
                    };

                    // 使用刚指定的配置项和数据显示图表。
                    myChart.setOption(option);
                </script>
            </div>
        </div>
    </div>
</section>
<!-- ***** Features Big Item End ***** -->

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

