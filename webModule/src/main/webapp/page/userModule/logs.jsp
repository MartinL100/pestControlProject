
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
                        <tr>
                            <td>贤心</td>
                            <td>汉族</td>

                        </tr>
                        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>

                        </tr>
                        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>

                        </tr>        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>

                        </tr>
                        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>

                        </tr>


                        </tbody>
                    </table>
                </div>

                <!-- 翻页按钮部分-->
                <div align="center">
                    <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe603;</i></button>
                    &nbsp&nbsp;
                    <input type="text"  style="height: 0.68cm;width: 0.8cm" />
                    <span style="font-size: 16px">/66页</span>
                    <button class="layui-btn layui-btn-primary layui-btn-sm">跳转</button>
                    <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe602;</i></button>
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
                                    <form class="layui-form" action="" lay-filter="component-form-group">
                                        <div class="layui-inline">
                                            <label class="layui-form-label">验证日期</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="date" id="startdate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <!--时间模块-->
                                        <div class="layui-inline"style="margin-top: 10%">
                                            <label class="layui-form-label">验证日期</label>
                                            <div class="layui-input-inline">
                                                <input type="text" name="date" id="enddate" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                                            </div>
                                        </div>
                                        <!--时间模块-->
                                        <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 10%">查询</button>
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

        });

        laydate.render({
            elem: '#enddate'

        });



    });
</script>
</body>
</html>