
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <title>森林病害添加页面</title>
    <jsp:include page="../../../../head.jsp"></jsp:include>
</head>
<body>
<div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">添加鼠害</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body" >
    <form action="addMouseServlet" method="post" enctype="multipart/form-data" id="fid">
    <span style=" position:relative;left:50px">名称</span>
    <input type="text" style=" position:relative;left:120px" name="mouseName">
    <span style=" position:relative;left:280px">食物</span>
    <input type="text" style=" position:relative;left:350px" name="mouseFood">
    <br>
    <span style=" position:relative;left:50px;top: 50px">繁殖</span>
    <input type="text" style=" position:relative;left:85px;top: 50px" name="mouseBreed">
    <span style=" position:relative;left:240px;top: 50px">天敌</span>
    <input type="text" style=" position:relative;left:285px;top: 50px" name="mouseNatural">
    <br>
    <span style=" position:relative;left:50px;top: 100px">图片</span>
    <input type="file" style=" position:relative;left:120px;top: 100px" name="mousePhoto">

    <br>
    <span style=" position:relative;left:50px;top: 80px">防治措施</span>
    <textarea rows="5" cols="23"style=" position:relative;left:90px;top: 150px" name="mousePrevent"></textarea>
    <span style=" position:relative;left:240px;top: 80px">主要危害</span>
    <textarea rows="5" cols="23"style=" position:relative;left:275px;top: 150px" name="mouseHarm"></textarea>
    <br>
        <button type="submit" class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:200px;left:450px" onclick="add()" >添加</button>

        </form>
 </div>
<script>
    function add() {
        $("#fid").submit()
    }



</script>




</body>
</html>
