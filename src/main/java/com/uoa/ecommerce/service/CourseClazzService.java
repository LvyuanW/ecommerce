package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.dto.Clazz2CourseQueryDTO;
import com.uoa.ecommerce.dto.Course2ClazzQueryDTO;
import com.uoa.ecommerce.dto.CourseClazzDTO;
import com.uoa.ecommerce.entity.CourseClazz;
import com.uoa.ecommerce.vo.CourseClazzVO;

import java.util.List;

public interface CourseClazzService extends IService<CourseClazz> {
    boolean createCourseClazz(CourseClazzDTO courseClazzDTO);
    boolean updateCourseClazz(String courseClassId, CourseClazzDTO courseClazzDTO);
    boolean deleteCourseClazz(String courseClassId);
    List<CourseClazzVO> getCourseByClazz(Clazz2CourseQueryDTO query);
    List<CourseClazzVO> getClazzByCourse(Course2ClazzQueryDTO query);
}
