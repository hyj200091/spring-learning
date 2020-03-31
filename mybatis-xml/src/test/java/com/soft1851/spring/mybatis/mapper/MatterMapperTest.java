package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.dto.MatterDto;
import com.soft1851.spring.mybatis.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Author: zw_w
 * @Date: 2020/3/31 18:37
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class MatterMapperTest {
    @Resource
    private MatterMapper matterMapper;

    @Test
    public void selectLimitFromTeacherInClassByDynamicSql() {
        MatterDto matterDto = MatterDto.builder().teacherName("许老师").clazzName("软件1851").studentName("陈").build();
        matterMapper.selectLimitFromTeacherInClassByDynamicSql(matterDto).forEach(System.out::println);
    }
}