package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.dto.Clazz2CourseQueryDTO;
import com.uoa.ecommerce.dto.Course2ClazzQueryDTO;
import com.uoa.ecommerce.dto.CourseClazzDTO;
import com.uoa.ecommerce.entity.CourseClazz;
import com.uoa.ecommerce.mapper.CourseClazzMapper;
import com.uoa.ecommerce.service.CourseClazzService;
import com.uoa.ecommerce.vo.CourseClazzVO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseClazzServiceImpl extends ServiceImpl<CourseClazzMapper, CourseClazz> implements CourseClazzService {

    @Override
    public boolean createCourseClazz(CourseClazzDTO dto) {
        boolean exists = lambdaQuery()
                .eq(CourseClazz::getCourseUid, dto.getCourseUid())
                .eq(CourseClazz::getClassUid, dto.getClassUid())
                .eq(CourseClazz::getIsDeleted, 0)
                .exists();

        if (exists) {
            throw new BusinessException("Course-Class Relationship Exists");
        }

        CourseClazz courseClazz = new CourseClazz();
        courseClazz.setCourseUid(dto.getCourseUid());
        courseClazz.setClassUid(dto.getClassUid());
        courseClazz.setIsDeleted(0);
        return this.save(courseClazz);
    }

    @Override
    public boolean updateCourseClazz(String courseClassId, CourseClazzDTO dto) {
        CourseClazz courseClazz = this.getById(courseClassId);
        if (courseClazz == null || courseClazz.getIsDeleted() == 1) {
            return false;
        }
        courseClazz.setClassUid(dto.getClassUid());
        courseClazz.setCourseUid(dto.getCourseUid());
        return this.updateById(courseClazz);
    }

    @Override
    public boolean deleteCourseClazz(String courseClassId) {
        return lambdaUpdate()
                .set(CourseClazz::getIsDeleted, 1)
                .set(CourseClazz::getDeletedAt, LocalDateTime.now())
                .eq(CourseClazz::getUid, courseClassId)
                .eq(CourseClazz::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<CourseClazzVO> getClazzByCourse(Course2ClazzQueryDTO query) {
        return this.baseMapper.getClazzByCourse(query.getCourseUid());
    }

    @Override
    public List<CourseClazzVO> getCourseByClazz(Clazz2CourseQueryDTO query) {
        return this.baseMapper.getCourseByClazz(query.getClassUid());
    }
}
