package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TeacherCourseDTO {
    @Schema(description = "teacher uid")
    private String teacherUid;

    @Schema(description = "course uid")
    private String courseUid;
}
