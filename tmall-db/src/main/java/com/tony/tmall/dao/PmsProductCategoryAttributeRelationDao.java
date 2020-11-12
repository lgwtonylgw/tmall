package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductCategoryAttributeRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类）
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductCategoryAttributeRelationDao extends BaseMapper<PmsProductCategoryAttributeRelationEntity> {
	
}
