package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsPermissionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 后台用户权限表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsPermissionDao extends BaseMapper<UmsPermissionEntity> {
	
}
