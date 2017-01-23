package com.drivers.router.config;

import org.javasimon.console.SimonConsoleServlet;
import org.javasimon.spring.MonitoredMeasuringPointcut;
import org.javasimon.spring.MonitoringInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *  演示配置能力，包括AOP配置与Servlet配置
 *  地址： http://<IP>:<PORT>/<context>/javasimon
 *
 *  注意：javasimon是实时刷新，最好不要在生成环境中使用
 * Created by xhuji on 2016/9/7.
 */
@Configuration
@Profile((Profiles.SPRING_PROFILE_DEVELOPMENT))
public class JavasimonConfiguration {
    //定义AOP,对标注了@Monitored的方法进行监控
    @Bean(name = "monitoringAdvisor")
    public DefaultPointcutAdvisor monitoringAdvisor(){
        DefaultPointcutAdvisor monitoringAdvisor = new DefaultPointcutAdvisor();
        monitoringAdvisor.setAdvice(new MonitoringInterceptor());
        monitoringAdvisor.setPointcut(new MonitoredMeasuringPointcut());
        return monitoringAdvisor;
    }
    @Bean
    public ServletRegistrationBean dispatcherRegistration(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new SimonConsoleServlet());
        registration.addInitParameter("url-prefix","/javasimon");
        registration.addUrlMappings("/javasimon/*");
        return registration;
    }
}
