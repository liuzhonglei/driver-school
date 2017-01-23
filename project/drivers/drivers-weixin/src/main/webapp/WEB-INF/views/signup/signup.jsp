<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--<%@ page import="com.medal.weixin.sdk.pojo.SNSUserInfo" %>--%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>报名缴费通道-眉山市瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
</head>
<body id="app">
<%
    double tuition = 0;
    if (request.getParameter("tuition") != null){
        tuition = Double.valueOf(request.getParameter("tuition")) / 100;
    }
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <h2 class="text-center">瑞达驾校欢迎您 </h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <h4 class="text-center">专业从事驾驶员培训20余年</h4>
            <p>  眉山市彭山区瑞达汽车驾驶培训有限公司是原彭山县南门口交通驾校，专业从事驾驶员培训20余年，一次性收费，管理严格。 教学正规，服务周到。 </p>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 col-sm-12">
            <h4 class="text-center">报名缴费</h4>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal" id="pay-form">
                <input type="hidden" id="opendId" name="opendId" value="<%= request.getParameter("openId") %>" v-model="payReq.content.openId"/>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <h3 class="text-center">眉山瑞达驾校学费 <strong id="tuition" tuition="<%=tuition%>"><%=tuition%>元</strong> </h3>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="name" name="name" placeholder="姓名" v-model="payReq.content.name"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">手机号码:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="mobile"  placeholder="手机号码" v-model="payReq.content.mobile">
                    </div>
                </div>
            </form>
                <button name="submit" class="form-control btn btn-default" id="submit"  v-on:click="apply()">报名并缴费</button>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<script src="${ctx}/js/jweixin-1.0.0.js" type="text/javascript"></script>
<script src="${ctx}/plugins/vue/dist/vue.js" type="text/javascript"></script>
<script src="${ctx}/js/pay/PayService.js" type="text/javascript"></script>
<script src="${ctx}/js/pay/pay1.js" type="text/javascript"></script>
</body>
</html>