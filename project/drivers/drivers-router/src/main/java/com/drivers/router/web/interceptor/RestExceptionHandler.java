package com.drivers.router.web.interceptor;

import com.drivers.router.exceptions.BizException;
import com.drivers.router.utils.ExceptionUtils;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 采用ControllerAdvice方式实现异常处理，给客户端更好的展示效果
 * Created by xhuji on 2016/8/29.
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    /**
     * 业务异常
     * @param ex
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public Response<?> handleException(BizException ex){
        logError(ex.getResponse(), ex);
        return ex.getResponse();
    }

    /**
     * key重复异常
     * @param ex
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public Response<?> getHandleException(DuplicateKeyException ex){
        Response<?> response = new Response<>();
        response.setStatusCode(StatusCode.BusinessDataHasExisted, true);
        logError(response, ex);
        return response;
    }

    /**
     * 数据访问异常
     * @param ex
     * @return
     */
    @ExceptionHandler(DataAccessException.class)
    @ResponseBody
    public Response<?> handleException(DataAccessException ex) {
        Response<?> response = new Response<>();
        response.setStatusCode(StatusCode.InternalServerDataAccessException, true);
        logError(response, ex);
        return response;
    }
    // Ambiguous @ExceptionHandler method mapped for [class org.springframework.http.converter.HttpMessageNotReadableException]
//    @ExceptionHandler({HttpMessageNotReadableException.class})
//    @ResponseBody
//    public Response<?> handleException(HttpMessageNotReadableException ex) {
//        Response<?> response = new Response<>();
//        response.setStatusCode(StatusCode.ValidateErrorHttpMessageNotReadable, true);
//        logError(response, ex);
//        return response;
//    }

    /**
     * Json异常
     * @param ex
     * @return
     */
    @ExceptionHandler({JsonMappingException.class})
    @ResponseBody
    public Response<?> handleException(JsonMappingException ex) {
        Response<?> response = new Response<>();
        response.setStatusCode(StatusCode.ValidateErrorHttpMessageNotReadable, true);
        logError(response, ex);
        return response;
    }

    /**
     * 其它异常
     * @param ex
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public Response<?> handleException(Throwable ex) {
        Response<?> response = new Response<>();
        response.setStatusCode(StatusCode.InternalServerErrorForBusiness, true);
        logError(response, ex);
        return response;
    }
    private void putError(Response<?> response, Throwable ex) {
        String message = ExceptionUtils.getCalmException(ex);
        response.putError(Response.INTERNAL_SERVER_ERROR, message == null ? "" : message);
    }

    private void logError(Response<?> response,Throwable ex){
        putError(response, ex);
        log.error((response.getMessageId() == null ? "" : ("message_id:" + response.getMessageId()) + ", ") + response.getMessage(),
                ex);
    }
}
