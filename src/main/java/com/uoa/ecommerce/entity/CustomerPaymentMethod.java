package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("Customer_Payment_Methods")  // 指定表名（防止大小写或命名冲突）
public class CustomerPaymentMethod {

    private Integer customerId;            // 外键，关联 Customers 表的 customer_id

    private String paymentMethodCode;      // 支付方式代码，例如 VISA、PAYPAL 等
}