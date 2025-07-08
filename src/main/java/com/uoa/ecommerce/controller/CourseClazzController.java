package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.Clazz2CourseQueryDTO;
import com.uoa.ecommerce.dto.Course2ClazzQueryDTO;
import com.uoa.ecommerce.dto.CourseClazzDTO;
import com.uoa.ecommerce.service.CourseClazzService;
import com.uoa.ecommerce.vo.CourseClazzVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-clazz")
@Tag(name = "CourseClazzMgmt", description = "Course-Class Relationship Management (GET/POST only)")
public class CourseClazzController {

    @Autowired
    private CourseClazzService courseClazzService;

    @Operation(summary = "Add Course-Class Relationship")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody CourseClazzDTO dto) {
        boolean isSuccess = courseClazzService.createCourseClazz(dto);
        if (!isSuccess) {
            throw new BusinessException("Course-Class Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Course-Class Relationship via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody CourseClazzDTO dto) {
        boolean isSuccess = courseClazzService.updateCourseClazz(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Course-Class Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Course-Class Relationship via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = courseClazzService.deleteCourseClazz(uid);
        if (!isSuccess) {
            throw new BusinessException("Course-Class Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Get Courses by ClassUid")
    @GetMapping("/list-courses-by-class")
    public Result<List<CourseClazzVO>> listCoursesByClass(@ModelAttribute Clazz2CourseQueryDTO query) {
        return Result.success(courseClazzService.getCourseByClazz(query));
    }

    @Operation(summary = "Get Classes by CourseUid")
    @GetMapping("/list-classes-by-course")
    public Result<List<CourseClazzVO>> listClassesByCourse(@ModelAttribute Course2ClazzQueryDTO query) {
        return Result.success(courseClazzService.getClazzByCourse(query));
    }
}
