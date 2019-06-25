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
    <meta charset="UTF-8">
    <title>查看出库信息</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%--<link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">--%>
    <%--<link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
    <%--<script src="../../jquery-3.4.1.js"></script>--%>
    <%@include file="../../head.jsp"%>
</head>
<body>
<
<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">



                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <!--<form action="addInformation.lovo" method="post" id="addInformationFromId">-->
                        <div class="layui-form-item">
                            <label>领用小班:</label>&nbsp;&nbsp;
                            <label>${Stockpile.getStockpileClass()} </label>&nbsp;&nbsp; &nbsp;&nbsp;


                            <div class="layui-inline" style="margin-right: 30px">
                                <label > &nbsp;&nbsp; &nbsp;&nbsp;出库人:</label>&nbsp;&nbsp;
                                <label >${Stockpile.getStockpileMan()}</label>&nbsp;&nbsp; &nbsp;&nbsp;
                            </div>

                            <label >出库时间：</label>&nbsp;&nbsp;
                            <label>${Stockpile.getStockpileDate()}</label>&nbsp;&nbsp; &nbsp;&nbsp;



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
                                    <c:forEach items="${Stockpile. getDrugList()}" var="MessageVo">
                                        <tr>
                                            <!-- 出库物品名称 -->
                                            <td>${MessageVo.getDrugName()}</td>
                                            <!-- 出库物品类型 -->
                                            <td>${MessageVo.getDrugType()}</td>
                                            <!-- 防治类型 -->
                                            <td>${MessageVo.getDrugCureType()}</td>
                                            <!-- 领用数量 -->
                                            <td>${MessageVo. getDrugNum()}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- 物品表格数据结束 -->
                        </div>
                    <!--</form>-->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body" align="center">
                        <div class="layui-btn-container layadmin-layer-demo">
                            <button class="layui-btn layui-btn-primary" id="okBtn" data-type="test20">确定</button>
                        </div>
                    </div>
                    <!-- 按钮结束 -->

                </div>
            </div>
        </div>


    </div>
</div>
</div>


<script>
    $("#okBtn").click(function () {
        location.href= 'outwarehousePanelServlet.lovo';
    });
</script>

</body>
</html>