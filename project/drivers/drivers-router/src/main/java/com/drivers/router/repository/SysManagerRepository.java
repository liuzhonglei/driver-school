package com.drivers.router.repository;

import com.drivers.entity.SysManager;
import com.drivers.router.web.request.SysManagerReq;
import com.drivers.router.web.request.common.SingleFieldUpdateReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysManagerRepository extends BaseRepository<SysManager,Long> {

    Integer save(SysManager sysManager);

    Long countBySearch(SysManagerReq request);

    List<SysManager> findAllBySearch(SysManagerReq request);

    @Select("select * from sys_manager where username = #{username} and data_status = 1")
    SysManager findByUsername(String username);

    @Select("select count(id) from sys_manager where username = #{username} and data_status = 1")
    Integer validateUsername(String username);

    @Update("update sys_manager set password = #{password}  where username = #{username}")
    Integer updatePassword(@Param("username") String username, @Param("password")  String password);

    @Update("update sys_manager set data_status = 0,data_updater = #{dataUpdater} where id = #{id}")
    Integer invalid(@Param("id")Long id, @Param("dataUpdater") String dataUpdater);

    Integer batchInvalid(@Param("ids")List<Long> ids, @Param("dataUpdater") String dataUpdater);

    @Update("update sys_manager set ${key} = #{value},data_updater = #{dataUpdater} where id = #{id}")
    Integer siglnFieldUpdate(SingleFieldUpdateReq request);

    @Select("select * from sys_manager where id = #{id}")
    SysManager findById(Long id);

    void update(Map<String,Object> map);

    @Select("select wx_openid from sys_manager where is_push = 1 and data_status = 1 and wx_openid is not null")
    List<String> findPushOpenid();

    @Update("update sys_manager set wx_nickname = #{wxNickname},wx_openid = #{wxOpenid} where id = #{id}")
    Integer bindWeixin(SysManager content);

    @Update("update sys_manager set wx_nickname = null,wx_openid = null where id = #{id}")
    Integer unbindWeixin(Long id);
}