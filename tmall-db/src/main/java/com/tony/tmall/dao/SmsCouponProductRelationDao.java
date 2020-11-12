package com.tony.tmall.dao;

import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券和产品的关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface SmsCouponProductRelationDao extends BaseMapper<SmsCouponProductRelationEntity> {
	
}
