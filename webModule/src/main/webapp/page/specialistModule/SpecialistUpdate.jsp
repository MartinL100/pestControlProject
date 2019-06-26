<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String basePathIMG = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <jsp:include page="../../head.jsp"></jsp:include>
    <title>修改专家信息</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <h1 align="center" style="font-size: 35px">修 改 专 家 信 息</h1>
        <div class="layui-card-body" style="padding: 15px;">
            <form  id="fid" class="layui-form" method="post" action="specialistUpdate" lay-filter="component-form-group" >
                <input type="hidden" name="updateTag" value="" id="updateId">
                <input type="hidden" name="specialistId" value="${specialistObj.specialistId}" id="specialistId">
                <div style="float: left;margin-left: 250px">
                    <div class="layui-form-item" style="margin-top: 55px">
                        <div class="layui-inline">
                            <label class="layui-form-label">姓名</label>${specialistObj.specialistName}
                        </div>
                    </div>

                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">出身年月</label>${specialistObj.specialistBirthday}
                        </div>
                    </div>


                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>${specialistObj.specialistSex}
                        </div>
                    </div>

                </div>
                <div style="float: left; margin-left: 400px">
                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">照片</label>
                            <img src="<%=basePathIMG%>${specialist.specialistPath}" style="width: 40px;height: 60px">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline" style="margin-left: 250px">
                        <label class="layui-form-label">专长</label>${specialistObj.specialistSpeciality}

                    </div>
                    <div class="layui-inline" style="margin-left: 400px">
                        <label class="layui-form-label">职务</label>
                        <div class="layui-input-inline">
                            <input type="text" value="${specialistObj.specialistDuty}" name="specialistDuty"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline" style="margin-left: 250px">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-inline">
                            <input type="tel" name="specialistTel" lay-verify="phone" autocomplete="off"
                                   class="layui-input" value="${specialistObj.specialistTel}">
                        </div>
                    </div>
                    <div class="layui-inline" style="margin-left: 200px">
                        <label class="layui-form-label">工作单位</label>
                        <div class="layui-input-inline">
                            <input type="text" value="${specialistObj.specialistUnits}" name="specialistUnits"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label"
                               style="margin-left: 250px">通讯地址</label>${specialistObj.specialistSite}

                    </div>
                    <div class="layui-inline" style="margin-left: 400px">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" value="${specialistObj.specialistEmail}" name="specialistEmail"
                                   lay-verify="email" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>
                <div align="center">
                    <button class="layui-btn layui-btn-primary layui-btn-sm"
                            style="width:80px;margin-top:40px" onclick="updateSpecialist('updateSpecialist')">修改
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    function updateSpecialist(r) {
        $("#updateId").val(r);
        $("#fid").submit();
    }


    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function () {
        var $ = layui.$
            , admin = layui.admin
            , element = layui.element
            , layer = layui.layer
            , laydate = layui.laydate
            , form = layui.form;

        form.render(null, 'component-form-group');

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });
    });
</script>
</body>
</html>
