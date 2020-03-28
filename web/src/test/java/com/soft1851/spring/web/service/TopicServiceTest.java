package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.spider.JueJinSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicServiceTest {

   @Resource
    private TopicService topicService;
    @Test
    public void queryAll() {
        System.out.println();
    }

    @Test
    public void addTopic() {
        Topic topic =   Topic.builder()
                .topicName("111")
                .description("111")
                .topicIcon("111")
                .followersCount(111)
                .msgCount(111)
                .followed(false).build();
        topicService.addTopic(topic);
    }

    @Test
    public void batchInsert() {
        int[] ints = topicService.batchInsert(JueJinSpider.getTopics());
        assertEquals(JueJinSpider.getTopics().size(),ints.length);
    }
}