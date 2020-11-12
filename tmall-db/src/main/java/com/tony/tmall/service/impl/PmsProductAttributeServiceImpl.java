package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductAttributeDao;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.tony.tmall.service.PmsProductAttributeService;


@Service("pmsProductAttributeService")
public class PmsProductAttributeServiceImpl extends ServiceImpl<PmsProductAttributeDao, PmsProductAttributeEntity> implements PmsProductAttributeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductAttributeEntity> page = this.page(
                new Query<PmsProductAttributeEntity>().getPage(params),
                new QueryWrapper<PmsProductAttributeEntity>()
        );

        return new PageUtils(page);
    }

}