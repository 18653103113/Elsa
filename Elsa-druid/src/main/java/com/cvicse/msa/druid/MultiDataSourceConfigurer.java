package com.cvicse.msa.druid;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Profile("multi-datasource")
public class MultiDataSourceConfigurer {
    @Primary    //当系统中有多个数据源时，必须有一个数据源为主数据源，使用@Primary修饰
    @Bean(name = "mysql")
    @ConfigurationProperties("spring.datasource.mysql")
    public DataSource dataSourceMysql(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "oracle")
    @ConfigurationProperties("spring.datasource.oracle")
    public DataSource dataSourceOracle(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "postgres")
    @ConfigurationProperties("spring.datasource.postgres")
    public DataSource dataSourcePostgres(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSourceMysql());
        //配置多数据源
        Map<Object, Object> dataBaseMap = new HashMap<>(16);
        dataBaseMap.put("mysql", dataSourceMysql());
        dataBaseMap.put("oracle", dataSourceOracle());
        dataBaseMap.put("postgres", dataSourcePostgres());
        dynamicDataSource.setTargetDataSources(dataBaseMap);
        return dynamicDataSource;
    }

    @Bean(name="sqlServerSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource")DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }
    @Bean(name="sqlServerTransactionManager")//事务管理@Transactional(TransactionManager="mysqlTransactionManager")
    public PlatformTransactionManager platformTransactionManager(@Qualifier("dynamicDataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name="sqlServerSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlServerSqlSessionFactory")SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}


