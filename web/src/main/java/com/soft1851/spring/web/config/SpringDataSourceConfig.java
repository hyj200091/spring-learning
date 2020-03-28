package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author: hyj
 * @Date: 2020/3/19 8:22
 * @Configuration：用来标注本类是个配置类
 * @ComponentScan：用来扫描包
 * @PropertySource：用来读入资源目录的属性文件
 * @EnableTransactionManagement：运行事务管理器
 */
@Configuration
@ComponentScan("com.soft1851.spring.web")
@PropertySource("classpath:/jdbc.properties")
@EnableTransactionManagement
public class SpringDataSourceConfig {
   /**
    * 数据连接池地址配置
    * @return druidDataSource
    */
   @Bean
   public DruidDataSource druidDataSource(){
      DruidDataSource druidDataSource = new  DruidDataSource();
      druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
      druidDataSource.setUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
      druidDataSource.setUsername("root");
      druidDataSource.setPassword("root");
      druidDataSource.setInitialSize(8);
      druidDataSource.setMinIdle(1);
      druidDataSource.setMaxActive(20);
      druidDataSource.setMaxWait(60000);
      druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
      druidDataSource.setMinEvictableIdleTimeMillis(300000);
      return druidDataSource;
   }
   @Bean
   public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
      return new   JdbcTemplate(druidDataSource);
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
