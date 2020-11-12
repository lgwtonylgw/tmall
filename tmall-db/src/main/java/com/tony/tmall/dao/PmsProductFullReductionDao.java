package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductFullReductionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品满减表(只针对同商品)
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductFullReductionDao extends BaseMapper<PmsProductFullReductionEntity> {
	
}
