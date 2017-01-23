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
     * 学员列表展示
     */
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/cadets/_search/cadets',
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
            field: 'name',
            title: '姓名',
            width: '5%',
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
            field: 'mobile',
            title: '电话号码',
            width: '5%',
            align: 'center'
        },{
            field: 'idcardNum',
            title: '身份证号码',
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
            field: 'dataCreateDatetime',
            title: '注册时间',
            width: '10%',
            align: 'center'
        },{
            field: 'payStatus',
            title: '缴费状态',
            width: '10%',
            align: 'center',
            formatter: function(value, row, index) {
               if(row.payStatus == 1){
                   return "未缴费";
               }else if(row.payStatus == 2){
                   return "已缴费未报道";
               }else if(row.payStatus == 3){
                   return "已缴费已报道";
               }else {
                   return "未知";
               }
            }
        },{
            field: 'course',
            title: '课程情况',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.course == 1){
                    return "科目一";
                }else if(row.course == 2){
                    return "科目二";
                }else if(row.course == 3){
                    return "科目三";
                }else if(row.course == 4){
                    return "科目四";
                }else {
                    return "未知";
                }
            }
        },{
            field: 'driverName',
            title: '教练姓名',
            width: '5%',
            align: 'center',
        }, {
            field: 'operate',
            title: '操作',
            width: '20%',
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
                var coach = '';
                if (row.driverName != null && row.driverName != ''){
                    coach = 'disabled';
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
                    "<button type='button' class='appoint-click btn btn-info btn-sm'",coach,">",
                    "<span class='glyphicon glyphicon-trash'>指定教练</span>",
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
        displayText: function (item) {
            return "选：" + item;//返回字符串
        },
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
            $.post("/api/wxFans/getWxFansDic",{name: query,bindTable: 'cadet'},function (e) {
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
        afterSelect: function (item) {//打印对应的id//选择项之后的事件 ，item是当前选中的。
            var itemArray =item.split('-');
            vm.bindReq.content.wxNickname = itemArray[0];
            vm.bindReq.content.wxOpenid = itemArray[3];
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
                wxNickname: '',
                wxOpenid: ''
            }
        },
        relateCoachReq:{
            content:{
                id: '',
                coachId: ''
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
                service.bindWeixin(JSON.stringify(this.bindReq));
            }
        },
        unbindWeixin: function () {
            service.unbindWeixin(JSON.stringify(this.bindReq));
        },
        relateCoach: function () {
            console.log("relateCoach");
            var selections = $('#coach-table').bootstrapTable('getAllSelections');
            if(selections != null && selections.length > 0){
                this.relateCoachReq.content.coachId =  selections[0].id;
                console.log("coachId:" + this.relateCoachReq.content.coachId);
                service.relateCoach(JSON.stringify(this.relateCoachReq));
            }else {
                console.log("没选择教练");
            }
        }
    }
});
var service = CadetService(vm);

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
            vm.editReq.content.idcardNum = selections[0].idcardNum;
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
    },
    'click .appoint-click': function (e, value, row, index) {
        var selections = $('#table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行操作!!!')
        }else if(selections.length == 1){
            vm.relateCoachReq.content.id =  selections[0].id;
            console.log("id:" + vm.relateCoachReq.content.id);
            $('#appointModal').modal('show');
            $('#coach-table').bootstrapTable({
                toolbar: '#coach-toolbar',
                url: '/api/coachs/_search/coachs',
                contentType: 'application/json',
                method: 'get',
                queryParams: function(params) {
                    $('#coach-toolbar').find('input[name]').each(function () {
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
                sidePagination: "server",
                pagination: true,
                pageList:"[5,10, 20, 50]",
                singleSelect: true,
                columns: [{
                    field: 'state',
                    checkbox: true,
                    width: '2%'
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
                    field: 'wxNickname',
                    title: '微信账号',
                    width: '10%',
                    align: 'center'
                }
                // ,{
                //     field: 'cadetNum',
                //     title: '学员数量',
                //     width: '5%',
                //     align: 'center'
                // }
                ]
            });
            $('#coach-ok').click(function () {
                $('#coach-table').bootstrapTable('refresh');
            });
        }else{
            toastr.warning('最多只能选择一条数据进行操作!!!')
        }
    }
};