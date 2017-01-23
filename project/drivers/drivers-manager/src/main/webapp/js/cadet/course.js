$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/cadetcourses/_search/cadetcourses',
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
        // showToggle: true,
        minimumCountColumns: 3,
        // showPaginationSwitch: true,
        sidePagination: "server",
        pagination: true,
        pageList:"[5,10, 20, 50]",
        sortName: 'id',
        sortOrder: 'desc',
        columns: [{
            field: 'state',
            checkbox: true,
            width: '5%'
        },{
            field: 'id',
            title: '序号',
            width: '5%',
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
            width: '10%',
            align: 'center'
        },{
            field: 'mobile',
            title: '电话号码',
            width: '10%',
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
            field: 'course',
            title: '目前课程',
            width: '10%',
            align: 'center',
            formatter: function(value, row, index) {
                var str = '';
                if(row.course == 1){
                    str = "科目1";
                }else if(row.course == 2){
                    str =  "科目2";
                }else if(row.course == 3){
                    str =  "科目3";
                }else if(row.course == 4){
                    str =  "科目4";
                }else {
                    str =  "无";
                }
                return str;
            }
        }, {
            field: 'operate',
            title: '操作',
            width: '25%',
            align: 'center',
            clickToSelect: false,
            events: operateEvents,
            formatter: function(value, row, index) {
                return [
                    "<button type='button' class='edit-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-edit'>编辑</span>",
                    "</button> ",
                    "<button type='button' class='delete-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-trash'>删除</span>",
                    "</button>"
                ].join('');
            }
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});

/**
 * 编辑学员课程信息表单校验
 * @type {any}
 */
var editValidator = $("#edit-form").validate({
    errorElement: "span",
    rules:{
    },
    messages:{
    }
});

var vm = new Vue({
    el: '#app',
    data: {
        editReq:{
            content: {
                id: '',
                cadetId: '',
                username: '',
                name: '',
                sex: '',
                birthday: '',
                mobile: '',
                email: '',
                idcardNum: '',
                course: ''
            }
        }
    },
    methods:{
        update: function(event){
            if (editValidator.form()){
                service.saveOrUpdateCourse(JSON.stringify(this.editReq));
            }
        },
        delete: function(){
            var selections = $('table').bootstrapTable('getSelections');
            if(selections != null && selections.length == 1){
                var object = Object();
                object.content =  this.editReq.content.id;
                service.deleteCourse(JSON.stringify(object));
            }
        }
    }
});
var service = new CadetService();
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
            vm.editReq.content.id = selections[0].cadetPayId;
            vm.editReq.content.cadetId = selections[0].id;
            vm.editReq.content.username = selections[0].username;
            vm.editReq.content.name = selections[0].name;
            vm.editReq.content.sex = selections[0].sex;
            vm.editReq.content.birthday = selections[0].birthday;
            vm.editReq.content.mobile = selections[0].mobile;
            vm.editReq.content.email = selections[0].email;
            vm.editReq.content.idcardNum = selections[0].idcardNum;
            vm.editReq.content.course = selections[0].course;
            console.log(vm.editReq.content.course);
            $('#editModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行编辑!!!')
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