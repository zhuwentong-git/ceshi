$(()=>{
        //鼠标点击事件 获取 验证码
    $('.getCode').click(function() {
        let phone = $(this).prev().val();
        mingrui.get('user/sendChckCode', {
            phone: phone
        }, data => {
            //隐藏发送验证的按钮
            $('.getCode').hide();
            //显示提示信息
            $('.getCode').next().show();
            //显示提示信息-->验证码已经发送，00秒后重新获取
            let timeOut = 60;
            //调用js定时任务实现效果
            let codeInfoTimer = setInterval(function () {
                $('.getCode').next().text('验证码已发送，' + timeOut + '后重新获取');
                timeOut--;
                if (timeOut < 0) {
                    $('.getCode').show();
                    //显示提示信息
                    $('.getCode').next().hide();

                    clearInterval(codeInfoTimer);//停止定时器
                }
            }, 1000);
        })
    })





    jQuery.validator.addMethod("password", function(value, element) {
        var tel = /^[a-zA-Z]\w{5,9}$/;
        return this.optional(element) || (tel.test(value));
        //校验失败提示信息
    }, "密码格式不正确");

    jQuery.validator.addMethod("phone", function(value, element) {
        var tel = /^(137|138|176|135|188|173|191)\d{8}$/;
        return this.optional(element) || (tel.test(value));
    }, "手机格式不正确");

    //验证手机号是否被注册过
    jQuery.validator.addMethod("checkPhoneExist", function(value, element) {
        let flag = true;
        mingrui.asyncGet('user',{userPhoneCode:value},data=>{
            if (data.status == 0){
                if (data.userList.length > 0){
                    flag =false;
                }
            }
        })
        return flag;
    }, "手机号已经被注册");

    //验证手机验证码是否输入正确
    jQuery.validator.addMethod("checkCode", function(value, element) {

        let flag = true;
        let phone = $(element).parent().parent().prev().find('input[name="userPhoneCode"]').val();
        mingrui.asyncGet('user/checkCode',{
            phone:phone,
            code:value
        },data => {
            if(data.status != 0){
                flag = false;
            }
        });

        return flag;
    }, "验证码错误");

    $('#regForm').validate({
        //验证规则 -->所有的key | 属性为表单的name值
        rules:{
            userPhoneCode:{
                required:true,
                phone:true,
                checkPhoneExist:true
            },
            checkCode:{
                required:true,
                checkCode:true
            },
            userPass:{
                required:true,
                password:true
            },
            rePassWord:{
                required:true,
                equalTo: "#passWord"
            }
        },

        //提示信息
        messages:{
            userPhoneCode:{
                required:'请输入手机号'
            },
            checkCode:{
                required:'请输入验证码'
            },
            userPass:{
                required:'请输入密码'
            },
            rePassWord:{
                required:'请输入确认密码',
                equalTo: '两次输入密码不一致'
            }
        },
        submitHandler:function (form) {
            let formData = mingrui.serializeForm('regForm');
             mingrui.postOrPut('user','POST',formData,data=>{
                 if (data.status == 0){
                     window.location.href='/login';
                 }else{
                     alert('注册失败')
                 }
             })
        }
    })
})