<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../../../head.jsp"%>
    <title>事件信息</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>病害信息一览</h1></div>
                <!--左边区域-->
                <div  style=" position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label" style="width: 60%;text-align:left;">名&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp称：${diseaseBean.diseaseName}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">病&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp原：${diseaseBean.diseaseSource}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">发病症状：${diseaseBean.diseaseSymptom}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">发病规律：${diseaseBean.diseaseLaw}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">主要危害：${diseaseBean.diseaseHarm}   </label>

                            </div>
                        </div>
                    </div>
                </div>

                <!--右边区域-->
                <div  style="position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label">灾区图片：   </label>
                                <div style="position: relative;left:120px;top: -20px">
                                    <img  style="width: 120px;height: 130px;margin-left: -3cm;margin-top: 1cm" src="/img/${diseaseBean.diseasePhoto}"><p/></div>
                                <label class="layui-form-label" style="width: 99%;text-align:left;margin-top: -20px">防治措施：${diseaseBean.diseaseMeasure}   </label>

                            </div>
                        </div>
                    </div>
                </div>

                <!-- 表格部分结束 -->
            </div>
        </div>
    </div>
</div>

<!--提交按钮-->
<div class="layui-form-item layui-layout-admin">
    <div class="layui-input-block">
        <div class="layui-footer" style="left: 0;">
            <form  action="diseaseIntitServlet" method="post">
               </a> <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">返回</button>
            </form>
        </div>
    </div>
</div>
<!--提交按钮结束-->









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