
//初始化
function initHeader(){
    var LayuiNavMore = $(".header-li");
    console.log(LayuiNavMore);
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });

}

function mycenter(){
    localStorage.setItem("usercardId",0);
}
function myinformation(){
    localStorage.setItem("usercardId",1);
}
//注销
function ReLogin(){
    layui.use(['layer'], function(){
    var layer = layui.layer;
        layer.alert('确认要注销吗？',{icon: 0,offset: clientHeight/5},
            function (){
                $.ajax({
                    type:'post',
                    url: url + "/user",
                    dataType:'json',
                    data: {method:'logout'},
                    success:function (obj) {
                        localStorage.removeItem('userJson');
                        layer.closeAll();
                        window.location.href = "/jsp/mainPage.jsp";
                    }
                });
            }
        );
    });
}