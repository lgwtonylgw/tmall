package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.PmsProductAttributeValueEntity;

import java.util.Map;

/**
 * 存储产品参数信息的表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface PmsProductAttributeValueService extends IService<PmsProductAttributeValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

