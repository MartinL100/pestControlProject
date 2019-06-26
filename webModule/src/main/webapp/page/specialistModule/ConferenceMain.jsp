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
    <title>专家会商</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-card">
        <h1 align="center" style="font-size: 35px">专家会商</h1>
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="" lay-filter="component-form-group">

                <div style="float: left;margin-left: 250px">
                    <div class="layui-form-item" style="margin-top: 20px">
                        <div class="layui-inline">
                            <label class="layui-form-label">事件名称</label>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">时间</label>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">发生位置</label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">灾情描述</label>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">会商结果</label>
                        <div class="layui-input-block">
                            <textarea name="text" placeholder="请输入内容" class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>


                <div style="float: left; margin-left: 150px">
                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">照片</label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">影响面积</label>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <span class="layui-form-label">会商人员</span>
                            <select style="width: 80px;height: 100px">
                                <option value="1">2</option>
                                <option value="2">3</option>
                                <option value="2">4</option>
                            </select>

                        </div>
                    </div>


                    <div align="center">
                        <button class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:120px;margin-top:40px">添加会商信息
                        </button>

                        <button class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:80px;margin-top:40px">返回
                        </button>
                    </div>
                </div>
                <div>
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>会商人员</th>
                            <th>会商结果</th>
                        </thead>
                        <tbody>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>2</td>
                            <td>3</td>
                        </tr>

                        </tbody>
                    </table>
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
