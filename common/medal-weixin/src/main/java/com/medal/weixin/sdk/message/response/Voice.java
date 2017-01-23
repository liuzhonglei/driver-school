package com.medal.weixin.sdk.message.response;

import lombok.Data;

/**
 * 语音 model
 * Created by xhuji on 2016/10/20.
 */
@Data
public class Voice {
    /**
     *  通过素材管理接口上传多媒体文件，得到的id。
     */
    private String MediaId;
}
