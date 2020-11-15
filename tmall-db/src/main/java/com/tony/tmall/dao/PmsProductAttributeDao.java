package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.ProductAttrInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品属性参数表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Mapper
public interface PmsProductAttributeDao extends BaseMapper<PmsProductAttributeEntity> {

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}
