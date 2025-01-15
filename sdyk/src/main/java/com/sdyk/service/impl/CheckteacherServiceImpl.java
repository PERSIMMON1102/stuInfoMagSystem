package com.sdyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyk.mapper.CheckteacherMapper;
import com.sdyk.pojo.Checkteacher;
import com.sdyk.service.CheckteacherService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckteacherServiceImpl implements CheckteacherService {

    @Resource
    private CheckteacherMapper checkteacherMapper;

    @Override
    public PageResult findPageInfo(QueryPageBean queryPageBean) {
        LambdaQueryWrapper<Checkteacher> wrapper=null;
        String queryString=queryPageBean.getQueryString();
        //文本框中是否写了要查询的信息
        if(queryString!=null&&queryString.length()>0){
            wrapper=new LambdaQueryWrapper<>();
            wrapper.like(Checkteacher::getTehid,queryString);
            wrapper.or();
            wrapper.like(Checkteacher::getName,queryString);
        }

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        Page<Checkteacher> page = new Page<>(currentPage,pageSize);
        checkteacherMapper.selectPage(page,wrapper);
        return new PageResult(page.getTotal(),page.getRecords());
    }

    @Override
    public Result deleteInfoById(Integer id) {
        boolean flag=checkteacherMapper.deleteById(id)>0;
        if(flag){
            return new Result(flag,"删除成功");
        }else {
            return new Result(flag, "删除失败");
        }
    }

    @Override
    public Result addteacherInfo(Checkteacher checkteacher) {
        boolean flag=false;
        if(checkteacher.getId()!=null){
            flag=checkteacherMapper.updateById(checkteacher)>0;
        }
        else {
            flag = checkteacherMapper.insert(checkteacher) > 0;
        }
        if(flag){
            return new Result(flag,"操作成功");
        }else {
            return new Result(flag, "操作失败");
        }
    }

    @Override
    public Result getteacherInfoById(Integer id) {
        Checkteacher checkteacher=checkteacherMapper.selectById(id);
        return new Result(true,null,checkteacher);
    }


}
