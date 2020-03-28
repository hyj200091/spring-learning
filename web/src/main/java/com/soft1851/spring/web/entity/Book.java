package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hyj
 * @data 2020/3/24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String type;
    private String author;
    private String introduction;
}
