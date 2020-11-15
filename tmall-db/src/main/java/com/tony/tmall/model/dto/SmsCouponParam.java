package com.tony.tmall.model.dto;

import com.tony.tmall.entity.SmsCouponEntity;
import com.tony.tmall.entity.SmsCouponProductCategoryRelationEntity;
import com.tony.tmall.entity.SmsCouponProductRelationEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 优惠券信息封装，包括绑定商品和绑定分类
 * Created by tony on 2020/8/28.
 */
public class SmsCouponParam extends SmsCouponEntity {
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品")
    private List<SmsCouponProductRelationEntity> productRelationList;
    @Getter
    @Setter
    @ApiModelProperty("优惠券绑定的商品分类")
    private List<SmsCouponProductCategoryRelationEntity> productCategoryRelationList;
}
