package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsRoleDao;
import com.tony.tmall.entity.UmsRoleEntity;
import com.tony.tmall.service.UmsRoleService;


@Service("umsRoleService")
public class UmsRoleServiceImpl extends ServiceImpl<UmsRoleDao, UmsRoleEntity> implements UmsRoleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsRoleEntity> page = this.page(
                new Query<UmsRoleEntity>().getPage(params),
                new QueryWrapper<UmsRoleEntity>()
        );

        return new PageUtils(page);
    }

}