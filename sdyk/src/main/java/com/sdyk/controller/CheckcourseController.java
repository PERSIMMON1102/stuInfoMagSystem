package com.sdyk.controller;


import com.sdyk.pojo.Checkcourse;
import com.sdyk.service.CheckcourseService;
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
@RestController
@RequestMapping("/checkitem1")
public class CheckcourseController {
    @Resource
    private CheckcourseService checkitemService;

    @RequestMapping("/findPageInfo")
    public PageResult findPageInfo(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult=checkitemService.findPageInfo(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/deleteInfoById")
    public Result deleteInfoById(Integer id){
        Result result=checkitemService.deleteInfoById(id);
        return result;
    }

    @RequestMapping("/addItemInfo")
    public Result addItemInfo(@RequestBody Checkcourse checkitem){
        Result result=checkitemService.addItemInfo(checkitem);
        return  result;
    }

    @RequestMapping("/getItemInfoById")
    public Result getItemInfoById(Integer id){
        Result result= checkitemService.getItemInfoById(id);
        return  result;
    }

}

