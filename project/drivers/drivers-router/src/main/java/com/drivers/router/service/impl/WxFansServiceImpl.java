package com.drivers.router.service.impl;

import com.drivers.entity.WxFans;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.service.WxFansService;
import com.drivers.router.service.WxMerchantService;
import com.drivers.router.web.request.WxFansReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.WxFansResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.common.KeyValueResp;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.client.UserClient;
import com.medal.weixin.sdk.pojo.WeixinUserInfo;
import com.medal.weixin.sdk.pojo.WeixinUserList;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xhuji on 2016/11/6.
 */
@Service
@Transactional
@Slf4j
public class WxFansServiceImpl implements WxFansService {

    @Autowired
    WxFansRepository wxFansRepository;

    @Autowired
    private WxMerchantService wxMerchantService;


    @Override
    public void save(Request<WxFans> request, Response<Integer> response) {
        Integer result = wxFansRepository.save(request.getContent());
        response.setContent(result);
    }

    @Override
    public void getWxFansDic(String name,String bindTable, Response<List<KeyValueResp>> response) {
        List<KeyValueResp> result = null;
        if ("coach".equalsIgnoreCase(bindTable)){
            result = wxFansRepository.getWxFansDic4Coach(name);
        }else if ("cadet".equalsIgnoreCase(bindTable)){
            result = wxFansRepository.getWxFansDic4Cadet(name);
        }else if ("sys_manager".equalsIgnoreCase(bindTable)){
            result = wxFansRepository.getWxFansDic4SysManager(name);
        }
        response.setContent(result);
    }

    @Override
    public void findAllBySearch(WxFansReq request, PagerResponse<WxFansResp> response) throws UnsupportedEncodingException {
        Long count = wxFansRepository.countBySearch(request);
        List<WxFansResp> cadetResps = wxFansRepository.findAllBySearch(request);

        if(CollectionUtils.isNotEmpty(cadetResps)){
            for (WxFansResp resp : cadetResps){
                resp.setNickname(emojiRecovery2(resp.getNickname()));
            }
        }
        response.setTotal(count);
        response.setRows(cadetResps);
    }

    @Override
    public void batchSave(Response<Integer> response) throws UnsupportedEncodingException {
       String accessToken  = wxMerchantService.getAccessToken(1L);
        WeixinUserList weixinUserList = UserClient.getUserList(accessToken,"");
        int count = weixinUserList.getCount();
        if (count != 0){
            List<String> openIds = weixinUserList.getOpenIdList();
            if (CollectionUtils.isNotEmpty(openIds)){
                for (String openid : openIds) {
                    WxFans wxFan = getWxFansByOpenid(openid);
                    if (wxFan == null){
                        wxFan = new WxFans();
                        WeixinUserInfo weixinUserInfo = UserClient.getUserInfo(accessToken,openid);
                        BeanUtils.copyProperties(weixinUserInfo,wxFan);
                        wxFan.setNickname(emojiConvert1(weixinUserInfo.getNickname()));
//                        wxFan.setNickname("暂时不处理");
                        save(wxFan);
                    }
                }
            }
        }
    }
    public static String emojiConvert1(String str)
            throws UnsupportedEncodingException {
        if (StringUtil.isBlank(str)){
            return null;
        }
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch(UnsupportedEncodingException e) {
                log.error("emojiConvert error", e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        log.debug("emojiConvert " + str + " to " + sb.toString()
                + ", len：" + sb.length());
        return sb.toString();
    }
    /**
     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
     * @param str
     * 转换后的字符串
     * @return 转换前的字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiRecovery2(String str)
            throws UnsupportedEncodingException {
        if (StringUtil.isBlank(str)){
            return null;
        }
        String patternString = "\\[\\[(.*?)\\]\\]";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);

        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                        URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch(UnsupportedEncodingException e) {
                log.error("emojiRecovery error", e);
                throw e;
            }
        }
        matcher.appendTail(sb);
        log.debug("emojiRecovery " + str + " to " + sb.toString());
        return sb.toString();
    }
    @Override
    public Long countByOpenid(String openId) {
        return wxFansRepository.countByOpenid(openId);
    }

    @Override
    public void invalidByOpenid(Request<String> request, Response<Integer> response) {
        Integer result = wxFansRepository.invalidByOpenid(request.getContent());
        response.setContent(result);
    }

    private WxFans getWxFansByOpenid(String openid){
        return wxFansRepository.findByOpenid(openid);
    }
    private Integer save(WxFans wxFans) {
        Integer result = wxFansRepository.save(wxFans);
        return result;
    }
}
