package com.cvicse.msa.druid;


import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * 动态数据源
 * DynamicDataSource扩展Spring的AbstractRoutingDataSource抽象类，重写determineCurrentLookupKey()方法
 * determineCurrentLookupKey()方法决定使用哪个数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
    * ThreadLocal用于提供线程局部变量，在多线程环境可以保证各个线程里的变量独立于其它线程里的变量。
    * 也就是说ThreadLocal可以为每个线程创建一个【单独的变量副本】，相当于线程的private static类型变量。
    */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 决定使用哪个数据源之前需要把多个数据源的信息以及默认数据源信息配置好
     * @param defaultTargetDataSource  默认数据源
     * @param targetDataSources       目标数据源
     */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }


    @Override
    protected Object determineCurrentLookupKey() {
        //logger.info("当前数据源：{}"+ DataSourceContextHolder.getDataBaseType());
        return DataSourceContextHolder.getDataBaseType();
    }

}
