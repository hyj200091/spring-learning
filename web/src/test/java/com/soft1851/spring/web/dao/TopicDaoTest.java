package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicDaoTest {
    @Resource
    private TopicDao topicDao;

    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }

    @Test
    public void batchInsert() {
    }

    @Test
    public void insert() {
     Topic topic = Topic.builder()
             .id("3")
             .topicName("111")
                .description("111")
                .topicIcon("111")
                .followersCount(111)
                .msgCount(111)
                .followed(false).build();
     topicDao.insert(topic);
    }
}