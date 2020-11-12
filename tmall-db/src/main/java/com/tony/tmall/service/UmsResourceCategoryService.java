package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsResourceCategoryEntity;

import java.util.Map;

/**
 * 资源分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsResourceCategoryService extends IService<UmsResourceCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

