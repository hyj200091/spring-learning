package com.soft1851.spring.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hyj
 * @Date: 2020/3/31 17:55
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatterVo {
    private String teacherName;
    private String clazzName;
    private String studentName;
    private String hometown;
    private String birthday;
}
