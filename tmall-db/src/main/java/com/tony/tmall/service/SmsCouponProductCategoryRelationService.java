package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;

import java.util.Map;

/**
 * 优惠券和产品分类关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsCouponProductCategoryRelationService extends IService<SmsCouponProductCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

