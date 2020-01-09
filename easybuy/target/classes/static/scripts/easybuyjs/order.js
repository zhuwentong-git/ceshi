$(()=>{



    //加载订单信息
    mingrui.get('order',{},data=>{
        if (data.status == 0){
             let orderHTML = '';
        data.orderList.forEach(function(order,index){
            //表头信息
            orderHTML += '<table>\n' +
                '\t\t\t\t<tr>\n' +
                '\t\t\t\t\t<th>'+order.ordCode+'   -    创建时间:'+order.ordCreateDate+',订单过期时间:'+order.ordPastDate+'</th>\n' +
                '\t\t\t\t\t<th>商品总价:'+order.ordMoney+'</th>\n' +
                '\t\t\t\t\t<th>订单状态:'+(order.ordStatus==1?"未支付":order.ordStatus==2?"已支付":"已过期")+'</th>\n' +
                '\t\t\t\t</tr>\n';
            //获取当前订单的订单详情
            mingrui.asyncGet('order/listDetail',{
                ordId:order.ordId
            },function(data){
                console.log(data)
                if(data.status == 0){
                    let orderDetaiHTML = '';

                    //遍历订单详情
                    data.orderDetailList.forEach(function(detail,index){
                        //通过商品id查询商品信息
                        mingrui.asyncGet('good',{
                            goodId:detail.goodId
                        },function(data){

                            if(data.status == 0){
                                //拼接商品详情
                                orderDetaiHTML += '\t\t\t\t<tr>\n' +
                                    '\t\t\t\t\t<td class="thumb"><img width="100px" src="'+data.goodList[0].goodImg+'" /><a href="#">'+detail.goodName+'</a></td>\n' +
                                    '\t\t\t\t\t<td class="price">\n' +
                                    '\t\t\t\t\t\t<span>￥'+detail.goodPrice+'</span>\n' +
                                    '\t\t\t\t\t</td>\n' +
                                    '\t\t\t\t\t<td class="number">\n' + detail.buyCount +
                                    '\t\t\t\t\t</td>\n' +
                                    '\t\t\t\t</tr>\n';
                            }

                        });

                    });
                    if (order.ordStatus == 1){
                        //在每个订单最后一行加一个支付
                        orderDetaiHTML += '<tr><td colspan="4"><input type="button" onclick=toPay('+ order.ordMoney +',"'+ order.ordId +'") style="float: right" value="支付"/></td></tr>';
                    }

                    //将拼接好的商品详情放到表头下
                    orderHTML += orderDetaiHTML;
                }
            });
            //结束标记
            orderHTML += '\t\t\t</table>';
        })
            $('#shopping form').html(orderHTML);
        }
    })
})
function toPay(total,ordId){


    window.location.href='order/pay?ordMoney=' + total + '&ordId=' + ordId;
}