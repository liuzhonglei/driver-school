function CadetService(vm){
    var obj   = new Object();
    //注册学员信息
    obj.register = function(data){
        $.ajax({
            url: '/api/cadets/create',
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
    obj.saveOrUpdateCadetPay = function(data){
        $.ajax({
            url: '/api/cadetpays/createOrUpdate',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#editModal').modal('hide');
                toastr.success('成功操作学员缴费信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    obj.saveOrUpdateCourse = function(data){
        $.ajax({
            url: '/api/cadetcourses/createOrUpdate',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#editModal').modal('hide');
                toastr.success('成功操作学员课程信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //删除学员信息
    obj.delete = function(data){
        $.ajax({
            url: '/api/cadets/delete',
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
    //删除学员缴费信息
    obj.deleteCadetpay = function(data){
        $.ajax({
            url: '/api/cadetpays/delete',
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
    //删除学员课程信息
    obj.deleteCadetpay = function(data){
        $.ajax({
            url: '/api/cadetcourses/delete',
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
            url: '/api/cadets/batchDelete',
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
    //更新学员信息
    obj.update = function(data){
        $.ajax({
            url: '/api/cadets/update',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                $('#editModal').modal('hide');
                toastr.success('成功编辑学员信息');
                $('#table').bootstrapTable('refresh');
            }
        });
    };
    //
    obj.singleFieldUpdate = function(data){
        $.ajax({
            url: '/api/cadets/singleFieldUpdate',
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
    //学员信息绑定微信账号
    obj.bindWeixin = function(data){
        $.ajax({
            url: '/api/cadets/bindWeixin',
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
    //学员信息解绑微信账号
    obj.unbindWeixin = function(data){
        $.ajax({
            url: '/api/cadets/unbindWeixin',
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
    //学员指定教练
    obj.relateCoach = function(data){
        $.ajax({
            url: '/api/cadets/relateCoach',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                toastr.success('成功关联教练员');
                $('#appointModal').modal('hide');
                $('#table').bootstrapTable('refresh');
            }
        });
    };

    return obj;
}