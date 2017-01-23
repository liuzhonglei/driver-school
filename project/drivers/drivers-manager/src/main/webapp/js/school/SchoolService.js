function SchoolService(vm) {
    var obj = new Object();
    obj.getShcool = function () {
        $.ajax({
            url: '/api/schools/get',
            dataType: 'json',
            method: 'GET',
            data: {},
            success: function(result){
                vm.$data.editReq.content.id = result.content.id;
                vm.$data.editReq.content.name = result.content.name;
                vm.$data.editReq.content.logoUrl = result.content.logoUrl;
                vm.$data.editReq.content.mobile = result.content.mobile;
                vm.$data.editReq.content.phone = result.content.phone;
                vm.$data.editReq.content.email = result.content.email;
                vm.$data.editReq.content.addr = result.content.addr;
                vm.$data.editReq.content.slogan = result.content.slogan;
                vm.$data.editReq.content.introduction = result.content.introduction;
                vm.$data.editReq.content.administrators = result.content.administrators;
            }
        });
    };
    obj.updateSchool = function (data) {
        $.ajax({
            url: '/api/schools/update',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data: data,
            success: function(result){
                if(result.status == 1000){
                    toastr.success('更新驾校信息成功.');
                }else{
                    toastr.warning('更新驾校信息失败！');
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