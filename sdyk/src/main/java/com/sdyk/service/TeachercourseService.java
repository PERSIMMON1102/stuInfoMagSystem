package com.sdyk.service;

import com.sdyk.pojo.Checkcourse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TeachercourseService {
   List<Checkcourse> getCoursesByTeacherId(String thid);
}
