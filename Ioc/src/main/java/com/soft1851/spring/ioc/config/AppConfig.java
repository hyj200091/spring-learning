package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author hyj
 * @date 2020/3/17
 */
@ContextConfiguration
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
