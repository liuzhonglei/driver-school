<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>订单信息-眉山瑞达驾校</title>
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
                <li><i class="fa fa-users"></i>订单管理</li>
                <li><i class="fa fa-user"></i>订单信息</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
        <div id="toolbar">
            <div class="form-inline" role="form">
                <div class="form-group">
                    <label>用户唯一标识:</label>
                    <input type="text" class="form-control" name="userUnique">
                </div>
                 <div class="form-group">
                     <label>订单号:</label>
                     <input type="text" class="form-control" name="outTradeNo">
                 </div>
                <div class="form-group">
                    <label>支付订单号:</label>
                    <input type="text" class="form-control" name="transactionNo">
                </div>
                <div class="form-group">
                    <label>预付单号:</label>
                    <input type="text" class="form-control" name="prepayId">
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

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/jsBackstage.jsp"></jsp:include>
<script src="${ctx}/js/trade/TradeService.js" type="text/javascript"></script>
<script src="${ctx}/js/trade/trade.js" type="text/javascript"></script>
</body>
</html>