package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductCategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.PmsProductCategoryWithChildrenItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 产品分类
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductCategoryDao extends BaseMapper<PmsProductCategoryEntity> {

    List<PmsProductCategoryWithChildrenItem> listWithChildren();
}
