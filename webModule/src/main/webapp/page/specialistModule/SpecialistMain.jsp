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
    <title>专家一览</title>
</head>
<body>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">专家一览</h1>
                <form method="post" action="specialistMain" id="fid">
                    <input type="hidden" value="" name="pageTag" id="hid1"> <!-- 按钮标记 -->
                    <input type="hidden" value="" name="specialistId" id="hid2"> <!-- 选择专家ID标记 -->
                    <input type="hidden" value="${currentPage}" name="currentPage" id="hid3"> <!-- 当前页标记 -->
                    <div class="layui-card-body">
                        <table class="layui-table">
                            <thead>
                            <tr>
                                <th>姓名</th>
                                <th>工作单位</th>
                                <th>专长</th>
                                <th>职务</th>
                                <th>电话</th>
                            </thead>
                            <tbody>
                            <!-- 遍历传入的专家信息集合  -->
                            <c:forEach items="${specialistList}" var="c">
                                <!-- 标记 -->
                                <tr onclick="getCk(${c.specialistId})">
                                    <!-- 专家姓名 -->
                                    <td>${c.specialistName}</td>
                                    <!-- 工作单位 -->
                                    <td>${c.specialistUnits}</td>
                                    <!-- 专长 -->
                                    <td>${c.specialistSpeciality}</td>
                                    <!-- 职务 -->
                                    <td>${c.specialistDuty}</td>
                                    <!-- 电话  -->
                                    <td>${c.specialistTel}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <!-- 翻页按钮部分-->
                    <div style="margin-left: 35%; ">
                        <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="addSpecialist('prev')"><i
                                class="layui-icon">&#xe603;</i></button>
                        &nbsp;&nbsp;
                        <input type="text" style="height: 0.68cm;width: 0.8cm" value="${currentPage}" id="inId"/>
                        <span style="font-size: 16px">/${countRow}页</span>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="pagefash(this)">跳转
                        </button>
                        <button class="layui-btn layui-btn-primary layui-btn-sm" onclick="addSpecialist('next')"><i
                                class="layui-icon">&#xe602;</i></button>
                        <br>
                    </div>
                    <!-- 翻页按钮部分结束 -->


                    <div class="layui-fluid" id="LAY-component-grid-mobile">
                        <div class="layui-row layui-col-space10">

                            <!-- 按钮开始 -->
                            <div style="width: 40%; float: left;margin-top: 4%">
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style="width:140px;margin-left:20px;" onclick="addSpecialist('add')">添加专家
                                </button>
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style="width:140px;margin-left:20px;" onclick="findSpecialist('find')">查看专家信息
                                </button>
                                <span id="sid1" style="color:red"></span>
                                <br/>
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style="width:140px;margin-left:20px;margin-top:35px"
                                        onclick="findSpecialist('update')">修改专家信息
                                </button>
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style="width:140px;margin-left:20px;margin-top:35px"
                                        onclick="findSpecialist('del')">删除专家
                                </button>

                            </div>
                            <!-- 按钮结束 -->
                            <!-- 条件查询框开始 -->
                            <div style="margin-top: 40px;border: solid #b2b2b2;width: 300px;height: 210px; position: relative;left:700px;top: -30px;">
                                <span style=" position:absolute;top:-35px;left:30px">查询专家信息</span>
                                <span style=" position:absolute;top:20px;left:30px">专家姓名</span>
                                <input type="text" name="specialistName" value="${specialistName}"
                                       style=" position:absolute;top:30px;left:140px;width: 140px;height:20px;"/>
                                <span style=" position:absolute;top:75px;left:30px">专长</span>
                                <input type="text" name="specialistSpeciality" value="${specialistSpeciality}"
                                       style=" position:absolute;top:85px;left:140px;width: 140px;height:20px;"/>
                                <span style=" position:absolute;top:130px;left:30px">工作单位</span>
                                <input type="text" name="specialistUnits" value="${specialistUnits}"
                                       style=" width: 140px;height:20px;position:absolute;top:140px;left:140px"/>
                                <button class="layui-btn layui-btn-primary layui-btn-sm"
                                        style=" position:absolute;top:170px;left:200px"
                                        onclick="addSpecialist('findF')">查询
                                </button>
                            </div>
                            <!-- 条件查询框结束-->
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    // 得到选择行的专家ID标记
    function getCk(r) {
        $("#hid2").val(r);
    }

    //添加专家、点击上下页、动态查询标记提交
    function addSpecialist(r) {
        $("#hid1").val(r);
        $("#fid").submit();
    }

    //查看专家信息、修改、删除专家标记提交
    function findSpecialist(r) {
        $("#hid1").val(r);
        var a = $("#hid2").val();
        if (a != null) {
            $("#sid1").text("");
            $("#fid").submit();
        } else {
            $("#sid1").text("请选择行")
        }
    }

    //跳转分页
    function pagefash(obj) {
        //得到要跳转到的指定页面
        var fashYe = $(obj).prev().prev().val();
        $("#hid3").val(fashYe);
        $("#hid1").val(fashYe);
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