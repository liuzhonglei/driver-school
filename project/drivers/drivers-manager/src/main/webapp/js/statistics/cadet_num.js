$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/statistics/cadet/num',
        showFooter: true,
        queryParams: function(params) {
            $('#toolbar').find('input[name]').each(function () {
                params[$(this).attr('name')] = $(this).val();
            });
            var type = $('#type option:selected').val();
            params['type'] = type;
            return params;
        },
        clickToSelect: true,
        undefinedText: '-',
        showRefresh: true,
        pagination: true,
        sortOrder: 'desc',
        columns: [{
            field: 'times',
            title: '时间段',
            width: '40%',
            align: 'center',
            footerFormatter: function(data){
                return '总人数';
            }
        },{
            field: 'totalNum',
            title: '人数（个）',
            width: '40%',
            align: 'center',
            footerFormatter: function(data){
                var allTotalAmount = 0;
                $.each(data,function(n,value) {
                    allTotalAmount = allTotalAmount + value.totalNum;
                });
                return allTotalAmount ;
            }
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});