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
        <div class="layui-card-body" style="padding: 15px;">
            <form class="layui-form" action="conferenceMain" method="post" lay-filter="component-form-group" id="fid">
                <input type="hidden" value="" name="addResult1" id="addResultId"/>
                <input type="hidden" value="${findEvent}" name="findEvent" id="findEventId"/>
                <div style="float: left;margin-left: 50px">
                    <div class="layui-form-item" style="margin-top: 20px">
                        <div class="layui-inline">
                            <label class="layui-form-label">事件名称</label>${conferenceDto.eventName}
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">时间</label>${conferenceDto.occurTime}
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">发生位置</label>${conferenceDto.areaName}
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">灾情描述</label>${conferenceDto.eventDescribe}
                        </div>
                    </div>

                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">会商结果</label>
                        <div class="layui-input-block">
                            <textarea style="width:200px;" name="conferenceResult" placeholder="请输入内容"
                                      class="layui-textarea"></textarea>
                        </div>
                    </div>
                </div>

                <div style="float: left; margin-left: 340px">
                    <div class="layui-form-item" style="margin-top: 30px">
                        <div class="layui-inline">
                            <label class="layui-form-label">照片</label>
                            <img src="<%=basePathIMG%>${conferenceDto.photoPath}" style="width: 120px;height: 180px">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">影响面积</label>${conferenceDto.eventArea}
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <span class="layui-form-label">会商人员</span>
                        <div class="layui-inline" style="overflow: hidden">
                            <div style="float: left;margin-left: 350px ;
                            width: 100px; height:150px;overflow-y:auto; border: 1px #b2b2b2 solid">
                                <c:forEach items="${specialistList}" var="c">
                                    <input type="checkbox" name="test" onchange="inputChange(this)"
                                           value="${c.specialistId}"/><span>${c.specialistName}</span>
                                </c:forEach>
                            </div>
                            <button style="width:40px;margin-top:40px" onclick="addConferenceSpecialist()">添加
                            </button>
                            <div style="float: right;margin-left: 90px ;
                            width: 100px; height:150px;overflow-y:auto; border: 1px #b2b2b2 solid" id="box2">

                            </div>
                        </div>
                    </div>


                    <div align="center">
                        <button class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:120px;margin-top:40px" onclick="addResult1('addResult1')">添加会商信息
                        </button>

                        <button class="layui-btn layui-btn-primary layui-btn-sm"
                                style="width:80px;margin-top:40px" onclick="addResult1('revert')">返回
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
                        <c:forEach items="${resultList}" var="c">
                            <tr>
                                <td>${c.conferenceDate}</td>
                                <td>
                                    <c:forEach items="${c.specialistList}" var="d">
                                        ${d.specialistName},
                                    </c:forEach>
                                </td>
                                <td>${c.conferenceResult}</td>
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
    //添加会商专家
    var strId = "";
    var strSpecialistName = "";

    function inputChange(obj) {
        strId += obj.value + "-";
        strSpecialistName += $(obj).next().eq(0).text() + "-";

    }

    function addConferenceSpecialist() {
        strSpecialistName = strSpecialistName.substring(0, strSpecialistName.length - 1);
        var specialistArray = strSpecialistName.split("-");
        var s = "";
        specialistArray.each(function () {
            s += "<span>" + this + "</span>"
        });
        $("#box2").html(s);


        // var obj = document.getElementsByName("test");
        // var check_val = [];
        // var check_specialistId = [];
        // //得到选中的专家
        // for (k in obj) {
        //     if (obj[k].checked) {
        //         check_val.push(obj[k].next().text);
        //     }
        //     alert(check_val)
        // }
        //
        // //将数组遍历到另一个div
        // var nameHtml = "<span>";
        // for (a in check_val) {
        //     nameHtml = nameHtml + check_val[a] + "</span><br/>";
        // }
        // $("#box2").innerHTML = nameHtml;
    }


    function addResult1(r) {

        var obj = document.getElementsByName("test");
        var check_specialistId = [];
        //得到选中的专家ID
        var a = "";
        for (k in obj) {
            if (obj[k].checked) {
                a += obj[k].value + ",";
            }
        }
        a = a.substring(0, a.length - 1);
        $.post("conferenceMain", {"specialist": a}, function (r) {
        });
        $("#addResultId").val(r);
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
