package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.entity.Student;
import com.uoa.ecommerce.dto.StudentDTO;
import com.uoa.ecommerce.dto.StudentQueryDTO;

import java.util.List;

public interface StudentService extends IService<Student> {
    boolean createStudent(StudentDTO dto);

    boolean updateStudent(String uid, StudentDTO dto);

    boolean deleteStudent(String uid);

    List<Student> queryStudent(StudentQueryDTO query);
}
