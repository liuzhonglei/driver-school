package com.drivers.weixin.service.impl;

import com.drivers.entity.Cadet;
import com.drivers.entity.Coach;
import com.drivers.entity.School;
import com.drivers.router.repository.CadetRepository;
import com.drivers.router.service.CoachService;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.base.Response;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.message.response.TextMessageResp;
import com.medal.weixin.sdk.message.response.base.BaseMessageResp;
import com.medal.weixin.sdk.service.ClickHandle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by xhuji on 2016/10/26.
 */
@Service
@Transactional
@Slf4j
public class CoachInfoClickHandle implements ClickHandle{
    @Autowired
    private CoachService coachService;
    @Autowired
    private CadetRepository cadetRepository;
    @Autowired
    private SchoolService schoolService;

    @Override
    public BaseMessageResp handle(Map<String,String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();

        Request<String> request = new Request<>();
        request.setContent(requestMap.get("FromUserName"));
        Response<Coach> response = new Response<>();
        coachService.findByCadetOpenId(request,response);
        Coach coach = response.getContent();

        Cadet cadet = cadetRepository.findByOpenid(requestMap.get("FromUserName"));
        StringBuilder sb = new StringBuilder();
        if (null != coach){
            String cadetName;
            if (StringUtil.isNotBlank(cadet.getName())){
                cadetName = cadet.getName();
            }else {
                cadetName = "【匿名】";
            }
            String sex;
            if (null == cadet.getSex()){
                sex = "先生/女士";
            }else if (cadet.getSex() == 1){
                sex = "先生";
            }else {
                sex = "女士";
            }
            sb.append("尊敬的" + cadetName + "(" + sex + "): \n");
            sb.append("\n");
            sb.append("您的教练信息如下: " + "\n");
            if (StringUtil.isNotBlank(coach.getName())){
                sb.append("教练姓名: "+ coach.getName() + "\n");
            }else {
                sb.append("教练姓名: "+ "无 \n");
            }
            if (StringUtil.isNotBlank(coach.getMobile())){
                sb.append("教练电话: "+ coach.getMobile() + "\n");
            }else {
                sb.append("教练电话: "+ "无 \n");
            }
        }else {
            sb.append("对不起,暂时未找到你的教练相关信息！\n");
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
