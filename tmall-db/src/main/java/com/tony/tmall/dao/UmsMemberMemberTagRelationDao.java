package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsMemberMemberTagRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户和标签关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsMemberMemberTagRelationDao extends BaseMapper<UmsMemberMemberTagRelationEntity> {
	
}
