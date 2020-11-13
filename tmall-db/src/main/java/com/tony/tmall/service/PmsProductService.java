package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 商品信息
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface PmsProductService extends IService<PmsProductEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

