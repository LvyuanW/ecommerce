package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Teacher2CourseQueryDTO {
    @Schema(description = "teacher uid")
    private String teacherUid;
}
