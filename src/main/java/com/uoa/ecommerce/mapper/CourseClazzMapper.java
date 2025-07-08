package com.uoa.ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uoa.ecommerce.entity.CourseClazz;
import com.uoa.ecommerce.vo.CourseClazzVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseClazzMapper extends BaseMapper<CourseClazz> {
    // 根据班级ID查课程
    List<CourseClazzVO> getCourseByClazz(@Param("classUid") String classUid);

    // 根据课程ID查班级
    List<CourseClazzVO> getClazzByCourse(@Param("courseUid") String courseUid);
}
