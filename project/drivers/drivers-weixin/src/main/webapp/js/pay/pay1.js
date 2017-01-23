$(document).ready(function () {
    var service = PayService();
    var vm =new Vue({
        el: '#app',
        data: {
            payReq:{
                content: {
                    opendId: '',
                    payFee: '',
                    name: '',
                    mobile: '',
                    dataCreator: 'weixin',
                    dataUpdater: 'weixin'
                }
            }
        },
        methods:{
            apply: function(event){
                if (payValidator.form()){
                    if (typeof WeixinJSBridge == "undefined"){
                        if( document.addEventListener ){
                            document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
                        }else if (document.attachEvent){
                            document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                            document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
                        }
                    }else{
                        var paymentFee = $("#tuition").attr("tuition")
                        console.log(paymentFee);
                        this.payReq.content.payFee = paymentFee * 100;
                        console.log(this.payReq.content.payFee);
                        this.payReq.content.payFee = paymentFee * 100;
                        service.callpay(JSON.stringify(this.payReq));
                        this.payReq.content.payFee = paymentFee;
                        console.log(this.payReq.content.payFee);
                    }
                }
            }
        }
    })
});


/**
 * 投诉建议表单校验
 * @type {any}
 */
var payValidator = $("#pay-form").validate({
    errorElement: "span",
    rules:{
        name: {
            required: true,
        },
        mobile:{
            required: true,
            isMobile:true
        },
        message:{
            required: true
        }
    }
});