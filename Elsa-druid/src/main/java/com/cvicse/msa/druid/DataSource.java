package com.cvicse.msa.druid;

import java.lang.annotation.*;

/**
 * 多数据源注解类
 * @author lizl
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
