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
    <title>药剂/器械一览</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%--<link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">--%>
    <%--<link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
    <%--<script src="../../lib/jquery.js"></script>--%>
    <%@include file="../../head.jsp"%>
</head>


<body>



<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">


                </form>
                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <!-- 表单开始 -->
                    <form action="drugPanelPageServlet.lovo" method="post" id="addInformationFromId">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <%--<input type="hidden" value="${page.getCurrentPage()}" name="currentPage">--%>
                                <%--<input type="hidden" value="${page.getAllPage()}" id="MaxPage" name="MaxPage">--%>
                                <%--<input type="hidden" value="${drugTypeID}" id="drugTypeID" name="drugType">--%>
                                <%--<input type="hidden" value="${drugCureTypeID}" id="drugCureTypeID" name="drugCureType">--%>
                                <input type="hidden"  id="checkType" value="${checkType}" name="PageTag">
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
                                        <th>名称</th>
                                        <th>防治类型</th>
                                        <th>类别</th>
                                        <th>主要用途</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 遍历传入的出入库信息集合  -->
                                    <c:forEach items="${drugList}" var="drug">
                                        <tr>
                                            <!-- 物品名称 -->
                                            <td>${drug.getDrugName()}</td>
                                            <!-- 防治品类型 -->
                                            <td>${drug.getDrugCureType()}</td>
                                            <!-- 物品类型 -->
                                            <td>${drug.getDrugType()}</td>
                                            <!--  物品主要用途-->
                                            <td>${drug.getDrugUseWay()}</td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- 物品表格数据结束 -->
                            <div style="margin-bottom: 50px;margin-top: 50px">
                                <button type="button" class="layui-btn layui-btn-primary" id="prevBtn" onclick="pageSubmit('prev')"> &nbsp;<&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px" name="currentPage" value="${page.getCurrentPage()}" id="currentPage">
                                &nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;/ ${MaxPage}</span>
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="skipBtn"> &nbsp;>|&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="next" onclick="pageSubmit('next')">&nbsp;&nbsp;>&nbsp;&nbsp;</button>
                            </div>



                            <!-- 防治类型下拉框结束 -->
                        </div>



                        <div style="margin-top: 40px;border: solid #b2b2b2;width: 300px;height: 210px;position:relative;left:380px;top: 50px">
                            <span style=" position:absolute;top:-35px;left:30px">查询药剂信息</span>
                            <span style=" position:absolute;top:0px;left:30px">药剂名称</span>
                            <span style=" position:absolute;top:60px;left:30px">防治类型</span>
                            <span style=" position:absolute;top:120px;left:30px">类别</span>
                            <input name="drugName" id="drugName" type="text" style=" position:absolute;top:11px;left:105px"/>
                            <select type="text" id="drugCureType" name="drugCureType" style="display: block; position:absolute;top:70px;left:105px;width: 58%;height: 22px">
                                <c:forEach items="${drugCureTypeList}" var="cureType">
                                    <option>${cureType.getTypeVal()}</option>
                                </c:forEach>
                            </select>

                            <select type="text" id="drugType" name="drugType" style="display: block; position:absolute;top:128px;left:105px;width: 58%;height: 22px">
                                <c:forEach items="${drugTypeList}" var="drugType">
                                    <option value="${drugType.getTypeVal()}">${drugType.getTypeVal()}</option>
                                </c:forEach>
                            </select>
                            <!--<input type="date" style=" position:absolute;top:85px;left:140px"/>-->
                            <!--<input type="text" style=" width: 140px;height:20px;position:absolute;top:140px;left:140px"/>-->

                        </div>
                    </form>
                    <!-- 表单结束 -->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container" style="margin-top: 40px">
                            <button id="addBtn" type="button" class="layui-btn layui-btn-primary" style=" position:relative;left:80px;top: -80px">添加药剂</button>
                            <button id="findBtn" type="submit" class="layui-btn layui-btn-primary" style=" position:absolute;top:0px;left:600px">查询</button>
                        </div>

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
    //跳转到添加器械页面
    $("#addBtn").click(function () {
        $("#checkType").val("addBtn")
        $("#addInformationFromId").submit();

    });

    // 提交表单

    $("#findBtn").click(function () {
      var drugType=  $("#drugType").val();
       var drugCureType  = $("#drugCureType").val();
       var name=  $("#drugName").val();
       // alert( drugType+"   "+drugCureType+"   "+name)
        $("#addInformationFromId").submit();
    });

    function pageSubmit(tag) {
        $("#checkType").val(tag)
       // alert( $("#checkType").val())
        $("#addInformationFromId").submit();
    }

    $("#skipBtn").click(function () {
        var currentPage=  $("#currentPage").val();
        $("#checkType").val(currentPage)
        $("#addInformationFromId").submit();
    });
</script>


</body>
</html>