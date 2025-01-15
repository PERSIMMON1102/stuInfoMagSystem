package com.sdyk.controller;


import com.sdyk.pojo.Checkitem;
import com.sdyk.pojo.Checkteacher;
import com.sdyk.service.CheckitemService;
import com.sdyk.service.CheckteacherService;
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
@RequestMapping("/checkteacher")
public class CheckteacherController {

    @Resource
    private CheckteacherService checkteacherService;

    @RequestMapping("/findPageInfo")
    public PageResult findPageInfo(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkteacherService.findPageInfo(queryPageBean);
        return  pageResult;
    }

    @RequestMapping("/deleteInfoById")
    public Result deleteInfoById(Integer id){
        Result result=checkteacherService.deleteInfoById(id);
        return result;
    }

    @RequestMapping("/addTeacherInfo")
    public Result addItemInfo(@RequestBody Checkteacher checkteacher){
        Result result=checkteacherService.addteacherInfo(checkteacher);
        return result;
    }
    @RequestMapping("/getTeacherInfoById")
    public Result getItemInfoById(Integer id){
        Result result=checkteacherService.getteacherInfoById(id);
        return  result;
    }


}

