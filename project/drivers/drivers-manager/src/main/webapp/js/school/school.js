var vm = new Vue({
    el: '#app',
    data: {
        editReq: {
            content: {
                id: '',
                name: '',
                logoUrl: '',
                mobile: '',
                phone: '',
                email: '',
                addr: '',
                slogan: '',
                introduction: '',
                administrators: ''
            }
        }
    },
    methods:{
        get: function(){
            service.getShcool();
        },
        update: function () {
            service.updateSchool(JSON.stringify(this.editReq));
        }
    }
});
var service = SchoolService(vm);

$(document).ready(function () {
    vm.get();
});




