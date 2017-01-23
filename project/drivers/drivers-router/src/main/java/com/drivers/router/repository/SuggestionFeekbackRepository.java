package com.drivers.router.repository;

import com.drivers.entity.SuggestionFeekback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SuggestionFeekbackRepository extends BaseRepository<SuggestionFeekback,Long> {
    Integer save(SuggestionFeekback suggestionFeekback);

    @Select("select * from suggestion_feekback where suggestion_id = #{suggestionId}")
    List<SuggestionFeekback> findFeekbackBySuggestionId(Long suggestionId);
}