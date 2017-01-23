package com.drivers.router.repository;

import com.drivers.entity.CashierPay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xhuji on 2016/10/12.
 */
@Mapper
public interface CashierPayRecordRepository extends BaseRepository<CashierPay,Long>{

    Long save(CashierPay newCashierPay);

    @Select("select * from cashier_pay where appid = #{appid} and out_trade_no = #{outTradeNo}")
    CashierPay findByOutTradeNoAndAppId(@Param("appid") String appid, @Param("outTradeNo") String outTradeNo);
}
