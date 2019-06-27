<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
<jsp:include page="head.jsp"></jsp:include>
    <title>登陆</title>


</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>森林病虫害防治系统</h2>
            <h2 style="background-color: red" id="errorInfoId">${errorInfo}</h2>

        </div>
        <form action="loginServlet" method="post" id="formId">
        <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
                <input type="text" name="userName" id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
                <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
            </div>


            <div class="layui-form-item">
                <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit" id="login">登 入</button>
            </div>

        </div>
        </form>
    </div>





</div>


<script src="lib/jquery.js"></script>
<script>
    $("#login").click(function () {
        $("#formId").submit();
    });

    $(document).ready(function () {

        setTimeout(function () {
            $("#errorInfoId").hide()
        },3000)
    })
</script>


</body>
</html>