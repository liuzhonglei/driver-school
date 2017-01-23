package com.medal.framework.mybatis.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/17
 */
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T>,IstartMapper<T> {
}
