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
    <title>查看专家信息</title>
</head>
<body>


<div class="layui-fluid">
    <div class="layui-card">
        <h1 align="center" style="font-size: 35px">查 看 专 家 信 息</h1>
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="specialistFind" method="post" lay-filter="component-form-group">
                <input type="hidden" name="findTag" id="findTagId">
                <div style="overflow:hidden;" align="center">
                    <div class="layui-form-item"
                         style="position: relative;width: 50%;float: left;">
                        <div class="layui-inline" style="margin-left: 100px">
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 45px">姓名&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistName}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">出身年月&emsp;&emsp;&emsp;${specialist.specialistBirthday}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">性别&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistSex}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">专长&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistSpeciality}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">电话&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistTel}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">通讯地址&emsp;&emsp;&emsp;${specialist.specialistSite}</label>

                        </div>

                    </div>


                    <div class="layui-form-item"
                         style="position: relative;width: 50%;float: left;margin-left:50%;margin-top:-400px;">
                        <div class="layui-inline">
                            <div style="float: left;margin-left: 15px">
                                <img src="<%=basePathIMG%>${specialist.specialistPath}"
                                     style="width: 150px;height: 200px">
                            </div>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 5px">职务&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistDuty}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">工作单位&emsp;&emsp;&emsp;${specialist.specialistUnits}</label>
                            <label class="layui-form-label" style="text-align:left;width: 90%;margin-top: 25px">邮箱&emsp;&emsp;&emsp;&emsp;&emsp;${specialist.specialistEmail}</label>
                        </div>
                    </div>
                </div>


                <div align="center">
                    <button class="layui-btn layui-btn-primary layui-btn-sm"
                            style="width:80px;margin-top:10px" onclick="getBack('getBack')">返回
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>


<script>

    function getBack(r) {
        $("#findTagId").val(r);
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
