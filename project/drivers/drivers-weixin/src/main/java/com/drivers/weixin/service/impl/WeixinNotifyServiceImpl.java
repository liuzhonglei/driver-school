package com.drivers.weixin.service.impl;

import com.drivers.entity.*;
import com.drivers.router.repository.*;
import com.drivers.weixin.service.WeixinNotifyService;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.client.TemplateMessageClient;
import com.medal.weixin.sdk.pojo.TemplateData;
import com.medal.weixin.sdk.pojo.TemplateMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.mapper.JsonMapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * Created by xhuji on 2016/11/23.
 */
@Service
@Transactional
@Slf4j
public class WeixinNotifyServiceImpl implements WeixinNotifyService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CadetRepository cadetRepository;
    @Autowired
    private CadetPayRepository cadetPayRepository;
    @Autowired
    private CadetCourseRepository cadetCourseRepository;
    @Autowired
    private WxFansRepository wxFansRepository;
    @Autowired
    private JsonMapper jsonMapper;
    @Autowired
    private WxMerchantRepository wxMerchantRepository;
    @Autowired
    private SysManagerRepository sysManagerRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Override
    public boolean notify(Map<String, String> map) {
        boolean result = false;
        log.info("微信回调返回状态码: return_code={},return_msg={}",map.get("return_code"),map.get("return_msg"));
        if ("SUCCESS".equals(map.get("return_code"))){
            String transactionId = map.get("transaction_id");
            log.info("微信回调返回内容: transaction_id={},total_fee={}",transactionId,map.get("total_fee"));
            Long count = transactionRepository.countByTransactionNo(transactionId);
            log.info("count={}",count);
            if (count != null && count.equals(0L)){
                log.info("交易单不存在,进行保存操作!");
                Transaction transaction = new Transaction();
                transaction.setUserUniqueType(1);
                transaction.setUserUnique(map.get("openid"));
                transaction.setPayDatetime(map.get("time_end"));
                transaction.setMchId(map.get("mch_id"));
                transaction.setDeviceInfo(map.get("device_info"));
                transaction.setSignType(map.get("sign_type"));
                transaction.setSign(map.get("sign"));
                transaction.setIsSubscribe(map.get("is_subscribe"));
                transaction.setTradeType(map.get("trade_type"));
                transaction.setBankType(map.get("bank_type"));
                String totalFee = map.get("total_fee");
                if (StringUtil.isNotBlank(totalFee)){
                    transaction.setTotalFee(Integer.valueOf(map.get("total_fee")));
                }
                String settlementTotalFee = map.get("settlement_total_fee");
                if (StringUtil.isNotBlank(settlementTotalFee)){
                    transaction.setSettlementTotalFee(Integer.valueOf(map.get("settlement_total_fee")));
                }
                transaction.setFeeType(map.get("fee_type"));
                transaction.setTransactionNo(map.get("transaction_id"));
                transaction.setOutTradeNo(map.get("out_trade_no"));
                transaction.setDataCreator("weixin");
                transaction.setDataUpdater("weixin");
                log.info("Transaction:{}",transaction);
                transactionRepository.save(transaction);
                result = true;

                tradeRepository.updateTransactionInfo(transaction.getId(),transaction.getTransactionNo(),transaction.getOutTradeNo(),2);
                log.info("用户openid={}",map.get("openid"));
                WxFans wxFans = wxFansRepository.findByOpenid(map.get("openid"));
                Long cadetCount = cadetRepository.coutByOpenid(map.get("openid"));
                if (cadetCount != null && cadetCount.equals(0L)){

                    Cadet cadet = new Cadet();
                    cadet.setName(wxFans.getName());
                    cadet.setSex(wxFans.getSex());
//                cadet.setBirthday(wxFans.get);
                    cadet.setMobile(wxFans.getMobile());
                    cadet.setWxNickname(wxFans.getNickname());
                    cadet.setWxOpenid(wxFans.getOpenId());
                    cadet.setModel("C1");
                    cadet.setAddr(wxFans.getProvince());
                    cadet.setEnrolDatetime(ZonedDateTime.now());
                    cadet.setDataCreator("weixin");
                    cadet.setDataUpdater("weixin");
                    cadetRepository.save(cadet);
                    log.info("保持的学员数据ID,id={}",cadet.getId());
                    CadetCourse cadetCourse = new CadetCourse();
                    cadetCourse.setCadetId(cadet.getId());
                    cadetCourse.setCourse(1);
                    cadetCourse.setDataCreator("weixin");
                    cadetCourse.setDataUpdater("weixin");
                    cadetCourseRepository.save(cadetCourse);
                    CadetPay cadetPay = new CadetPay();
                    cadetPay.setCadetId(cadet.getId());
                    cadetPay.setPayStatus(2);
                    cadetPay.setPayAmount(new BigDecimal(map.get("total_fee")));
                    cadetPay.setPayDatetime(LocalDate.now());
                    cadetPay.setDataCreator("weixin");
                    cadetPay.setDataUpdater("weixin");
                    cadetPayRepository.save(cadetPay);
                }


                String accessToken = wxMerchantRepository.findAccessToken(1L);
                log.info("获取到的accessToken={}",accessToken);
                //推送下单成功消息给用户
                Map<String,TemplateData> userMap = new HashedMap(5);

                userMap.put("first",new TemplateData("尊敬的 " + wxFans.getName() + " ：您好！"));
                userMap.put("class",new TemplateData("您已成功报名参加眉山瑞达驾校培训"));
                userMap.put("time",new TemplateData("每周一至周五"));
                userMap.put("add",new TemplateData("眉山瑞达驾校"));
                userMap.put("remark",new TemplateData("请尽快到驾校报道,谢谢。"));
                TemplateMessage templateMessage = new TemplateMessage();
                templateMessage.setTemplateId("J5ZKh4yc7ZHHeQK_MRTrOOki0_FnOFvS8A1oxAxqtm4");
                templateMessage.setTouser(map.get("openid"));
                templateMessage.setUrl("");
                templateMessage.setData(userMap);
                String json  = jsonMapper.toJson(templateMessage);
                TemplateMessageClient.sendTemplateMessage(accessToken,json);
                //推送有新订单消息给管理员
                Map<String,TemplateData> managerMap = new HashedMap(5);
                managerMap.put("first",new TemplateData("您好，您有一个新订单"));
                managerMap.put("keyword1",new TemplateData(wxFans.getName()));
                managerMap.put("keyword2",new TemplateData("驾校培训"));
                managerMap.put("keyword3",new TemplateData(map.get("total_fee")));
                managerMap.put("keyword4",new TemplateData("已支付"));
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                managerMap.put("keyword5",new TemplateData(ZonedDateTime.now().format(formatter)));
                managerMap.put("remark",new TemplateData("请及时确认"));

                TemplateMessage managerTemplateMessage = new TemplateMessage();
                managerTemplateMessage.setTemplateId("mUkP6oSFTsCzJahmUHZjYb_eITV6dFNYuDn7WogAx44");
                managerTemplateMessage.setUrl("");
                managerTemplateMessage.setData(managerMap);

                List<String> openids = sysManagerRepository.findPushOpenid();
                if (CollectionUtils.isNotEmpty(openids)){
                    for(String openid : openids){
                        managerTemplateMessage.setTouser(openid);
                        String managerJson  = jsonMapper.toJson(managerTemplateMessage);
                        TemplateMessageClient.sendTemplateMessage(accessToken,managerJson);
                    }
                }

            }else {
                log.info("交易单已经存在,不进行保持操作!");
            }
        }else {

        }
        return result;
    }
}
