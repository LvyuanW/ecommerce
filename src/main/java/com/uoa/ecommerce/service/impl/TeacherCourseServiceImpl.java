package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.dto.Course2TeacherQueryDTO;
import com.uoa.ecommerce.dto.Teacher2CourseQueryDTO;
import com.uoa.ecommerce.dto.TeacherCourseDTO;
import com.uoa.ecommerce.entity.TeacherCourse;
import com.uoa.ecommerce.mapper.TeacherCourseMapper;
import com.uoa.ecommerce.service.TeacherCourseService;
import com.uoa.ecommerce.vo.TeacherCourseVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherCourseServiceImpl extends ServiceImpl<TeacherCourseMapper, TeacherCourse> implements TeacherCourseService {

    @Override
    public boolean createTeacherCourse(TeacherCourseDTO dto) {
        boolean exists = lambdaQuery()
                .eq(TeacherCourse::getTeacherUid, dto.getTeacherUid())
                .eq(TeacherCourse::getCourseUid, dto.getCourseUid())
                .eq(TeacherCourse::getIsDeleted, 0)
                .exists();

        if (exists) {
            throw new BusinessException("Teacher-Course Relationship Exists");
        }

        TeacherCourse teacherCourse = new TeacherCourse();
        teacherCourse.setTeacherUid(dto.getTeacherUid());
        teacherCourse.setCourseUid(dto.getCourseUid());
        teacherCourse.setIsDeleted(0);

        return this.save(teacherCourse);
    }

    @Override
    public boolean updateTeacherCourse(String teacherCourseId, TeacherCourseDTO dto) {
        TeacherCourse teacherCourse = this.getById(teacherCourseId);
        if (teacherCourse == null || teacherCourse.getIsDeleted() == 1) {
            return false;
        }
        teacherCourse.setCourseUid(dto.getCourseUid());
        teacherCourse.setTeacherUid(dto.getTeacherUid());
        return this.updateById(teacherCourse);
    }

    @Override
    public boolean deleteTeacherCourse(String teacherCourseId) {
        return lambdaUpdate()
                .set(TeacherCourse::getIsDeleted, 1)
                .set(TeacherCourse::getDeletedAt, LocalDateTime.now())
                .eq(TeacherCourse::getUid, teacherCourseId)
                .eq(TeacherCourse::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<TeacherCourseVO> getCourseByTeacher(Teacher2CourseQueryDTO query) {
        return this.baseMapper.getCourseByTeacher(query.getTeacherUid());
    }

    @Override
    public List<TeacherCourseVO> getTeacherByCourse(Course2TeacherQueryDTO query) {
        return this.baseMapper.getTeacherByCourse(query.getCourseUid());
    }
}
