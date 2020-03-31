package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.dto.MatterDto;
import com.soft1851.spring.mybatis.vo.MatterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: hyj
 * @Date: 2020/3/31 17:59
 * @Description:
 */
public interface MatterMapper {

    /**
     * 多表指定条件查询（结合动态SQL）
     * @param matterDto MatterDto
     * @return List<MatterVo>
     */
    List<MatterVo> selectLimitFromTeacherInClassByDynamicSql(@Param("matterDto") MatterDto matterDto);
}
