package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Post;

import java.util.List;

/**
 * @author hyj
 * @ClassName ForumDao
 * @date 2020/3/17
 */
public interface PostDao {
    /**
     * 新增Post
     * @param post
     * @return int
     */
    int insert(Post post);

    /**
     * 批量新增post
     * @param posts
     * @return int[]
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 批量删除post
     * @param postId
     * @return int[]
     */
    int[] batchDelete(int[] postId);

    /**
     * 根据id来删除post
     * @param postId
     * @return int
     */
    int delete(int postId);

    /**
     * 根据id来查询Forum
     * @param postId
     * @return Post
     */
    Post get(int postId);

    /**
     * 模糊查询post
     * @param words
     * @return List<Post></>
     */
    List<Post> selectWords(String words);

    /**
     * 根据论坛id查询改论坛拥有的帖子总数
     * @param forumId
     * @return int
     */
    int countPostByForumId(int forumId);
}
