$(()=>{
    //页面加载验证码图片
    $('#imgCode')[0].src = timestamp("/user/imgCode");

    $('#imgCode').click(function(){
        this.src = timestamp("/user/imgCode");
    })

    jQuery.validator.addMethod("validCode",function (value,element) {
        let flag = true;
        mingrui.asyncGet('user/checkImgCode',{
            imgCode:value
        },data=>{
            if (data.status != 0){
                flag = false;
            }
        })
        return flag;

    },"验证码输入错误")

    jQuery.validator.addMethod("password", function(value, element) {
        var tel = /^[a-zA-Z]\w{5,9}$/;
        return this.optional(element) || (tel.test(value));
        //校验失败提示信息
    }, "密码格式不正确");

    jQuery.validator.addMethod("userPhoneCode", function(value, element) {
        var tel = /^(137|138|176|135|188|173|191)\d{8}$/;
        return this.optional(element) || (tel.test(value));
    }, "手机格式不正确");

    //验证手机号是否被注册过
    jQuery.validator.addMethod("checkPhoneExist", function(value, element) {
        let flag = true;
        mingrui.asyncGet('user',{userPhoneCode:value},data=>{
            if (data.status == 0){
                if (data.userList.length <= 0){
                    flag =false;
                }
            }
        })
        return flag;
    }, "手机号未注册");

    $('#loginForm').validate({
            //验证规则 -->所有的key | 属性为表单的name值
            rules: {
                userPhoneCode: {
                    required: true,
                    userPhoneCode: true,
                    checkPhoneExist: true
                },
                userPass: {
                    required: true,
                    password: true
                },
            validCode:{
                required:true,
                validCode:true
            }
            },

            //提示信息
            messages: {
                userPhoneCode: {
                    required: '请输入手机号'
                },
                userPass: {
                    required: '请输入密码'
                },
            validCode:{
                required:'请输入验证码'
            }
            },
        submitHandler:function (form) {
                let formData = mingrui.serializeForm('loginForm');
                console.log(formData)
                mingrui.postOrPut('user/login','POST',formData,data=>{
                    if (data.status == 0){
                        console.log(data)

                       mingrui.setCookie(mingrui.USER_LOGIN_KEY,data.userList[0]);

                      let cookie_good_car = $.cookie(mingrui.COOKIE_KEY);
                      if (cookie_good_car){
                          mingrui.postOrPut('goodCar','POST',{
                              goodCar:JSON.parse(cookie_good_car)
                          },data=>{
                              console.log('cookie购物车与用户绑定成功');
                              $.cookie(mingrui.COOKIE_KEY,null);
                          })
                      }
                      window.location.href='/';
                    }else{
                        alert(data.msg)
                    }

                })
        }

    })
});


//为url添加时间戳
function timestamp(url) {
    let getTimestamp = new Date().getTime();
    if (url.indexOf("?") > -1) {
        url = url + "&timestamp=" + getTimestamp
    } else {
        url = url + "?timestamp=" + getTimestamp
    }
    return url;
};