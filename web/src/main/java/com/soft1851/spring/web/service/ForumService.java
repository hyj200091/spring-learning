package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/21
 */
public interface ForumService {
    /**
     * 新增Forum
     * @param forum
     * @return int
     */
    int insert(Forum forum);

    /**
     * 批量新增Forum
     * @param forums
     * @return int[]
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除Forum
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
     * 根据id查询Forum
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