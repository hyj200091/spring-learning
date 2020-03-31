package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.vo.ClazzVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/3/31 17:05
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzMapperTest {

    @Resource
    private ClazzMapper mapper;

    @Test
    public void getClazzStudent() {
        List<ClazzVo> clazzVo = mapper.getClazzStudent(1);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void getClazzStudent1() {
        List<Map<String,Object>> clazzVo = mapper.getClazzStudent1(2);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void getClazzOneToMany() {
        Clazz clazz = mapper.getClazzOneToMany(1);
        List<Student> students = clazz.getStudents();
        students.forEach(student -> System.out.println(student.getStudentName()));
    }
}