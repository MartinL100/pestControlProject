
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>静态表格</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">
</head>
<body>



<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header" align="center"><h1>事件记录</h1></div>
                <!-- 表格部分-->
                <div class="layui-card-body">
                    <table class="layui-table">
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
                        <c:forEach items="eventList" var="e">
                            <tr>
                                <td>e.eventName </td>
                                <td>e.occurTime</td>
                                <td><c:if test="${e.areaId==0}">
                                     0
                                </c:if>
                                <c:if test="${e.areaId==1}">
                                     1
                                </c:if>
                                <c:if test="${e.areaId==2}">
                                     2
                                </c:if></td>

                                <td>e.plan</td>
                                <td><c:if test="${e.disasterStage==0}">
                                    0
                                </c:if>
                                    <c:if test="${e.disasterStage==1}">
                                        1
                                    </c:if>
                                    <c:if test="${e.disasterStage==2}">
                                       2
                                    </c:if></td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>


                </div>
            </div>
        </div>
        </div>
    </div>
<!-- 表格部分结束 -->

<!-- 翻页按钮部分-->
    <div align="center">
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe603;</i></button>
        &nbsp&nbsp;
        <input type="text"  style="height: 0.68cm;width: 0.8cm" />
        <span style="font-size: 16px">/66页</span>
        <button class="layui-btn layui-btn-primary layui-btn-sm">跳转</button>
        <button class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon">&#xe602;</i></button>
        <br>
    </div>
<!-- 翻页按钮部分结束 -->
<!-- 按钮部分 -->
<div style="position: relative;left:100px;top:20px">
    <button class="layui-btn layui-btn-primary"style="position: relative;left:0px;top:36px" >&nbsp&nbsp&nbsp&nbsp添加事件&nbsp&nbsp&nbsp&nbsp</button>

    <button class="layui-btn layui-btn-primary" style="position: relative;left:28px;top:36px">查询事件信息</button>
    <p/>
    <button class="layui-btn layui-btn-primary"style="position: relative;left:0px;top:88px">申请专家会审</button>
    <button class="layui-btn layui-btn-primary"style="position: relative;left:28px;top:88px">修改事件信息</button>
</div>
<!-- 按钮部分结束 -->
<!--删选方框-->
<div class="layui-col-xs3" style="float: right;margin-right: 10%;top:-25px;">

    <div class="layui-card" style="border: solid 2px;border-color: #8D8D8D" >
        <div class="layui-card-header">查询用户信息</div>
        <div class="layui-card-body" >
            <!-- 填充内容 -->

            <span>事件名称</span><input type="text"  style="height: 0.68cm;width: 3.5cm;position: relative;left:0px;top:0px;margin-left: 5%;"/><p/><p/>
            <span style="position: relative;top:15px">灾情状态</span><input type="text"   style="height: 0.68cm;width: 3.5cm;position: relative;left:0px;top:15px;margin-left: 5%;" /><p/><p/>
            <span style="position: relative;top:30px">发生位置</span><input type="text"  style="height: 0.68cm;width: 3.5cm;position: relative;left:0px;top:30px;margin-left: 5%;"/><p/><p/>
            <span style="position: relative;top:45px">起始时间</span><input type="date"  style="height: 0.68cm;width: 3.5cm;position: relative;left:0px;top:45px;margin-left: 5%;"/><p/><p/>
            <span style="position: relative;top:60px">结束时间</span><input type="date"  style="height: 0.68cm;width: 3.5cm;position: relative;left:0px;top:60px;margin-left: 5%;"/><p/><p/>

            <button class="layui-btn layui-btn-primary layui-btn-sm" style="width: 20%;margin-left: 70%;margin-top: 30%">查询</button>

            <!-- 填充内容 -->
        </div>
    </div>
</div></div></div>
<!--删选方框结束-->






<script src="../../layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '../../layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index']);
</script>
</body>
</html>