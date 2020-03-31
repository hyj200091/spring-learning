package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zw_w
 * @Date: 2020/3/31 14:22
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    /**教师管理的班级id*/
    private Integer clazzId;
    /**一对一映射关系*/
    private Clazz clazz;
}
