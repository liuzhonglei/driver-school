$(document).ready(function () {
    //表单校验
    var validator = $("#password-form").validate({
        errorElement: "span",
        rules:{
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            }
        },
        messages:{
        }
    });

    var service = SysmanagerService();
    var vm = new Vue({
        el: '#app',
        data: {
            req:{
                content: {
                    username: '',
                    password: ''
                }
            }
        },
        methods:{
            submit: function(event){
                if (validator.form()){
                    console.log('submit')
                    // event.preventDefault();
                    console.log(JSON.stringify(this.req))
                    service.updatePassword(JSON.stringify(this.req));

                }
            },
            reset: function () {
                validator.resetForm();
            }
        }
    })
});