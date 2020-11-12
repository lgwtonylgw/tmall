package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.entity.UmsAdminPermissionRelationEntity;

import java.util.Map;

/**
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限)
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsAdminPermissionRelationService extends IService<UmsAdminPermissionRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

