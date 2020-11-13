package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.CmsPrefrenceAreaProductRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 优选专区和产品关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface CmsPrefrenceAreaProductRelationService extends IService<CmsPrefrenceAreaProductRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

