(function () {
    let showDetails = $(".showDetail");
    let dishNumber = $(".dishNumber");
    let checkBox = $("checkDish");
    let addCartAll = $(".addCartAll");
    let addCart = $(".addCart");
    let addOrder = $(".addOrder");
    dishNumber.on("input propertychange",function () {
        let sibling = this.parentNode.children;
        let dishMoney = 0;
        let dishValue = this.value;
        let totalMoney = null;
        for (let i in sibling){
            if (sibling[i].className==="dishMoney"){
                dishMoney = sibling[i].value;
            }
            if (sibling[i].className==="totalMoney"){
                sibling[i].value = dishMoney*dishValue;
                totalMoney = sibling[i];
            }
        }
    });
    addCartAll.click(function () {
         
    });
    addCart.click(function () {

    });
    addOrder.click(function () {

    });
    showDetails.click(function () {
        console.log(this.value());
    })
})();