package com.drivers.router.web.response.base;

import com.drivers.router.exceptions.BizException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.medal.common.utils.StringUtil;
import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @param <T>
 */
@Data
public class Response<T>  implements Serializable {

	private static final long serialVersionUID = -5587859954446690142L;
	public static final String UN_FIELD_ERRORS = "un_field_errors";
    public static final String UN_BUSINESS_OPERATION_ERRORS = "business_operation_errors";
    public static final String INTERNAL_SERVER_ERROR = "internal_server_error";
    public static final String VALIDATE_ERROR = "validate_error";

    protected Integer status;//参考enum StatusCode

    protected String message;//参考enum StatusCode

    protected String messageId;

    protected Map<String, Object> errors;

    protected T content;// 返回的数据

    //辅助字段，用于service中返回一些重复操作但必须在事务外操作的数据
    @JsonIgnore
    protected Map<String, Object> returnValues = new HashMap<>(3);

    public Response() {
    	setMessageId();
        this.setStatusCode(StatusCode.OK);
    }

    public Integer getStatus() {
        return status;
    }

    private void setMessageId(){
    	if(StringUtil.isNotEmpty(messageId)) {
            return;
        }
    	messageId = (String) MDC.get("_KRY_GLOBAL_MSG_ID");
        if(StringUtil.isEmpty(messageId)){
           messageId = UUID.randomUUID().toString();
        }
    }

    public void setStatus(Integer status) {
        this.status = status;
        setMessageId();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
        setMessageId();
    }

    public Map<String, Object> getErrors() {
        return errors;
    }

    public void putError(String fieldName, Object errorMessage) {
        if (errors == null) errors = new HashMap<>();
        errors.put(fieldName, errorMessage);
    }

    public void setStatusCode(StatusCode statusCode) {
        setStatus(statusCode.getCode());
        this.message = statusCode.getMessage();
        setMessageId();
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    private static String message(StatusCode statusCode, String messageId) {
        return "code:" + statusCode.getCode() + ":" + statusCode.getMessage();
    }

    public void setStatusCode(StatusCode statusCode, boolean isAppendCode) {
    	setMessageId();
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
        if (isAppendCode) {
            this.message = message(statusCode, this.messageId);
        }
    }

    public Map<String, Object> getReturnValues() {
        return returnValues;
    }

    public void setReturnValues(Map<String, Object> returnValues) {
        this.returnValues = returnValues;
    }

    public void putReturnValue(String key, Object value) {
        if(this.returnValues.containsKey(key)){
            throw new BizException("Response.returnValues不允许放入重复的key");
        }
        this.returnValues.put(key,value);
    }
    public Object getReturnValue(String key){
        return this.returnValues.get(key);
    }
}
