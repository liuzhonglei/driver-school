package com.drivers.weixin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by xhuji on 2016/9/4.
 */
@Controller
@Slf4j
public class Route {
    @RequestMapping(value = {"/","/index.html"},method = RequestMethod.GET)
    public String index(){
        log.debug("visit index page");
        return "/index";
    }

    @RequestMapping(value = "/about.html",method = RequestMethod.GET)
    public String about(){
        log.debug("visit about page");
        return "/about";
    }

    /**
     * suggestion
     * @return
     */
    @RequestMapping(value = "/suggestion.html",method = RequestMethod.GET)
    public String suggestion(){
        log.debug("visit suggestion page");
        return "/suggestion";
    }
    @RequestMapping(value = "/signup.html",method = RequestMethod.GET)
    public String signup(){
        log.debug("visit signup page");
        return "/signup";
    }
    @RequestMapping(value = "/pay/payment.html",method = RequestMethod.GET)
    public String payment(RedirectAttributes attr){
        log.debug("visit payment page");
        return "/signup/signup";
    }

    @RequestMapping(value = "/contact.html",method = RequestMethod.GET)
    public String contact(){
        log.debug("visit contact page");
        return "/contact";
    }

    @RequestMapping(value = "/addr.html",method = RequestMethod.GET)
    public String addr(){
        log.debug("visit addr page");
        return "/addr";
    }

    @RequestMapping(value = "/fee.html",method = RequestMethod.GET)
    public String fee(){
        log.debug("visit fee page");
        return "/fee";
    }
}
