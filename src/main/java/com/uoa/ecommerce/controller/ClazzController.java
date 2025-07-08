package com.uoa.ecommerce.controller;

import com.uoa.ecommerce.common.BusinessException;
import com.uoa.ecommerce.common.Result;
import com.uoa.ecommerce.dto.ClazzDTO;
import com.uoa.ecommerce.dto.ClazzQueryDTO;
import com.uoa.ecommerce.entity.Clazz;
import com.uoa.ecommerce.service.ClazzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clazzes")
@Tag(name = "ClazzMgmt", description = "ClazzCRUD (GET/POST Only)")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @Operation(summary = "Add Clazz")
    @PostMapping("/add")
    public Result<Boolean> create(@Valid @RequestBody ClazzDTO dto) {
        boolean isSuccess = clazzService.createClazz(dto);
        if (!isSuccess) {
            throw new BusinessException("Class Add Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Update Clazz via Uid (POST instead of PUT)")
    @PostMapping("/update")
    public Result<Boolean> update(@RequestParam String uid, @RequestBody ClazzDTO dto) {
        boolean isSuccess = clazzService.updateClazz(uid, dto);
        if (!isSuccess) {
            throw new BusinessException("Class Update Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Delete Clazz via Uid (POST instead of DELETE)")
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestParam String uid) {
        boolean isSuccess = clazzService.deleteClazz(uid);
        if (!isSuccess) {
            throw new BusinessException("Class Delete Failed");
        }
        return Result.success(true);
    }

    @Operation(summary = "Search Clazz via MultiParams")
    @PostMapping("/search")
    public Result<List<Clazz>> query(@RequestBody ClazzQueryDTO query) {
        return Result.success(clazzService.queryClazz(query));
    }
}

