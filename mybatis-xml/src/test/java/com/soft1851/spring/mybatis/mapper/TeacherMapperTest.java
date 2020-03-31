package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/3/31 19:16
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class TeacherMapperTest {

    @Resource
    private TeacherMapper teacherMapper;

    @Test
    public void getTeacherOneToOne() {
        Teacher teacher = teacherMapper.getTeacherOneToOne(1);
        System.out.println(teacher.getClazz().getClazzName());
    }
}