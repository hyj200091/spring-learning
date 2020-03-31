package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/3/31 14:43
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class StudentMapperTest {
    @Resource
    private StudentMapper studentMapper;

    @Test
    public void insert() {
        Student student = Student.builder()
                .clazzId(1)
                .studentName("测试学生")
                .hometown("江苏南京")
                .birthday(LocalDate.of(2000,10,10))
                .build();
        studentMapper.insert(student);
        System.out.println(student.getStudentId());
    }

    @Test
    public void delete() {
        studentMapper.delete(3005);
    }

    @Test
    public void update() {
        Student student = studentMapper.getStudentById(3009);
        System.out.println(student);
        student.setStudentName("新名字");
        student.setHometown("上海");
        student.setBirthday(LocalDate.of(1999,11,11));
        studentMapper.update(student);
        System.out.println(studentMapper.getStudentById(3009));
    }

    @Test
    public void getStudentById() {
        System.out.println(studentMapper.getStudentById(2009));
    }

    @Test
    public void batchInsert() {
        List<Student> students = new ArrayList<>();
        for (int i=0;i<2;i++){
            Student student = Student.builder()
                    .studentId(4000+i)
                    .studentName("测试"+i)
                    .clazzId(1)
                    .hometown("测试城市")
                    .birthday(LocalDate.of(1999,01,01))
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchInsert(students));
    }

    @Test
    public void batchDelete() {
        List<Integer> idList = new ArrayList<>();
        for (int i=0;i<2;i++){
            idList.add(4000+i);
        }
        System.out.println(studentMapper.batchDelete(idList));
    }

    @Test
    public void batchUpdate() {
        List<Student> students = new ArrayList<>();
        for (int i=0;i<10;i++){
            Student student = Student.builder()
                    .studentId(4000+i)
                    .studentName("测试中"+i)
                    .clazzId(1)
                    .build();
            students.add(student);
        }
        System.out.println(studentMapper.batchUpdate(students));
    }

    @Test
    public void selectLimit() {
        System.out.println(studentMapper.selectLimit());
    }

    @Test
    public void selectLimitByDynamicSql() {
        System.out.println(studentMapper.selectLimitByDynamicSql(studentMapper.getStudentById(2008)));
    }

    @Test
    public void selectAll() {
        List<Student> students = studentMapper.selectAll();
        students.forEach(student -> System.out.println(student.getStudentName()+","+student.getBirthday()));
    }
}