package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductAttributeCategoryDao;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.service.PmsProductAttributeCategoryService;


@Service("pmsProductAttributeCategoryService")
public class PmsProductAttributeCategoryServiceImpl extends ServiceImpl<PmsProductAttributeCategoryDao, PmsProductAttributeCategoryEntity> implements PmsProductAttributeCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductAttributeCategoryEntity> page = this.page(
                new Query<PmsProductAttributeCategoryEntity>().getPage(params),
                new QueryWrapper<PmsProductAttributeCategoryEntity>()
        );

        return new PageUtils(page);
    }

}