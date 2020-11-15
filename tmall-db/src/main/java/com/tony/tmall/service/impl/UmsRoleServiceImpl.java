package com.tony.tmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.dao.UmsRoleDao;
import com.tony.tmall.entity.*;
import com.tony.tmall.service.UmsRoleMenuRelationService;
import com.tony.tmall.service.UmsRoleResourceRelationService;
import com.tony.tmall.service.UmsRoleService;
import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service("umsRoleService")
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleDao, UmsRoleEntity> implements UmsRoleService {


    @Autowired
    private UmsRoleDao umsRoleDao;


    @Autowired
    private UmsRoleMenuRelationService umsRoleMenuRelationService;


    @Autowired
    private UmsRoleResourceRelationService umsRoleResourceRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleEntity> page = this.page(
                new Query<UmsRoleEntity>().getPage(params),
                new QueryWrapper<UmsRoleEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<UmsMenuEntity> getMenuList(Long id) {
        return umsRoleDao.getMenuList(id);
    }

    @Override
    public List<UmsMenuEntity> listMenu(Long roleId) {
        return umsRoleDao.getMenuListByRoleId(roleId);
    }

    @Override
    public List<UmsResourceEntity> listResource(Long roleId) {
        return umsRoleDao.getResourceListByRoleId(roleId);
    }

    @Override
    @Transactional
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        umsRoleMenuRelationService.remove(new LambdaQueryWrapper<UmsRoleMenuRelationEntity>()
        .eq(UmsRoleMenuRelationEntity::getRoleId,roleId));
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelationEntity relation = new UmsRoleMenuRelationEntity();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            umsRoleMenuRelationService.save(relation);
        }
        return menuIds.size();
    }

    @Override
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        umsRoleResourceRelationService.remove(new LambdaQueryWrapper<UmsRoleResourceRelationEntity>()
                .eq(UmsRoleResourceRelationEntity::getRoleId,roleId));
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelationEntity relation = new UmsRoleResourceRelationEntity();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            umsRoleResourceRelationService.save(relation);
        }
        return resourceIds.size();
    }
}