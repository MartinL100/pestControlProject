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
    <title>事件信息</title>
</head>
<body>
<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>事件记录</h1></div>
                <!--左边区域-->
                <div  style=" position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label" style="width: 60%;text-align:left;">事件名称：${event.eventName}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">时&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp间：${event.occurTime}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">灾害类别：${disasterType}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">灾害状态：${disasterStage}</label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">发现途径：${findWay}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">发生位置：${area}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">所在小班：${className}   </label>
                                <label class="layui-form-label" style="width: 60%;text-align:left;">影响面积：${event.eventArea}  </label>
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
                                <img  style="width: 120px;height: 130px;margin-left: -3cm;margin-top: 1cm" src="/img/${event.photoPath}"><p/></div>
                            <label class="layui-form-label" style="width: 60%;text-align:left;margin-top: -20px">事件描述：${event.eventDescribe}   </label>
                            <label class="layui-form-label" style="width: 60%;text-align:left;">初步损失：${event.eventLoss}   </label>
                            <label class="layui-form-label" style="width: 60%;text-align:left;">专家建议：${event.plan}   </label>
                            <label class="layui-form-label" style="width: 60%;text-align:left;">防治方案：${event.plan}   </label>
                        </div>
                        </div>
                    </div>
                </div>
                <!-- 表格部分-->
                <div class="layui-card-body">
                    <table class="layui-table">
                        <colgroup>
                            <col >
                            <col>
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>会商人员</th>
                            <th>会商结果</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${conferenceResults}" var="conf">
                                <td>
                                        ${conf.conferenceDate}
                                </td>
                                <td>
                                       <c:forEach items="${conf.specialistList}" var="sp">
                                           ${sp.specialistName}&nbsp;
                                       </c:forEach>
                                </td>
                                <td>
                                        ${conf.conferenceResult}
                                </td>
                            </c:forEach>
                        </tbody>
                    </table>
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
            <form  action="eventMainServlet" method="post">
            <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">返回</button>
            </form>
        </div>
    </div>
</div>
<!--提交按钮结束-->








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