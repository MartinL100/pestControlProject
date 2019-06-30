<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/login.css" media="all">
    <script src="../../lib/jquery.js"></script>
    <script src="../../layuiadmin/layui/layui.js"></script>
    <script src="../../lib/userModule/userModule.js"></script>
    <title>Title</title>
</head>
<body>
<Main style="width: 90% ;margin: auto">

    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header" align="center"><h1>修改小班信息</h1></div>

<form action="updateClassServlet" method="post" id="formID00">
    <!--左边区域-->
    <div  style="position: relative;width:400px;left:15%;float: left">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px">
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80%;text-align:left;">名称：${classShow.sclassName}   </label><p/>
                    负责人电话：<input class="layui-form-label"style="margin-top: 80px;height: 35px;text-align:left;" value="${classShow.sclassLeaderTel}" name="sclassLeaderTel"></input><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">负责区域：${classShow.area.areaName}</label><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">地类：${classShow.area.selectedType.typeVal}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">创建时间：${classShow.sclassStartDate}   </label><p/>


                </div>
            </div>
        </div>
    </div>

    <!--右边区域-->
    <div  style="position: relative;width:400px;left:15%;float: left">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px">
                    负责人：<input class="layui-form-label"style="margin-top: 20px; height: 25px ;text-align:left;" value="${classShow.sclassLeader}" name="sclassLeader"></input><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">人员数量：${classShow.sclassNum}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">林种：${classShow.area.areaTreeType}</label><p/>
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px;width: 80% ;text-align:left;">优势树种：${classShow.area.areaGoodTree}   </label><p/>

                </div>
            </div>
        </div>

    </div>
</form>

                    <!--提交按钮-->
                    <div class="layui-form-item layui-layout-admin">
                        <div class="layui-input-block">
                            <div class="layui-footer" style="left: 0;">
                                    <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1" id="updateID9">修改</button>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</Main>



<script>
    $("#updateID9").click(function () {

        $("#formID00").submit();
    });

</script>

<script src="layuiadmin/layui/layui.js"></script>
<script>







    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
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

</script>
<script>
    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'upload'], function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //同时绑定多个元素，并将属性设定在元素上
        upload.render({
            elem: '.test-upload-demoMore'
            ,before: function(){
                layer.tips('接口地址：'+ this.url, this.item, {tips: 1});
            }
            ,done: function(res, index, upload){
                var item = this.item;
                console.log(item); //获取当前触发上传的元素，layui 2.1.0 新增
            }
        })

    });
</script>
</body>
</html>