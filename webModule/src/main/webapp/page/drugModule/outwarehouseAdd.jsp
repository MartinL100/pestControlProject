<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
//http://ip+port+projectName
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>出入库管理主页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%--<link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">--%>
    <%--<link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
    <%--<script src="../../js/jquery.js"></script>--%>
    <%@include file="../../head.jsp"%>
</head>


<body>



<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">



                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <form action="addInformation.lovo" method="post" id="addInformationFromId">
                        <div class="layui-form-item">
                            <label class="layui-form-label">领用班级:</label>
                            <div class="layui-inline">
                                <input type="hidden" value="${currentPage}" name="currentPage">
                                <input type="hidden" value="${checkType}" id="checkTypeId">
                                <!-- 下拉框开始 -->
                                <div>
                                    <select name="ClassName" id="selectId" style="display: block;width: 200px;float: left" class="layui-input">
                                        <c:forEach items="${ClassNameList}" var="ClassName">
                                            <option value="${ClassName.getTypeKey()}">${ClassName.getTypeVal()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!-- 下来狂结束 -->
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">出库人:</label>
                                <div class="layui-input-block">
                                    <span>${userObj.userName}</span>
                                </div>
                            </div>


                            <!-- 物品信息表开始-->
                            <div class="layui-card-body">
                                <table class="layui-table">
                                    <colgroup>
                                        <col width="150">
                                        <col width="150">
                                        <col width="200">
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>物品名称</th>
                                        <th>类型</th>
                                        <th>防治类型</th>
                                        <th>领用数量</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 遍历传入的出入库信息集合  -->
                                    <c:forEach items="${MessageVolist}" var="MessageVo">
                                        <tr onclick="sendId(${MessageVo.getId()})">
                                            <!-- 出库物品名称 -->
                                            <td>${MessageVo.ObjectName}</td>
                                            <!-- 出库物品类型 -->
                                            <td>${MessageVo.ObjectType}</td>
                                            <!-- 防治类型 -->
                                            <td>${MessageVo.PreventionType}</td>
                                            <!-- 领用数量 -->
                                            <td><input type="text" value=${MessageVo.ObjectCount}></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- 物品表格数据结束 -->
                        </div>
                    </form>


                    <%--<div  type="hidden" style="background-color: red;border: #f2f2f2;display: none;" id="HiddenDivId">--%>
                        <%--<div  class="layui-form layui-card-header layuiadmin-card-header-auto">--%>
                            <%--<!-- 表单开始 -->--%>
                            <%--<form action="addInformation.lovo" method="post" id="outwarehouseAddObjFromId">--%>
                                <%--<div class="layui-form-item">--%>
                                    <%--<div class="layui-inline">--%>
                                        <%--<input type="hidden" value="${currentPage}" name="currentPage">--%>
                                        <%--<input type="hidden"  id="checkType">--%>
                                    <%--</div>--%>



                                    <%--<!-- 物品信息表开始-->--%>
                                    <%--<div class="layui-card-body">--%>
                                        <%--<table class="layui-table">--%>
                                            <%--<colgroup>--%>
                                                <%--<col width="150">--%>
                                                <%--<col width="150">--%>
                                                <%--<col width="200">--%>
                                                <%--<col>--%>
                                            <%--</colgroup>--%>
                                            <%--<thead>--%>
                                            <%--<tr>--%>
                                                <%--<th></th>--%>
                                                <%--<th>物品名称</th>--%>
                                                <%--<th>类型</th>--%>
                                                <%--<th>防治类型</th>--%>
                                                <%--<th>主要用途</th>--%>
                                            <%--</tr>--%>
                                            <%--</thead>--%>
                                            <%--<tbody>--%>
                                            <%--<!-- 遍历传入的出入库信息集合  -->--%>
                                            <%--<c:forEach items="${MessageVolist}" var="MessageVo">--%>
                                                <%--<tr>--%>
                                                    <%--<td><input type="checkbox" style="display: block"></td>--%>
                                                    <%--<!-- 出库物品名称 -->--%>
                                                    <%--<td>${MessageVo.ObjectName}</td>--%>
                                                    <%--<!-- 出库物品类型 -->--%>
                                                    <%--<td>${MessageVo.ObjectType}</td>--%>
                                                    <%--<!-- 防治类型 -->--%>
                                                    <%--<td>${MessageVo.PreventionType}</td>--%>
                                                    <%--<!-- 领用数量 -->--%>
                                                    <%--<td>${MessageVo.ObjectWays}</td>--%>
                                                <%--</tr>--%>
                                            <%--</c:forEach>--%>
                                            <%--</tbody>--%>
                                        <%--</table>--%>
                                    <%--</div>--%>



                                    <%--<!-- 物品表格数据结束 -->--%>
                                    <%--<div style="margin-bottom: 50px;margin-top: 50px">--%>
                                        <%--<button type="button" class="layui-btn layui-btn-primary" id="prevPage" onclick="paging('prevPage')"> &nbsp;<&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;--%>
                                        <%--&nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px" name="currentPage" value="${Page.currentPage}" id="currentPage">--%>
                                        <%--&nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;/ ${Page.MaxPage}</span>--%>
                                        <%--&nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="lastPage" value="lastBtn" onclick="paging('lastPage')"> &nbsp;>|&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;--%>
                                        <%--&nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextPage" value="nextBtn"  onclick="paging('nextPage')">&nbsp;&nbsp;>&nbsp;&nbsp;</button>--%>
                                    <%--</div>--%>


                                    <%--<!-- 物品名称开始 -->--%>
                                    <%--<label class="layui-form-label">物品名称:</label>--%>
                                    <%--<div>--%>
                                        <%--<input type="text" name="ObjectName" id="ObjectName" style="display: block;width: 200px;float: left" class="layui-input">--%>

                                    <%--</div>--%>
                                    <%--<!-- 物品名称结束 -->--%>


                                    <%--<!-- 下拉框开始 -->--%>
                                    <%--<label class="layui-form-label">类型:</label>--%>
                                    <%--<div>--%>
                                        <%--<select name="drugType" id="drugType" style="display: block;width: 200px;float: left" class="layui-input">--%>
                                            <%--<c:forEach items="${drugTypeList}" var="drugType">--%>
                                                <%--<option>${drugType.getValue()}</option>--%>
                                            <%--</c:forEach>--%>
                                        <%--</select>--%>
                                    <%--</div>--%>
                                    <%--<!-- 下拉框结束 -->--%>

                                    <%--<!-- 防治类型下拉框开始 -->--%>
                                    <%--<label class="layui-form-label">防治类型:</label>--%>
                                    <%--<div>--%>
                                        <%--<select name="drugCureType" id="drugCureType" style="display: block;width: 200px;float: left" class="layui-input">--%>

                                            <%--<c:forEach items="${drugCureTypeList}" var="drugcureType">--%>
                                                <%--<option>${drugcureType.getValue()}</option>--%>
                                            <%--</c:forEach>--%>

                                        <%--</select>--%>
                                    <%--</div>--%>
                                    <%--<!-- 防治类型下拉框结束 -->--%>
                                <%--</div>--%>
                            <%--</form>--%>
                            <%--<!-- 表单结束 -->--%>

                            <%--<!-- 按钮开始 -->--%>
                            <%--<div class="layui-card-body">--%>
                                <%--<div class="layui-btn-container layadmin-layer-demo">--%>
                                    <%--<button type="button" class="layui-btn layui-btn-primary" id="findBtn">查询</button>--%>
                                    <%--<button type="button" class="layui-btn layui-btn-primary" id="getBtn">领取</button>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<!-- 按钮结束 -->--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container layadmin-layer-demo">
                            <button class="layui-btn layui-btn-primary" id="addBtn" data-type="test20">添加物品</button>
                            <button type="button" class="layui-btn layui-btn-primary" id="removeBtn">移除物品</button>
                            <button  type="button" class="layui-btn layui-btn-primary" id="outBtn">出库</button>
                        </div>
                    </div>
                    <!-- 按钮结束 -->

                </div>
            </div>
        </div>




            </div>
        </div>
    </div>

<%--<script src="../../layuiadmin/layui/layui.js"></script>--%>
<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,layer = layui.layer;

        element.render();

        // /* 触发弹层 */
        // var active = {
        //     // test19: function(){
        //     //     layer.open({
        //     //         type: 2,
        //     //         title: '贤心博客',
        //     //         shadeClose: true,
        //     //         shade: 0.8,
        //     //         area: ['375px', '500px'],
        //     //         content: 'http://www.layui.com/'
        //     //     });
        //     // },
        //    test20: function(){
        //         layer.open({
        //             type: 2,
        //             title: '添加物品',
        //             shade: false,
        //             maxmin: true,
        //             area: ['90%', '90%'],
        //             content: '../../page/drugModule/outwarehouseAddObj.jsp'
        //
        //         });
        //     }
        //
        //
        // };


        $('#LAY-component-layer-list .layadmin-layer-demo .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] && active[type].call(this);
        });

    });


    $("#removeBtn").click(function () {
        alert(123)
    });

    $("#addBtn").click(function () {
        $("#HiddenDivId").show()
    });
</script>


</body>
</html>