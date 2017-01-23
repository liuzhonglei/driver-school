package com.drivers.router.repository;

import com.drivers.entity.Suggestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SuggestionRepository extends BaseRepository<Suggestion,Long> {

    //    @Select("select * from suggestion a left join suggestion_feekback b on a.id = b.suggestion_id where a.id = #{id}")
    public Suggestion selectSuggestionAndFeekback(Long id);

    @Select("select * from suggestion where id=#{id}")
    public Suggestion findOne(Long id);

//    public List<Suggestion> findAllBySearch(SuggestionReq req);
}