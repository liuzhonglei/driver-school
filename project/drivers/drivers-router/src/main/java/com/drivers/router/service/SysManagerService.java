package com.drivers.router.service;

import com.drivers.entity.SysManager;
import com.drivers.router.web.request.SysManagerReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
public interface SysManagerService {

    void save(Request<SysManager> request, Response<Integer> response);

    void invalid(Request<Long> request, PagerResponse<Integer> response,String dataUpdater);

    void batchInvalid(Request<List<Long>> request, Response<Integer> response, String dataUpdater);

    void updatePassword(Response<SysManager> request, Response<Integer> response);

    void siglnFieldUpdate(Request<SingleFieldUpdateReq> request, Response<Integer> response);

    void update(Request<SysManager> request, Response<Integer> response);

    void findByPageSearch(final SysManagerReq request, PagerResponse<SysManager> response);

    void findByUsername(String username, Response<SysManager> response);

    Boolean validateUsername(String username);

    void bindWeixin(Request<SysManager> request, Response<Integer> response);

    void unbindWeixin(Request<SysManager> request, Response<Integer> response);
}
