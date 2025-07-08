package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("teacher")
public class Teacher implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String uid;      // UUID 唯一标识符

    @NotBlank(message = "Name Required!")
    private String name;     // 教师姓名

    @NotBlank(message = "Gender Required!")
    private String gender;   // 性别（M/F）

    @NotBlank(message = "Title Required!")
    private String title;    // 职称

    private String remark;   // 备注

    @TableLogic // 启用逻辑删除
    private Integer isDeleted; // 0 未删除，1 已删除

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;
}
