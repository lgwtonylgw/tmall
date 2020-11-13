package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsRoleMenuRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 后台角色菜单关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsRoleMenuRelationService extends IService<UmsRoleMenuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

