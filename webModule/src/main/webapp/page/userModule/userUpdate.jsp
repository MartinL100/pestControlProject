
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

        <h1 align="center" style="padding: 15px;">修改用户信息</h1>
        <h2 style="color: red" id="errorInfo" align="center"></h2>

        <div class="layui-card-body" style="padding: 15px;">




                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 27%">用户名</label>

                    <div class="layui-input-block" style="width: 30%;margin-top: 3%" align="center" >

<%--                        <input type="text"   disabled="disabled" value="${user.userName}" name="sureNewPwd" lay-verify="required" placeholder="确认密码" autocomplete="off" class="layui-input" >--%>
                        <label class="layui-form-label" style="margin-left: 10%">${user.userName}</label>
                    </div>
                </div>
            <form class="layui-form" id="updateForm" action="updateUserInfoSureServlet" lay-filter="component-form-group">
                <div class="layui-form-item" align="center">

                    <label  class="layui-form-label" style="margin-left: 27%">新密码</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="password" id="newPwd" name="newPwd" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <!--隐藏div，用于记录点击的用户的id-->
                <input id="userId" name="userId"  value="${user.userId}" style="display: none"/>
                <div class="layui-form-item" align="center">

                    <label  class="layui-form-label" style="margin-left: 27%">确认新密码</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="password" id="sureNewPwd" name="sureNewPwd" lay-verify="required" placeholder="确认密码" autocomplete="off" class="layui-input" >
                    </div>
                </div>
                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 27%">真实姓名</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <label class="layui-form-label" style="margin-left: 15%" >${user.realName}</label>
                    </div>
                </div>

                <div class="layui-form-item" align="center">
                    <label class="layui-form-label" style="margin-left: 27%">用户等级</label>
                    <div class="layui-input-block" style="width: 30%" >
                        <select name="roleId" lay-filter="aihao">
                            <c:forEach var="role" items="${roleList}" >
                                <option value="${role.roleId}">${role.roleName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </form>
                <div  align="center">


                    <div class="layui-input-block" style="width: 30%;margin-top: 8%" >
                        <button id="updateUser" class="layui-btn" >立即提交</button>
                    </div>
                </div>







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
<script>
    $("#updateUser").click(function () {
        var newPwd=$("#newPwd").val();
        var sureNewPwd=$("#sureNewPwd").val();


        if(sureNewPwd!=newPwd){
            sendErroInfo("两次密码不一致，请重新输入");
            $("#newPwd").val("");
            $("#sureNewPwd").val("");
        }else {

            $("#updateForm").submit();
        }
    })

</script>
</body>
</html>
