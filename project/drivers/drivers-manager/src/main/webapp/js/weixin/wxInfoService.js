function WxInfoService(vm) {
    var obj = new Object();
    obj.getWxInfo = function () {
        $.ajax({
            url: '/api/wxInfo/get',
            dataType: 'json',
            method: 'GET',
            data: {},
            success: function(result){
                vm.$data.editReq.content.id = result.content.id;
                vm.$data.editReq.content.appId = result.content.appId;
                vm.$data.editReq.content.appSecret = result.content.appSecret;
                vm.$data.editReq.content.partnerId = result.content.partnerId;
                vm.$data.editReq.content.partnerKey = result.content.partnerKey;
                vm.$data.editReq.content.paySignKey = result.content.paySignKey;
                vm.$data.editReq.content.password = result.content.password;
                vm.$data.editReq.content.menuOpenType = result.content.menuOpenType;
                vm.$data.editReq.content.isOpenSubMch = result.content.isOpenSubMch;
                vm.$data.editReq.content.accessToken = result.content.accessToken;
            }
        });
    };
    obj.updateWxInfo = function (data) {
        $.ajax({
            url: '/api/wxInfo/update',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data: data,
            success: function(result){
                if(result.status == 1000){
                    toastr.success('更新微信信息成功.');
                }else{
                    toastr.warning('更新微信信息失败！');
                }

            }
        });
    };
    obj.singleFieldUpdateForTuition = function (data) {
        $.ajax({
            url: '/api/schooltuitions/singleFieldUpdate',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    return obj;
}