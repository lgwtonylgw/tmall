package com.tony.tmall.model.vo;

import com.tony.tmall.entity.PmsProductCategoryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by tony on 2020/5/25.
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategoryEntity {
    @Getter
    @Setter
    @ApiModelProperty("子级分类")
    private List<PmsProductCategoryEntity> children;
}
