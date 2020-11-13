package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsSkuStockEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * sku的库存
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsSkuStockService extends IService<PmsSkuStockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

