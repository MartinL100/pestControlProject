
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
    <title>添加用户信息</title>
</head>
<body>

<div class="layui-fluid" >

    <div class="layui-card">

        <h1 align="center" style="padding: 15px;">添加用户信息</h1>

        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="" lay-filter="component-form-group">

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 38%">用户名</label>

                    <div class="layui-input-block" style="width: 15%;margin-top: 3%" >
                        <label class="layui-form-label" >用户名</label>
                    </div>
                </div>

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 38%">新密码</label>

                    <div class="layui-input-block" style="width: 15%" >
                        <input type="password" name="username" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 38%">确认新密码</label>

                    <div class="layui-input-block" style="width: 15%" >
                        <input type="password" name="username" lay-verify="required" placeholder="确认密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 38%">真实姓名</label>

                    <div class="layui-input-block" style="width: 15%" >
                        <label class="layui-form-label" >真实姓名</label>
                    </div>
                </div>

                <div class="layui-form-item" align="center">
                    <label class="layui-form-label" style="margin-left: 38%">用户等级</label>
                    <div class="layui-input-block" style="width: 15%" >
                        <select name="interest" lay-filter="aihao">
                            <option value=""></option>
                            <option value="0">写作</option>
                            <option value="1" selected="">阅读</option>
                            <option value="2">游戏</option>
                            <option value="3">音乐</option>
                            <option value="4">旅行</option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item" align="center">

                    <div class="layui-input-block" style="width: 30%;margin-top: 8%" >
                        <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">立即提交</button>
                    </div>
                </div>






            </form>
        </div>
    </div>
</div>



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
    });
</script>
</body>
</html>
