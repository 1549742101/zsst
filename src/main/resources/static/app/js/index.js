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
    })
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
    setInterval(BannerF,3000)
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
        if( jindu === 59 ){
            clearInterval( myset );
        }
    };
    let goFun1 = ()=>{
        jindu1 +=0.5 ;
        let strokeLength = jinduLength*jindu ;
        txt1.innerHTML = jindu1 +"%";
        // 更改环形样式，控制进度变化：实线段长度。
        progressRound1.style.strokeDasharray = strokeLength+" 1000";
        // 如果进度为 100 ，那么终止计时器。
        if( jindu1 === 60 ){
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
    $(".getCode").click(
        function () {
            this.innerHTML="1234"
        }
    )
})();