package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.entity.Student;
import com.uoa.ecommerce.dto.StudentDTO;
import com.uoa.ecommerce.dto.StudentQueryDTO;
import com.uoa.ecommerce.mapper.StudentMapper;
import com.uoa.ecommerce.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public boolean createStudent(StudentDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setGender(dto.getGender());
        student.setGrade(dto.getGrade());
        student.setRemark(dto.getRemark());
        student.setIsDeleted(0);
        return this.save(student);
    }

    @Override
    public boolean updateStudent(String uid, StudentDTO dto) {
        Student student = this.getById(uid);
        if (student == null || student.getIsDeleted() == 1) {
            return false;
        }
        student.setName(dto.getName());
        student.setGender(dto.getGender());
        student.setGrade(dto.getGrade());
        student.setRemark(dto.getRemark());
        return this.updateById(student);
    }

    @Override
    public boolean deleteStudent(String uid) {
        //第一次编辑
//        Student student = this.getById(uid);
//        if (student == null || student.getIsDeleted() == 1) {
//            return false;
//        }
//        student.setIsDeleted(1);
//        student.setDeletedAt(LocalDateTime.now());
//        return this.updateById(student);
//以上删除逻辑由于通过update完成，会触发po中的@TableLogic注解
//即，在数据表记录被更新后，这个注解会自动将is_deleted又设置回0
//所以使用框架自带的删除方法
//并且使用MetaObjectHandler在po中自动填充deleted_at字段
        //第二次编辑
//        return this.removeById(uid);
//这一次is_deleted成功更新，但是deleted_at为空
//deleted_at 之所以还是 null，并不是注解写错，而是 MetaObjectHandler#updateFill 在逻辑删除里根本不会被调用。
//removeById / deleteById 的实现走的是 SqlInjector 注入的 LogicDeleteById 语句，
//它只给目标字段（is_deleted）赋值，并不会把整条 entity 交给填充器，
//所以 MyMetaObjectHandler 永远进不来。这在官方 Issue #2802 里已经确认过了
        //改用 lambdaUpdate()，手动填充删除时间
        return lambdaUpdate()
                .set(Student::getIsDeleted, 1)
                .set(Student::getDeletedAt, LocalDateTime.now())
                .eq(Student::getUid, uid)
                .eq(Student::getIsDeleted, 0)
                .update();
    }

    @Override
    public List<Student> queryStudent(StudentQueryDTO query) {
        QueryWrapper<Student> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(query.getGender() != null, Student::getGender, query.getGender())
                .like(query.getName() != null, Student::getName, query.getName())
                .like(query.getRemark() != null, Student::getRemark, query.getRemark())
                .like(query.getGrade() != null, Student::getGrade, query.getGrade())
                .eq(Student::getIsDeleted, 0);
        return this.list(wrapper);
    }
}
