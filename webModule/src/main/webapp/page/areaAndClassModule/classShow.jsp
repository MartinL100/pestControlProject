<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html lang="en">
<head>
 <jsp:include page="../../head.jsp"></jsp:include>
    <title>小班信息</title>
</head>
<body>
<Main style="width: 90% ;margin: auto">

    <div class="layui-fluid">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md12">
                <div class="layui-card">
                    <div class="layui-card-header" align="center"><h1>查看小班信息</h1></div>

    <!--左边区域-->
    <div  style="position: relative;width:400px;left:5%;float: left ;" >
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px;width: 200px" >
                    <label class="layui-form-label"style="margin-top: 20px;height: 25px">名称：${classShow.sclassName}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px;width: 100px">负责人电话：${classShow.sclassLeaderTel}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">负责区域：${classShow.area.areaName}</label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">地类：${classShow.area.selectedType.typeVal}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">创建时间：${classShow.sclassStartDate}   </label><p/>


                </div>
            </div>
        </div>

    </div>

    <!--右边区域-->
    <div  style="position: relative;width:400px;left:15%;float: left">
        <div class="layui-form-item">
            <div class="layui-inline">
                <div class="layui-inline" style="position: relative;left:15px">
                    <label class="layui-form-label"style="margin-top: 20px; height: 25px">负责人：${classShow.sclassLeader}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">人员数量：${classShow.sclassNum}   </label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">林种：${classShow.area.areaTreeType}</label><p/>
                    <label class="layui-form-label"style="margin-top: 80px;height: 25px">优势树种：${classShow.area.areaGoodTree}   </label><p/>

                </div>
            </div>
        </div>

    </div>

                    <!--提交按钮-->
                    <div class="layui-form-item layui-layout-admin">
                        <div class="layui-input-block">
                            <div class="layui-footer" style="left: 0;">
                                <form  action="findClassServlet" method="post">
                                    <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1" id="buttonID0">返回</button>
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