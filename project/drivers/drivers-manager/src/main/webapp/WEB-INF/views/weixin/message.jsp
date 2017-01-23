<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>
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
                <li><i class="fa-bell"></i>系统管理</li>
                <li><i class="fa-bell"></i>用户访问日志</li>
            </ol>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <form action="/message" method="post">
                <!-- 加载编辑器的容器 -->
                <script id="container" name="content" type="text/plain">

                </script>
                <!-- 配置文件 -->
                <script type="text/javascript" src="${ctx}/js/ueditor/ueditor.config.js"></script>
                <!-- 编辑器源码文件 -->
                <script type="text/javascript" src="${ctx}/js/ueditor/ueditor.all.js"></script>
                <!-- 实例化编辑器 -->
                <script type="text/javascript">
                    var ue = UE.getEditor('container');
                </script>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
</body>
</html>