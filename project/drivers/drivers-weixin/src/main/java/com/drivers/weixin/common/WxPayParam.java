package com.drivers.weixin.common;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xhuji on 2016/10/12.
 */
@Data
@NoArgsConstructor
public class WxPayParam extends PayBaseParam{
    private String weixinAppId;
    private String weixinAppSecret;
    private String weixinPaySignKey;
    private String weixinPartnerId;
    private String weixinPartnerKey;
    private String weixinPassword;
    private Integer weixinMenuOpenType;
    private String weixinCertUrl;
    private Integer isOpenSubMch;

    private Integer isNewInterface = Constant.WX_VALID;//是否使用新接口  ：0 否，1：是
}
