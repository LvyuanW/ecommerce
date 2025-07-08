package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.dto.Course2TeacherQueryDTO;
import com.uoa.ecommerce.dto.Teacher2CourseQueryDTO;
import com.uoa.ecommerce.dto.TeacherCourseDTO;
import com.uoa.ecommerce.entity.TeacherCourse;
import com.uoa.ecommerce.vo.TeacherCourseVO;

import java.util.List;

public interface TeacherCourseService extends IService<TeacherCourse> {
    boolean createTeacherCourse(TeacherCourseDTO teacherCourseDTO);
    boolean updateTeacherCourse(String teacherCourseId, TeacherCourseDTO teacherCourseDTO);
    boolean deleteTeacherCourse(String teacherCourseId);
    List<TeacherCourseVO> getTeacherByCourse(Course2TeacherQueryDTO query);
    List<TeacherCourseVO> getCourseByTeacher(Teacher2CourseQueryDTO query);
}