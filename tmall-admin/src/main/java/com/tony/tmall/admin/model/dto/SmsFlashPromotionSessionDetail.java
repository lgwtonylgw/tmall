package com.tony.tmall.admin.model.dto;

import com.tony.tmall.entity.SmsFlashPromotionSessionEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 包含商品数量的场次信息
 * Created by tony on 2020/11/19.
 */
public class SmsFlashPromotionSessionDetail extends SmsFlashPromotionSessionEntity {
    @Setter
    @Getter
    @ApiModelProperty("商品数量")
    private Long productCount;
}
