package com.cvicse.msa.druid;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ThreadLocal存储当前使用数据源实例的key。ThreadLocal实例化的时候给一个master的默认值，也就是默认数据源是master数据源。
 */
public class DynamicDataSourceContextHolder {

    private static ThreadLocal<Object> CONTEXT_HOLDER = ThreadLocal.withInitial(() -> DataSourceKey.PRIMARY.getName());
    public static List<Object> dataSourceKeys = new ArrayList<Object>();

    public static void setDataSourceKey(String key){
        CONTEXT_HOLDER.set(key);
    }

    public static Object getDataSourceKey(){
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceKey(){
        CONTEXT_HOLDER.remove();
    }

    public static Boolean containDataSourceKey(String key){
        return dataSourceKeys.contains(key);
    }

}
