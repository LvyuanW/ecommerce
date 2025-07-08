package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.CourseDTO;
import com.uoa.ecommerce.dto.CourseQueryDTO;
import com.uoa.ecommerce.entity.Course;
import com.uoa.ecommerce.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@Tag(name = "CourseMgmt", description = "CourseCRUD (GET/POST Only)")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Add Course")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody CourseDTO dto) {
        boolean isSuccess = courseService.createCourse(dto);
        if (!isSuccess) {
            throw new BusinessException("Course Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Course via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody CourseDTO dto) {
        boolean isSuccess = courseService.updateCourse(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Course Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Course via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = courseService.deleteCourse(uid);
        if (!isSuccess) {
            throw new BusinessException("Course Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Search Course via MultiParams")
    @PostMapping("/search")
    public Result<List<Course>> query(@RequestBody CourseQueryDTO query) {
        return Result.success(courseService.queryCourse(query));
    }
}
