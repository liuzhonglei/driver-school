$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/statistics/cadet/pay',
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
                return '总金额';
            }
        },{
            field: 'totalAmount',
            title: '金额(元)',
            width: '40%',
            align: 'center',
            formatter: function(value, row){
                return '<div>' +
                    '<i class="glyphicon glyphicon-usd"></i>' +
                    value +
                    '</div>';
            },
            footerFormatter: function(data){
                var allTotalAmount = 0;
                $.each(data,function(n,value) {
                    allTotalAmount = allTotalAmount + value.totalAmount;
                });
                return '<div>' +
                    '<i class="glyphicon glyphicon-usd"></i>' +
                    allTotalAmount +
                    '</div>';
            }
        }]
    });

    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
});