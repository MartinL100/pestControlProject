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
    <title>添 加 区 域</title>

</head>
<body>

<div class="layui-fluid" id="addDivId">

    <div class="layui-card">

        <h1 align="center" style="padding: 15px;">添 加 区 域</h1>
        <h3 style="color: red" align="center" id="erroInfo">${erroInfo}</h3>
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="addAreaServlet" lay-filter="component-form-group" method="post">

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 27%" >名称</label>

                    <div class="layui-input-block" style="width: 30%;margin-top: 3%" >
                        <input type="text" name="userName"  id="userName" lay-verify="required" placeholder="名称" autocomplete="off" class="layui-input" >
                    </div>

                </div>

                <div class="layui-form-item" align="center">

                    <label class="layui-form-label" style="margin-left: 27%">林种</label>

                    <div class="layui-input-block" style="width: 30%" >
                        <input type="text" name="areaTreeType" lay-verify="required" placeholder="林种" autocomplete="off" class="layui-input" >
                    </div>
                </div>

                <div class="layui-form-item" align="center" >

                    <label class="layui-form-label" style="margin-left: 27%; ">优势树种</label>

                    <div class="layui-input-block" style="width: 30% ;" >

                        <input type="text" name="areaGoodTree" lay-verify="required" placeholder="优势树种" autocomplete="off" class="layui-input" >
                    </div>
                </div>


                <div class="layui-form-item" align="center">
                    <label class="layui-form-label" style="margin-left: 27%">地类</label>
                    <div class="layui-input-block" style="width: 30%" >
                        <select name="selectedType" lay-filter="aihao">
                            <c:forEach var="areaObj" items="${areaList}" >
                                <option value="${areaObj.typeId}">${areaObj.typeVal}</option>
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
    })




</script>
</body>
</html>
