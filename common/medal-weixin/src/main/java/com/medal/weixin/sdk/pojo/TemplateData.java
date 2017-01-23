package com.medal.weixin.sdk.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by xhuji on 2016/11/23.
 */
@Data
@ToString
@NoArgsConstructor
public class TemplateData {

    private String value;

    private String color;

    public TemplateData(String value){
        this.value = value;
    }

    public TemplateData(String value,String color){
        this.value = value;
        this.color = color;
    }
}
