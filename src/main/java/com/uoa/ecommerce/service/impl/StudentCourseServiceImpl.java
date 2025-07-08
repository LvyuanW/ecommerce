package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.dto.Course2StudentQueryDTO;
import com.uoa.ecommerce.dto.Student2CourseQueryDTO;
import com.uoa.ecommerce.dto.StudentCourseDTO;
import com.uoa.ecommerce.entity.StudentCourse;
import com.uoa.ecommerce.mapper.StudentCourseMapper;
import com.uoa.ecommerce.service.StudentCourseService;
import com.uoa.ecommerce.vo.StudentCourseVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements StudentCourseService {

    @Override
    public boolean createStudentCourse(StudentCourseDTO dto) {
        // 判断是否已存在关联关系（未删除状态）
        boolean exists = lambdaQuery()
                .eq(StudentCourse::getStudentUid, dto.getStudentUid())
                .eq(StudentCourse::getCourseUid, dto.getCourseUid())
                .eq(StudentCourse::getIsDeleted, 0)
                .exists();

        if (exists) {
            throw new BusinessException("Student-Class Relationship Exists");
        }

        // 创建新的关联记录
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentUid(dto.getStudentUid());
        studentCourse.setCourseUid(dto.getCourseUid());
        studentCourse.setIsDeleted(0);

        return this.save(studentCourse);
    }

    @Override
    public boolean updateStudentCourse(String courseClassId, StudentCourseDTO dto) {
        StudentCourse studentCourse = this.getById(courseClassId);
        if (studentCourse == null || studentCourse.getIsDeleted() == 1) {
            return false;
        }
        studentCourse.setCourseUid(dto.getCourseUid());
        studentCourse.setStudentUid(dto.getStudentUid());
        return this.updateById(studentCourse);
    }

    @Override
    public boolean deleteStudentCourse(String courseClassId) {
        return lambdaUpdate()
                .set(StudentCourse::getIsDeleted, 1)
                .set(StudentCourse::getDeletedAt, LocalDateTime.now())
                .eq(StudentCourse::getUid, courseClassId)
                .eq(StudentCourse::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<StudentCourseVO> getCourseByStudent(Student2CourseQueryDTO query) {
        return this.baseMapper.getCourseByStudent(query.getStudentUid());
    }

    @Override
    public List<StudentCourseVO> getStudentByCourse(Course2StudentQueryDTO query) {
        return this.baseMapper.getStudentByCourse(query.getCourseUid());
    }

}
