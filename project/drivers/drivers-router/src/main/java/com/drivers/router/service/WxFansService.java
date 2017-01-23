package com.drivers.router.service;

import com.drivers.entity.WxFans;
import com.drivers.router.web.request.WxFansReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.WxFansResp;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.common.KeyValueResp;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xhuji on 2016/11/6.
 */
public interface WxFansService {

    void save(Request<WxFans> request, Response<Integer> response);

    void getWxFansDic(String name,String bindTable,Response<List<KeyValueResp>> response);

    void findAllBySearch(WxFansReq request, PagerResponse<WxFansResp> response) throws UnsupportedEncodingException;

    void batchSave(Response<Integer> response) throws UnsupportedEncodingException;

    Long countByOpenid(String openId);

    void invalidByOpenid(Request<String> request, Response<Integer> response);
}
