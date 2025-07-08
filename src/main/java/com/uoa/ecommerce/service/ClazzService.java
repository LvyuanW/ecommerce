package com.uoa.ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uoa.ecommerce.dto.ClazzDTO;
import com.uoa.ecommerce.dto.ClazzQueryDTO;
import com.uoa.ecommerce.entity.Clazz;

import java.util.List;

public interface ClazzService extends IService<Clazz> {
    boolean createClazz(ClazzDTO clazz);

    boolean updateClazz(String id, ClazzDTO clazz);

    boolean deleteClazz(String id);

    List<Clazz> queryClazz(ClazzQueryDTO query);
}
