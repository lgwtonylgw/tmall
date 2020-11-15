package com.tony.tmall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tony.tmall.entity.UmsMenuEntity;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.util.PageUtils;

import java.util.List;
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

    List<UmsMenuEntity> getMenuList(Long id);

    List<UmsMenuEntity> listMenu(Long roleId);

    List<UmsResourceEntity> listResource(Long roleId);

    int allocMenu(Long roleId, List<Long> menuIds);

    int allocResource(Long roleId, List<Long> resourceIds);
}

