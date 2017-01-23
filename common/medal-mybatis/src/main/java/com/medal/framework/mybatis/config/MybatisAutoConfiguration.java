package com.medal.framework.mybatis.config;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Title:  MyBatis基础配置
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/16
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class,SqlSessionFactoryBean.class})
@ConditionalOnBean({DataSource.class})
@EnableConfigurationProperties({MedalMybatisProperties.class})
@AutoConfigureAfter({DataSourceAutoConfiguration.class})
@Slf4j
public class MybatisAutoConfiguration {
    /**
     * 属性
     */
    @Autowired
    private MedalMybatisProperties properties;
    /**
     * 资源处理器
     */
    private ResourceLoader resourceLoader = new DefaultResourceLoader();
    /**
     * 注入Mybatis插件 (option)
     */
    @Autowired(required = false)
    private Interceptor[] interceptors;
    /**
     *  (option)
     */
    @Autowired(required = false)
    private DatabaseIdProvider databaseIdProvider;

    @PostConstruct
    public void checkConfigFileExists(){
        if (this.properties.isCheckConfigLocation() && StringUtils.hasText(this.properties.getConfigLocation())){
            Resource resource = this.resourceLoader.getResource(this.properties.getConfigLocation());
            Assert.state(resource.exists(), "Cannot find config location: " + resource + " (please add config file or check your Mybatis " + "configuration)");
        }
    }
    /**
     * 创建SqlSessionFactory bean：采用mybatis-spring方式配置(SqlSessionFactoryBean)
     * @see  "http://www.mybatis.org/spring/zh/getting-started.html"
     *
     * @return
     * @throws Exception
     */
    @Bean
    @ConditionalOnMissingBean//自由在容器中没有这个bean的时候才会配置该bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        //指定 数据源
        factory.setDataSource(dataSource);
//        factory.setVfs(SpringBootVFS.class);
        //指定 MyBatis的XML配置文件路径
        if (StringUtils.hasText(this.properties.getConfigLocation())){
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        factory.setConfiguration(this.properties.getConfiguration());
        if(!ObjectUtils.isEmpty(this.interceptors)) {
            factory.setPlugins(this.interceptors);
        }
        //指定 数据库ID识别器
        if(this.databaseIdProvider != null) {
            factory.setDatabaseIdProvider(this.databaseIdProvider);
        }
        //
        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())){
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if(StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        //指定 mapper xml目录
        if (!ObjectUtils.isEmpty(this.properties.resolveMapperLocations())){
            factory.setMapperLocations(this.properties.resolveMapperLocations());
        }
        return factory.getObject();
    }

    /**
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
//    @ConditionalOnMissingBean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        ExecutorType executorType = this.properties.getExecutorType();
        return executorType != null?new SqlSessionTemplate(sqlSessionFactory, executorType):new SqlSessionTemplate(sqlSessionFactory);

    }

    @Bean
    @ConditionalOnMissingBean
    public VendorDatabaseIdProvider databaseIdProvider() throws IOException {
        VendorDatabaseIdProvider vendorDatabaseIdProvider = new VendorDatabaseIdProvider();

        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Properties properties = new Properties();
        properties.put("SQL Server", "sqlserver");
        properties.put("DB2", "db2");
        properties.put("Oracle", "oracle");
        properties.put("MySQL", "mysql");
        properties.put("H2", "h2");
        propertiesFactoryBean.setProperties(properties);

        vendorDatabaseIdProvider.setProperties(propertiesFactoryBean.getObject());
        return vendorDatabaseIdProvider;
    }

    @Bean
    @ConditionalOnMissingBean
    public Interceptor[] interceptors(){
        //设置并添加分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);
        return new Interceptor[]{pageHelper};
    }

}
