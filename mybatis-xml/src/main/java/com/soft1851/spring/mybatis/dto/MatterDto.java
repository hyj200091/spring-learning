package com.soft1851.spring.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hyj
 * @Date: 2020/3/31 18:00
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatterDto {
    private String teacherName;
    private String clazzName;
    private String studentName;
}
