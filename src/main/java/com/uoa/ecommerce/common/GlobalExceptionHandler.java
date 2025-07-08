package com.uoa.ecommerce.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// common/GlobalExceptionHandler.java
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public Result<?> handleBusinessException(BusinessException ex) {
        return Result.fail(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception ex) {
        return Result.fail(500, "SERVER ERROR：" + ex.getMessage());
    }

    // B. 直接放行 springdoc 的请求
//    @ExceptionHandler(Exception.class)
//    public Result<?> handleException(Exception ex, HttpServletRequest req) throws Exception {
//        if (req.getRequestURI().startsWith("/v3/api-docs")) {   // swagger 相关
//            throw ex;   // 让 springdoc 自己处理
//        }
//        return Result.fail(500, "SERVER ERROR：" + ex.getMessage());
//    }
}
