//弹出错误信息，传入需要弹出的错误信息即可
function sendErroInfo(info) {

    if(info!=null&&info!=""){

        layui.use('layer', function(){
            var layer = layui.layer;

            layer.msg(info,{icon: 5});
        });
    }

}

