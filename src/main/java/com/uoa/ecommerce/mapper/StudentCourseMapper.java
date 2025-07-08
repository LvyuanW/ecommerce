package com.uoa.ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uoa.ecommerce.entity.StudentCourse;
import com.uoa.ecommerce.vo.StudentCourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentCourseMapper extends BaseMapper<StudentCourse> {
    // 根据班级ID查课程
    List<StudentCourseVO> getStudentByCourse(@Param("courseUid") String courseUid);

    // 根据课程ID查班级
    List<StudentCourseVO> getCourseByStudent(@Param("studentUid") String studentUid);
}
