package com.drivers.router.repository;

import com.drivers.entity.WxMerchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/10/13.
 */
@Mapper
public interface WxMerchantRepository extends BaseRepository<WxMerchant,Long>{
//    @Select("select id,weixin_app_id,weixin_app_secret,weixin_pay_sign_key,weixin_partner_id,weixin_partner_key from wx_pay_request_parames")
    WxMerchant findWxPayParamesById();

    @Select("select * from wx_merchant")
    WxMerchant findAll();

    Integer update(Map<String, Object> map);

    @Update("update wx_merchant set access_token = #{accessToken} where id = #{id}")
    Integer updateAccessTokenById(@Param("id") Long id,@Param("accessToken") String accessToken);

    @Select("select access_token from wx_merchant where id = #{id}")
    String findAccessToken(Long id);
}
