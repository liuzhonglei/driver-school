<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>驾校信息管理-眉山瑞达驾校</title>
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
                    <li><i class="fa fa-car"></i>驾校管理</li>
                    <li><i class="fa fa-heart-o"></i>驾校信息管理</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <%--<div class="text-center">--%>
                            <%--<img class="img-profile" src="{{editReq.content.logUrl}}">--%>
                        <%--</div>--%>
                        <h3 class="text-center"><strong>{{editReq.content.name}}</strong></h3>
                        <h4 class="text-center"><small><i class="fa fa-map-marker"></i> {{editReq.content.addr}}</small></h4>
                        <hr>
                        <div class="text-center">
                            {{editReq.content.slogan}}
                        </div>
                        <hr>
                        <%--<div class="row text-center">--%>
                            <%--{{editReq.content.introduction}}--%>
                        <%--</div>--%>
                        <hr>
                        <h4><strong>通用信息</strong></h4>
                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-building-o"></i> 公司</div>
                                {{editReq.content.name}}
                            </li>
                            <li>
                                <div><i class="fa fa-thumbs-up"></i> 管理者</div>
                                {{editReq.content.administrators}}
                            </li>
                        </ul>
                        <hr>
                        <h4><strong>联系方式</strong></h4>
                        <ul class="profile-details">
                            <li>
                                <div><i class="fa fa-phone"></i> 座机</div>
                                +028 {{editReq.content.phone}}
                            </li>
                            <li>
                                <div><i class="fa fa-tablet"></i> 手机</div>
                                +86 {{editReq.content.mobile}}
                            </li>
                            <li>
                                <div><i class="fa fa-envelope"></i> 电子邮箱</div>
                                {{editReq.content.email}}
                            </li>
                            <li>
                                <div><i class="fa fa-map-marker"></i> 详细地址</div>
                                四川省<br/>
                                彭山市<br/>
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
                        <h2><i class="fa fa-heart-o red"></i><strong>驾校信息变更</strong></h2>
                    </div>
                    <div class="panel-body">
                        <%--<form id = "form" action="/api/schools/upload" method="post" enctype="multipart/form-data">--%>
                            <%--<div class="form-group text-center">--%>
                                <%--<div id="kv-avatar-errors-2" class="center-block" style="width:800px;display:none"></div>--%>
                                <%--<div class="kv-avatar center-block" style="width:300px">--%>
                                    <%--<input id="avatar-2" name="avatar" type="file" class="file-loading">--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</form>--%>
                        <form class="form-horizontal" role="form">
                            <input type="text" value="{{editReq.content.id}}" hidden="hidden">
                            <div class="form-group">
                                <label class="control-label">驾校</label>
                                <input type="text" class="form-control" v-model="editReq.content.name" value="{{editReq.content.name}}" >
                            </div>
                            <div class="form-group">
                                <label class="control-label">管理员</label>
                                <input type="text" class="form-control" v-model="editReq.content.administrators" value="{{editReq.content.administrators}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">电话号码</label>
                                <input type="text" class="form-control" v-model="editReq.content.phone" value="{{editReq.content.phone}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">手机号码</label>
                                <input type="text" class="form-control" v-model="editReq.content.mobile"  value="{{editReq.content.mobile}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">电子邮箱</label>
                                <input type="email" class="form-control" v-model="editReq.content.email" value="{{editReq.content.email}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">地址</label>
                                <input type="text" class="form-control" v-model="editReq.content.addr" value="{{editReq.content.addr}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">宣传口号</label>
                                <input type="text" class="form-control" v-model="editReq.content.slogan"  value="{{editReq.content.slogan}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">简介</label>
                                <textarea class="form-control" rows="3" v-model="editReq.content.introduction">{{editReq.content.introduction}}</textarea>
                            </div>
                        </form>
                        <div class="pull-right">
                            <button class="btn btn-primary" v-on:click="update()">更新</button>
                         </div>
                    </div>
                </div>
            </div><!--/.col-->
        </div><!--/.row profile-->
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>

    <script src="${ctx}/js/school/SchoolService.js" ></script>
    <script src="${ctx}/js/school/school.js" ></script>

    <script>
        var btnCust = '<button class="btn btn-default" title="上传" ' +
                '>' +
                '<i class="fa fa-upload"></i>' +
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