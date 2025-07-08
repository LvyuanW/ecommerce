package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.StudentDTO;
import com.uoa.ecommerce.dto.StudentQueryDTO;
import com.uoa.ecommerce.entity.Student;
import com.uoa.ecommerce.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Student Management", description = "Student CRUD (GET/POST Only)")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Operation(summary = "Add Student")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody StudentDTO dto) {
        boolean isSuccess = studentService.createStudent(dto);
        if (!isSuccess) {
            throw new BusinessException("Student Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Student via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody StudentDTO dto) {
        boolean isSuccess = studentService.updateStudent(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Student Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Student via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = studentService.deleteStudent(uid);
        if (!isSuccess) {
            throw new BusinessException("Student Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Search Student via MultiParams")
    @PostMapping("/search")
    public Result<List<Student>> query(@RequestBody StudentQueryDTO query) {
        return Result.success(studentService.queryStudent(query));
    }
}