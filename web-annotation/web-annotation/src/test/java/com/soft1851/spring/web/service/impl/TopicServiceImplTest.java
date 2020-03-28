package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zw_w
 * @Date: 2020/3/27 16:11
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
//WebAppConfiguration逐季雷默认为webapp目录，需要切换到src/main/resources目录
@WebAppConfiguration("src/main/resources")
public class TopicServiceImplTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void queryAll() {
        System.out.println(topicService.queryAll());
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
        System.out.println(topicService.batchInsert(topicList));
    }

    @Test
    public void addTopic() {
        Topic topic = new Topic().builder()
                .followed(true)
                .followersCount(15)
                .msgCount(14)
                .description("test")
                .topicIcon("test")
                .topicName("test")
                .build();
        topicService.addTopic(topic);
    }
}