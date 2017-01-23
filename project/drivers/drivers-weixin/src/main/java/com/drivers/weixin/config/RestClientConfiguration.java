package com.drivers.weixin.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用spring的restTemplate替代httpclient工具
 * Created by xhuji on 2016/10/24.
 */
@Configuration
@Slf4j
public class RestClientConfiguration {

//    @Bean
    public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();

        //整个连接池的并发数
        poolingHttpClientConnectionManager.setMaxTotal(300);
        //同路由地址的并发数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(200);

        return poolingHttpClientConnectionManager;
    }
//    @Bean
    public HttpClientBuilder httpClientBuilder(){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(poolingHttpClientConnectionManager());
        // 重试次数，默认是3次，没有开启
        httpClientBuilder.setRetryHandler(new DefaultHttpRequestRetryHandler(2, true));
        // 保持长连接配置，需要在头添加Keep-Alive
        httpClientBuilder.setKeepAliveStrategy(DefaultConnectionKeepAliveStrategy.INSTANCE);
        //
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.16 Safari/537.36"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        httpClientBuilder.setDefaultHeaders(headers);

        return httpClientBuilder;
    }
//    @Bean
    public HttpClient httpClient(){
        return httpClientBuilder().build();
    }

//    @Bean
    public HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory(){
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient());
        //连接超时时间，毫秒
        clientHttpRequestFactory.setConnectTimeout(5000);
        //读写超时时间，毫秒// 数据读取超时时间，即SocketTimeout
        clientHttpRequestFactory.setReadTimeout(10000);
        // 连接不够用的等待时间，不宜过长，必须设置，比如连接不够用时，时间过长将是灾难性的
        clientHttpRequestFactory.setConnectionRequestTimeout(200);
        // 缓冲请求数据，默认值是true。通过POST或者PUT大量发送数据时，建议将此属性更改为false，以免耗尽内存。
        // clientHttpRequestFactory.setBufferRequestBody(false);
        return clientHttpRequestFactory;
    }
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();

        // 添加内容转换器
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());
        messageConverters.add(new ByteArrayHttpMessageConverter());
        restTemplate.setMessageConverters(messageConverters);
        //
        restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory());
        //
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
        log.debug("RestClient初始化完成");
        return restTemplate;
    }
}
