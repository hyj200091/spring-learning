package com.soft1851.spring.mybatis.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: hyj
 * @Date: 2020/3/31 16:40
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClazzVo {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    private Integer studentId;
    private String studentName;
    private String homeTown;
    private LocalDate birthday;
}
