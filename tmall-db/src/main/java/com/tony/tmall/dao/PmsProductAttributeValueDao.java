package com.tony.tmall.dao;

import com.tony.tmall.entity.PmsProductAttributeValueEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 存储产品参数信息的表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface PmsProductAttributeValueDao extends BaseMapper<PmsProductAttributeValueEntity> {
	
}
