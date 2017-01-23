package com.drivers.router.repository;

import com.drivers.entity.WxFans;
import com.drivers.router.web.request.WxFansReq;
import com.drivers.router.web.response.WxFansResp;
import com.drivers.router.web.response.common.KeyValueResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by xhuji on 2016/10/17.
 */
@Mapper
public interface WxFansRepository extends BaseRepository<WxFans,Long>{

    @Select("select * from wx_fans where id = #{id} and data_status = 1")
    WxFans findById(@Param("id") Long id);

    Integer save(WxFans wxFans);

    List<KeyValueResp> getWxFansDic4Cadet(@Param("nickname") String nickname);

    List<KeyValueResp> getWxFansDic4Coach(@Param("nickname")String nickname);

    List<KeyValueResp> getWxFansDic4SysManager(@Param("nickname")String name);
    Long countBySearch(WxFansReq request);

    List<WxFansResp> findAllBySearch(WxFansReq request);

    @Select("select * from wx_fans where open_id = #{openId} and data_status = 1")
    WxFans findByOpenid(@Param("openId")String openId);

    @Select("select count(id) from wx_fans where open_id = #{openId} and data_status = 1")
    Long countByOpenid(@Param("openId")String openId);

    @Update("update wx_fans set data_status = 0 where open_id = #{openId} and data_status = 1")
    Integer invalidByOpenid(@Param("openId")String openId);

    @Update("update wx_fans set name = #{name},mobile = #{mobile} where open_id = #{openId} and data_status = 1")
    void updateOtherByOpenid(@Param("name")String name, @Param("mobile")String mobile, @Param("openId")String openId);

    @Update("update wx_fans set bind_table = #{bindTable},bind_id = #{bindId} where open_id = #{openid} and data_status = 1")
    void bindByOpenid(@Param("bindTable")String bindTable, @Param("bindId")Long bindId, @Param("openid")String openid);

    @Update("update wx_fans set bind_table = null,bind_id = null where open_id = #{openid} and data_status = 1")
    void unbindByOpenid(String wxOpenid);


}
