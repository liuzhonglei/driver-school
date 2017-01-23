package com.drivers.router.repository;

import com.drivers.entity.Suggestion;
import com.drivers.router.web.request.SuggestionReq;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SuggestionRepository extends BaseRepository<Suggestion,Long> {

    Integer save(Suggestion suggestion);

    @Update("update suggestion set data_status = 0 where id = #{id}")
    Integer invalid(Long id);

    @Delete("delete from suggestion where id = #{id}")
    Integer delete(Long id);

    @Select("select * from suggestion where id=#{id}")
    Suggestion findOne(Long id);

    List<Suggestion> findAllBySearch(SuggestionReq request);

    Long countBySearch(SuggestionReq request);

    @Update("update suggestion set business_status = #{businessStatus} where id = #{id}")
    Integer updateBusinessStatusById(@Param("id") Long id,@Param("businessStatus") Integer businessStatus);
}