
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
    <base href="<%=basePath%>">
    <title>病害一览管理页面</title>
 <jsp:include page="../../head.jsp"></jsp:include>
</head>

<body>
<%--<form action="getName" method="post" id="xiangqing">--%>
    <%--&lt;%&ndash;得到ID&ndash;%&gt;--%>
<%--<input type="hidden" value="" id="diseaseId" name="diseaseId" >--%>
<%--</form>--%>

<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">

                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <!-- 表单开始 -->
                    <form action="diseaseIndex" method="post" id="queryFromId" >
                        <div class="layui-form-item">
                            <div class="layui-inline">
                                <input type="hidden" value="${page.currentPage}" name="currentPage">
                                <input type="hidden" value="" id="name" name="name">
                                <input type="hidden" value="" id="name1" name="name1">
                                <input type="hidden"  name="pageTag" id="pageTagId">

                            </div>
                            <!-- 物品信息表开始-->
                            <div class="layui-card-body">
                                <table class="layui-table">
                                    <colgroup>
                                        <col width="150">
                                        <col width="150">
                                        <col width="200">
                                        <col width="200">
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>名称</th>
                                        <th>主要危害</th>
                                        <th>发病规律</th>
                                        <th></th>

                                    </tr>
                                    </thead>

                                    <tbody>

                                    <c:forEach items="${list}" var="diseaseBean" >
                                        <tr onclick="fun(${diseaseBean.diseaseId})">
                                            <td>${diseaseBean.diseaseName}</td>
                                            <td>${diseaseBean.diseaseHarm}</td>
                                            <td>${diseaseBean.diseaseLaw}</td>
                                            <%--class="layui-btn layui-btn-primary layui-btn-sm"--%>
                                            <td><a href="/idDisease?diseaseId=${diseaseBean.diseaseId}"><input class="layui-btn layui-btn-primary layui-btn-sm" type="button" value="查看详细信息"/> </a></td>
                                        </tr>

                                    </c:forEach>
                                    </tbody>
                                </table>

                            </div>

                            <!-- 物品表格数据结束 -->
                            <div style="margin-bottom: 50px;margin-top: 50px">
                                <button type="button" class="layui-btn layui-btn-primary" id="prevBtn" onclick="pageF('prev')"> &nbsp;<&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;
                                <%--&nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px" name="currentPage" value="${currentPage}" id="currentPage">--%>
                                &nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;${page.currentPage}/ ${page.allPage}</span>
                                <%--&nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="lastBtn" value="lastBtn"> &nbsp;>|&nbsp;</button>&nbsp;&nbsp; &nbsp;&nbsp;--%>
                                &nbsp;&nbsp; &nbsp;&nbsp; <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="nextBtn" onclick="pageF('next')">&nbsp;&nbsp;>&nbsp;&nbsp;</button>


                            </div>
                        </div>
                    </form>

                    <!-- 表单结束 -->

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container" style="margin-top: 40px">
                          <a href="/page/documentModule/diseaseAdd.jsp"><button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:relative;left:50px">添加新病害</button></a>
                        </div>
                    </div>


                    <div style="margin-top: 40px;border: solid #b2b2b2;width: 300px;height: 210px;position:relative;left:380px;top: -80px">
                        <span style=" position:absolute;top:-35px;left:30px">查询病害信息</span>
                        <span style=" position:absolute;top:20px;left:30px">病害名称</span>
                        <input type="text" style=" position:absolute;top:30px;left:140px ;width: 140px"  name="name" id="qname">
                        <span style=" position:absolute;top:75px;left:30px">发病状态</span>
                        <input type="text" style="position:absolute;top:85px;left:140px;width: 140px" name="name1" id="qname1">

                        <button class="layui-btn layui-btn-primary layui-btn-sm" style=" position:absolute;top:170px;left:200px" name="name2" id="query" onclick="query()">查询</button>

                    </div>

                    </div>
                    <!-- 按钮结束 -->
                </div>
            </div>
        </div>




    </div>
</div>
</div>

<script src="diseasePanel.jsp"></script>
<script>
    $("#getBtn").click(function () {
        //
        alert(123)
    });

function fun(id) {
    $("#diseaseId").val(id);
}


// function findDisease(){
//
//       $("#xiangqing").submit();
//
// }


    function query() {
       var name=$('#qname').val();
       var name1=$('#qname1').val();
       $('#name').val(name);
       $('#name1').val(name1);
        $("#queryFromId").submit();

    }

    function  pageF(tag) {
        //把分页标志放入到隐藏表单
        $("#pageTagId").val(tag);
        //提交查询表单
        $("#queryFromId").submit();
    }

</script>


</body>
</html>