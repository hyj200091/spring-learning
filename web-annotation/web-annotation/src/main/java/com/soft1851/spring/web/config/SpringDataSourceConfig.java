package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: zw_w
 * @Date: 2020/3/19 8:22
 * @Configuration：用来标注本类是个配置类
 * @ComponentScan：用来扫描包
 * @PropertySource：用来读入资源目录的属性文件
 * @EnableTransactionManagement：运行事务管理器
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private  String driverClassName;
    @Value("${jdbc.url}")
    private  String jdbcUrl;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private  String password;


    /**
     * 数据连接地址池配置
     * @return
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(8);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMaxWait(60000);
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        return druidDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(druidDataSource());
    }

    /**
     * 装配事务的管理器
     * @param druidDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return  new DataSourceTransactionManager(druidDataSource);
    }

}
