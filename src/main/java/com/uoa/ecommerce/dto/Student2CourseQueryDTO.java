package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Student2CourseQueryDTO {
    @Schema(description = "student uid")
    private String studentUid;  // 学生 UID
}
