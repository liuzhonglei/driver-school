package com.drivers.router.repository;

import com.drivers.entity.CadetPay;
import com.drivers.router.web.request.CadetPayReq;
import com.drivers.router.web.request.StatisticsReq;
import com.drivers.router.web.response.CadetPayResp;
import com.drivers.router.web.response.StatisticsCadetPayResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface CadetPayRepository extends BaseRepository<CadetPay,Long> {

    Integer save(CadetPay content);

    @Update("update cadet_pay set data_status = 0,data_updater = #{dataUpdater} where id = #{id}")
    Integer invalid(@Param("id")Long id, @Param("dataUpdater")String dataUpdater);

    void update(Map<String, Object> map);

    @Select("select * from cadet_pay where id = #{id}")
    CadetPay findById(Long id);

//    @Select("select cp.* from cadet c left join cadet_pay cp on c.id = cp.cadet_id where c.openid = #{openId}")
    @Select("SELECT c.id," +
            "            c.username," +
            "            c.name," +
            "            c.sex," +
            "            c.birthday," +
            "            c.mobile," +
            "            c.weixin_num," +
            "            c.idcard_num," +
            "            cp.id as cadetPayId," +
            "            cp.cadet_id as cadetId," +
            "            cp.pay_status," +
            "            cp.pay_amount," +
            "            cp.pay_datetime," +
            "            cp.data_updater," +
            "            cp.data_update_datetime" +
            "    FROM cadet c" +
            "    LEFT JOIN (SELECT * from cadet_pay where data_status = 1) cp on cp.cadet_id = c.id" +
            "    WHERE c.wx_openid = #{openId}")
    CadetPayResp findByOpenId(@Param("openId") String openId);

    Long countBySearch(CadetPayReq request);

    List<CadetPayResp> findAllBySearch(CadetPayReq request);

    List<StatisticsCadetPayResp> statisticsAmount(StatisticsReq request);

}