<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String basePathIMG = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/img/";
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
        <div class="layui-card-body" style="padding: 15px;overflow: hidden;">
            <form class="layui-form" action="conferenceMain" method="post" lay-filter="component-form-group" id="fid">
                <input type="hidden" value="" name="addResultOrRevert" id="addResultOrRevert"/>
                <input type="hidden" value="${findEvent}" name="findEvent" id="findEventId"/>
                <input type="hidden" value="" name="specialist" id="specialist">


                <div style=" position: relative;width:40%;left:15%;float: left">
                    <div class="layui-form-item" style="margin-top: 20px">
                        <div class="layui-inline">
                            <label class="layui-form-label"
                                   style="text-align:left;width: 90%">事件名称&nbsp;&nbsp;&nbsp;${conferenceDto.eventName}</label><br/>
                            <label class="layui-form-label"
                                   style="text-align:left;width: 90%">时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${conferenceDto.occurTime}</label><br/>
                            <label class="layui-form-label"
                                   style="text-align:left;width: 90%">发生位置&nbsp;&nbsp;&nbsp; ${conferenceDto.areaName}</label><br/>
                            <label class="layui-form-label"
                                   style="text-align:left;width: 90%">灾情描述&nbsp;&nbsp;&nbsp; ${conferenceDto.eventDescribe}</label><br/>
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label" style="text-align:left;">会商结果</label>
                        <div class="layui-input-block" style="display: inline-block;margin-left: 0px">
                            <textarea style="width:200px;" name="conferenceResult" placeholder="请输入内容"
                                      class="layui-textarea" id="textId"></textarea>
                        </div>
                    </div>
                </div>


                <div style="position: relative;width:50%;left:15%;float: left;margin-top: 20px">
                    <div class="layui-inline">
                        <div>
                            <label class="layui-form-label" style="text-align:left;">灾区图片</label>
                            <img src="<%=basePathIMG%>${conferenceDto.photoPath}"
                                 style="display: inline-block; width: 120px;height: 120px">
                        </div>
                        <label class="layui-form-label"
                               style="text-align:left;width: 90%">影响面积 ${conferenceDto.eventArea}</label><br/>
                        <label class="layui-form-label" style="text-align:left;">会商人员</label>

                        <div style="overflow: hidden;display: inline-block">

                            <div id="box1" style="float: left;
                           width: 110px; height:150px;overflow-y:auto; border: 1px #b2b2b2 solid">
                                <c:forEach items="${specialistList}" var="c">
                                    <p style="margin: 0px"><input type="checkbox" onchange="inputChange(this)"
                                                 value="${c.specialistId}"/><span>${c.specialistName}</span></p>
                                </c:forEach>
                            </div>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="dtid"
                                    style="float: left; width:40px;margin-top:40px">添加
                            </button>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" type="button" id="butId"
                                    style="float: left; width:40px;margin-top:90px;margin-left: -40px">删除
                            </button>
                            <div style=" float: left;
                            width: 110px; height:150px;overflow-y:auto; border: 1px #b2b2b2 solid" id="box2">

                            </div>
                        </div>
                    </div>


                    <div style="margin-left: 10px">
                        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:120px;margin-top:40px" onclick="resultAdd('resultAdd')">添加会商信息
                        </button>

                        <button class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:80px;margin-top:40px" onclick="back('revert')">返回
                        </button>
                    </div>
                </div>


                <div style="float: left; overflow-y: auto;height: 20%;width: 100%">
                    <table class="layui-table">
                        <thead>
                        <tr>
                            <th>日期</th>
                            <th>会商人员</th>
                            <th>会商结果</th>
                        </thead>
                        <tbody>
                        <c:forEach items="${resultList}" var="c">
                            <tr>
                                <td>
                                        ${c.conferenceDate}
                                </td>
                                <td>
                                    <c:forEach items="${c.specialistList}" var="d">
                                        ${d.specialistName},
                                    </c:forEach>
                                </td>
                                <td>
                                        ${c.conferenceResult}
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </form>
        </div>
    </div>
</div>

<script>
    function back(r) {
        $("#addResultOrRevert").val(r);
    }

    $("#dtid").click(function () {
        //获取box1中被选中的节点
        var box1Check = $("#box1 :checked");
        $.each(box1Check,function (){
            //将选中的节点添加到box2
            $("#box2").append(this.parentNode);

        });

    });
$("#butId").click(function () {
    //获取第box2中所有input
    var box2Unchecked = $("#box2 input");


    $.each(box2Unchecked, function () {

        //判断是否是选中的
        var key = this.checked;

        if (key == false) {
            //将未选中的节点添加到box1
            $("#box1").append(this.parentNode)
        }

    })
});

    function resultAdd(r) {

        var textVal = $("#textId").val();
        var bl = true;
        if (textVal == null || textVal.length == 0) {
            bl=false;
            sendErroInfo("请输入会商结果");
        }else {
            bl=true;
        }
        if (bl) {
            var a = "";
            var specialistId = $(":checked");
            specialistId.each(function () {
                a = a + this.value + ",";
            });
            a = a.substring(0, a.length - 1);
            $("#specialist").val(a);
            $("#addResultOrRevert").val(r);
            $("#fid").submit();
        }
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
