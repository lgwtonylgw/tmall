package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsTopicCategoryEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 话题分类表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsTopicCategoryService extends IService<CmsTopicCategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

