-- 学生表 | Student Table
CREATE TABLE student
(
    uid        CHAR(36)    NOT NULL PRIMARY KEY COMMENT '唯一标识符（UUID）| Unique identifier (UUID)',
    name       VARCHAR(50) NOT NULL COMMENT '学生姓名 | Student name',
    gender     ENUM('M','F') COMMENT '性别（M男 / F女）| Gender (M=Male, F=Female)',
    grade      VARCHAR(20) COMMENT '年级 | Grade (e.g., 2021, Junior)',
    remark     VARCHAR(255) COMMENT '备注信息 | Remarks',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生信息表 | Student information table';

-- 教师表 | Teacher Table
CREATE TABLE teacher
(
    uid        CHAR(36)    NOT NULL PRIMARY KEY COMMENT '唯一标识符（UUID）| Unique identifier (UUID)',
    name       VARCHAR(50) NOT NULL COMMENT '教师姓名 | Teacher name',
    gender     ENUM('M','F') COMMENT '性别（M男 / F女）| Gender (M=Male, F=Female)',
    title      VARCHAR(50) COMMENT '职称 | Professional title',
    remark     VARCHAR(255) COMMENT '备注信息 | Remarks',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师信息表 | Teacher information table';

-- 课程表 | Course Table
CREATE TABLE course
(
    uid        CHAR(36)     NOT NULL PRIMARY KEY COMMENT '唯一标识符（UUID）| Unique identifier (UUID)',
    name       VARCHAR(100) NOT NULL COMMENT '课程名称 | Course name',
    credit     DECIMAL(4, 1) COMMENT '学分 | Credit',
    remark     VARCHAR(255) COMMENT '备注信息 | Remarks',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程信息表 | Course information table';

-- 班级表 | Class Table
CREATE TABLE class
(
    uid        CHAR(36)    NOT NULL PRIMARY KEY COMMENT '唯一标识符（UUID）| Unique identifier (UUID)',
    name       VARCHAR(50) NOT NULL COMMENT '班级名称 / 教室名 / 授课单元 | Class name or teaching unit',
    remark     VARCHAR(255) COMMENT '备注信息 | Remarks',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='授课班级/教室表（非入学班级）| Class table for teaching units (not enrollment groups)';


-- 学生-课程关联表 | Student-Course Mapping Table
CREATE TABLE student_course
(
    uid         CHAR(36) NOT NULL PRIMARY KEY COMMENT '唯一标识符 | Unique ID',
    student_uid CHAR(36) NOT NULL COMMENT '学生 UID | Student UID',
    course_uid  CHAR(36) NOT NULL COMMENT '课程 UID | Course UID',
    is_deleted  TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生与课程的多对多关系 | Many-to-many relation between students and courses';


-- 教师-课程关联表 | Teacher-Course Mapping Table
CREATE TABLE teacher_course
(
    uid         CHAR(36) NOT NULL PRIMARY KEY COMMENT '唯一标识符 | Unique ID',
    teacher_uid CHAR(36) NOT NULL COMMENT '教师 UID | Teacher UID',
    course_uid  CHAR(36) NOT NULL COMMENT '课程 UID | Course UID',
    is_deleted  TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教师与课程的多对多关系 | Many-to-many relation between teachers and courses';

-- 课程-班级关联表 | Course-Class Mapping Table
CREATE TABLE course_class
(
    uid        CHAR(36) NOT NULL PRIMARY KEY COMMENT '唯一标识符 | Unique ID',
    course_uid CHAR(36) NOT NULL COMMENT '课程 UID | Course UID',
    class_uid  CHAR(36) NOT NULL COMMENT '班级 UID | Class UID',
    is_deleted TINYINT(1) DEFAULT 0 COMMENT '是否被删除（0=未删除，1=已删除）| Logical deletion flag (0=active, 1=deleted)',
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录创建时间 | Record creation timestamp',
    deleted_at DATETIME DEFAULT NULL COMMENT '逻辑删除时间（仅逻辑删除时填写）| Logical deletion timestamp (only set when logically deleted)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='课程与班级的多对多关系 | Many-to-many relation between courses and classes';

