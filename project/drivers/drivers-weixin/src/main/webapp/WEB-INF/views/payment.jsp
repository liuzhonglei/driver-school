<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.medal.weixin.sdk.pojo.SNSUserInfo" %>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

    <meta charset="utf-8" />

    <title>支付-眉山市瑞达驾校</title>

    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="keywords" content="" />
    <meta name="description" content="" />

    <jsp:include page="/WEB-INF/views/common/css.jsp"></jsp:include>

</head>
<body>
<%
    SNSUserInfo user = (SNSUserInfo) request.getAttribute("snsUserInfo");
    if (user == null){
        user = new SNSUserInfo();
    }
%>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <form class="form-horizontal">
                <input type="hidden" id="opendId" name="opendId" value="<%= user.getOpenId() %>" />
                <input type="hidden" id="nickname" name="nickname" value="<%= user.getNickname() %>"/>
                <input type="hidden" id="sex" name="nickname" value="<%= user.getSex() %>"/>
                <input type="hidden" id="country" name="country" value="<%= user.getCountry() %>"/>
                <input type="hidden" id="province" name="province" value="<%= user.getProvince() %>"/>
                <input type="hidden" id="city" name="city" value="<%= user.getCity() %>"/>
                <input type="hidden" id="headImgUrl" name="headImgUrl" value="<%= user.getHeadImgUrl() %>"/>
                <input type="hidden" id="privilegeList" name="privilegeList" value="<%= user.getPrivilegeList() %>"/>
                <div class="form-group">
                    <div class="col-sm-8 col-sm-offset-2">
                        <h3 class="text-center">眉山瑞达驾校学费 <strong>2000元</strong> </h3>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-8">
                        <a href="javascript:pay();" class="btn_1">立即支付</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/common/js.jsp"></jsp:include>
<script src="${ctx}/js/jweixin-1.0.0.js" type="text/javascript"></script>
<%--<script src="${ctx}/js/suggestion/SuggestionService.js" type="text/javascript"></script>--%>
<%--<script src="${ctx}/js/suggestion/suggestion.js" type="text/javascript"></script>--%>
<script type="text/javascript">
//    var  appId = getQueryString("appId");
//    var  timeStamp = getQueryString("timeStamp");
//    var  nonceStr = getQueryString("nonceStr");
//    var  pg = getQueryString("pg");
//    var  signType = getQueryString("signType");
//    var  paySign = getQueryString("paySign");
    var appId = '<%=request.getAttribute("appId") %>' ;
    var  timeStamp = '<%=request.getAttribute("timeStamp") %>';
    var  nonceStr = '<%=request.getAttribute("nonceStr") %>';
    var  pg = '<%=request.getAttribute("pg") %>';
    var  signType = '<%=request.getAttribute("signType") %>';
    var  paySign = '<%=request.getAttribute("paySign") %>';
    console.log("appId:" + appId);
    console.log("timeStamp:" + timeStamp);
    console.log("nonceStr:" + nonceStr);
    console.log("pg:" + pg);
    console.log("signType:" + signType);
    console.log("paySign:" + paySign);
    function getQueryString(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }

function onBridgeReady(){
    WeixinJSBridge.invoke(
            'getBrandWCPayRequest', {
                "appId"： appId,     //公众号名称，由商户传入
                "timeStamp"： timeStamp,         //时间戳，自1970年以来的秒数
                "nonceStr"： nonceStr, //随机串
                "package"： "prepay_id=" + pg,
                "signType"： "MD5",         //微信签名方式：
                "paySign"： paySign //微信签名
                },
                function(res){
                    if(res.err_msg == "get_brand_wcpay_request:ok" ) {
                        alert("支付成功");
                    }     // 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回    ok，但并不保证它绝对可靠。
                }
        );
    }


    function pay(){
        if (typeof WeixinJSBridge == "undefined"){
            alert("undefined");
            if( document.addEventListener ){
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            }else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        }else{
//            alert("！undefined");
            onBridgeReady();
        }
    }
</script>
</body>
</html>