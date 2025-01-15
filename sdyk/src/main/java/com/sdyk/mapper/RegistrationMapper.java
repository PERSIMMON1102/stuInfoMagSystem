package com.sdyk.mapper;

import com.sdyk.pojo.Registration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RegistrationMapper extends BaseMapper<Registration> {
    @Select("SELECT r.* FROM registration r WHERE r.coursecode = #{coursecode}")
    List<Registration> getRegistrationsByCourseCode(@Param("coursecode") String coursecode);
}
