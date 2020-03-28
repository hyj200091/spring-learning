package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zw_w
 * @Date: 2020/3/26 10:06
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private String id;
    private String topicName;
    private String topicIcon;
    private String description;
    private Integer msgCount;
    private Integer followersCount;
    private Boolean followed;
}
