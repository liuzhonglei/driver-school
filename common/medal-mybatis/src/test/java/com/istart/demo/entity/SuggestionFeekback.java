package com.istart.demo.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/9
 */
@Data
public class SuggestionFeekback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    private Long suggestionId;

    private String content;
}
