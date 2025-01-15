package com.sdyk.service;

import com.sdyk.pojo.Checkcourse;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;

public interface CheckcourseService {
    PageResult findPageInfo(QueryPageBean queryPageBean);

    Result deleteInfoById(Integer id);

    Result addItemInfo(Checkcourse checkitem);

    Result getItemInfoById(Integer id);
}
