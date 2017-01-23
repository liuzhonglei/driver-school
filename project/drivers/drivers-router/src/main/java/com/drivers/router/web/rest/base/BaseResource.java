package com.drivers.router.web.rest.base;

import com.drivers.router.utils.ExceptionUtils;
import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/25
 */
@Slf4j
public class BaseResource {

    protected Pageable toPageable(int limit, int offset) {
        return toPageable(limit,offset,null,null);
    }

    protected Pageable toPageable(int limit,int offset,String sort,String order) {
        Sort _sort = null;
        if (StringUtils.isNotBlank(order)) {
            if(StringUtils.isBlank(sort)){
                sort = "id";
            }
            if (order.equalsIgnoreCase("asc")) {
                _sort = new Sort(new Sort.Order(Sort.Direction.ASC, sort));
            }else if (order.equalsIgnoreCase("desc")) {
                _sort = new Sort(new Sort.Order(Sort.Direction.DESC, sort));
            }
        }
        return new PageRequest(offset/limit, limit,_sort);
    }
    //------------校验
    public <T> Response<T> validate(Response<T> response, BindingResult result) {
        resolvedValidate(response, result);
        return response;
    }

    protected <T> boolean resolvedValidate( Response<T> response, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<>();
            for (ObjectError objectError : result.getAllErrors()) {
                if (objectError instanceof FieldError) {
                    FieldError fieldError = (FieldError) objectError;
                    response.putError(fieldError.getField(), fieldError.getDefaultMessage());
                } else {
                    errorList.add(objectError.toString());
                }
            }
            if (errorList.size() > 0) response.putError(Response.UN_FIELD_ERRORS, result);
            response.setStatusCode(StatusCode.ValidateError);
            return false;
        }
        return true;
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
