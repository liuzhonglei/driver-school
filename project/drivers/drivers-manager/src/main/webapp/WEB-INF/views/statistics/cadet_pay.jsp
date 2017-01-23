<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>学员缴费信息统计-眉山瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
    <link href="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet">
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
                    <li><i class="fa fa-bar-chart-o"></i>统计信息</li>
                    <li><i class="fa fa-bar-chart-o"></i>学员费用统计</li>
                </ol>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div id="toolbar"><!-- start toolbar -->
                    <div class="form-inline" role="form">
                        <div class="form-group">
                            <label for="type">统计类型:</label>
                            <select id="type" class="form-control">
                                <option value="1">按年</option>
                                <option value="2">按月</option>
                                <option value="3">按日</option>
                            </select>
                        </div>
                        <button id="ok" type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        </button>
                </div>
            </div><!-- end toolbar -->

            <table id="table"></table>
             </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
    <script src="${ctx}/plugins/bootstrap-table/dist/bootstrap-table.min.js" type="text/javascript"></script>
    <script src="${ctx}/plugins/bootstrap-table/dist/locale/bootstrap-table-zh-CN.min.js" type="text/javascript"></script>
    <script src="${ctx}/js/statistics/cadet_pay.js" type="text/javascript"></script>
</body>
</html>