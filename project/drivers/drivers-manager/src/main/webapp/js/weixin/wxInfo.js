var vm = new Vue({
    el: '#app',
    data: {
        editReq: {
            content: {
                id: '',
                appId: '',
                appSecret: '',
                paySignKey: '',
                partnerId: '',
                partnerKey: '',
                password: '',
                menuOpenType: '',
                certUrl: '',
                isOpenSubMch: '',
                accessToken: ''
            }
        }
    },
    methods:{
        get: function(){
            service.getWxInfo();
        },
        update: function () {
            service.updateWxInfo(JSON.stringify(this.editReq));
        }
    }
});
var service = WxInfoService(vm);

$(document).ready(function () {
    vm.get();
});




