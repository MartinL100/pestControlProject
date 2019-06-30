
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <%@include file="../../head.jsp"%>
    <title>日志一览</title>
</head>
<body>



<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">用  户  管  理</h1>
                <div class="layui-card-body">
                    <table class="layui-table">

                        <thead>
                        <tr>
                            <th>日志内容</th>
                            <th>日期</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="log" items="${logList}">
                        <tr>
                            <td>${log.logDescrip}</td>
                            <td>${log.logDate}</td>

                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

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


                        <div class="layui-col-xs3" style="float: right;margin-right: 10%;width: 30%">

                            <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D;">
                                <div class="layui-card-header">查询用户信息</div>
                                <div class="layui-card-body" >
                                    <!-- 填充内容 -->
                                    <form class="layui-form" action="" lay-filter="component-form-group" id="selectForm">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">开始日期</label>
                                            <div class="layui-input-inline">
                                                <input  type="text" value="${startTime}" name="startTime" id="startdate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <!--时间模块-->
                                        <div class="layui-inline"style="margin-top: 7%">
                                            <label class="layui-form-label">结束日期</label>
                                            <div class="layui-input-inline">
                                                <input  type="text" value="${endTime}" name="endTime" id="enddate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <!--时间模块-->
                                        <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 3%">查询</button>
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
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
</script>


<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,layer = layui.layer
            ,laydate = layui.laydate
            ,form = layui.form;

        form.render(null, 'component-form-group');

        laydate.render({

            elem: '#startdate'
            ,trigger: 'click'
        });

        laydate.render({
            elem: '#enddate'
            ,trigger: 'click'
        });



    });
</script>


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
</body>
</html>