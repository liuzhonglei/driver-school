package com.drivers.manager.web;

import com.codahale.metrics.annotation.Timed;
import com.drivers.router.web.rest.base.BaseResource;
import lombok.extern.slf4j.Slf4j;
import org.javasimon.aop.Monitored;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xhuji on 2016/8/27.
 */
@Controller
@Slf4j
public class Router extends BaseResource{

    /**
     * 后台首页
     * @return
     */
    @Timed
    @Monitored
    @RequestMapping(value = {"/index.html","/dashboard.html"}, method = RequestMethod.GET)
    public String getHomePage(){
        log.debug("Getting home page");
        return "/dashboard";
    }
    /**
     * 登录页面
     * both "normal login" and "login for update" shared this form.
     *
     */
    @RequestMapping(value = {"/","/login.html"}, method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "用户名或密码无效!");

            //login form for update page
            //if login error, get the targetUrl from session again.
            String targetUrl = getRememberMeTargetUrlFromSession(request);
            System.out.println(targetUrl);
            if(StringUtils.hasText(targetUrl)){
                model.addObject("targetUrl", targetUrl);
                model.addObject("loginUpdate", true);
            }
        }
        if (logout != null) {
            model.addObject("msg", "您已经成功退出.");
        }
        model.setViewName("/login");
        return model;
    }
    /**
     * Check if user is login by remember me cookie, refer
     * org.springframework.security.authentication.AuthenticationTrustResolverImpl
     */
    private boolean isRememberMeAuthenticated() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return false;
        }

        return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
    }

    /**
     * save targetURL in session
     */
    private void setRememberMeTargetUrlToSession(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.setAttribute("targetUrl", "/admin/update");
        }
    }

    /**
     * get targetURL from session
     */
    private String getRememberMeTargetUrlFromSession(HttpServletRequest request){
        String targetUrl = "";
        HttpSession session = request.getSession(false);
        if(session!=null){
            targetUrl = session.getAttribute("targetUrl")==null?""
                    :session.getAttribute("targetUrl").toString();
        }
        return targetUrl;
    }

    /******************************************************************************************************
     * 系统管理员
     *
     *************************************************************************************************/

    /**
     * 管理员列表
     * @return
     */
    @Timed
    @Monitored
    @RequestMapping(value = "/sysmanagers.html", method = RequestMethod.GET)
    public String sysmanagers(){
        return "/sysmanager/sysmanager";
    }

    /**
     * 注册管理员
     * @return
     */
    @Timed
    @Monitored
    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public String register(){
        return "/sysmanager/register";
    }

    /**
     * 管理员个人基本信息
     * @return
     */
    @Timed
    @Monitored
    @RequestMapping(value = "/sysmanager.html", method = RequestMethod.GET)
    public String sysmanager(){
        return "/sysmanager/profile";
    }

    /**
     * 管理员修改密码
     * @return
     */
    @Timed
    @Monitored
    @RequestMapping(value = "/password.html", method = RequestMethod.GET)
    public String updatePassword(){
        return "/sysmanager/password";
    }
    /******************************************************************************************************
     * 驾校管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/school.html", method = RequestMethod.GET)
    public String school(){
        return "/school/school";
    }
    @Timed
    @Monitored
    @RequestMapping(value = "/schooltuition.html", method = RequestMethod.GET)
    public String schoolTuition(){
        return "/school/tuition";
    }
    /******************************************************************************************************
     * 教练管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/car.html", method = RequestMethod.GET)
    public String car(){
        return "/car/car";
    }
    /******************************************************************************************************
     * 教练管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/coach.html", method = RequestMethod.GET)
    public String coach(){
        return "/coach/coach";
    }
    /******************************************************************************************************
     * 学员管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/cadet.html", method = RequestMethod.GET)
    public String cadet(){
        return "/cadet/cadet";
    }

    @Timed
    @Monitored
    @RequestMapping(value = "/cadetpay.html", method = RequestMethod.GET)
    public String cadetpay(){
        return "/cadet/pay";
    }

    @Timed
    @Monitored
    @RequestMapping(value = "/cadetcourse.html", method = RequestMethod.GET)
    public String cadetcourse(){
        return "/cadet/course";
    }
    /******************************************************************************************************
     * 投诉建议
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/suggestion.html", method = RequestMethod.GET)
    public String suggestion(){
        return "/suggestion/suggestion";
    }

    /******************************************************************************************************
     * 统计
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/cadet_pay_statistics.html", method = RequestMethod.GET)
    public String cadetPayStatistics(){
        return "/statistics/cadet_pay";
    }
    @Timed
    @Monitored
    @RequestMapping(value = "/cadet_num_statistics.html", method = RequestMethod.GET)
    public String cadetNumStatistics(){
        return "/statistics/cadet_num";
    }
    /******************************************************************************************************
     * 系统管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/log.html", method = RequestMethod.GET)
    public String log(){
        return "/system/log";
    }

    /******************************************************************************************************
     * 微信管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/wxInfo.html", method = RequestMethod.GET)
    public String wxInfo(){
        return "/weixin/wxInfo";
    }

    @Timed
    @Monitored
    @RequestMapping(value = "/message.html", method = RequestMethod.GET)
    public String message(){
        return "/weixin/message";
    }

    @Timed
    @Monitored
    @RequestMapping(value = "/wxfans.html", method = RequestMethod.GET)
    public String wxfans(){
        return "/weixin/wxFans";
    }
    /******************************************************************************************************
     * 订单管理
     *
     *************************************************************************************************/
    @Timed
    @Monitored
    @RequestMapping(value = "/order.html", method = RequestMethod.GET)
    public String order(){
        return "/trade/order";
    }

}
