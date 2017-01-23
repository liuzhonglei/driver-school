<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>修改密码--眉山瑞达驾校</title>
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
                    <li><i class="fa fa-home"></i>修改密码</li>
                </ol>
            </div>
        </div>
        <!-- 加入自己的内容-->
        <div class="row">
            <div class="col-md-12">
                <%--<form id = "register-form" class="form-horizontal">--%>
                <div class="panel panel-default" id="app">
                    <div class="panel-heading">
                        <h2><i class="fa fa-indent red"></i><strong>修改密码</strong></h2>
                    </div>
                    <div class="panel-body">
                        <form id = "password-form" class="form-horizontal">
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="username">用户名</label>
                                <div class="col-md-9">
                                    <input type="text" id="username" name="username" v-model="req.content.username" class="form-control" value="${pageContext.request.userPrincipal.name}" disabled="disabled">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="password">密码</label>
                                <div class="col-md-9">
                                    <input type="password" id="password" name="password" v-model="req.content.password" class="form-control" placeholder="请输入密码">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="confirm_password">确认密码</label>
                                <div class="col-md-9">
                                    <input type="password" id="confirm_password" name="confirmPassword" class="form-control" placeholder="请再次输入密码">
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
    <script src="${ctx}/plugins/jquery-form/jquery.form.js" ></script>
    <script src="${ctx}/plugins/jquery-validation/dist/jquery.validate.min.js" ></script>
    <script src="${ctx}/plugins/jquery-validation/src/localization/messages_zh.js" ></script>
    <script src="${ctx}/plugins/jquery.metadata/jquery.metadata.js" ></script>
    <script src="${ctx}/js/sysmanager/password.js" ></script>
    <script src="${ctx}/js/sysmanager/SysmanagerService.js" ></script>
</body>
</html>