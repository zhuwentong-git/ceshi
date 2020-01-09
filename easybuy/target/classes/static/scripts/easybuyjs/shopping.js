$(()=>{

    $('.button input').click(function(){

        //获取当前选中的购物车信息
        let good_list = [];
        $(':checkbox[name="sel-good"]').each(function(){
            if (this.checked){
                let obj = {
                    goodId:this.value,
                    count:$(this).parent().parent().find('.number input').val()
                }
                good_list.push(obj)
            }
        })
        //判断用户是否登录
        if (mingrui.userIsLogin()){
            //将拼接好购买的商品信息传递到后台
            mingrui.get('product_order',{
                goodList:JSON.stringify(good_list)
            },data=>{
                window.location.href="/product_order";
            })
        }else{
            window.location.href="/product_order";
        }

    })


        let good_car_list = [];
    //用户是否登录
    if (mingrui.userIsLogin()){
        //登录,根据用户id 从redis里获取数据
       mingrui.asyncGet('goodCar',{},data=>{
           if (data.status == 0){
               console.log(data)
               good_car_list = data.goodCarList;
               console.log(good_car_list)
           }
       })

    }else{
        //未登录,从cookie里获取数据
        if (mingrui.getCookie(mingrui.COOKIE_KEY)){
            good_car_list = mingrui.getCookie(mingrui.COOKIE_KEY);

        }

    }


    let carHTML = '';
    for (let i in good_car_list){
        mingrui.asyncGet('good',{
            goodId:good_car_list[i].goodId
        },data=>{
            if (data.status == 0){
                carHTML += '<tr>\n' + '<td><input type="checkbox" checked name="sel-good" value="' + data.goodList[0].goodId + '"/></td>' +
                    '\t\t\t\t\t<td class="thumb"><img  style="width: 100px" src="'+ data.goodList[0].goodImg + '" /><a href="product-view.html">'+ data.goodList[0].goodName +'</a></td>\n' +
                    '\t\t\t\t\t<td class="price">\n' +
                    '\t\t\t\t\t\t<span>￥'+ data.goodList[0].goodPrice +'</span>\n' +
                    '\t\t\t\t\t\t<input type="hidden" value="99" />\n' +
                    '\t\t\t\t\t</td>\n' +
                    '\t\t\t\t\t<td class="number">\n' +
                    '\t\t\t\t\t\t<dl>\n' +
                    '\t\t\t\t\t\t\t<dt><input  type="text" name="number" value="'+ good_car_list[i].count + '" /></dt>\n' +
                    '\t\t\t\t\t\t\t<dd onclick="reloadPrice(1,true);">修改</dd>\n' +
                    '\t\t\t\t\t\t</dl>\n' +
                    '\t\t\t\t\t</td>\n' +
                    '\t\t\t\t\t<td class="delete"><a href="javascript:delShopping(1);">删除</a></td>\n' +
                    '\t\t\t\t</tr>'

            }
        })

    }
    $('#shopping table').append(carHTML);


    let user = mingrui.getCookie(mingrui.USER_LOGIN_KEY);
    if (user){
        $('.shopping_user').hide().next().text(user.userNick);
    }
})