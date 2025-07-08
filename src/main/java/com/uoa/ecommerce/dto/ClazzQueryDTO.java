package com.uoa.ecommerce.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class ClazzQueryDTO {
    @Schema(description = "clazz name", example = "M12")
    private String name;

    @Schema(description = "remark", example = "25 seats")
    private String remark;
}
