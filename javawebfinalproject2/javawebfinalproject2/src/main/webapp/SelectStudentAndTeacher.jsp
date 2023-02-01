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
    <script src="assets/js/xlsx.full.min.js"></script>
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
                    <h5>查看修改普通老师与学生信息</h5>

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
            <form class="form-horizontal form-inline col-12" id="tform" action="SelectStudentAndTeacherServlet" method="post">

                <div class="form-group col-12">
                    <label for="nOna" class="col-3 control-label" style="justify-content: left">姓名或编号:</label>
                    <input class="form-control col-8" id="nOna" name="numOname" type="text" placeholder="请输入姓名或编号进行查询" value="${sessionScope.nu}">
                </div>
                <div class="form-group col-12 " >
                    <label for="role" class="col-3  control-label" title="角色" style="justify-content: left">身份</label>
                    <select class="selectpicker form-control combox col-8" id="role" name="role">
                        <option value="全部">全部</option>
                        <option value="老师">老师</option>
                        <option value="学生">学生</option>
                    </select>
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

                <div class="form-group col-12 row">
                    <label class="bg-success" for="loadteacher">导入教师信息</label><input type="file" id="loadteacher" value="导入教师信息" onchange="function loadxlsx(e) {
                    if(e.files==null) {return;}

                    var f = e.files[0];
                    var reader = new FileReader();
                    reader.onload = async function(x) {
                    var data = new Uint8Array(x.target.result);
                    var workbook = XLSX.read(data, {type: 'array'});
                    var datajson = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]]);
                    let res = await fetch('LoadTeacherServlet', {
                        method: 'post',
                        body: JSON.stringify(datajson)
                    })
                    if(res.ok) {
                        alert('ok');
                    }
    /* DO SOMETHING WITH workbook HERE */
  };
  reader.readAsArrayBuffer(f);
                }
                loadxlsx(this)">
                    <label class="bg-success" for="loadstudent">导入学生信息</label><input type="file" value="导入学生信息" id="loadstudent" onchange="function loadxlsx(e) {
                    if(e.files==null) {return;}

                    var f = e.files[0];
                    var reader = new FileReader();
                    reader.onload = async function(x) {
                    var data = new Uint8Array(x.target.result);
                    var workbook = XLSX.read(data, {type: 'array'});
                    var datajson = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]]);
                    let res = await fetch('LoadStudentServlet', {
                        method: 'post',
                        body: JSON.stringify(datajson)
                    })
                    if(res.ok) {
                        alert('ok');
                    }
    /* DO SOMETHING WITH workbook HERE */
  };
  reader.readAsArrayBuffer(f);
                }
                loadxlsx(this)">
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
            <form action="UpdateTeacherBaseServlet" method="post" class="col-12">
                <div class="table-responsive col-12">

                    <table class="table table-condensed table-hover col-12">
                        <!-- On rows -->
                        <%--                        老师--%>
                            <%
                            ArrayList<teacherBaseDate> teacherList=(ArrayList<teacherBaseDate>)request.getSession().getAttribute("teacherList");
                            ArrayList<studentBaseDate> studentList=(ArrayList<studentBaseDate>) request.getSession().getAttribute("studentList");
                            String tea=(String) request.getSession().getAttribute("teacher");
                            String stu=(String) request.getSession().getAttribute("student");
                            int i=0;
                            if(tea!=null)
                            if(tea.equals("teacher")){

                        %>
                        <tr class="active col-12">
                            <td class="active">身份</td>
                            <td class="active">姓名</td>
                            <td class="active">工号</td>
                            <td class="active">学院</td>
                            <td class="active">手机号码</td>
                        </tr>
                            <%
                            }
                        %>
                            <%
                            if(teacherList!=null&&teacherList.size()>0){
                                i=0;
                                for(teacherBaseDate te:teacherList){
                                    i++;
                                    String nA=te.getName();
                                    String iD=te.getId();
                                    String nU=te.getNum();
                                    String cS=te.getSchool();
                                    String rO="老师";
                                    String rO_=te.getRole();
                                    String pH=te.getPhone();

                                    String pA=null;
                                    request.setAttribute("nA",nA);
//                                    request.setAttribute("rO_",rO_);
                                    request.setAttribute("nU",nU);
                                    request.setAttribute("cS",cS);
                                    request.setAttribute("rO",rO);
                                    request.setAttribute("pH",pH);
                                    request.setAttribute("i",i);
                        %>
                        <tr class="active">
                            <td class="active "><input class="form-control input-group-sm" type="text" name="rO${i}" value="${rO}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="nA${i}" value="${nA}"></td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="nU${i}" value="${nU}"></td>
                            <td class="active ">
                                <select name="cS${i}" id="">
                                    <option value="${cS}">${cS}</option>
                                    <option value="计算机学院">计算机学院</option>
                                    <option value="信息学院">信息学院</option>
                                    <option value="化学工程学院">化学工程学院</option>
                                </select>
                            </td>
                            <td class="active "><input class="form-control input-group-sm" type="text" name="pH${i}" value="${pH}"></td>
                        </tr>
                            <%

                                }
                        %>
                        <input type="submit" class="col-2 offset-9" value="保存修改">
                        <p style="color: red;float: left; margin-top: -35px">
                            <%
                                String success=request.getParameter("successTeacher");
                                if(success!=null)
                                    if(success.equals("successTeacher")){
                            %>
                            <%="保存成功"%>
                            <%
                                    }
                            %>
                        </p>
                            <%
                            }
                        %>

            </form>
            </table>
            <form action="UpdateStudentBaseServlet" method="post">

                <table>
                    <%--                        学生--%>
                    <%
                        if(stu!=null)
                            if(stu.equals("student")){
                    %>
                    <tr class="active col-12">
                        <td class="active">身份</td>
                        <td class="active">姓名</td>
                        <td class="active">学号</td>
                        <td class="active">学院</td>
                        <td class="active">专业</td>
                        <td class="active">班级</td>
                        <td class="active">手机号码</td>
                    </tr>
                    <%
                            }
                    %>
                    <%
                        if(studentList!=null&&studentList.size()>0){
                            i=0;
                            for(studentBaseDate te:studentList){
                                i++;
                                String nA=te.getName();
                                String nU=te.getNum();
                                String cS=te.getSchool();
                                String rO="学生";
                                String mJ=te.getMajor();
                                String cL=te.get_Class();
                                String pH=te.getPhone();

                                request.setAttribute("nA",nA);
                                request.setAttribute("nU",nU);
                                request.setAttribute("cS",cS);
                                request.setAttribute("rO",rO);
                                request.setAttribute("pH",pH);
                                request.setAttribute("mJ",mJ);
                                request.setAttribute("cL",cL);
                                request.setAttribute("i",i);
                    %>
                    <tr class="active">
                        <td class="active "><input class="form-control input-group-sm" type="text" name="rO${i}" value="${rO}"></td>
                        <td class="active "><input class="form-control input-group-sm" type="text" name="nA${i}" value="${nA}"></td>
                        <td class="active "><input class="form-control input-group-sm" type="text" name="nU${i}" value="${nU}"></td>
                        <%--                            <td class="active "><input class="form-control input-group-sm" type="text" name="cS${i}" value="${cS}"></td>--%>
                        <%--                            <td class="active "><input class="form-control input-group-sm" type="text" name="mJ${i}" value="${mJ}"></td>--%>
                        <%--                            <td class="active "><input class="form-control input-group-sm" type="text" name="cL${i}" value="${cL}"></td>--%>
                        <td class="active ">
                            <select name="cS${i}" id="school" class="selectpicker form-control combox col-8" onchange="loadMajor();">
                                <option>${cS}</option>
                                <option value="计算机学院">计算机学院</option>
                                <option value="信息学院">信息学院</option>
                                <option value="化学工程学院">化学工程学院</option>
                            </select>
                        </td>
                        <td class="active ">
                            <select class="selectpicker form-control combox col-8" name="mJ${i}" id="major"  onchange="loadClass();">
                                <option>${mJ}</option>
                            </select>
                        </td>
                        <td class="active ">
                            <select class="selectpicker form-control combox col-8" name="cL${i}" id="Class">
                                <option>${cL}</option>
                            </select>
                        </td>
                        <td class="active ">
                        <td class="active "><input class="form-control input-group-sm" type="text" name="pH${i}" value="${pH}"></td>


                            <%

                                }
                        %>
                        <input type="submit" class="col-2 offset-9" value="保存修改">
                        <p style="color: red;float: left; margin-top: -35px">
                            <%
                                String success=request.getParameter("successStudent");
                                if(success!=null)
                                    if(success.equals("successStudent")){
                            %>
                            <%="保存成功"%>
                            <%
                                    }
                            %>
                        </p>
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