<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>森林虫害添加页面</title>
<jsp:include page="../../../../head.jsp"></jsp:include>
</head>
<body>
<span id="errorInfoId" style="display: none">${errorInfo}</span>
<div class="layadmin-user-login-main">

    <div class="layadmin-user-login-box layadmin-user-login-header">
        <br><br>
        <h1 align="center">添加虫害</h1>
    </div>
</div>
<div class="layui-card-header"></div>
<div class="layui-card-body">
    <form action="addWormServlet" method="post" enctype="multipart/form-data" id="jj">
    <span style=" position:relative;left:50px">名称</span>
    <input type="text" style=" position:relative;left:120px"name="pestisName">
    <span style=" position:relative;left:280px">寄主</span>
    <input type="text" style=" position:relative;left:350px"name="pestisHost"/>
    <br>
    <span style=" position:relative;left:50px;top: 50px">繁殖</span>
    <input type="text" style=" position:relative;left:120px;top: 50px"name="pestisBreed"/>
    <span style=" position:relative;left:280px;top: 50px">天敌</span>
    <input type="text" style=" position:relative;left:350px;top: 50px"name="pestisEnemy"/>
    <br>
    <span style=" position:relative;left:50px;top: 100px">幼虫图片</span>
    <input type="file" style=" position:relative;left:90px;top: 100px" name="pestisPhoto"/>

    <span style=" position:relative;left:200px;top: 100px">成虫图片</span>
    <input type="file" style=" position:relative;left:245px;top: 100px"name="pestisAdultImages"/>

    <br>
    <span style=" position:relative;left:50px;top: 80px">防治措施</span>
    <textarea rows="5" cols="23"style=" position:relative;left:90px;top: 150px" name="pestisDefense"></textarea>
    <span style=" position:relative;left:250px;top: 80px">主要危害</span>
    <textarea rows="5" cols="23"style=" position:relative;left:295px;top: 150px" name="pestisHarm"></textarea>
    <br>
    <button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;top:200px;left:450px" onclick="addpestis()" type="submit">添加</button>
    </form>
</div>

<script>
    function addpestis() {
        $("#jj").submit()
    }

    $(document).ready(function () {
       var errorInfos= $("#errorInfoId").text()
        sendErroInfo(errorInfos);
    })


</script>

</body>
</html>
