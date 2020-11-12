package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.PmsProductCategoryAttributeRelationDao;
import com.tony.tmall.entity.PmsProductCategoryAttributeRelationEntity;
import com.tony.tmall.service.PmsProductCategoryAttributeRelationService;


@Service("pmsProductCategoryAttributeRelationService")
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationDao, PmsProductCategoryAttributeRelationEntity> implements PmsProductCategoryAttributeRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsProductCategoryAttributeRelationEntity> page = this.page(
                new Query<PmsProductCategoryAttributeRelationEntity>().getPage(params),
                new QueryWrapper<PmsProductCategoryAttributeRelationEntity>()
        );

        return new PageUtils(page);
    }

}