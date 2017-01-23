function PayService(){
    var obj   = new Object();

    obj.callpay = function (data) {
        $.ajax({
            url: '/pay/jspay',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                obj.wxPay(result);
            }
        });
    };
    obj.wxPay = function(obj) {
        //传入公众号名称，时间戳，随机串，Package 扩展字段，签名方式和PaySign 签名
        WeixinJSBridge.invoke('getBrandWCPayRequest', {
            "appId" : obj.appId,
            "timeStamp" : obj.timeStamp,
            "nonceStr" : obj.nonceStr,
            "package" : "prepay_id=" + obj.pg,
            "signType" : obj.signType,
            "paySign" : obj.paySign
        }, function(res) {
            // alert(res.err_code + res.err_desc);
            if (res.err_msg == "get_brand_wcpay_request:ok") {
                alert("支付成功！");
            }else {
                alert("支付失败！");
            }
        });
    }
    return obj;
}