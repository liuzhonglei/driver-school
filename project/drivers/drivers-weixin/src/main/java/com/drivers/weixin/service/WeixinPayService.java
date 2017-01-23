package com.drivers.weixin.service;

import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.drivers.weixin.common.Pay;
import com.drivers.weixin.web.request.WxpayWebReq;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by xhuji on 2016/10/12.
 */
public interface WeixinPayService {

    /**
     * 微信公众号网页支付
     * @param request
     * @return
     */
    void web(Request<WxpayWebReq> request, Response<Pay> response) throws IOException, XmlPullParserException;

}
