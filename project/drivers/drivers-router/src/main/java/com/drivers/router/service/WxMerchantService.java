package com.drivers.router.service;

import com.drivers.entity.WxMerchant;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;

/**
 * Created by xhuji on 2016/11/19.
 */
public interface WxMerchantService {
    void findAll(Response<WxMerchant> response);

    void updateWxMerchant(Request<WxMerchant> request, Response<Integer> response);

    Integer updateAccessTokenById(Long id,String accessToken);

    String getAccessToken(Long id);
}
