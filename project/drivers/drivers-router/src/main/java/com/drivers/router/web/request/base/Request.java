package com.drivers.router.web.request.base;

//import lombok.Data;

import lombok.Data;

import javax.validation.Valid;
import java.io.Serializable;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/11
 */
@Data
public  class Request<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Valid
    private T content;// 要同步的所有信息

}
