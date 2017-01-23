function CoachService(vm){
    var obj   = new Object();
    toastr.options = {
        "closeButton": true, //是否显示关闭按钮
        "debug": false, //是否使用debug模式
        "newestOnTop": true,
        "progressBar": true,
        "positionClass": "toast-top-center",//弹出窗的位置
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",//显示的动画时间
        "hideDuration": "1000",//消失的动画时间
        "timeOut": "5000", //展现时间
        "extendedTimeOut": "1000",//加长展示时间
        "showEasing": "swing",//显示时的动画缓冲方式
        "hideEasing": "linear",//消失时的动画缓冲方式
        "showMethod": "fadeIn",//显示时的动画方式
        "hideMethod": "fadeOut" //消失时的动画方式
    };

    //注册教练信息
    obj.register = function(data){
        $.ajax({
            url: '/api/coachs/create',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#myModal').modal('hide');
                toastr.success('成功注册教练信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //编辑教练信息
    obj.update = function(data){
        $.ajax({
            url: '/api/coachs/update',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#editModal').modal('hide');
                toastr.success('成功编辑教练信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //删除教练信息
    obj.delete = function(data){
        $.ajax({
            url: '/api/coachs/delete',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                toastr.success('删除成功!');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //批量删除教练信息
    obj.batchDelete = function(data){
        $.ajax({
            url: '/api/coachs/batchDelete',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                toastr.success('批量删除成功!');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //
    obj.singleFieldUpdate = function(data){
        $.ajax({
            url: '/api/coachs/singleFieldUpdate',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                toastr.success('更新成功!!!');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //教练绑定微信账号
    obj.bindWeixin = function(data){
        $.ajax({
            url: '/api/coachs/bindWeixin',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#bindModal').modal('hide');
                toastr.success('成功绑定微信账号');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //教练解绑微信账号
    obj.unbindWeixin = function(data){
        $.ajax({
            url: '/api/coachs/unbindWeixin',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                toastr.success('成功解绑微信账号');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    return obj;
}