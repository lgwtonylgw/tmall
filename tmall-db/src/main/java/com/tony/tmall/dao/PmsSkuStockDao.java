package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsSkuStockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * sku的库存
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsSkuStockDao extends BaseMapper<PmsSkuStockEntity> {
	
}
