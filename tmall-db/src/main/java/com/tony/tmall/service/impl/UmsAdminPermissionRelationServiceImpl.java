package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsAdminPermissionRelationDao;
import com.tony.tmall.entity.UmsAdminPermissionRelationEntity;
import com.tony.tmall.service.UmsAdminPermissionRelationService;


@Service("umsAdminPermissionRelationService")
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationDao, UmsAdminPermissionRelationEntity> implements UmsAdminPermissionRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsAdminPermissionRelationEntity> page = this.page(
                new Query<UmsAdminPermissionRelationEntity>().getPage(params),
                new QueryWrapper<UmsAdminPermissionRelationEntity>()
        );

        return new PageUtils(page);
    }

}