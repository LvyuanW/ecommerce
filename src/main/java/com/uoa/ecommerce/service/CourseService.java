package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.dto.CourseDTO;
import com.uoa.ecommerce.dto.CourseQueryDTO;
import com.uoa.ecommerce.entity.Course;

import java.util.List;

public interface CourseService extends IService<Course> {
    boolean createCourse(CourseDTO course);

    boolean updateCourse(String id, CourseDTO course);

    boolean deleteCourse(String id);

    List<Course> queryCourse(CourseQueryDTO query);
}
