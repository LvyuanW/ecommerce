package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("course")
public class Course implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String uid;          // UUID 唯一标识符

    @NotBlank(message = "Name Required!")
    private String name;         // 课程名称

    @NotNull(message = "Credit Required!")
    private BigDecimal credit;   // 学分

    private String remark;       // 备注

    @TableLogic // 启用逻辑删除
    private Integer isDeleted; // 0 未删除，1 已删除

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;
}
