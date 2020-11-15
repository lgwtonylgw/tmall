package com.tony.tmall.dao;

import com.tony.tmall.entity.SmsCouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.model.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface SmsCouponDao extends BaseMapper<SmsCouponEntity> {

    SmsCouponParam getItem(Long id);
}
