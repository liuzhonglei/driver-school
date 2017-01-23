//package com.drivers.router.config;
//
//import net.bull.javamelody.MonitoringFilter;
//import net.bull.javamelody.Parameter;
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.context.annotation.Profile;
//
//import javax.servlet.DispatcherType;
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
//@ImportResource("classpath:net/bull/javamelody/monitoring-spring.xml")
//@Profile((Profiles.SPRING_PROFILE_PRODUCTION))
//public class JavaMelodyConfiguration {
//
//    //    @Override
//    //    public void onStartup(ServletContext servletContext) throws ServletException {
//    //        servletContext.addListener(new SessionListener());
//    //    }
//
//    @Bean
//    public FilterRegistrationBean javaMelody() {
//        FilterRegistrationBean javaMelody = new FilterRegistrationBean();
//        javaMelody.setFilter(new MonitoringFilter());
//        javaMelody.setAsyncSupported(true);
//        javaMelody.setName("javamelody");
//        javaMelody.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC);
//
//        // see the list of parameters:
//        // https://github.com/javamelody/javamelody/wiki/UserGuide#6-optional-parameters
//        javaMelody.addInitParameter(Parameter.LOG.getCode(), Boolean.toString(true));
//        // to add basic auth:
//        // javaMelody.addInitParameter(Parameter.AUTHORIZED_USERS.getCode(), "admin:pwd");
//        // to change the default storage directory:
//        // javaMelody.addInitParameter(Parameter.STORAGE_DIRECTORY.getCode(), "/tmp/javamelody");
//
//        javaMelody.addUrlPatterns("/*");
//        return javaMelody;
//    }
//}
