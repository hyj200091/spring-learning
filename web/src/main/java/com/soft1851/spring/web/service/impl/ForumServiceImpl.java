package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.entity.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/3/21
 */
@Service
public class ForumServiceImpl implements ForumService {

    @Autowired
    private ForumDao forumDao;

    @Override
    public int insert(Forum forum) {
        return 0;
    }

    @Override
    public int[] batchInsert(List<Forum> forums) {
        return new int[0];
    }

    @Override
    public int delete(int forumId) {
        return forumDao.delete(forumId);
    }

    @Override
    public int update(Forum forum) {
        return 0;
    }

    @Override
    public Forum get(int forumId) {
        return forumDao.get(forumId);
    }

    @Override
    public List<Forum> selectAll() {
        return forumDao.selectAll();
    }
}
