package com.sdyk.controller;


import com.sdyk.pojo.Checkitem;
import com.sdyk.service.CheckitemService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wjd
 * @since 2024-11-21
 */
@RestController  //这个类中所有的方法的返回值都会被处理为json格式数据
@RequestMapping("/checkitem")
public class CheckitemController {

    @Resource
    private CheckitemService checkitemService;

    @RequestMapping("/findPageInfo")
    public PageResult findPageInfo(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkitemService.findPageInfo(queryPageBean);
        return  pageResult;
    }

    @RequestMapping("/deleteInfoById")
    public Result deleteInfoById(Integer id){
        Result result=checkitemService.deleteInfoById(id);
        return result;
    }

    @RequestMapping("/addItemInfo")
    public Result addItemInfo(@RequestBody Checkitem checkitem){
        Result result=checkitemService.addItemInfo(checkitem);
        return result;
    }
    @RequestMapping("/getItemInfoById")
    public Result getItemInfoById(Integer id){
        Result result=checkitemService.getItemInfoById(id);
        return  result;
    }


}

