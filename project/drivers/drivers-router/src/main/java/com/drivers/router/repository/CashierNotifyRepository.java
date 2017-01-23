package com.drivers.router.repository;

import com.drivers.entity.CashierNotify;
import com.drivers.entity.CashierPay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xhuji on 2016/10/12.
 */
@Mapper
public interface CashierNotifyRepository extends BaseRepository<CashierNotify,Long>{


    @Select("select * from cashier_notify")
    CashierPay findAll();
}
