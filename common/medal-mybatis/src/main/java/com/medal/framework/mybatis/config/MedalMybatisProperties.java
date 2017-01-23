package com.medal.framework.mybatis.config;

import lombok.Data;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Title: istart-mybatis的属性配置，Spring-boot自身会自动配置
 * Description:
 * Copyright: Copyright (c) 2012
 * Company: shishike Technology(Beijing) Chengdu Co. Ltd.
 *
 * @author xiejinjun
 * @version 1.0 2016/8/19
 */
@ConfigurationProperties(prefix = "medal.mybatis")
public class MedalMybatisProperties {

    /**
     * config-location: MyBatis xml config file (optional)
     */
    private String configLocation;
    /**
     * mapper-locations: Mapper xml config files (optional)
     */
    private String[] mapperLocations;
    /**
     * type-aliases-package: Package to search for type aliases (optional)
     */
    private String typeAliasesPackage;
    /**
     * type-handlers-package: Package to search for type aliases (optional)
     */
    private String typeHandlersPackage;
    private boolean checkConfigLocation = false;
    /**
     * executor-type: Executor type: SIMPLE, REUSE, BATCH (optional)
     */
    private ExecutorType executorType;
    /**
     * configuration 	A MyBatis Configuration bean. About available properties see the MyBatis reference page. NOTE This property cannot use at the same time with the config-location.
     */
    private Configuration configuration;

    public Resource[] resolveMapperLocations() {
        ArrayList resources = new ArrayList();
        if(this.mapperLocations != null) {
            String[] mapperLocations = this.mapperLocations;
            int var3 = mapperLocations.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                String mapperLocation = mapperLocations[var4];

                try {
                    Resource[] mappers = (new PathMatchingResourcePatternResolver()).getResources(mapperLocation);
                    resources.addAll(Arrays.asList(mappers));
                } catch (IOException var8) {
                    ;
                }
            }
        }

        Resource[] var9 = new Resource[resources.size()];
        var9 = (Resource[])resources.toArray(var9);
        return var9;
    }

    private String sqlSessionFactoryBeanName;

    private String basePackage;

    private String mappers;

    public String getConfigLocation() {
        return configLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }

    public String[] getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String[] mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getTypeAliasesPackage() {
        return typeAliasesPackage;
    }

    public void setTypeAliasesPackage(String typeAliasesPackage) {
        this.typeAliasesPackage = typeAliasesPackage;
    }

    public String getTypeHandlersPackage() {
        return typeHandlersPackage;
    }

    public void setTypeHandlersPackage(String typeHandlersPackage) {
        this.typeHandlersPackage = typeHandlersPackage;
    }

    public boolean isCheckConfigLocation() {
        return checkConfigLocation;
    }

    public void setCheckConfigLocation(boolean checkConfigLocation) {
        this.checkConfigLocation = checkConfigLocation;
    }

    public ExecutorType getExecutorType() {
        return executorType;
    }

    public void setExecutorType(ExecutorType executorType) {
        this.executorType = executorType;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getSqlSessionFactoryBeanName() {
        return sqlSessionFactoryBeanName;
    }

    public void setSqlSessionFactoryBeanName(String sqlSessionFactoryBeanName) {
        this.sqlSessionFactoryBeanName = sqlSessionFactoryBeanName;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getMappers() {
        return mappers;
    }

    public void setMappers(String mappers) {
        this.mappers = mappers;
    }
}
