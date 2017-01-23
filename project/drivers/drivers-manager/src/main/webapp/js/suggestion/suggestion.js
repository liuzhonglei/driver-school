$(document).ready(function () {
    // 配置日历
    $('#datetimepicker1').datetimepicker({
        locale: 'zh-cn',
        defaultDate: "11/1/2013",
        format: 'YYYY-MM-DD'
    });
    $('#datetimepicker2').datetimepicker({
        locale: 'zh-cn',
        defaultDate: new Date(),
        format: 'YYYY-MM-DD',
        useCurrent: false //Important! See issue #1075
    });
    $("#datetimepicker1").on("dp.change", function (e) {
        $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepicker2").on("dp.change", function (e) {
        $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
    });

    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/suggestions/_search/suggestions',
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
            var businessStatus = $('#businessStatus option:selected').val();
            if(businessStatus != 0){
                params['businessStatus'] = businessStatus;
            }
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
            width: '2%'
        },{
            field: 'id',
            title: '序号',
            width: '3%',
            align: 'center'
        },{
            field: 'name',
            title: '投诉人',
            width: '5%',
            align: 'center'
        },{
            field: 'appType',
            title: '平台',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.appType == 1){
                    return "云后台";
                }else if(row.appType == 2){
                    return "官网";
                }else if(row.appType == 3){
                    return "微信";
                }else {
                    return "未知";
                }
            }
        },{
            field: 'mobile',
            title: '手机号码',
            width: '5%',
            align: 'center'
        },{
            field: 'content',
            title: '投诉内容',
            width: '20%',
            align: 'center'
        },{
            field: 'dataCreateDatetime',
            title: '投诉时间',
            width: '10%',
            align: 'center'
        },{
            field: 'businessStatus',
            title: '处理状态',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(row.businessStatus == 1){
                    return "未处理";
                }else if(row.businessStatus == 2){
                    return "正在处理";
                }else if(row.businessStatus == 3){
                    return "已处理";
                }
            }
        },{
            field: 'dataCreator',
            title: '处理人',
            width: '5%',
            align: 'center'
        },{
            field: 'dataUpdateDatetime',
            title: '处理时间',
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
                var reply = '';
                if (row.appType != 3){
                    reply = 'disabled';
                }

                var close;
                if (row.businessStatus == 3){
                    close = 'disabled';
                }
                return [
                    "<button type='button' class='delete-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-trash'></span>",
                    "<span class='hidden-xs hidden-sm'>删除</span>",
                    "</button>",
                    " ",
                    "<button type='button' class='close-click btn btn-info btn-sm'",close,">",
                    "<span class='glyphicon glyphicon-trash'></span>",
                    "<span class='hidden-xs hidden-sm'>关闭</span>",
                    "</button>",
                    " ",
                    "<button type='button' class='reply-click btn btn-info btn-sm'",reply,">",
                    "<span class='glyphicon glyphicon-trash'></span>",
                    "<span class='hidden-xs hidden-sm'>回复</span>",
                    "</button>",
                    " ",
                    "<button type='button' class='feekback-click btn btn-info btn-sm'>",
                    "<span class='glyphicon glyphicon-trash'></span>",
                    "<span class='hidden-xs hidden-sm'>详情</span>",
                    "</button>"
                ].join('');
            }
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
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
        replyReq:{
            content: {
                suggestionId: '',
                suggestionName: '',
                suggestionContent: '',
                content: ''
            }
        }
    },
    methods:{
        close: function(event){
            service.close(JSON.stringify(this.editReq));
        },
        delete: function(){
            var selections = $('table').bootstrapTable('getSelections');
            if(selections != null && selections.length == 1){
                var object = Object();
                object.content =  selections[0].id;
                service.delete(JSON.stringify(object));
            }
        },
        reply: function(){
            service.reply(JSON.stringify(this.replyReq));
        },
        feekback: function(){
            service.feekback(JSON.stringify(this.replyReq));
        }
    }
});

var service = SuggestionService(vm);

window.operateEvents = {
    'click .delete-click': function (e, value, row, index) {
        bootbox.confirm("确认删除该条投诉？",function (result) {
            if(result == true){
                var selections = $('table').bootstrapTable('getSelections');
                if(selections != null && selections.length == 1){
                    var suggestionService = new SuggestionService();
                    suggestionService.delete(selections[0].id);
                }
            }
        });
    },
    'click .close-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行微信解绑!!!')
        }else if(selections.length == 1){
            bootbox.confirm("确认关闭该条投诉？",function (result) {
                if(result == true){
                    vm.editReq.content.id = selections[0].id;
                    vm.close();
                }
            });
        }else{
            toastr.warning('最多只能选择一条数据进行微信解绑!!!')
        }
    },
    'click .reply-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行回复!!!')
        }else if(selections.length == 1){
            vm.replyReq.content.suggestionId = selections[0].id;
            vm.replyReq.content.suggestionName = selections[0].name;
            vm.replyReq.content.suggestionContent = selections[0].content;
            $('#replyModal').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行回复!!!')
        }
    },
    'click .feekback-click': function (e, value, row, index) {
        var selections = $('table').bootstrapTable('getSelections');
        if (selections.length == 0){
            toastr.warning('请选择一条数据进行查看!!!')
        }else if(selections.length == 1){
            vm.replyReq.content.suggestionId = selections[0].id;
            vm.feekback();
            $('#modalTable').modal('show');
        }else{
            toastr.warning('最多只能选择一条数据进行回复!!!')
        }
    }
};
