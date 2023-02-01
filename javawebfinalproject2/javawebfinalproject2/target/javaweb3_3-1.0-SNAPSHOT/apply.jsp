<%--
  Created by IntelliJ IDEA.
  User: Mans'tei'n
  Date: 2021/6/20
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="person" scope="session" type="com.example.javawebproject.model.Person"></jsp:useBean>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,300,400,500,700,900" rel="stylesheet">

    <title>健康码申请</title>
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
            let i = 0;
            document.getElementsByName('q5').forEach(n => {
                if (n.checked == true) {
                    i++;
                }
            });
            if (i === 0) {
                alert('请勾选健康状况');
                document.getElementById('q5').focus();
                return false;
            }
            if(i>1&&document.getElementById('q50').checked==true)
            {
                alert('无异常不能与其他健康情况同时选中');
                return false;
            }
            return true;
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
        <h1 class="h1 text-white">申请健康码</h1>
        <p class="text-white">
            请按要求填写申报表
        </p>
    </div>
</div>
<!-- End Login Page -->

<!-- Start Contact -->
<div class="container py-5 col-lg-5">
    <form action="ApplyServlet" method="post" onsubmit="return valid()" class="text-left mb-3">
        <div class="question" id="i1">
            <div>姓名</div>
            <div class="txt">
                <jsp:getProperty name="person" property="name"/>
            </div>
        </div>
        <div class="question" id="i2">
            <div>身份证号</div>
            <div class="txt">
                <jsp:getProperty name="person" property="id"/>
            </div>
        </div>
        <div class="question" id="i3">
            <div>工号或学号</div>
            <div class="txt">
                <jsp:getProperty name="person" property="num"/>
            </div>
        </div>
        <div class="question" id="i4">
            <div>手机号</div>
            <div class="txt">
                <input type="text" name="phone" class="form-control mt-1" id="i4n">
            </div>
        </div>
        <div class="question" id="q1">
            <div>本人近期（14天内）是否去过重点疫区？<span class="single"></span></div>
            <div class="bg-light">
                <input type="radio" name="q1" id="q1n" value="no" required>
                <label for="q1n">否</label>
            </div>
            <div class="bg-light">
                <input type="radio" name="q1" id="q1y" value="yes" required>
                <label for="q1y">是</label>
            </div>
        </div>
        <div class="question" id="q2">
            <div>本人近期（14天内）是否去过国外<span class="single"></span></div>
            <div class="bg-light">
                <input type="radio" name="q2" id="q2n" value="no" required>
                <label for="q2n">否</label>
            </div>
            <div class="bg-light">
                <input type="radio" name="q2" id="q2y" value="yes" required>
                <label for="q2y">是</label>
            </div>
        </div>
        <div class="question" id="q3">
            <div>本人近期（14天内）是否接触过新冠确诊病人或疑似病人？<span class="single"></span></div>
            <div class="bg-light">
                <input type="radio" name="q3" id="q3n" value="no" required>
                <label for="q3n">否</label>
            </div>
            <div class="bg-light">
                <input type="radio" name="q3" id="q3y" value="yes" required>
                <label for="q3y">是</label>
            </div>
        </div>
        <div class="question" id="q4">
            <div>本人是否被卫生部门确认为新冠肺炎确诊病例或疑似病例？<span class="single"></span></div>
            <div class="bg-light">
                <input type="radio" name="q4" id="q4n" value="no" required>
                <label for="q4n">否</label>
            </div>
            <div class="bg-light">
                <input type="radio" name="q4" id="q4y" value="yes" required>
                <label for="q4y">是</label>
            </div>
        </div>

        <div class="question" id="q5">
            <div>当前健康状况（若有以下状况，请在方框内勾选）<span class="multi"></span></div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q50" value="healthy">
                <label for="q50">无异常</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q51" value="fever">
                <label for="q51">发烧（≥37.3℃）</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q52" value="weak">
                <label for="q52">乏力</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q53" value="cough">
                <label for="q53">干咳</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q54" value="obstruction">
                <label for="q54">鼻塞</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q55" value="snivel">
                <label for="q55">流涕</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q56" value="sorethroat">
                <label for="q56">咽痛</label>
            </div>
            <div class="bg-light">
                <input type="checkbox" name="q5" id="q57" value="diarrhea">
                <label for="q57">腹泻</label>
            </div>
        </div>
        <div class="question bg-light border-success border rounded" id="q6">
            <div>本人郑重承诺：</div>
            <div class="bg-light">
                <label for="q61">为疫情防控，本人同意以上信息依法提交所在辖区疫情防控部门统筹管理。</label>
                <input type="checkbox" name="q6" id="q61" required>
            </div>
            <div class="bg-light">
                <label for="q62">上述信息是我本人填写，本人对信息内容的真实性和完善性负责。如果信息有误或缺失，本人愿承担相应的法律责任。同时，本人保证遵守防疫管控的各项规定。配合并听从各项措施和要求。</label>

                <input type="checkbox" name="q6" id="q62" required>

            </div>
        </div>
        <div class="question" id="sub">
            <input type="submit" name="sub" class="form-control mt-1 bg-success text-white" value="提交">
        </div>
    </form>
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