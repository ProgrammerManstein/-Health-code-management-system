<%--
  Created by IntelliJ IDEA.
  User: legion
  Date: 2021/6/13
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: legion
  Date: 2021/6/13
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>系统管理员登录</title>
    <link rel="stylesheet" href="assets/css/SignIn.css">
    <%--    <link rel="stylesheet" href="css/bootstrap.min.css">--%>
    <script src="https://cdn.staticfile.org/vue/2.6.9/vue.js"></script>
</head>

<body>
<div id='app' class="container bg-success">
    <img src="assets/images/bg2.jpg" />
    <div class="panel">
        <div class="content login">
            <div class="switch">
                <p style="color: red">
                    <%
                        String error=request.getParameter("error");
                        if(error!=null)
                        if(error.equals("error")){
                    %>
                    <%="用户名或密码错误"%>
                    <%
                        }
                    %>
                </p>
                <span :class='{"active": active === "login"}' @click='go("login")'>系统管理员登录</span>
            </div>
            <div class='form' id="fromLogin">
                <form action="loginActionServlet" method="post">

                    <template v-if='active === "login"'>
                        <div class="input"><input :class='{ hasValue: loginForm.Username }' v-model='loginForm.Username' type="text" name="num1" id="username" /><label for="username">用户名</label></div>
                        <div class="input"><input :class='{ hasValue: loginForm.Password }' v-model='loginForm.Password' type="password" name="password" id="Password" /><label for="Password">密码</label></div>
                    </template>

                    <span>忘记?</span>

                    <button type="submit" @click='submit'>登陆</button>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            active: 'login',
            registerForm: { email: '', Username: '', Password: '', repeat: '', },
            loginForm: { Username: '', Password: '', },
        },
        methods: {
            go (type) {
                this.active = type
            },
            submit() {
                if (type === 'login') {
                    console.log('login', this.loginForm)
                }

                if (type === 'register') {
                    console.log('register', this.registerForm)
                }
            }
        },
        beforeMount () {}
    })
</script>

</html>
