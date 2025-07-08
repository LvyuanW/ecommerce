package com.uoa.ecommerce.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("Products")  // 指定表名，大小写敏感时必须加
public class Product {

    @TableId
    private Integer productId;              // 主键

    private Integer parentProductId;        // 父产品 ID（可为空）

    private String productName;             // 产品名称

    private BigDecimal productPrice;        // 产品价格（推荐使用 BigDecimal）

    private String productColor;            // 产品颜色

    private String productSize;             // 产品尺寸

    private String productDescription;      // 产品描述
}