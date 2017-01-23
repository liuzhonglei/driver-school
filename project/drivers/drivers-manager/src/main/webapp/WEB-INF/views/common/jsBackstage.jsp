<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-table/dist/extensions/editable/bootstrap-table-editable.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/x-editable/dist/bootstrap3-editable/js/bootstrap-editable.min.js" type="text/javascript"></script>

<script src="${ctx}/plugins/moment/min/moment.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/moment/locale/zh-cn.js" type="text/javascript"></script>
<script src="${ctx}/plugins/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

<script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/sortable.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/purify.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-fileinput/js/fileinput.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-fileinput/themes/fa/theme.js" type="text/javascript"></script>
<script src="${ctx}/plugins/bootstrap-fileinput/js/locales/zh.js" type="text/javascript"></script>

<script src="${ctx}/plugins/jquery-form/jquery.form.js" type="text/javascript"></script>
<script src="${ctx}/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="${ctx}/plugins/jquery-validation/src/localization/messages_zh.js" type="text/javascript"></script>
<script src="${ctx}/js/common/additional-methods.js" type="text/javascript"></script>
<script src="${ctx}/plugins/jquery.metadata/jquery.metadata.js" type="text/javascript"></script>

<script src="${ctx}/plugins/bootbox.js/bootbox.js" type="text/javascript"></script>

<script src="${ctx}/plugins/toastr/toastr.min.js"></script>
<script src="${ctx}/plugins/vue/dist/vue.js" type="text/javascript"></script>
<script>
    toastr.options = {
        "closeButton": true, //是否显示关闭按钮
        "debug": false, //是否使用debug模式
        "newestOnTop": true,
        "progressBar": true,
        "positionClass": "toast-top-center",//弹出窗的位置
        "preventDuplicates": false,
        "onclick": null,
        "showDuration": "300",//显示的动画时间
        "hideDuration": "1000",//消失的动画时间
        "timeOut": "5000", //展现时间
        "extendedTimeOut": "1000",//加长展示时间
        "showEasing": "swing",//显示时的动画缓冲方式
        "hideEasing": "linear",//消失时的动画缓冲方式
        "showMethod": "fadeIn",//显示时的动画方式
        "hideMethod": "fadeOut" //消失时的动画方式
    };
</script>