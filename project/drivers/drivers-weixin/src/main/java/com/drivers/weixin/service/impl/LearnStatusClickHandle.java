package com.drivers.weixin.service.impl;

import com.drivers.entity.School;
import com.drivers.router.service.CadetCourseService;
import com.drivers.router.service.SchoolService;
import com.drivers.router.web.request.base.Request;
import com.drivers.router.web.response.CadetCourseResp;
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
 * Created by xhuji on 2016/10/22.
 */
@Service
@Transactional
@Slf4j
public class LearnStatusClickHandle implements ClickHandle{
    @Autowired
    private CadetCourseService cadetCourseService;
    @Autowired
    private SchoolService schoolService;

    @Override
    public BaseMessageResp handle(Map<String,String> requestMap){
        TextMessageResp textMessageResp = new TextMessageResp();

        Request<String> request = new Request<>();
        request.setContent(requestMap.get("FromUserName"));
        Response<CadetCourseResp> response = new Response<>();
        cadetCourseService.findOneByOpenId(request,response);
        CadetCourseResp cadetCourseResp = response.getContent();

        StringBuilder sb = new StringBuilder();
        if (null != cadetCourseResp){
            String name = "";
            if (StringUtil.isNotBlank(cadetCourseResp.getName())){
                name = cadetCourseResp.getName();
            }else if (StringUtil.isNotBlank(cadetCourseResp.getUsername())){
                name = cadetCourseResp.getUsername();
            }else {
                name = "【匿名】";
            }
            String sex = "";
            if (null == cadetCourseResp.getSex()){
                sex = "先生/女士";
            }else if (cadetCourseResp.getSex() == 1){
                sex = "先生";
            }else {
                sex = "女士";
            }
            sb.append("尊敬的" + name + "(" + sex + "): \n");
            sb.append("\n");
            sb.append("您的课程情况如下: " + "\n");

            if (null == cadetCourseResp.getCourse() || cadetCourseResp.getCourse() == 0){
                sb.append("    课程: "+ "无\n");
            }else if(cadetCourseResp.getCourse() == 1){
                sb.append("    课程: "+ "科目一\n");
            }else if(cadetCourseResp.getCourse() == 2){
                sb.append("    课程: "+ "科目二\n");
            }else if(cadetCourseResp.getCourse() == 3){
                sb.append("    课程: "+ "科目三\n");
            }else if(cadetCourseResp.getCourse() == 4){
                sb.append("    课程: "+ "科目四\n");
            }else {
                sb.append("    课程: "+ "数据异常,请尽快联系管理员\n");
            }
        }else {
            sb.append("对不起,暂时未找到你的课程相关信息！\n");
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
