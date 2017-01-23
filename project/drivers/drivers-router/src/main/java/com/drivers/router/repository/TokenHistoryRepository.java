package com.drivers.router.repository;

import com.drivers.entity.TokenHistory;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xhuji on 2016/11/26.
 */
@Mapper
public interface TokenHistoryRepository extends BaseRepository<TokenHistory,Long>{
    @Insert("INSERT INTO token_history(token) VALUE(#{token})")
    Integer save(TokenHistory tokenHistory);
}
