package com.tony.tmall.dao;

import com.tony.tmall.entity.UmsAdminRoleRelationEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.entity.UmsRoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 后台用户和角色关系表
 * 
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
@Mapper
public interface UmsAdminRoleRelationDao extends BaseMapper<UmsAdminRoleRelationEntity> {

    List<Long> getAdminIdList(Long resourceId);

    List<UmsResourceEntity> getResourceList(Long adminId);

    List<UmsRoleEntity> getRoleList(Long adminId);
}
