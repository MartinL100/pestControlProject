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
    <title>事件记录</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <form action="conferenceEvent" method="post" id="fid">
                <input type="hidden" name="findEvent" value="" id="conferenceEventId"> <!-- 会商ID -->
                <div class="layui-card">
                    <h1 align="center">事件记录</h1>
                    <div class="layui-card-body">
                        <table class="layui-table">
                            <thead>
                            <tr>
                                <th>事件名称</th>
                                <th>日期</th>
                                <th>发生位置</th>
                                <th>防治方案</th>
                                <th>灾情状态</th>
                            </thead>
                            <tbody>
                            <c:forEach items="${conferenceEventList}" var="c">
                                <tr onclick="findConferenceId(${c.conferenceId})">
                                    <td>${c.eventName}</td>
                                    <td>${c.occurTime}</td>
                                    <td>${c.areaName}</td>
                                    <td>${c.plan}</td>
                                    <td>${c.disasterStage}</td>

                                </tr>


                            </c:forEach>

                            </tbody>
                        </table>
                    </div>


                    <div class="layui-fluid" id="LAY-component-grid-mobile" align="center">
                        <div class="layui-row layui-col-space10">

                            <!-- 按钮开始 -->
                            <div style="width: 40%;">
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style="width:140px;height:35px;" onclick="conferenceEvent()">专家会商
                                </button>


                            </div>
                            <!-- 按钮结束 -->
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


<script>
    function findConferenceId(r) {
        $("#conferenceEventId").val(r);
    }

    function conferenceEvent() {
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