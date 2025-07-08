package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.dto.Course2StudentQueryDTO;
import com.uoa.ecommerce.dto.Student2CourseQueryDTO;
import com.uoa.ecommerce.dto.StudentCourseDTO;
import com.uoa.ecommerce.entity.StudentCourse;
import com.uoa.ecommerce.vo.StudentCourseVO;

import java.util.List;

public interface StudentCourseService extends IService<StudentCourse> {
    boolean createStudentCourse(StudentCourseDTO studentCourseDTO);
    boolean updateStudentCourse(String studentCourseId, StudentCourseDTO studentCourseDTO);
    boolean deleteStudentCourse(String studentCourseId);
    List<StudentCourseVO> getStudentByCourse(Course2StudentQueryDTO query);
    List<StudentCourseVO> getCourseByStudent(Student2CourseQueryDTO query);
}
