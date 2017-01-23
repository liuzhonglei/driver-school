package com.drivers.router.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springside.modules.mapper.JsonMapper;

import javax.servlet.MultipartConfigElement;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Title:
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/9/6
 */
@Configuration
public class MvcConfiguration {
    //    @Bean
//    public SimpleMappingExceptionResolver SimpleMappingExceptionResolver(){
//        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("org.apache.shiro.authz.UnauthenticatedException","error/403");
//        properties.setProperty("java.lang.Throwable","error/500");
//        simpleMappingExceptionResolver.setExceptionMappings(properties);
//        return simpleMappingExceptionResolver;
//    }

    @Bean
    @ConditionalOnMissingBean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/views/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }
    // 参考Spring boot reference 72.3
    @Bean
    public JsonMapper jsonMapper(){
        return JsonMapper.nonNullMapper();
    }

    @Bean
    @Primary
    public ObjectMapper objectMapper(){
        return jsonMapper().getMapper();
    }

    /**
     *
     * @return
     */
    @Bean
    public HttpMessageConverters getHttpMessageConverters(){
        // 添加内容转换器
        Collection<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));// 字符串
        messageConverters.add(new FormHttpMessageConverter());// form表单
        //messageConverters.add(new GsonHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter(objectMapper()));// json
        messageConverters.add(new ByteArrayHttpMessageConverter()); // 流
        return new HttpMessageConverters(true, messageConverters);
    }

    /**
     * 支持文件上传
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("10485760KB");
        factory.setMaxRequestSize("10485760KB");
        return factory.createMultipartConfig();
    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
