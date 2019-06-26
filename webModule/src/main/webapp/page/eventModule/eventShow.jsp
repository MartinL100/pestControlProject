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
                <div  style="position: relative;width:400px;left:15%;float: left">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label"style="height: 25px">事件名称：${event.eventName}   </label><p/>
                                <label class="layui-form-label"style="height: 25px">时&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp间：${event.occurTime}   </label><p/>
                                <label class="layui-form-label"style="height: 25px">灾害类型：${event.disasterStage}</label><p/>
                                <label class="layui-form-label"style="height: 25px">发现途径：${event.findWay}   </label><p/>
                                <label class="layui-form-label"style="height: 25px">发生位置：${event.areaId}   </label><p/>
                                <label class="layui-form-label"style="height: 25px">所在小班：${event.classId}   </label><p/>
                                <label class="layui-form-label"style="height: 25px">影响面积：${event.eventArea}  </label><p/>

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
                                <img  style="width: 120px;height: 130px" src=${event.photoPath}><p/></div>
                            <label class="layui-form-label"style="height: 20px">事件描述：${event.eventDescribe}   </label><p/>
                            <label class="layui-form-label"style="height: 20px">初步损失：${event.eventLoss}   </label><p/>
                            <label class="layui-form-label"style="height: 20px">专家建议：${event.plan}   </label><p/>
                            <label class="layui-form-label"style="height: 20px">防治方案：${event.plan}   </label><p/>

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