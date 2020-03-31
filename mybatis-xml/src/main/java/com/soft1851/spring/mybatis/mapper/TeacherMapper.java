package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @Author: hyj
 * @Date: 2020/3/31 19:09
 * @Description:
 */
public interface TeacherMapper {
    /**
     * 根据teacherId一对一关联查询其管理的班级信息
     * @param teacherId int
     * @return Teacher
     */
    Teacher getTeacherOneToOne(int teacherId);
}
