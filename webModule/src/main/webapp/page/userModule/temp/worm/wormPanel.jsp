<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
 <jsp:include page="../../../../head.jsp"></jsp:include>
    <title>用户管理</title>
</head>
<body>
<!--用于控制页面跳转-->
<form action="addUserInitServlet" method="post" id="addUserForm"></form>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">虫害一览</h1>
                <h2 style="color: red" id="erroInfo" align="center"></h2>
                <div class="layui-card-body">
                    <table class="layui-table">

                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>寄主</th>
                            <th>主要危害</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pestisBeanList}" var="pestisBean" >
                            <tr onclick="saveId(this)">
                                <td>${pestisBean.pestisName}</td>
                                <td>${pestisBean.pestisHost}</td>
                                <td>${pestisBean.pestisHarm}</td>
                                <td style="display: none">${pestisBean.id}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>

                <form action="" id="userIdRecord" method="post">
                    <!--隐藏div，用于记录点击的用户的id-->
                    <input id="userId" name="checkedUserId" style="display: none"/>
                </form>
                <!-- 翻页按钮部分-->
                <div align="center">
                    <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="splitPage('prev')"><i class="layui-icon">&#xe603;</i></button>
                    &nbsp&nbsp;
                    <input type="text"  style="height: 0.68cm;width: 0.8cm" id="targetPageNum" value="${currentPage}"/>
                    <span style="font-size: 16px">/${maxPage}</span>
                    <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="splitPage('targetPage')">跳转</button>
                    <button class="layui-btn layui-btn-primary layui-btn-sm"  onclick="splitPage('next')"><i class="layui-icon">&#xe602;</i></button>
                    <br>
                </div>


                <!-- 翻页按钮部分结束 -->

<!--通用模块-->

                <style>
                    /* 这段样式只是用于演示 */
                    #LAY-component-grid-mobile .layui-card-body{display: flex; justify-content: center; flex-direction: column; text-align: center; height: 200px;}
                </style>

                <div class="layui-fluid" id="LAY-component-grid-mobile"  >




                    <div class="layui-row layui-col-space10" >
                        <div style="width: 40%; float: left;margin-top: 4%" >
                           <a href="page/userModule/temp/worm/wormAdd.jsp"><button id="addUser" ac class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">添加新虫害</button></a>
                            <button  id="delUser" class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">删除用户</button><br/>
                            <button  id="updateUserInfo" class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">修改用户信息</button>
                        </div>

                        <div class="layui-col-xs3" style="float: right;margin-right: 20%;">

                            <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D">
                                <div class="layui-card-header">查询虫害信息</div>
                                <div class="layui-card-body" >
                                    <form action="wormIntitServlet" method="post" id="selectForm">
                                    <!-- 填充内容 -->
                                        <div class="layui-inline">
                                            <label class="layui-form-label" >害虫名</label>
                                            <div class="layui-input-block" style="width:52%;">
                                                <input  value="${pestisName}" type="text" name="pestisName"  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <div class="layui-inline" style="margin-top: 10%">
                                            <label class="layui-form-label" >寄主</label>
                                            <div class="layui-input-block" style="width:52%;">
                                                <input  value="${pestisHost}" type="text" name="pestisHost"  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                    <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 10%" type="submit">查询</button>
<!--分页标记-->
                                        <input id="currentPageId" name="currentPage" style="display: none" value="${currentPage}"/><!--当前页-->
                                        <input id="tagId" name="tag" style="display: none" value="${tag}"/><!--操作标记-->
<!--分页标记-->
                                    </form>
                                    <!-- 填充内容 -->
                                </div>
                            </div>
                        </div></div></div>
<!--通用模块-->

            </div>
        </div>

    </div>
</div>

<script>
    //点击某行，保存该行对应用户对象的id
    function saveId(obj) {
        //获取点中行对应的用户id
   var id = obj.lastChild.previousSibling.firstChild.nodeValue;
        //将用户id保存到隐藏div  userId中
   $("#userId").val(id);
    }


    //点击删除按钮
    $("#delUser").click(function () {
        $("#userIdRecord").attr('action','delUserServlet');
        //从隐藏div中获取选中id
        var userId=$("#userId").val();
        if(userId==null||""==userId){
            sendErroInfo("请点击需要删除的行")

        }else {
            $("#userIdRecord").submit();
        }
    })

    //点击修改按钮

    $("#updateUserInfo").click(function () {
        $("#userIdRecord").attr('action','updateUserInfoServlet');

        //从隐藏div中获取选中id
        var userId=$("#userId").val();
        if(userId==null||""==userId){
            sendErroInfo("请点击需要修改的行");

        }else {
            $("#userIdRecord").submit();
        }

    })

    //点击添加用户
    $("#addUser").click(function () {
        $("#addUserForm").submit();
    })
    //分页公共js

    function splitPage(splitTag) {
        if("targetPage"==splitTag){
            var targetPage=$("#targetPageNum").val();
            $("#tagId").val(targetPage);
        }else {
            $("#tagId").val(splitTag);
        }
        $("#selectForm").submit();
    }


</script>











<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
</script>
</body>
</html>