package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.OmsOrderReturnApplyEntity;
import com.tony.tmall.model.dto.OmsUpdateStatusParam;
import com.tony.tmall.model.vo.OmsOrderReturnApplyResult;
import com.tony.tmall.util.PageUtils;

import java.util.List;
import java.util.Map;

/**
 * 订单退货申请
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
public interface OmsOrderReturnApplyService extends IService<OmsOrderReturnApplyEntity> {

    PageUtils queryPage(Map<String, Object> params);

    int delete(List<Long> ids);

    OmsOrderReturnApplyResult getItem(Long id);

    int updateStatus(Long id, OmsUpdateStatusParam statusParam);
}

