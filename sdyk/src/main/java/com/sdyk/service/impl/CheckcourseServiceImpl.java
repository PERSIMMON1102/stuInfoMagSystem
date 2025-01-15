package com.sdyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyk.mapper.CheckcourseMapper;
import com.sdyk.pojo.Checkcourse;
import com.sdyk.service.CheckcourseService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CheckcourseServiceImpl implements CheckcourseService {

    @Resource
    private CheckcourseMapper checkcourseMapper;

    @Override
    public PageResult findPageInfo(QueryPageBean queryPageBean) {

        LambdaQueryWrapper<Checkcourse> wrapper = null;

        String queryString = queryPageBean.getQueryString();
        if (queryString != null && queryString.length() > 0) {
            wrapper = new LambdaQueryWrapper<>();
            wrapper.like(Checkcourse::getCoursecode, queryString);
            wrapper.or();
            wrapper.like(Checkcourse::getCoursename, queryString);
        }

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        Page<Checkcourse> page = new Page<>(currentPage, pageSize);
        checkcourseMapper.selectPage(page, wrapper);
        return new PageResult(page.getTotal(), page.getRecords());
    }

    //删除数据的服务
    @Override
    public Result deleteInfoById(Integer id){
        boolean flag=checkcourseMapper.deleteById(id)>0;
        if(flag){
            return  new Result(flag,"删除成功");

            }else{
            return new Result(flag,"删除失败");
        }

    }

    @Override
    public  Result addItemInfo(Checkcourse checkitem){
        boolean flag=false;
        if(checkitem.getId()!=null){
            flag=checkcourseMapper.updateById(checkitem)>0;
        }else {
            flag=checkcourseMapper.insert(checkitem)>0;
        }
        if(flag){
            return  new Result(flag,"操作成功");

        }else{
            return new Result(flag,"操作失败");
        }


    }

    @Override
    public Result getItemInfoById(Integer id) {
        Checkcourse checkitem=checkcourseMapper.selectById(id);
        return new Result(true,null,checkitem);
    }

}

