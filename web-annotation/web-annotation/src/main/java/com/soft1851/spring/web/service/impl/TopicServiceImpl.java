package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzw
 * @date 2020/3/27
 * @deprecated @Transactional(rollbackFor = Exception.class)如果类加了这个注释，那么
 * 这个类方法里面的方法抛出异常 就会回滚 数据库里面的数据也会回滚
 */
@Service
//@Transactional()
public class TopicServiceImpl implements TopicService {
    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return  topicDao.batchInsert(topics);
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
//        int a = 1 / 0;
    }
}
