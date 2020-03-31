package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName CourseStudent
 * @Description TODO
 * @Author hyj
 * @Date 2020/3/31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
}