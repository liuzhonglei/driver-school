package com.drivers.router.utils;

import com.drivers.router.web.response.base.Response;
import com.drivers.router.web.response.base.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;

/**
 * Created by MyPC on 2015/1/28.
 */
@Slf4j
public class ExceptionUtils {
    final static Logger logger = LoggerFactory.getLogger("Error&Exception");


    public static <T> Response<T> dealExceptionMessage(Throwable e) {
        Throwable t = null;


        String message;
        StatusCode statusCode = StatusCode.InternalServerExceptionForTomcat;
        if (e instanceof ServletException) {

            if (((ServletException) e).getRootCause() == null) {
                t = e.getCause();
                message = getCalmException(t);
            } else {
                t = ((ServletException) e).getRootCause();
                message = getCalmException(t);
            }


            logger.error("服务器500错误", e);

        } else {
            t = e;
            message = getCalmException(e);
            logger.error("服务器500错误", e);
        }
        log.error("find error in deep:"+e+" msg:"+message,e);//by fw 2016-5-23
        if (t instanceof Error) {
            statusCode = StatusCode.InternalServerErrorForTomcat;
        } else {
            statusCode = StatusCode.InternalServerExceptionForTomcat;
        }

        Response response = new Response();
        response.setStatusCode(statusCode);
        response.setMessage(statusCode.getMessage() + ", " + message);
        return response;
    }

    public static String getCalmException(Throwable e) {
        if (e == null) return "";
        String message = null;
        StackTraceElement[] ss = e.getStackTrace();
        if (ss != null && ss.length > 0) {
            for (StackTraceElement s : ss) {
                if(s==null) continue;
                message = s.toString();
                if (message.contains("com.calm") || message.contains("com.keruyun")) {
                    break;
                }
            }
        }
        return e.getClass().getCanonicalName() + (e.getMessage() == null ? "" : (":" + e.getMessage())) + ":" +(message==null?"":message);
    }
}
