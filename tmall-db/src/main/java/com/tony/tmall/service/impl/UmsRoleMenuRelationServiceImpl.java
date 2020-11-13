package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsRoleMenuRelationDao;
import com.tony.tmall.entity.UmsRoleMenuRelationEntity;
import com.tony.tmall.service.UmsRoleMenuRelationService;


@Service("umsRoleMenuRelationService")
public class UmsRoleMenuRelationServiceImpl extends ServiceImpl<UmsRoleMenuRelationDao, UmsRoleMenuRelationEntity> implements UmsRoleMenuRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleMenuRelationEntity> page = this.page(
                new Query<UmsRoleMenuRelationEntity>().getPage(params),
                new QueryWrapper<UmsRoleMenuRelationEntity>()
        );

        return new PageUtils(page);
    }

}