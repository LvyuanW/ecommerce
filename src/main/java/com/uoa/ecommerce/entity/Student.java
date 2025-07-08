package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("student")
public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String uid;      // UID 唯一标识符

    @NotBlank(message = "Name Required!")
    private String name;     // 学生姓名

    @NotBlank(message = "Gender Required!")
    private String gender;   // 性别（M/F）

    @NotBlank(message = "Grade Required!")
    private String grade;    // 年级（如 2021）

    private String remark;   // 备注

    @TableLogic // 启用逻辑删除
    private Integer isDeleted; // 0 未删除，1 已删除

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

//    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime deletedAt;
}
