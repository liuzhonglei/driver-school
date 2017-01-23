package com.drivers.router.repository;

import com.drivers.entity.Trade;
import com.drivers.router.web.request.TradeReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by xhuji on 2016/11/23.
 */
@Mapper
public interface TradeRepository extends BaseRepository<Trade,Long>{

    Integer save(Trade goods);

    @Update("update trade set transaction_id = #{transactionId},transaction_no = #{transactionNo},order_status = #{orderStatus} where out_trade_no = #{outTradeNo} and data_status = 1")
    void updateTransactionInfo(@Param("transactionId") Long transactionId, @Param("transactionNo")String transactionNo, @Param("outTradeNo")String outTradeNo, @Param("orderStatus")Integer orderStatus);

    Long countBySearch(TradeReq req);

    List<Trade> findAllBySearch(TradeReq req);
}
