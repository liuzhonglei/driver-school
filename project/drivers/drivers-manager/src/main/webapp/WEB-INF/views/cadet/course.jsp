<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学员课程管理-眉山瑞达驾校</title>
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
                <li><i class="fa fa-home"></i><a href="index.html">首页</a></li>
                <li><i class="fa fa-laptop"></i>学员管理</li>
                <li><i class="fa fa-laptop"></i>学员课程管理</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
        <div id="toolbar">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <label>姓名:</label>
                    <input type="text" class="form-control" name="name">
                </div>
                 <div class="form-group">
                     <label>手机号码:</label>
                     <input type="text" class="form-control" name="mobile">
                  </div>
                <div class="form-group">
                    <label>微信号:</label>
                    <input type="text" class="form-control" name="weixinNum">
                </div>
                <div class="form-group">
                    <label>身份证:</label>
                    <input type="text" class="form-control" name="idcardNum">
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

<!-- 编辑学员课程信息Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="editModalLabel">编辑学员课程信息</h4>
            </div>
            <div class="modal-body">
                <form id = "edit-form" class="form-horizontal">
                    <input type="text" id="id-edit" name="id" v-model="editReq.content.id" />
                    <input type="text" id="cadetId-edit" name="cadetId" v-model="editReq.content.cadetId" />
                    <div class="form-group">
                        <label for="username-edit" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username-edit" name="username" v-model="editReq.content.username" placeholder="请输入用户名" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="name-edit" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name-edit" name="name" v-model="editReq.content.name" placeholder="请输入姓名" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile-edit" class="col-sm-2 control-label">手机号码</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="mobile-edit" name="mobile" v-model="editReq.content.mobile" placeholder="请输入手机号码" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idcardNum-edit" class="col-sm-2 control-label">身份证</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idcardNum-edit" name="idcardNum" v-model="editReq.content.idcardNum" placeholder="请输入身份证号码" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="course-edit" class="col-sm-2 control-label">课程</label>
                        <div class="col-sm-10">
                            <select id="course-edit" name="model" v-model="editReq.content.course"  class="form-control" size="1">
                                <option value="" selected="selected" >请选择</option>
                                <option value="1">科目1</option>
                                <option value="2">科目2</option>
                                <option value="3">科目3</option>
                                <option value="4">科目4</option>
                            </select>
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

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>

<script src="${ctx}/js/cadet/CadetService.js" type="text/javascript"></script>
<script src="${ctx}/js/cadet/course.js" type="text/javascript"></script>
</body>
</html>