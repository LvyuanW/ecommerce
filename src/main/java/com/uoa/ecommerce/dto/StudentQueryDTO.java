package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class StudentQueryDTO {

    @Schema(description = "student name", example = "nick")
    private String name;

    @Schema(description = "gender（M / F）", example = "M")
    private String gender;

    @Schema(description = "grade", example = "2021")
    private String grade;

    @Schema(description = "remark", example = "good boy")
    private String remark;
}
