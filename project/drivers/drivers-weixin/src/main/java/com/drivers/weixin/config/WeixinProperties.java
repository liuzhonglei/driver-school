package com.drivers.weixin.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Title: Properties specific to drivers-weixin.
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/5
 */
@ConfigurationProperties(prefix = "weixin", ignoreUnknownFields = false)
@Data
public class WeixinProperties {

    private Developer developer = new Developer();

    private ServerConfig serverConfig = new ServerConfig();
    @Data
    public static class Developer{

        private String appid;

        private String appsecret;
    }
    @Data
    public static class ServerConfig{

        private String url;

        private String homeUrl;

        private String token;

        private String encodingAESKey;

        private String encodingType;

        private String validateUrl;
    }
}
