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
            <form id="fid" class="layui-form" method="post" action="specialistUpdate" lay-filter="component-form-group">
                <input type="hidden" name="updateTag" value="" id="updateId">
                <input type="hidden" name="specialistId" value="${specialistObj.specialistId}" id="specialistId">
                <div style="overflow:hidden;">
                    <div class="layui-form-item"
                         style="position: relative;width: 50%;float: left;">
                        <div class="layui-inline" style="margin-left: 60px" align="center">
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 45px">姓名&emsp;&emsp;&emsp;&emsp;&emsp;${specialistObj.specialistName}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">出身年月&emsp;&emsp;&emsp;${specialistObj.specialistBirthday}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">性别&emsp;&emsp;&emsp;&emsp;&emsp;${specialistObj.specialistSex}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">专长&emsp;&emsp;&emsp;&emsp;&emsp;${specialistObj.specialistSpeciality}</label>
                            <div class="layui-inline" style="float: left;">
                                <label class="layui-form-label" style="text-align:left;margin-top: 25px">电话</label>
                                <div class="layui-input-inline" style="margin-top: 25px">
                                    <input id="telId" type="text" name="specialistTel" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">通讯地址&emsp;&emsp;&emsp;${specialistObj.specialistSite}</label>

                        </div>

                    </div>


                    <div class="layui-form-item"
                         style="position: relative;width: 50%;float: left;margin-left:50%;margin-top:-420px;">
                        <div class="layui-inline">
                            <div style="float: left;margin-left: 15px">
                                <img src="<%=basePathIMG%>${specialistObj.specialistPath}"
                                     style="width: 150px;height: 200px">
                            </div>
                            <div class="layui-inline">
                                <div class="layui-inline">
                                    <label class="layui-form-label" style="text-align:left;margin-top: 25px">职务</label>
                                    <div class="layui-input-inline" style="margin-top: 25px">
                                        <input id="dutyId" type="text" name="specialistDuty" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label"
                                           style="text-align:left;margin-top: 25px">工作单位</label>
                                    <div class="layui-input-inline" style="margin-top: 25px">
                                        <input id="unitsId" type="text" name="specialistUnits" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label" style="text-align:left;margin-top: 25px">邮箱</label>
                                    <div class="layui-input-inline" style="margin-top: 25px">
                                        <input id="emailId" type="text" name="specialistEmail" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>


                <div align="center">
                    <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"
                            style="width:80px;margin-top:40px" onclick="updateSpecialist('updateSpecialist')">修改
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    function updateSpecialist(r) {
        var telTest = $("#telId").val();
        var dutyTest = $("#dutyId").val();
        var unitsTest = $("#unitsId").val();
        var emailTest = $("#siteId").val();
        var mPattern = /^1[34578]\d{9}$/;
        var ePattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        var bl = true;
        if (telTest.test(mPattern)) {
            sendErroInfo("请输入合法手机号");
            bl = false;
        }
        if (null == dutyTest || dutyTest.length == 0) {
            sendErroInfo("职务不能为空");
            bl = false;
        }
        if (null == unitsTest || unitsTest.length == 0) {
            sendErroInfo("工作单位不能为空");
            bl = false;
        }
        if (emailTest.test(ePattern)) {
            sendErroInfo("请输入正确的邮箱");
            bl = false;
        }
        if (bl) {
            $("#updateId").val(r);
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