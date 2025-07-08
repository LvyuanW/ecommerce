package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.dto.TeacherDTO;
import com.uoa.ecommerce.dto.TeacherQueryDTO;
import com.uoa.ecommerce.entity.Teacher;
import com.uoa.ecommerce.mapper.TeacherMapper;
import com.uoa.ecommerce.service.TeacherService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public boolean createTeacher(TeacherDTO dto){
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setGender(dto.getGender());
        teacher.setTitle(dto.getTitle());
        teacher.setRemark(dto.getRemark());
        teacher.setIsDeleted(0);
        return this.save(teacher);
    }

    @Override
    public boolean updateTeacher(String uid, TeacherDTO dto){
        Teacher teacher = this.getById(uid);
        if(teacher == null || teacher.getIsDeleted() == 1){
            return false;
        }
        teacher.setName(dto.getName());
        teacher.setGender(dto.getGender());
        teacher.setTitle(dto.getTitle());
        teacher.setRemark(dto.getRemark());
        return this.updateById(teacher);
    }

    @Override
    public boolean deleteTeacher(String uid){
        return lambdaUpdate()
                .set(Teacher::getIsDeleted, 1)
                .set(Teacher::getDeletedAt, LocalDateTime.now())
                .eq(Teacher::getUid, uid)
                .eq(Teacher::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<Teacher> queryTeacher(TeacherQueryDTO query){
        QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(query.getGender() != null, Teacher::getGender, query.getGender())
                .like(query.getName() != null, Teacher::getName, query.getName())
                .like(query.getTitle() != null, Teacher::getTitle, query.getTitle())
                .like(query.getRemark() != null, Teacher::getRemark, query.getRemark())
                .eq(Teacher::getIsDeleted, 0);
        return this.list(wrapper);
    }
}
