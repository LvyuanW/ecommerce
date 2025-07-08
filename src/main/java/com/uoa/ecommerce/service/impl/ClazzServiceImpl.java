package com.uoa.ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uoa.ecommerce.dto.ClazzDTO;
import com.uoa.ecommerce.dto.ClazzQueryDTO;
import com.uoa.ecommerce.entity.Clazz;
import com.uoa.ecommerce.mapper.ClazzMapper;
import com.uoa.ecommerce.service.ClazzService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {

    @Override
    public boolean createClazz(ClazzDTO dto){
        Clazz clazz = new Clazz();
        clazz.setName(dto.getName());
        clazz.setRemark(dto.getRemark());
        clazz.setIsDeleted(0);
        return this.save(clazz);
    }

    @Override
    public boolean updateClazz(String uid, ClazzDTO dto){
        Clazz clazz = this.getById(uid);
        if(clazz == null || clazz.getIsDeleted() == 1){
            return false;
        }
        clazz.setName(dto.getName());
        clazz.setRemark(dto.getRemark());
        return this.updateById(clazz);
    }

    @Override
    public boolean deleteClazz(String uid){
        return lambdaUpdate()
                .eq(Clazz::getUid, uid)
                .eq(Clazz::getIsDeleted, 0)
                .set(Clazz::getIsDeleted, 1)
                .set(Clazz::getDeletedAt, LocalDateTime.now())
                .update();
    }

    @Override
    public List<Clazz> queryClazz(ClazzQueryDTO query){
        QueryWrapper<Clazz> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .like(query.getName() != null, Clazz::getName, query.getName())
                .like(query.getRemark() != null, Clazz::getRemark, query.getRemark())
                .eq(Clazz::getIsDeleted, 0);
        return this.list(wrapper);
    }
}
