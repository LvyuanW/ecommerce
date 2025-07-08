package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("Invoices")  // 显式绑定表名
public class Invoice {

    @TableId
    private Integer invoiceNumber;        // 主键：发票编号

    private String invoiceStatusCode;     // 发票状态代码（如：PAID、PENDING 等）

    private LocalDateTime invoiceDate;    // 发票日期时间
}
