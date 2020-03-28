package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Rank
 * @Description TODO
 * @Author hyj
 * @Date 2020/3/27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rank {
    private  Integer id;
    private  String title;
    private  String author;
    private  String pic;
    private  String duration;

}