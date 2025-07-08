package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class Clazz2CourseQueryDTO {
    @Schema(description = "class uid")
    private String classUid;
    //预留了未来分页模块的空间
}
