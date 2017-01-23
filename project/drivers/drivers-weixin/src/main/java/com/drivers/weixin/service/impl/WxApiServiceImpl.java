package com.drivers.weixin.service.impl;

import com.drivers.weixin.common.bean.WxPayBaseIn;
import com.drivers.weixin.common.bean.WxPayBaseOut;
import com.drivers.weixin.common.bean.WxpayUnifiedOrderIn;
import com.drivers.weixin.common.bean.WxpayUnifiedOrderOut;
import com.drivers.weixin.config.ApiWxpayMethodProperties;
import com.drivers.weixin.service.WxApiService;
import com.drivers.weixin.util.MapUtils;
import com.drivers.weixin.util.SecurityUtils;
import com.drivers.weixin.util.XmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by xhuji on 2016/10/12.
 */
@Service
@Transactional
@Slf4j
public class WxApiServiceImpl implements WxApiService{
    @Autowired
    private ApiWxpayMethodProperties apiWxpayMethodProperties;


    /**
     * https://api.weixin.qq.com/sns/oauth2/access_token?appid="+APPID+"&secret="+secrest+"&code="+code+"&grant_type=authorization_code
     * @return
     */
    public String openid(){
        String appid = "";
        String REDIRECT_URI = "";
        return  null;
    }
    /**
     * 统一下单:  https://api.mch.weixin.qq.com/pay/unifiedorder
     * 不需要证书 参考https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_1
     *
     * @param in
     * @return
     */
    public WxpayUnifiedOrderOut unifiedorder(WxpayUnifiedOrderIn in) {
        String reqXml = XmlUtils.object2Xml(in);
        String url = apiWxpayMethodProperties.getUnifiedOrder();
        return wxRequest(url,reqXml,WxpayUnifiedOrderOut.class);
    }

    /**
     *
     * @param url
     * @param reqXml
     * @param Clazz
     * @param <T>
     * @return
     */
    private <T extends WxPayBaseOut>T wxRequest(String url, String reqXml, Class<T> Clazz){
        String response = null;
//        response = restTemplate.postForObject(url,reqXml,String.class);
        T out = XmlUtils.xml2Object(response,Clazz);
        return out;
    }

    public String createWxSign(WxPayBaseIn in, String partnerKey) {
        Map<String ,Object> map =  XmlUtils.parseXStream2Map(in);
        TreeMap<String,Object> treeMap = new TreeMap<>(map);
        String param = MapUtils.treeMap2ascString(treeMap) + "&key="+partnerKey;
        return SecurityUtils.md5(param).toUpperCase();
    }
}
