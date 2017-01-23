function SysmanagerService(vm){
    var obj   = new Object();
    //注册管理员信息
    obj.register = function(data){
        $.ajax({
            url: '/api/sysmanagers/create',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#registerModal').modal('hide');
                toastr.success('成功注册系统管理员信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //编辑管理员信息
    obj.update = function(data){
        $.ajax({
            url: '/api/sysmanagers/update',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#editModal').modal('hide');
                toastr.success('成功编辑系统管理员信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //删除管理员信息
    obj.delete = function(data){
        $.ajax({
            url: '/api/sysmanagers/delete',
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
    //批量删除管理员信息
    obj.batchDelete = function(data){
        $.ajax({
            url: '/api/sysmanagers/batchDelete',
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
            url: '/api/sysmanagers/singleFieldUpdate',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                toastr.success('更新成功!');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    obj.updatePassword = function(data){
        $.ajax({
            url: '/api/sysmanagers/updatePassword',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                toastr.success('密码更新成功!!!');
            }
        });
    };
    obj.getByUsername = function(){
        $.ajax({
            url: '/api/sysmanagers/get?username=' + vm.$data.editReq.content.username,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'GET',
            // data:data,
            success: function(result){
                vm.$data.editReq.content.id = result.content.id;
                vm.$data.editReq.content.username = result.content.username;
                vm.$data.editReq.content.name = result.content.name;
                vm.$data.editReq.content.sex = result.content.sex;
                vm.$data.editReq.content.birthday = result.content.birthday;
                vm.$data.editReq.content.mobile = result.content.mobile;
                vm.$data.editReq.content.email = result.content.email;
            }
        });
    };
    //管理员绑定微信账号
    obj.bindWeixin = function(data){
        $.ajax({
            url: '/api/sysmanagers/bindWeixin',
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
    //管理员解绑微信账号
    obj.unbindWeixin = function(data){
        $.ajax({
            url: '/api/sysmanagers/unbindWeixin',
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