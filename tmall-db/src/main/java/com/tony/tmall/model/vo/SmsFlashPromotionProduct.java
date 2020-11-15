package com.tony.tmall.model.vo;

import com.tony.tmall.entity.PmsProductEntity;
import com.tony.tmall.entity.SmsFlashPromotionProductRelationEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 限时购及商品信息封装
 * Created by tony on 2020/11/16.
 */
public class SmsFlashPromotionProduct extends SmsFlashPromotionProductRelationEntity {
    @Getter
    @Setter
    @ApiModelProperty("关联商品")
    private PmsProductEntity product;
}
