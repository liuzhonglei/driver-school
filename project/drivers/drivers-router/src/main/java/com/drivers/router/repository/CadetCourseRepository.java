package com.drivers.router.repository;

import com.drivers.entity.CadetCourse;
import com.drivers.router.web.request.CadetCourseReq;
import com.drivers.router.web.response.CadetCourseResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface CadetCourseRepository extends BaseRepository<CadetCourse,Long> {

    Integer save(CadetCourse content);

    @Update("update cadet_course set data_status = 0,data_updater = #{dataUpdater} where id = #{id}")
    Integer invalid(@Param("id")Long id, @Param("dataUpdater")String dataUpdater);

    void update(Map<String, Object> map);

    @Select("select * from cadet_course where id = #{id}")
    CadetCourse findById(Long id);

    Long countBySearch(CadetCourseReq request);

    List<CadetCourseResp> findAllBySearch(CadetCourseReq request);

    @Select("SELECT c.id," +
            "c.username," +
            "c.name," +
            "c.sex," +
            "c.birthday," +
            "c.mobile," +
            "c.weixin_num," +
            "c.idcard_num," +
            "cc.id as cadetCourseId," +
            "cc.cadet_id as cadetId," +
            "cc.course," +
            "cc.data_updater," +
            "cc.data_update_datetime" +
            "    FROM cadet c" +
            "      LEFT JOIN (SELECT * from cadet_course WHERE data_status = 1) cc on cc.cadet_id = c.id" +
            "    WHERE c.wx_openid = #{openId}")
    CadetCourseResp findByOpenId(@Param("openId") String openId);
}