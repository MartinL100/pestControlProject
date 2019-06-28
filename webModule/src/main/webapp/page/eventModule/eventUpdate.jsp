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

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="disasterType">灾害类型：${disasterType}</label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="findWay">发现途径：${findWay}  </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="areaId">发生位置：${area}   </label>

                                <label class="layui-form-label"style="width: 60%; margin-top: 20px;text-align:left;" id="classId">所在小班：${className}   </label>

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
                <select id="findWaySelect" name="findWay" >
                    <option value="">直接选择或搜索选择</option>
                    <option value="1">已得到控制</option>
                    <option value="2">防治中</option>
                    <option value="3">无法解决申请会商</option>
                </select>
            </div>
        </div><p/>
        <div class="layui-inline" style="margin-top: 50px;" >
            <label>防治方案</label>
            <div class="layui-input-block">
                <textarea id="plan" name="plan" placeholder="${event.plan}" class="layui-textarea" style="width: 400px;margin-top: -16px;margin-left: -49px"></textarea>
            </div>
            <hide id="hide">
                <input  id="disasterStage" name="disasterStage" type="text"  value="${event.disasterStage}"  />
                <input  id="findId" type="text"  value="${event.findWay}"  />
            <input  type="text" name="eventId" value="${event.eventId}"  />
            </hide>
        </div>

    </form>
</div>
<!--提交按钮-->
<div class="layui-form-item layui-layout-admin">
    <div class="layui-input-block">
        <div class="layui-footer" style="left: 0;">
            <button id="changeButton" class="layui-btn" lay-submit="" lay-filter="component-form-demo1">修改</button>
        </div>
    </div>
</div>
<!--提交按钮结束-->




<script>
    $(document).ready(function () {
        $("#hide").hide();
       var findid=$("#findId").val();
        $("#findWaySelect").val(findid);


    })
  $("#changeButton").click(function () {
      $("#plan1").val( $("#plan").val());
      if($("#plan").val().length!=0){
        alert($("#disasterStage").val());
      $("#f1").submit();}
  })


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