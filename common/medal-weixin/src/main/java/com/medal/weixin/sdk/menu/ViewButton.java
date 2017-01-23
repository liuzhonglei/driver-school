package com.medal.weixin.sdk.menu;

import lombok.Data;

/**
 * view类型的按钮
 *
 * Created by xhuji on 2016/9/3.
 */
@Data
public class ViewButton extends Button {

    private String type;

    private String url;

}
