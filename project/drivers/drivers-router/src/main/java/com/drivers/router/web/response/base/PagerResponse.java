package com.drivers.router.web.response.base;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/8
 */
@Data
public class PagerResponse<T> extends Response<T> {

    private Long total = 0L;

    private List<T> rows = new ArrayList<>();

    public PagerResponse(){
        super();
    }

    public PagerResponse(List<T> rows, Long total){
        super();
        this.total = total;
        this.rows = rows;
    }
}
