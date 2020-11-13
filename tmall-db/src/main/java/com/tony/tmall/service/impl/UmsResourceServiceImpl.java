package com.tony.tmall.service.impl;

import com.tony.tmall.util.PageUtils;
import com.tony.tmall.util.Query;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.tony.tmall.dao.UmsResourceDao;
import com.tony.tmall.entity.UmsResourceEntity;
import com.tony.tmall.service.UmsResourceService;


@Service("umsResourceService")
public class UmsResourceServiceImpl extends ServiceImpl<UmsResourceDao, UmsResourceEntity> implements UmsResourceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsResourceEntity> page = this.page(
                new Query<UmsResourceEntity>().getPage(params),
                new QueryWrapper<UmsResourceEntity>()
        );

        return new PageUtils(page);
    }

}