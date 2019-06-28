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
    <title>添加专家信息</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <h1 align="center" style="font-size: 35px">添 加 专 家 信 息</h1>
        <div class="layui-card-body" style="padding: 15px;" align="center">
            <form enctype="multipart/form-data" id="fid"; method="post" class="layui-form" action="specialistAdd" lay-filter="component-form-group">


                <div class="layui-form-item" style="margin-top: 55px">
                    <div class="layui-inline">
                        <label class="layui-form-label" >姓名</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistName" autocomplete="off"
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
                                   class="layui-input" >
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">专长</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistSpeciality" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">职务</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistDuty" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">电话</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistTel" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">工作单位</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistUnits" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <div class="layui-form-item" style="margin-top: 30px">
                    <div class="layui-inline">
                        <label class="layui-form-label">通讯地址</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistSite" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">邮箱</label>
                        <div class="layui-input-inline">
                            <input type="text" name="specialistEmail" lay-verify="email" autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>
                </div>

                <button class="layui-btn layui-btn-primary layui-btn-sm"
                        style="width:80px;margin-top:40px" onclick="add()">添加
                </button>

            </form>
        </div>
    </div>
</div>


<script>

    function add(){
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
