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
    <title>修改事件</title>
</head>
<body>


<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>修 改 事 件</h1></div>
                <!--左边区域-->
                <div  style="position: relative;left:6%;float: left;width: 30%">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-inline" style="position: relative;left:15px">
                                <label class="layui-form-label" style="width: 60%;text-align:left;">事件名称：${event.eventName}</label>
                                <label class="layui-form-label" style="width: 60%; margin-top: 20px;text-align:left;">时间:${event.occurTime}</label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="disasterType">灾害类型：</label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="findWay">发现途径：  </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="areaId">发生位置：   </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="classId">所在小班：   </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;">影响面积：${event.eventArea}   </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;">初步损失：${event.eventLoss}   </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;">专家建议：${event.plan}   </label>

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



<div style="left:42%;position: relative; top:-300px ;padding: 15px;">
    <form id="f1" class="layui-form" action="eventUpdateServlet" >
        <div class="layui-inline" >
            <label>发现途径</label>
            <div class="layui-input-inline" style="width:65%;">
                <select name="findWay" >
                    <option value="">直接选择或搜索选择</option>
                    <option value="1">小班巡查发现</option>
                    <option value="2">公众发现</option>
                    <option value="3">上级部门巡查通报</option>
                </select>
            </div>
        </div><p/>
        <div class="layui-inline" style="margin-top: 50px;" >
            <label>防治方案</label>
            <div class="layui-input-block">
                <textarea name="text" placeholder="请输入内容" class="layui-textarea" style="width: 400px;margin-top: -16px;margin-left: -49px"></textarea>
            </div>

        </div>

    </form>
</div>
<!--提交按钮-->
<div class="layui-form-item layui-layout-admin">
    <div class="layui-input-block">
        <div class="layui-footer" style="left: 0;">
            <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">修改</button>
        </div>
    </div>
</div>
<!--提交按钮结束-->




<script>
    $(document).ready(function () {
        alert(1);

    });

</script>

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