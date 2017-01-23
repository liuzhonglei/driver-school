package com.drivers.manager.service;

import com.drivers.entity.TokenHistory;
import com.drivers.entity.WxMerchant;
import com.drivers.router.repository.TokenHistoryRepository;
import com.drivers.router.service.WxMerchantService;
import com.drivers.router.web.response.base.Response;
import com.medal.weixin.sdk.client.TokenClient;
import com.medal.weixin.sdk.pojo.Token;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 微信Token定时访问器
 * Created by xhuji on 2016/9/7.
 */
@Slf4j
@Service
@Data
public class TokenSchedulingService {
    @Autowired
    private WxMerchantService wxMerchantService;
    @Autowired
    private TokenHistoryRepository tokenHistoryRepository;
    /**
     * 缓存使用
     */
//    public Token accessToken = null;

    /**
     *
     * 每隔7100秒调度一次 710000
     */
    @Scheduled(fixedDelay = 2 * 60 * 60 * 100)
    public void schedule2(){
        Response<WxMerchant> response = new Response<>();
        wxMerchantService.findAll(response);

        WxMerchant wxMerchant = response.getContent();
        Token accessToken = TokenClient.getToken(wxMerchant.getAppId(),wxMerchant.getAppSecret());

        wxMerchantService.updateAccessTokenById(wxMerchant.getId(),accessToken.getAccessToken());
        log.info("获取token：" + accessToken.getAccessToken());
        TokenHistory tokenHistory = new TokenHistory();
        tokenHistory.setToken(accessToken.getAccessToken());
        tokenHistoryRepository.save(tokenHistory);
    }
//
//    /**
//     * 暂定一秒后，每隔50秒调度一次
//     */
//    @Scheduled(initialDelay=1000, fixedRate=50000)
//    public void schedule3(){
//        log.info("测试调度3");
//    }
}
