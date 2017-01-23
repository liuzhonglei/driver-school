$(document).ready(function () {
    /**
     *   教练列表展示
    */
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/coachs/_search/coachs',
        contentType: 'application/json',
        method: 'get',
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
            var model = $('#model option:selected').val();
            console.log(model);
            if(model != 0){
                params['model'] = model;
            }
            return params;
        },
        clickToSelect: true,
        undefinedText: '-',
        idField: 'id',
        showColumns: true,
        showRefresh: true,
        minimumCountColumns: 3,
        sidePagination: "server",
        pagination: true,
        pageList:"[5,10, 20, 50]",
        sortName: 'id',
        sortOrder: 'desc',
        columns: [{
            field: 'state',
            checkbox: true,
            width: '2%'
        },{
            field: 'id',
            title: '序号',
            width: '3%',
            align: 'center'
        },{
            field: 'name',
            title: '姓名',
            width: '10%',
            align: 'center'
        }, {
            field: 'sex',
            title: '性别',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(value == 1){
                    return "男";
                }else if (value == 2){
                    return "女";
                }else{
                    return "未知";
                }
            }
        },{
            field: 'birthday',
            title: '出生日期',
            width: '5%',
            align: 'center'
        },{
            field: 'idcardNum',
            title: '身份证号码',
            width: '10%',
            align: 'center'
        },{
            field: 'mobile',
            title: '手机号码',
            width: '10%',
            align: 'center'
        },{
            field: 'mobile2',
            title: '备用手机号码',
            width: '10%',
            align: 'center'
        },{
            field: 'wxNickname',
            title: '微信账号',
            width: '10%',
            align: 'center'
        },{
            field: 'wxOpenid',
            title: '微信标识',
            width: '10%',
            align: 'center',
            visible: false
        },{
            field: 'model',
            title: '车型',
            width: '10%',
            align: 'center'
        },{
            field: 'cadetNum',
            title: '学员数量',
            width: '5%',
            align: 'center'
        }, {
            field: 'operate',
            title: '操作',
            width: '50%',
            align: 'center',
            clickToSelect: false,
            events: operateEvents,
            formatter: function(value, row, index) {
                var wx = '';
                if(row.wxNickname != null && row.wxNickname != ''){
                    wx = [
                        "<button type='button' class='unbind-click btn btn-info btn-sm'>",
                        "<span class='glyphicon glyphicon-trash'>解绑微信</span>",
                        "</button>"
                    ].join('');
                }else {
                    wx = [
                        "<button type='button' class='bind-click btn btn-info btn-sm'>",
                        "<span class='glyphicon glyphicon-trash'>绑定微信</span>",
                        "</button>"
                    ].join('');
                }

                return [
                    "<button type='button' class='edit-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-edit'>编辑</span>",
                    "</button>",
                    " ",
                    "<button type='button' class='delete-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-trash'>删除</span>",
                    "</button>",
                    " ",
                    wx ,
                    " ",
                    "<button type='button' class='unbind-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-trash'>分配学员</span>",
                    "</button>"
                ].join('');
            }
        }]
    });
    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });

    /**
     *
     */
    $("#file").fileinput({
        uploadUrl: "/api/cadets/upload", // server upload action
        uploadAsync: true,//异步上传
        maxFileCount: 1,
        maxFileSize: 10000,
        allowedFileExtensions: ["xlsx", "xls"],
        language: "zh",
        browseClass: "btn btn-primary btn-block",
        browseLabel: '导入',
        browseIcon: "<i class=\"glyphicon glyphicon-circle-arrow-up\"></i> ",
        showPreview: false,
        showCaption: false,
//         showRemove: false,
//         showUpload: false,
//         autoReplace: false,
        //
        minImageWidth: 50,
        minImageHeight: 50
        // maxImageWidth: 500,
        // maxImageHeight: 500
    });

    var $input = $('.typeahead');
    var name2Id = {};//姓名对应的id
    $input.typeahead({
        source: function (query, process) {
            $.post("/api/wxFans/getWxFansDic",{name: query,bindTable: 'coach'},function (e) {
                console.log(e.status);
                if (e.status == 1000) {
                    if (e.content.length == 0) { return; }
                    var names = [];
                    $.each(e.content, function (index, ele) {
                        name2Id[ele.name] = ele.id;//键值对保存下来。
                        names.push(ele.name);
                        console.log(ele.name);
                    });
                    process(names);//调用处理函数，格式化
                }
            });
        } ,//数据源
        items: 8,//最多显示个数
        // updater: function (item) {
        //     return item;//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        // },
        // displayText: function (item) {
        //     return "选：" + item;//返回字符串
        // },
        afterSelect: function (item) {
            var itemArray =item.split('-');
            vm.bindReq.content.wxNickname = itemArray[0];
            vm.bindReq.content.wxOpenid = itemArray[3];
        },
        delay: 500,//延迟时间
        autoSelect: true
    });
});

