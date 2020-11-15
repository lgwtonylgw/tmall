package com.tony.tmall.admin.service;

import com.tony.tmall.admin.model.dto.OmsMoneyInfoParam;
import com.tony.tmall.admin.model.dto.OmsReceiverInfoParam;
import com.tony.tmall.model.vo.OmsOrderDetail;
import com.tony.tmall.model.dto.OmsOrderDeliveryParam;

import java.util.List;

/**
 * Author: tony
 * Date: 2020/11/14 13:38
 * Description:
 */
public interface OrderService {
    int delivery(List<OmsOrderDeliveryParam> deliveryParamList);

    int close(List<Long> ids, String note);

    int delete(List<Long> ids);

    OmsOrderDetail detail(Long id);

    int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam);

    int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam);

    int updateNote(Long id, String note, Integer status);
}
