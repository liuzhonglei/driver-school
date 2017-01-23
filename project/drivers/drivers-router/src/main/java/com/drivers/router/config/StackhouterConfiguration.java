//package com.drivers.router.config;
//
//import com.stackhunter.client.web.StackHunterServletFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
///**
// * Title:
// * Description:
// * Copyright: Copyright (c) 2012
// * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
// *
// * @author xiejinjun
// * @version 1.0 2016/9/7
// */
//@Configuration
//public class StackhouterConfiguration {
//
//    @Bean
//    public FilterRegistrationBean stackHunterServletFilter(){
//        FilterRegistrationBean  registrationBean = new FilterRegistrationBean(new StackHunterServletFilter());
//        registrationBean.setName("StackHunterServletFilter");
//        registrationBean.setUrlPatterns(Arrays.asList("/*"));
//        return registrationBean;
//    }
//}
