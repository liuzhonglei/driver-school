<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>系统管理员-眉山瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/cssBackstage.jsp"></jsp:include>
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
                    <li><i class="fa fa-laptop"></i>管理员信息</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="form-inline" role="form">
                    <div class="form-group">
                        <button type="button" class="btn btn-success form-control" data-toggle="modal" data-target="#registerModal">
                            <span class='glyphicon glyphicon-plus'>新增</span>
                        </button>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-warning form-control" v-on:click="batchDelete()">
                            <span class='glyphicon glyphicon-trash'>删除</span>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
            <div id="toolbar">
                <div class="form-inline" role="form">
                    <div class="form-group">
                        <label>用户姓名:</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="form-group">
                        <label>真实姓名:</label>
                        <input type="text" class="form-control" name="name">
                    </div>
                    <div class="form-group">
                        <label>手机号码:</label>
                        <input type="text" class="form-control" name="mobile">
                    </div>
                    <button id="ok" type="button" class="btn btn-default">
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    </button>
                </div>
            </div>
            </div>
            <table id="table"></table>
        </div>
    </div>

    <!-- 新增系统管理员model -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="registerModalLabel">新增系统管理员</h4>
                </div>
                <div class="modal-body">
                    <form id = "register-form" class="form-horizontal">
                        <div class="form-group">
                            <label for="username-register" class="col-sm-2 control-label">用户名*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username-register" name="username" v-model="req.content.username" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="password-register" class="col-sm-2 control-label">密码*</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="password-register" name="password" v-model="req.content.password" placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="confirmPassword-register" class="col-sm-2 control-label">确认密码*</label>
                            <div class="col-sm-10">
                                <input type="password" class="form-control" id="confirmPassword-register" name="confirmPassword" v-model="req.content.confirmPassword" placeholder="请再次输入密码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name-register" class="col-sm-2 control-label">真实姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name-register" name="name" v-model="req.content.name" placeholder="请输入真实姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="sex-register">性别</label>
                            <div class="col-sm-10">
                                <select id="sex-register" name="sex" v-model="req.content.sex"  class="form-control" size="1">
                                    <option value="" selected="selected">请选择</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="birthday-register">出生日期</label>
                            <div class='col-sm-10 input-group date' id='datetimepicker-register'>
                                <input type='text' id="birthday-register" class="form-control" name="birthday" v-model="req.content.birthday"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobile-register" class="col-sm-2 control-label">手机号码*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mobile-register" name="mobile" v-model="req.content.mobile" class="form-control" placeholder="请输入手机号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="email-register">电子邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" id="email-register" name="email" v-model="req.content.email" class="form-control" placeholder="请输入电子邮箱">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" v-on:click="save()">保存</button>
                </div>
            </div>
        </div>
    </div>

    <!-- 编辑系统管理员信息 -->
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="editModalLabel">编辑系统管理员</h4>
                </div>
                <div class="modal-body">
                    <form id = "edit-form" class="form-horizontal">
                        <input type="text" id="id-edit" name="id" v-model="editReq.content.id" hidden="hidden">
                        <div class="form-group">
                            <label for="username-edit" class="col-sm-2 control-label">用户名*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username-edit" name="username" v-model="editReq.content.username" placeholder="请输入用户名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name-edit" class="col-sm-2 control-label">真实姓名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="name-edit" name="name" v-model="editReq.content.name" placeholder="请输入真实姓名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="sex-edit">性别</label>
                            <div class="col-sm-10">
                                <select id="sex-edit" name="sex" v-model="editReq.content.sex"  class="form-control" size="1">
                                    <option value="" selected="selected">请选择</option>
                                    <option value="1">男</option>
                                    <option value="2">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="birthday-edit">出生日期</label>
                            <div class='col-sm-10 input-group date' id='datetimepicker-edit'>
                                <input type='text' id="birthday-edit" class="form-control" name="birthday" v-model="editReq.content.birthday"/>
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="mobile-edit" class="col-sm-2 control-label">手机号码*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="mobile-edit" name="mobile" v-model="editReq.content.mobile" class="form-control" placeholder="请输入手机号码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label" for="email-edit">电子邮箱</label>
                            <div class="col-sm-10">
                                <input type="email" id="email-edit" name="email" v-model="editReq.content.email" class="form-control" placeholder="请输入电子邮箱">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" v-on:click="update()">保存</button>
                </div>
            </div>
        </div>
    </div>
    <!-- 系统管理员绑定微信信息 -->
    <div class="modal fade" id="bindModal" tabindex="-1" role="dialog" aria-labelledby="bindModalLabel" >
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="bindModalLabel">绑定微信信息</h4>
                </div>
                <div class="modal-body">
                    <form id = "bind-form" class="form-horizontal">
                        <div class="form-group">
                            <p>请注意:一个微信账号只能被绑定一次,绑定的微信号在有用户进行微信支付后进行消息推送。</p>
                        </div>
                        <input type="text" id="id-bind" name="id" v-model="bindReq.content.id" hidden="hidden">
                        <div class="form-group">
                            <label for="username-bind" class="col-sm-2 control-label">用户名*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="username-bind" name="username" v-model="bindReq.content.username" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="wx-bind" class="col-sm-2 control-label">微信账号*</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control typeahead" id="wx-bind" name="wx_nickname" placeholder="请输入微信账号">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" v-on:click="bindWeixin()">绑定</button>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>
    <script src="${ctx}/plugins/bootstrap3-typeahead/bootstrap3-typeahead.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/sysmanager/SysmanagerService.js" type="text/javascript"></script>
    <script src="${ctx}/js/sysmanager/sysmanager.js" type="text/javascript"></script>
</body>
</html>