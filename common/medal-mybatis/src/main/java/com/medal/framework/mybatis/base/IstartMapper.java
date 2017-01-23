package com.medal.framework.mybatis.base;

import org.apache.ibatis.annotations.UpdateProvider;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/17
 */
public interface IstartMapper<T>  {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
    /**
     * 失效数据
     * @param id
     * @return
     */
    @UpdateProvider(type = IstartProvider.class,method = "dynamicSQL")
    Integer invalid(Object id);

    /**
     * 激活数据
     * @param id
     * @return
     */
    @UpdateProvider(type = IstartProvider.class,method = "dynamicSQL")
    Integer activate(Object id);

}
