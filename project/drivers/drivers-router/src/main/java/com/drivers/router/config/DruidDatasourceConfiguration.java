package com.drivers.router.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLException;

/**
 * Title: 数据源配置
 * Description: 采用Drui数据源
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/7/22
 */
@Configuration
@Slf4j
public class DruidDatasourceConfiguration {
    public DruidDatasourceConfiguration(){
        log.debug("装载medal-mybatis项目下的DatasourceConfiguration！");
    }
    @Value("${spring.datasource.name}")
    private String name;
    @Value("${spring.datasource.url}")
    private String jdbcUrl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.max-active:100}")
    private int maxActive;
    @Value("${spring.datasource.min-idle:8}")
    private int initialSize;
    @Value("${spring.datasource.max-wait}")
    private long maxWaitMillis;
    @Value("${spring.datasource.min-idle}")
    private int minIdle;
    @Value("${spring.datasource.time-between-eviction-runs-millis}")
    private long timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.min-evictable-idle-time-millis}")
    private long minEvictableIdleTimeMillis;
    @Value("${spring.datasource.validation-query:SELECT 'x'}")
    private String validationQuery;
    private boolean testWhileIdle = true;
    private boolean testOnBorrow = false;
    private boolean testOnReturn = false;
    private boolean poolPreparedStatements = true;
    private int maxOpenPreparedStatements = 20;

    /**
     * ali druid数据源
     * @return
     * @throws SQLException
     */
    @Bean(name = "dataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setName(name);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(100);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWaitMillis);
        dataSource.setMinIdle(minIdle);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxOpenPreparedStatements(maxOpenPreparedStatements);
        return dataSource;
    }
    /**
     * 配置StatViewServlet
     * 		Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
     * 		这个StatViewServlet的用途包括：
     	 * 		提供监控信息展示的html页面
     	 * 		提供监控信息的JSON API
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new StatViewServlet());
        registration.addUrlMappings("/druid/*");
        registration.addInitParameter("resetEnable", "true");//允许清空统计数据
        registration.addInitParameter("loginUsername", "druid");//用户名
        registration.addInitParameter("loginPassword", "druid");//密码
        return registration;
    }
}
