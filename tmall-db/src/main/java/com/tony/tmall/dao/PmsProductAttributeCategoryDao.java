package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.PmsProductAttributeCategoryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产品属性分类表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductAttributeCategoryDao extends BaseMapper<PmsProductAttributeCategoryEntity> {

    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
