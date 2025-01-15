package com.sdyk.service.impl;

import com.sdyk.mapper.UserMapper;
import com.sdyk.pojo.User;
import com.sdyk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getCurrentUser(String userId) {
        return userMapper.selectById(userId);
    }
}
