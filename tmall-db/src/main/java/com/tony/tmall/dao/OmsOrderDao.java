package com.tony.tmall.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.entity.OmsOrderEntity;
import com.tony.tmall.model.dto.OmsOrderDeliveryParam;
import com.tony.tmall.model.vo.OmsOrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Mapper
public interface OmsOrderDao extends BaseMapper<OmsOrderEntity> {

    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    OmsOrderDetail getDetail(Long id);
}
