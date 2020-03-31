package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.vo.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: hyj
 * @Date: 2020/3/31 16:44
 * @Description:
 */
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {

    /**
     * 获取指定班课中所有学生信息
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课中所有学生信息
     * @param id int
     * @return List<Map<String,Object>>
     */
    List<Map<String,Object>> getClazzStudent1(int id);

    /**
     * 根据clazzId一对多关联查询本班所有学生
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);
}


