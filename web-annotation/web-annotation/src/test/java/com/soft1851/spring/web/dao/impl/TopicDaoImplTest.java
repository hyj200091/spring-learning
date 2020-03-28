package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/3/26 10:16
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
//WebAppConfiguration逐季雷默认为webapp目录，需要切换到src/main/resources目录
@WebAppConfiguration("src/main/resources")
public class TopicDaoImplTest {
    @Autowired
    private TopicDao topicDao;
    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }

    @Test
    public void batchInsert() {
        Topic topic1 = new Topic().builder()
                .followed(true)
                .followersCount(15)
                .msgCount(14)
                .description("test")
                .topicIcon("test")
                .topicName("test")
                .build();
        Topic topic2 = new Topic().builder()
                .followed(true)
                .followersCount(15)
                .msgCount(14)
                .description("test")
                .topicIcon("test")
                .topicName("test")
                .build();
        List<Topic> topicList = new ArrayList<>();
        topicList.add(topic1);
        topicList.add(topic2);
        System.out.println(topicDao.batchInsert(topicList));
    }

    @Test
    public void insert() {
        Topic topic = new Topic().builder()
                .followed(true)
                .followersCount(15)
                .msgCount(14)
                .description("test")
                .topicIcon("test")
                .topicName("test")
                .build();
        System.out.println(topicDao.insert(topic));
    }
}