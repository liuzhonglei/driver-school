package com.drivers.router.web.request.common;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by xhuji on 2016/9/24.
 */
@Data
public class SingleFieldUpdateReq {
    @NotNull
    private Long id;

    @NotBlank
    private String key;

    private String value;

    private String dataUpdater;
}
