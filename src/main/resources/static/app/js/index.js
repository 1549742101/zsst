// JavaScript Document
(function () {
    let banner_img=$(".banner_ul>li");
    let banner_ol=$(".banner_ol>li");
    let banner=$(".banner_on>li");
    let index;
    banner.click(function () {
        index = banner.index(this);
        banner_ol.removeClass("active");
        banner_img.removeClass("active");
        banner.removeClass("active");
        $(this).addClass("active");
        banner_img[index].className='active';
        banner_ol[index].className='active';
    });
    function BannerF() {
        banner_ol.removeClass("active");
        banner_img.removeClass("active");
        banner.removeClass("active");
        if (index<3){
            index++;
            banner[index].className='active';
            banner_img[index].className='active';
            banner_ol[index].className='active';
        }else{
            index=0;
            banner[index].className='active';
            banner_img[index].className='active';
            banner_ol[index].className='active';
        }
    }
    setInterval(BannerF,3000);
    // 找标签
    let progressRound = document.querySelector("#progressRound");
    let progressRound1 = document.querySelector("#progressRound1");
    let txt = document.querySelector("#txt");
    let txt1 = document.querySelector("#txt1");
// 进度数据，默认为 0
    let jindu = 0;
    let jindu1 = 0;
// let roundLength = Math.PI*2*100;
    let jinduLength = Math.PI*1.4;
    let goFun = ()=>{
        jindu +=0.5 ;
        let strokeLength = jinduLength*jindu ;
        txt.innerHTML = jindu +"%";
        // 更改环形样式，控制进度变化：实线段长度。
        progressRound.style.strokeDasharray = strokeLength+" 1000";
        // 如果进度为 100 ，那么终止计时器。
        let praise0 = $("#praise0").html();
        if( jindu >= praise0 ){
            clearInterval( myset );
        }
    };
    let goFun1 = ()=>{
        jindu1 +=0.5 ;
        let strokeLength = jinduLength*jindu1 ;
        txt1.innerHTML = jindu1 +"%";
        // 更改环形样式，控制进度变化：实线段长度。
        progressRound1.style.strokeDasharray = strokeLength+" 1000";
        // 如果进度为 100 ，那么终止计时器。
        let praise1 = $("#praise1").html();
        if( jindu1 >= praise1){
            clearInterval( myset1 );
        }
    };
// 启动计时器
    let myset = setInterval(function(){
        goFun();
    },50);
    let myset1 = setInterval(function(){
        goFun1();
    },50);
    let recode = "";
    let booCode = false;
    $(".login_in").click(function () {
        getCode(1);
    });
    $(".reg").click(function () {
        getCode(2);
    })
    function getCode(val) {
        if (val===1){
            $.ajax({
                url:"getReCode",
                type:"post",
                dataType:"text",
                success:function (data) {
                    booCode=false;
                    recode=data;
                    $(".getCode1").html(recode);
                },
                error:function () {
                    booCode=false;
                    errorMsg(1,"验证码获取失败,请联系管理员");
                }
            });
        }
        if (val===2){
            $.ajax({
                url:"getReCode",
                type:"post",
                dataType:"text",
                async: false,
                success:function (data) {
                    booCode=false;
                    recode=data;
                    $(".getCode2").html(recode);
                },
                error:function () {
                    booCode=false;
                    errorMsg(2,"验证码获取失败,请联系管理员");
                }
            });
        }

    }
    function codeTrue(val){
        let code="真的是爱你哟"
        if (val===1){
            code = $(".loginCode").val()+"真的是爱你哟";
        }
        if (val===2){
            code = $(".reCode").val()+"真的是爱你哟";
        }
        $.ajax({
            url:"setReCode",
            data:{
                code:recode,
                recode:code
            },
            type: "post",
            dataType: "json",
            async: false,
            success:function (data) {
                let result = data;
                if (result.code === 200){
                    console.log(result)
                    booCode=true;
                }else {
                    if (val===1){
                        getCode(1);
                        errorMsg(1,"验证码输入错误")
                    }
                    if (val===2){
                        getCode(2)
                        errorMsg(2,"验证码输入错误");
                    }
                }
            },
            error:function () {
                if (val===1){
                    getCode(1);
                    errorMsg(1,"验证码验证失败")
                }
                if (val===2){
                    getCode(2);
                    errorMsg(2,"验证码验证失败")
                }
            }
        })
    }
    $(".loginUserName").focus(function () {
        $(".loginUserName").removeClass("bg-warning");
    })
    $(".loginPassWord").focus(function () {
        $(".loginPassWord").removeClass("bg-warning");
    })
    $(".login").click(function () {
        codeTrue(1);
        let username = $(".loginUserName").val();
        let password = $(".loginPassWord").val();
        if (username.length<5){
            $(".loginUserName").addClass("bg-warning");
            return;
        }
        if (password.length<5){
            $(".loginPassWord").addClass("bg-warning");
            return;
        }
        if (booCode){
            $.ajax({
                url:"login",
                type:"post",
                data:{
                    username:username,
                    password:password,
                    rememberMe:$(".rememberMe").is(':checked')
                },
                success:function (data) {
                    let result = data;
                    if (result.code == 200){
                        $(location).attr("href","index");
                    }else{
                        $("#login").modal("hide");
                        errorMsg(1,result.message);
                    }
                },
                error:function (data) {
                    errorMsg(1,data.message);
                }
            })
        }else {
            //codeTrue(1);
        }
    });
    let booCodePhone = false;
    $("#reg").click(function () {
        codeTrue(2);
        let username = $(".registerUserName").val();
        let password = $(".registerPassWord").val();
        let passwords = $(".registerPassWords").val();
        let phone = $(".registerPhone").val().trim();
        let phoneCode = $(".phoneCode").val().trim();
        PhoneCode(phone,phoneCode);
        if (booCode&&booCodePhone){
            console.log("3333")
            if (password===passwords){
                console.log("4444")
                $.ajax({
                    url:"register",
                    type:"post",
                    dataType:"json",
                    data:{
                        username:username,
                        password:password,
                        phone:phone
                    },
                    success:function (data) {
                        if (data.code===200){
                            errorMsg(2,"注册成功");
                            $(location).attr("href","index");
                        }else {
                            errorMsg(2,data.message);
                        }
                    },
                    error:function () {
                        errorMsg(2,"注册失败");
                    }
                })
            }else {
                errorMsg(2,"两次密码输入不一致")
            }
        }else {
            codeTrue(2)
        }
    })
    $(".getPhoneCode").click(function () {
        codeTrue(2);
        if (booCode){
            let phone = $(".registerPhone").val().trim();
            if (phone.length===11){
                $.ajax({
                    url:'getCode',
                    type:'post',
                    dataType:'json',
                    data:{
                        phone:phone
                    },
                    success:function (data) {
                        if (data.code===200){
                            let time = 60;
                            function Timer() {
                                if (time!=0){
                                    time--;
                                    $(".getPhoneCode").html(time)
                                    $(".getPhoneCode").addClass("disable");
                                    setTimeout(function () {
                                        Timer()
                                    },1000)
                                }else {
                                    $(".getPhoneCode").removeClass("disable");
                                    $(".getPhoneCode").html("重新获取")
                                    clearTimeout(Timer);
                                }
                            }
                            Timer();
                        }else {
                            errorMsg(2,"获取验证码失败")
                            $(".getPhoneCode").html("重新获取")
                        }
                    },
                    error:function () {
                        errorMsg(2,"获取验证码失败")
                        $(".getPhoneCode").html("重新获取")
                    }
                })
            }else {
                errorMsg(2,"手机号长度不正确")
            }
        }else {
            codeTrue(2)
        }
    });
    function PhoneCode(phone,code) {
        if (phone.length===11&&code.length===6){
            $.ajax({
                url:"setCode",
                type:"post",
                dataType:"json",
                data:{
                    phone:phone,
                    code:code
                },
                success:function (data) {
                    if (data.code===200){
                        booCodePhone = true;
                    }else {
                        errorMsg(2,"短信验证码验证失败")
                        booCodePhone = false;
                    }
                },
                error:function () {
                    errorMsg(2,"短信验证码验证失败")
                    booCodePhone = false;
                }
            })
        }else if(phone.length===11){
            errorMsg(2,"手机号格式错误")
            booCodePhone = false;
        }else {
            errorMsg(2,"短信验证码格式错误")
            booCodePhone = false;
        }
    }
    function errorMsg(box,msg) {
        let b1 = $("#msgBox1");
        let b2 = $("#msgBox2");
        let box1 = $("#msgBox1>span");
        let box2 = $("#msgBox2>span");
        if (box==1){
            b1.removeClass("fade")
            box1.html(msg)
            setTimeout(function () {
                b1.addClass("fade")
                box1.html("")
            },4000);
        }
        if (box==2){
            b2.removeClass("fade")
            box2.html(msg)
            setTimeout(function () {
                b2.addClass("fade")
                box2.html("")
            },4000);
        }
    }
})();