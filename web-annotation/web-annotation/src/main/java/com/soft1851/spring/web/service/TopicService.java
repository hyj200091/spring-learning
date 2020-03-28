package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

/**
 * @author wzw
 */
public interface TopicService {

    /**
     * 查询所有topic
     * @return list
     */
    List<Topic> queryAll();

    /**
     * 批量插入
     * @param topics
     * @return list
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增topic
     * @param topic
     */
    void addTopic(Topic topic);
}
