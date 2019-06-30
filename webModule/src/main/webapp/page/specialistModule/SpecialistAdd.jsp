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
    <title>添加专家信息</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <h1 align="center" style="font-size: 35px">添 加 专 家 信 息</h1>
        <div class="layui-card-body" style="padding: 15px;" align="center">
            <form enctype="multipart/form-data" id="fid" ; method="post" class="layui-form" action="specialistAdd"
                  lay-filter="component-form-group">


                <div class="layui-form-item" style="margin-top: 55px">
                    <div class="layui-inline">
                        <label class="layui-form-label">姓名</label>
                        <div class="layui-input-inline">
                            <input  type="text" name="specialistName" autocomplete="off" id="nameId"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">性别</label>
                        <div class="layui-input-block">
                            <input type="radio" name="specialistSex" value="1" title="男" checked="">
                            <input type="radio" name="specialistSex" value="2" title="女">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                    </div>
                </div>

                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">出身年月</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistBbirthday" id="LAY-component-form-group-date"
                                   lay-verify="date"
                                   placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">照片</label>
                        <div class="layui-input-inline">
                            <input type="file" name="specialistPath" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">专长</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistSpeciality" autocomplete="off" id="specialityId"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">职务</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistDuty" autocomplete="off" class="layui-input" id="dutyId">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistTel" autocomplete="off" class="layui-input" id="telId">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">工作单位</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistUnits" autocomplete="off" class="layui-input"
                                   id="unitsId">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">通讯地址</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistSite" autocomplete="off" id="siteId"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistEmail" lay-verify="email" autocomplete="off" id="emailId"
                                   class="layui-input">
                        </div>
                    </div>
                </div>

                <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"
                        style="width:80px;margin-top:40px" onclick="add()">添加
                </button>

            </form>
        </div>
    </div>
</div>


<script>

    function add() {
        var nameTest = $("#nameId").val();
        var specialityTest = $("#specialityId").val();
        var dutyTest = $("#dutyId").val();
        var telTest = $("#telId").val();
        var unitsTest = $("#unitsId").val();
        var siteTest = $("#siteId").val();
        var emailTest = $("#siteId").val();
        var mPattern = /^1[34578]\d{9}$/;
        var ePattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        var bl = true;
        if (null == nameTest || nameTest.length == 0) {
            sendErroInfo("姓名不能为空");
            bl = false;

        }else {
            bl=true;
        }
        if (null == birthdayTest || birthdayTest.length == 0) {
            sendErroInfo("生日不能为空");
            bl = false;
        }else {
            bl=true;
        }

        if (null == dutyTest || dutyTest.length == 0) {
            sendErroInfo("职务不能为空");
            bl = false;
        }else {
            bl=true;
        }
        if (telTest.test(mPattern)) {
            sendErroInfo("请输入合法手机号");
            bl = false;
        }else {
            bl=true;
        }
        if (null == unitsTest || unitsTest.length == 0) {
            sendErroInfo("工作单位不能为空");
            bl = false;
        }else {
            bl=true;
        }
        if (null == siteTest || siteTest.length == 0) {
            sendErroInfo("通讯地址不能为空");
            bl = false;
        }else {
            bl=true;
        }
        if (emailTest.test(ePattern)) {
            sendErroInfo("请输入正确的邮箱");
            bl = false;
        }else {
            bl=true;
        }
        if (bl) {
            $("#fid").submit();
        }
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
