//父页面中table中每行数据的id字符串
var fatherStr="";
//子页面中复选框被选中的id字符串
var sonStr="";


/**
 * 如果checkBox触发onchange()函数
 * @param obj 当前checkbox对象
 * @constructor
 */
//当checkbox被选中 添加进去id
function AddSonStr(obj){
    var b=obj.checked;
    //如果改变后是选中状态则将该checkBox的val添加进子类字符串
    if(b){
        $(obj).attr("name","box")
        sonStr+=obj.value+",";
        // idArr.push(obj.value)
    }
    //如果改变后是未选中状态则删除在子类字符串中的该对象的value
    else{
        $(obj).removeAttr("name");
        sonStr=  sonStr.replace(obj.value+",","")
    }
}


//通过class遍历得到父页面中table中每一行物品的id
function eachfatherId() {
    $(".fatherClassId").each(function () {
        fatherStr += this.value + ",";
        // fatherIdArr.push(this.value)

    })
}

    //通过class遍历的将子页面中选中的复选框设置为未选中
    //将物品名设置为空
    function eachSonCheckBox() {
        $(".sonCheckBox").each(function () {
            var ck = this.checked
            if (ck) {
                this.checked = false
            }
        })}



/**
 * 传入Json对象得到 html字符串
 * @param JSonObj JSon对象
 * @returns {string} html支持费
 */
//得到父页面的html语句
function getFatherTableHtml(JSonObj) {
            var str = "";
            var trdd = "trdd"
            for (let i = 0; i < JSonObj.length; i++) {
                str += "<tr onclick=sendId('" + trdd + JSonObj[i].drugId + "') id='" + trdd + JSonObj[i].drugId + "'>"
                // str+="<tr onclick='sendId("+JSonObj[i].drugId+trdd+")'"+"id='"+JSonObj[i].drugId+trdd+"'>";
                str += "<td>" + JSonObj[i].drugName + "</td>";
                str += "<td>" + JSonObj[i].drugType + "</td>";
                str += "<td>" + JSonObj[i].drugCureType + "</td>";
                str += "<td><input type='number'   onblur='getMax(this)' value='1' name='DrugCounts'><span style='color: red'></span></td>";
                str += "<td hidden><input type='hidden' name='AlldrugId' class='fatherClassId' value='" + JSonObj[i].drugId + "'></td>"
                str += "<td hidden><input type='number' class='MaxNum' value='" + JSonObj[i].drugNum + "'></td>"
                str += "</tr>";
                //alert(JSonObj[i].drugId+trdd)
            }
            // alert(str)
            return str;
    }


/**
 * 得到模态框的html语句
 * @param JsonObj Json对象
 * @returns {string}  模态框页面中拼接html字符串
 */
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

/**
 * 将选中行的id发送给隐藏标签
 */
//将选中行的id发送给隐藏标签
function sendId(tridid) {
    // alert(tridid)
    $("#trfactherId").val(tridid)
}


/**
 * 去重
 * @param sStr 模态框中的checkBox选中id字符串 即是 sonStr
 * @param fStr 父类中存在的数据的id字符串 fatherStr
 * @returns {*} 新的模态框中选中状态去重后的 sonStr
 * @constructor
 */
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