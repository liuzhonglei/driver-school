$(document).ready(function () {
    $('#datetimepicker1').datetimepicker({
        locale: 'zh-cn',
        format: 'YYYY-MM-DD'
    });
    vm.getByUsername();
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

var vm = new Vue({
    el: '#app',
    data: {
        editReq:{
            content: {
                id: '',
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
        getByUsername: function(){
            service.getByUsername();
        },
        submit: function(){
            if (validator.form()){
                service.update(JSON.stringify(this.editReq));
            }
        },
        reset: function () {
            validator.resetForm();
        }
    }
});
var service = SysmanagerService(vm);