<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>个人基本信息-眉山瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/cssBackstage.jsp"></jsp:include>
    <style>
        .kv-avatar .file-preview-frame,.kv-avatar .file-preview-frame:hover {
            margin: 0;
            padding: 0;
            border: none;
            box-shadow: none;
            text-align: center;
        }
        .kv-avatar .file-input {
            display: table-cell;
            max-width: 220px;
        }
    </style>
</head>
<body id="app">
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

    <div class="main">
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header"><i class="fa fa-laptop"></i> 工作台</h3>
                <ol class="breadcrumb">
                    <li><i class="fa fa-home"></i><a href="${ctx}/index.html">首页</a></li>
                    <li><i class="fa fa-laptop"></i>系统管理员</li>
                    <li><i class="fa fa-heart-o"></i>基本信息</li>
                </ol>
            </div>
        </div>

        <div class="row profile">

            <div class="col-md-5">

                <div class="panel panel-default">
                    <div class="panel-body">
                        <%--<div class="text-center">--%>
                            <%--<img class="img-profile" src="{{editReq.content.avatarUrl}}">--%>
                        <%--</div>--%>

                        <h3 class="text-center"><strong>{{editReq.content.username}}</strong></h3>
                        <h4 class="text-center"><small><i class="fa fa-map-marker"></i> {{editReq.content.addr}}</small></h4>
                        <hr>
                        <h4><strong>通用信息</strong></h4>

                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-building-o"></i> 真实姓名</div>
                                {{editReq.content.name}}
                            </li>
                            <li>
                                <div><i class="fa fa-thumbs-up"></i> 性别</div>
                                {{editReq.content.sex}}
                            </li>
                            <li>
                                <div><i class="fa fa-thumbs-up"></i> 生日</div>
                                {{editReq.content.birthday}}
                            </li>
                        </ul>

                        <hr>

                        <h4><strong>联系方式</strong></h4>

                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-tablet"></i> 手机</div>
                                +86 {{editReq.content.mobile}}
                            </li>
                            <li>
                                <div><i class="fa fa-envelope"></i> 电子邮箱</div>
                                {{editReq.content.email}}
                            </li>
                        </ul>

                        <h4><strong>详细信息</strong></h4>

                        <div class="profile-details">
                            {{editReq.content.introduction}}
                         </div>
                    </div>

                </div>

            </div><!--/.col-->

            <div class="col-md-7">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2><i class="fa fa-heart-o red"></i><strong>个人基本信息变更</strong></h2>
                    </div>
                    <div class="panel-body">
                        <!-- the avatar markup -->
                        <%--<div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>--%>
                        <%--<form class="text-center" action="/avatar_upload.php" method="post" enctype="multipart/form-data">--%>
                            <%--<div class="kv-avatar center-block" style="width:300px">--%>
                                <%--<input id="avatar-2" name="avatar-2" type="file" class="file-loading">--%>
                            <%--</div>--%>
                        <%--</form>--%>

                        <form id="register-form" class="form-vertical hover-stripped" role="form">
                            <input type="text" value="{{editReq.content.id}}" hidden="hidden">
                            <div class="form-group">
                                <label class="control-label">用户名</label>

                                <input type="text" class="form-control" v-model="editReq.content.username" value="${pageContext.request.userPrincipal.name}" >
                            </div>
                            <div class="form-group">
                                <label class="control-label">真实姓名</label>

                                <input type="text" class="form-control" v-model="editReq.content.name" value="{{editReq.content.name}}" >
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="select">性别</label>
                                <select id="select" name="sex" v-model="editReq.content.sex"  class="form-control" size="1">
                                    <option value="0">请选择</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label class="control-label" for="birthday">出生日期</label>
                                <div class='input-group date' id='datetimepicker1'>
                                    <input type='text' id="birthday" class="form-control" name="birthday" v-model="editReq.content.birthday"/>
                                    <span class="input-group-addon">
                                        <span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label">手机号码</label>
                                <input type="text" class="form-control" v-model="editReq.content.mobile"  value="{{editReq.content.mobile}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">电子邮箱</label>
                                <input type="email" class="form-control" v-model="editReq.content.email" value="{{editReq.content.email}}">
                            </div>
                        </form>
                        <div class="pull-right">
                            <button class="btn btn-primary" type="submit" v-on:click="submit()">更新</button>
                        </div>
                    </div>
                </div>

            </div><!--/.col-->

        </div><!--/.row profile-->
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>

    <script src="${ctx}/js/sysmanager/SysmanagerService.js" ></script>
    <script src="${ctx}/js/sysmanager/profile.js" ></script>

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
            defaultPreviewContent: '<img src="/upload/avatar/036b00c4c8818f7f6c4284108589eb78.jpg" alt="logo" style="width:160px"><h6 class="text-muted">Click to select</h6>',
            layoutTemplates: {main2: '{preview} ' +  btnCust + ' {remove} {browse}'},
            allowedFileExtensions: ["jpg", "png", "gif"]
        });
    </script>
</body>
</html>