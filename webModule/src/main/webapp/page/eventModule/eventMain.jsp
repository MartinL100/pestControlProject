<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../head.jsp"%>

    <title>事件记录</title>
</head>
<body>



<div class="layui-fluid">

    <div class="layui-card">
        <div class="layui-card-header" align="center"><h1>事件记录</h1></div>
        <!-- 表格部分-->
        <div class="layui-card-body">
            <table class="layui-table" id="t1">
                <colgroup>
                    <col width="250">
                    <col width="150">
                    <col width="200">
                    <col>
                </colgroup>
                <thead>
                <tr>
                    <th>事件名称</th>
                    <th>日期</th>
                    <th>发生位置</th>
                    <th>防止方案</th>
                    <th>灾情状态</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${eventsList}" var="e">
                    <tr id="${e.eventId}"onclick="choose(${e.eventId})" >
                        <td>${e.eventName}</td>
                        <td>${e.occurTime}</td>
                        <td><c:if test="${e.areaId==0}">
                           金牛区
                        </c:if>
                            <c:if test="${e.areaId==1}">
                                武侯区
                            </c:if>
                            <c:if test="${e.areaId==2}">
                                郫都区
                            </c:if></td>

                        <td>${e.plan}</td>
                        <td><c:if test="${e.disasterStage==1}">
                            已经得到控制
                        </c:if>
                            <c:if test="${e.disasterStage==2}">
                                防治中
                            </c:if>
                            <c:if test="${e.disasterStage==3}">
                               无法解决申请专家会商
                            </c:if></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- 表格部分结束 -->
<!-- 翻页按钮部分-->
<div align="center">
    <button id="prev" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe603;</i></button>
    &nbsp&nbsp;
    <input type="text"  id="currentPage" style="height: 0.68cm;width: 0.8cm" value=${currentPage} >

    <span id="maxPage" style="font-size: 16px">/${maxPage}</span>
    <button id="jump" class="layui-btn layui-btn-primary layui-btn-sm">跳转</button>
    <button id="next" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe602;</i></button>
    <br>
</div>
<!-- 翻页按钮部分结束 -->

<!-- 按钮部分 -->
<div style="position: relative;left:100px;top:20px">
    <button id="b1" class="layui-btn layui-btn-primary"style="position: relative;left:0px;top:36px" >&nbsp&nbsp&nbsp&nbsp添加事件&nbsp&nbsp&nbsp&nbsp</button>

    <button id="b2" class="layui-btn layui-btn-primary" style="position: relative;left:28px;top:36px">查询事件信息</button>
    <p/>
    <button id="b3" class="layui-btn layui-btn-primary"style="position: relative;left:0px;top:88px">申请专家会审</button>
    <button id="b4" class="layui-btn layui-btn-primary"style="position: relative;left:28px;top:88px">修改事件信息</button>
</div>
<!-- 按钮部分结束 -->

<!--删选方框-->
<div class="layui-col-xs3" style="float: right;margin-right:20%;top:-40px;">

    <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D" >
        <div class="layui-card-header"><h3>查询用户信息</h3></div>
        <form class="layui-form"  >
            <div class="layui-card-body" >
                <div class="layui-inline">
                    <label class="layui-form-label" >事件名称</label>
                    <div class="layui-input-block" style="width:52%;">
                        <input id="eventName" type="text" name="username"  lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline"style="margin-top: 5%">
                    <label class="layui-form-label">灾情状态</label>
                    <div class="layui-input-inline" style="width:52%;">
                        <select name="quiz" id="dx1" >
                            <option value="">请选择</option>
                            <option value="1">已得到控制</option>
                            <option value="2">防治中</option>
                            <option value="3">无法解决申请会商</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline"style="margin-top: 5%">
                    <label class="layui-form-label">发生位置</label>
                    <div class="layui-input-inline" style="width:52%">
                        <select name="quiz" id="dx2">
                            <option value="">请选择</option>
                            <option value="1">电信一区</option>
                            <option value="2">电信二区</option>
                            <option value="3">电信三区</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline"style="margin-top: 5%;">
                    <label class="layui-form-label">开始日期</label>
                    <div class="layui-input-inline" style=" width:52%">
                        <input type="text" name="date" id="startTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline"style="margin-top: 5%">
                    <label class="layui-form-label">结束日期</label>
                    <div class="layui-input-inline"style="width:52%">
                        <input type="text" name="date" id="endTime" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
        </form>
        <button id="find" class="layui-btn layui-btn-primary " style="width: 20%;margin-left: 70%;margin-top:3%">查询</button>
    </div>

