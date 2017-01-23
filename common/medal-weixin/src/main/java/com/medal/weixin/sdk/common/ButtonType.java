package com.medal.weixin.sdk.common;

/**
 * Created by xhuji on 2016/10/22.
 */
public enum ButtonType {
    Click("click"),VIEW("view");

    private final String value;

    ButtonType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
