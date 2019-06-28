<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/27
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
<script>
    //做比较的两个数组
    var array1 = ['a','b','c','d','e'];//数组1
    var array2 = ['d','f','e','a','p'];//数组2


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
    console.log(tempArray2)
</script>
</html>
