package com.drivers.weixin.service;

import com.drivers.entity.WxFans;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.service.WxFansService;
import com.drivers.router.service.WxMerchantService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.client.UserClient;
import com.medal.weixin.sdk.message.response.Article;
import com.medal.weixin.sdk.message.response.NewsMessageResp;
import com.medal.weixin.sdk.message.response.TextMessageResp;
import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import com.medal.weixin.sdk.pojo.WeixinUserInfo;
import com.medal.weixin.sdk.service.AbstractWeixinMessageService;
import com.medal.weixin.sdk.service.ClickHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/9/5.
 */
@Slf4j
@Service
@Transactional
public class WeixinMessageService extends AbstractWeixinMessageService {

    @Resource
    private ClickHandle contactClickHandle;
    @Resource
    private ClickHandle learnStatusClickHandle;
    @Resource
    private ClickHandle payStatusClickHandle;
    @Resource
    private ClickHandle addrClickHandle;
    @Resource
    private ClickHandle feeClickHandle;
    @Resource
    private ClickHandle coachInfoClickHandle;
    @Autowired
    WxMerchantService wxMerchantService;
    @Autowired
    WxFansService wxFansService;
    @Autowired
    private WxFansRepository wxFansRepository;

    /**
     * 暂时不处理
     * @param requestMap
     * @return
     */
    @Override
    public BaseMessageResp handleTemplateSendJobFinishvent(Map<String, String> requestMap) {
        return new TextMessageResp();
    }

    @Override
    public BaseMessageResp handleUnknowMessageType(Map<String, String> requestMap) {
        return new BaseMessageResp();
    }

    @Override
    public BaseMessageResp handleUnknowEventType(Map<String, String> requestMap) {
        return new BaseMessageResp();
    }

    @Override
    public BaseMessageResp handleLocationEvent(Map<String, String> requestMap) {
        return new BaseMessageResp();
    }

    @Override
    public BaseMessageResp handleScanEvent(Map<String, String> requestMap) {
        return new BaseMessageResp();
    }

    @Override
    public BaseMessageResp handleVideoMessage(Map<String, String> requestMap) {
        return new BaseMessageResp();
    }

    /**
     * TODO 后期可以开发成管理员 想自定义的功能菜单
     * @param requestMap
     * @return
     */
    @Override
    public BaseMessageResp handleTextMessage(Map<String, String> requestMap){
        // 创建图文消息
        NewsMessageResp newsMessage = new NewsMessageResp();
        // 接收用户发送的文本消息内容
        String content = requestMap.get("Content");

        List<Article> articleList = new ArrayList<>();
        // 单图文消息
        if ("1".equals(content)) {
            Article article = new Article();
            article.setTitle("微信公众帐号开发教程Java版");
            article.setDescription("柳峰，80后，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列教程，也希望借此机会认识更多同行！");
            article.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
            article.setUrl("http://blog.csdn.net/lyq8479");
            articleList.add(article);
            // 设置图文消息个数
            newsMessage.setArticleCount(articleList.size());
            // 设置图文消息包含的图文集合
            newsMessage.setArticles(articleList);

        }
        // 单图文消息---不含图片
        else if ("2".equals(content)) {
            Article article = new Article();
            article.setTitle("微信公众帐号开发教程Java版");
            // 图文消息中可以使用QQ表情、符号表情
            article.setDescription("柳峰，80后，" + emoji(0x1F6B9)
                    + "，微信公众帐号开发经验4个月。为帮助初学者入门，特推出此系列连载教程，也希望借此机会认识更多同行！\n\n目前已推出教程共12篇，包括接口配置、消息封装、框架搭建、QQ表情发送、符号表情发送等。\n\n后期还计划推出一些实用功能的开发讲解，例如：天气预报、周边搜索、聊天功能等。");
            // 将图片置为空
            article.setPicUrl("");
            article.setUrl("http://blog.csdn.net/lyq8479");
            articleList.add(article);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
        }
        // 多图文消息
        else if ("3".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("微信公众帐号开发教程\n引言");
            article1.setDescription("");
            article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
            article1.setUrl("http://blog.csdn.net/lyq8479/article/details/8937622");

            Article article2 = new Article();
            article2.setTitle("第2篇\n微信公众帐号的类型");
            article2.setDescription("");
            article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8941577");

            Article article3 = new Article();
            article3.setTitle("第3篇\n开发模式启用及接口配置");
            article3.setDescription("");
            article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8944988");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
        }
        // 多图文消息---首条消息不含图片
        else if ("4".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("微信公众帐号开发教程Java版");
            article1.setDescription("");
            // 将图片置为空
            article1.setPicUrl("");
            article1.setUrl("http://blog.csdn.net/lyq8479");

            Article article2 = new Article();
            article2.setTitle("第4篇\n消息及消息处理工具的封装");
            article2.setDescription("");
            article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/8949088");

            Article article3 = new Article();
            article3.setTitle("第5篇\n各种消息的接收与响应");
            article3.setDescription("");
            article3.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article3.setUrl("http://blog.csdn.net/lyq8479/article/details/8952173");

            Article article4 = new Article();
            article4.setTitle("第6篇\n文本消息的内容长度限制揭秘");
            article4.setDescription("");
            article4.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article4.setUrl("http://blog.csdn.net/lyq8479/article/details/8967824");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            articleList.add(article4);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
        }
        // 多图文消息---最后一条消息不含图片
        else if ("5".equals(content)) {
            Article article1 = new Article();
            article1.setTitle("第7篇\n文本消息中换行符的使用");
            article1.setDescription("");
            article1.setPicUrl("http://0.xiaoqrobot.duapp.com/images/avatar_liufeng.jpg");
            article1.setUrl("http://blog.csdn.net/lyq8479/article/details/9141467");

            Article article2 = new Article();
            article2.setTitle("第8篇\n文本消息中使用网页超链接");
            article2.setDescription("");
            article2.setPicUrl("http://avatar.csdn.net/1/4/A/1_lyq8479.jpg");
            article2.setUrl("http://blog.csdn.net/lyq8479/article/details/9157455");

            Article article3 = new Article();
            article3.setTitle("如果觉得文章对你有所帮助，请通过博客留言或关注微信公众帐号xiaoqrobot来支持柳峰！");
            article3.setDescription("");
            // 将图片置为空
            article3.setPicUrl("");
            article3.setUrl("http://blog.csdn.net/lyq8479");

            articleList.add(article1);
            articleList.add(article2);
            articleList.add(article3);
            newsMessage.setArticleCount(articleList.size());
            newsMessage.setArticles(articleList);
        }
        return newsMessage;
    }

