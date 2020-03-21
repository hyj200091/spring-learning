package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/17
 */
public interface ForumDao {
    /**
     * 新增Form
     * @param forum
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增Form
     * @param forums
     * @return int[]
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Form
     * @param forumId
     * @return int
     */
    int delete(int forumId);

    /**
     * 修改Form
     * @param forum
     * @return
     */
    int update(Forum forum);

    /**
     * 根据id查询Form
     * @param forumId
     * @return Forum
     */
    Forum get(int forumId);

    /**
     * 查询所有论坛信息
     * @return List<Forum>
     */
    List<Forum> selectAll();
}
