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
<html>
<head>
    <meta charset="utf-8">
    <title>表单组合</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
</head>
<body>

<div align="center"><h1>添 加 事 件 信 息</h1></div></div>
        <div class="layui-card-body" style="padding: 15px;">
            <form id="f1" class="layui-form" action="eventAddServlet"method="post" enctype="multipart/form-data" lay-filter="component-form-group">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">事件名称</label>
                            <div class="layui-input-block">
                                <input id="eventName" type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label"></label>

                            <div class="layui-input-inline" >
                            &nbsp
                            </div>
                                <div>
                            <label class="layui-form-label">发生时间</label>
                                    <div class="layui-input-inline">
                                <input type="text" name="occurTime" id="LAY-component-form-group-date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                            </div>
                                </div>
                        </div>
                        <!--头像-->
                        <div  class="layui-inline">
                            <input type="file" name="fileName"  />

                        </div>
                        <!--头像-->
                    </div>

                <!--发生区域、小班-->
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">发生位置</label>
                        <div class="layui-input-inline" >
                            <select id="area" name="areaId" lay-verify="required" lay-search="" lay-filter="aihao" class="layui-form">
                                <option value="" >请选择</option>
                                <c:forEach items="${areaList}" var="a">
                                    <option value="${a.areaId}" onclick="fullClass(this)">${a.areaName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline" style="position: relative;left:15px">
                        <label style="margin-left: -6px" class="layui-form-label">所在小班:</label><label  name="classId" id="theClass"  class="layui-form-label" ></label>
                    </div>
                </div>



                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">灾害类型</label>
                        <div class="layui-input-inline">
                            <select name="disasterType" lay-verify="required" lay-search="">
                                <option value="">请选择</option>
                                <c:forEach items="${disasterTypeList}" var="t">
                                    <option value="${t.typeKey}">${t.typeVal}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">灾情阶段</label>
                        <div class="layui-input-inline">
                            <select name="disasterStage" lay-verify="required" lay-search="">
                                <option value="">直接选择或搜索选择</option>
                                <c:forEach items="${disasterStageList}" var="s">
                                    <option value="${s.typeKey}">${s.typeVal}</option>
                                </c:forEach>

                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发现途径</label>
                        <div class="layui-input-inline">
                            <select name="findWay" lay-verify="required" lay-search="">
                                <option value="" >直接选择或搜索选择</option>
                               <c:forEach items="${findWayList}" var="f">
                                   <option value="${f.typeKey}">${f.typeVal}</option>
                               </c:forEach>

                            </select>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">初步损失</label>
                        <div class="layui-input-block">
                            <input  id="loss" type="text" name="eventLoss" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline" style="position: relative;left:10px">
                        <label class="layui-form-label">影响面积</label>
                        <div class="layui-input-block">
                            <input id="eventArea" type="text" name="eventArea" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline"style="position: relative;left:20px">
                        <label class="layui-form-label">防治方案</label>
                        <div class="layui-input-block">
                            <input id="plan" type="text" name="plan" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <!--灾情描述文本-->
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">输入灾情描述</label>
                    <div class="layui-input-block">
                        <textarea name="eventDescribe" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <%--数据验证信息--%>
                <error>
                    <h3 style="color: red" id="error" ></h3>
                </error>


                <!--提交按钮-->
                <div class="layui-form-item layui-layout-admin">
                    <div class="layui-input-block">
                        <div class="layui-footer" style="left: 0;">
                            <form  action="" method="">
                                <button id="ad" class="layui-btn" lay-submit="" lay-filter="component-form-demo1">立即提交</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!--提交按钮结束-->
                <hide>
                    <input type="text" id="classId" name="classId" value="1" />
                </hide>
            </form>

        </div>


<script>
    $(document).ready(function () {
        $("#img").hide();
        $("#classId").hide();
    });
    // 提交按钮触发事件
    $("#ad").click(function () {
         var yes="yes";

       $.each( $(":textarea"),function () {
          if($(this).val()==null||$(this).val()==""){
              yes="no"
          }
       });
        if(yes=="yes"){
            alert(yes);
        $(f1).submit();}else {
            sendErroInfo("请选择下拉选项")
        }
    });
    // 选择区域触发事件
   function fullClass(areaId){

        $.post("eventFindClassByAreaServlet",{"areaId":areaId},function (result) {
           json=eval("("+result+")");
           $("#classId").val(json.sclassId);
            $("#theClass").text(json.sclassName);
        })
    };
    //名称格式输入验证
    $("#eventName").change(function () {
        var str= $("#eventName").val();
        check(str);
    });
    $("#loss").change(function () {
        var str= $("#loss").val();
        check(str);
    });
    $("#eventArea").change(function () {
        var str= $("#eventArea").val();
        check(str);
    });
    $("#plan").change(function () {
        var str= $("#plan").val();
        check(str);
    });






    function check(str) {
            var uPattern = /^[a-zA-Z0-9\u4E00-\u9FA5]{2,16}$/;
            if(!uPattern.test(str)){
              sendErroInfo("仅支持两位汉字、数字、字母的组合")
            }

    }
    function IsDate(){
        var str = $("#LAY-component-form-group-date").val().trim();
        if(str.length!=0){
            var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
            var r = str.match(reg);
            if(r==null){
                $("#error").text('对不起，您输入的日期格式不正确!');
            }else{
                $("#error").text('');
            }
        }
    }
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
        form.on('select(aihao)',function () {
            var option=$("#area option:selected");

            var areaId=option.val();
           fullClass(areaId);

        })

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });

    });

</script>

</body>
</html>
