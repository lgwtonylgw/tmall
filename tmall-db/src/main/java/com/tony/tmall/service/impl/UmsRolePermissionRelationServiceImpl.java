package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsRolePermissionRelationDao;
import com.tony.tmall.entity.UmsRolePermissionRelationEntity;
import com.tony.tmall.service.UmsRolePermissionRelationService;


@Service("umsRolePermissionRelationService")
public class UmsRolePermissionRelationServiceImpl extends ServiceImpl<UmsRolePermissionRelationDao, UmsRolePermissionRelationEntity> implements UmsRolePermissionRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRolePermissionRelationEntity> page = this.page(
                new Query<UmsRolePermissionRelationEntity>().getPage(params),
                new QueryWrapper<UmsRolePermissionRelationEntity>()
        );

        return new PageUtils(page);
    }

}