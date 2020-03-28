package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

/**
 * @aurthor hyj
 * @date 2020/3/28
 * @deprecated 云班课数据爬虫
 */
public class Subject {
    private String classImg;
    private String authorImg;
    private String authorName;
    private String subjectName;
    private String className;
}
