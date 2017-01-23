//package com.drivers.weixin.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.CharEncoding;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Description;
//import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
//
///**
// * Title:
// * Description:
// * Copyright: Copyright (c) 2012
// * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
// *
// * @author xiejinjun
// * @version 1.0 2016/9/2
// */
//@Configuration
//@Slf4j
//public class ThymeleafConfiguration {
//
//    @Bean
//    @Description("Thymeleaf template resolver serving HTML 5 emails")
//    public ClassLoaderTemplateResolver emailTemplateResolver() {
//        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
//        resolver.setPrefix("templates/");
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML5");
//        resolver.setCharacterEncoding(CharEncoding.UTF_8);
//        resolver.setOrder(1);
//        return resolver;
//    }
//}
