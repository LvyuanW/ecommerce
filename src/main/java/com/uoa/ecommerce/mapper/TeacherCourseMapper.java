package com.uoa.ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uoa.ecommerce.entity.TeacherCourse;
import com.uoa.ecommerce.vo.TeacherCourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherCourseMapper extends BaseMapper<TeacherCourse> {
    List<TeacherCourseVO> getTeacherByCourse(@Param("courseUid") String courseUid);
    List<TeacherCourseVO> getCourseByTeacher(@Param("teacherUid") String teacherUid);
}
