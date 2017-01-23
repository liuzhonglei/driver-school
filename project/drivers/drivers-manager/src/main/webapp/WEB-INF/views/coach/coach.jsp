<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>教练信息-眉山瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/views/common/cssBackstage.jsp"></jsp:include>
</head>
<body  id="app">
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<jsp:include page="/WEB-INF/views/common/menu.jsp"></jsp:include>

<div class="main">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header"><i class="fa fa-laptop"></i> 工作台</h3>
            <ol class="breadcrumb">
                <li><i class="fa fa-home"></i><a href="${ctx}/index.html">首页</a></li>
                <li><i class="fa fa-users"></i>教练管理</li>
                <li><i class="fa fa-user"></i>教练信息管理</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <button type="button" class="btn btn-success form-control" data-toggle="modal" data-target="#myModal">
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
                    <label>姓名:</label>
                    <input type="text" class="form-control" name="name">
                </div>
                 <div class="form-group">
                     <label>手机号码:</label>
                     <input type="text" class="form-control" name="mobile">
                 </div>
                <div class="form-group">
                    <label>身份证号码:</label>
                    <input type="text" class="form-control" name="idcardNum">
                </div>
                <div class="form-group">
                    <label>车型:</label>
                    <select id="model" name="model" class="form-control" size="1">
                        <option value="" selected="selected" >请选择</option>
                        <option value="C1">C1</option>
                        <option value="C2">C2</option>
                        <option value="C3">C3</option>
                    </select>
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

<!-- 新增教练信息 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">新增教练</h4>
            </div>
            <div class="modal-body">
               <form id = "register-form" class="form-horizontal">
                   <div class="form-group">
                       <label for="name" class="col-sm-3 control-label">姓名*</label>
                       <div class="col-sm-9">
                            <input type="text" class="form-control" id="name" name="name" v-model="req.content.name" placeholder="请输入姓名">
                       </div>
                   </div>
                   <div class="form-group">
                       <label for="mobile" class="col-sm-3 control-label">手机号码*</label>
                       <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobile" name="mobile" v-model="req.content.mobile" class="form-control" placeholder="请输入手机号码">
                       </div>
                   </div>
                   <div class="form-group">
                       <label for="mobile2" class="col-sm-3 control-label">备用手机号码</label>
                       <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobile2" name="mobile2" v-model="req.content.mobile2" class="form-control" placeholder="请输入备用手机号码">
                       </div>
                   </div>
                   <div class="form-group">
                       <label for="select" class="col-sm-3 control-label">车型*</label>
                       <div class="col-sm-9">
                            <select id="select" name="model" v-model="req.content.model"  class="form-control" size="1">
                                <option value="" selected="selected" >请选择</option>
                                <option value="C1">C1</option>
                                <option value="C2">C2</option>
                                <option value="C3">C3</option>
                            </select>
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

<!-- 编辑教练信息 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="editModalLabel">编辑教练</h4>
            </div>
            <div class="modal-body">
                <form id = "edit-form" class="form-horizontal">
                    <input type="text" id="id-edit" name="id" v-model="editReq.content.id" hidden="hidden">
                    <div class="form-group">
                        <label for="name-edit" class="col-sm-3 control-label">姓名*</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="name-edit" name="name" v-model="editReq.content.name" placeholder="请输入姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile-edit" class="col-sm-3 control-label">手机号码*</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobile-edit" name="mobile" v-model="editReq.content.mobile" class="form-control" placeholder="请输入手机号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="mobile2-edit" class="col-sm-3 control-label">备用手机号码</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="mobile2-edit" name="mobile2" v-model="editReq.content.mobile2" class="form-control" placeholder="请输入备用手机号码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="model-edit" class="col-sm-3 control-label">车型*</label>
                        <div class="col-sm-9">
                            <select id="model-edit" name="model" v-model="editReq.content.model"  class="form-control" size="1">
                                <option value="" selected="selected" >请选择</option>
                                <option value="C1">C1</option>
                                <option value="C2">C2</option>
                                <option value="C3">C3</option>
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

<!-- 教练绑定微信信息 -->
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
                        <p>注意:您将为该教练绑定微信号,一个微信账号只能被绑定一次,绑定的微信号为该教练分配学员后进行消息推送。</p>
                    </div>

                    <input type="text" id="id-bind" name="id" v-model="bindReq.content.id" hidden="hidden">
                    <div class="form-group">
                        <label for="username-bind" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="username-bind" name="username" v-model="bindReq.content.name" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="wx-bind" class="col-sm-2 control-label">微信账号*</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control typeahead" id="wx-bind" name="username" v-model="editReq.content.wxNickname" placeholder="请输入微信账号">
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
<script src="${ctx}/js/coach/CoachService.js" type="text/javascript"></script>
<script src="${ctx}/js/coach/coach.js" type="text/javascript"></script>
</body>
</html>