package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wzw
 */
@Repository
public class TopicDaoImpl implements TopicDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Topic> selectAll() {
        String sql ="SELECT * FROM t_topic";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Topic.class));
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        List<Topic> topicList = topics;
        String sql = "INSERT INTO t_topic(topic_name,topic_icon,description,msg_count,followers_count,followed)"+
                "VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Topic topic = topicList.get(i);
                preparedStatement.setString(1,topic.getTopicName());
                preparedStatement.setString(2,topic.getTopicIcon());
                preparedStatement.setString(3,topic.getDescription());
                preparedStatement.setInt(4,topic.getMsgCount());
                preparedStatement.setInt(5,topic.getFollowersCount());
                preparedStatement.setBoolean(6,topic.getFollowed());
            }
            @Override
            public int getBatchSize() {return topicList.size(); }
        });
    }

    @Override
    public int insert(Topic topic) {
        String sql = "INSERT INTO t_topic(topic_name,topic_icon,description,msg_count,followers_count,followed)"+
                "VALUES(?,?,?,?,?,?)";
        Object[] args = {topic.getTopicName(),topic.getTopicIcon(),topic.getDescription(),
                topic.getMsgCount(),topic.getFollowersCount(),String.valueOf(topic.getFollowed())};
        return jdbcTemplate.update(sql,args);
    }
}
