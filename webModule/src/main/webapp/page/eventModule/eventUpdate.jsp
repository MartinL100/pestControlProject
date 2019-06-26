<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../head.jsp"%>
    <title>静态表格</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>事件记录</h1></div>
                <!--左边区域-->
                <div  style="position: relative;left:6%;float: left;width: 30%">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <div class="layui-inline" style="position: relative;left:15px">
                            <label class="layui-form-label" style="width: 80px">事件名称：</label><span>${event.eventName} </span><p/>
                            <div style="width: 80px; margin-top: 20px">
                            <label class="layui-form-label" >时&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp间:</label>
                            <span >${event.occurTime} </span></div>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">灾害类型：</label>
                            <span style=" margin-top: 20px">${event.disasterType} </span><p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">发现途径： </label>
                            <span style=" margin-top: 20px">${event.findWay}  <p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">发生位置：   </label>
                            <span style=" margin-top: 20px">${event.areaId} <p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">所在小班：   </label>
                            <span style=" margin-top: 20px">${event.classId} <p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">影响面积：   </label>
                            <span style=" margin-top: 20px">${event.eventArea} <p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">初步损失：   </label>
                            <span style=" margin-top: 20px">${event.eventLoss} <p/>
                            <label class="layui-form-label"style="width: 80px; margin-top: 20px">专家建议：   </label>
                            <span style=" margin-top: 20px">${event.plan} <p/>
                        </div>
                </div>
                </div>
            </div>

                <!--右边区域-->
                <div  style="position: relative;left:10%;float: left">
                    <div class="layui-form-item">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label">灾区图片：   </label>
                                    <img src="${event.photoPath}" style="width: 120px;height: 140px"><p/>


                            </div>
                    </div>

                </div>

            </div>
        </div>
    </div>
</div>
<!-- 表格部分结束 -->
<!--提交按钮-->
<div class="layui-form-item layui-layout-admin">
    <div class="layui-input-block">
        <div class="layui-footer" style="left: 0;">
            <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">修改</button>
        </div>
    </div>
</div>
<!--提交按钮结束-->

<div class="layui-card-body" style="left:42%;position: relative; top:-300px ;padding: 15px;">
    <form id="f1" class="layui-form" action="eventUpdateServlet" lay-filter="component-form-group">
        <label class="layui-form-label">发生位置</label>
        <div class="layui-input-inline">
            <select name="quiz">
                <option value="">请选择</option>
                <option value="1">layer</option>
                <option value="2">form</option>
                <option value="3">layim</option>
            </select>
        </div><p/>
        <label class="layui-form-label" style="margin-top: 50px">防治方案</label>
        <div class="layui-input-block">
            <textarea name="text" placeholder="请输入内容" class="layui-textarea" style="width: 400px;margin-top: 50px"></textarea>
        </div>
    </form>
</div>






<script src="layuiadmin/layui/layui.js"></script>
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
</body>
</html>