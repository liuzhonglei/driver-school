package com.istart.demo.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

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
@Table(name = "suggestion")
public class Suggestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Long id;

    private String name;

    private String mobile;

    private String content;

    private Integer businessStatus;

    private Integer dataStatus;
    @Transient
    private List<SuggestionFeekback> suggestionFeekbacks;

    @Override
    public String toString() {
        return "Suggestion{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", content='" + content + '\'' +
                ", businessStatus=" + businessStatus +
                ", dataStatus=" + dataStatus +
                ", suggestionFeekbacks=" + suggestionFeekbacks +
                '}';
    }
}
