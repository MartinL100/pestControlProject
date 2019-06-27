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
    <title>添加物品页面</title>
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
                    <!-- 表单开始 -->
                    <form action="outwarehouseAddObjServlet.lovo" method="post" id="AddObjFromId">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <input type="hidden" value="${newCurrentPage}" name="currentPage">
                                <input type="hidden"  id="checkType" name="PageTag">
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
                                            <th>&nbsp;&nbsp;</th>
                                            <th>物品名称</th>
                                            <th>类型</th>
                                            <th>防治类型</th>
                                            <th>主要用途</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <!-- 遍历传入的出入库信息集合  -->
                                        <c:forEach items="${drugList}" var="drug">
                                            <tr value="${drug.getDrugId()}" name="${drug.getDrugId()}" >
                                                <td><input style="display: block" type="checkbox"  onchange="AddName(this)" value="${drug.getDrugId()}"></td>
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
                                &nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px" name="currentPage" value="${newCurrentPage}" id="currentPage">
                                &nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;/ ${MaxPage}</span>
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="skipBtn"> &nbsp;跳转&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="next" onclick="pageSubmit('next')">&nbsp;&nbsp;>&nbsp;&nbsp;</button>
                            </div>


                            <!-- 物品名称开始 -->
                            <label class="layui-form-label">物品名称:</label>
                                <div>
                                   <input type="text" name="ObjectName" id="ObjectName" style="display: block;width: 200px;float: left" class="layui-input">

                                </div>
                            <!-- 物品名称结束 -->


                            <!-- 下拉框开始 -->
                            <label class="layui-form-label">类型:</label>
                            <div>
                                <select name="drugType" id="drugType" style="display: block;width: 200px;float: left" class="layui-input">
                                    <c:forEach items="${drugTypeList}" var="drugType">
                                        <option value="${drugType.getTypeVal()}">${drugType.getTypeVal()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- 下拉框结束 -->

                            <!-- 防治类型下拉框开始 -->
                            <label class="layui-form-label">防治类型:</label>
                            <div>
                                <select name="drugCureType" id="drugCureType" style="display: block;width: 200px;float: left" class="layui-input">
                                    <c:forEach items="${drugCureTypeList}" var="cureType">
                                        <option>${cureType.getTypeVal()}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <!-- 防治类型下拉框结束 -->
                            </div>
                    </form>
                    <!-- 表单结束 -->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container layadmin-layer-demo">
                            <button type="button" class="layui-btn layui-btn-primary" id="findBtn">查询</button>
                            <button type="button" class="layui-btn layui-btn-primary" id="getBtn">领取</button>
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

    //关闭子窗口 刷新父窗口
    $("#getBtn").click(function (status) {
        $("#checkType").val("getBtn");
        $("#AddObjFromId").submit();

        if(status=="yes"){
            window.parent.location.reload();//刷新父页面
            var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
            parent.layer.close(index);
        }
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.close(index);

    });


    function pageSubmit(tag) {
        $("#checkType").val(tag)
        // alert( $("#checkType").val())
        $("#AddObjFromId").submit();
    }

    $("#findBtn").click(function () {
        $("#AddObjFromId").submit();
    });

    function AddName(obj) {
      $x= $(obj)
       var b= obj.checked;
       // alert(b)
        if(b){
            $x.attr("name","box")
          // alert($(obj).attr("name"))
        }
        else{
            $x.removeAttr("name")
          // alert($(obj).attr("name"))
        }


    }

</script>


</body>
</html>