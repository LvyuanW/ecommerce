package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TeacherQueryDTO {

    @Schema(description = "Teacher Name", example = "nick")
    private String name;

    @Schema(description = "gender（M / F）", example = "M")
    private String gender;

    @Schema(description = "title", example = "Professor")
    private String title;

    @Schema(description = "remark", example = "good boy")
    private String remark;
}
