package com.drivers.weixin.common;

/**
 * Created by xhuji on 2016/10/12.
 */
public class Constant {
    public static final String DEFAULT_CHARSET = "UTF-8";


    public static final int VALID=1;  //有效
    public static final int INVALID=2;  //无效

    public static final int SUCCESS_NUMBER=0;  //有效
    public static final int FAIL_NUMBER=-1;  //无效

    public static final String SUCCESS="SUCCESS";  //成功
    public static final String FAIL="FAIL";  //失败
    public static final String Y = "Y";  //是
    public static final String N = "N";  //否

    public static final String SERVER_UPDATE_TIME_NAME = "server_update_time"; //服务器更新时间 数据库字段名
    public static final String SERVER_CREATE_TIME_NAME = "server_create_time"; //服务器创建时间 数据库字段名
    public static final String ID_NAME = "id"; //id

    public static final int WX_VALID=1;  //微信相关判断  是
    public static final int WX_INVALID=0;  //微信相关判断  否

    public static final int IS_SUB_MCH_Y = 1;  //是否开通受理商户支付 是
    public static final int IS_SUB_MCH_N = 0;  //是否开通受理商户支付 否

    public static final String CERT_SUFFIX = ".p12";  //证书后缀名

}
