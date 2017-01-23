package com.medal.weixin.sdk.menu;

import lombok.Data;

/**
 * 复合类型的按钮
 *
 * Created by xhuji on 2016/9/3.
 */
@Data
public class ComplexButton extends Button{

    private Button[] sub_button;

}
