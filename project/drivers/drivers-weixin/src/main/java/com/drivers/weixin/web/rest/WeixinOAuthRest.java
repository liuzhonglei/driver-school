package com.drivers.weixin.web.rest;//package com.medal.weixin.sdk.rest;

import com.drivers.router.repository.SchoolTuitionRepository;
import com.drivers.router.web.response.SchoolTuitionResp;
import com.drivers.weixin.service.WeixinOAuthService;
import com.medal.common.utils.StringUtil;
import com.medal.weixin.sdk.pojo.SNSUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xhuji on 2016/10/17.
 */
@Controller
@RequestMapping("/weixin")
@Slf4j
public class WeixinOAuthRest {

    @Autowired
    private WeixinOAuthService weixinOAuthService;
    @Autowired
    private SchoolTuitionRepository schoolTuitionRepository;
    /**
     * 授权后的回调请求处理
     *
     * @return
     */
    @RequestMapping(value = "/oauth", method = RequestMethod.GET)
    public String getSNSUserInfo(HttpServletRequest request, HttpServletResponse response,RedirectAttributes attr) throws Exception {
        log.debug("授权后的回调请求处理:{}","getSNSUserInfo");
        request.setCharacterEncoding("gb2312");
        response.setCharacterEncoding("gb2312");
        // 用户同意授权后，能获取到code
        String code = request.getParameter("code");
        // 用户同意授权
        if (StringUtil.isNotBlank(code) && !"authdeny".equals(code)) {
            log.debug("用户同意授权");
            SNSUserInfo snsUserInfo = weixinOAuthService.getSNSUserInfo(code);
            // 设置要传递的参数
            attr.addAttribute("openId", snsUserInfo.getOpenId());
            SchoolTuitionResp schoolTuitionResp =  schoolTuitionRepository.findAllBySearch();
            attr.addAttribute("tuition", schoolTuitionResp.getTuition());
            log.debug("授权后传递的参数:openId={},tuition={}",snsUserInfo.getOpenId(),schoolTuitionResp.getTuition());
        }else {
            log.debug("用户不同意授权");
        }
        return "redirect:/pay/payment.html";
    }
}
