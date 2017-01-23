$(document).ready(function () {
    $('#datetimepicker-register').datetimepicker({
        locale: 'zh-cn',
        format: 'YYYY-MM-DD'
    });
    $('#datetimepicker-edit').datetimepicker({
        locale: 'zh-cn',
        format: 'YYYY-MM-DD'
    });
    /**
     * 系统管理员列表展示
     */
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/sysmanagers/_search/sysmanagers',
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
            return params;
        },
        searchText: '',
        clickToSelect: true,
        undefinedText: '-',
        idField: 'id',
        showColumns: true,
        showRefresh: true,
        sidePagination: "server",
        pagination: true,
        pageList:"[10, 20, 50, 100]",
        columns: [{
            field: 'state',
            checkbox: true,
            width: '2%'
        },{
            field: 'id',
            title: '序号',
            width: '3%',
            align: 'center'
        }
        // ,{
        //     field: 'avatarUrl',
        //     title: '头像',
        //     width: '10%',
        //     align: 'center',
        //     formatter: function(value, row, index){
        //         return [
        //             "<div>",
        //             "<div class='small_pic'>",
        //             "<a class='delete-click' href='#pic_one'>",
        //             "<img src='" + row.avatarUrl +"'  style='width:30px;height:30px;'alt='用户头像'/> ",
        //             "</a>",
        //             "</div>",
        //             "</div>"
        //         ].join('');
        //     },
        //     events:operateEvents,
        // }
        , {
            field: 'username',
            title: '用户名',
            width: '10%',
            align: 'center'
        }, {
            field: 'name',
            title: '真实姓名',
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
        }, {
            field: 'birthday',
            title: '出生日期',
            width: '5%',
            align: 'center'
        }, {
            field: 'mobile',
            title: '手机号码',
            width: '10%',
            align: 'center'
        }, {
            field: 'email',
            title: '电子邮箱',
            width: '10%',
            align: 'center'
        }, {
            field: 'dataUpdater',
            title: '创建人',
            width: '10%',
            align: 'center'
        }, {
            field: 'dataUpdateDatetime',
            title: '创建时间',
            width: '10%',
            align: 'center'
        }, {
            field: 'operate',
            title: '操作',
            width: '15%',
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
                    wx
                ].join('');
                }
        }]
    });
    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });

    var $input = $('.typeahead');
    var name2Id = {};//姓名对应的id
    $input.typeahead({
        source: function (query, process) {
            $.post("/api/wxFans/getWxFansDic",{name: query,bindTable: 'sys_manager'},function (e) {
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
            console.log('wxNickname:' + vm.bindReq.content.wxNickname);
            vm.bindReq.content.wxOpenid = itemArray[3];
            console.log('wxOpenid:' + vm.bindReq.content.wxOpenid);
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
        username: {
            required: true,
            rangelength:[2,10],
            remote:{
                url: '/api/sysmanagers/validateUsername',
                type: 'get',
                dataType: 'json'
            }
        },
        password: {
            required: true,
            minlength: 5
        },
        confirmPassword: {
            required: true,
            minlength: 5,
            equalTo: "#password-register"
        },
        birthday:{
            dateISO:true
        },
        age:{
            number:true
        },
        mobile:{
            isMobile:true
        },
        email:{
            required: false,
            email: true
        }
    },
    messages:{
        username:{
            required: "请输入用户名",
            remote: "用户名已存在!"
        }
    }
});
/**
 * 编辑教练表单校验
 * @type {any}
 */
var editValidator = $("#edit-form").validate({
    errorElement: "span",
    rules:{
        username: {
            required: true,
            rangelength:[2,10]
        },
        birthday:{
            dateISO:true
        },
        age:{
            number:true
        },
        mobile:{
            number:true
        },
        email:{
            required: false,
            email: true
        }
    },
    messages:{
        username:{
            required: "请输入用户名",
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
        wx_nickname: {
            required: true,
        }
    },
    messages:{
        wx_nickname:{
            required: "请输入微信账号",
        }
    }
});
var vm = new Vue({
    el: '#app',
    data: {
        req:{
            content: {
                username: '',
                password: '',
                name: '',
                sex: 0,
                age: '',
                mobile: '',
                email: ''
            }
        },
        editReq:{
            content: {
                id: '',
                username: '',
                name: '',
                sex: '',
                age: '',
                mobile: '',
                email: ''
            }
        },
        bindReq:{
            content:{
                id: '',
                username:'',
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
            if(selections != null && selections.length == 1){
                var object = Object();
                object.content =  selections[0].id;
                service.delete(JSON.stringify(object));
            }
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
                console.log('bindReq' + JSON.stringify(this.bindReq));
                service.bindWeixin(JSON.stringify(this.bindReq));
            }
        },
        unbindWeixin: function () {
            service.unbindWeixin(JSON.stringify(this.bindReq));
        },
    }
});
var service = SysmanagerService(vm);

window.operateEvents = {
    'click .edit-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行编辑!!!')
        }else if(selections.length == 1){
            vm.editReq.content.id = selections[0].id;
            vm.editReq.content.username = selections[0].username;
            vm.editReq.content.name = selections[0].name;
            vm.editReq.content.sex = selections[0].sex;
            vm.editReq.content.birthday = selections[0].birthday;
            vm.editReq.content.mobile = selections[0].mobile;
            vm.editReq.content.email = selections[0].email;
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
            vm.bindReq.content.username = selections[0].username;
            console.log('useranme' + vm.bindReq.content.username);
            vm.bindReq.content.name = selections[0].name;
            vm.bindReq.content.wxNickname = null;
            vm.bindReq.content.wxOpenid = null;
            $("#wx-bind").val(null);
            $('#bindModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行绑定!!!')
        }
    },
    'click .unbind-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行微信解绑!')
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
