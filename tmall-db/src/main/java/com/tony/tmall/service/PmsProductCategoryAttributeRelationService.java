package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.PmsProductCategoryAttributeRelationEntity;

import java.util.Map;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductCategoryAttributeRelationService extends IService<PmsProductCategoryAttributeRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

