package com.uoa.ecommerce.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//此类会在实体类中的字段使用
//@TableField(fill = FieldFill.INSERT)
//注解时工作
//所以编辑器显示0个用法不代表此类可以被删除或注释
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        // 自动填充 createdAt 字段
        this.strictInsertFill(metaObject, "createdAt", LocalDateTime.class, LocalDateTime.now());
    }
//弃用
    @Override
    public void updateFill(MetaObject metaObject) {
        // 仅当 isDeleted 字段被设置为 1（代表逻辑删除）时，才填充 deletedAt
//        Object isDeleted = getFieldValByName("isDeleted", metaObject);
//        if (Integer.valueOf(1).equals(isDeleted)) {
//            this.strictUpdateFill(metaObject, "deletedAt", LocalDateTime.class, LocalDateTime.now());
        }
}
