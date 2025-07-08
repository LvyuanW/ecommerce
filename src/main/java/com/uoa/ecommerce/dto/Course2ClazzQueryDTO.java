package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Course2ClazzQueryDTO {
    @Schema(description = "course uid")
    private String courseUid;
}
