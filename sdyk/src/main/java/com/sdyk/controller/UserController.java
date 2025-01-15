package com.sdyk.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sdyk.mapper.UserMapper;
import com.sdyk.mapper.UserRoleMapper; // Import userRoleMapper
import com.sdyk.pojo.User;
import com.sdyk.pojo.Userrole; // Import userRole POJO类
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRoleMapper userRoleMapper; // UserRoleMapper用于查询用户角色

    @Resource
    private HttpSession httpSession;

    @RequestMapping("/login")
    public String login(String username, String password) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUname, username);
        lambdaQueryWrapper.eq(User::getUpass, password);

        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (user != null) {
            // 1. 存储用户ID到Session中
            httpSession.setAttribute("userId", user.getUid().toString());

            // 2. 查询用户角色信息
            LambdaQueryWrapper<Userrole> userRoleWrapper = new LambdaQueryWrapper<>();
            userRoleWrapper.eq(Userrole::getUid, user.getUid());
            Userrole userRole = userRoleMapper.selectOne(userRoleWrapper);

            // 3. 根据角色 ID 进行重定向
            if (userRole != null) {
                Integer roleId = userRole.getRoleid(); // 获取角色 ID
                switch (roleId) {
                    case 0: // ADMIN
                        return "redirect:/pages/admin.html"; // 管理员页面
                    case 1: // STUDENT
                        return "redirect:/pages/student.html"; // 学生页面
                    case 2: // TEACHER
                        return "redirect:/pages/teacher.html"; // 老师页面
                    default:
                        break;
                }
            }

            // 默认重定向到主页面
            return "redirect:/pages/main.html";
        } else {
            // 登录失败
            return "redirect:/index.html"; // 登录失败，重定向到登录页面
        }
    }

    @RequestMapping("/currentUser")
    @ResponseBody
    public User getCurrentUser() {
        String  userId = (String) httpSession.getAttribute("userId");
        if (userId != null) {
            return userMapper.selectById(userId); // 返回当前用户信息
        }
        return null; // 用户未登录
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public String userInfo() {
        String  userId = (String) httpSession.getAttribute("userId");
        if (userId != null) {
            User user = userMapper.selectById(userId);
            return "当前用户ID: " + userId + ", 用户名: " + user.getUname();
        }
        return "用户未登录";
    }
}