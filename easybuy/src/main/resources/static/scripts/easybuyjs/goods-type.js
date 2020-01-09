$(document).ready(function () {
    mingrui.get('good_type',{},function (data) {
        var ddHTML = '';
       if (data.status == 0){
           for (var i in data.goodTypeList){
               ddHTML += '<dd><a href="/product_list?typeId=' + data.goodTypeList[i].typeId + '"  target="main">'+ data.goodTypeList[i].typeName +'</a></dd>';
           }
       }
       $('#main .lefter .box dl').html(ddHTML);
    })
    let user = mingrui.getCookie(mingrui.USER_LOGIN_KEY);
    if (user){
        $('.login_user').hide().next().html(user.userNick +'<a href="/order-list">我的订单</a>');
    }
})