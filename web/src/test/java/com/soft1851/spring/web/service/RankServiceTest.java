package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.spider.BiLiBiLiSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
public class RankServiceTest {
    @Resource
    private RankService rankService;

    @Test
    public void queryAll() {
        System.out.println(rankService.queryAll());
    }

    @Test
    public void addRank() {
    }

    @Test
    public void batchInsert() {
        int[] ints = rankService.batchInsert(BiLiBiLiSpider.getRanks());
        assertEquals(BiLiBiLiSpider.getRanks().size(),ints.length);
    }
}