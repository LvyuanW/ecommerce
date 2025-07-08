package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CourseClazzDTO {

    @Schema(description = "course uid")
    private String courseUid;

    @Schema(description = "class uid")
    private String classUid;
}
