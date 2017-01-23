package com.istart.demo.repository;

import com.istart.demo.entity.Suggestion;
import com.medal.framework.mybatis.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/16
 */
@Mapper
public interface SuggestionRepository extends BaseMapper<Suggestion> {

//    @Select("select * from suggestion a left join suggestion_feekback b on a.id = b.suggestion_id where a.id = #{id}")
    public Suggestion selectSuggestionAndFeekback(Long id);

    @Select("select * from suggestion where id=#{id}")
    public Suggestion findOne(Long id);
}
