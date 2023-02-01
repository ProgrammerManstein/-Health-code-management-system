<%--<jsp:useBean id="teacherList" scope="request" type=""/>--%>
<%@ page import="javax.swing.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.example.javawebproject.model.teacherBaseDate" %>
<%@ page import="com.example.javawebproject.model.admin" %>
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
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <link href="assets/css/font-awesome.css" rel="stylesheet" type="text/css">

    <link href="assets/css/templatemo-softy-pinko.css" rel="stylesheet" type="text/css">

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
<div class="welcome-area bg-success" id="welcome" style="height: 60vh">

    <!-- ***** Header Text Start ***** -->
    <div class="header-text">
        <div class="container">
            <div class="row">
                <div class="offset-xl-3 col-xl-6 offset-lg-2 col-lg-8 col-md-12 col-sm-12">
                    <h1>管理员账号管理</h1>
                    <h5>查看修改校级管理员与院级管理员信息</h5>

                </div>
            </div>
        </div>
    </div>
    <!-- ***** Header Text End ***** -->
</div>
<!-- ***** Welcome Area End ***** -->

<div class="container">
    <div class="row">
        <div class="col-12">
            <form class="form-horizontal form-inline col-12" id="tform" action="SelectAdmin23Servlet" method="post">

                <div class="form-group col-12">
                    <label for="nOna" class="col-3 control-label" style="justify-content: left">用户名或工号:</label>
                    <input class="form-control col-8" id="nOna" name="numOname" type="text" placeholder="请输入工号或姓名进行查询" value="${sessionScope.nu}">
                </div>
                <div class="form-group col-12 " >
                    <label for="nOna" class="col-3  control-label" title="学院" style="justify-content: left">学院</label>
                    <select class="selectpicker form-control combox col-8" id="selectBranchOffice" name="school">
                        <option value="全部">全部</option>
                        <option value="计算机学院">计算机学院</option>
                        <option value="信息学院">信息学院</option>
                        <option value="化学工程学院">化学工程学院</option>
                    </select>
                </div>
                <div class="form-group col-12 " >
                    <label for="role" class="col-3  control-label" title="角色" style="justify-content: left">角色</label>
                    <select class="selectpicker form-control combox col-8" id="role" name="role">
                        <option value="全部">全部</option>
                        <option value="计算机学院">校级管理员</option>
                        <option value="信息学院">院级管理员</option>
                    </select>
                </div>
                <input type="submit" class="col-2 offset-9" value="点击查询">
<%--                <input class="btn btn-default" type="submit" value="Submit">--%>
<%--                <a href="javascript:void(0);" onclick="document.getElementById('tform').submit()" class="main-button-slider col-2 offset-9 ">点击查询</a>--%>
                <%--                        <a href="#features" class="">Discover More</a>--%>
<%--                <button type="button" class="btn btn-primary btn-lg active">Primary button</button>--%>
            </form>
            <p style="color: red;float: left; margin-top: -35px">
                <%
                    String error=request.getParameter("error");
                    if(error!=null)
                        if(error.equals("error")){
                %>
                <%="您输入的工号或姓名不存在"%>
                <%
                        }
                %>
            </p>

        </div>
    </div>
</div>


<!-- ***** situation ***** -->
<section class="section padding-top-70 padding-bottom-0" id="features">
    <div class="container">

        <div class="row col-12">
            <form action="UpdateAdmin23Servlet" method="post" class="col-12">
                <div class="table-responsive col-12">

                    <table class="table table-condensed table-hover col-12">
                        <!-- On rows -->
                        <tr class="active col-12">
                            <td class="active">姓名</td>
                            <td class="active">身份证号</td>
                            <td class="active">工号</td>
                            <td class="active">学院</td>
                            <td class="active">角色</td>
                            <td class="active">手机号码</td>
                            <td class="active">密码</td>
                        </tr>
                        <%
                            ArrayList<teacherBaseDate> teacherList=(ArrayList<teacherBaseDate>)request.getSession().getAttribute("teacherList");
                            ArrayList<admin> adminList=(ArrayList<admin>)request.getSession().getAttribute("adminList");
                            int i=0;
                        %>

                        <%
                            if(teacherList!=null&&teacherList.size()>0&&adminList!=null&&adminList.size()>0)
                                for(teacherBaseDate te:teacherList){
                                    i++;

                                    String nA=te.getName();
                                    String iD=te.getId();
                                    String nU=te.getNum();
                                    String cS=te.getSchool();
                                    String rO=te.getRole();
                                    String pH=te.getPhone();

                                    String pA=null;
                                    request.setAttribute("nA",nA);
                                    request.setAttribute("iD",iD);
                                    request.setAttribute("nU",nU);
                                    request.setAttribute("cS",cS);
                                    request.setAttribute("rO",rO);
                                    request.setAttribute("pH",pH);
                                    request.setAttribute("i",i);
                                    for(admin ad:adminList){
                                        if(ad!=null)
                                        if(ad.getNum().equals(nU)){
                                            pA=ad.getPassword();
                                            break;
                                        }
                                    }
                                    request.setAttribute("pA",pA);
                        %>
                        <tr class="active">
                            <td class="active "><input class="form-control input-group-sm" type="text" name="nA${i}" value="${nA}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="iD${i}" value="${iD}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="nU${i}" value="${nU}"></td>
                            <td class="active ">
                                <select name="cS${i}" id="">
                                    <option value="${cS}">${cS}</option>
                                    <option value="计算机学院">计算机学院</option>
                                    <option value="信息学院">信息学院</option>
                                    <option value="化学工程学院">化学工程学院</option>
                                </select>
                            </td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="rO${i}" value="${rO}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="pH${i}" value="${pH}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="pA${i}" value="${pA}"></td>
                        </tr>
                        <%

                                }
                        %>

                    </table>
                    


                </div>
                <input type="submit" class="col-2 offset-9" value="保存修改">
            </form>
            <p style="color: red;float: left; margin-top: -35px">
                <%
                    String success=request.getParameter("success");
                    if(success!=null)
                        if(success.equals("success")){
                %>
                <%="保存成功"%>
                <%
                        }
                %>
            </p>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="hr"></div>
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