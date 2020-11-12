package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsMemberProductCategoryRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员与产品分类关系表（用户喜欢的分类）
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsMemberProductCategoryRelationDao extends BaseMapper<UmsMemberProductCategoryRelationEntity> {
	
}
