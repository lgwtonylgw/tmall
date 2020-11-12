package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsAdminLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 后台用户登录日志表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsAdminLoginLogDao extends BaseMapper<UmsAdminLoginLogEntity> {
	
}
