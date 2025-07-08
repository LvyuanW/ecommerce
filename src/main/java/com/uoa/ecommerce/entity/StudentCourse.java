package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("student_course")
public class StudentCourse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.ASSIGN_ID)
    private String uid;      // UID 唯一标识符

    @NotBlank(message = "Student Uid Required!")
    private String studentUid;  // 学生 UID

    @NotBlank(message = "Course Uid Required!")
    private String courseUid;   // 课程 UID

    @TableLogic // 启用逻辑删除
    private Integer isDeleted; // 0 未删除，1 已删除

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;
}
