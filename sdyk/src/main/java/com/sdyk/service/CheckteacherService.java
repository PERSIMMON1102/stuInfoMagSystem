package com.sdyk.service;

import com.sdyk.pojo.Checkteacher;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;

public interface CheckteacherService {
    PageResult findPageInfo(QueryPageBean queryPageBean);

    Result deleteInfoById(Integer id);

    Result addteacherInfo(Checkteacher checkteacher);

    Result getteacherInfoById(Integer id);
}
