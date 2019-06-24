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



<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">用  户  管  理</h1>
                <div class="layui-card-body">
                    <table class="layui-table">

                        <thead>
                        <tr>
                            <th>用户名</th>
                            <th>密码</th>
                            <th>等级</th>
                            <th>真实姓名</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>贤心</td>
                            <td>汉族</td>
                            <td>1989-10-14</td>
                            <td>人生似修行</td>
                        </tr>
                        <tr>
                            <td>张爱玲</td>
                            <td>汉族</td>
                            <td>1920-09-30</td>
                            <td>于千万人之中遇见你所遇见</td>
                        </tr>
                        <tr>
                            <td>Helen Keller</td>
                            <td>拉丁美裔</td>
                            <td>1880-06-27</td>
                            <td> Life is either a daring adventure or nothing.</td>
                        </tr>
                        <tr>
                            <td>岳飞</td>
                            <td>汉族</td>
                            <td>1103-北宋崇宁二年</td>
                            <td>教科书再滥改，也抹不去“民族英雄”的事实</td>
                        </tr>
                        <tr>
                            <td>孟子</td>
                            <td>华夏族（汉族）</td>
                            <td>公元前-372年</td>
                            <td>猿强，则国强。国强，则猿更强！ </td>
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
                        <div style="width: 40%; float: left;margin-top: 4%" >
                            <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">添加用户</button>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">删除用户</button><br/>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">修改用户信息</button>
                        </div>

                        <div class="layui-col-xs3" style="float: right;margin-right: 20%;">

                            <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D">
                                <div class="layui-card-header">查询用户信息</div>
                                <div class="layui-card-body" >
                                    <!-- 填充内容 -->
                                        <select name="city" lay-verify="" style="display: inline;width: 60%; margin-left: 10%;" class="layui-input " >
                                            <option value="">所有用户</option>
                                            <option value="010">超级管理员</option>
                                            <option value="021">资料管理员</option>
                                            <option value="0571">灾情管理员</option>
                                            <option value="0571">专家管理员</option>
                                            <option value="0571">库房管理员</option>
                                        </select>
                                    <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 10%">查询</button>

                                    <!-- 填充内容 -->
                                </div>
                            </div>
                        </div></div></div>
<!--通用模块-->

            </div>
        </div>

    </div>
</div>









<script src="../../layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
</script>
</body>
</html>