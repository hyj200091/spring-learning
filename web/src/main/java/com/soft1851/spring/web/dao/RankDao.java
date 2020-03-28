package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Rank;

import java.util.List;

/**
 * @ClassName RankDao
 * @Description TODO
 * @Author hyj
 * @Date 2020/3/27
 **/
public interface RankDao {
    /**
     * 搜索全部
     * @return list
     */
    List<Rank> selectAll();

    /**
     * 批量插入
     * @param ranks
     * @return int[]
     */
    int [] batchInsert(List<Rank> ranks);

    /**
     * 新增单个
     * @param
     * @return
     */
    int insert(Rank rank);
}
