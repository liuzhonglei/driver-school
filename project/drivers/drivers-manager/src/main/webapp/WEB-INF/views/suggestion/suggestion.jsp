<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>投诉建议-眉山市瑞达驾校</title>
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
                <li><i class="fa fa-phone-square"></i>投诉建议</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
        <div id="toolbar">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <label>投诉人:</label>
                    <input type="text" class="form-control" name="name">
                </div>
                <div class="form-group">
                    <label>手机号码:</label>
                    <input type="text" class="form-control" name="mobile">
                </div>
                <div class="form-group">
                    <label>状态:</label>
                    <select id="businessStatus" class="form-control">
                        <option value="0">所有</option>
                        <option value="1">未处理</option>
                        <option value="2">正在处理</option>
                        <option value="3">已处理</option>
                    </select>
                </div>
                <div class="form-group">
                    <label>投诉时间:</label>
                    <%--<input type="text" class="form-control" name="dataUpdateDatetime">--%>
                    <div class='input-group date' id='datetimepicker1'>
                        <input type='text' class="form-control" name="startTime"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
                    ~
                    <div class='input-group date' id='datetimepicker2'>
                        <input type='text' class="form-control" name="endTime"/>
                        <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                    </div>
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


<!-- 回复model -->
<div class="modal fade" id="replyModal" tabindex="-1" role="dialog" aria-labelledby="replyModalLabel" >
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="replyModalLabel">投诉回复</h4>
            </div>
            <div class="modal-body">
                <form id = "bind-form" class="form-horizontal">
                    <div class="form-group">
                        <p>请注意:您回复的内容会同步推送到用户微信上。</p>
                    </div>
                    <input type="text" id="suggestionId-reply" name="suggestionId" v-model="replyReq.content.suggestionId" hidden="hidden">
                    <div class="form-group">
                        <label for="suggestionName-reply" class="col-sm-2 control-label">投诉人:</label>
                        <div class="col-sm-10">
                            <input type="text" id="suggestionName-reply" name="suggestionName" v-model="replyReq.content.suggestionName" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="suggestionContent-reply" class="col-sm-2 control-label">投诉内容:</label>
                        <div class="col-sm-10">
                            <textarea name="suggestionContent"id="suggestionContent-reply" class="form-control" rows="4" v-model="replyReq.content.suggestionContent" readonly></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="content-reply" class="col-sm-2 control-label">回复:</label>
                        <div class="col-sm-10">
                            <textarea name="message"id="content-reply" class="form-control" placeholder="内容" rows="6" v-model="replyReq.content.content" required="required"></textarea>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" v-on:click="reply()">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalTable" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">投诉处理详情</h4>
            </div>
            <div class="modal-body">
                <table id="feekback-table">
                    <thead>
                    <tr>
                        <th data-field="opType">操作类型</th>
                        <th data-field="opName">操作名称</th>
                        <th data-field="content">反馈信息</th>
                        <th data-field="dataUpdater">操作人</th>
                        <th data-field="dataUpdateDatetime">操作时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>
<script src="${ctx}/js/suggestion/SuggestionService.js" type="text/javascript"></script>
<script src="${ctx}/js/suggestion/suggestion.js" type="text/javascript"></script>
</body>
</html>