<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户登录-眉山瑞达驾校</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="renderer" content="webkit"/>
    <!--webfonts-->
    <%--<link href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700' rel='stylesheet' type='text/css'/>--%>
    <%--<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet' type='text/css'/>--%>
    <!-- Fav and touch icons -->
    <link rel="shortcut icon" href="${ctx}/assets/ico/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/css/login.css" />
    <link rel="stylesheet" type="text/css" charset="UTF-8" href="${ctx}/plugins/bootstrap/dist/css/bootstrap.min.css" />
</head>
<body>

    <div class="login-form">
        <div class="close"></div>
        <div class="head-info">
            <label class="lbl-1"></label>
            <label class="lbl-2"> </label>
            <label class="lbl-3"> </label>
        </div>
    <div class="clear"></div>
    <div class="avtar">
        <img src="${ctx}/images/avtar.png" />
    </div>

    <form role="form" action="${ctx}/login.html" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
        <input type="text" name="username" class="text" value="admin" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'admin';}" >
        <div class="key">
            <input type="password" name="password" value="admin" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'admin';}">
        </div>
        <div class="signin">
            <input type="submit" value="登录" >
        </div>
    </form>
</div>
<div class="copy-rights">
    <p>Copyright &copy; 2016.蜀ICP备16031477号-1.</p>
</div>
</body>
</html>