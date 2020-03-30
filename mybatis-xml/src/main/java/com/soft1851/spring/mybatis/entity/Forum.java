package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: hyj
 * @Date: 2020/3/30 19:19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {
    private Integer forumId;
    private String forumName;
}
