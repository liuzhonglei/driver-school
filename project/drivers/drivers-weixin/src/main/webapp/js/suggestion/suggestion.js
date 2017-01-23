$(document).ready(function () {
    /**
     * 投诉建议表单校验
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
            },
            message:{
                required: true
            }
        },
        messages:{
            name:{
                required: "请输入您的姓名,方便我们联系您",
            },mobile:{
                required: "请输入您的手机号,方便我们联系您",
                isMobile:"您输入的手机号有误,请重新输入"
            },message:{
                required: "请输入您的投诉内容"
            }
        }
    });
    var vm =new Vue({
        el: '#app',
        data: {
            req:{
                content: {
                    name: '',
                    mobile: '',
                    content: '',
                    appType: 3,
                    dataCreator: 'weixin',
                    dataUpdater: 'weixin'
                }
            }
        },
        methods:{
            submit: function(event){
                // event.preventDefault();
                if (registerValidator.form()){
                    console.log(JSON.stringify(this.req));
                    service.register(JSON.stringify(this.req));
                }
                this.req.content.name = '';
                this.req.content.mobile = '';
                this.req.content.content = '';
            }
        }
    });

    var service = SuggestionService();
});


