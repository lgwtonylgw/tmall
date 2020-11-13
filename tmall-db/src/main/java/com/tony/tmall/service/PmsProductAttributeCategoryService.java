package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 产品属性分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductAttributeCategoryService extends IService<PmsProductAttributeCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