/**
 * 新增教练表单校验
 * @type {any}
 */
var registerValidator = $("#register-form").validate({
    errorElement: "span",
    rules:{
        name: {
            required: true,
        },
        mobile:{
            required: true,
            isMobile:true
        },
        mobile2:{
            isMobile:true
        },
        model:{
            required: true
        }
    },
    messages:{
        name:{
            required: "请输入姓名",
        },
        model:{
            required: "请选择车型"
        }
    }
});
/**
**
* 编辑教练表单校验
* @type {any}
*/
var editValidator = $("#edit-form").validate({
    errorElement: "span",
    rules:{
        name: {
            required: true,
        },
        mobile:{
            required: true,
            isMobile:true
        },
        mobile2:{
            isMobile:true
        },
        model:{
            required: true,
        }
    },
    messages:{
        name:{
            required: "请输入姓名",
        },
        model:{
            required: "请选择车型"
        }
    }
});
/**
 * 绑定微信账号表单校验
 * @type {any}
 */
var bindWeixinValidator = $("#bind-form").validate({
    errorElement: "span",
    rules:{
        username: {
            required: true,
        }
    },
    messages:{
        username:{
            required: "请输入微信账号",
        }
    }
});
var vm = new Vue({
    el: '#app',
    data: {
        req:{
            content: {
                name: '',
                mobile: '',
                mobile2: '',
                model: ''
            }
        },
        editReq:{
            content: {
                name: '',
                mobile: '',
                mobile2: '',
                model: ''
            }
        },
        bindReq:{
            content:{
                id: '',
                name:'',
                wxNickname: '',
                wxOpenid: ''
            }
        }
    },
    methods:{
        save: function(event){
            if (registerValidator.form()){
                service.register(JSON.stringify(this.req));
            }
        },
        update: function(event){
            if (editValidator.form()){
                service.update(JSON.stringify(this.editReq));
            }
        },
        reset: function () {
            validator.resetForm();
        },
        delete: function(){
            var selections = $('#table').bootstrapTable('getSelections');
            var object = Object();
            object.content =  selections[0].id;
            service.delete(JSON.stringify(object));
        },
        batchDelete: function () {
            var selections = $('#table').bootstrapTable('getAllSelections');
            if(selections != null && selections.length > 0){
                var object = Object();
                object.content = new Array(); ;
                $.each(selections,function(n,value) {
                    object.content.push(value.id);
                });
                service.batchDelete(JSON.stringify(object));
            }
        },
        bindWeixin: function () {
            if (bindWeixinValidator.form()){
                service.bindWeixin(JSON.stringify(this.bindReq));
            }
        },
        unbindWeixin: function () {
            service.unbindWeixin(JSON.stringify(this.bindReq));
        },
    }
});
var service = CoachService(vm);

window.operateEvents = {
    'click .edit-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行编辑!!!')
        }else if(selections.length == 1){
            vm.editReq.content.id = selections[0].id;
            vm.editReq.content.name = selections[0].name;
            vm.editReq.content.mobile = selections[0].mobile;
            vm.editReq.content.mobile2 = selections[0].mobile2;
            vm.editReq.content.model = selections[0].model;
            $('#editModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行编辑!!!')
        }
    },
    'click .bind-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行绑定!!!')
        }else if(selections.length == 1){
            vm.bindReq.content.id = selections[0].id;
            vm.bindReq.content.name = selections[0].name;
            vm.bindReq.content.wxNickname = null;
            vm.bindReq.content.wxOpenid = null;
            $("#wx-bind").val(null);
            $('#bindModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行绑定!')
        }
    },
    'click .unbind-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行微信解绑!!!')
        }else if(selections.length == 1){
            vm.bindReq.content.id = selections[0].id;
            vm.unbindWeixin();
        }else{
            toastr.warning('最多只能选择一条数据进行微信解绑!!!')
        }
    },
    'click .delete-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行删除!!!')
        }else if(selections.length == 1){
            bootbox.confirm({
                message: "确认删除该条数据？",
                buttons: {
                    confirm: {
                        label: '确定',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: '取消',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if(result == true){
                        vm.delete();
                    }
                }
            });
        }else{
            toastr.warning('最多只能选择一条数据进行删除!!!')
        }
    }
};