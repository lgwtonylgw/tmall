package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsPermissionDao;
import com.tony.tmall.entity.UmsPermissionEntity;
import com.tony.tmall.service.UmsPermissionService;


@Service("umsPermissionService")
public class UmsPermissionServiceImpl extends ServiceImpl<UmsPermissionDao, UmsPermissionEntity> implements UmsPermissionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsPermissionEntity> page = this.page(
                new Query<UmsPermissionEntity>().getPage(params),
                new QueryWrapper<UmsPermissionEntity>()
        );

        return new PageUtils(page);
    }

}