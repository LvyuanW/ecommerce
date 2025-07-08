package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.Course2StudentQueryDTO;
import com.uoa.ecommerce.dto.Student2CourseQueryDTO;
import com.uoa.ecommerce.dto.StudentCourseDTO;
import com.uoa.ecommerce.service.StudentCourseService;
import com.uoa.ecommerce.vo.StudentCourseVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-course")
@Tag(name = "StudentCourseMgmt", description = "Student-Course Relationship Management (GET/POST Only)")
public class StudentCourseController {

    @Autowired
    private StudentCourseService studentCourseService;

    @Operation(summary = "Add Student-Course Relationship")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody StudentCourseDTO dto) {
        boolean isSuccess = studentCourseService.createStudentCourse(dto);
        if (!isSuccess) {
            throw new BusinessException("Student-Course Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Student-Course Relationship via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody StudentCourseDTO dto) {
        boolean isSuccess = studentCourseService.updateStudentCourse(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Student-Course Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Student-Course Relationship via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = studentCourseService.deleteStudentCourse(uid);
        if (!isSuccess) {
            throw new BusinessException("Student-Course Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Get Courses by StudentUid")
    @GetMapping("/list-courses-by-student")
    public Result<List<StudentCourseVO>> listCoursesByStudent(@ModelAttribute Student2CourseQueryDTO query) {
        return Result.success(studentCourseService.getCourseByStudent(query));
    }

    @Operation(summary = "Get Students by CourseUid")
    @GetMapping("/list-students-by-course")
    public Result<List<StudentCourseVO>> listStudentsByCourse(@ModelAttribute Course2StudentQueryDTO query) {
        return Result.success(studentCourseService.getStudentByCourse(query));
    }
}
