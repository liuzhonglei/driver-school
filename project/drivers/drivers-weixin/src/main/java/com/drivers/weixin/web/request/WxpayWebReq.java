package com.drivers.weixin.web.request;

import lombok.Data;
import lombok.ToString;

/**
 * Created by xhuji on 2016/10/12.
 */
@Data
@ToString
public class WxpayWebReq {

    private String openId; // 用户的标识，对当前公众号唯一

    private String name;

    private String mobile;

    private Integer payFee;//总金额

    private String ip;

    private String dataCreator;

    private String dataUpdater;

}
