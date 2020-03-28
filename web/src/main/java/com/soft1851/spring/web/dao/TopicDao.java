package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Topic;

import java.util.List;

public interface TopicDao {
    /**
     * 查询所有
     * @return list
     */
    List<Topic> selectAll();

    /**
     * 批量插入
     */
    int[] batchInsert(List<Topic> topics);

    /**
     * 新增
     * @param topic
     * @return int
     */
    int insert(Topic topic);
}