    @Override
    public BaseMessageResp handleImageMessage(Map<String, String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();
//        textMessageResp.setContent("您发送的是图片消息！");
        return textMessageResp;
    }

    @Override
    public BaseMessageResp handleLocationMessage(Map<String, String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();
//        textMessageResp.setContent("您发送的是地理位置消息！");
        return textMessageResp;
    }

    @Override
    public BaseMessageResp handleLinkMessage(Map<String, String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();
//        textMessageResp.setContent("您发送的是链接消息！");
        return textMessageResp;
    }

    @Override
    public BaseMessageResp handleVoiceMessage(Map<String, String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();
//        textMessageResp.setContent("您发送的是音频消息！");
        return textMessageResp;
    }

    /**
     * 用户关注微信公众号后保存到本地数据库,并推送消息
     * @param requestMap
     * @return
     */
    @Override
    public BaseMessageResp handleSubscribeEvent(Map<String, String> requestMap){
        log.info("处理用户关注微信公众号事件");
        String openId = requestMap.get("FromUserName");
        log.info("用户openId：openId={}",openId);
        Long count = wxFansRepository.countByOpenid(openId);
        if (count != null && count.equals(0L)){
            WeixinUserInfo weixinUserInfo = UserClient.getUserInfo(wxMerchantService.getAccessToken(1L),openId);
            log.info("获取到的用户消息：WeixinUserInfo={}",weixinUserInfo);
            WxFans wxFans = new WxFans();
            if (weixinUserInfo != null && StringUtil.isNotBlank(weixinUserInfo.getNickname())){//防止token失效
                BeanUtils.copyProperties(weixinUserInfo,wxFans);
                log.info("保存用户：WxFans={}",wxFans);
                wxFansRepository.save(wxFans);
            }
        }else {
            log.info("该用户已经存在：openId={}",openId);
        }

        TextMessageResp textMessageResp = new TextMessageResp();
        StringBuilder message = new StringBuilder();
        message.append("感谢您关注眉山市瑞达驾校!");
        textMessageResp.setContent(message.toString());
        return textMessageResp;
    }

    /**
     * 用户取消关注微信公众号后无效数据库记录,并推送消息
     * @param requestMap
     * @return
     */
    @Override
    public BaseMessageResp handleUnsubscribeEvent(Map<String, String> requestMap){
        // 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
        String openId = requestMap.get("FromUserName");
        Request<String> request = new Request<>();
        request.setContent(openId);
        Response<Integer> response = new Response<>();
        wxFansService.invalidByOpenid(request,response);
        TextMessageResp textMessageResp = new TextMessageResp();
        StringBuilder message = new StringBuilder();
        message.append("请再次关注眉山瑞达驾校!");
        textMessageResp.setContent(message.toString());
        return textMessageResp;
    }

    /**
     * TODO 待封装 后期不用修改该方法
     * @param requestMap
     * @return
     */
    @Override
    public BaseMessageResp handleClickEvent(Map<String, String> requestMap){
        BaseMessageResp baseMessageResp = null;
        // 事件KEY值，与创建自定义菜单时指定的KEY值对应
        String eventKey = requestMap.get("EventKey");
        if (eventKey.equals("payStatusButton")) {
            baseMessageResp = payStatusClickHandle.handle(requestMap);
        } else if (eventKey.equals("learnStatusButton")) {
            baseMessageResp = learnStatusClickHandle.handle(requestMap);
        }else if(eventKey.equals("contactUsButton")){
            baseMessageResp = contactClickHandle.handle(requestMap);
        }else if(eventKey.equals("feeButton")){
            baseMessageResp = feeClickHandle.handle(requestMap);
        }else if(eventKey.equals("addrButton")){
            baseMessageResp = addrClickHandle.handle(requestMap);
        }else if(eventKey.equals("coachInfoButton")){
            baseMessageResp = coachInfoClickHandle.handle(requestMap);
        }

        if (baseMessageResp == null){
            baseMessageResp = new BaseMessageResp();
        }
        return baseMessageResp;
    }


    @Override
    public BaseMessageResp handleViewEvent(Map<String, String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();
        textMessageResp.setContent("页面跳转! ");
        return textMessageResp;
    }


}
