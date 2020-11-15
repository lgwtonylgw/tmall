package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsSkuStockEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku的库存
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsSkuStockDao extends BaseMapper<PmsSkuStockEntity> {
    /**
     * 批量插入操作
     */
    int insertList(@Param("list")List<PmsSkuStockEntity> skuStockList);

    /**
     * 批量插入或替换操作
     */
    int replaceList(@Param("list")List<PmsSkuStockEntity> skuStockList);
}
