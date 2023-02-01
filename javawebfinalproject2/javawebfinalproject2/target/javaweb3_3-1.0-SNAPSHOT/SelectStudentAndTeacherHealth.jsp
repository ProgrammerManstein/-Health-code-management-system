<%--<jsp:useBean id="teacherList" scope="request" type=""/>--%>
<%@ page import="javax.swing.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="com.example.javawebproject.model.teacherBaseDate" %>
<%@ page import="com.example.javawebproject.model.admin" %>
<%@ page import="com.example.javawebproject.model.studentBaseDate" %>
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
                    <h1>师生信息管理</h1>
                    <h5>查询学生健康码情况</h5>

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
            <form class="form-horizontal form-inline col-12" id="tform" action="SelectStudentHealthServlet" method="post">

                <div class="form-group col-12">
                    <label for="nOna" class="col-3 control-label" style="justify-content: left">姓名或编号:</label>
                    <input class="form-control col-8" id="nOna" name="numOname" type="text" placeholder="请输入姓名或编号进行查询" value="${sessionScope.nu}">
                </div>
                <div class="form-group col-12 " >
                    <label class="col-3  control-label" title="角色" style="justify-content: left">身份</label>

                    <div>
                        <button><span><a href="SelectStudentAndTeacherHealth.jsp">学生</a></span></button>
                        <button><span><a href="SelectTeacherAndStudentHealth.jsp">老师</a></span></button>

                    </div>
                </div>

<%--                8888888888888888888888888888888888--%>
                <script>
                    function loadMajor(){
                        var pid=document.getElementById("school").value;
                        let s = '';
                        for(let [key] of Object.entries(menu[pid])) {
                            s += "<option value=" + key + ">" + key + "</option>"
                        }
                        document.getElementById('major').innerHTML = s;
                    }

                    function loadClass(){
                        var sc=document.getElementById("school").value;
                        var mj=document.getElementById("major").value;
                        let s = '';
                        menu[sc][mj].forEach(key => {
                            s += "<option value=" + key + ">" + key + "</option>"
                        });
                        document.getElementById('Class').innerHTML = s;
                    }
                    var menu = {
                        全部:{
                            全部:['全部'],
                        },
                        计算机学院: {
                            全部:['全部'],
                            计实: ['全部','1班'],
                            计智: ['全部','1班'],
                            软件工程: ['全部','1班', '2班', '3班', '4班', '5班'],
                            数字媒体: ['全部','1班', '2班', '3班', '4班', '5班'],
                            网络工程: ['全部','1班', '2班', '3班', '4班', '5班'],
                            计算机科学与技术: ['全部','1班', '2班', '3班', '4班', '5班'],
                        },
                        信息学院: {
                            全部:['全部'],
                            通信工程: ['全部','1班', '2班', '3班', '4班', '5班'],
                            自动化系: ['全部','1班', '2班', '3班', '4班', '5班'],
                            电子信息工程系: ['全部','1班', '2班', '3班', '4班', '5班'],
                        },
                        化学工程学院: {
                            全部:['全部'],
                            应用化学: ['全部','1班', '2班', '3班', '4班', '5班'],
                            安全工程: ['全部','1班', '2班', '3班', '4班', '5班'],
                            化工工程与工艺: ['全部','1班', '2班', '3班', '4班', '5班'],
                            能源化学工程: ['全部','1班', '2班', '3班', '4班', '5班'],
                        },
                    }
                </script>
<%--                8888888888888888888888888888888888--%>
                <div class="form-group col-12 " >
                    <label for="school" class="col-3  control-label" title="学院" style="justify-content: left">学院</label>

                    <select name="school" id="school" class="selectpicker form-control combox col-8" onchange="loadMajor();">
                        <option value="全部">全部</option>
                        <option value="计算机学院">计算机学院</option>
                        <option value="信息学院">信息学院</option>
                        <option value="化学工程学院">化学工程学院</option>
                    </select>
                </div>
                <div class="form-group col-12 " >
                    <label for="nOna" class="col-3  control-label" title="专业" style="justify-content: left">专业</label>
                    <select class="selectpicker form-control combox col-8" name="major" id="major"  onchange="loadClass();">

                    </select>
                </div>
                <div class="form-group col-12 " >
                    <label for="nOna" class="col-3  control-label" title="班级" style="justify-content: left">班级</label>
                    <select class="selectpicker form-control combox col-8" name="Class" id="Class">

                    </select>
                </div>
                <input type="submit" class="col-2 offset-9" value="点击查询">
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
            <%
//                ArrayList<teacherBaseDate> teacherList=(ArrayList<teacherBaseDate>)request.getSession().getAttribute("teacherList");
                ArrayList<studentBaseDate> studentList=(ArrayList<studentBaseDate>) request.getSession().getAttribute("studentList");
                ArrayList<String> YoN=(ArrayList<String>)request.getSession().getAttribute("YoN");
                ArrayList<String> code=(ArrayList<String>)request.getSession().getAttribute("code");
                int i=0;
            %>
            <form action="SelectStudentHealthServlet" method="post">
                <table>
                    <%--                        学生--%>
                    <tr class="active col-12">
                        <td class="active">姓名</td>
                        <td class="active">学号</td>
                        <td class="active">学院</td>
                        <td class="active">专业</td>
                        <td class="active">班级</td>
                        <td class="active">今日是否打卡</td>
                        <td class="active">健康码颜色</td>
                    </tr>
                    <%
                        if(YoN!=null)
                        if(studentList!=null&&studentList.size()>0){
                            i=0;
                            for(studentBaseDate stu:studentList){

                                String nA=stu.getName();
                                String nU=stu.getNum();
                                String cS=stu.getSchool();
                                String mJ=stu.getMajor();
                                String cL=stu.get_Class();
                                String yOn=YoN.get(i);
                                String cO=code.get(i);
                                request.setAttribute("nA",nA);
                                request.setAttribute("nU",nU);
                                request.setAttribute("cS",cS);
                                request.setAttribute("mJ",mJ);
                                request.setAttribute("cL",cL);
                                request.setAttribute("yOn",yOn);
                                request.setAttribute("cO",cO);
                                request.setAttribute("i",i);
                    %>
                    <tr class="active">
                        <td class="active ">${nA}</td>
                        <td class="active ">${nU}</td>
                        <td class="active ">${cS}</td>
                        <td class="active ">${mJ}</td>
                        <td class="active ">${cL}</td>
                        <td class="active ">${yOn}</td>
                        <td class="active ">${cO}</td>
                    </tr>


                    <%
                            i++;
                        }
                    %>
                        <%

                            }
                        %>
                </table>
            </form>
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