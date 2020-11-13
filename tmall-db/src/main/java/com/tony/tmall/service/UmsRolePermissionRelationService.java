package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsRolePermissionRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 后台用户角色和权限关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsRolePermissionRelationService extends IService<UmsRolePermissionRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

