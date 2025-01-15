package com.sdyk.service;

import com.sdyk.pojo.Registration;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;

import java.util.List;

public interface RegistrationService {
    PageResult findPageInfo(QueryPageBean queryPageBean);

    Result addCourseInfo(Registration registration);

    Result findCourseByStudentId(String studentId);

    Result deleteInfoById(Integer id);

    List<Registration> getRegistrationsByCourseCode(String coursecode);

    void updateRegistration(Registration registration) ;

}
