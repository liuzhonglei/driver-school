package com.drivers.router.repository;

import com.drivers.entity.Cadet;
import com.drivers.router.web.request.CadetReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.CadetResp;
import com.drivers.router.web.response.StatisticsCadetNumResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CadetRepository extends BaseRepository<Cadet,Long> {

    Long countBySearch(CadetReq request);

    List<CadetResp> findAllBySearch(CadetReq request);

    List<StatisticsCadetNumResp> statisticsCadetNum(StatisticsReq request);

    Long save(Cadet cadet);

    @Update("update cadet set data_status = 0,data_updater = #{dataUpdater} where id = #{id}")
    Integer invalid(@Param("id")Long id, @Param("dataUpdater") String dataUpdater);

    Integer batchInvalid(@Param("ids")List<Long> ids, @Param("dataUpdater") String dataUpdater);

    @Update("update cadet set ${key} = #{value},data_updater = #{dataUpdater} where id = #{id}")
    Integer siglnFieldUpdate(SingleFieldUpdateReq request);

    Integer batchSave(List<Cadet> content);

    @Update("update cadet set wx_nickname = #{wxNickname},wx_openid = #{wxOpenid} where id = #{id}")
    Integer bindWeixin(Cadet content);

    @Select("select count(id) from cadet where wx_openid = #{openid} and data_status = 1")
    Long coutByOpenid(@Param("openid") String openid);

    @Update("update cadet set coach_id = #{coachId} where id = #{id} and data_status = 1")
    Integer relateCoach(Cadet content);

    @Update("update cadet set wx_nickname = null,wx_openid = null where id = #{id}")
    Integer unbindWeixin(Long id);

    @Select("select * from cadet where id = #{id}")
    Cadet findById(@Param("id") Long id);
    @Select("select * from cadet where wx_openid = #{wxOpenid}")
    Cadet findByOpenid(@Param("wxOpenid")String wxOpenid);
}