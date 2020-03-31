package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: hyj
 * @Date: 2020/3/31 14:36
 * @Description:
 */
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     * 新增student，并返回自增主键
     * @param student Student
     */
    void insert(Student student);

    /**
     * 根据studentId删除Student
     * @param studentId int
     */
    void delete(int studentId);

    /**
     * 更新student
     * @param student Student
     */
    void update(Student student);

    /**
     * 根据studentId查询Student
     * @param studentId int
     * @return Student
     */
    Student getStudentById(int studentId);

    /**
     * 批量插入
     * @param students List<Student>
     * @return int
     */
    int batchInsert(@Param("students")List<Student> students);

    /**
     * 批量删除
     * @param idList List<Integer>
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 批量修改
     * @param students List<Student>
     * @return int
     */
    int batchUpdate(@Param("students") List<Student> students);

    /**
     * 单表（带两个指定条件）查询
     * @return List<Student>
     */
    List<Student> selectLimit();

    /**
     * 单表指定条件查询（结合动态SQL）
     * @param student List<Student>
     * @return List<Student>
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询所有学生，按生日排序，多对一查询所有学生所在班级信息
     * @return List<Student>
     */
    List<Student> selectAll();
}
