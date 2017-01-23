package com.medal.framework.mybatis.config;

import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by xhuji on 2016/8/26.
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class,SqlSessionFactoryBean.class})
//@ConditionalOnBean({DataSource.class})
@Slf4j
public class MybatisCommonBeanAutoConfiguration {

    /**
     * databaseIdProvider
     * @return
     * @throws IOException
     */
    @Bean
    @ConditionalOnMissingBean
    public VendorDatabaseIdProvider databaseIdProvider() throws IOException {
        log.debug("开始加载Bean{}","databaseIdProvider");
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

    /**
     * 分页插件
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public Interceptor[] interceptors(){
        log.debug("开始加载Bean{}","interceptors");
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
    @Bean
    @ConditionalOnMissingBean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.istart.test.women");//为了不加载失败随便写的一个包名。  如果这个包名对应与对应的Mapper接口包的话，接口上不需要对应的@Mapper注解，否则需要。
        Properties _properties = new Properties();
        _properties.put("mappers","com.medal.framework.mybatis.base.IstartMapper," +
                "com.medal.framework.mybatis.base.BaseMapper");
        _properties.setProperty("notEmpty", "false");
        _properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(_properties);
        return mapperScannerConfigurer;
    }
//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer(){
//        MapperScannerConfigurer scannerConfigurer = new MapperScannerConfigurer();
//        scannerConfigurer.setBasePackage("com.medal.framework.mybatis.base");
//        return  scannerConfigurer;
//    }
//    @Bean
//    public MapperHelper mapperHelper(){
//        MapperHelper helper = new MapperHelper();
//        Properties _properties = new Properties();
//        _properties.put("mappers","com.medal.framework.mybatis.base.IstartMapper," +
//                "com.medal.framework.mybatis.base.BaseMapper");
//        _properties.setProperty("notEmpty", "false");
//        _properties.setProperty("IDENTITY", "MYSQL");
//        helper.setProperties(_properties);
//        return helper;
//    }
}
