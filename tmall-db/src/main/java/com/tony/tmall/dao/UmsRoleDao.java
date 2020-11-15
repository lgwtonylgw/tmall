package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.entity.UmsRoleEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 后台用户角色表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsRoleDao extends BaseMapper<UmsRoleEntity> {

    List<UmsMenuEntity> getMenuList(Long adminId);

    List<UmsMenuEntity> getMenuListByRoleId(Long roleId);

    List<UmsResourceEntity> getResourceListByRoleId(Long roleId);
}
