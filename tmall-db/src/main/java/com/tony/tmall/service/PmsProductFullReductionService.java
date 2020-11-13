package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductFullReductionEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 产品满减表(只针对同商品)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductFullReductionService extends IService<PmsProductFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

