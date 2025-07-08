package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Orders")  // 显式绑定数据库表名
public class Order {

    @TableId
    private Integer orderId;               // 主键：订单 ID

    private Integer customerId;            // 外键：关联 Customers 表

    private String orderStatusCode;        // 订单状态代码（如：PLACED、SHIPPED、CANCELLED）

    private LocalDateTime dateOrderPlaced; // 下单时间
}