package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 产品阶梯价格表(只针对同商品)
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductLadderDao extends BaseMapper<PmsProductLadderEntity> {
	
}
