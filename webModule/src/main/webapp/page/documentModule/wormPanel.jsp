<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <title>虫害一览管理页面</title>
  <jsp:include page="../../head.jsp"></jsp:include>
</head>

<body>

<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">

                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <!-- 表单开始 -->
                    <form action="idPestis" method="post" id="addInformationFromId">
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <input type="hidden" value="${currentPage}" name="currentPage">
                                <input type="hidden" value="${checkType}" id="checkTypeId">
                                <input type="hidden" value=""  id="pestisId" name="pestisId">
                            </div>



                            <!-- 物品信息表开始-->
                            <div class="layui-card-body">
                                <table class="layui-table">
                                    <colgroup>
                                        <col width="150">
                                        <col width="150">
                                        <col width="200">

                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>寄主</th>
                                        <th>发病规律</th>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach  var="pestisBean" items="${page}"  >
                                        <tr onclick="fing(${pestisBean.id})" >
                                        <td>${pestisBean.pestisName}</td>
                                        <td>${pestisBean.pestisHost}</td>
                                        <td>${pestisBean.pestisHarm}</td>
                                        </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>

                            <!-- 物品表格数据结束 -->

                            <!-- 物品表格数据结束 -->
                            <div style="margin-bottom: 50px;margin-top: 50px">
                                <button type="button" class="layui-btn layui-btn-primary" id="prevBtn"> &nbsp;<&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px" name="currentPage" value="${currentPage}" id="currentPage">
                                &nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;/ ${MaxPage}</span>
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="lastBtn" value="lastBtn"> &nbsp;>|&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="nextBtn">&nbsp;&nbsp;>&nbsp;&nbsp;</button>
                            </div>





                        </div>
                    </form>

                    <!-- 表单结束 -->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container" style="margin-top: 40px">
                           <a href="page/documentModule/wormAdd.jsp"><button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;left:50px">添加新害虫</button></a>
                            <button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;left:100px" onclick="x()">查看详细信息</button>
                        </div>
                    </div>

                    <div style="margin-top: 40px;border: solid #b2b2b2;width: 300px;height: 210px;position:relative;left:380px;top: -80px">
                        <span style=" position:absolute;top:-35px;left:30px">查询虫害信息</span>
                        <span style=" position:absolute;top:20px;left:30px">寄生虫</span>
                        <input type="text" style=" position:absolute;top:30px;left:140px ;width: 140px" >
                        <span style=" position:absolute;top:75px;left:30px">寄主</span>
                        <input type="text" style="position:absolute;top:85px;left:140px;width: 140px"/>

                        <button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:absolute;top:170px;left:200px">查询</button>
                    </div>
                </div>
                <!-- 按钮结束 -->

            </div>
        </div>
    </div>




</div>
</div>
</div>

<script src="wormPanel.jsp"></script>
<script>
    $("#getBtn").click(function () {
        //
        alert(123)
    });
function fing(id) {
    $("#pestisId").val(id)
}
function x() {
    $("#addInformationFromId").submit()
}

</script>


</body>
</html>