package com.drivers.weixin.service.impl;

import com.drivers.entity.Trade;
import com.drivers.entity.WxMerchant;
import com.drivers.router.repository.TradeRepository;
import com.drivers.router.repository.WxFansRepository;
import com.drivers.router.repository.WxMerchantRepository;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.drivers.weixin.common.Pay;
import com.drivers.weixin.service.WeixinPayService;
import com.drivers.weixin.util.MapUtils;
import com.drivers.weixin.util.SecurityUtils;
import com.drivers.weixin.web.PayClient;
import com.drivers.weixin.web.request.WxpayWebReq;
import com.medal.common.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by xhuji on 2016/10/12.
 */
@Service
@Transactional
@Slf4j
public class WeixinPayServiceImpl implements WeixinPayService{
    @Autowired
    private WxMerchantRepository wxMerchantRepository;
    @Autowired
    private TradeRepository tradeRepository;
    @Autowired
    private WxFansRepository wxFansRepository;

    /**
     * 生成预结单
     * @param request
     * @param response
     * @throws IOException
     * @throws XmlPullParserException
     */
    @Override
    public void web(Request<WxpayWebReq> request, Response<Pay> response) throws IOException, XmlPullParserException {
        WxMerchant wxMerchant = wxMerchantRepository.findAll();
        String out_trade_no = UUID.randomUUID().toString().replace("-","");
        String nonceStr = create_nonce_str();

        Map<String, String> paraMap = new HashMap<>();
        paraMap.put("appid", wxMerchant.getAppId());//公众账号ID
        paraMap.put("mch_id", wxMerchant.getPartnerId());//商户号
        paraMap.put("device_info", "WEB");//设备号
        paraMap.put("nonce_str",nonceStr );//随机字符串
        paraMap.put("body", "眉山市瑞达驾校学费");//商品描述（支付成功后会在支付凭证中展示）
//        paraMap.put("detail", "测试购买支付");//商品详情
//        paraMap.put("attach", "2000元");//附加数据
        paraMap.put("out_trade_no", out_trade_no);//商户订单号
        paraMap.put("fee_type", "CNY");//货币类型
        paraMap.put("total_fee", String.valueOf(request.getContent().getPayFee()));//总金额
        String spbillCreateIp = request.getContent().getIp();
        if (StringUtil.isBlank(spbillCreateIp) || "0:0:0:0:0:0:0:1".equals(spbillCreateIp)){
            spbillCreateIp = "127.0.0.1";
        }
        paraMap.put("spbill_create_ip",spbillCreateIp );//终端IP
//        paraMap.put("spbill_create_ip", request.getRemoteAddr());//交易起始时间
//        paraMap.put("spbill_create_ip", request.getRemoteAddr());//交易结束时间
//        paraMap.put("goods_tag", request.getRemoteAddr());//商品标记
        paraMap.put("notify_url", wxMerchant.getCertUrl());// 通知地址(此路径是微信服务器调用支付结果通知路径)
        paraMap.put("trade_type", "JSAPI");//交易类型
//        paraMap.put("product_id", "JSAPI");//商品ID
//        paraMap.put("limit_pay", "JSAPI");//指定支付方式
        paraMap.put("openid", request.getContent().getOpenId());//用户标识

        TreeMap<String,Object> treeMap = new TreeMap<>(paraMap);
        String param = MapUtils.treeMap2ascString(treeMap) + "&key=" + wxMerchant.getPartnerKey();
        String sign =  SecurityUtils.md5(param).toUpperCase();//签名
        paraMap.put("sign", sign);

        String xml = ArrayToXml(paraMap);
        String xmlStr = PayClient.jsPay(xml);
        // 预付商品id
        String prepay_id = "";
        if (xmlStr.indexOf("SUCCESS") != -1) {
            Map<String, String> map = doXMLParse(xmlStr);
            prepay_id =  map.get("prepay_id");
        }
        log.info("预结单ID为: prepay_id = {}",prepay_id);
        String timestamp = Long.toString(System.currentTimeMillis() / 1000);

        TreeMap<String,Object> treeMap2 = new TreeMap<>();
        treeMap2.put("appId",wxMerchant.getAppId());
        treeMap2.put("timeStamp", timestamp);
        treeMap2.put("nonceStr",nonceStr);
        treeMap2.put("package","prepay_id=" + prepay_id);
        treeMap2.put("signType","MD5");
        String param2 = MapUtils.treeMap2ascString(treeMap2)+ "&key=" + wxMerchant.getPartnerKey();
        String sign2 =  SecurityUtils.md5(param2).toUpperCase();//签名
        log.info("params:{},sign2:{}",param2,sign2);

        Pay pay = new Pay();
        pay.setAppId(wxMerchant.getAppId());
        pay.setTimeStamp(timestamp);
        pay.setNonceStr(nonceStr);
        pay.setPg(prepay_id);
        pay.setSignType("MD5");
        pay.setPaySign(sign2);
        pay.setOpenid(request.getContent().getOpenId());
       log.info("应该响应到网页内容为: pay = {}",pay);
        response.setContent(pay);

        //保持订单信息
        Trade trade = new Trade();
        trade.setUserUniqueType(1);
        trade.setUserUnique(request.getContent().getOpenId());
        trade.setIp(spbillCreateIp);
        trade.setAppId(wxMerchant.getAppId());
        trade.setMchId(wxMerchant.getPartnerId());
        trade.setDeviceInfo(paraMap.get("device_info"));
        trade.setGoods(paraMap.get("body"));
        trade.setOutTradeNo(paraMap.get("out_trade_no"));
        trade.setOrderFee(Integer.valueOf(paraMap.get("total_fee")));
        trade.setOrderStatus(1);
//        trade.setTransactionId();
//        trade.setTransactionNo();
        trade.setPrepayId(prepay_id);
        trade.setSignType("MD5");
        trade.setSign(paraMap.get("sign"));
        trade.setNonceStr(nonceStr);
        trade.setTimeStamp(timestamp);
        trade.setDataCreator("weixin");
        trade.setDataUpdater("weixin");
        tradeRepository.save(trade);

        wxFansRepository.updateOtherByOpenid(request.getContent().getName(),request.getContent().getMobile(),request.getContent().getOpenId());
    }
    /**
     * map转成xml
     *
     * @param arr
     * @return
     */
    public String ArrayToXml(Map<String, String> arr) {
        String xml = "<xml>";

        Iterator<Map.Entry<String, String>> iter = arr.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String key = entry.getKey();
            String val = entry.getValue();
            xml += "<" + key + ">" + val + "</" + key + ">";
        }

