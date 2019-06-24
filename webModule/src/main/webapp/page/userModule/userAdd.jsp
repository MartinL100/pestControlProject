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
        <h3 style="color: red" align="center" id="erroInfo">${erroInfo}</h3>


        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="userAddServlet" lay-filter="component-form-group" method="post">

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 30%">用户名</label>

                    <div class="layui-input-block" style="width: 30%;margin-top: 3%" >
                        <input type="text" name="userName"  id="userName" lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input" >
                    </div>

                </div>

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 30%">密码</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="password" name="password" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 30%">确认密码</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="password" name="passwordSure" lay-verify="required" placeholder="确认密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 30%">真实姓名</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="text" name="realName" lay-verify="required" placeholder="真实姓名" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <div class="layui-form-item" align="center">
                    <label class="layui-form-label" style="margin-left: 30%">用户等级</label>
                    <div class="layui-input-block" style="width: 30%" >
                        <select name="roleId" lay-filter="aihao">
                            <c:forEach var="role" items="${roleList}" >
                                <option value="${role.roleId}">${role.roleName}</option>
                            </c:forEach>
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

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });





    });
</script>
<script>

    $(document).ready(function () {
        setTimeout(function(){
            $("#erroInfo").hide();
        }, 3000);


        $("#userName").mouseleave(function () {
            var userName=$("#userName").val()

            $.post("isExistUserServlet",{"userName":userName},function (result) {
                $("#erroInfo").show();
                $("#erroInfo").text(result);
                setTimeout(function(){
                    $("#erroInfo").hide();
                }, 3000);

            })
        })
    })

</script>
</body>
</html>
