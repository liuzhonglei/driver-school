<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <title>意见反馈-眉山市瑞达驾校</title>
    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>
</head>
<body id="app">
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
        <div class="col-sm-12">
            <form id="register-form" class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <h3 class="text-center">投诉建议 </h3>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <p>在使用过程中出现任何问题请反馈给我们，我们一定会及时解决，谢谢.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">姓名:</label>
                    <div class="col-sm-10">
                        <input id="name" name="name" type="text" class="form-control" placeholder="姓名" v-model="req.content.name" required="required" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="mobile" class="col-sm-2 control-label">电话号码:</label>
                    <div class="col-sm-10">
                        <input name="mobile" id="mobile" type="text" class="form-control" placeholder="电话号码" v-model="req.content.mobile" required="required" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="message" class="col-sm-2 control-label">内容:</label>
                    <div class="col-sm-10">
                        <textarea name="message"id="message" class="form-control" placeholder="内容" rows="6" v-model="req.content.content" required="required"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <button name="submit" class="btn btn-default" id="submit" v-on:click="submit()">发送消息</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
</div>
<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<script src="${ctx}/js/suggestion/SuggestionService.js" ></script>
<script src="${ctx}/js/suggestion/suggestion.js" ></script>
</body>
</html>