
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
    <link rel="stylesheet" href="diseaseInfo.jsp" media="all">
    <link rel="stylesheet" href="../documentModule/mdiseaseInfo.html" media="all">
    <link rel="stylesheet" href="diseaseInfo.jsp" media="all">
    <script type="text/javascript" src="../../lib/jquery.js"></script>
</head>
<body>
<div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">病害详细信息</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body" style=" position:relative;left:130px">
    <form action="idDisease" method="get" enctype="multipart/form-data"  >

    <span style=" position:relative;left:50px">名称</span>
    <span style=" position:relative;left:120px">${idDisease.diseaseName}</span>
    <br>
    <span style=" position:relative;left:50px;top: 65px">病源</span>
    <span style=" position:relative;left:120px;top: 65px">${idDisease.diseaseSource}</span>

    <span style=" position:relative;left:-58px;top: 160px">发病状态</span>
    <span style=" position:relative;left:-20px;top: 160px">${idDisease.diseaseSymptom}</span>
    <br>
    <span style=" position:relative;left:45px;top: 100px">发病规律</span>
    <span style=" position:relative;left:85px;top: 100px">${idDisease.diseaseLaw}</span>



    <span style=" position:relative;left:280px">图片</span>
    <img src="#" style=" position:relative;left:340px ;width: 120px;height: 160px ">

    <br>
    <span style=" position:relative;left:40px;top: 180px">防治措施</span>
    <span style=" position:relative;left:90px;top:180px" >${idDisease.diseaseMeasure}</span>

    <span style=" position:relative;left:200px;top: 80px">主要危害</span>
    <span style=" position:relative;left:250px;top: 80px" >${idDisease.diseaseHarm}</span>
    <br>
    </form>
</div>
<a href="/diseaseIndex"><button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:250px;left:450px">返回</button></a>

<script>



</script>



</body>
</html>