<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>注册-眉山瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

    <div class="main">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-laptop"></i> 工作台</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="${ctx}/index.html">首页</a></li>
                    <li><i class="fa fa-home"></i>系统管理员</li>
                    <li><i class="fa fa-home"></i>注册</li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <%--<form id = "register-form" class="form-horizontal">--%>
                <div class="panel panel-default" id="app">
                    <div class="panel-heading">
                        <h2><i class="fa fa-indent red"></i><strong>管理员注册</strong></h2>
                    </div>
                    <div class="panel-body">
                        <!-- the avatar markup -->
                        <%--<div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>--%>
                        <%--<form class="text-center" action="/avatar_upload.php" method="post" enctype="multipart/form-data">--%>
                            <%--<div class="kv-avatar center-block" style="width:300px">--%>
                                <%--<input id="avatar-2" name="avatar-2" type="file" class="file-loading">--%>
                            <%--</div>--%>
                        <%--</form>--%>

                        <form id = "register-form" action="/api/sysmanagers" method="post" enctype="application/json" class="form-horizontal">
                            <input type="text" id="avatar" name="avatar" v-model="req.content.avatar" hidden="hidden">
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="username">用户名*</label>
                                <div class="col-md-9">
                                    <input type="text" id="username" name="username" v-model="req.content.username" class="form-control" placeholder="请输入用户名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="password">密码*</label>
                                <div class="col-md-9">
                                    <input type="password" id="password" name="password" v-model="req.content.password" class="form-control" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="confirmPassword">确认密码*</label>
                                <div class="col-md-9">
                                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control" placeholder="请再次输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="name">真实姓名</label>
                                <div class="col-md-9">
                                    <input type="text" id="name" name="name" v-model="req.content.name" class="form-control" placeholder="请输入真实姓名">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="select">性别</label>
                                <div class="col-md-9">
                                    <select id="select" name="sex" v-model="req.content.sex"  class="form-control" size="1">
                                        <option value="0">请选择</option>
                                        <option value="1">男</option>
                                        <option value="2">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="birthday">出生日期</label>
                                <div class="col-md-9">
                                    <div class='input-group date' id='datetimepicker1'>
                                        <input type='text' id="birthday" class="form-control" name="birthday" v-model="req.content.birthday"/>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="age">年龄</label>
                                <div class="col-md-9">
                                    <input type="text" id="age" name="age" v-model="req.content.age" class="form-control" placeholder="请输入年龄">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="mobile">手机号码</label>
                                <div class="col-md-9">
                                    <input type="text" id="mobile" name="mobile" v-model="req.content.mobile" class="form-control" placeholder="请输入手机号码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="email-input">电子邮箱</label>
                                <div class="col-md-9">
                                    <input type="email" id="email-input" name="email" v-model="req.content.email" class="form-control" placeholder="请输入电子邮箱">
                                </div>
                            </div>
                            <br>
                        </form>
                    </div>
                    <div class="panel-footer">
                        <button class="btn btn-sm btn-success" v-on:click="submit()"><i class="fa fa-dot-circle-o"></i> 提交</button>
                        <button class="btn btn-sm btn-danger" v-on:click="reset()"><i class="fa fa-ban"></i> 重置</button>
                    </div>
                </div>
                <%--</form>--%>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/canvas-to-blob.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/sortable.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-fileinput/js/plugins/purify.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-fileinput/js/fileinput.min.js"></script>
    <script src="${ctx}/plugins/bootstrap-fileinput/themes/fa/theme.js"></script>
    <script src="${ctx}/plugins/bootstrap-fileinput/js/locales/zh.js"></script>

    <script src="${ctx}/plugins/moment/min/moment.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/moment/locale/zh-cn.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>

    <script src="${ctx}/plugins/jquery-form/jquery.form.js" ></script>

    <script src="${ctx}/plugins/vue/dist/vue.js" ></script>

    <script src="${ctx}/plugins/jquery-validation/dist/jquery.validate.min.js" ></script>
    <script src="${ctx}/plugins/jquery-validation/src/localization/messages_zh.js" ></script>
    <script src="${ctx}/plugins/jquery.metadata/jquery.metadata.js" ></script>

    <script src="${ctx}/js/sysmanager/SysmanagerService.js" ></script>
    <script src="${ctx}/js/sysmanager/register.js" ></script>
    <script>
        var btnCust = '<button type="button" class="btn btn-default" title="Add picture tags" ' +
                'onclick="alert(\'Call your custom code here.\')">' +
                '<i class="glyphicon glyphicon-tag"></i>' +
                '</button>';
        $("#avatar-2").fileinput({
            overwriteInitial: true,
            maxFileSize: 1500,
            showClose: false,
            showCaption: false,
            showBrowse: false,
            browseOnZoneClick: true,
            removeLabel: '',
            removeIcon: '<i class="glyphicon glyphicon-remove"></i>',
            removeTitle: 'Cancel or reset changes',
            elErrorContainer: '#kv-avatar-errors-2',
            msgErrorClass: 'alert alert-block alert-danger',
            defaultPreviewContent: '<img src="/upload/logo/logo.jpg" alt="logo" style="width:160px" class="img-circle"><h6 class="text-muted">Click to select</h6>',
            layoutTemplates: {main2: '{preview} ' +  btnCust + ' {remove} {browse}'},
            allowedFileExtensions: ["jpg", "png", "gif"]
        });
    </script>
</body>
</html>