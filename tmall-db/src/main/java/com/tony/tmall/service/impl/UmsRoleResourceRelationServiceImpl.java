package com.tony.tmall.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tony.tmall.common.utils.PageUtils;
import com.tony.tmall.common.utils.Query;

import com.tony.tmall.dao.UmsRoleResourceRelationDao;
import com.tony.tmall.entity.UmsRoleResourceRelationEntity;
import com.tony.tmall.service.UmsRoleResourceRelationService;


@Service("umsRoleResourceRelationService")
public class UmsRoleResourceRelationServiceImpl extends ServiceImpl<UmsRoleResourceRelationDao, UmsRoleResourceRelationEntity> implements UmsRoleResourceRelationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleResourceRelationEntity> page = this.page(
                new Query<UmsRoleResourceRelationEntity>().getPage(params),
                new QueryWrapper<UmsRoleResourceRelationEntity>()
        );

        return new PageUtils(page);
    }

}