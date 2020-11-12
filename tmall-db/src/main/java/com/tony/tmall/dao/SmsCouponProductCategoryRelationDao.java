package com.tony.tmall.dao;

import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券和产品分类关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface SmsCouponProductCategoryRelationDao extends BaseMapper<SmsCouponProductCategoryRelationEntity> {
	
}
