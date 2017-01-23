package com.medal.weixin.sdk.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by xhuji on 2016/11/23.
 */
@Data
@ToString
public class TemplateMessage {
    /**
     * openid
     */
    private String touser;

    @JsonProperty("template_id")
    private String templateId;

    private String url;

    private Object data;
}
