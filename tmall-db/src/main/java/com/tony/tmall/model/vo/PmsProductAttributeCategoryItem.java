package com.tony.tmall.model.vo;

import com.tony.tmall.entity.PmsProductAttributeCategoryEntity;
import com.tony.tmall.entity.PmsProductAttributeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 包含有分类下属性的dto
 * Created by tony on 2020/5/24.
 */
public class PmsProductAttributeCategoryItem extends PmsProductAttributeCategoryEntity {
    @Getter
    @Setter
    @ApiModelProperty(value = "商品属性列表")
    private List<PmsProductAttributeEntity> productAttributeList;
}
