$(document).ready(function () {
    $('#datetimepicker1').datetimepicker({
        locale: 'zh-cn',
        // defaultDate: "11/1/2013",
        format: 'YYYY-MM-DD'
    });

    //表单校验
    var validator = $("#register-form").validate({
        errorElement: "span",
        rules:{
            username: {
                required: true,
                rangelength:[2,10],
                remote:{
                    url: '/api/sysmanagers/validateUsername',
                    type: 'get',
                    dataType: 'json'
                }
            },
            password: {
                required: true,
                minlength: 5
            },
            confirmPassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            },
            birthday:{
                dateISO:true
            },
            age:{
                number:true
            },
            mobile:{
                number:true
            },
            email:{
                required: false,
                email: true
            }
        },
        messages:{
            username:{
                required: "请输入用户名",
                remote: "用户名已存在!"
            }
        }
    });

    var service = SysmanagerService();
    var vm = new Vue({
        el: '#app',
        data: {
            req:{
                content: {
                    username: '',
                    password: '',
                    name: '',
                    sex: 0,
                    age: '',
                    mobile: '',
                    email: ''
                }
            }
        },
        methods:{
            submit: function(event){
                if (validator.form()){
                    // event.preventDefault();
                    service.register(JSON.stringify(this.req));
                }
            },
            reset: function () {
                validator.resetForm();
            }
        }
    });
});