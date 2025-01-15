package com.sdyk.mapper;

import com.sdyk.pojo.Checkcourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sdyk.pojo.Teachercourse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wjd
 * @since 2024-11-21
 */
@Mapper
public interface TeachercourseMapper extends BaseMapper<Teachercourse> {
    @Select("SELECT cc.* FROM teachercourse tc LEFT JOIN checkcourse cc ON tc.courseid = cc.coursecode WHERE tc.thid = #{thid}")
    List<Checkcourse> getCoursesByTeacherId(@Param("thid") String thid);
}
