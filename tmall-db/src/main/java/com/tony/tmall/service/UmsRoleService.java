package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.util.PageUtils;

import java.util.Map;

/**
 * 后台用户角色表
 *
 * @author tony
 * @email lgwtonylgw@gmail.com
 * @date 2020-11-12 09:18:06
 */
public interface UmsRoleService extends IService<UmsRoleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

