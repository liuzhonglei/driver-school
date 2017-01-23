function SuggestionService(){
    var obj   = new Object();
    obj.register = function(data){
        $.ajax({
            url: '/api/suggestions/create',
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            method: 'POST',
            data:data,
            success: function(result){
                alert("感谢你的投诉建议,我们会及时处理!如有疑问请联系18782278582.");
            }
        });
    };
    return obj;
}