package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import com.tony.tmall.model.dto.PmsProductAttributeParam;
import com.tony.tmall.model.vo.ProductAttrInfo;
import com.tony.tmall.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 商品属性参数表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface PmsProductAttributeService extends IService<PmsProductAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int create(PmsProductAttributeParam productAttributeParam);

    int delete(List<Long> ids);

    List<ProductAttrInfo> getProductAttrInfo(Long productCategoryId);
}

