package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsRoleResourceRelationEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 后台角色资源关系表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsRoleResourceRelationService extends IService<UmsRoleResourceRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

