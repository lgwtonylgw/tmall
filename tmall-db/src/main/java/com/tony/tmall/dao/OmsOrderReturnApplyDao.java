package com.tony.tmall.dao;

import com.tony.tmall.entity.OmsOrderReturnApplyEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.vo.OmsOrderReturnApplyResult;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单退货申请
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:07
 */
@Mapper
public interface OmsOrderReturnApplyDao extends BaseMapper<OmsOrderReturnApplyEntity> {

    OmsOrderReturnApplyResult getDetail(Long id);
}
