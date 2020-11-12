package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.CmsSubjectCategoryEntity;

import java.util.Map;

/**
 * 专题分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsSubjectCategoryService extends IService<CmsSubjectCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

