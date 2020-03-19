package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.config.SpringDataSourceConfig;
import com.soft1851.spring.orm.dao.ForumDao;
import com.soft1851.spring.orm.entity.Forum;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;



public class SpringDataSourceConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext act = new AnnotationConfigApplicationContext(SpringDataSourceConfig.class);
        //手动开启扫包
        act.scan("com.soft1851.spring.ioc.config");
        //ctx.refresh();
        JdbcTemplate jdbcTemplate = (JdbcTemplate) act.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
        ForumDao forumDao = (ForumDao) act.getBean("forumDao");
        List<Forum> forumList = forumDao.selectAll();
        System.out.println(forumList);
    }
}
