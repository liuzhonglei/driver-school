$(document).ready(function () {
    $('#table').bootstrapTable({
        toolbar: '#toolbar',
        url: '/api/trades/_search/trades',
        contentType: 'application/json',
        method: 'get',
        queryParams: function (params) {
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
        pageList: "[5,10, 20, 50]",
        sortName: 'id',
        sortOrder: 'desc',
        columns: [{
            field: 'state',
            checkbox: true,
            width: '2%'
        }, {
            field: 'id',
            title: '序号',
            width: '3%',
            align: 'center'
        }, {
            field: 'userUnique',
            title: '用户唯一标识',
            width: '10%',
            align: 'center'
        }, {
            field: 'goods',
            title: '商品',
            width: '10%',
            align: 'center'
        }, {
            field: 'outTradeNo',
            title: '订单号',
            width: '10%',
            align: 'center'
        }, {
            field: 'orderFee',
            title: '金额(元)',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                return row.orderFee/100;
            }
        }, {
            field: 'orderStatus',
            title: '订单状态',
            width: '5%',
            align: 'center',
            formatter: function(value, row, index) {
                if(value == 1){
                    return "未支付";
                }else if (value == 2){
                    return "已支付";
                }else{
                    return "未知";
                }
            }
        }, {
            field: 'transactionNo',
            title: '支付订单号',
            width: '10%',
            align: 'center'
        }, {
            field: 'prepayId',
            title: '预付单号',
            width: '10%',
            align: 'center',
            visible: false
        }, {
            field: 'signType',
            title: '签名类型',
            width: '5%',
            align: 'center'
        }
        // , {
        //     field: 'sign',
        //     title: '签名',
        //     width: '10%',
        //     align: 'center'
        // }, {
        //     field: 'nonceStr',
        //     title: '随机字符串',
        //     width: '5%',
        //     align: 'center'
        // }
        , {
            field: 'timeStamp',
            title: '时间戳',
            width: '5%',
            align: 'center'
        }
        ]
    });
    $('#ok').click(function () {
        $('#table').bootstrapTable('refresh');
    });
})

window.operateEvents = {
};