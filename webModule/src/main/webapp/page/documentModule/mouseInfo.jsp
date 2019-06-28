<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>森林鼠害详情页面</title>
    <link rel="stylesheet" href="mouseInfo.jsp" media="all">
    <link rel="stylesheet" href="mouseInfo.jsp" media="all">
    <link rel="stylesheet" href="mouseInfo.jsp" media="all">
    <script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">鼠害详细信息</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body" style=" position:relative;left:130px">
    <span style=" position:relative;left:50px">名称</span>
    <span  style=" position:relative;left:120px">${idMouse.mouseName}</span>

    <br>
    <span style=" position:relative;left:50px;top: 65px">繁殖</span>
    <span style=" position:relative;left:120px;top: 65px">${idMouse.mouseBreed}</span>

    <span style=" position:relative;left:-55px;top: 160px">天敌</span>
    <span style=" position:relative;left:20px;top: 160px">${idMouse.mouseNatural}</span>
    <br>
    <span style=" position:relative;left:45px;top: 100px">食物</span>
    <span style=" position:relative;left:110px;top: 100px">${idMouse.mouseFood}</span>



    <span style=" position:relative;left:280px">图片</span>
    <img src="#" style=" position:relative;left:340px ;width: 120px;height: 160px ">

    <br>
    <span style=" position:relative;left:40px;top: 180px">防治措施</span>
    <span style=" position:relative;left:90px;top:180px" >${idMouse.mousePrevent}</span>

    <span style=" position:relative;left:200px;top: 80px">主要危害</span>
    <span style=" position:relative;left:250px;top: 80px" >${idMouse.mouseHarm}</span>
    <br>
</div>
<a href="/mouseIndex"><button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:250px;left:450px" onclick="">返回</button></a>
</body>
</html>