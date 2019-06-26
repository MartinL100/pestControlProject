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
<html>
<head>
    <meta charset="utf-8">
    <title>表单组合</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
</head>
<body>
<style>
    .layui-upload-img{width: 88px; height:66px; margin: 0 10px 10px 0;}
</style>
<div class="layui-fluid">
    <div class="layui-card">
        <div class="layui-card-header"><div align="center"><h1>添 加 事 件 信 息</h1></div></div>
        <div class="layui-card-body" style="padding: 15px;">
            <form id="f1" class="layui-form" action="eventAddServlet"method="post" lay-filter="component-form-group">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">事件名称</label>
                            <div class="layui-input-block">
                                <input type="text" name="eventName" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                            </div>
                            <label class="layui-form-label"></label>

                            <div class="layui-input-inline" >
                            &nbsp
                            </div>
                                <div>
                            <label class="layui-form-label">发生时间</label>
                                    <div class="layui-input-inline">
                                <input type="text" name="occurTime" id="LAY-component-form-group-date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
                            </div>
                                </div>
                        </div>
                        <!--头像-->
                        <div class="layui-inline">
                            <div class="layui-col-md12">
                                <div class="layui-card">
                                    <div class="layui-card-body">
                                        <div class="layui-upload">
                                            <div class="layui-upload-list">
                                                <img class="layui-upload-img" id="test-upload-normal-img" >
                                            </div>
                                            <button name="photoPath" type="button" class="layui-btn" id="test-upload-normal">选择头像</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!--头像-->
                    </div>

                <!--发生区域、小班-->
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">发生位置</label>
                        <div class="layui-input-inline">
                            <select id="areaId" name="areaId">
                                <option value="">请选择</option>
                                <option value="1">layer</option>
                                <option value="2">form</option>
                                <option value="3">layim</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline" style="position: relative;left:15px">
                        <label class="layui-form-label">所在小班:</label><label name="classId" id="theClass"  > </label>
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">灾害类型</label>
                        <div class="layui-input-inline">
                            <select name="disasterType">
                                <option value="">请选择</option>
                                <option value="1">layer</option>
                                <option value="2">form</option>
                                <option value="3">layim</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">灾情阶段</label>
                        <div class="layui-input-inline">
                            <select name="disasterStage" lay-verify="required" lay-search="">
                                <option value="">直接选择或搜索选择</option>
                                <option value="1">layer</option>
                                <option value="2">form</option>
                                <option value="3">layim</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">发现途径</label>
                        <div class="layui-input-inline">
                            <select name="findWay" lay-verify="required" lay-search="">
                                <option value="">直接选择或搜索选择</option>
                                <option value="1">小班巡查发现</option>
                                <option value="2">公众发现</option>
                                <option value="3">上级部门巡查通报</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">初步损失</label>
                        <div class="layui-input-block">
                            <input type="text" name="eventLoss" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline" style="position: relative;left:10px">
                        <label class="layui-form-label">影响面积</label>
                        <div class="layui-input-block">
                            <input type="text" name="eventArea" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-inline"style="position: relative;left:20px">
                        <label class="layui-form-label">防治方案</label>
                        <div class="layui-input-block">
                            <input type="text" name="plan" style="width: 190px" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                </div>


                <!--灾情描述文本-->
                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">输入灾情描述</label>
                    <div class="layui-input-block">
                        <textarea name="eventDescribe" placeholder="请输入内容" class="layui-textarea"></textarea>
                    </div>
                </div>
                <!--提交按钮-->
                <div class="layui-form-item layui-layout-admin">
                    <div class="layui-input-block">
                        <div class="layui-footer" style="left: 0;">
                            <button id="addButton" class="layui-btn" >立即提交</button>
                        </div>
                    </div>
                </div>
                <!--提交按钮结束-->
            </form>
        </div>
    </div>
</div>




<script>
    // 提交按钮触发事件
    $("#addButton").click(function () {
        alert(555);
        $(f1).submit();
    })
    // 选择区域触发事件
    $("#areaId").click(function () {
        var areaId=$("#areaId").val();
        fullClassLabel(areaId)
    })
    //
    function fullClassLabel(areaId) {
        $.post("",{"areaId":areaId },function (result) {
             var jsonStr= eval("("+result+")");

        })

    }
</script>




<script src="layuiadmin/layui/layui.js"></script>
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
