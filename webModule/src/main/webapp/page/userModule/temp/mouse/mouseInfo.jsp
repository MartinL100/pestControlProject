<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../../../head.jsp"%>
    <title>事件信息</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>鼠害详细信息</h1></div>
                <!--左边区域-->
                <div  style=" position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label" style="width: 60%;text-align:left;">名&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp称：${mouse.mouseName}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">繁&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp殖：${mouse.mouseBreed}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">食nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp物：${mouse.mouseFood}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">天nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp敌：${mouse.mouseNatural}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">防治措施：${mouse.mousePrevent}   </label>

                            </div>
                        </div>
                    </div>
                </div>

                <!--右边区域-->
                <div  style="position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label">灾区图片：   </label>
                                <div style="position: relative;left:120px;top: -20px">
                                    <img  style="width: 120px;height: 130px;margin-left: -3cm;margin-top: 1cm" src="/img/${mouse.mousePhoto}"><p/></div>
                                <label class="layui-form-label" style="width: 99%;text-align:left;margin-top: -20px">主要危害：${mouse.mouseHarm}   </label>

                            </div>
                        </div>
                    </div>
                </div>

                <!-- 表格部分结束 -->
            </div>
        </div>
    </div>
</div>

<!--提交按钮-->
<div class="layui-form-item layui-layout-admin">
    <div class="layui-input-block">
        <div class="layui-footer" style="left: 0;">
            <form  action="mouseIntitServlet" method="post">
               </a> <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">返回</button>
            </form>
        </div>
    </div>
</div>
<!--提交按钮结束-->









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
            elem: '#LAY-component-form-group-date'
        });
    });

</script>

</body>
</html>