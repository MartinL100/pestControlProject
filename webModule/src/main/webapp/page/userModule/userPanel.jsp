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

<h2 style="color: red" id="erroInfo"></h2>

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
                        <c:forEach items="${userList}" var="user" >
                            <tr onclick="saveId(this)">
                                <td>${user.userName}</td>
                                <td>${user.userPassword}</td>
                                <td>${user.role.roleName}</td>
                                <td>${user.realName}</td>
                                <td style="display: none">${user.userId}</td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>

                </div>

                <form action="delUserServlet" id="userIdRecord" method="post">
                    <!--隐藏div，用于记录点击的用户的id-->
                    <input id="userId" name="checkedUserId" style="display: none"/>
                </form>
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
                            <button  id="delUser" class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">删除用户</button><br/>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 25%;margin-left: 15%;margin-top: 4%">修改用户信息</button>
                        </div>

                        <div class="layui-col-xs3" style="float: right;margin-right: 20%;">

                            <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D">
                                <div class="layui-card-header">查询用户信息</div>
                                <div class="layui-card-body" >
                                    <form action="findUserServlet" method="post">
                                    <!-- 填充内容 -->
                                        <select name="roleId" lay-verify="" style="display: inline;width: 60%; margin-left: 10%;" class="layui-input " >
                                            <c:forEach var="role" items="${roleList}" >
                                                <option value="${role.roleId}">${role.roleName}</option>
                                            </c:forEach>
                                        </select>
                                    <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 10%" type="submit">查询</button>
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
    function saveId(obj) {
        //获取点中行对应的用户id
   var id = obj.lastChild.previousSibling.firstChild.nodeValue;
        //将用户id保存到隐藏div  userId中
   $("#userId").val(id);
    }
    //点击删除按钮
    $("#delUser").click(function () {
        //从隐藏div中获取选中id
        var userId=$("#userId").val();
        if(userId==null||""==userId){
            $("#erroInfo").text("请点击需要删除的行");
        }else {
            $("#userIdRecord").submit();
        }
    })
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