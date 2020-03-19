package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Forum;
import java.util.List;


/**
 * @author hyj
 * @ClassName ForumDao
 * @date 2020/3/17
 */
public interface ForumDao {
    /**
     * 新增Forum
     * @param forum
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增Forum
     * @param forums
     * @return init[]
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据forumId来删除Forum
     * @param forumId
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改Forum
     * @param forum
     * @return int
     */
    int update(Forum forum);

    /**
     * 根据id来查询Forum
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛消息
     * @return list<Forum>
     */
    List<Forum> selectAll();
}
