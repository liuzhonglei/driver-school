package com.drivers.weixin.service.impl;

import com.drivers.entity.CadetPay;
import com.drivers.entity.School;
import com.drivers.router.service.CadetPayService;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetPayResp;
import com.drivers.router.web.response.base.Response;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.message.response.TextMessageResp;
import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import com.medal.weixin.sdk.service.ClickHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * Created by xhuji on 2016/10/22.
 */
@Service
@Transactional
@Slf4j
public class PayStatusClickHandle implements ClickHandle{
    @Autowired
    private  CadetPayService cadetPayService;
    @Autowired
    private SchoolService schoolService;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public BaseMessageResp handle(Map<String,String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();

        Request<String> request = new Request<>();
        request.setContent(requestMap.get("FromUserName"));

        Response<CadetPayResp> response = new Response<>();
        cadetPayService.findOneByOpenId(request,response);
        CadetPayResp cadetPayResp = response.getContent();

        StringBuilder sb = new StringBuilder();
        if (null != cadetPayResp){
            String name = "";
            if (StringUtil.isNotBlank(cadetPayResp.getName())){
                name = cadetPayResp.getName();
            }else if (StringUtil.isNotBlank(cadetPayResp.getUsername())){
                name = cadetPayResp.getUsername();
            }else {
                name = "【匿名】";
            }
            String sex = "";
            if (null == cadetPayResp.getSex()){
                sex = "先生/女士";
            }else if (cadetPayResp.getSex() == 1){
                sex = "先生";
            }else {
                sex = "女士";
            }
            sb.append("尊敬的" + name + "(" + sex + "): \n");
            sb.append("\n");
            sb.append("您的缴费情况如下: " + "\n");
            if (cadetPayResp.getPayStatus() != null && cadetPayResp.getPayStatus() == 1){
                sb.append("    缴费金额: "+ cadetPayResp.getPayAmount() + "(元)\n");
                sb.append("    缴费时间: "+ cadetPayResp.getPayDatetime().format(formatter) + "\n");
            }else {
                sb.append("    您还未缴费,请尽快联系管理员,谢谢\n");
            }
        }else {
            sb.append("对不起,暂时未找到你的缴费相关记录！\n");
        }

        sb.append("\n");

        Response<School> schoolResponse = new Response<>();
        schoolService.findAll(schoolResponse);
        School school = schoolResponse.getContent();
        sb.append("感谢您的咨询,如有疑问,请联系\n");
        sb.append("    管理员:" + school.getAdministrators() + "\n");
        sb.append("    电话:" + school.getMobile());
        textMessageResp.setContent(sb.toString());
        return textMessageResp;
    }
}
