<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>森林病害添加页面</title>
  <jsp:include page="../../../../head.jsp"></jsp:include>
</head>
<body>
<div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">虫害详细信息</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body" style=" position:relative;left:150px">
    <form action="idpestis" method="get" id="demo0">
        <input type="hidden" name="huiijia" id="demoId">
    <span style=" position:relative;left:50px">名称</span>
    <span style=" position:relative;left:120px">${idpestis.pestisName}</span>
    <span style=" position:relative;left:-55px;top: 150px">寄主</span>
    <span style=" position:relative;left:20px;top: 150px">${idpestis.pestisHost}</span>
    <br>
    <span style=" position:relative;left:50px;top: 50px">繁殖</span>
    <span style=" position:relative;left:120px;top: 50px">${idpestis.pestisBreed}</span>
    <span style=" position:relative;left:-55px;top: 200px">天敌</span>
    <span style=" position:relative;left:20px;top: 200px">${idpestis.pestisEnemy}</span>
    <br>
    <span style=" position:relative;left:395px;top: -20px">幼虫图片</span>
    <img src="/img/${idpestis.pestisPhoto}" style=" position:relative;left:474px;top: -20px;width: 120px;height: 160px">

    <span style=" position:relative;left:200px;top: 200px">成虫图片</span>
    <img src="/img/${idpestis.pestisAdultImages}" style=" position:relative;left:280px;top: 200px ;width: 120px;height: 160px ">

    <br>
    <span style=" position:relative;left:45px;top: 100px">防治措施</span>
    <span style=" position:relative;left:90px;top:100px" >${idpestis.pestisDefense}</span>
    <span style=" position:relative;left:-125px;top: 180px">主要危害</span>
    <span style=" position:relative;left:-75px;top: 180px" >${idpestis.pestisHarm}</span>
    <br>
    </form>
</div>
<a href="wormIntitServlet"><button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:250px;left:450px" >返回</button></a>
</body>
</html>
