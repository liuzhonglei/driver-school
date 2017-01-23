$(document).ready(function () {
    var schoolService = new SchoolService();
    $('#table').bootstrapTable({
        class: 'table table-no-bordered',
        url: '/api/schooltuitions/get',
        clickToSelect: true,
        undefinedText: '-',
        idField: 'id',
        showRefresh: true,
        columns: [{
            field: 'name',
            title: '驾校名称',
            width: '30%',
            align: 'center'
        },{
            field: 'tuition',
            title: '学费（元）',
            width: '20%',
            align: 'center',
            editable: true,
            editableEmptytext: '请输入学费',
            formatter: function(value, row, index) {
                return row.tuition/100;
            }
        },{
            field: 'tuitionExplain',
            title: '学费说明',
            width: '50%',
            align: 'center',
            editable: true,
            editableEmptytext: '请输入学费说明'
        }],
        onEditableSave: function (field, row, oldValue, $el) {
            var data = new Object();
            data.content = new Object();
            data.content.id = row.id;
            if (field == 'tuition' && row.tuition != oldValue){
                data.content.key = 'tuition';
                data.content.value = row.tuition * 100;
                schoolService.singleFieldUpdateForTuition(JSON.stringify(data));
            }
            if(field == 'tuitionExplain' && row.tuitionExplain != oldValue){
                data.content.key = 'tuition_explain';
                data.content.value = row.tuitionExplain;
                schoolService.singleFieldUpdateForTuition(JSON.stringify(data));
            }
        }
    });
});