        xml += "</xml>";
        return xml;
    }
    private Map<String, String> doXMLParse(String xml)
            throws XmlPullParserException, IOException {

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());

        Map<String, String> map = null;

        XmlPullParser pullParser = XmlPullParserFactory.newInstance()
                .newPullParser();

        pullParser.setInput(inputStream, "UTF-8"); // 为xml设置要解析的xml数据

        int eventType = pullParser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    map = new HashMap<String, String>();
                    break;

                case XmlPullParser.START_TAG:
                    String key = pullParser.getName();
                    if (key.equals("xml"))
                        break;

                    String value = pullParser.nextText();
                    map.put(key, value);

                    break;

                case XmlPullParser.END_TAG:
                    break;

            }

            eventType = pullParser.next();

        }

        return map;
    }

    //    @RequestMapping(value = "web",method = RequestMethod.POST)
//    public Response<WxpayWebResp> web(@RequestBody Request<WxpayWebReq> request) throws Exception{
//        Response<WxpayWebResp> response = new Response<>();
//        response.setStatusCode(StatusCode.OK);
//
//        weixinPayService.web(request,response);
//        return response;
//    }
    private String getUserOpenId(HttpServletRequest request) throws Exception{
        String code = request.getParameter("code");
        if (code == null) {
            String openId = request.getParameter("openId");
            return openId;
        }
//        Oauth
        return "";
    }
    /**
     *
     * @return
     */
    private String create_nonce_str(){
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String res = "";
        for (int i = 0; i < 16; i++) {
            Random rd = new Random();
            res += chars.charAt(rd.nextInt(chars.length() - 1));
        }
        return res;
    }

    private String getSign(Map<String, String> params, String paternerKey )throws UnsupportedEncodingException {
//        String string1 = Pay.createSign(params, false);
        String string1 = "";
        String stringSignTemp = string1 + "&key=" + paternerKey;
        String signValue = DigestUtils.md5Hex(stringSignTemp).toUpperCase();
        return  signValue;
    }
}
