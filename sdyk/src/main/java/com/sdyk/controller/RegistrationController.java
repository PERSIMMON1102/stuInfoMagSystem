package com.sdyk.controller;

import com.sdyk.pojo.Checkcourse;
import com.sdyk.pojo.Registration;
import com.sdyk.service.RegistrationService;
import com.sdyk.service.TeachercourseService;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    @Resource
    private TeachercourseService teachercourseService;
    @Resource
    private RegistrationService registrationService;

    @RequestMapping("/findPageInfo")
    public PageResult findPageInfo(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult=registrationService.findPageInfo(queryPageBean);
        return pageResult;
    }

    @RequestMapping("/deleteInfoById")
    public Result deleteInfoById(Integer id){
        Result result=registrationService.deleteInfoById(id);
        return result;
    }

    @PostMapping("/addCourseInfo")
    public Result addCourseInfo(@RequestBody Registration registration) {
        if (registration == null || registration.getStuid() == null || registration.getStuid().isEmpty() || registration.getCoursecode() == null) {
            return Result.error("选课信息无效，请提供有效的学生学号和课程代码");
        }

        Result result = registrationService.addCourseInfo(registration);

        // 判断结果并返回相应提示信息
        if (result.isFlag()) {
            return Result.success("选课成功!");
        } else {
            return Result.error("选课失败: " + result.getMessage());
        }
    }

    /**
     * 根据学生学号获取该学生的所有选课信息
     * @param stuid 学生学号
     * @return Result 返回该学生的课程信息
     */
    @GetMapping("/courses/{stuid}")
    public Result getCoursesByStudentId(@PathVariable String stuid) {
        if (stuid == null || stuid.isEmpty()) {
            return Result.error("学生学号无效，请提供有效的学生学号");
        }
        return registrationService.findCourseByStudentId(stuid);
    }

    @GetMapping("/teacher/courses")
    public List<Checkcourse> getTeacherCourses(@RequestParam String thid) {
        return teachercourseService.getCoursesByTeacherId(thid);
    }

    @GetMapping("/byCourse/{coursecode}")
    public List<Registration> getRegistrationsByCourseCode(@PathVariable String coursecode) {
        return registrationService.getRegistrationsByCourseCode(coursecode);
    }

    @PutMapping("/update")
    public Result updateRegistration(@RequestBody Registration registration) {
        if (registration == null || registration.getStuid() == null || registration.getCoursecode() == null) {
            return new Result(false, "请求参数无效");
        }
        registrationService.updateRegistration(registration);
        return new Result(true, "更新成功");
    }
}
