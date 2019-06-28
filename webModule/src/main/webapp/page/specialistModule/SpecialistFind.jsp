<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String basePathIMG = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/img/";
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
                <div style="float: left;margin-left: 60px">
                    <div class="layui-form-item" style="margin-top: 55px">
                        <div class="layui-inline">
                            <label class="layui-form-label">姓名</label>${specialist.specialistName}
                        </div>
                    </div>

                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">出身年月</label>${specialist.specialistBirthday}
                        </div>
                    </div>


                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>${specialist.specialistSex}
                        </div>
                    </div>

                </div>
                <div  style="float: left; margin-left: 280px">
                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <%--<label class="layui-form-label">照片</label>--%>
                            <img src="<%=basePathIMG%>${specialist.specialistPath}" style="width: 100px;height: 120px">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline" style="margin-left: 60px">
                        <label class="layui-form-label">专长</label>${specialist.specialistSpeciality}

                    </div>
                    <div class="layui-inline" style="margin-left: 280px">
                        <label class="layui-form-label">职务</label>${specialist.specialistDuty}

                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 25px">
                    <div class="layui-inline" style="margin-left: 60px">
                        <label class="layui-form-label">电话</label>${specialist.specialistTel}

                    </div>
                    <div class="layui-inline" style="margin-left: 280px">
                        <label class="layui-form-label">工作单位</label>${specialist.specialistUnits}

                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 25px">
                    <div class="layui-inline">
                        <label class="layui-form-label" style="margin-left: 60px">通讯地址</label>${specialist.specialistSite}

                    </div>
                    <div class="layui-inline" style="margin-left: 280px">
                        <label class="layui-form-label">邮箱</label>${specialist.specialistEmail}

                    </div>
                </div>
   <div align="center">
                <button class="layui-btn layui-btn-primary layui-btn-sm"
                        style="width:80px;margin-top:0px" onclick="getBack('getBack')">返回
                </button>
   </div>
            </form>
        </div>
    </div>
</div>



<script>

    function getBack(r){
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
