package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.Course2TeacherQueryDTO;
import com.uoa.ecommerce.dto.Teacher2CourseQueryDTO;
import com.uoa.ecommerce.dto.TeacherCourseDTO;
import com.uoa.ecommerce.service.TeacherCourseService;
import com.uoa.ecommerce.vo.TeacherCourseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher-course")
@Tag(name = "TeacherCourseMgmt", description = "Teacher-Course Relationship Management (GET/POST Only)")
public class TeacherCourseController {

    @Autowired
    private TeacherCourseService teacherCourseService;

    @Operation(summary = "Add Teacher-Course Relationship")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody TeacherCourseDTO dto) {
        boolean isSuccess = teacherCourseService.createTeacherCourse(dto);
        if (!isSuccess) {
            throw new BusinessException("Teacher-Course Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Teacher-Course Relationship via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody TeacherCourseDTO dto) {
        boolean isSuccess = teacherCourseService.updateTeacherCourse(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Teacher-Course Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Teacher-Course Relationship via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = teacherCourseService.deleteTeacherCourse(uid);
        if (!isSuccess) {
            throw new BusinessException("Teacher-Course Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Get Courses by TeacherUid")
    @GetMapping("/list-courses-by-teacher")
    public Result<List<TeacherCourseVO>> listCoursesByTeacher(@ModelAttribute Teacher2CourseQueryDTO query) {
        return Result.success(teacherCourseService.getCourseByTeacher(query));
    }

    @Operation(summary = "Get Teachers by CourseUid")
    @GetMapping("/list-teachers-by-course")
    public Result<List<TeacherCourseVO>> listTeachersByCourse(@ModelAttribute Course2TeacherQueryDTO query) {
        return Result.success(teacherCourseService.getTeacherByCourse(query));
    }
}

