package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CourseQueryDTO {
    @Schema(description = "course name", example = "java")
    private String name;

    @Schema(description = "course credit", example = "3")
    private BigDecimal credit;

    @Schema(description = "remark", example = "core")
    private String remark;
}