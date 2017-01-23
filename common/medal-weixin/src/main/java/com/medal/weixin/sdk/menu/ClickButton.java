package com.medal.weixin.sdk.menu;

import lombok.Data;

/**
 * click 类型的按钮
 *
 * Created by xhuji on 2016/10/20.
 */
@Data
public class ClickButton extends Button {

    private String type;

    private String key;
}
