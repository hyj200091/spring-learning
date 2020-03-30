package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Forum;

import java.util.List;

/**
 * @Author: hyj
 * @Date: 2020/3/30 19:20
 * @Description:
 */
public interface ForumService {

    /**
     * 新增实体
     * @param forum
     */
    void insert(Forum forum);

    /**
     * 根据id删除
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param forum
     */
    void update(Forum forum);

    /**
     * 查询所有
     * @return
     */
    List<Forum> selectAll();

    /**
     * 根据id查询Forum
     * @param id
     * @return Forum
     */
    Forum selectForumById(int id);
}
