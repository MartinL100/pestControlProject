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
    <title>药剂器材管理页面</title>
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
                <h1 align="center">药剂器械出库管理</h1>
                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <!-- 表单开始 -->
                    <form action="outwarehousePanelServlet.lovo" method="post" id="outWareHousePanelFromId">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <%--<input type="hidden" value="${currentPage}" name="currentPage">--%>
                                <input type="hidden" value="${checkType}" name="checkType" id="checkTypeId">
                                <input type="hidden"  name="TrId" id="TrId">
                                <input type="hidden"  name="ClassId" id="ClassId">
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
                                        <th>日期</th>
                                        <th>领用小班</th>
                                        <th>出库人</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <!-- 遍历传入的出入库信息集合  -->
                                    <c:forEach items="${stockpileList}" var="stockpile">
                                        <tr id="${stockpile.getStockpileId()}" onclick="findById(${stockpile.getStockpileId()})">
                                            <!-- 出库启示日期 -->
                                            <td>${stockpile.getStockpileDate()}</td>
                                            <!-- 领用小班 -->
                                            <td>${stockpile.getStockpileClass()}</td>
                                            <!-- 出库人 -->
                                            <td>${stockpile.getStockpileMan()}</td>
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
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="skipBtn" > &nbsp;>|&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="nextBtn" onclick="pageSubmit('next')">&nbsp;&nbsp;>&nbsp;&nbsp;</button>
                            </div>





                            <%--<!-- 下拉框开始 -->--%>
                            <%--<label class="layui-form-label"style="margin-top: 20px">类型:</label>--%>
                            <%--<div style="margin-top: 20px">--%>
                                <%--<select name="drugType" id="drugType" style="display: block;width: 200px;float: left" class="layui-input">--%>
                                    <%--<c:forEach items="${drugTypeList}" var="drugType">--%>
                                        <%--<option>${drugType.getValue()}</option>--%>
                                    <%--</c:forEach>--%>
                                <%--</select>--%>
                            <%--</div>--%>
                            <%--<!-- 下拉框结束 -->--%>

                            <%--<!-- 防治类型下拉框开始 -->--%>
                            <%--<label class="layui-form-label" style="margin-top: 0px">防治类型:</label>--%>
                            <%--<div style="margin-top: 20px">--%>
                                <%--<select name="drugcureType" id="drugcureType" style="display: block;width: 200px;float: left" class="layui-input">--%>

                                    <%--<c:forEach items="${drugCureTypeList}" var="drugcureType">--%>
                                        <%--<option>${drugcureType.getValue()}</option>--%>
                                    <%--</c:forEach>--%>

                                <%--</select>--%>
                            <%--</div>--%>
                            <!-- 防治类型下拉框结束 -->
                        </div>

                    <!-- 表单结束 -->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container" style="margin-top: 40px">
                            <button type="button" class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;left:50px" id="addBtn">添加出库信息</button>
                            <button type="button" class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;left:100px" id="findByIDbtn">查看出库信息</button>
                        </div>
                    </div>
                    <div style="margin-top: 40px;border: solid #b2b2b2;width: 300px;height: 210px;position:relative;left:380px;top: -130px">
                        <span style=" position:absolute;top:-35px;left:30px">查询出库信息</span>
                        <span style=" position:absolute;top:20px;left:30px">起始时间</span>
                        <input  name="startTime" type="date" style=" position:absolute;top:30px;left:140px"/>
                        <span style=" position:absolute;top:75px;left:30px">结束时间</span>
                        <input name="endTime" type="date" style=" position:absolute;top:85px;left:140px"/>
                        <span  style=" position:absolute;top:130px;left:30px">领用小班</span>
                        <input name="className" type="text" style=" width: 140px;height:20px;position:absolute;top:140px;left:140px"/>
                        <button type="button" class="layui-btn layui-btn-primary" style=" position:absolute;top:170px;left:200px" id="findBtn">查询</button>
                    </div>
                    </form>
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


function findById(id) {
        $("#TrId").val(id);
}

$("#findByIDbtn").click(function () {

      var sid=$("#TrId").val();
     // alert(sid)
      if(sid!=0){
          $("#TrId").val(sid);
          $("#checkTypeId").val("findByIDbtn");
          $("#outWareHousePanelFromId").submit();
      }
      else {
          return;
      }
  });

function pageSubmit(PageTag) {
    $("#checkTypeId").val(PageTag)
    // alert( $("#checkType").val())
    $("#outWareHousePanelFromId").submit();
}

$("#skipBtn").click(function () {
    var currentPage=  $("#currentPage").val();
    $("#checkTypeId").val(currentPage)
    $("#outWareHousePanelFromId").submit();
});

$("#addBtn").click(function () {
    location.href="outwarehouseAddServlet.lovo";
});
$("#findBtn").click(function () {
    $("#checkTypeId").val("findBtn")
    $("#outWareHousePanelFromId").submit();
})
</script>
</body>
</html>