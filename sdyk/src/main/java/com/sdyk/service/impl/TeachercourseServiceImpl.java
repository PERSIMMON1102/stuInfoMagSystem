package com.sdyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdyk.mapper.TeachercourseMapper;
import com.sdyk.pojo.Checkcourse;
import com.sdyk.pojo.Teachercourse;
import com.sdyk.service.TeachercourseService;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class TeachercourseServiceImpl implements TeachercourseService {

    @Resource
    private TeachercourseMapper teachercourseMapper;

    @Override
    public List<Checkcourse> getCoursesByTeacherId(String thid) {
        return teachercourseMapper.getCoursesByTeacherId(thid);
    }


}
