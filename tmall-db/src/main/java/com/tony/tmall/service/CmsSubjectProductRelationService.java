package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsSubjectProductRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 专题商品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsSubjectProductRelationService extends IService<CmsSubjectProductRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

