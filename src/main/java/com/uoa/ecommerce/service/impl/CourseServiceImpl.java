package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.dto.CourseDTO;
import com.uoa.ecommerce.dto.CourseQueryDTO;
import com.uoa.ecommerce.entity.Course;
import com.uoa.ecommerce.mapper.CourseMapper;
import com.uoa.ecommerce.service.CourseService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Override
    public boolean createCourse(CourseDTO dto){
        Course course = new Course();
        course.setName(dto.getName());
        course.setCredit(dto.getCredit());
        course.setRemark(dto.getRemark());
        course.setIsDeleted(0);
        return this.save(course);
    }

    @Override
    public boolean updateCourse(String uid, CourseDTO dto){
        Course course = this.getById(uid);
        if(course == null || course.getIsDeleted() == 1){
            return false;
        }
        course.setName(dto.getName());
        course.setCredit(dto.getCredit());
        course.setRemark(dto.getRemark());
        return this.updateById(course);
    }

    @Override
    public boolean deleteCourse(String uid){
        return lambdaUpdate()
                .set(Course::getIsDeleted, 1)
                .set(Course::getDeletedAt, LocalDateTime.now())
                .eq(Course::getUid, uid)
                .eq(Course::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<Course> queryCourse(CourseQueryDTO query){
        QueryWrapper<Course> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(query.getName() != null, Course::getName, query.getName())
                .like(query.getCredit() != null, Course::getCredit, query.getCredit())
                .like(query.getRemark() != null, Course::getRemark, query.getRemark())
                .eq(Course::getIsDeleted, 0);
        return this.list(wrapper);
    }
}
