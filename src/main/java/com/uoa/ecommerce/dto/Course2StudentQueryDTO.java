package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Course2StudentQueryDTO {
    @Schema(description = "course uid")
    private String courseUid;   // 课程 UID
}
