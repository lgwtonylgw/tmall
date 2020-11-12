package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.PmsProductCategoryEntity;

import java.util.Map;

/**
 * 产品分类
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductCategoryService extends IService<PmsProductCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

