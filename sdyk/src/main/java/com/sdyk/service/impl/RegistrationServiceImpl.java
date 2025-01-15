package com.sdyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyk.mapper.RegistrationMapper;
import com.sdyk.pojo.Registration;
import com.sdyk.service.RegistrationService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Resource
    private RegistrationMapper registrationMapper;

    @Override
    public PageResult findPageInfo(QueryPageBean queryPageBean) {
        LambdaQueryWrapper<Registration> wrapper = null;
        String queryString = queryPageBean.getQueryString();
        // 检查文本框中是否有要查询的信息
        if (queryString != null && !queryString.isEmpty()) {
            wrapper = new LambdaQueryWrapper<>();
            wrapper.like(Registration::getStuid, queryString);
            wrapper.or();
            wrapper.like(Registration::getCoursecode, queryString);
        }
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        Page<Registration> page = new Page<>(currentPage, pageSize);
        registrationMapper.selectPage(page, wrapper);
        return new PageResult(page.getTotal(), page.getRecords());
    }

    @Override
    public Result addCourseInfo(Registration registration) {
        // 检查课程注册是否已经存在
        LambdaQueryWrapper<Registration> checkWrapper = new LambdaQueryWrapper<>();
        checkWrapper.eq(Registration::getStuid, registration.getStuid());
        checkWrapper.eq(Registration::getCoursecode, registration.getCoursecode());
        Registration existingRegistration = registrationMapper.selectOne(checkWrapper);

        if (existingRegistration != null) {
            return new Result(false, "该学生已经注册了此课程!");
        }

        // 添加新的注册信息
        boolean flag = false;
        if (registration.getId() != null) {
            // 如果ID存在，则更新
            flag = registrationMapper.updateById(registration) > 0;
        } else {
            // 否则插入新记录
            flag = registrationMapper.insert(registration) > 0;
        }

        if (flag) {
            return new Result(true, "操作成功");
        } else {
            return new Result(false, "操作失败");
        }
    }

    @Override
    public Result findCourseByStudentId(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            return new Result(false, "学生学号无效，请提供有效的学生学号");
        }

        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getStuid, studentId);

        List<Registration> registrations = registrationMapper.selectList(wrapper);

        if (registrations != null && !registrations.isEmpty()) {
            return new Result(true, "查询成功", registrations);
        } else {
            return new Result(false, "未找到该学生的注册课程");
        }
    }

    @Override
    public Result deleteInfoById(Integer id) {
        boolean flag=registrationMapper.deleteById(id)>0;
        if(flag){
            return  new Result(flag,"删除成功");

        }else{
            return new Result(flag,"删除失败");
        }
    }
    public List<Registration> getRegistrationsByCourseCode(String coursecode) {
        return registrationMapper.getRegistrationsByCourseCode(coursecode);
    }

    public void updateRegistration(Registration registration) {
        System.out.println("Updating registration: " + registration);
        registrationMapper.updateById(registration);
    }
}