<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
 <jsp:include page="../../head.jsp"></jsp:include>
    <title>用户管理</title>
</head>
<body>
<!--用于控制页面跳转-->
<form action="findAreaServlet" method="post" id="addUserForm"></form>

<div class="layui-fluid" id="divId1">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">区 域 一 览</h1>
                <h2 style="color: red" id="erroInfo" align="center"></h2>
                <div class="layui-card-body">
                    <table class="layui-table">

                        <thead>
                        <tr>
                            <th>区域名称</th>
                            <th>林种</th>
                            <th>地类</th>
                            <th>优势树种</th>
                            <th>负责小班</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${areaList}" var="areaObj" >
                            <tr onclick="saveId(this)">
                                <td>${areaObj.areaName}</td>
                                <td>${areaObj.areaTreeType}</td>
                                <td>${areaObj.selectedType.typeVal}</td>
                                <td>${areaObj.areaGoodTree}</td>
                                <td>${areaObj.sysClass.sclassName}</td>
                                <td style="display: none">${areaObj.areaId}</td>
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
                            <a href="addAreaInitServlet"><button id="addArea" ac class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">添加区域</button></a>

                        </div>

                        <div class="layui-col-xs3" style="float: right;margin-right: 20%;">

                            <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D">
                                <div class="layui-card-header">查询区域信息</div>
                                <div class="layui-card-body" >
                                    <form action="findAreaServlet" method="post" id="selectForm">
                                    <!-- 填充内容 -->
                                        <div >
                                        <label class="layui-form-label" style="display: inline-block ; width: 60px; ">区域名称</label>
                                     <input class="layui-input" name="areaName" value="${areaName}"  style="display: inline-block;width: 50%"/>
                                        </div>
                                        <div style="margin-top: 4% ">
                                            <label class="layui-form-label" style="display: inline-block ; width: 60px; ">林种</label>
                                            <input class="layui-input" name="areaTreeType" value="${areaTreeType}"  style="display: inline-block;width: 50%"/>
                                        </div>
                                        <div style="margin-top:4%">
                                            <label class="layui-form-label" style="display: inline-block ; width: 60px;  ">负责小班</label>
                                            <input class="layui-input" name="sclassName" value="${sclassName}"  style="display: inline-block;width: 50%"/>
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