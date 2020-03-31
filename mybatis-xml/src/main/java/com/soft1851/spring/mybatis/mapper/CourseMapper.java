package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @Author: hyj
 * @Date: 2020/3/31 19:38
 * @Description:
 */
public interface CourseMapper {

    /**
     * 根据班课id查询班课详情（班课自身信息、学生列表）
     * @param courseId int
     * @return Course
     */
    Course getCourseById(int courseId);
}
