package com.uoa.ecommerce.service;

import com.uoa.ecommerce.dto.TeacherDTO;
import com.uoa.ecommerce.dto.TeacherQueryDTO;
import com.uoa.ecommerce.entity.Teacher;

import java.util.List;

public interface TeacherService {
    boolean createTeacher(TeacherDTO dto);

    boolean updateTeacher(String uid, TeacherDTO dto);

    boolean deleteTeacher(String uid);

    List<Teacher> queryTeacher(TeacherQueryDTO query);
}
