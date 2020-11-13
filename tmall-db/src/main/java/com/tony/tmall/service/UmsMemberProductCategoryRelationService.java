package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsMemberProductCategoryRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 会员与产品分类关系表（用户喜欢的分类）
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsMemberProductCategoryRelationService extends IService<UmsMemberProductCategoryRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

