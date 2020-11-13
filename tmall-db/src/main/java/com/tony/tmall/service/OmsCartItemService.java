package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.OmsCartItemEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 购物车表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface OmsCartItemService extends IService<OmsCartItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

