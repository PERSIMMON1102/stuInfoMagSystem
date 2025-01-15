package com.sdyk.service;

import com.sdyk.pojo.Checkitem;
import com.sdyk.util.PageResult;
import com.sdyk.util.QueryPageBean;
import com.sdyk.util.Result;

public interface CheckitemService {

    PageResult findPageInfo(QueryPageBean queryPageBean);

    Result deleteInfoById(Integer id);

    Result addItemInfo(Checkitem checkitem);

    Result getItemInfoById(Integer id);
}
