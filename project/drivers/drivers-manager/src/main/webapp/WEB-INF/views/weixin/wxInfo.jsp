<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>公众号信息管理-眉山瑞达驾校</title>
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
                    <li><i class="fa fa-car"></i>微信公众号管理</li>
                    <li><i class="fa fa-heart-o"></i>公众号基本信息管理</li>
                </ol>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h2><i class="fa fa-heart-o red"></i><strong>公众号基本信息</strong></h2>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <input type="text" value="{{editReq.content.id}}" hidden="hidden">
                            <div class="form-group">
                                <label class="control-label">公众账号ID</label>
                                <input type="text" class="form-control" v-model="editReq.content.appId" value="{{editReq.content.appId}}" >
                            </div>
                            <div class="form-group">
                                <label class="control-label">公众账号密钥</label>
                                <input type="text" class="form-control" v-model="editReq.content.appSecret" value="{{editReq.content.appSecret}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">商户号</label>
                                <input type="text" class="form-control" v-model="editReq.content.partnerId"  value="{{editReq.content.partnerId}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">商户key</label>
                                <input type="email" class="form-control" v-model="editReq.content.partnerKey" value="{{editReq.content.partnerKey}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">商户支付key</label>
                                <input type="text" class="form-control" v-model="editReq.content.paySignKey" value="{{editReq.content.paySignKey}}">
                            </div>
                            <div class="form-group">
                                <label class="control-label">password</label>
                                <input type="text" class="form-control" v-model="editReq.content.password" value="{{editReq.content.password}}" disabled>
                            </div>
                            <div class="form-group">
                                <label class="control-label">menuOpenType</label>
                                <input type="text" class="form-control" v-model="editReq.content.menuOpenType" value="{{editReq.content.menuOpenType}}" disabled>
                            </div>
                            <div class="form-group">
                                <label class="control-label">isOpenSubMch</label>
                                <input type="text" class="form-control" v-model="editReq.content.isOpenSubMch" value="{{editReq.content.isOpenSubMch}}" disabled>
                            </div>
                            <div class="form-group">
                                <label class="control-label">accessToken</label>
                                <input type="text" class="form-control" v-model="editReq.content.accessToken" value="{{editReq.content.accessToken}}" disabled>
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

    <script src="${ctx}/js/weixin/wxInfoService.js" ></script>
    <script src="${ctx}/js/weixin/wxInfo.js" ></script>

</body>
</html>