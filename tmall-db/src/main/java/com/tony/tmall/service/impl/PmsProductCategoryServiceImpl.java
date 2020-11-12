package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductCategoryDao;
import com.tony.tmall.entity.PmsProductCategoryEntity;
import com.tony.tmall.service.PmsProductCategoryService;


@Service("pmsProductCategoryService")
public class PmsProductCategoryServiceImpl extends ServiceImpl<PmsProductCategoryDao, PmsProductCategoryEntity> implements PmsProductCategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductCategoryEntity> page = this.page(
                new Query<PmsProductCategoryEntity>().getPage(params),
                new QueryWrapper<PmsProductCategoryEntity>()
        );

        return new PageUtils(page);
    }

}