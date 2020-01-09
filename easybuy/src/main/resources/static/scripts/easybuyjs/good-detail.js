$(()=>{
    $('.buy .good_count').keydown(function(event) {
        if (event.keyCode == 38){//按下上键
            let maxCount = $(this).parent().prev().find('span').text();
            console.log(parseInt(maxCount) > parseInt(this.value))
            if (parseInt(maxCount) > parseInt(this.value)){
                this.value++;

            }
        }else if(event.keyCode == 40){
            if (1 < parseInt(this.value)){
                this.value--;
            }
        }

    })






    $('.button a').click(()=>{


            //isNaN-->不能转换为number返回true
        if (!isNaN($('.buy .good_count').val())){

            let goodId = $('input[name="good_id"]').val();//获取商品id

            let good_cookie_list = [];//定义购物车数组

            const COOKIE_KEY = 'good_cookie_list';//设置储存cookie的key值



            let get_cookie_good_list = $.cookie(COOKIE_KEY);//从cookie中获取购物车数据
            let flag = false;

            console.log(get_cookie_good_list);
            //获取库存
            let maxCount = $('.buy .good_count').parent().prev().find('span').text();
            //判断用户是否登录
            if (mingrui.userIsLogin()){

                //获取count值
                const count = $('.buy .good_count').val();
                mingrui.postOrPut('goodCar','POST',{
                    goodCar:[{
                        goodId:goodId,
                        count:count,
                        maxCount:maxCount
                    }]
                },data=>{
                    console.log(data)
                })

                //登录 放到redis缓存
            }else{
                //未登录,放到coolie(页面暂时缓存)里面
                if (get_cookie_good_list){//判断 购物车有东西(一开始判断都!=null !代表不能为空)

                    good_cookie_list = JSON.parse(get_cookie_good_list)//获取购物车数据 转为String类型json字符串放入集合

                    for (let i in good_cookie_list){//遍历集合中的商品
                        console.log(good_cookie_list[i].count)
                        if (good_cookie_list[i].goodId == goodId){//如果该数组已经有该商品
                            // good_cookie_list[i].count = good_cookie_list[i].count +1;//在原有的数量上加1
                            let maxCount = $('.buy .good_count').parent().prev().find('span').text();
                            if(parseInt(maxCount) < (parseInt(good_cookie_list[i].count) + parseInt($('.buy .good_count').val()))){

                                good_cookie_list[i].count = maxCount;

                            }else{
                                good_cookie_list[i].count = (parseInt(good_cookie_list[i].count)+parseInt($('.buy .good_count').val()))
                            }
                            flag =true;//说明当前商品已经在购物车
                        }

                    }

                }

                if (!flag){//如果当前商品中没有该商品进入判断
                    //定义要加入的商品
                    let goodObj={//定义一个对象
                        goodId:goodId,//商品id
                        count:$('.buy .good_count').val()//默认为数量1
                    }
                    good_cookie_list.push(goodObj)//将新添加的商品放入购物车集合中
                }
                $.cookie(COOKIE_KEY,JSON.stringify(good_cookie_list));//更新购物车状态  将购物车数据转成String类型json字符串放入cookie中
                console.log(JSON.parse($.cookie(COOKIE_KEY)))

            }

        }
    })
})
