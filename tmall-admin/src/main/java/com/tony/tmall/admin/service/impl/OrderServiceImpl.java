package com.tony.tmall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tony.tmall.admin.model.dto.OmsMoneyInfoParam;
import com.tony.tmall.admin.model.dto.OmsReceiverInfoParam;
import com.tony.tmall.model.vo.OmsOrderDetail;
import com.tony.tmall.admin.service.OrderService;
import com.tony.tmall.dao.OmsOrderDao;
import com.tony.tmall.entity.OmsOrderEntity;
import com.tony.tmall.entity.OmsOrderOperateHistoryEntity;
import com.tony.tmall.model.dto.OmsOrderDeliveryParam;
import com.tony.tmall.service.OmsOrderOperateHistoryService;
import com.tony.tmall.service.OmsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: tony
 * Date: 2020/11/14 13:39
 * Description:
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OmsOrderService omsOrderService;

    @Autowired
    private OmsOrderOperateHistoryService omsOrderOperateHistoryService;

    @Autowired
    private OmsOrderDao omsOrderDao;

    @Override
    @Transactional
    public int delivery(List<OmsOrderDeliveryParam> deliveryParamList) {
        //批量发货
        int count = omsOrderDao.delivery(deliveryParamList);
        //添加操作记录
        List<OmsOrderOperateHistoryEntity> operateHistoryList = deliveryParamList.stream()
                .map(omsOrderDeliveryParam -> {
                    OmsOrderOperateHistoryEntity history = new OmsOrderOperateHistoryEntity();
                    history.setOrderId(omsOrderDeliveryParam.getOrderId());
                    history.setCreateTime(new Date());
                    history.setOperateMan("后台管理员");
                    history.setOrderStatus(2);
                    history.setNote("完成发货");
                    return history;
                }).collect(Collectors.toList());
        omsOrderOperateHistoryService.saveBatch(operateHistoryList);
        return count;
    }

    @Override
    @Transactional
    public int close(List<Long> ids, String note) {
        OmsOrderEntity record = new OmsOrderEntity();
        record.setStatus(4);
        int count = omsOrderDao.update(record, new LambdaQueryWrapper<OmsOrderEntity>().eq(OmsOrderEntity::getDeleteStatus, 0));

        List<OmsOrderOperateHistoryEntity> historyList = ids.stream().map(orderId -> {
            OmsOrderOperateHistoryEntity history = new OmsOrderOperateHistoryEntity();
            history.setOrderId(orderId);
            history.setCreateTime(new Date());
            history.setOperateMan("后台管理员");
            history.setOrderStatus(4);
            history.setNote("订单关闭:"+note);
            return history;
        }).collect(Collectors.toList());
        omsOrderOperateHistoryService.saveBatch(historyList);
        return count;
    }

    @Override
    public int delete(List<Long> ids) {
        OmsOrderEntity record = new OmsOrderEntity();
        record.setDeleteStatus(1);
        return omsOrderDao.update(record,new LambdaQueryWrapper<OmsOrderEntity>().eq(OmsOrderEntity::getDeleteStatus,0));
    }

    @Override
    public OmsOrderDetail detail(Long id) {
        return omsOrderDao.getDetail(id);
    }

    @Override
    @Transactional
    public int updateReceiverInfo(OmsReceiverInfoParam receiverInfoParam) {
        OmsOrderEntity order = new OmsOrderEntity();
        order.setId(receiverInfoParam.getOrderId());
        order.setReceiverName(receiverInfoParam.getReceiverName());
        order.setReceiverPhone(receiverInfoParam.getReceiverPhone());
        order.setReceiverPostCode(receiverInfoParam.getReceiverPostCode());
        order.setReceiverDetailAddress(receiverInfoParam.getReceiverDetailAddress());
        order.setReceiverProvince(receiverInfoParam.getReceiverProvince());
        order.setReceiverCity(receiverInfoParam.getReceiverCity());
        order.setReceiverRegion(receiverInfoParam.getReceiverRegion());
        order.setModifyTime(new Date());
        int count = omsOrderDao.updateById(order);
        //插入操作记录
        OmsOrderOperateHistoryEntity history = new OmsOrderOperateHistoryEntity();
        history.setOrderId(receiverInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(receiverInfoParam.getStatus());
        history.setNote("修改收货人信息");
        omsOrderOperateHistoryService.save(history);
        return count;
    }

    @Override
    @Transactional
    public int updateMoneyInfo(OmsMoneyInfoParam moneyInfoParam) {
        OmsOrderEntity order = new OmsOrderEntity();
        order.setId(moneyInfoParam.getOrderId());
        order.setFreightAmount(moneyInfoParam.getFreightAmount());
        order.setDiscountAmount(moneyInfoParam.getDiscountAmount());
        order.setModifyTime(new Date());
        int count = omsOrderDao.updateById(order);
        //插入操作记录
        OmsOrderOperateHistoryEntity history = new OmsOrderOperateHistoryEntity();
        history.setOrderId(moneyInfoParam.getOrderId());
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(moneyInfoParam.getStatus());
        history.setNote("修改费用信息");
        omsOrderOperateHistoryService.save(history);
        return count;
    }

    @Override
    @Transactional
    public int updateNote(Long id, String note, Integer status) {
        OmsOrderEntity order = new OmsOrderEntity();
        order.setId(id);
        order.setNote(note);
        order.setModifyTime(new Date());
        int count = omsOrderDao.updateById(order);
        OmsOrderOperateHistoryEntity history = new OmsOrderOperateHistoryEntity();
        history.setOrderId(id);
        history.setCreateTime(new Date());
        history.setOperateMan("后台管理员");
        history.setOrderStatus(status);
        history.setNote("修改备注信息："+note);
        omsOrderOperateHistoryService.save(history);
        return count;
    }
}
