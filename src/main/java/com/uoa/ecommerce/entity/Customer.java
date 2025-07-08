package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Customers")  // 显式指定表名，特别是在大小写敏感数据库中
public class Customer {

    @TableId
    private Integer customerId;  // 主键

    private String genderCode;   // 性别代码，如 M/F

    private String customerFirstName;      // 名

    private String customerMiddleInitial;  // 中间名首字母

    private String customerLastName;       // 姓

    private String emailAddress;           // 邮箱地址

    private String loginName;              // 登录名

    private String loginPassword;          // 登录密码（建议加密）

    private String phoneNumber;            // 电话号码

    private String addressLine1;           // 地址行 1

    private String townCity;               // 城市/城镇

    private String county;                 // 行政区/县

    private String country;                // 国家
}
