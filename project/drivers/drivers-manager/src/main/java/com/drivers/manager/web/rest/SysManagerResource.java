package com.drivers.manager.web.rest;

import com.drivers.entity.SysManager;
import com.drivers.manager.security.SecurityUtils;
import com.drivers.router.service.SysManagerService;
import com.drivers.router.service.WxFansService;
import com.drivers.router.web.request.SysManagerReq;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.base.PagerResponse;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.drivers.router.web.response.common.KeyValueResp;
import com.drivers.router.web.rest.base.BaseResource;
import com.medal.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
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
@RestController
@RequestMapping(value = "/api/sysmanagers")
@Slf4j
public class SysManagerResource extends BaseResource{

    @Autowired
    private SysManagerService sysManagerService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/create",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> createSysManager(@RequestBody @Validated Request<SysManager> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }

        if (request.getContent().getId() != null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能有值");
            return response;
        }
        request.getContent().setDataCreator(SecurityUtils.getCurrentUserLogin());
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        request.getContent().setPassword(passwordEncoder.encode(request.getContent().getPassword()));
        sysManagerService.save(request,response);
        return response;
    }
    /**
     * 删除管理员信息
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> deleteSysManager(@RequestBody @Validated Request<Long> request, BindingResult result) throws Exception{
        PagerResponse<Integer> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        sysManagerService.invalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }

    @RequestMapping(value = "/batchDelete", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> batchDeleteSysManager(@RequestBody @Validated Request<List<Long>> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        sysManagerService.batchInvalid(request,response,SecurityUtils.getCurrentUserLogin());
        return response;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> updateSysManager(@RequestBody @Validated Request<SysManager> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        sysManagerService.update(request,response);
        return response;
    }
    /**
     * 单个字段更新
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/singleFieldUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> singleFieldUpdateSysManager(@RequestBody @Validated Request<SingleFieldUpdateReq> request, BindingResult result ) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        sysManagerService.siglnFieldUpdate(request,response);
        return response;
    }
    @RequestMapping(value = "/_search/sysmanagers", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public PagerResponse<SysManager> getByPage(@Validated SysManagerReq request, BindingResult result ){
        PagerResponse<SysManager> response = new PagerResponse<>();
        response.setStatusCode(StatusCode.OK);

        if(!resolvedValidate(response,result)){
            return response;
        }

        sysManagerService.findByPageSearch(request,response);
        return response;
    }

    /**
     * 用户名唯一性判断
     * @param username
     * @return
     */
    @RequestMapping(value = "/validateUsername", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean validateUsername(String username){
        if (StringUtil.isBlank(username)){
            return false;
        }else {
            return sysManagerService.validateUsername(username);
        }
    }

    /**
     * 根据用户名修改密码
     * @param request
     * @param result
     * @return
     */
    @RequestMapping(value = "/updatePassword" , method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> updatePassword(@RequestBody @Validated Response<SysManager> request, BindingResult result){
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        request.getContent().setPassword(passwordEncoder.encode(request.getContent().getPassword()));
        sysManagerService.updatePassword(request,response);
        return response;
    }

    /**
     * 根据用户名查询管理员信息
     * @param username
     * @param result
     * @return
     */
    @RequestMapping(value = "/get" , method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<SysManager> getByUsername(String username){
        Response<SysManager> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        sysManagerService.findByUsername(username,response);
        return response;
    }

    /**
     * 绑定微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/bindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> bindWeixin(@RequestBody @Validated Request<SysManager> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        sysManagerService.bindWeixin(request,response);
        return response;
    }
    /**
     * 解绑微信账号
     * @param request
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/unbindWeixin",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> unbindWeixin(@RequestBody @Validated Request<SysManager> request, BindingResult result) throws Exception{
        Response<Integer> response = new Response<>();
        response.setStatusCode(StatusCode.OK);
        if(!resolvedValidate(response,result)){
            return response;
        }
        if (request.getContent().getId() == null){
            response.setStatusCode(StatusCode.Business_TS_MEGER);
            response.setMessage("ID不能为空");
            return response;
        }
        request.getContent().setDataUpdater(SecurityUtils.getCurrentUserLogin());
        sysManagerService.unbindWeixin(request,response);
        return response;
    }
}
