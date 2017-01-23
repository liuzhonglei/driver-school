package com.drivers.weixin.web.rest;

import com.drivers.router.repository.SysManagerRepository;
import com.drivers.router.repository.WxMerchantRepository;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.rest.base.BaseResource;
import com.drivers.weixin.common.Pay;
import com.drivers.weixin.service.WeixinNotifyService;
import com.drivers.weixin.service.WeixinPayService;
import com.drivers.weixin.web.request.WxpayWebReq;
import com.drivers.weixin.web.response.NotifyResp;
import com.medal.weixin.sdk.client.TemplateMessageClient;
import com.medal.weixin.sdk.pojo.TemplateData;
import com.medal.weixin.sdk.pojo.TemplateMessage;
import com.medal.weixin.sdk.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springside.modules.mapper.JsonMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/10/12.
 */
@RestController
@Slf4j
@RequestMapping("/pay")
public class WeixinPayRest extends BaseResource{
    @Autowired
    private WeixinPayService weixinPayService;
    @Autowired
    private WeixinNotifyService weixinNotifyService;

    /**
     * 微信下单及收银
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jspay",method = RequestMethod.POST)
    public Pay jspay(@RequestBody @Validated Request<WxpayWebReq> request, BindingResult result) throws Exception {
        log.info("微信网页支付,请求的内容:{}",request.getContent());
        Response<Pay> payResponse = new Response<>();

        if (!resolvedValidate(payResponse,result)){
            return payResponse.getContent();
        }

        weixinPayService.web(request,payResponse);
        return payResponse.getContent();
    }

    @RequestMapping(value = "/notify",method = RequestMethod.POST)
    public String notify(HttpServletRequest request) throws Exception {
        Map<String,String> _map = MessageUtil.parseXml(request);
        weixinNotifyService.notify(_map);

        NotifyResp notifyResp = new NotifyResp();
        notifyResp.setReturn_code("SUCCESS");
        notifyResp.setReturn_msg("OK");
        String result = MessageUtil.toXXml(notifyResp);
        log.info("微信回调后服务器返回结果: result={}",result);
        return result;
    }
}
