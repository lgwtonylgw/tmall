package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 优惠券和产品的关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsCouponProductRelationService extends IService<SmsCouponProductRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

