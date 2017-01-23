package com.drivers.weixin.common.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * @author liangb
 * @version 1.0
 * @date 16/8/10 上午10:47
 */
@Data
public class WxPayBaseOut {

    @XStreamAlias("return_code")
    private String returnCode;

    @XStreamAlias("return_msg")
    private String returnMsg;

    @XStreamAlias("err_code")
    private String errCode;

    @XStreamAlias("err_code_des")
    private String errCodeDes;

    @XStreamAlias("result_code")
    private String resultCode;

    @XStreamAlias("result_msg")
    private String resultMsg;
}
