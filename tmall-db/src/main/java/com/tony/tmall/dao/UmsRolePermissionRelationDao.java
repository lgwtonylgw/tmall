package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsRolePermissionRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 后台用户角色和权限关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsRolePermissionRelationDao extends BaseMapper<UmsRolePermissionRelationEntity> {
	
}
