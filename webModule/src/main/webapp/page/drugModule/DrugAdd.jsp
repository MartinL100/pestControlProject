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
    <%--<meta charset="UTF-8">--%>
    <title>药剂/器械添加</title>
    <%--<meta name="renderer" content="webkit">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">--%>
    <%--<link rel="stylesheet" href="/web/layuiadmin/layui/css/layui.css" type="text/css" media="all">--%>
    <%--<link rel="stylesheet" href="/web/layuiadmin/style/admin.css" type="text/css" media="all">--%>
    <%--<script src="/web/lib/jquery.js" type="text/javascript"></script>--%>
    <%@include file="../../head.jsp"%>
</head>
<body>

<div class="layui-fluid" >
    <div class="layui-card">
        <div class="layui-card-header"align="center">  <h2><b>添加药品/器械</b></h2></div>
        <div class="layui-card-body" style="padding: 15px;" >
            <form class="layui-form" action="drugAddServlet.lovo" lay-filter="component-form-group" id="AddFormId">

                <div class="layui-input-inline">
                    <div class="layui-form-item">
                        <label class="layui-form-label">名称</label>
                        <div class="layui-input-inline">
                            <input style="width: 212px" onblur="verifyContent(this)" type="articleName" id="drugName" name="drugName" lay-verify="pass" placeholder="请输入物品名称" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>



                <div class="layui-form-item">
                    <label class="layui-form-label">防治类型</label>
                    <%--<div class="layui-input-block">--%>
                        <div class="layui-inline">
                            <select type="text" id="drugCureType" name="drugCureType" style="display: block; position:absolute;top:70px;left:105px;width: 58%;height: 22px">
                                <c:forEach items="${drugCureTypeList}" var="cureType">
                                    <option value="${cureType.getTypeId()}">${cureType.getTypeVal()}</option>
                                </c:forEach>
                            </select>
                        </select>
                        </div>
                    <%--</div>--%>
                </div>


                <div class="layui-form-item">
                    <label class="layui-form-label">类别</label>
                    <div class="layui-input-block">
                        <div class="layui-inline">
                            <select type="text" id="drugType" name="drugType" style="display: block; position:absolute;top:128px;left:105px;width: 58%;height: 22px">
                                <c:forEach items="${drugTypeList}" var="drugType">
                                    <option value="${drugType.getTypeId()}">${drugType.getTypeVal()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>


                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">主要用途</label>
                    <div class="layui-input-block">
                        <textarea onblur="verifyContent(this)" style="width: 350px;height: 200px" id="purpose" name="DrugUseWay" placeholder="请输入主要内容" class="layui-textarea"></textarea>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">数量</label>
                    <div class="layui-input-block">
                        <input onblur="verifyContent(this)" type="number" placeholder="请输入数量" id="drugNum" name="drugNum" style="width: 205px;height: 34px">
                   <span style="color: red"></span>
                    </div>
                </div>
                <div class="layui-form-item layui-layout-admin">
                    <div class="layui-input-block">
                        <div class="layui-footer" style="left: 0;">
                            <button style=" position:absolute;top: -80px; left:200px" type="button" class="layui-btn layui-btn-primary" id="addBtn">添加</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="/web/layuiadmin/layui/layui.js">

</script>

<script>

    function verifyContent(obj){
       var placeholder=  $(obj).attr("placeholder")
       var  txt=$(obj).text();
       if(''==txt){
           $(obj).attr("placeholder",placeholder)
       }
       alert(placeholder)
    }


    layui.config({
        base: '/web/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,layer = layui.layer
            ,laydate = layui.laydate
            ,form = layui.form;

        form.render(null, 'component-form-group');
        laydate.render({
            elem: '#LAY-component-form-group-date'
        });
    });

    $("#addBtn").click(function () {
        var drugName= $("#drugName").val()
        var drugCureType= $("#drugCureType").val()
        var drugType= $("#drugType").val()
        var drugNum= $("#drugNum").val()
        if(''==drugName){
            $("#drugName").next().eq(0).text("请输入名字")
        }
        if (''!=drugName&&''!=drugNum&&drugNum>0){
            // alert(drugName+"   "+drugCureType+"  "+drugType+"   "+drugNum)
            $("#AddFormId").submit();
          $("#AddFormId").reset();
        }
     else{
         return;
        }
        // location.href="../../page/drugModule/drugPanel.html"
    })
</script>


</body>
</html>
