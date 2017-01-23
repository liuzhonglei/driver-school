package com.drivers.router.repository;

import com.drivers.entity.Coach;
import com.drivers.router.web.request.CoachReq;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import com.drivers.router.web.response.common.KeyValueResp;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/9/8.
 */
@Mapper
public interface CoachRepository extends BaseRepository<Coach,Long> {

    Long countBySearch(CoachReq request);

    List<Coach> findAllBySearch(CoachReq request);

    Integer save(Coach content);

    @Update("update coach set data_status = 0,data_updater = #{dataUpdater} where id = #{id}")
    Integer invalid(@Param("id")Long id, @Param("dataUpdater") String dataUpdater);

    Integer batchInvalid(@Param("ids")List<Long> ids, @Param("dataUpdater") String dataUpdater);

    @Update("update coach set ${key} = #{value},data_updater = #{dataUpdater} where id = #{id}")
    Integer siglnFieldUpdate(SingleFieldUpdateReq request);

    @Select("select * from coach where id = #{id}")
    Coach findById(Long id);

    void update(Map<String, Object> map);

    @Results(id = "coachDicResult", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "value")
    })

    List<KeyValueResp> getCoachDic(@Param("name") String name);

    @Select("select coach.* from cadet left join coach on cadet.coach_id = coach.id where cadet.wx_openid = #{openid}")
    Coach findByCadetOpenId(@Param("openid") String openId);

    @Update("update coach set wx_nickname = #{wxNickname},wx_openid = #{wxOpenid} where id = #{id}")
    Integer bindWeixin(Coach content);

    @Update("update coach set wx_nickname = null,wx_openid = null where id = #{id}")
    Integer unbindWeixin(Long id);
}