</div>
<!--删选方框结束-->
<%--隐藏标签--%>
<hide id="hide1">
<form action="" method="post" id="f1">
    <input id="tid" type="text" name="eventId">

    <input id="showOrUp" type="text" name="showOrUp" >
    <input type="text" id="pageNow" name="currentPage" value="${currentPage}">
</form>
</hide>

<script>

    function split(pagetag) {
        var eventName=$("#eventName").val();
        var disasterStage=$("#dx1").val();
        var areaId=$("#dx2").val();
        var startTime=$("#startTime").val();
        var endTime=$("#endTime").val();
        $.post("eventFindServlet",{ "eventName":eventName, "disasterStage":disasterStage,"areaId":areaId,
            "startTime":startTime,"endTime":endTime,"currentPage":$("#pageNow").val(),"pageTag":pagetag},function (results){
            var jsonStr=eval("("+results+")");
            $("#currentPage").val(jsonStr.currentPage);
            $("#maxPage").text("/"+jsonStr.maxPage);
            $("#pageNow").val(jsonStr.currentPage);
            fullTable(jsonStr.eventsList);
        });
    }
    function fullTable(eventsList) {
        //组织行
        var html="<colgroup><col width=\"250\"><col width=\"150\"><col width=\"200\"><col></colgroup><thead>" +
            "<tr><th>事件名称</th><th>日期</th> <th>发生位置</th> <th>防止方案</th> <th>灾情状态</th></tr></thead>"
        //组装身体
        $.each(eventsList,function () {
            html+="<tr  onclick=choose("+this.eventId+")><td>"+this.eventName+"</td><td>"+this.occurTime+"</td><td>"+this.areaId+"</td>" +
                "<td>"+this.plan+"</td><td>"+this.disasterStage+"</td></tr>"
        });

        //放入到table标签
        html+="</tbody>"
        $("#t1").html(html);
    }
    $(document).ready(function () {
        $("#hide1").hide();
        $.post("eventFindServlet",function (result) {
            var jsonStr=eval("("+result+")");
            $("#currentPage").val(jsonStr.currentPage);
            $("#pageNow").val(jsonStr.currentPage);
            $("#maxPage").text(jsonStr.maxPage);
            fullTable(jsonStr.eventsList);
        } );
    });

    // 翻页触发事件
    $("#prev").click(function () {
        split("prev");
    });
    $("#jump").click(function () {
        split($("#currentPage").val());
    });
    $("#next").click(function () {
        split("next");
    });
    // 选择行触发事件
    function  choose(id) {
        $("#tid").val(id);

    }
    // 添加、查看、修改、申请会审按钮点击
    $("#b1").click(function () {
        location.href="page/eventModule/eventAdd.jsp"
    })
    $("#b2").click(function () {
        if($("#tid").val()!=null){
            $("#f1").attr("action","eventShowServlet");
            $("#showOrUp").val("show");
            $("#f1").submit();}
    });
    $("#b3").click(function () {
        var id=$("#tid").val()
        if($("#tid").val()!=null){
            $.post("eventConferenceServlet",{"eventId":id})
        }
        $("#f1").attr("action","eventConferenceServlet");
        $("#f1").submit();
    });
    $("#b4").click(function () {
        if($("#tid").val()!=null){
            $("#f1").attr("action","eventShowServlet");
            $("#showOrUp").val("update");
            $("#f1").submit();}
    });

    // 查询按钮触发事件
    $("#find").click(function () {
        var eventName=$("#eventName").val();
        var disasterStage=$("#dx1").val();
        var areaId=$("#dx2").val();
        var startTime=$("#startTime").val();
        var endTime=$("#endTime").val();
        $.post("eventFindServlet",{ "eventName":eventName, "disasterStage":disasterStage, "areaId":areaId, "startTime":startTime,"endTime":endTime},function (result) {
            var jsonStr=eval("("+result+")");
            fullTable(jsonStr.eventsList);
            $("#currentPage").val(jsonStr.currentPage);
            $("#pageNow").val(jsonStr.currentPage);
            $("#maxPage").text(jsonStr.maxPage)
        } );
    });



</script>


<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
</script>
<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'form', 'laydate'], function(){
        var $ = layui.$
            ,admin = layui.admin
            ,element = layui.element
            ,layer = layui.layer
            ,laydate = layui.laydate
            ,form = layui.form;

        form.render(null,'component-form-group');

        laydate.render({
            elem: '#startTime'

        });

        laydate.render({
                elem: '#endTime'
        });
    });
</script>
</body>
</html>