package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.TeacherDTO;
import com.uoa.ecommerce.dto.TeacherQueryDTO;
import com.uoa.ecommerce.entity.Teacher;
import com.uoa.ecommerce.service.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@Tag(name = "TeacherMgmt", description = "Teacher CRUD (GET/POST Only)")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Operation(summary = "Add Teacher")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody TeacherDTO dto) {
        boolean isSuccess = teacherService.createTeacher(dto);
        if (!isSuccess) {
            throw new BusinessException("Teacher Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Teacher via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody TeacherDTO dto) {
        boolean isSuccess = teacherService.updateTeacher(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Teacher Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Teacher via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = teacherService.deleteTeacher(uid);
        if (!isSuccess) {
            throw new BusinessException("Teacher Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Search Teacher via MultiParams")
    @PostMapping("/search")
    public Result<List<Teacher>> query(@RequestBody TeacherQueryDTO query) {
        return Result.success(teacherService.queryTeacher(query));
    }
}
