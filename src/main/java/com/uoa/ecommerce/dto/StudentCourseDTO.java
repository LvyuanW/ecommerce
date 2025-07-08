package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;
@Data
public class StudentCourseDTO {
    @Schema(description = "student uid")
    private String studentUid;  // 学生 UID

    @Schema(description = "course uid")
    private String courseUid;   // 课程 UID
}
