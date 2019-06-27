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
    <title>添加物品页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <%--<link rel="stylesheet" href="../../layuiadmin/layui/css/layui.css" media="all">--%>
    <%--<link rel="stylesheet" href="../../layuiadmin/style/admin.css" media="all">--%>
    <%--<script src="../../js/jquery.js"></script>--%>
    <%@include file="../../head.jsp"%>
</head>


<body>


<div class="layui-fluid" id="LAY-component-layer-list">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <h1 align="center">添加出库信息</h1>

                <div class="layui-form layui-card-header layuiadmin-card-header-auto">
                    <form action="outwarehouseAddServlet.lovo" method="post" id="addInformationFromId">
                        <div class="layui-form-item">
                            <label class="layui-form-label">领用班级:</label>
                            <div class="layui-inline">
                                <input type="hidden" value="${currentPage}" name="currentPage">
                                <input type="hidden" value="${checkType}" id="checkTypeId" name="checkType">
                                <input type="hidden" id="trfactherId" name="trId">
                                <!-- 下拉框开始 -->
                                <div>
                                    <select name="SelectedClassName" id="selectId" style="display: block;width: 200px;float: left" class="layui-input">
                                        <c:forEach items="${ClassNameList}" var="ClassName">
                                            <option value="${ClassName.typeKey}">${ClassName.typeVal}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!-- 下来狂结束 -->
                            </div>

                            <div class="layui-inline">
                                <label class="layui-form-label">出库人:</label>
                                <div class="layui-input-block">
                                    <span>${userObj.userName}</span>
                                </div>
                            </div>


                            <!-- 物品信息表开始-->
                            <div class="layui-card-body">
                                <table class="layui-table">
                                    <colgroup>
                                        <col width="150">
                                        <col width="150">
                                        <col width="200">
                                        <col>
                                    </colgroup>
                                    <thead>
                                    <tr>
                                        <th>物品名称</th>
                                        <th>类型</th>
                                        <th>防治类型</th>
                                        <th>领用数量</th>
                                        <th hidden>当前行ID</th>
                                        <th hidden>最大数量</th>
                                    </tr>
                                    </thead>
                                    <tbody id="fatherTBodyId">
                                    <!-- 遍历传入的出入库信息集合  -->
                                    <c:forEach items="${MessageVoList}" var="MessageVo">
                                        <tr value="${MessageVo.drugId}" name="${MessageVo.drugId}">
                                            <input type="hidden" value="${MessageVo.drugId}" name="drugId"  class="fatherClassId"></input>
                                            <!-- 出库物品名称 -->
                                            <td>${MessageVo.getDrugName()}</td>
                                            <!-- 出库物品类型 -->
                                            <td>${MessageVo.getDrugType()}</td>
                                            <!-- 防治类型 -->
                                            <td>${MessageVo.getDrugCureType()}</td>
                                            <!-- 领用数量 -->
                                            <td> <input type="number" name="DrugNum" value="${MessageVo.ObjectCount}"></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <!-- 物品表格数据结束 -->
                        </div>
                    </form>

                    <!-- 按钮开始 -->
                    <div class="layui-card-body">
                        <div class="layui-btn-container layadmin-layer-demo">
                            <button type="button" class="layui-btn layui-btn-primary" onclick="openModak()">添加物品</button>
                            <button class="layui-btn layui-btn-primary" id="removeByn">移除物品</button>
                            <button class="layui-btn layui-btn-primary" id="outBtn">出库</button>

                        </div>
                    </div>
                    <!-- 按钮结束 -->




























                    <!--模仿bootstrap的模态框-->

                    <!--                  =======================================                            --->

                    <form action="outwarehouseAddObjServlet.lovo"  method="post" id="addObjForm">
                    <div id="motaikunag" style="display: none;">
                        <!--<div class="layui-row layui-col-space15">-->
                        <!--<div class="layui-col-md12">-->
                        <!--<div class="layui-card">-->
                        <!-- 表单开始 -->
                            <div class="layui-form-item">
                                <div class="layui-inline">
                                    <input type="hidden" value="${newCurrentPage}" name="currentPage" id="sonCurrentPage">
                                    <input type="hidden" id="checkType" name="PageTag">
                                </div>

                                <!-- 物品信息表开始-->
                                <div class="layui-card-body">
                                    <table class="layui-table">
                                        <colgroup>
                                            <col width="150">
                                            <col width="150">
                                            <col width="200">
                                            <col>
                                        </colgroup>
                                        <thead>
                                        <tr>
                                            <th>&nbsp;&nbsp;</th>
                                            <th>物品名称</th>
                                            <th>类型</th>
                                            <th>防治类型</th>
                                            <th>主要用途</th>
                                        </tr>
                                        </thead>
                                        <tbody id="MotaiTableView">
                                        <!-- 遍历传入的出入库信息集合  -->
                                        <c:forEach items="${drugList}" var="drug">
                                            <tr value="${drug.getDrugId()}" name="${drug.getDrugId()}" >
                                                <td><input style="display: block" class="sonCheckBox" type="checkbox" onchange="AddName(this)" value="${drug.getDrugId()}"></td>
                                                <!-- 物品名称 -->
                                                <td>${drug.getDrugName()}</td>

                                                <!-- 物品类型 -->
                                                <td>${drug.getDrugType()}</td>
                                                <!-- 防治品类型 -->
                                                <td>${drug.getDrugCureType()}</td>
                                                <!--  物品主要用途-->
                                                <td>${drug.getDrugUseWay()}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>


                                <!-- 物品表格数据结束 -->
                                <div style="margin-bottom: 50px;margin-top: 50px">
                                    <button type="button" class="layui-btn layui-btn-primary" id="prevBtn"
                                            onclick="pageSubmit('prev')"> &nbsp;<&nbsp;</button>
                                    &nbsp;&nbsp; &nbsp;&nbsp;
                                    &nbsp;&nbsp; &nbsp;&nbsp;<input type="number" style="width: 35px;height: 32px"
                                    name="currentPage" value="${newCurrentPage}" id="currentPage">
                                    &nbsp;&nbsp; &nbsp;&nbsp; <span style="width: 35px;height: 32px;font-size:15px">&nbsp;&nbsp;/ ${MaxPage}</span>
                                    &nbsp;&nbsp; &nbsp;&nbsp;
                                    <button type="button" onclick="pageSubmit('')"class="layui-btn layui-btn-primary" id="skipBtn"> &nbsp;跳转&nbsp;</button>&nbsp;&nbsp;
                                    &nbsp;&nbsp;
                                    &nbsp;&nbsp; &nbsp;&nbsp;
                                    <button type="button" class="layui-btn layui-btn-primary" id="nextBtn" value="next"
                                            onclick="pageSubmit('next')">&nbsp;&nbsp;>&nbsp;&nbsp;
                                    </button>
                                </div>


                                <!-- 物品名称开始 -->
                                <label class="layui-form-label">物品名称:</label>
                                <div>
                                    <input type="text" name="drugName" id="drugName"
                                           style="display: block;width: 200px;float: left" class="layui-input">

                                </div>
                                <!-- 物品名称结束 -->


                                <!-- 下拉框开始 -->
                                <label class="layui-form-label">类型:</label>
                                <div>
                                    <select name="drugType" id="drugType"
                                            style="display: block;width: 200px;float: left" class="layui-input">
                                        <c:forEach items="${drugTypeList}" var="drugType">
                                            <option value="${drugType.getTypeVal()}">${drugType.getTypeVal()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!-- 下拉框结束 -->

                                <!-- 防治类型下拉框开始 -->
                                <label class="layui-form-label"
                                       style="margin-bottom: 50px;margin-top: 80px;right: 620px">防治类型:</label>
                                <div style="position: relative;right: -110px;top: -90px">
                                    <select name="drugCureType" id="drugCureType"
                                            style="display: block;width: 200px;float: left" class="layui-input">
                                        <c:forEach items="${drugCureTypeList}" var="cureType">
                                            <option>${cureType.getTypeVal()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <!-- 防治类型下拉框结束 -->
                            </div>

                        <!-- 表单结束 -->
                        <!-- 按钮开始 -->
                        <div class="layui-card-body">
                            <div class="layui-btn-container layadmin-layer-demo">
                                <div  style="position: relative;right: -80px;top: -50px">
                                <button type="button" class="layui-btn layui-btn-primary" id="findBtn" onclick="pageSubmit('findBtn')">查询</button>
                                <button type="button" class="layui-btn layui-btn-primary" id="getBtn">领取</button>
                                    </div>
                            </div>
                        </div>
                        <!-- 按钮结束 -->
                    </div>
                    </form>



                </div>

            </div>
        </div>

    </div>


</div>
</div>
</div>

<script src="../../layuiadmin/layui/layui.js"></script>
<script>

    // var idArr=new  Array();
    // var fatherIdArr=new Array();
    var fatherStr="";
    var sonStr="";

    //打开模态框
    function openModak() {
        $("[name='testname']").val("xxxxxxxxxxxxxxx");//向模态框中赋值
        layui.use(['layer'], function () {
            var layer = layui.layer, $ = layui.$;
            layer.open({
                type: 1,//类型
                area: ['800px', '600px'],//定义宽和高
                title: '添加物品',//题目
                shadeClose: false,//点击遮罩层关闭
                content: $('#motaikunag')//打开的内容
            });
        })
       // $("#addObjForm").submit();
    }

    //关闭模态框
    function  closeModak() {
        layer.closeAll()
    }


    function AddName(obj){
      var b=obj.checked;
      if(b){
          $(obj).attr("name","box")
          sonStr+=obj.value+",";
          // idArr.push(obj.value)
      }
      else{
          $(obj).removeAttr("name");
         sonStr=  sonStr.replace(obj.value+",","")
      }
    }

    //出库按钮
    $("#outBtn").click(function () {
       var cName= $("#selectId").val();
        if(null==cName&&''==cName){
            return;
        }
        trid= $("#checkTypeId").val("outBtn");
        $("#addInformationFromId").submit();
        // trid= $("#checkTypeId").val("");
        // location.href='outwarehouseAddServlet.lovo'
    });

    //移除按钮
    $("#removeByn").click(function () {
        //得到隐藏标签中的当前选中的trid
       var trid= $("#trfactherId").val();
       //alert(trid)
        if(null==trid&&""==trid){

        }
       //移除当前行
        $("#"+trid).remove();
        trid= $("#trfactherId").val("");
    })


    //领取按键
    $("#getBtn").click(function () {
    //关闭模态框
        var htmlstr="";
        layer.closeAll()
        $("#checkType").val("getBtn");
        var  SonTy = $("#checkType").val();
        eachfatherId();
        // sonStr=sonStr.substring(0,sonStr.length-1);
        // fatherStr=fatherStr.substring(0,fatherStr.length-1);
        //1 FactherStrPkSonStr();
       // alert(sonStr)
        //发送ajax请求
        sonStr=RemoveDistinctUnionOfObjects(sonStr,fatherStr);
       // alert(sonStr)
        $.post('outwarehouseAddObjServlet.lovo',{'PageTag':SonTy,'sonStr':sonStr,'fatherStr':fatherStr},function(resultHtml){
          // alert(resultHtml)
         var JSonobj=  eval("("+resultHtml+")")
           $("#fatherTBodyId").append(getFatherTableHtml(JSonobj));
        });
        //将字符重新赋值
        sonStr="";
        fatherStr="";
        //将所有选中的多选框checked设置为false
        eachSonCheckBox();

    });


    //分页&查询
    function pageSubmit(tag) {
        if(null!=tag&&""!=tag) {
            $("#checkType").val(tag);
            var drugCureTypes= $("#drugCureType").val();
            var drugTypes= $("#drugType").val();
            var drugNames=$("#drugName").val();
            var  SonTy = $("#checkType").val();
            var currentPages=$("#currentPage").val();
            $.post('outwarehouseAddObjServlet.lovo',{'PageTag':SonTy,"drugCureType":drugCureTypes,"drugType":drugTypes,"drugName":drugNames,"currentPage":currentPages},function(resultHtml){
            var JSonobj=  eval("("+resultHtml+")")
            //$("#fatherTBodyId").append(getFatherTableHtml(JSonobj));
            $("#MotaiTableView").html(getSonTableHtml(JSonobj))
            <%--//拼接模态框内容--%>
            });
        }  <%--}--%>
    }

    //通过class遍历得到父页面中table中每一行物品的id
    function eachfatherId() {
    $(".fatherClassId").each(function () {
        fatherStr+=this.value+",";
       // fatherIdArr.push(this.value)

    })
        //alert(fatherStr.length)
        // console.log(fatherStr)
        // console.log(sonStr)
    }

    //通过class遍历的将子页面中选中的复选框设置为未选中
    //将物品名设置为空
    function eachSonCheckBox() {
        $(".sonCheckBox").each(function () {
           var ck= this.checked
            if(ck){
                this.checked=false
            }
        })
        $("#drugName").val("");
    }




    //得到父页面的html语句
    function getFatherTableHtml(JSonObj) {
        var  str="";
        var trdd="trdd"
        for (let i = 0; i <JSonObj.length ; i++) {
            str+="<tr onclick=sendId('"+trdd+JSonObj[i].drugId+"') id='"+trdd+JSonObj[i].drugId+"'>"
            // str+="<tr onclick='sendId("+JSonObj[i].drugId+trdd+")'"+"id='"+JSonObj[i].drugId+trdd+"'>";
            str+="<td>"+JSonObj[i].drugName+"</td>";
            str+="<td>"+JSonObj[i].drugType+"</td>";
            str+="<td>"+JSonObj[i].drugCureType+"</td>";
            str+="<td><input type='number'   onblur='getMax(this)' value='1' name='DrugCounts'><span style='color: red'></span></td>";
            str+="<td hidden><input type='hidden' name='AlldrugId' class='fatherClassId' value='"+JSonObj[i].drugId+"'></td>"
            str+="<td hidden><input type='number' class='MaxNum' value='"+JSonObj[i].drugNum+"'></td>"
            str+="</tr>";
            //alert(JSonObj[i].drugId+trdd)
        }
       // alert(str)
        return str;
    }


    //得到模态框的html语句
    function getSonTableHtml(JsonObj) {
        var  str="";
        for (let i = 0; i <JsonObj.length ; i++) {
            str+="<tr>";
            str+="<td><input style='display: block' class='sonCheckBox' type='checkbox' onchange=AddName(this) value='"+JsonObj[i].drugId+"'></td>"
            str+="<td>"+JsonObj[i].drugName+"</td>";
            str+="<td>"+JsonObj[i].drugType+"</td>";
            str+="<td>"+JsonObj[i].drugCureType+"</td>";
            str+="<td>"+JsonObj[i].drugUseWay+"</td>";
            str+="</tr>"
        }
        return str;

    }


  //将选中行的id发送给隐藏标签
    function sendId(tridid) {
       // alert(tridid)
        $("#trfactherId").val(tridid)
    }


    //验证当前value最大数
    function getMax(obj) {
        // var sev= $("#selectId").val()
        // alert(sev)
      var currentCount=   $(obj).val();
      var maxCount= $(obj).parent().next().next().children().val()
        //alert(maxCount)
        if(currentCount>maxCount){
            $(obj).next().text("最多可以领取"+maxCount+"个")
            $(obj).val("")
        }
        else{
            $(obj).next().html("")
        }
    }



    //去重
    function RemoveDuplicates(str1,str2) {
        //做比较的两个数组
        var array1 = str1.split("\\,");//数组1
        var array2 = str2.split("\\,");//数组2
        //临时数组存放
        var tempArray1 = [];//临时数组1
        var tempArray2 = [];//临时数组2
        for(var i=0;i<array2.length;i++){
            tempArray1[array2[i]]=true;//将数array2 中的元素值作为tempArray1 中的键，值为true；
        }


        for(var i=0;i<array1.length;i++){
            if(!tempArray1[array1[i]]){
                tempArray2.push(array1[i]);//过滤array1 中与array2 相同的元素；
            }
        }
        var tempStr="";
        for (var i=0; i <tempArray2.length ; i++) {
            tempStr+=tempArray2[i]+","
        }
       tempStr= tempStr.substring(0,tempStr.length);
        sonStr=tempStr;
    }


    function RemoveDistinctUnionOfObjects(sStr,fStr){
       sStr= sStr.substring(0,sStr.length-1)
        var l=-1;
        if(sStr.length>fStr.length){
            l=sStr.length
        }
        else{
            l=fStr.length
        }
        //console.log(fStr)
        var array=new Array();
        array = sStr.split(',');//数组1
        // alert(sStr)
        // alert(array.length)
        // alert(array)
        //遍历判断子字符串中是否在父字符串中存在
      for (var i=0; i <array.length; i++) {
          //如果存在将这个字符设置为空
        // var b=  ((fStr.search(array[i]))==-1)
          var b=fStr.search(array[i]);
          //alert(b)
          if(b!=-1){
               sStr=sStr.replace(''+array[i]+'','');
              // alert(b)
              // alert("b = "+(fStr.indexOf(array[i]))==-1+"\n"+fatherStr)
          }
      }
      //将新的子字符串赋值给原先的子字符串
        //console.log(sStr)
      return sStr;
  }


</script>


</body>
</html>