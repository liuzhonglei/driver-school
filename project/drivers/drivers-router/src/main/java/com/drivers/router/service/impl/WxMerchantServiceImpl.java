package com.drivers.router.service.impl;

import com.drivers.entity.WxMerchant;
import com.drivers.router.repository.WxMerchantRepository;
import com.drivers.router.service.WxMerchantService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/11/19.
 */
@Service
@Transactional
public class WxMerchantServiceImpl implements WxMerchantService {
    @Autowired
    private WxMerchantRepository wxMerchantRepository;

    @Override
    public void findAll(Response<WxMerchant> response) {
        WxMerchant wxMerchant = wxMerchantRepository.findAll();
        response.setContent(wxMerchant);
    }

    @Override
    public void updateWxMerchant(Request<WxMerchant> request, Response<Integer> response) {
        WxMerchant requestContent = request.getContent();

        Map<String,Object> map = new HashMap<>();
        map.put("id",requestContent.getId());
        map.put("app_id",requestContent.getAppId());
        map.put("app_secret",requestContent.getAppSecret());
        map.put("pay_sign_key",requestContent.getPaySignKey());
        map.put("partner_id",requestContent.getPartnerId());
        map.put("partner_key",requestContent.getPartnerKey());
        map.put("password",requestContent.getPassword());
        map.put("menu_open_type",requestContent.getMenuOpenType());
        map.put("cert_url",requestContent.getCertUrl());
        map.put("access_token",requestContent.getAccessToken());
        map.put("is_open_sub_mch",requestContent.getIsOpenSubMch());
        wxMerchantRepository.update(map);
    }

    @Override
    public Integer updateAccessTokenById(Long id,String accessToken) {
        Integer result = wxMerchantRepository.updateAccessTokenById(id,accessToken);
        return result;
    }

    @Override
    public String getAccessToken(Long id) {
        return wxMerchantRepository.findAccessToken(id);
    }
}
