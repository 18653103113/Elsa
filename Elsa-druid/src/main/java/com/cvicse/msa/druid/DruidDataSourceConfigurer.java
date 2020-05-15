package com.cvicse.msa.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
public class DruidDataSourceConfigurer {

    //必须要手动的注入一个DruidDataSource而且指定去读取文件，不然是不会初始化数据源的
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.xxxx") //spring.datasource.druid
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        bean.addInitParameter("allow","127.0.0.1");
        bean.addInitParameter("resetEnable","false");
        bean.addInitParameter("loginUsername","druid");
        bean.addInitParameter("loginPassword","druid");
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        bean.addUrlPatterns("/*");
        bean.addInitParameter("exclusions","*.js,*.gif,/druid/*");
        return bean;
    }
}

