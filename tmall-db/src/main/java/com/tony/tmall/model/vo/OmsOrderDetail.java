package com.tony.tmall.model.vo;

import com.tony.tmall.entity.OmsOrderEntity;
import com.tony.tmall.entity.OmsOrderItemEntity;
import com.tony.tmall.entity.OmsOrderOperateHistoryEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单详情信息
 * Created by tony on 2020/10/11.
 */
public class OmsOrderDetail extends OmsOrderEntity {
    @Getter
    @Setter
    @ApiModelProperty("订单商品列表")
    private List<OmsOrderItemEntity> orderItemList;
    @Getter
    @Setter
    @ApiModelProperty("订单操作记录列表")
    private List<OmsOrderOperateHistoryEntity> historyList;
}
