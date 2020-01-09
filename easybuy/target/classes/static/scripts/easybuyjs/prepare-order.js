$(()=>{


    $('.wrap :button').click(()=>{
       mingrui.postOrPut('order','POST',{
           ordAdd:$('.user-addr input[name="userAddr"]:checked').val(),
           ordPayType:$('.user-addr').next().find('input[name="payType"]:checked').val()
       },data=>{
           console.log(data)
            if (data.status == 0){
                alert('訂單生成成功')
            }
       })
    })



        mingrui.get('user/addr',{},data=>{
            if (data.status == 0){
                let addrHTML = '选择收货地址<br/>';
                data.userAddressList.forEach((event,index) => {
                    console.log(index)
                    if (index == 0){
                        addrHTML +='<input type="radio" name="userAddr" checked value="'+event.addId+'"/>' +
                            event.addPro + ' ' + event.addCity + ' ' + event.addCounty + ' ' + event.addCountry + '<br/>'
                    }else{
                        addrHTML +='<input type="radio" name="userAddr"  value="'+event.addId+'"/>' +
                            event.addPro + ' ' + event.addCity + ' ' + event.addCounty + ' ' + event.addCountry + '<br/>'
                    }


                })

                $('.user-add').html(addrHTML);

            }
        })


})
