package com.drivers.weixin.web.rest;

import com.drivers.weixin.config.WeixinProperties;
import com.drivers.weixin.service.WeixinMessageService;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.service.MessageService;
import com.medal.weixin.sdk.util.MessageUtil;
import com.medal.weixin.sdk.util.SignUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 请求处理的核心类
 *
 * Created by xhuji on 2016/10/20.
 */
@RestController
@RequestMapping( value = "/weixin")
@Slf4j
public class WeixinMessageRest {
    @Autowired
    private WeixinProperties weixinProperties;

    @Autowired
    private MessageService weixinMessageService;
    /**
     * 请求校验（确认请求来自微信服务器）
     *
     * 公众平台用户提交信息后，微信服务器将发送GET请求到填写的URL,并且附带四个参数：
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * signature      | 微信加密签名
     * timestamp      | 时间戳
     * nonce          | 随机数
     * echostr        | 随机字符串
     * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * 开发者通过校验signature对请求进行校验，若确认此次GET请求来自于微信服务器就原因返回echostr参数内容，则接入生效，否则接入失败
     */
    @RequestMapping(method = RequestMethod.GET)
    public void validateRequestFromWeixin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        log.debug("确保请求来自微信服务器:{}","validateRequestFromWeixin");
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        String token = weixinProperties.getServerConfig().getToken();
        if (StringUtil.isBlank(token)){
            token = "ruida_drivers";
        }
        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(token,signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
    }

    /**
     * 处理微信服务器发来的消息
     */
    @RequestMapping(method = RequestMethod.POST)
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = weixinMessageService.processRequest(MessageUtil.parseXml(request));
        log.debug("响应:{}",respMessage);
        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }
}
