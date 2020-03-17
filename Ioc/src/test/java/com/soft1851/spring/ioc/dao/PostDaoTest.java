package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void insert() {
        byte[] init = {'a','b'};
        Post post = Post.builder().forumId(2).title("测试").content("测试内容").thumbnail(init).postTime(Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()))).build();
        int n = postDao.insert(post);
        System.out.println(n);
    }

    @Test
    public void batchInsert() {
        byte[] init={'a','b'};
        String time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        Post[] posts={
                Post.builder().forumId(2).title("批量1").content("批量内容1").thumbnail(init).postTime(Timestamp.valueOf(time)).build(),
                Post.builder().forumId(2).title("批量2").content("批量内容2").thumbnail(init).postTime(Timestamp.valueOf(time)).build(),
                Post.builder().forumId(2).title("批量3").content("批量内容3").thumbnail(init).postTime(Timestamp.valueOf(time)).build(),
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        assertEquals(3,rows.length);
    }

    @Test
    public void batchDelete() {
       int[] init ={1,2};
       int[] n = postDao.batchDelete(init);
        assertEquals(2,n.length);

    }

    @Test
    public void delete() {
        int init =3;
        int  n = postDao.delete(init);
        System.out.println(n);
    }

    @Test
    public void get() {
        Post post = postDao.get(4);
        System.out.println(post);
    }

    @Test
    public void selectWords() {
        String keyWords = "测试";
        System.out.println(postDao.selectWords(keyWords));
    }

    @Test
    public void countPostByForumId() {
        int n = postDao.countPostByForumId(3);
        System.out.println(n);
    }
}