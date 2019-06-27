<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    <jsp:include page="../../head.jsp"></jsp:include>
    <title>添加区域</title>
    <title>Title</title>
</head>
<body>
<Main style="width: 90% ;margin: auto">
<form id="f1" class="layui-form" action="eventAddServlet" lay-filter="component-form-group">

    <div class="layui-form-item"STYLE="margin-top: 50px">
        <div style="margin-top: 20px;float: left;width: 40%" >
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div style="margin-top: 20px;float: left;width: 48%">
            <label class="layui-form-label">负责人电话</label>
            <div class="layui-input-block">
                <input type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>

    </div>

    <div class="layui-form-item" STYLE="margin-top: 100px">
        <div style="margin-top: 20px;float: left;width: 40%" >
            <label class="layui-form-label">负责人</label>
            <div class="layui-input-block">
                <input type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div style="margin-top: 20px;float: left;width: 48%">
            <label class="layui-form-label">数量</label>
            <div class="layui-input-block">
                <input type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>


    <div style="margin-top: 100px">
        <label class="layui-form-label">负责区域</label>
        <div class="layui-input-inline">
            <select id="areaId" name="areaId">

                <c:forEach var="areaObj" items="${areaList}" >
                    <option value="${areaObj.areaId}">${areaObj.areaName}</option>
                </c:forEach>

            </select>
        </div>
    </div>




    <!--提交按钮-->
    <div class="layui-form-item layui-layout-admin">
        <div class="layui-input-block">
            <div class="layui-footer" style="left: 0;">
                <button id="addButton" class="layui-btn" lay-submit="" lay-filter="component-form-demo1">立即提交</button>
            </div>
        </div>
    </div>
    <!--提交按钮结束-->
</form>



</Main>




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

        form.render(null, 'component-form-group');

        laydate.render({
            elem: '#LAY-component-form-group-date'
        });

    });

</script>
<script>
    layui.config({
        base: 'layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'upload'], function(){
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test-upload-normal'
            ,url: '/upload/'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#test-upload-normal-img').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }
                //上传成功
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#test-upload-demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        //多图片上传
        upload.render({
            elem: '#test-upload-more'
            ,url: '/upload/'
            ,multiple: true
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#test-upload-more-list').append('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
                });
            }
            ,done: function(res){
                //上传完毕
            }
        });

        //指定允许上传的文件类型
        upload.render({
            elem: '#test-upload-type1'
            ,url: '/upload/'
            ,accept: 'file' //普通文件
            ,done: function(res){
                console.log(res)
            }
        });
        upload.render({ //允许上传的文件后缀
            elem: '#test-upload-type2'
            ,url: '/upload/'
            ,accept: 'file' //普通文件
            ,exts: 'zip|rar|7z' //只允许上传压缩文件
            ,done: function(res){
                console.log(res)
            }
        });
        upload.render({
            elem: '#test-upload-type3'
            ,url: '/upload/'
            ,accept: 'video' //视频
            ,done: function(res){
                console.log(res)
            }
        });
        upload.render({
            elem: '#test-upload-type4'
            ,url: '/upload/'
            ,accept: 'audio' //音频
            ,done: function(res){
                console.log(res)
            }
        });

        //设定文件大小限制
        upload.render({
            elem: '#test-upload-size'
            ,url: '/upload/'
            ,size: 60 //限制文件大小，单位 KB
            ,done: function(res){
                console.log(res)
            }
        });

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