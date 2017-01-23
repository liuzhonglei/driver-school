package com.medal.framework.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

/**
 * MyBatis扫描接口，使用的tk.mybatis.spring.mapper.MapperScannerConfigurer，如果你不使用通用Mapper，可以改为org.xxx...
 * Created by xhuji on 2016/8/17.
 */
@Configuration
@ConditionalOnClass({SqlSessionFactory.class,SqlSessionFactoryBean.class})
@EnableConfigurationProperties({MedalMybatisProperties.class})
@AutoConfigureAfter(MybatisAutoConfiguration.class)//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
@Slf4j
public class MyBatisMapperAutoConfiguration{
//    @Autowired
//    private MedalMybatisProperties properties;

    @Bean
    @ConditionalOnMissingBean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //从配置文件中获取sqlSessionFactoryBeanName[缺省为'sqlSessionFactory']
//        String sqlSessionFactoryBeanName = properties.getSqlSessionFactoryBeanName();
//        if (StringUtils.hasText(sqlSessionFactoryBeanName)){
//            mapperScannerConfigurer.setSqlSessionFactoryBeanName(sqlSessionFactoryBeanName);
//        }else {
//            mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        }
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        String basePackage = properties.getBasePackage();
//        if (StringUtils.hasText(basePackage)){
//            mapperScannerConfigurer.setBasePackage(basePackage);
//        }else{
//            //已经提前处理
//        }
        mapperScannerConfigurer.setBasePackage("com.istart.demo.repository");
        Properties _properties = new Properties();

//        String mappers = properties.getMappers();
//        if (StringUtils.hasText(mappers)){
//            _properties.put("mappers","com.istart.framework.mybatis.base.IstartMapper,com.istart.framework.mybatis.base.BaseMapper," + mappers);
//        }else{
//            _properties.put("mappers","com.istart.framework.mybatis.base.IstartMapper,com.istart.framework.mybatis.base.BaseMapper");
//        }
        _properties.put("mappers","com.medal.framework.mybatis.base.IstartMapper,com.medal.framework.mybatis.base.BaseMapper");
        _properties.setProperty("notEmpty", "false");
        _properties.setProperty("IDENTITY", "MYSQL");
        mapperScannerConfigurer.setProperties(_properties);
        return mapperScannerConfigurer;
    }
}
