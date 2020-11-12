package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.UmsAdminRoleRelationDao;
import com.tony.tmall.entity.UmsAdminRoleRelationEntity;
import com.tony.tmall.service.UmsAdminRoleRelationService;


@Service("umsAdminRoleRelationService")
public class UmsAdminRoleRelationServiceImpl extends ServiceImpl<UmsAdminRoleRelationDao, UmsAdminRoleRelationEntity> implements UmsAdminRoleRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsAdminRoleRelationEntity> page = this.page(
                new Query<UmsAdminRoleRelationEntity>().getPage(params),
                new QueryWrapper<UmsAdminRoleRelationEntity>()
        );

        return new PageUtils(page);
    }

}