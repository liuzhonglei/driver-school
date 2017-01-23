package com.drivers.router.repository;

import com.drivers.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by xhuji on 2016/11/23.
 */
@Mapper
public interface TransactionRepository extends BaseRepository<Transaction,Long>{
    Integer save(Transaction transaction);

    @Select("select count(id) from transaction where transaction_no = #{transactionNo}")
    Long countByTransactionNo(@Param("transactionNo") String transactionId);
}
