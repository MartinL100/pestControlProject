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
                    <div class="layui-card-header" align="center"><h1>查看小班信息</h1></div>

    <!--左边区域-->
    <div  style="position: relative;width:400px;left:15%;float: left">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px">
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px">名称：${event.eventName}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px;width: 100px">负责人电话：${event.occurTime}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">负责区域：${event.disasterStage}</label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">林地：${event.findWay}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">地类：${event.areaId}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">创建时间：${event.areaId}   </label><p/>


                </div>
            </div>
        </div>
    </div>

    <!--右边区域-->
    <div  style="position: relative;width:400px;left:15%;float: left">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px">
                    <label class="layui-form-label"style="margin-top: 20px; height: 25px">负责人：${event.eventName}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">人员数量：${event.occurTime}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">林种：${event.disasterStage}</label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">优势树种：${event.findWay}   </label><p/>

                </div>
            </div>
        </div>

    </div>

                    <!--提交按钮-->
                    <div class="layui-form-item layui-layout-admin">
                        <div class="layui-input-block">
                            <div class="layui-footer" style="left: 0;">
                                <form  action="eventMainServlet" method="post">
                                    <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">返回</button>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</Main>




<script src="../../layuiadmin/layui/layui.js"></script>
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