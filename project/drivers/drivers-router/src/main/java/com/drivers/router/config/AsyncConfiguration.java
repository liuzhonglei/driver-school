package com.drivers.router.config;

import com.drivers.router.async.ExceptionHandlingAsyncTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * <task:annotation-driven executor="myExecutor" scheduler="myScheduler"/>
 * <task:executor id="myExecutor" pool-size="5"/>
 * <task:scheduler id="myScheduler" pool-size="10"/>
 * Created by xhuji on 2016/9/7.
 */
@Configuration
@EnableAsync(proxyTargetClass = true)
@EnableScheduling
@Slf4j
public class AsyncConfiguration implements AsyncConfigurer{
    @Autowired
    private JHipsterProperties jHipsterProperties;

    @Bean(name = "myExecutor")
    @Override
    public Executor getAsyncExecutor() {
        log.debug("Creating Async Task Executor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(jHipsterProperties.getAsync().getCorePoolSize());
        executor.setMaxPoolSize(jHipsterProperties.getAsync().getMaxPoolSize());
        executor.setQueueCapacity(jHipsterProperties.getAsync().getQueueCapacity());
        executor.setThreadNamePrefix("istart-Executor-");
        return new ExceptionHandlingAsyncTaskExecutor(executor);
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
