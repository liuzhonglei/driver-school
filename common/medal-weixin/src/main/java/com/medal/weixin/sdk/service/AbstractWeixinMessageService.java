package com.medal.weixin.sdk.service;

import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import com.medal.weixin.sdk.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 核心服务类
 * Created by xhuji on 2016/9/2.
 */
@Slf4j
public abstract class AbstractWeixinMessageService implements MessageService{
    /**
     * 处理微信发来的请求
     *
     * @param requestMap
     * @return
     */
    public String processRequest(Map<String,String> requestMap) {
        String respMessage = null;
        // 默认返回的文本消息内容
        String respContent = "请求处理异常，请稍候尝试！";
        try {
            // 公众帐号(官网为开发者微信号)?
            String toUserName = requestMap.get("ToUserName");
            // 发送方帐号（一个OpenID）  o9SoVwrfU90rcWjPKvKRexhK4Td0
            String fromUserName = requestMap.get("FromUserName");
            //消息创建时间 （整型）
            Date date = new Date(Long.valueOf(requestMap.get("CreateTime")));
            // 消息类型
            String msgType = requestMap.get("MsgType");
            //消息id，64位整型
            String msgId = requestMap.get("MsgId");
            // 事件类型
            String eventType = requestMap.get("Event");
            // 存储请求信息
            log.debug("ToUserName:{},FromUserName:{},CreateTime:{},MsgType:{},MsgId:{},eventType：{}",toUserName,fromUserName,date,msgType,msgId,eventType);

            // 默认回复文本消息
            BaseMessageResp messageResp = new BaseMessageResp();
            switch (msgType){
                case MessageUtil.REQ_MESSAGE_TYPE_TEXT: // 文本消息
                    messageResp = handleTextMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_IMAGE: // 图片消息
                    messageResp = handleImageMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_VOICE: // 音频消息
                    messageResp = handleVoiceMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_VIDEO: // 视频消息
                    messageResp = handleVideoMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:// 地理位置消息
                    messageResp = handleLocationMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_LINK:// 链接消息
                    messageResp = handleLinkMessage(requestMap);
                    break;
                case MessageUtil.REQ_MESSAGE_TYPE_EVENT:// 事件推送
                    switch (eventType){
                        case MessageUtil.EVENT_TYPE_SUBSCRIBE:// 订阅/关注
                            messageResp = handleSubscribeEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_UNSUBSCRIBE: // 取消订阅/取消关注
                            messageResp = handleUnsubscribeEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_SCAN: //扫描带参数二维码
                            messageResp = handleScanEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_LOCATION: //上报地理位置
                            messageResp = handleLocationEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_CLICK:// 自定义菜单点击事件
                            messageResp = handleClickEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_VIEW:// 自定义菜单view事件
                            messageResp = handleViewEvent(requestMap);
                            break;
                        case MessageUtil.EVENT_TYPE_TEMPLATESENDJOBFINISH: //模版消息成功后的事件推送
                            messageResp = handleTemplateSendJobFinishvent(requestMap);
                            break;
                        default: messageResp = handleUnknowEventType(requestMap);
                    }
                    break;
                default: messageResp = handleUnknowMessageType(requestMap);
            }
            messageResp.setToUserName(fromUserName);
            messageResp.setFromUserName(toUserName);
            messageResp.setCreateTime(new Date().getTime());
            messageResp.setFuncFlag(0);
            respMessage = MessageUtil.baseMessageRespToXml(messageResp);//设置消息类型，并格式化为字符串

            // 存储返回信息
            log.debug("返回消息：{}",respMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
    }

    protected abstract BaseMessageResp handleTemplateSendJobFinishvent(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleUnknowMessageType(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleUnknowEventType(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleLocationEvent(Map<String, String> requestMap);

    protected abstract  BaseMessageResp handleScanEvent(Map<String, String> requestMap);

    protected abstract BaseMessageResp  handleVideoMessage(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleTextMessage(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleImageMessage(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleLocationMessage(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleLinkMessage(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleVoiceMessage(Map<String, String> requestMap);

    /**
     * 处理订阅/关注事件
     * @param requestMap
     * @return
     */
    protected abstract BaseMessageResp handleSubscribeEvent(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleUnsubscribeEvent(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleClickEvent(Map<String, String> requestMap);

    protected abstract BaseMessageResp handleViewEvent(Map<String, String> requestMap);

    /**
     * emoji表情转换(hex -> utf-16)
     *
     * @param hexEmoji
     * @return
     */
    public static String emoji(int hexEmoji) {
        return String.valueOf(Character.toChars(hexEmoji));
    }

    /**
     * 判断是否是QQ表情
     *
     * @param content
     * @return
     */
    public static boolean isQqFace(String content) {
        boolean result = false;

        // 判断QQ表情的正则表达式
        String qqfaceRegex = "/::\\)|/::~|/::B|/::\\||/:8-\\)|/::<|/::$|/::X|/::Z|/::'\\(|/::-\\||/::@|/::P|/::D|/::O|/::\\(|/::\\+|/:--b|/::Q|/::T|/:,@P|/:,@-D|/::d|/:,@o|/::g|/:\\|-\\)|/::!|/::L|/::>|/::,@|/:,@f|/::-S|/:\\?|/:,@x|/:,@@|/::8|/:,@!|/:!!!|/:xx|/:bye|/:wipe|/:dig|/:handclap|/:&-\\(|/:B-\\)|/:<@|/:@>|/::-O|/:>-\\||/:P-\\(|/::'\\||/:X-\\)|/::\\*|/:@x|/:8\\*|/:pd|/:<W>|/:beer|/:basketb|/:oo|/:coffee|/:eat|/:pig|/:rose|/:fade|/:showlove|/:heart|/:break|/:cake|/:li|/:bome|/:kn|/:footb|/:ladybug|/:shit|/:moon|/:sun|/:gift|/:hug|/:strong|/:weak|/:share|/:v|/:@\\)|/:jj|/:@@|/:bad|/:lvu|/:no|/:ok|/:love|/:<L>|/:jump|/:shake|/:<O>|/:circle|/:kotow|/:turn|/:skip|/:oY|/:#-0|/:hiphot|/:kiss|/:<&|/:&>";
        Pattern p = Pattern.compile(qqfaceRegex);
        Matcher m = p.matcher(content);
        if (m.matches()) {
            result = true;
        }
        return result;
    }
}
