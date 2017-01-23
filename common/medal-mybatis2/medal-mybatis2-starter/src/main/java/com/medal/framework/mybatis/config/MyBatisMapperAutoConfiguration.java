//package com.medal.framework.mybatis.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import tk.mybatis.spring.mapper.MapperScannerConfigurer;
//
//import java.util.Properties;
//
///**
// * MyBatis扫描接口，使用的tk.mybatis.spring.mapper.MapperScannerConfigurer，如果你不使用通用Mapper，可以改为org.xxx...
// *
// *  本来是想从配置文件中
// * Created by xhuji on 2016/8/17.
// */
//@Configuration
////@ConditionalOnClass({SqlSessionFactory.class,SqlSessionFactoryBean.class})
////@AutoConfigureAfter(MybatisAutoConfiguration.class)//TODO 注意，由于MapperScannerConfigurer执行的比较早，所以必须有下面的注解
//@Slf4j
//public class MyBatisMapperAutoConfiguration{
//
//    @Bean
//    @ConditionalOnMissingBean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
//        mapperScannerConfigurer.setBasePackage("com.istart.test.women");//为了不加载失败随便写的一个包名。  如果这个包名对应与对应的Mapper接口包的话，接口上不需要对应的@Mapper注解，否则需要。
//        Properties _properties = new Properties();
//        _properties.put("mappers","com.medal.framework.mybatis.base.IstartMapper,com.medal.framework.mybatis.base.BaseMapper");
//        _properties.setProperty("notEmpty", "false");
//        _properties.setProperty("IDENTITY", "MYSQL");
//        mapperScannerConfigurer.setProperties(_properties);
//        return mapperScannerConfigurer;
//    }
//}
