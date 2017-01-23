package com.drivers.router.repository;

import com.drivers.entity.SchoolTuition;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.SchoolTuitionResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SchoolTuitionRepository extends BaseRepository<SchoolTuition,Long> {

    SchoolTuitionResp findAllBySearch();

    @Select("select count(id) from school")
    Long count();

    @Update("update school_tuition set ${key} = #{value},data_updater = #{dataUpdater} where id = #{id}")
    Integer updateSchoolTuition(SingleFieldUpdateReq request);
}