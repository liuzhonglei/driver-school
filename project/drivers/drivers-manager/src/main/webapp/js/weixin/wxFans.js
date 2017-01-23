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
     * 微信粉丝列表展示
     */
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/wxFans/_search/wxFans',
        contentType: 'application/json',
        method: 'get',
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
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
            field: 'headimgurl',
            title: '头像',
            width: '10%',
            align: 'center',
            formatter: function(value, row, index) {
                return [
                    "<div>",
                    "<div class='small_pic'>",
                    "<a class='delete-click' href='#pic_one'>",
                    "<img src='" + row.headimgurl +"'  style='width:30px;height:30px;'alt='用户头像'/> ",
                    "</a>",
                    "</div>",
                    "</div>"
                ].join('');
            }
        },{
            field: 'nickname',
            title: '账号',
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
            field: 'openid',
            title: '唯一标识',
            width: '5%',
            align: 'center'
        },{
            field: 'addr',
            title: '地址',
            width: '10%',
            align: 'center',
            formatter: function(value, row, index) {
                return row.country + "," + row.province + "," + row.city;
            }
        },{
            field: 'language',
            title: '语言',
            width: '5%',
            align: 'center'
        }, {
            field: 'subscribe',
            title: '订阅',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(value == 0){
                    return "否";
                }else if (value == 1){
                    return "是";
                }else{
                    return "未知";
                }
            }
        },{
            field: 'subscribeTime',
            title: '关注时间',
            width: '10%',
            align: 'center'
        }, {
            field: 'operate',
            title: '操作',
            width: '20%',
            align: 'center',
            clickToSelect: false,
            events: operateEvents,
            formatter: function(value, row, index) {
                    return [
                        "<button type='button' class='edit-click btn btn-info btn-sm'>",
                        "<span class='glyphicon glyphicon-edit'>标签</span>",
                        "</button> ",
                        "<button type='button' class='delete-click btn btn-info btn-sm'>",
                        "<span class='glyphicon glyphicon-trash'>分组</span>",
                        "</button> "
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
        // browseClass: "btn btn-primary",
        // browseLabel: '导入',
        // browseIcon: "<i class=\"glyphicon glyphicon-circle-arrow-up\"></i> ",
        showPreview: false,
        // showCaption: false,
        // showRemove: true,
        // showUpload: true,
        // autoReplace: true,
    });

    var $input = $('.typeahead');
    var name2Id = {};//姓名对应的id
    $input.typeahead({
        source: function (query, process) {
            $.post("/api/coachs/getCoachDic",{name: query},function (e) {
                console.log(e.status);
                if (e.status == 1000) {
                    if (e.content.length == 0) {  return; }
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
            console.log(name2Id[item]);//打印对应的id//选择项之后的事件 ，item是当前选中的。
        },
        delay: 500,//延迟时间
        autoSelect: true
    });

    var $input2 = $('.typeahead2');
    var name2Id2 = {};//姓名对应的id
    $input2.typeahead({
        source: function (query, process) {
            $.post("/api/wxFans/getWxFansDic",{name: query},function (e) {
                console.log(e.status);
                if (e.status == 1000) {
                    if (e.content.length == 0) { return; }
                    var names = [];
                    $.each(e.content, function (index, ele) {
                        name2Id2[ele.name] = ele.id;//键值对保存下来。
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
            console.log(name2Id2[item]);//打印对应的id//选择项之后的事件 ，item是当前选中的。
        },
        delay: 500,//延迟时间
        autoSelect: true
    });
});

/**
 * 新增学员表单校验
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
        }
    },
    messages:{
        name:{
            required: "请输入姓名",
        }
    }
});
/**
 * 编辑学员表单校验
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
        }
    },
    messages:{
        name:{
            required: "请输入姓名",
        }
    }
});
var vm = new Vue({
    el: '#app',
    data: {
        req:{
            content: {
                username: '',
                name: '',
                sex: '',
                birthday: '',
                mobile: '',
                idcardNum: ''
            }
        },
        editReq:{
            content: {
                id: '',
                username: '',
                name: '',
                sex: '',
                birthday: '',
                mobile: '',
                idcardNum: ''
            }
        },
        bindReq:{
            content:{
                id: '',
                name:'',
                wxNickname: ''
            }
        }
    },
    methods:{
        save: function(event){
            if (registerValidator.form()){
                service.register(JSON.stringify(this.req));
            }
        },
        importView: function () {
            $('#importModal').modal('show');
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
            var selections = $('table').bootstrapTable('getSelections');
            if(selections != null && selections.length == 1){
                var object = Object();
                object.content =  selections[0].id;
                service.delete(JSON.stringify(object));
            }
        },
        batchDelete: function () {
            var selections = $('table').bootstrapTable('getAllSelections');
            if(selections != null && selections.length > 0){
                var object = Object();
                object.content = new Array(); ;
                $.each(selections,function(n,value) {
                    object.content.push(value.id);
                });
                service.batchDelete(JSON.stringify(object));
            }
        }
    }
});
var service = CadetService(vm);
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
window.operateEvents = {
    'click .edit-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
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
            vm.editReq.content.idCardNum = selections[0].idCardNum;
            $('#editModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行编辑!!!')
        }
    },
    'click .bing-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行绑定!!!')
        }else if(selections.length == 1){
            vm.bindReq.content.id = selections[0].id;
            vm.bindReq.content.username = selections[0].username;
            vm.bindReq.content.name = selections[0].name;
            $('#bindModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行绑定!!!')
        }
    },
    'click .unbing-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行绑定!!!')
        }else if(selections.length == 1){
            vm.editReq.content.id = selections[0].id;
            vm.editReq.content.username = selections[0].username;
            vm.editReq.content.name = selections[0].name;
            vm.editReq.content.sex = selections[0].sex;
            vm.editReq.content.birthday = selections[0].birthday;
            vm.editReq.content.mobile = selections[0].mobile;
            vm.editReq.content.email = selections[0].email;
            $('#bindModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行绑定!!!')
        }
    },
    'click .delete-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
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