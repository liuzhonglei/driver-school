function SuggestionService(){
    var obj   = new Object();

    obj.delete = function(id){
        $.ajax({
            url: '/api/suggestions/invalid/' + id,
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            // data:data,
            success: function(data){
                if(data.status = 1000){
                    $('#table').bootstrapTable('refresh');
                }
            }
        });
    };
    obj.close = function(data){
        $.ajax({
            url: '/api/suggestions/close',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                if(data.status = 1000){
                    $('#table').bootstrapTable('refresh');
                }
            }
        });
    };
    obj.reply = function(data){
        $.ajax({
            url: '/api/feekbacks/create',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                if(data.status = 1000){
                    $('#table').bootstrapTable('refresh');
                }
            }
        });
    };
    obj.feekback = function(data){
        $.ajax({
            url: '/api/feekbacks/getFeekback',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(data){
                if(data.status = 1000){
                    $('#feekback-table').bootstrapTable({data: data});
                }
            }
        });
    };
    return obj;
}