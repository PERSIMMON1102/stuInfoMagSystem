package com.sdyk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sdyk.mapper.CheckitemMapper;
import com.sdyk.pojo.Checkitem;
import com.sdyk.service.CheckitemService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CheckitemServiceImpl implements CheckitemService {

    @Resource
    private CheckitemMapper checkitemMapper;

    @Override
    public PageResult findPageInfo(QueryPageBean queryPageBean) {
        LambdaQueryWrapper<Checkitem>wrapper=null;
        String queryString=queryPageBean.getQueryString();
        //文本框中是否写了要查询的信息
        if(queryString!=null&&queryString.length()>0){
            wrapper=new LambdaQueryWrapper<>();
            wrapper.like(Checkitem::getStuid,queryString);
            wrapper.or();
            wrapper.like(Checkitem::getName,queryString);
        }

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        Page<Checkitem> page = new Page<>(currentPage,pageSize);
        checkitemMapper.selectPage(page,wrapper);
        return new PageResult(page.getTotal(),page.getRecords());
    }

    @Override
    public Result deleteInfoById(Integer id) {
        boolean flag=checkitemMapper.deleteById(id)>0;
        if(flag){
            return new Result(flag,"删除成功");
        }else {
            return new Result(flag, "删除失败");
        }
    }

    @Override
    public Result addItemInfo(Checkitem checkitem) {
        boolean flag=false;
        if(checkitem.getId()!=null){
            flag=checkitemMapper.updateById(checkitem)>0;
        }
       else {
            flag = checkitemMapper.insert(checkitem) > 0;
        }
        if(flag){
            return new Result(flag,"操作成功");
        }else {
            return new Result(flag, "操作失败");
        }
    }

    @Override
    public Result getItemInfoById(Integer id) {
        Checkitem checkitem=checkitemMapper.selectById(id);
        return new Result(true,null,checkitem);
    }


}
