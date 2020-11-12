package com.tony.tmall.dao;

import com.tony.tmall.entity.SmsHomeRecommendProductEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 人气推荐商品表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface SmsHomeRecommendProductDao extends BaseMapper<SmsHomeRecommendProductEntity> {
	
}
