package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 人气推荐商品表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface SmsHomeRecommendProductService extends IService<SmsHomeRecommendProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

