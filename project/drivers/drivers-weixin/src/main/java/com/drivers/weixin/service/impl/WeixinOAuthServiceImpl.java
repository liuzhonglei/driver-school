package com.drivers.weixin.service.impl;

import com.drivers.entity.WxFans;
import com.drivers.entity.WxMerchant;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.repository.WxMerchantRepository;
import com.drivers.weixin.service.WeixinOAuthService;
import com.medal.weixin.sdk.client.AdvancedClient;
import com.medal.weixin.sdk.pojo.SNSUserInfo;
import com.medal.weixin.sdk.pojo.WeixinOauth2Token;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by xhuji on 2016/11/22.
 */
@Slf4j
@Service
@Transactional
public class WeixinOAuthServiceImpl implements WeixinOAuthService {
    @Autowired
    private WxMerchantRepository wxMerchantRepository;
    @Autowired
    private WxFansRepository wxFansRepository;
    @Override
    public SNSUserInfo getSNSUserInfo(String code) {
        // 获取网页授权access_token
        WxMerchant wxMerchant = wxMerchantRepository.findAll();
        WeixinOauth2Token weixinOauth2Token = new WeixinOauth2Token();
        if (wxMerchant != null){
            weixinOauth2Token = AdvancedClient.getOauth2AccessToken(wxMerchant.getAppId(),wxMerchant.getAppSecret(), code);
        }
        // 获取用户信息
        SNSUserInfo snsUserInfo = AdvancedClient.getSNSUserInfo(weixinOauth2Token.getAccessToken(), weixinOauth2Token.getOpenId());

        //保存微信关注者信息
        Long count = wxFansRepository.countByOpenid(snsUserInfo.getOpenId());
        if (!count.equals(1L)){
            WxFans wxFans = new WxFans();
            BeanUtils.copyProperties(snsUserInfo,wxFans);
            wxFansRepository.save(wxFans);
        }
        return snsUserInfo;
    }
}
